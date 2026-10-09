package com.example.demo.Usercontroller;

import com.example.demo.entity.User;
import com.example.demo.Userrepository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private Userrepository userRepository;

    @GetMapping
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id") long userId) {
        return this.userRepository.findById(userId).orElseThrow();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") long userId) {
        User ex = this.userRepository.findById(userId).orElseThrow();
        ex.setFirstname(user.getFirstname());
        ex.setLasttname(user.getLasttname());
        return this.userRepository.save(ex);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {
        User ex = this.userRepository.findById(userId).orElseThrow();
        this.userRepository.delete(ex);
        return ResponseEntity.ok().build();
    }
}
