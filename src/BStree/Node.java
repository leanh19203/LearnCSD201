/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BStree;

/**
 *
 * @author Admin
 */
public class Node {
    Car info;
    Node Left=null, right = null;

    public Node(Car info,Node Left, Node right) {
        this.info = info;
        this.Left = Left;
        this.right =right;
    }
    public Node(){
        
    }
}
