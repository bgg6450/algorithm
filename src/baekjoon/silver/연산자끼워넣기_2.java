package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연산자끼워넣기_2 {

    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        String[] codes = br.readLine().split(" ");
        R = numbers.length - 1;
    }

    public void permutation(int depth) {
        if (depth == R) {

        }

    }
}
