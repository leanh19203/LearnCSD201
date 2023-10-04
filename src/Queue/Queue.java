/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;
import java.util.LinkedList;
/**
 *
 * @author Admin
 */
public class Queue {
    LinkedList<Node> q = new LinkedList<Node>();
    public  boolean isEmpty(){
        return q.isEmpty();
    }
    public void  Queue (Node p){
        if(p!=null)
            q.addFirst(p);
        
    }
    public Node Dequeue(){//lay 1 phan tu ra khoi hang doi
        Node p =null;
        if(isEmpty()){
            p=q.getLast();
            q.removeLast();
        }return p;
    }
    public  Node visit(){
        Node p =null;
        if(!isEmpty()){
            p=q.getLast();
        }return p;
    }
                   
}
