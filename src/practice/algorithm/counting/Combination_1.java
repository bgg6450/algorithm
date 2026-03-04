package practice.algorithm.counting;

public class Combination_1 {
    static int[] nums = {1, 3, 5, 7, 9};
    static int r = 2;
    static int[] result = new int[r];

    public static void comb(int start, int depth) {
        if (depth == r) {
            System.out.println(result[0] + " " + result[1]);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            result[depth] = nums[i];
            comb(i+1, depth+1);
        }
    }

    public static void main(String[] args) {
        comb(0, 0);
    }
}
