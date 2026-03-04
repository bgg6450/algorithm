package practice.algorithm.counting;

public class Permutation_2 {

    static int r = 2;
    static int n;
    static int[] visited = new int[r];
    static int[] nums = {1, 3, 5, 7, 9};

    public static void main(String[] args) {
        n = nums.length;
        permutation(0);
    }

    public static void permutation(int depth) {
        if (depth == r) {
            System.out.println(String.format("[%d, %d]", visited[0], visited[1]));
            return;
        }
        for (int i = 0; i < n; i++) {
            visited[depth] = nums[i];
            permutation(depth + 1);
        }
    }
}
