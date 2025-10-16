package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 스킬체크테스트_1번 {
    int answer = 1;
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        map.values().stream().forEach(value -> answer *= value+1);
        return answer - 1;
    }
}
