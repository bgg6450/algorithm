package naver.cloud.test;

import java.util.*;

public class Test_3 {
    public int solution(int[] A, int[] B) {
        Set<Integer> c_values = new HashSet<>();
        List<Integer> emptyNums = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            c_values.add(Math.max(A[i], B[i]));
        }
        for (int i = 1; i < 100000; i++) {
            if (!c_values.contains(i)) {
                emptyNums.add(i);
            }
        }
        if (emptyNums.isEmpty()) {
            return c_values.stream().max(Integer::compare).get()+1;
        }
        return emptyNums.stream().min(Integer::compare).get();
    }
}
