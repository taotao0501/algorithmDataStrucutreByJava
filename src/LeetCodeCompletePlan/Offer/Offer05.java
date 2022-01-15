package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2022/1/15 21:24
 * @Version: V1.0
 **/


public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray()) {
            if(c == ' '){
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
