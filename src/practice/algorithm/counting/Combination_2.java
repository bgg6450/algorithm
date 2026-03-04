package practice.algorithm.counting;

public class Combination_2 {

    static int n;
    static int r = 2;
    static int[] nums = {1, 3, 5, 7, 9};
    static int[] visited = new int[r];

    public static void main(String[] args) {
        n = nums.length;
        combination(0, 0);
    }

    public static void combination(int start, int depth) {
        if (depth == r) {
            System.out.println(String.format("[%d, %d]", visited[0], visited[1]));
            return;
        }
        for (int i = start; i < n; i++) {
            visited[depth] = nums[i];
            combination(i + 1, depth + 1);
        }
    }
}
