package programmers.level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 도둑질 {

    public static int solution(int[] money) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[1];
        dp[2] = money[2] + money[0];

        for (int i = 3; i < money.length; i++) {
            int lower = dp[i - 3];
            int higher = dp[i - 2];
            if (i == money.length - 2 && dp[0] > dp[1]) {
                dp[i] = money[i] + Math.max(lower, higher);
                break;
            }
            dp[i] = money[i] + Math.max(lower, higher);
        }

        List<Integer> results = new ArrayList<>();
        for (int result : dp) {
            results.add(result);
        }

        results.forEach(System.out::println);
        Collections.sort(results);

        if (money.length == 3) {
            Arrays.sort(money);
            return money[money.length - 1];
        }
        if (money.length == 4) {
            return Math.max(money[0] + money[2], money[1] + money[3]);
        }
        else {
            return Math.max(results.get(money.length - 2), results.get(money.length - 1));
        }
    }

    public static void main(String[] args) {
//        int[] input = {2, 2, 1, 3, 5, 2, 1, 0, 3, 5};
        int[] input = {1, 2, 1, 4, 3};
        solution(input);
    }
}
