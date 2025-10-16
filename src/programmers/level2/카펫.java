package programmers.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for (int i = 3; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                int x = total / i;
                int y = total / x;
                if ((2*x + (y-2)*2) == brown) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{};
    }
}
