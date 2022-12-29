package level1;

import java.util.ArrayList;
import java.util.List;

// [1차] 비밀지도
public class Solution4 {
    public static List<String> solution(int n, int[] arr1, int[] arr2) {
        List<String> a1 = new ArrayList<>();
        List<String> a2 = new ArrayList<>();
        List<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a1.add(String.format("%0" + n + "d", Long.valueOf(Integer.toBinaryString(arr1[i]))));
            a2.add(String.format("%0"+ n +"d", Long.valueOf(Integer.toBinaryString(arr2[i]))));
        }
        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < n; j++) {
                s.append(String.valueOf(a1.get(i).charAt(j)).equals("0") && String.valueOf(a2.get(i).charAt(j)).equals("0") ? " " : "#");
            }
            a.add(s.toString());
        }
        return a;
    }
}