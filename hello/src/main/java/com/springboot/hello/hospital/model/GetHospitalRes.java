package com.springboot.hello.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class GetHospitalRes {
    private String hospitalName; //병원이름
    private String fullAddress; // 주소
    private String roadNameAddress; //도로명주소
    private int healthcareProviderCount; //의료진 수
    private int patientRoomCount; //병상 수
    private float totalAreaSize; // 면적
    private String businessStatusStr; //3:폐업, 1:영업
}
