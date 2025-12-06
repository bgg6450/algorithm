package practice.algorithm.counting;

public class Combination {
    static int[] arr = {1, 3, 5, 7, 9};
    static int target = 2;
    static int[] result = new int[target];

    public static void comb(int start, int depth) {
        if (depth == target) {
            System.out.println(result[0] + " " + result[1]);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            result[depth] = arr[i];
            comb(i+1, depth+1);
        }
    }

    public static void main(String[] args) {
        comb(0, 0);
    }
}
