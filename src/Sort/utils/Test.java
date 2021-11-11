package Sort.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/11/1 17:39
 * @Version: V1.0
 **/


public class Test {
    public static void main(String[] args) {
        String a = "01:29";
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.parse(a);
        LocalDateTime testTime = LocalDateTime.of(today, time);
        LocalDateTime testTimeAdvanceTwoH = testTime.minusHours(2);
        System.out.println(testTime.toString());
        System.out.println(testTimeAdvanceTwoH.toString());

    }
}
