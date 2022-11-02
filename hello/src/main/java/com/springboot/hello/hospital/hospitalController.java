package com.springboot.hello.hospital;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import com.springboot.hello.domain.User;
import com.springboot.hello.hospital.model.GetHospitalRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@Slf4j
@RequestMapping("/api")
public class hospitalController {

    private HospitalDao hospitalDao;

    public hospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping(value = "/{hospitalId}")
    public GetHospitalRes getHospitalId(@PathVariable int hospitalId) throws SQLException {
        Hospital hospital = hospitalDao.findById(hospitalId);
        GetHospitalRes hospitalRes = new GetHospitalRes(
                hospital.getHospitalName(),
                hospital.getFullAddress(),
                hospital.getRoadNameAddress(),
                hospital.getHealthcareProviderCount(),
                hospital.getPatientRoomCount(),
                hospital.getTotalAreaSize(),
                hospital.getBusinessStatus()
        );
        return hospitalRes;
    }

}
