/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list.Double;

import linked.list.*;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Mylist M= new Mylist();
        M.Insert("MAD201 ", 80);M.Insert("PRF192 ", 50);M.Insert("DBI202 ", 20);
        M.Insert("LAB201 OOP", 90);M.Insert("JPD113", 40);
        M.Insert("PRN 211", 100);
        M.Printout(0);
        System.out.println("");
        M.f1("CDX", 33);System.out.print("F1: ");M.Printout(0);
        System.out.println("");
        M.f2();System.out.print("F2: ");M.Printout(0);
        System.out.println("");
        M.f3();System.out.print("F3: ");M.Printout(0);
//        M.InsertAti("OSG 202", 66, 3);
//        //M.DelNodeMaxPrice(2);
//        M.Printout();
//        M.Sort5byPriceDSC(); System.out.println("");
//        M.Printout();
    }    
}
