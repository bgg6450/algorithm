import level1.Solution;
import level1.Solution8;

import java.util.ArrayList;
import java.util.List;

public class Hello {
    public static void main(String[] args) {
        String s = "1T*2D#3D";
        String s0 = s.split("[0-9][SDT]")[0];
        String s1 = s.split("[0-9][SDT]")[1];
        String s2 = s.split("[0-9][SDT]")[2];
        String s3 = s.split("[0-9][SDT]")[3];
        System.out.println(s0);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}