package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 모음사전 {

    List<String> results = new ArrayList<>();

    public int solution(String word) {
        dfs("", 0);
        Collections.sort(results);
        return results.indexOf(word);
    }

    public void dfs(String result, int depth) {
        if (depth == 6) {
            return;
        }
        results.add(result);

        dfs(result + "A", depth + 1);
        dfs(result + "E", depth + 1);
        dfs(result + "I", depth + 1);
        dfs(result + "O", depth + 1);
        dfs(result + "U", depth + 1);
    }
}
