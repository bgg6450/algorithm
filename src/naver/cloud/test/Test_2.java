package naver.cloud.test;

import java.util.*;

public class Test_2 {

    public int solution(String S) {
        List<Character> dp = new ArrayList<>();

        for (char C : S.toCharArray()) {
            int current = lowerBound(dp, C);
            if (current == dp.size()) {
                dp.add(C);
            } else {
                dp.set(current, C);
            }
        }
        return S.length() - dp.size();
    }

    int lowerBound(List<Character> dp, char target) {
        int left = 0;
        int right = dp.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (dp.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
