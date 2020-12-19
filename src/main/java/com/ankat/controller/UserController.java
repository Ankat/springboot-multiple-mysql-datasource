package com.ankat.controller;

import com.ankat.model.db1.User;
import com.ankat.repository.db1.UserRepository;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Log4j2
@RestController(value = "userController")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/getUsers")
    public String getUsers() {
        List<User> userList = userRepository.findAll();
        log.info(userList);
        return Optional.ofNullable(userList).map(ul -> ul.isEmpty() ? "No User Found" : ul.toString()).orElse("No User Found");
    }

    @GetMapping(value = "/getUserById/{usrId}")
    public Object getUserById(@PathVariable Long usrId) {
        log.info(usrId);
        return Optional.ofNullable(usrId).isPresent()? userRepository.findById(usrId).map(u -> u.toString()).orElse("No User Found"): Optional.empty();
    }

    @GetMapping(value = "/getUserById")
    public Object getUserById(@RequestParam Optional<Long> usrId) {
        return usrId.isPresent()?  userRepository.findById(usrId.get()).map(u -> u.toString()).orElse("No User Found")  :"Invalid Arguments";
    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody Optional<User> user) {
        return Optional.ofNullable(userRepository.save(user.get())).map(u -> u.toString()).orElse("No User Found");
    }

}
