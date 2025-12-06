package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 4
 * 0 1 2 3
 * 4 0 5 6
 * 7 1 0 2
 * 3 4 5 0
 */
class 스타트와링크 {

    static List<int[]> results = new ArrayList<>();
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            l.add(i+1);
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        combination(0, 0, N/2, N, new int[N]);
        getOpponents(new int[]{1, 3, 5, 7, 9}, 10);
    }

    public static void combination(int start, int depth, int target, int N, int[] result) {
        if (depth == target) {
            results.add(result);
            return;
        }
        for (int i = start; i < N; i++) {
            result[depth] = l.get(i);
            combination(i+1, depth+1, target, N, result);
        }
    }

    public static int[] getOpponents(int[] members, int N) {
        int[] oMembers = new int[N/2];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < members.length; i++) {
            visited[members[i] - 1] = true;
        }
        for (int j = 0; j < N; j++) {
            if (!visited[j]) {
                oMembers[j] = j + 1;
            }
        }
        System.out.println(oMembers);
        return oMembers;
    }
}
