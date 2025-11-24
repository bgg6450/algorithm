package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
            }
        }
        map.forEach((k, v) -> {
            if (v != 0) {
                sb.append(k);
            }
        });
        return sb.toString();
    }
}
