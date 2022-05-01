# 字符串匹配算法
## 1. 朴素的字符串匹配算法

> 问题：在一个字符串中查找是否存在一个子串，如果有则返回字符串第一个匹配的字符的索引

### 1.暴力解法

```java
public class SubstringMatch {
    
    private SubstringMatch();
    
    public static int bruteforce(String s, String t){
        for(int i = 0; i+ t.length() -1 < s.length(); i++) {
            int j = 0;
            for(; j < t.length(); j ++) {
                if(s.charAt(i+j) != t.charAt(j)) {
                    break;
                }
            }
            if( j == t.length()) {
                return i;
            }
        }
        return -1;
         
    }
}
```
m = s.length();
n = t.length();
时间复杂度严格来说是 |m-n|*|n|,考虑到实际情况
下 m >> n,所以近似于时间复杂度为 O(mn)。

优化思路：比较两个字符串是否相等是O(n)，比较两个整型是否相等是O(1)。因此优化思路是：使用字符串哈希化成整型。

这里其实就是用到了





#### BTW 哈希算法（无缝连接第13周）
1.LeetCode-387
> 给定一个字符串 s ，
> 找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
> 1 <= s.length <= 105 
> s 只包含小写字母 

比较巧妙的解法是利用字符串本身在ASCii码的位置作为key，构建一个map。
```java
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length() ; i++) {
          freq[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i ++) {
            if( freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
```













