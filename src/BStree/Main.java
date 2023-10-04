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
public class Main {

    public static void main(String[] args) {
        BStree myBSTree = new BStree();
        myBSTree.insert("CXB", "Trang", 100);
        myBSTree.insert("CX5", "den", 90);
        myBSTree.insert("CX3", "do", 110);
        myBSTree.insert("Crv", "Trang", 80);
        myBSTree.insert("Civic", "den", 98);
        myBSTree.insert("City", "Trang", 105);
        myBSTree.insert("hrv", "den", 120);
        myBSTree.insert("ForEv1", "den", 85);
        myBSTree.insert("ForEv2", "den", 102);
        myBSTree.insert("ForEv3", "den", 115);
        myBSTree.insert("ForEv4", "den", 150);
        myBSTree.insert("ForEv5", "den", 82);
        myBSTree.insert("ForEv6", "den", 87);
        myBSTree.insert("ForEv7", "den", 86);
        System.out.println("Pre_order:");
        myBSTree.pre_order(myBSTree.root);
        System.out.println("");
        System.out.println("Post_order:");
        myBSTree.post_order(myBSTree.root);
        System.out.println("");
        System.out.println("in_order:");
        myBSTree.in_order(myBSTree.root);
        System.out.println("");
        System.out.println("in_order:");
        myBSTree.BreadthFirst(myBSTree.root);
        System.out.println("");
        System.out.println("f1:");
        myBSTree.f1(myBSTree.root);
        System.out.println("");
        System.out.println("f2:");
        myBSTree.f2(myBSTree.root);
        System.out.println("");
        System.out.println("f3:");
        myBSTree.f3(myBSTree.root);
        System.out.println("");
        System.out.println("f4:");
        myBSTree.f4(myBSTree.root);
        System.out.println("");
        System.out.println("Before deletebycopy");myBSTree.BreadthFirst(myBSTree.root);
        myBSTree.DelbyCopy(100);
        System.out.println("");
        System.out.println("After deletebycopy:");myBSTree.BreadthFirst(myBSTree.root);
        System.out.println("");
        System.out.println("lever node");
        System.out.println(myBSTree.LevelOfNode(myBSTree.SearchNodebyprice(90)));
        System.out.println("");
        System.out.println("Before deletebymerge");myBSTree.BreadthFirst(myBSTree.root);
        myBSTree.DelByMerge(myBSTree.SearchNodebyprice(110));
        System.out.println("");
        System.out.println("After deletebymerge:");myBSTree.BreadthFirst(myBSTree.root);
        

    }
}
        
  
