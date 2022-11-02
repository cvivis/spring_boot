package com.springboot.hello.member;


import com.springboot.hello.member.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/put-api")
public class PutController {
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

    @PutMapping("/dto")
    public ResponseEntity<MemberDto> putMemberDto(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
