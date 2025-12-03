package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class 숨바꼭질 {

    static int[] da = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        boolean[] visited = new boolean[100001];
        int[] dist = new int[100001];
        visited[a] = true;
        dist[a] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        System.out.println(bfs(queue, visited, dist, b));
    }

    private static int bfs(Queue<Integer> queue, boolean[] visited, int[] dist, int b) {
        while (!queue.isEmpty()) {
            Integer currentA = queue.poll();
            if (currentA == b) return dist[currentA];

            for (int i = 0; i < 2; i++) {
                int na = currentA + da[i];
                if (na > -1 && na < 100001 && !visited[na]) {
                    if (na == b) {
                        return dist[currentA] + 1;
                    }
                    visited[na] = true;
                    queue.add(na);
                    dist[na] = dist[currentA] + 1;
                }
            }
            if (currentA != 0 && currentA*2 < 100001) {
                int na = currentA * 2;
                if (na == b) {
                    return dist[currentA] + 1;
                }
                if (!visited[na]) {
                    visited[na] = true;
                    queue.add(na);
                    dist[na] = dist[currentA] + 1;
                }
            }
        }

        return dist[b];
    }
}
