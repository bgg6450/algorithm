package programmers.level2;

import java.util.Arrays;

public class 땅따먹기 {
    public static int solution(int[][] land) {
        int depth = land.length;
        int width = land[0].length;
        int[][] dp = new int[depth][width];

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0) {
                    dp[0][j] = land[0][j];
                }
                else {
                    int[] dps = Arrays.copyOf(dp[i-1], width);
                    dps[j] = 0;
                    Arrays.sort(dps);

                    dp[i][j] = land[i][j] + dps[width - 1];
                }
            }
        }

        int[] results = dp[depth - 1];
        Arrays.sort(results);

        return results[width - 1];
    }
}
