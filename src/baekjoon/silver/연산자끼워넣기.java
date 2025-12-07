package baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class 연산자끼워넣기 {

    static int target;
    static int[] nums;
    static int[] codeNums;
    static List<Integer> codes;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nums = new int[N];
        target = N - 1;
        codeNums = new int[4];
        codes = new ArrayList<>();

        for (int i = 0; i < N; i ++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            codeNums[i] = sc.nextInt();
        }
        permutation(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void permutation(int depth) {
        if (depth == target) {
            calc();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (codeNums[i] != 0) {
                codeNums[i] -= 1;
                codes.add(i);
                permutation(depth + 1);
                codes.remove(codes.size() - 1);
                codeNums[i] += 1;
            }
        }
    }

    static void calc() {
        int result = nums[0];
        for (int i = 1; i < target + 1; i++) {
            if (codes.get(i-1) == 0) {
                result += nums[i];
            }
            if (codes.get(i-1) == 1) {
                result -= nums[i];
            }
            if (codes.get(i-1) == 2) {
                result *= nums[i];
            }
            if (codes.get(i-1) == 3) {
                result /= nums[i];
            }
        }
        max = Math.max(result, max);
        min = Math.min(result, min);
    }
}
