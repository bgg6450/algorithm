package level1;

import java.util.HashSet;

// 폰켓몬
public class Solution6 {
    public int solution(int[] nums) {
        HashSet<Integer> a = new HashSet<>();
        for (int i : nums) {
            a.add(i);
        }
        return Math.min(nums.length/2, a.size());
    }
}
