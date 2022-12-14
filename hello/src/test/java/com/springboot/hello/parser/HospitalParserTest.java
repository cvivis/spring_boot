package com.springboot.hello.parser;

import com.springboot.hello.dao.HospitalDao;
import com.springboot.hello.domain.Hospital;
import com.springboot.hello.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@SpringBootTest
class HospitalParserTest {


//    String str = "\"1\",\"의원\",\"01_01_02_P\",\"3620000\",\"PHMA119993620020041100004\",\"19990612\",\"\",\"01\",\"영업/정상\",\"13\",\"영업중\",\"\",\"\",\"\",\"\",\"062-515-2875\""+
//            ",\"\",\"500881\",\"광주광역시 북구 풍향동 565번지 4호 3층\",\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",\"61205\",\"효치과의원\",\"20211115113642\",\"U\",\"2021-11-17 02:40:00.0\",\"치과의원\",\"192630.735112\",\"185314.617632\",\"치과의원\",\"1\",\"0\",\"0\",\"52.29\",\"401\",\"치과\",\"\",\"\",\"\",\"0\",\"0\",\"\",\"\",\"0\",\"\"";
// 내꺼 CSV는 "" 삽입이 이루어 지지 않기 때문에 가공을 다시진행하였다.
    String str = "1,의원,01_01_02_P,3620000,PHMA119993620020041100004,19990612,,1,영업/정상,13,영업중,,,,,062-515-2875,,500881,광주광역시 북구 풍향동 565번지 4호 3층,\"광주광역시 북구 동문대로 24, 3층 (풍향동)\",61205,효치과의원,2.02111E+13,U,2021.11.17 2:40,치과의원,192630.7351,185314.6176,치과의원,1,0,0,52.29,401,치과,,,,0,0,,,0,";

    @Autowired
    ReadLineContext<Hospital> hospitalReadLineContext;

    @Autowired
    HospitalDao hospitalDao;

    @Autowired
    HospitalService hospitalService;


//    @Test
//    @DisplayName("add, get테스트")
//    void addAndGet(){
//        hospitalDao.deleteAll();
//        assertEquals(0,hospitalDao.getCount());
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(str);
//        hospitalDao.add(hospital);
//        assertEquals(1,hospitalDao.getCount());
//        Hospital selectHospital = hospitalDao.findById(hospital.getId());
//        assertEquals(hospital.getId(),selectHospital.getId());
//        assertEquals(hospital.getOpenServiceName(),selectHospital.getOpenServiceName());
//        assertEquals(hospital.getOpenLocalGovernmentCode(),selectHospital.getOpenLocalGovernmentCode());
//        assertEquals(hospital.getManagementNumber(),selectHospital.getManagementNumber());
//        assertEquals(hospital.getLicenseDate(),selectHospital.getLicenseDate());
//        assertEquals(hospital.getBusinessStatus(),selectHospital.getBusinessStatus());
//        assertEquals(hospital.getBusinessStatusCode(),selectHospital.getBusinessStatusCode());
//        assertEquals(hospital.getPhone(),selectHospital.getPhone());
//        assertEquals(hospital.getFullAddress(),selectHospital.getFullAddress());
//        assertEquals(hospital.getRoadNameAddress(),selectHospital.getRoadNameAddress());
//        assertEquals(hospital.getHospitalName(),selectHospital.getHospitalName());
//        assertEquals(hospital.getBusinessTypeName(),selectHospital.getBusinessTypeName());
//        assertEquals(hospital.getHealthcareProviderCount(),selectHospital.getHealthcareProviderCount());
//        assertEquals(hospital.getPatientRoomCount(),selectHospital.getPatientRoomCount());
//        assertEquals(hospital.getTotalNumberOfBeds(),selectHospital.getTotalNumberOfBeds());
//        assertEquals(hospital.getTotalAreaSize(),selectHospital.getTotalAreaSize());
//    }
//
//    @Test
//    @DisplayName("테스트 1줄을 Hospital로 잘 만드는지 확인")
//    void convertToHospital() {
//        HospitalParser hp = new HospitalParser();
//        Hospital hospital = hp.parse(str);
//
//        assertEquals(1, hospital.getId()); // col:0
//        assertEquals("의원", hospital.getOpenServiceName());//col:1
//        assertEquals(3620000,hospital.getOpenLocalGovernmentCode()); // col: 3
//        assertEquals("PHMA119993620020041100004",hospital.getManagementNumber()); // col:4
//        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612 //col:5
//        assertEquals(1, hospital.getBusinessStatus()); //col:7
//        assertEquals(13, hospital.getBusinessStatusCode());//col:9
//        assertEquals("062-515-2875", hospital.getPhone());//col:15
//        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress()); //col:18
//        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());//col:19
//        assertEquals("효치과의원", hospital.getHospitalName());//col:21
//        assertEquals("치과의원", hospital.getBusinessTypeName());//col:25
//        assertEquals(1, hospital.getHealthcareProviderCount()); //col:29
//        assertEquals(0, hospital.getPatientRoomCount()); //col:30
//        assertEquals(0, hospital.getTotalNumberOfBeds()); //col:31
//        assertEquals(52.29f, hospital.getTotalAreaSize()); //col:32
//    }
//    @Test
//    @DisplayName("10만건 이상의 데이터가 파싱되는지")
//    void addBigdata() throws IOException {
//        hospitalDao.deleteAll();
////        String filename = "/Users/admin/Downloads/fulldata_01_01_02_P_의원.csv";
//        String filename = "/Users/admin/Downloads/bigdata.csv";
//        int cnt = this.hospitalService.insertLargeVolumeHospitalData(filename);
//        assertTrue(cnt > 1000);
//        System.out.printf("파싱된 데이터 개수: %d", cnt);
//
//    }
}