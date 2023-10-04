/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Admin
 */
public class Node {
    Book info;
    Node next;

    public Node() {
    }

    public Node(Book info, Node next) {
        this.info = info;
        this.next = next;
    }
}
