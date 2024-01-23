package com.jbdl63.digitalLibrary.Controller;

import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.Service.RedisService;
import com.jbdl63.digitalLibrary.dto.RangeDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/redis", produces = MediaType.APPLICATION_JSON_VALUE)
public class RedisController {

    @Autowired
    private RedisService redisService;


    //String
    @PostMapping
    public void addNewAuthor(@RequestBody Author author) {
        redisService.addNewData(author);
    }

    @GetMapping("/{id}")
    public Author getAuthorDataUsingId(@PathVariable("id") Integer id) {
        return redisService.getAuthorDetailsUsingId(id);
    }

    @GetMapping("/delete/{id}")
    public Author getAndDeleteById(@PathVariable("id") Integer id) {
        return redisService.getAndDeleteById(id);
    }

    //List
    @PostMapping("/list")
    public void addNewAuthorInList(@RequestBody Author author) {
        redisService.addNewDataToList(author);
    }

    @GetMapping("/list/{start}/{end}")
    public RangeDataDto getListDataUsingRange(@PathVariable("start") Integer start, @PathVariable("end") Integer end) {
        return redisService.fetchAuthorsUsingRange(start, end);
    }

    //Set
    @PostMapping("/set")
    public void addNewAuthorInSet(@RequestBody Author author) {
        redisService.addNewDataToSet(author);
    }

    @GetMapping("/set/{count}")
    public List<Author> returnRandomAuthorsDataFromSet(@PathVariable("count") int count) {
        return redisService.getRandomNumbers(count);
    }

    //Hash
    @PostMapping("/hash")
    public void addNewAuthorInHash(@RequestBody Author author) {
        redisService.addNewDataToHash(author);
    }
}
