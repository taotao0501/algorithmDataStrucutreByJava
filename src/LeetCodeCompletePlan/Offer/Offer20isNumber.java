package LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/2/17 10:51
 * @Version: V1.0
 **/

public class Offer20isNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //标记是否数值(整数/小数)，是否遇到小数点，是否遇到e E
        boolean isNum = false, isDot = false, ise_or_E = false;
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {
                isNum = true;
            } else if (str[i] == '.') { //遇到小数点
                if (isDot || ise_or_E) { //小数点后不能再跟小数点，或者e/E
                    return false;
                }
                isDot = true; //标记已经遇到小数点
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (!isNum || ise_or_E) {// ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                    return false;
                }
                ise_or_E = true; // 标记已经遇到‘e’或'E'
                isNum = false; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    //正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                    return false;
                }
            } else {
                return false; //
            }
        }
        return isNum;
    }
}
