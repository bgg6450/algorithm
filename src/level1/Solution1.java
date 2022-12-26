package level1;

import java.util.*;

// 신고 결과 받기
public class Solution1 {
    public List<Integer> solution(String[] id_list, String[] report, int k) {

//        List<String> newReport = new ArrayList<>();
//        for (String a : report) {
//            if (!newReport.contains(a)) {
//                newReport.add(a);
//            }
//        }

        HashSet<String> newReport = new HashSet<>();
        Collections.addAll(newReport, report);

        HashMap<String, Integer> reportCountByUser = new HashMap<>();
        HashMap<String, List<String>> reportListByUser = new HashMap<>();

        for (String a : id_list) {
            reportCountByUser.put(a, 0);
            reportListByUser.put(a, new ArrayList<>());
        }

        for (String a : newReport) {
            reportListByUser.get(a.split(" ")[0]).add(a.split(" ")[1]);
            reportCountByUser.put(a.split(" ")[1], reportCountByUser.get(a.split(" ")[1])+1);
        }

        List<String> banList = new ArrayList<>();
        for (String a : id_list) {
            if (reportCountByUser.get(a) >= k) {
                banList.add(a);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (String a : id_list) {
            int i = 0;
            for (String b : reportListByUser.get(a)) {
                if (banList.contains(b)) {
                    i++;
                }
            }
            answer.add(i);
        }
        return answer;
    }
}
