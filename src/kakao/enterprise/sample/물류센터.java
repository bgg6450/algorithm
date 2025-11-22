package kakao.enterprise.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

public class 물류센터 {
    //5
    //0 1 2
    //1 2 1
    //1 3 7
    //3 4 5
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int nodes = Integer.parseInt(input.split("\n")[0]);
        String[] parsedInput = input.split("\n");
        int[][] nodesArr = new int[3][nodes];

        for (int i = 1; i < nodes; i++) {
            String[] node = parsedInput[i].split(" ");
            int node1 = Integer.parseInt(node[0]);
            int node2 = Integer.parseInt(node[1]);
            int dist = Integer.parseInt(node[2]);

            if (node1 > node2) {
                nodesArr[i - 1][0] = node1;
                nodesArr[i - 1][1] = node2;
            } else {
                nodesArr[i - 1][0] = node2;
                nodesArr[i - 1][1] = node1;
            }
            nodesArr[i - 1][2] = dist;
        }

        System.out.println("Hello Goorm! Your input is " + input);
    }

    public static class Node {
        private int current;
        private Set<Node> neighbors;
    }
}
