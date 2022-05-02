package exercise.Interview.ByteDance;

/**
 * 字符串全排列
 */

import java.util.ArrayList;
import java.util.List;

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
        for(int i=0; i<len; i++){
            if(!used[i]){
                used[i]=true;
                abc = s+str.charAt(i);
                dfs(str,index+1, abc);
                abc = s;
                used[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        String test = "ABCDEF";
        System.out.println((new StrPermute()).list(test));
    }
}
