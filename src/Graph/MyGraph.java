/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;


/**
 *
 * @author Admin
 */
public class MyGraph {
    int N;// so luong dinh trong do thi
    int[][] E; //ma tran lien ket(ma tran ke)hoac ma tran khoang cach
    char[] V = "ABCEFGHIJKLMNHOPQRSTUVMXYZ".toCharArray();//khai bao cac dinh string
    int [] deg = new int[N];// mang luu bac cua dinh
    public MyGraph() {
    }
    public  void  Degree(){
        deg = new int[N];
        for (int i = 0; i < N; i++) {
            int dem = 0;
            for (int k = 0; k < N; k++) {
                if(E[i][k]!=0){
                    dem++;
                }
            }
            deg[i]=dem;
        }
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
            int x=q.deQueue();
           visit(x);
           for(int i =0;i<N;i++){
               if(visited[i]==false && E[k][i]>0){
                   q.enQueue(i);
                   visited[i] = true;
               }
           }
        }
    }
    public void visit(int x){// tham dinh x
        System.out.print(" "+ V[x]);// hien ra chu cai voi dinh thu i
    }
    
    public  void breadth(int k){
        boolean[] visited = new boolean[N];
        for(int i = 0; i<N; i++){
            visited[i]=false; 
        }
         Breadth(k, visited);
         for(int i =0; i<N;i++){
             if(visited[i]==false)
                 Breadth(i, visited);
         }
    }//duyet theo chieu sau xuat phat tu
    public void Depth(int k, boolean [] visited){
        visit(k);
        visited[k]= true;
        for(int i = 0;i < N;i++){
            if(E[k][i]!=0&& visited[i]==false){
                Depth(i, visited);
            }
                
        }
    }// dam bao duyet den tat ca cac dinh trong do thi
    public void Depth(int k){
        boolean[] visited =new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i]=false;
        }
        Depth(k, visited);
        for (int i = 0; i < N; i++) {
            if(visited[i]==false){
                Depth(k, visited);
            }
        }
    }
     //duyet theo chieu sau xuat phat tu
    int count = 0;
    public void Depth2(int k, boolean [] visited){
        count++;
        if(count>1&&count<8){
          visit(k);  
        }
        visited[k]= true;
        for(int i = 0;i < N;i++){
            if(E[k][i]!=0&& visited[i]==false){
                Depth(i, visited);
            }
                
        }
    }// dam bao duyet den tat ca cac dinh trong do thi
  
    public void Depth2(int k){
        boolean[] visited =new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i]=false;
        }
        Depth2(k, visited);
        for (int i = 0; i < N; i++) {
            if(visited[i]==false){
                Depth2(i, visited);
            }
        }
    }
    public void visit2(int x){//tham dinh x
        System.out.print(" "+ V[x]+"("+deg[x]+")");//hien ra chu cai voi dinh thu i
    }
     public void Depth3(int k,boolean[]visited){
          count++;
          visit2(k);
         if(count>1&&count<8){
        visit(k);}
        visited[k]=true;
        for (int i = 0; i < N; i++) {
            if(E[k][i]!=0&& visited[i]==false)
                Depth3(i, visited);
        }
    }//dam bao duyet de tat ca cac dinh trong do thi
    public void Depth3(int k){
        Degree();//tinh bac cua tat ca ca dinh
        boolean[] visited =new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i]=false;
        }
        Depth3(k, visited);
        for (int i = 0; i < N; i++) {
            if(visited[i]==false){
                Depth3(i, visited);
            }
        }
    }
}
