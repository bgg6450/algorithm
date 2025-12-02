package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(br.readLine());
        int connected = Integer.parseInt(br.readLine());

        List<Integer>[] map = new ArrayList[nums];
        for (int i = 0; i < nums; i++) {
            map[i] = new ArrayList<>();
        }

        boolean[] infested = new boolean[nums];
        infested[0] = true;

        for (int i = 0; i < connected; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            map[num1-1].add(num2-1);
            map[num2-1].add(num1-1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (!map[node].isEmpty()) {
                for (int i = 0; i < map[node].size(); i++) {
                    if (!infested[map[node].get(i)]) {
                        queue.add(map[node].get(i));
                        infested[map[node].get(i)] = true;
                    }
                }
            }
        }

        int count = 0;
        for (boolean b : infested) {
            if (b) count++;
        }
        System.out.println(count-1);
    }
}
