package level1;

public class Solution8 {
    public static int solution(int a, int b, int n) {
        int s = 0;
        while (n >= a) {
            s += n / a * b;
            n = (n / a) * b + (n % a);
        }
        return s;
    }
}
