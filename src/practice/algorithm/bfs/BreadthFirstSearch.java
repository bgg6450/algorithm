package practice.algorithm.bfs;

import practice.datastructure.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch<T> {

    public void search(BinaryTree<Integer> node) {
        Queue<BinaryTree<Integer>> queue = new ArrayDeque<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BinaryTree<Integer> current = queue.poll();
            System.out.printf("node: %s", current.getElement());

            if (current.hasLeft()) {
                queue.add(current.getLeftNode());
            }

            if (current.hasRight()) {
                queue.add(current.getRightNode());
            }
        }
    }
}
