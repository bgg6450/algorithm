package baekjoon.silver;

import java.util.Scanner;

class 퇴사 {

    static int idx;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][2];
        idx = N;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(dp(initIdx()));
    }

    static int initIdx() {
        for (int i = idx - 1; i >= 0; i--) {
            if ((i + arr[i][0]) <= idx) {
                return i;
            }
        }
        return -1;
    }

    static int dp(int idx) {
        if (idx == 0) {
            return arr[0][1];
        }
        int max = 0;
        int nextIdx = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if (idx - i >= arr[i][0]) {
                max = Math.max(arr[i][1], max);
                if (max == arr[i][1]) {
                    nextIdx = i;
                }
            }
        }
        return dp(nextIdx) + arr[idx][1];
    }
}
