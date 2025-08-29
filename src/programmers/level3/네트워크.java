package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {

    public int solution_dfs(int n, int[][] computers) {
        int result = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                result++;
            }
        }
        return result;
    }

    private void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                dfs(j, visited, computers);
            }
        }
    }
}
