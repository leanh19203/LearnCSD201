/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;
import  java.util.LinkedList;
/**
 *
 * @author Admin
 */
public class Stack {
    LinkedList<Book> Stack = new LinkedList<Book>();
    public  void push (Book b){
        if( b!=null) Stack.addLast(b);//dua them 1 phan tu vao cuoi
    }
    public Book pop(){
        Book b=null;
        if(Stack.isEmpty()!=true){
            b=Stack.getLast();
            Stack.removeLast();
        }
        return b;
    }
    public Book top(){ //chi lay thong tin cua phan tu trong no
        Book b=null;
        if(Stack.isEmpty()!=true){
            b=Stack.getLast();
    }
        return b;
    }
}
