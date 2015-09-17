package solver.logic.dataStructures;

import java.util.HashMap;

/**
 * Toteutus AVL puu-tietorakenteesta.
 * @param <T> Solmun avain
 * @param <E> Solmun arvo
 */
public class AVLTree<T, E> {

    private HashMap<T, E> valiaikainenMap;

    public AVLTree() {
        valiaikainenMap = new HashMap<>();
    }

    public void put(T key, E value) {
        valiaikainenMap.put(key, value);
    }

    public E get(T key) {
        return valiaikainenMap.get(key);
    }
    
    private void insert() {
        
    }

    private Node rightRotate(Node n1) {
        Node n2 = n1.left();
        n2.setParent(n1.parent());
        n1.setParent(n2);
        n1.setLeft(n2.right());
        n2.setRight(n1);
        if (n1.left() != null) {
            n1.left().setParent(n1);
        }
        n1.setHeight(Math.max(n1.left().height(), n1.right().height() + 1));
        n2.setHeight(Math.max(n2.left().height(), n2.right().height() + 1));
        return n2;
    }

    private Node leftRotate(Node n1) {
        Node n2 = n1.right();
        n2.setParent(n1.parent());
        n1.setParent(n2);
        n1.setRight(n2.left());
        n2.setLeft(n1);
        if (n1.right() != null) {
            n1.right().setParent(n1);
        }
        n1.setHeight(Math.max(n1.left().height(), n1.right().height() + 1));
        n2.setHeight(Math.max(n2.left().height(), n2.right().height() + 1));
        return n2;
    }

    private Node RightLeftRotate(Node n1) {
        Node n2 = n1.right();
        n1.setRight(rightRotate(n2));
        return leftRotate(n1);
    }

    private Node LeftRightRotate(Node n1) {
        Node n2 = n1.right();
        n1.setRight(leftRotate(n2));
        return rightRotate(n1);
    }
}
