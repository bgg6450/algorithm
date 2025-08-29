package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환_BFS {

    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    private int bfs(String begin, String target, String[] words) {
        int depth = 0;
        boolean[] counted = new boolean[words.length];

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return depth;
                }

                for (int j = 0; j < words.length; j++) {
                    if (!counted[j] && isChangeable(current, words[j])) {
                        counted[j] = true;
                        queue.add(words[j]);
                    }
                }
            }
            depth++;
        }
        return 0;
    }

    private static boolean isChangeable(String bf, String af) {
        int differ = 0;
        for (int i = 0; i < bf.length(); i++) {
            if (bf.charAt(i) != af.charAt(i)) {
                differ++;
            }
        }
        return differ == 1;
    }
}
