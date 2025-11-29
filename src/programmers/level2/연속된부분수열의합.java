package programmers.level2;

public class 연속된부분수열의합 {
    static int[] answer;

    public int[] solution(int[] sequence, int k) {
        answer = new int[]{0, sequence.length - 1};
        dfs(sequence, k, 0, sequence.length - 1);
        return answer;
    }

    void dfs(int[] sequence, int k, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            if (sequence[startIndex] == k) {
                answer = new int[]{startIndex, endIndex};
            }
            return;
        }
        int result = 0;
        for (int i = startIndex; i < endIndex + 1; i++) {
            result += sequence[i];
        }
        if (result == k) {
            if (answer[1] - answer[0] > endIndex - startIndex) {
                answer = new int[]{startIndex, endIndex};
            }
            if (answer[1] - answer[0] == endIndex - startIndex && answer[0] > startIndex) {
                answer = new int[]{startIndex, endIndex};
            }
            return;
        }
        dfs(sequence, k, startIndex + 1, endIndex);
        dfs(sequence, k, startIndex, endIndex - 1);
    }
}
