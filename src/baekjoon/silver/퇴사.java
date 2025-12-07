package baekjoon.silver;

import java.util.Scanner;

class 퇴사 {

    static int idx;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][2];
        idx = N - 1;


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp(idx);
    }

    static int nextIdx(int cn) {
        for (int i = cn; i >= 0; i--) {
            if ((i + arr[i][0]) <= cn + 1) {
                return i;
            }
        }
        return -1;
    }

    static int dp(int idx) {
        int nextIdx = nextIdx(idx);
        if (nextIdx == -1) {
            return 0;
        }
        System.out.println(arr[idx][1]);
        return dp(nextIdx) + arr[idx][1];
    }
}
