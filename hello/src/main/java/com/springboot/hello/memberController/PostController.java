package com.springboot.hello.memberController;


import com.springboot.hello.memberController.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/post-api")
public class PostController {


    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    @PostMapping("/data")
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(
                (map) -> {
                    sb.append(map.getKey()+" : "+map.getValue()+"\n");
                }
        );
        return sb.toString();
    }
    //{
    //  "name":"cvivis",
    //  "email":"cvivis@gmail.com",
    //  "organization":"naver"
    //}
    @PostMapping("/dto")
    public String postMemberDto(@RequestBody MemberDto memberDto){

        return memberDto.toString();
    }
}
