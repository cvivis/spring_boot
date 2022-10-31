package com.springboot.hello.parser;

import com.springboot.hello.domain.Hospital;

public class HospitalParser implements Parser<Hospital>{

    @Override
    public Hospital parse(String str) {
        return new Hospital();
    }
}
