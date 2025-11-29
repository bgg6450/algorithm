package programmers.level2;

public class 타겟넘버_2 {

    static int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    public void dfs(int[] numbers, int target, int answer, int depth) {
        if ((depth == numbers.length)) {
            if (answer == target) {
                count++;
            }
            return;
        }
        dfs(numbers, target, answer + numbers[depth], depth+1);
        dfs(numbers, target, answer - numbers[depth], depth+1);
    }
}
