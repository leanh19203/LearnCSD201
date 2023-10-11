/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import javafx.scene.AccessibleAttribute;

/**
 *
 * @author Admin
 */
public class MyGraph {
    int N;// so luong dinh trong do thi
    int[][] E; //ma tran lien ket(ma tran ke)hoac ma tran khoang cach
    char[] V = "ABCEFGHIJKLMNHOPQRSTUVMXYZ".toCharArray();//khai bao cac dinh string

    public MyGraph() {
    }

    public MyGraph(int n, int[][] E) {//khoi dung ma tran truyen tham so so dinh ma tran
        this.N = n;
        this.E = E;
    }//f1 duyen do thi theo chieu sau hoac chieu rong breadth
    // duyen do thi theo chieu sau depth hoac chieu rong breadth va theo 1 yeu cau khac
    //dua k vao queue--> lay ra, visit -->tao vong for qua ma tran e tim e(k)(i)!=0-->queue rong thi dừng
    public void Breadth(int k, boolean[] visited ){//duyen do thi theo chieu rong xuat phat tu diem k
        Queue q = new Queue();
        q.enQueue(k);
        while(!q.isEmpty()){
           visit(k);
           for(int i =0;i<N;i++){
               if(visited[i]==false && E[k][i]>0){
                   q.enQueue(i);
               }
           }
        }
    }
    public void visit(int x){
        System.out.println(""+ V[x]);
    }
   
}
