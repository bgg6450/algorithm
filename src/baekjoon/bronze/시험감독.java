package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: 정수 하나
        int n = Integer.parseInt(br.readLine());

        // 둘째 줄: 정수 n개
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 셋째 줄: 정수 2개
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long count = 0;
        for (long l : arr) {
            if (a >= l) {
                count += 1;
            }
            else {
                count += 1 + ((l - a - 1) / b + 1);
            }
        }
        System.out.println(count);
    }
}
