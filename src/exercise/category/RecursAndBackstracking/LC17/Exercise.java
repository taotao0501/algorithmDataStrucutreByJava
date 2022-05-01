package exercise.category.RecursAndBackstracking.LC17;
//digits是数字字符串
//s(digits)是digits所代表的字母字符串
//s(digit[0...n-1]) = letter(digits[0]) + s(digit[1...n-1])

//时间复杂度是 3^n = O(2^n) 比较低， n=20是家用计算机的性能天花板
//回溯法适合n未知的暴力解决

// 4-22 重新练习， 一定要把所有的代码弄懂
// 树型结构问题，这里没有回溯的一般条件，递归结果如上所述

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private String[] letterMap = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9}
    };

    List<String> res;

    public List<String> letterCombination(String digits) {
        res = new ArrayList<String>();
        if (digits.equals("")) {
            return res;
        }

        findCombination(digits, 0, "");

        return res;
    }

    // index表示 digit的第几个数字字符的索引，s表示digits[0,index-1]组成的一个字符串。
    private void findCombination(String digits, int index, String s) {
        System.out.println(index + " : " + s);

        //终止条件
        if (index == digits.length()) {
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        //前置逻辑处理
        Character c = digits.charAt(index);
        String letters = letterMap[c - '0'];

        for (int i = 0; i < letters.length(); i++) {
            //递归前
            System.out.println("digits[" + index + "] = " + c +
                    " , use " + letters.charAt(i));
            // 递归
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        System.out.println("digits[" + index + "] = " + c + " complete, return");
    }

    ;

    private static void printList(List<String> list) {
        for (String s : list)
            System.out.println(s);
    }

    public static void main(String[] args) {

        printList((new Solution()).letterCombinations("234"));
    }


}