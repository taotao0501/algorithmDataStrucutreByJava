package learn.Sort.utils;

import java.time.LocalDate;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2021/11/1 17:39
 * @Version: V1.0
 **/

public class Test {
    public static void main(String[] args) {
//        String a = "01:29";
//        LocalDate today = LocalDate.now();
//        LocalTime time = LocalTime.parse(a);
//        LocalDateTime testTime = LocalDateTime.of(today, time);
//        LocalDateTime testTimeAdvanceTwoH = testTime.minusHours(2);
//        System.out.println(testTime.toString());
//        System.out.println(testTimeAdvanceTwoH.toString());

//
//        List<Apple> appleList = new ArrayList<>();
//
//        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
//        Apple apple3 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
//        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
//
//        appleList.add(apple1);
//        appleList.add(apple2);
//        appleList.add(apple3);
//
//        Map<Integer, Apple> appleMap = appleList.stream().
//                collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));
//
//        System.out.println(appleMap);


        // 判断正则
//        String str = "12小时50分钟";
//        Pattern p2 = Pattern.compile("[\\u4e00-\\u9fa5]+|\\d+\\.+\\d+|\\d+");
//        Matcher m = p2.matcher( str);
//        Pattern pattern2 = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
//
//        int count = 0;
//        while( m.find() ){
//            String group = m.group();
//            if( pattern2.matcher(group).matches()) {
//                if(count == 0) {
//                    System.out.println("hours: " + group);
//                }
//                else if(count == 2) {
//                    System.out.println("minutes: " + group);
//                }
//            }
//            count ++;
//        }
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String str = "2012-10-12";
//        LocalDate sbt = LocalDate.parse(str);
//
//        System.out.println(sbt.minusDays(1));
        LocalDate now = LocalDate.now();
        System.out.println(now);
        Integer abc = 2;

    }

}
