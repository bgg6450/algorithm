import level1.Solution;

import java.util.ArrayList;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        int[] a = {9, 20, 28, 18, 11};
        int[] b = {30, 1, 21, 17, 28};
        List<String> c = new ArrayList<>();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        c.add("e");
        for (int i = 0; i< 5; i++) {
            System.out.println(a[i] | b[i]);
        }
    }
}