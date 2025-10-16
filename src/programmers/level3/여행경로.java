package programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

public class 여행경로 {
    List<List<String>> results = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        result.add("ICN");
        dfs(Arrays.stream(tickets).collect(Collectors.toList()), tickets.length + 1, result);

        Collections.sort(results, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        return results.get(0).toArray(new String[0]);
    }

    void dfs(List<String[]> tickets, int target, List<String> result) {
        if (result.size() == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i)[0].equals(result.get(result.size()-1))) {
                result.add(tickets.get(i)[1]);
                List<String[]> newTickets = new ArrayList<>(tickets);
                newTickets.remove(i);
                dfs(newTickets, target, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
