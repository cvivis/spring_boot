package com.springboot.hello.controller;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/get/{userId}")
    public String getUserId(@PathVariable String userId) throws SQLException {
        User user = userDao.selectId(userId);
        return user.getId();
    }

    @PostMapping("/post")
    public ResponseEntity<User> postUser(@RequestBody User user) throws SQLException {
        userDao.insert(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @DeleteMapping("/delete")
    public int deleteUserAll() throws SQLException {
        int deleteCount = userDao.deleteAll();
        return deleteCount;
    }

}
