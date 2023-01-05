package level1;

// 다트 게임
public class Solution {
    public static int solution(String dartResult) {
        dartResult += "0S";
        int[] option = new int[3];
        String[] sum = new String[3];
        int result = 0;

        for (int i = 0; i < 3; i++) {
            sum[i] += dartResult.split("[0-9][SDT]")[i+1];
            option[i] += Integer.parseInt(String.valueOf(dartResult.replaceAll("[#*]", "").split("[SDT]")[i]));
        }

        for (int i = 0; i < 3; i++) {
            result += option[i] * Integer.parseInt(String.valueOf(sum[i].equals("*") ? 2 : sum[i].equals("#") ? -1 : 1));
        }
        return result;
    }
}

//    int result = 0;
//        int[] a = new int[3];
//        String s = dartResult.replaceAll("[0-9*#]", "")
//                .replace("S", "1")
//                .replace("D", "2")
//                .replace("T", "3");
//
//        System.out.println(s);
//
//        for (int i = 0; i < 3; i++) {
//            String x = dartResult.split("[SDT]")[i];
//            if (x.contains("*")) {
//                a[i] += Integer.parseInt(x.replace("*", "")) * 2;
//                if (i > 1) {
//                    a[i - 1] *= 2;
//                }
//            } else if (x.contains("#")){
//                a[i] += Integer.parseInt(x.replace("#", "")) * -1;
//            } else {
//                a[i] += Integer.parseInt(x);
//            }
//
//        }
//
//        for (int i : a) {
//            System.out.println(i);
//        }
//
//        for (int i = 0; i < 3; i++) {
//            result += Math.pow(a[i], Integer.parseInt(String.valueOf(s.charAt(i))));
//        }
//        return result;
