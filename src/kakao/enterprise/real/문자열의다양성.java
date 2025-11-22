package kakao.enterprise.real;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열의다양성 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        for (int i = 1; i < 27; i++) {

            int[] freq = new int[26];
            int distinct = 0, left = 0, maxLen = 0;

            for (int right = 0; right < S.length; right++) {
                int r = S[right] - 'a';
                if (freq[r] == 0) {
                    distinct++;
                }
                freq[r]++;

                while (distinct > i) {
                    int l = S[left++] - 'a';
                    freq[l]--;
                    if (freq[l] == 0) {
                        distinct--;
                    }
                }

                if (distinct == i) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
            }
            System.out.println(maxLen);
        }
    }
}
