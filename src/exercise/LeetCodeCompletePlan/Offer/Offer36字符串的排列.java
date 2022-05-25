package exercise.LeetCodeCompletePlan.Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description
 * @Author harrypotterandsbt@gmail.com
 * @Date 2022/5/22
 */
public class Offer36字符串的排列 {

    List<String> res = new ArrayList<>();
    char[] charArr;
    public String[] permutation(String s) {
        charArr = s.toCharArray();
        dfs(charArr, 0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(char[] s, int index) {
        if(index == s.length -1) {
            res.add(String.valueOf(s));
        }
        Set<Character> set = new HashSet<>();
        for(int i = index ; i < s.length; i ++) {
            if(set.contains(s[i])) {
                continue;
            }
            set.add(s[i]);
            swap(s , index , i);
            dfs(s,index+1);
            swap(s, i ,index);
        }
    }


    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String test = "abcc";
        String[] res = new Offer36字符串的排列().permutation(test);
        for(String str : res) {
            System.out.println(str);
        }
    }



}
