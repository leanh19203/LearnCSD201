/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list;

/**
 *
 * @author Admin
 */
public class book {
    String title;
    int price;

    public book() {
    }

    public book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[" + title + ", " + price + ']';
    }
    
}
