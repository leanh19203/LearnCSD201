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
public class Main {
    public static void main(String[] args) {
        Queue  q= new Queue();
        Node p = new Node(new Book("Prf192", 300),null); q.Queue(p);
        p = new Node(new Book("Pro192", 400),null); q.Queue(p);
        p = new Node(new Book("DBI202", 200),null); q.Queue(p);
        p = new Node(new Book("LAB201", 500),null); q.Queue(p);
        p=q.visit();
        System.out.println(p.info.toString());
        System.out.println("");
        q.Dequeue();
        p=q.visit();
        System.out.println(p.info.toString());
    }
            
}
