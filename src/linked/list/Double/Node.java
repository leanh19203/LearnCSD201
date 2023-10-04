/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list.Double;

/**
 *
 * @author Admin
 */
public class Node {
    Book info;
    Node next;
    Node pre; //khac so voi singgle linklist

    public Node() {
    }

    public Node(Book info, Node next, Node pre) {
        this.info = info;
        this.next = next;
        this.pre = pre;
    }

 
}
