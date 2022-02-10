package LeetCodeCompletePlan.Offer;

/**
 * @Description: 这道题很难，不想做了
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/1/26 17:59
 * @Version: V1.0
 **/

public class Offer13Solution {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    public int dfs(int i, int j, int m, int n, int k,
                   boolean[][] visited) {
        if(i >= m || j>= n || k < getSum(i) + getSum(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j ,m ,n, k, visited) + dfs(i, j + 1 ,m ,n, k, visited);

    }

    private int getSum(int num) {
        int res = 0;
        while( num != 0) {
            int s = num % 10;
            res += s;
            num /= 10;
        }
        return res;
    }
}
