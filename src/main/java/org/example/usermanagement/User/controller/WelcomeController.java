package org.example.usermanagement.User.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
        public ResponseEntity<String> welcome() {
        String welcome = "Hello World!";
    return ResponseEntity.ok(welcome);
    }
}

