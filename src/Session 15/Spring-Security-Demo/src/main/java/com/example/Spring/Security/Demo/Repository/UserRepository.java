package com.example.Spring.Security.Demo.Repository;

import com.example.Spring.Security.Demo.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    UserData findByUsername(String username);
}
