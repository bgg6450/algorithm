package practice.algorithm.dfs;

import practice.datastructure.BinaryTree;

public class DepthFirstSearch {

    public void preOrderTraversal(BinaryTree<Integer> node) {
        if (node!= null) {
            Integer element = node.getElement();
            System.out.printf("element: %d", element);
            preOrderTraversal(node.getLeftNode());
            preOrderTraversal(node.getRightNode());
        }
    }

    public void inOrderTraversal(BinaryTree<Integer> node) {
        if (node!= null) {
            Integer element = node.getElement();
            inOrderTraversal(node.getLeftNode());
            System.out.printf("element: %d", element);
            inOrderTraversal(node.getRightNode());
        }
    }

    public void postOrderTraversal(BinaryTree<Integer> node) {
        if (node!= null) {
            Integer element = node.getElement();
            postOrderTraversal(node.getLeftNode());
            postOrderTraversal(node.getRightNode());
            System.out.printf("element: %d", element);
        }
    }
}
