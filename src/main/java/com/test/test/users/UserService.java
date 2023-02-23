package com.test.test.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    private Long generateId(){
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
    public User create(String name, Integer age, String password) {
        User newUser = new User();
            newUser.setId(generateId());
            newUser.setName(name);
            newUser.setAge(age);
            newUser.setPassword(password);

        userRepository.save(newUser);
        return newUser;
    }
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getList() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, String newName, Integer newAge, String newPassword) {
        User updUser = new User();
            updUser.setId(id);
            updUser.setName(newName);
            updUser.setAge(newAge);
            updUser.setPassword(newPassword);
        userRepository.save(updUser);
        return updUser;
    }
}
