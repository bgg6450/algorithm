package programmers.level2;

import java.util.Arrays;

public class 피로도_2 {
    static int result = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, 0);
        return result;
    }

    public void dfs(int k, int[][] dungeons, int visited) {
        if (visited == dungeons.length) {
            result = Math.max(result, visited);
            return;
        }
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] == 0 && dungeons[i][1] == 0) {
                continue;
            }
            if (k >= dungeons[i][0]) {
                int[][] copiedDungeons = Arrays.copyOf(dungeons, dungeons.length);
                copiedDungeons[i] = new int[]{0, 0};
                dfs(k - dungeons[i][1], copiedDungeons, visited+1);
            } else {
                result = Math.max(result, visited);
            }
        }
    }
}
