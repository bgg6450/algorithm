package naver.cloud.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test_1 {
    public int solution(String[] E) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                int[] s = new int[E.length];
                for (int k = 0; k < s.length; k++) {
                    if (E[k].contains(String.valueOf(i)) || E[k].contains(String.valueOf(j))) {
                        s[k] = 1;
                    }
                }
                results.add(Arrays.stream(s).sum());
            }
        }
        return results.stream().max(Integer::compareTo).get();
    }
}
