package programmers.level3;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for (int[] puddle : puddles) {
            int row = puddle[1] - 1;
            int col = puddle[0] - 1;
            if (col == 0) {
                for (int i = row; i < n; i++) {
                    dp[i][col] = -1;
                }
            }
            if (row == 0) {
                for (int j = col; j < m; j++) {
                    dp[row][j] = -1;
                }
            }
            dp[row][col] = -1;
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((j == 0 || i == 0) && dp[i][j] != -1) {
                    dp[i][j] = 1;
                }
                else if (dp[i][j] != -1) {
                    int left = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
                    int top = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                    dp[i][j] = left + top;
                }
            }
        }

        return dp[n-1][m-1] & 1000000007;
    }
}
