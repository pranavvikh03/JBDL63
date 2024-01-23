package com.jbdl63.digitalLibrary.Service;

import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.dto.RangeDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String KEY = "AUTHOR::";

    // 1. String
    // 2. List
    // 3. Set
    // 4. HashMap
    public void addNewData(Author author) {
        redisTemplate.opsForValue().setIfAbsent(KEY+author.getAuthorId(), author, Duration.ofSeconds(30));
    }

    public Author getAuthorDetailsUsingId(Integer id) {
        return (Author) redisTemplate.opsForValue().get(KEY+id);
    }

    public Author getAndDeleteById(Integer id) {
        return (Author) redisTemplate.opsForValue().getAndDelete(KEY+id);
    }

    public void addNewDataToList(Author author) {
        redisTemplate.opsForList().leftPush(KEY+"_List", author);
    }

    public RangeDataDto fetchAuthorsUsingRange(int start, int end) {
        List<Author> range = redisTemplate.opsForList().range(KEY + "_List", start, end);
        return RangeDataDto.builder().dataSize(range.size()).data(range).build();
    }

    public void addNewDataToSet(Author author) {
        Random random = new Random();
        author.setAuthorId(random.nextInt(1000));
        redisTemplate.opsForSet().add(KEY + "_Set", author);
    }

    public List<Author> getRandomNumbers(int count) {
        return redisTemplate.opsForSet().randomMembers(KEY + "_Set", count);
    }

    public void addNewDataToHash(Author author) {
        redisTemplate.opsForHash().put(KEY + "_DataInHash", author.getAuthorId(), author);
        Map<Integer, Author> entries = redisTemplate.opsForHash().entries(KEY + "_DataInHash");
        Set<Map.Entry<Integer, Author>> set = entries.entrySet();
        for (Map.Entry<Integer, Author> o : set) {
            System.out.println(o.getKey()+"\t"+o.getValue());
        }
    }
}
