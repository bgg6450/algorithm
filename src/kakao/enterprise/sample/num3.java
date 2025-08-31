package kakao.enterprise.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class num3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] S = br.readLine().split("");

        List<Integer> totalResult = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            Set<String> characters = new HashSet<>();
            StringBuilder part = new StringBuilder();
            List<Integer> result = new ArrayList<>();

            for (int j = 0; j < S.length-i; j++) {
                characters.add(S[j]);
                if (characters.size() > i+1) {
                    result.add(part.length());
                    part = new StringBuilder();
                    characters = new HashSet<>();
                }
                part.append(S[j]);
            }

            Collections.sort(result);
            totalResult.add(result.get(result.size() - 1));
        }

        totalResult.forEach(System.out::println);
    }
}
