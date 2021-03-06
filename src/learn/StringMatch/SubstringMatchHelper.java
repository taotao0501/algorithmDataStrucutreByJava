package learn.StringMatch;

/**
 * @Description: 匹配测试类
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/28 17:49
 * @Version: V1.0
 **/

public class SubstringMatchHelper {

    private SubstringMatchHelper() {
    }

    ;

    public static void matchTest(String name, String s, String t) {
        int pos = -1;
        long startTime = System.nanoTime();
        if (name.equals("bruteforce")) {
            pos = SubstringMatch.bruteforce(s, t);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;

        if (s.indexOf(t) != pos) {
            throw new RuntimeException(name + " failed");
        }

        System.out.println(String.format("%s : res = %d, time = %f s", name, pos, time));
    }

}
