package com.springboot.hello.memberController;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> getUserId(@PathVariable String userId) throws SQLException {
        User user = userDao.selectId(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @PostMapping("")
    public ResponseEntity<User> postUser(@RequestBody User user) throws SQLException {
        userDao.insert(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

    @GetMapping("/user")
    public User addAndGet() throws SQLException {
        userDao.insert(new User("1", "Suin", "1026"));
        return userDao.selectId("1");
    }

    //    @DeleteMapping("/all")
//    public int deleteUserAll() throws SQLException {
//        int deleteCount = userDao.deleteAll();
//        return deleteCount;
//    }
    @DeleteMapping("/all")
    public ResponseEntity<Integer> deleteAll() throws SQLException {
        return ResponseEntity
                .ok()
                .body(userDao.deleteAll());
    }

}
