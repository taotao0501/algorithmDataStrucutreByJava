package learn.StringMatch;

/**
 * @Description: 暴力搜索
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/28 17:31
 * @Version: V1.0
 **/

public class SubstringMatch {

    private SubstringMatch() {
    }

    ;

    public static int bruteforce(String s, String t) {
        for (int i = 0; i + t.length() - 1 < s.length(); i++) {
            int j = 0;
            for (; j < t.length(); j++) {
                if (s.charAt(i + j) != t.charAt(j)) {
                    break;
                }
            }
            if (j == t.length()) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String s1 = "hello, this is liuyubobobo.";
        String t1 = "bo";
        SubstringMatchHelper.matchTest("bruteforce", s1, t1);

        String s2 = FileOperation.readFile2("pride-and-prejudice.txt");
        String t2 = "china";
        SubstringMatchHelper.matchTest("bruteforce", s2, t2);
        SubstringMatchHelper.matchTest("bruteforce", s2, "zyx");
    }
}
