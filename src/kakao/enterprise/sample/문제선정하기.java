package kakao.enterprise.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 문제선정하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        List<Integer> levels = Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> count = new ArrayList<>();
        for (Integer level : levels) {
            if (!count.contains(level)) {
                count.add(level);
            }
        }

        if (count.size() >= 3) {
            System.out.println("Y E S");
        } else System.out.println("N O");

        br.close();
    }
}
