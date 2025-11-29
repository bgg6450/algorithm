package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    Set<Integer> results = new HashSet<>();

    public int solution(String numbers) {
        String[] nums = numbers.split("");
        boolean[] counted = new boolean[nums.length];
        dfs(nums, counted, "", numbers.length());
        return results.size();
    }

    void dfs(String[] nums, boolean[] counted, String result, int maxLength) {
        if (result.length() == maxLength) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!counted[i]) {
                if (isPrime(Integer.parseInt(result + nums[i]))) {
                    results.add(Integer.parseInt(result + nums[i]));
                }
                counted[i] = true;
                dfs(nums, counted, result + nums[i], maxLength);
                counted[i] = false;
            }
        }
    }

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
