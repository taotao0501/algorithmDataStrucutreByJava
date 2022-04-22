package LeetCodeCompletePlan.Offer;

/**
 * @Description: 重新尝试自己解决：失败了
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/1/26 16:11
 * @Version: V1.0
 **/

public class Offer12_Retry {

    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null && board.length == 0) {
            throw new IllegalArgumentException("board cannot be empty");
        }
        m = board.length;
        if (board[0].length == 0) {
            throw new IllegalArgumentException("board cannot be empty");
        }
        n = board.length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, int startx, int starty, int index,
                               String word) {
        //递归终止条件
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (!visited[newx][newy] && inArea(newx, newy) &&
                        searchWord(board, newx, newy, index + 1, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        char[][] b1 = {{'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}};
        String[] words = {"asade", "see", "eds"};

        for (String word : words) {
            if ((new Offer12_WordSearch()).exist(b1, word))
                System.out.println("found " + word);
            else
                System.out.println("can not found " + word);
        }
    }
}
