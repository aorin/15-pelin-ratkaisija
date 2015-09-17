package solver.logic.dataStructures;

/**
 * Luokka määrittelee käsitteen solmu.
 * @param <T> Solmun avain
 * @param <E> Solmun arvo
 */
public class Node<T, E> {
    private T key;
    private E value;
    private int height;
    private Node parent, leftChild, rightChild;
    
    public Node(T key, E value) {
        this.key = key;
        this.value = value;
    }
    
    public Node left() {
        return this.leftChild;
    }
    
    public Node right() {
        return this.rightChild;
    }
    
    public Node parent() {
        return this.parent;
    }
    
    public void setLeft(Node left) {
        this.leftChild = left;
    }
    
    public void setRight(Node right) {
        this.rightChild = right;
    }
    
    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    public int height() {
        return this.height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
}
