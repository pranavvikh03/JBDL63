package com.example.Spring.Security.Demo.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class SecurityController {

    @GetMapping("/allowedToAll")
    public String getString() {
        return "Allowed To All";
    }

    @GetMapping("/allowedToAdmin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdminString() {
        return "Allowed to Admin Only";
    }

    @GetMapping("/allowedToUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getUserString() {
        return "Allowed To UserData Only";
    }
}
