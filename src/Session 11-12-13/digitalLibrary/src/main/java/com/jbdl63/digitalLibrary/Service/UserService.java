package com.jbdl63.digitalLibrary.Service;

import com.jbdl63.digitalLibrary.Model.User;
import com.jbdl63.digitalLibrary.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllBooksIssuedToUser(String userName) {
        User user = userRepository.findByUserName(userName);
        return userRepository.findById(user.getUserId()).stream().toList();
    }
}
