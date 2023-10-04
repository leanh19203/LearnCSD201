/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        Book x1 = new Book("sach lap trinh", 100); s.push(x1);
        x1 = new Book("sach data", 120); s.push(x1);
        x1 = new Book("sach nhat 1", 40); s.push(x1);
        x1 = new Book("sach lab", 90); s.push(x1);
        Book x2 = null;
        x2=s.pop();
        x2=s.top();
        System.out.println(x1);
        System.out.println(x2);
        
    }
}
