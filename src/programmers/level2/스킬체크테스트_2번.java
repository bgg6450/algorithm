package programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 스킬체크테스트_2번 {

    int[] dx = {1, 0};
    int[] dy = {0, 1};

    public int[] solution(String[] maps) {
        List<Integer> results = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            if (!maps[currentX].split("")[currentY].equals("X")) {
                result += Integer.valueOf(maps[currentX].split("")[currentY]);
                for (int i = 0; i < 2; i++) {
                    if (currentX + dx[i] < maps.length && currentY + dy[i] < maps[0].length() &&
                            !maps[currentX + dx[i]].split("")[currentY + dy[i]].equals("X")) {
                        queue.add(new int[]{currentX + dx[i], currentY + dy[i]});
                    }
                }
            }
            if (queue.isEmpty()) {

            }
        }
        return null;
    }
}
