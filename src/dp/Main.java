package dp;

/**
 * 가장 큰 정사각형 찾기 문제
 *
 */
public class Main {

    public static void main(String[] args) {

        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        Main main = new Main();
        System.out.println(main.solution(board));
    }

    public int solution(int[][] board) {

        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        int[][] dp = new int[1001][1001];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(board[i-1][j-1] != 0) {
                    dp[i][j] = Min(Min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    answer = Max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }

    private int Max(int a, int b) {
        return a < b ? b : a;
    }

    private int Min(int a, int b) {
        return a < b ? a : b;
    }
}