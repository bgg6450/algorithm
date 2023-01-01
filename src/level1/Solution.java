package level1;

import java.util.HashSet;

public class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> a = new HashSet<>();
        for (int i : nums) {
            a.add(i);
        }
        return Math.min(nums.length/2, a.size());
    }
}
