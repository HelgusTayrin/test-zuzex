package com.test.test.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/create")
    public @ResponseBody User createNewUser(@RequestParam String name, @RequestParam Integer age, @RequestParam String password) {
        return userService.create(name, age, password);
    }

    @GetMapping(path="/getList", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getUsersList() {
        return userService.getList();
    }

    @GetMapping(path="/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Optional<User> getUserById(@RequestParam Long id) {
        return userService.getById(id);
    }

    @DeleteMapping(path="/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteUser(@RequestParam Long id) {
        userService.delete(id);
        return "User with id: " + id + "was be deleted";
    }

    @PostMapping(path="/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User updateUser(@RequestParam Long id, @RequestParam String newName, @RequestParam Integer newAge, @RequestParam String newPassword) {
        return userService.update(id, newName, newAge, newPassword);
    }
}
