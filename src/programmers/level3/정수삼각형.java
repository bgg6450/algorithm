package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int depth = triangle.length;
        int[][] dp = new int[depth][depth];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < depth; i++) {
            for (int j = 0; j <= i; j++) {
                int left = j == 0 ? 0 : dp[i - 1][j - 1];
                int right = j == i ? 0 : dp[i - 1][j];
                dp[i][j] = Math.max(left, right) + triangle[i][j];
            }
        }
        List<Integer> results = new ArrayList<>();
        for (int result : dp[depth-1]) {
            results.add(result);
        }
        Collections.sort(results);
        return results.get(depth-1);
    }
}
