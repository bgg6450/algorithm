package practice.datastructure;

public class BinaryTree<T> {
    private BinaryTree<T> leftNode;
    private BinaryTree<T> rightNode;
    private final T element;

    public BinaryTree(T element) {
        this.element = element;
    }

    public BinaryTree(BinaryTree<T> leftNode, BinaryTree<T> rightNode, T element) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.element = element;
    }

    public BinaryTree<T> getLeftNode() {
        return this.leftNode;
    }

    public BinaryTree<T> getRightNode() {
        return this.rightNode;
    }

    public T getElement() {
        return this.element;
    }

    public boolean hasLeft() {
        return leftNode != null;
    }

    public boolean hasRight() {
        return rightNode != null;
    }
}
