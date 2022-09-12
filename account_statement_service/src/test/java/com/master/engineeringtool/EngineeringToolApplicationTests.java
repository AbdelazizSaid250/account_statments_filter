package com.master.engineeringtool;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.master.common.util.Const.YMD_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class EngineeringToolApplicationTests {

    @Test
    void contextLoads() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YMD_FORMAT);
        int monthValue = LocalDate.parse("1994-09-19", formatter).getMonthValue();

        assertEquals(9, monthValue);
    }

}
