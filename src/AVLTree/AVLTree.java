/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree;
import java.util.*;
public class AVLTree {
    Node root=null;
    public boolean isEmpty(){//2
        return root==null;
    }// khai niem KEY la khoa dung de sap xep cay
    public void insert(Node p){ // coi KEY la price2
        if(isEmpty()) {root=p; return;} // neu rong thi cho goc =node p la xong
        else{ // b1 duyet cay de tim vi tri can chen
            Node c=root; // dung node d de duyet cay coi la node con
            Node f=null; // node nay chay phia tren luu node cha cua node c
            while(c!=null){
                if(p.info.price==c.info.price){// neu trung key thi 0 them
                    System.out.println("This price key is duplicate");return;
                }
                if(p.info.price>c.info.price){ // duyet sang ben phai cay
                    f=c; c=c.right;
                }else{
                    f=c; c=c.left;     // duyet sang trai
                }
            }// tim dc node f la node can gan node con moi
            if(p.info.price> f.info.price) f.right=p;
            else f.left=p;
        }
    }
    public void insert(Car c){//3
        if(c==null)return;
        Node p= new Node(c, null, null);
        insert(p);
    }
    public void insert(String xbrand, String xcolor, double xprice){//4
        Car c= new Car(xbrand, xcolor, xprice);
        insert(c);
    }
    public void visit(Node p){ // tham node p//5
        if(p!=null) System.out.print(p.info.toString());
    }
    public void pre_order(Node p){ //duyet truoc Goc-Trai-Phai//6
        if(p!=null){
            visit(p);
            pre_order(p.left); // lap lai viec tham cay con trai
            pre_order(p.right);// lap lai viec tham cay con phai
        }
    } 
    public void post_order(Node p){ // duyet sau: Trai - Phai - Goc//7
        if(p!=null){
            post_order(p.left); // lap lai viec tham cay con trai
            post_order(p.right);// lap lai viec tham cay con phai
            visit(p);
        }
    }//
    
    public void in_order(Node p){ // duyet Giua: Trai - Goc - Phai //8
        if(p!=null){
            in_order(p.left); // lap lai viec tham cay con trai
            visit(p);            
            in_order(p.right);// lap lai viec tham cay con phai
        }
    }
    public void BreadthFirst(Node p){//9
        if(p==null) return; 
        Queue q= new Queue();
        q.enQueue(p); // dua p vao trong queue;
        while(!q.isEmpty()){
           Node x= q.deQueue();  // lay node dau hang doi ra khoi queue
            visit(x);              // tham no = hien thong tin len
            if(x.left!=null) q.enQueue(x.left); // dua con trai vao queue
            if(x.right!=null) q.enQueue(x.right); // dua con phai vao queue
        }
    }
    public Node SearchNodebyPrice(int xPrice){ // tim 1 node trong cay theo key 10
        Node p=null, x=null;
        if(root==null) return p;
        p=root;
        while(p!=null){
            if(p.info.price==xPrice){ x=p; }
            if(xPrice<p.info.price) p=p.left;
            else p=p.right;
        }
        return x;
    }
    public int HightOfSubTree(Node p){ // dem chieu cao cay con tinh tu node pb 11
        if(p==null) return 0;
        if(p.left==null && p.right==null) return 1;
        else if(p.left!=null && p.right==null) return 1+ HightOfSubTree(p.left);
        else if(p.left==null && p.right!=null) return 1+ HightOfSubTree(p.right);
        else{
            if(HightOfSubTree(p.left)> HightOfSubTree(p.right)) return 1+ HightOfSubTree(p.left);
            else return 1+ HightOfSubTree(p.right);
        }
    }// b1. dap cay xay mang da sap xep
    public void toArray(ArrayList<Node> a, Node p){ // tinh tu node p
        if(p==null)return;
        else{
            toArray(a, p.left);
            a.add(p);
            toArray(a, p.right);
        } 
    }// b2 Xay lai cay moi
    public void blance(ArrayList<Node> a, int first, int last){
        int Mid=0;
        if(first>last) return; // thieu TB Base
        if(first<=last){
            Mid=(first+last)/2;
            Node x=a.get(Mid); // lay node tu arraylist
            x.left=null; x.right=null; // xoa lien ket cua tung node
            insert(x);// chen vao cay moi
        }
        blance(a,first,Mid-1);
        blance(a,Mid+1,last);
    }//b3 gop buoc 1, 2
   public void blanceTree(){
       ArrayList<Node>a= new ArrayList<Node>();
       toArray(a, root); // b1 day cay xay mang
       AVLTree newTree= new AVLTree();
       int first=0, last=a.size()-1; 
       newTree.blance(a, first, last);// b3 xay cay can bang new tree
       root=newTree.root; // ggan lai cho cay cu
   }//cay lech phai hoac con phai thi co the xoay sang trai
   // khi do con phai len lam cha con cha xuong lam con trai
   public  Node LRotate(Node pa){
       if(pa.right==null){
           return pa;
       }
       Node ch = pa.right;
       if(ch.left!=null)
           pa.right=ch.left;
           ch.left=pa;
           return ch;
   }
   public void LeftRotate(int xprice){// tim node can quay quay trai gan lai node cha
       if(root==null)return;
       Node p = root, f = null;
       while(p!=null&&p.info.price!=xprice){//tim toi node can xoay
           f=p;
           if(xprice<p.info.price)p=p.left;
           else p=p.right;
       }
       //b2 quay
       if(f==null)root=LRotate(p);
       else{
           if(f.left==p)f.left=LRotate(p);
           else f.right=LRotate(p);
       }
       
   }
   //cay lech trai hoac con trai thi co the xoay sang phai
   // khi do con trai len lam cha con cha xuong lam con phai
   public  Node RRotate(Node pa){
       if(pa.left==null){
           return pa;
       }
       Node ch = pa.left;
       if(ch.right!=null)
           pa.left=ch.right;
           ch.right=pa;
           return ch;
   }
    public void RightRotate(double xprice){// tim node can quay quay phai gan lai node cha
       if(root==null)return;
       Node p = root, f = null;
       while(p!=null&&p.info.price!=xprice){//tim toi node can xoay
           f=p;
           if(xprice<p.info.price)p=p.left;
           else p=p.right;
       }
       //b2 quay
       if(f==null)root=LRotate(p);
       else{
           if(f.left==p)f.left=RRotate(p);
           else f.right=RRotate(p);
       }
       
   }//quay ca trai vaf quay ca phai
    public  Node LR_Rotate(Node pa){
        if(pa.left.right==null){
            return pa;
        }
        pa.left = LRotate( pa.left);
        return RRotate(pa);
        
    }
    public void LeftRight_Rotate(double xPrice){
        if(isEmpty())return;
        Node pa=root, f=null;
        while(pa!=null&&pa.info.price!=xPrice){
            f=pa; //giu lai node cha truoc khi chuyen sang trai hoac phai
            if(xPrice<pa.info.price){
                pa=pa.left;
            }
            else {
                pa=pa.right;
            }
        }
        if(pa!= null){
            if(f.left==pa){
                f.left=LR_Rotate(pa);
            }
            else{
                f.left=LR_Rotate(pa);
            }
            
        }
       
    }
    public Node RL_Rotate(Node pa){
        if(pa.right.left==null)return pa;
        else{
            pa.right=RRotate(pa.right);
            return LRotate(pa);
        }
    }
    public void RightLeft_Rotate(double xPrice) {
        if (isEmpty()) {
            return; // cay 0 rong thi b1 di tim node co x price
        }
        Node pa = root, f = null;
        while (pa != null && pa.info.price != xPrice) {
            f = pa;
            if (xPrice < pa.info.price) {
                pa = pa.left;
            } else {
                pa = pa.right;
            }
        }// neu tim thay thi pa!=null
        if (pa != null) {
            if (f == null) {//pa can xoay chinh la node root
                root = RL_Rotate(pa);
            } else {//PA CAN XOAY KHONG PHAI ROOT
                if (f.left == pa) {
                    f.left = RL_Rotate(pa);
                } else {
                    f.right = RL_Rotate(pa);
                }
            }
        }
    }

// Can bang cay dung phep quay cay
    public void blance(Node p) {// p la node moi chen them hoac xoa di (xPrice)
        ArrayList<Node> a = new ArrayList<Node>(); // khai bao mot mang de phan ra cay
        Node q = root;
        while (q != p && q != null) { // tim toi node moi thme hoac xoa p
            a.add(q);
            if (p.info.price < q.info.price) {
                q = q.left;
            } else {
                q = q.right;
            }
        }// xa 1 nhanh cua cay ban dau vao trong mang a
        for (Node x : a) {// duyet qua cac node trong mang a
            int h = HightOfSubTree(x.left) - HightOfSubTree(x.right); // cao trai-phai
            if (h == 2) {// lech sang trai
                int L = HightOfSubTree(x.left.left) - HightOfSubTree(x.left.right);
                if (L == 1) {// lech trai hoan toan -> phai quay phai
                    RightRotate(x.info.price);
                } else if (L == -1) {// lech trai xong lech phai
                    LeftRight_Rotate(x.info.price);
                }
            } else if (h == -2) {
                int L = HightOfSubTree(x.right.left) - HightOfSubTree(x.left.right);
                if (L == -1) {// lech phai hoan toan -> phai quay phai
                    RightRotate(x.info.price);
                } else if (L == -1) {// lech trai xong lech trai
                    RightLeft_Rotate(x.info.price);
                }
            }
        }
    }

    public void InsertAVLTree(String brand, String color, double price) {
        Node p = new Node(new Car(brand, color, price), null, null);
        insert(p); // chen 1 node vao cay 
        blance(p); // chen xong lai di can bang
    }

}

