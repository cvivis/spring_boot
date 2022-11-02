package com.springboot.hello.member;

import com.springboot.hello.dao.UserDao;
import com.springboot.hello.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@Slf4j
@RequestMapping("/api/get-api")
public class GetController {

//    UserDao userdao = new UserDao();

    private final UserDao userDao;
    public GetController(UserDao userDao) {
        this.userDao = userDao;
    }

//    @GetMapping("/variable1/{variable}")
//    public String getVariable1(@PathVariable String variable) {
//        return variable;
//    }
//
//    @GetMapping("/variable2/{variable}")
//    public String getVariable2(@PathVariable String variable) {
//        return variable;
//    }
//
//    @GetMapping("/request1")
//    public String getVariable3(@RequestParam String name,
//                               @RequestParam String email,
//                               @RequestParam String organization) {
//        return String.format("%s %s %s", name, email, organization);
//    }
//
//    @GetMapping("/request2")
//    public String getVariable4(@RequestParam Map<String, String> param) {
//        param.entrySet().forEach(
//                (map) -> {
//                    System.out.printf("key:%s value:%s\n", map.getKey(), map.getValue());
//                }
//        );
//        return "request2 호출완료";
//    }
//
//    @GetMapping("/request3")
//    public String getRequestParam(MemberDto memberDto) {
////        log.info("getVariable3으로 요청이 들어왔습니다. variable:{}", variable);
//        return memberDto.toString();
//
//    }
//
//    @GetMapping(value = "/variable1/{variable}")
//    public String getVariable(@PathVariable String variable) {
//        log.info("getVariable1으로 요청이 들어왔습니다. variable:{}", variable);
//        return variable;
//    }

    @GetMapping(value = "/userdao/{userId}")
    public String getUserId(@PathVariable String userId) throws SQLException {
        User user = userDao.selectId(userId);
        return user.getId();
    }

}