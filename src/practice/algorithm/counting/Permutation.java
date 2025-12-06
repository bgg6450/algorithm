package practice.algorithm.counting;

public class Permutation {
    static int[] arr = {1, 3, 5, 7, 9};
    static boolean[] visited = new boolean[arr.length];
    static int target = 2;
    static int[] result = new int[target];

    public static void perm(int depth) {
        if (depth == target) { // depth 크기는 최대 target
            System.out.println(result[0] + " " + result[1]);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                perm(depth + 1); // 하나 채웠으니 depth 높여서 나머지 값 채우는 과정
                visited[i] = false; // 백트래킹
            }
        }
    }

    public static void main(String[] args) {
        perm(0);
    }
}
