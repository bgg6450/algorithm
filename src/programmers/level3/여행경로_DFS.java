package programmers.level3;

import java.util.*;
import java.util.stream.Collectors;

public class 여행경로_DFS {

    public String[] solution(String[][] tickets) {
        List<String[]> fromIcn = new ArrayList<>();
        for (String[] ticket : tickets) {
            if (ticket[0].equals("ICN") && !fromIcn.contains(ticket)) {
                fromIcn.add(ticket);
            }
        }

        List<List<String>> answer = new ArrayList<>();
        for (String[] strings : fromIcn) {
            List<String> result = new ArrayList<>();
            result.add(strings[0]);
            result.add(strings[1]);
            answer.add(dfs(strings, Arrays.stream(tickets).collect(Collectors.toList()), result));
        }
        return answer.stream()
                .sorted(Comparator.comparing(list -> String.join("", list)))
                .findFirst()
                .orElse(Collections.emptyList())
                .toArray(new String[0]);
    }

    private List<String> dfs(String[] begin, List<String[]> tickets, List<String> result) {
        if (tickets.isEmpty()) {
            return result;
        }
        tickets.remove(begin);
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i)[0].equals(begin[1])) {
                result.add(tickets.get(i)[1]);
                dfs(tickets.get(i), tickets, result);
            }
        }
        return result;
    }
}
