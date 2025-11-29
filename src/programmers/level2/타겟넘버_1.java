package programmers.level2;

public class 타겟넘버_1 {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer;
        dfs(numbers, 0, target, 0);
        answer = count;

        return answer;
    }
    public void dfs(int[] numbers, int depth, int target, int result){
        // 탐색 중단 조건
        // 모든 탐색을 끝마쳤을 때, 즉 depth가 numbers의 길이와 같을 때
        // 그리고 이 때 result가 target과 같다면 count 증가
        if (depth == numbers.length){
            if (target == result){
                count++;
            }
            return;
        }

        // result 변경과 depth 증가 후 재귀 호출
        int plus = result + numbers[depth];
        int minus = result - numbers[depth];

        dfs(numbers, depth+1, target, plus);
        dfs(numbers, depth+1, target, minus);
    }
}
