package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 스타트와링크_2 {

    static int N;
    static int R;
    static boolean[] visited;
    static int[][] table;
    static List<Integer> teamA = new ArrayList<>();
    static List<Integer> teamB = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N / 2;
        visited = new boolean[N];
        table = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(row[j]);
            }
        }
        combination(0, 0);
        System.out.println(result);
    }

    public static void combination(int depth, int start) {
        if (depth == R) {
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    teamA.add(j);
                } else {
                    teamB.add(j);
                }
            }
            result = Math.min(Math.abs(count(teamA) - count(teamB)), result);
            teamA = new ArrayList<>();
            teamB = new ArrayList<>();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static int count(List<Integer> team) {
        int result = 0;
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                result += table[team.get(i)][team.get(j)];
            }
        }
        return result;
    }
}
