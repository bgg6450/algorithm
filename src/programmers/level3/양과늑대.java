package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class 양과늑대 {

    static List<Node> nodes = new ArrayList<>();
    static int result = 0;
    static int maxLambs = 0;

    public int solution(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            if (info[i] == 0) {
                maxLambs += 1;
            }
            Node node = new Node(i, info[i]);
            nodes.add(node);
        }

        for (int[] edge : edges) {
            int parentNode = edge[0];
            int childNode = edge[1];
            Node node1 = nodes.get(parentNode);
            node1.addChildNode(childNode);
            Node node2 = nodes.get(childNode);
            node2.setParentNode(parentNode);
        }

        if (nodes.get(0).childNodes.size() == 2) {
            List<Integer> childNodes = nodes.get(0).childNodes;
            Integer node1 = childNodes.get(0);
            Integer node2 = childNodes.get(1);
            return dfs(node1, 1, 0) + dfs(node2, 1, 0) + 1;
        }
        return dfs(0, 0, 0);
    }

    int dfs(int currentNode, int lambs, int wolves) {
        Node node = nodes.get(currentNode);
        int info = node.info;

        if (info == 0) {
            lambs += 1;
        } else {
            wolves += 1;
        }

        if (wolves < lambs && lambs < maxLambs) {
            result = Math.max(result, lambs);
            List<Integer> childNodes = node.getChildNodes();
            for (Integer childNode : childNodes) {
                dfs(childNode, lambs, wolves);
            }
        }
        return result;
    }

    static class Node {
        int parentNode;
        int currentNode;
        List<Integer> childNodes;
        int info;

        void addChildNode(int childNode) {
            childNodes.add(childNode);
        }

        List<Integer> getChildNodes() {
            return childNodes;
        }

        void setParentNode(int parentNode) {
            this.parentNode = parentNode;
        }

        Node(int currentNode, int info) {
            this.currentNode = currentNode;
            this.info = info;
            this.childNodes = new ArrayList<>();
        }
    }
}
