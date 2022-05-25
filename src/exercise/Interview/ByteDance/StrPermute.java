package exercise.Interview.ByteDance;

/**
 * 字符串全排列 ，本题只能解决 字符串中每个字符互不相同，否则就会有重复，需要剪枝
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StrPermute {
    List<String> res;
    boolean[] used;
    int len;
    String abc;
    public List<String> list(String str){
        len = str.length();
        res = new ArrayList<String>();
        used = new boolean[len];
        dfs(str,0,"");
        return res;


    }

    private void dfs(String str, int index, String s){
        if(index == len){
            res.add(s);
            return;
        }
        Set<Character> record = new HashSet<>();
        for(int i=0; i<len; i++){
            if(record.contains(str.charAt(i))) {
                continue;
            }
            if(!used[i]){
                used[i]=true;
                abc = s+str.charAt(i);
                record.add(str.charAt(i));
                dfs(str,index+1, abc);
                abc = s;
                used[i]=false;
            }
        }
    }
    public static void main(String[] args) {
//        String test = "ABCDEF";
        String test = "abcc";
        System.out.println((new StrPermute()).list(test));
    }
}
