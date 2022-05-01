package exercise.category.RecursAndBackstracking.LC93;

import java.util.ArrayList;
import java.util.List;

// dfs(s,segId,segStart) 表示从 s[segStart]的位置，搜索IP地址的
// 第seg
public class Solution_1 {
    static final int SEG_COUNT = 4;
    List<String> res = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return res;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了4段 IP地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                res.add(ipAddr.toString());
            }
        }

        //如果还没找到4端IP地址就遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        //由于不能有前导零，如果当前数字为0，那这一段IP地址为0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        //一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            // 计算IP字段的数值是否在(0,255]内
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
