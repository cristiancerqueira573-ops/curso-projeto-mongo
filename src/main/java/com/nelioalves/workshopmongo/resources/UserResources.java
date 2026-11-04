package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@example.com");
        User Alex = new User("2", "Alex Green", "alex@example.com");
        List<User> list = Arrays.asList(maria, Alex);
        return ResponseEntity.ok().body(list);
    }













}

