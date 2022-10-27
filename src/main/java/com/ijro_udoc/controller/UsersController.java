package com.ijro_udoc.controller;

import com.ijro_udoc.model.Users;
import com.ijro_udoc.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/users-post")
    public ResponseEntity<?> usersPost(@RequestBody Users users) {
        return ResponseEntity.ok(usersService.save(users));
    }

    @PutMapping("/users-put")
    public ResponseEntity<?> usersPut(@RequestBody Users users) {
        Users users1 = usersService.findById(users.getId());
        users.setCreated_at(users1.getCreated_at());
        return ResponseEntity.ok(usersService.save(users));
    }

    @GetMapping("/users")
    public ResponseEntity<?> usersGet() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> usersGetOne(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }

    @DeleteMapping("/users-del/{id}")
    public ResponseEntity<?> usersDelOne(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
