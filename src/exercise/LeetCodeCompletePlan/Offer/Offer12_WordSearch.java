package exercise.LeetCodeCompletePlan.Offer;

/**
 * @Description:
 * @Author: Bentao She
 * @Date: 2022/1/15 19:17
 * @Version: V1.0
 **/
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
// Related Topics 数组 回溯 矩阵
// 👍 487 👎 0

public class Offer12_WordSearch {

    // 分别是 上，右，下，左四个方向
    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            throw new IllegalArgumentException("board cann not be empty!");
        }
        n = board[0].length;
        if (n == 0) {
            throw new IllegalArgumentException("board cann not be empty!");
        }
        visited = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 从 board[startx, starty]开始，寻找word[index....word.size]子字符串
    private boolean searchWord(char[][] board, String word,
                               int index, int startx, int starty) {
        //递归终止条件
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            // 从board[starx][starty]出发，向四个方向搜索
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] &&
                        searchWord(board, word, index + 1, newx, newy)) {
                    return true;
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    public static void main(String args[]) {

        char[][] b1 = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String words[] = {"ABCCED", "SEE", "ABCB"};
        for (int i = 0; i < words.length; i++)
            if ((new Offer12_WordSearch()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);

        // ---

        char[][] b2 = {{'A'}};
        if ((new Offer12_WordSearch()).exist(b2, "AB"))
            System.out.println("found AB");
        else
            System.out.println("can not found AB");
    }
}
