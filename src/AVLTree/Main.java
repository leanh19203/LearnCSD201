/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree;

/**
 *
 * @author 
 */
public class Main {
    public static void main(String[] args) {
        AVLTree t= new AVLTree();
        t.insert("CX8","trang", 100);   t.insert("CX5","den", 90);
        t.insert("CX3","do", 110);      t.insert("CRV","trang", 80);// trng->4
        t.insert("civic","den", 98);    t.insert("city","trang", 105);
        t.insert("hrv","den", 120);     t.insert("ForEV","den", 85);
        t.insert("hrv1","den", 102);    t.insert("hrv1","den", 107); t.insert("ForEV1","den", 115);
        t.insert("hrv2","den", 150);    t.insert("ForEV2","den", 82);
        t.insert("hrv3","den", 87);     t.insert("ForEV3","den", 86);
//      t.blanceTree(); t.BreadthFirst(t.root);
        t.LeftRotate(90); t.BreadthFirst(t.root);
        System.out.println("");
        t.RightRotate(90); t.BreadthFirst(t.root);
    }  
}
