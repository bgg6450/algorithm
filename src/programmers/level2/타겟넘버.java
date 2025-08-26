package programmers.level2;

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class 타겟넘버 {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer;
        dfs(numbers, 0, target, 0);
        answer = count;

        return answer;
    }
    public void dfs(int[] numbers, int depth, int target, int result){
        if (depth == numbers.length){
            if (target == result){
                count++;
            }
            return;
        }
        int plus = result + numbers[depth];
        int minus = result - numbers[depth];

        dfs(numbers, depth+1, target, plus);
        dfs(numbers, depth+1, target, minus);
    }
}
