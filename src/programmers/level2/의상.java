package programmers.level2;

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            }
            else {
                map.put(clothe[1], 2);
            }
        }
        int answer = 1;
        List<Integer> result = new ArrayList<>(map.values());
        for (Integer i : result) {
            answer *= i;
        }
        return answer-1;
    }
}
