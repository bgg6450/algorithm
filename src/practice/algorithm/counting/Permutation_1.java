package practice.algorithm.counting;

public class Permutation_1 {
    static int[] nums = {1, 3, 5, 7, 9};
    static boolean[] visited = new boolean[nums.length];
    static int r = 2;
    static int[] result = new int[r];

    public static void perm(int depth) {
        if (depth == r) {
            System.out.println(result[0] + " " + result[1]);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = nums[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        perm(0);
    }
}
