/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree;

/**
 *
 * @author SIEU THI SO 4G
 */
import java.util.LinkedList;
public class Queue {
    LinkedList<Node> Q= new LinkedList<Node>();
    public boolean isEmpty(){
        return Q.isEmpty();
    }
    public void enQueue(Node p){ // them vao hang doi 1 node
        if(p!=null)Q.addFirst(p);
    }
    public Node deQueue(){ // lay 1 phan tu ra khoi hang doi
        Node p=null;
        if(!isEmpty()){
            p=Q.getLast();
            Q.removeLast();
        }   
        return p;
    }
    public Node visit(){ // tham node o dau hang doi
        Node p=null;
        if(!isEmpty()){
            p=Q.getLast();
        }   
        return p;
    }
}