package com.springboot.hello.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Hospital {
    private int id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;

    public String businessStatusStr(Hospital hospital){
        String BusinessStatusStr = "";
        if(hospital.getBusinessStatus()==1)BusinessStatusStr = "정상";
        else if(hospital.getBusinessStatus()==2) BusinessStatusStr = "휴업";
        else if(hospital.getBusinessStatus()==3) BusinessStatusStr = "폐업";
        return BusinessStatusStr;
    }

}
