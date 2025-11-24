package naver.cloud.test;

import java.util.*;

public class Test_3 {
    public int solution(int[] A, int[] B) {
        Set<Integer> c_values = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            c_values.add(Math.max(A[i], B[i]));
        }
        for (int i = 1; i < 100000; i++) {
            if (!c_values.contains(i)) {
                return i;
            }
        }
        return 100001;
    }
}
