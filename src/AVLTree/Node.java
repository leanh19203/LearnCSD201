
package AVLTree;


public class Node {
    Car info;
    Node left = null;
    Node right = null;

    public Node(Car info, Node left, Node right) {
        this.info = info;
        this.left=left;
        this.right=right;
    }
    public Node() {
    }    
}
