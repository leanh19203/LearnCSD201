/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked.list.Double;


/**
 *
 * @author Admin
 */
public class Mylist {
Node head=null,tail=null,p=null;
    boolean isEmpty(){
        return (head==null); // phep ss head==null tra ve true/false
    }
    void Insert(String aTitle, int aPrice){
        if(aTitle.charAt(0)=='B' || aPrice>100)return;
        AddFirst(aTitle, aPrice);
    }
    void AddFirst(String aTitle, int aPrice){
        Book b= new Book(aTitle, aPrice);
        Node moi = new Node(b, null,null);// info la b, next chua gan
        if(isEmpty()){
            head=moi;tail=moi;tail.next=null; head.pre=null;
        }else{              // neu LinkedList da co 1 not tro len
            moi.next=head; // node moi.next = head hien tai
            head.pre=moi;// preview cua head hien tai thi bang node moi
            head=moi;
        }
    }  
    void AddFirst(Book aBook){
        Node moi = new Node(aBook, null,null);// info la b, next chua gan
        if(isEmpty()){
            head=moi;tail=moi;tail.next=null; head.pre=null;
        }else{              // neu LinkedList da co 1 not tro len
            moi.next=head; // node moi.next = head hien tai
            head.pre=moi;// preview cua head hien tai thi bang node moi
            head=moi;
        }
    }
    void AddFirst(Node moi){
        if(isEmpty()){
            head=moi;tail=moi;tail.next=null; head.pre=null;
        }else{              // neu LinkedList da co 1 not tro len
            moi.next=head; // node moi.next = head hien tai
            head.pre=moi;// preview cua head hien tai thi bang node moi
            head=moi;
        }
    }
    void AddLast(String aTitle, int aPrice){
        Book b= new Book(aTitle, aPrice);
        Node p = new Node(b, null,null);// info la b, next chua gan
        if(isEmpty()){
            head=p;tail=p;tail.next=null; head.pre=null;
        }else{              // neu LinkedList da co 1 not tro len
            tail.next=p; p.pre=tail;
            tail=p;
        }
    }  
    void AddLast(Book b){
        Node p = new Node(b, null,null);// info la b, next chua gan
        if(isEmpty()){
            head=p;tail=p;tail.next=null; head.pre=null;
        }else{              // neu LinkedList da co 1 not tro len
            tail.next=p; p.pre=tail;
            tail=p;
        }
    }
    void AddLast(Node p){
        if(isEmpty()){
            head=p;tail=p;tail.next=null; head.pre=null;
        }else{              // neu LinkedList da co 1 not tro len
            tail.next=p; p.pre=tail;
            tail=p;
        }
    }
    void Printout(int from){ // 0 in ra tu Head, 1 in ra nguoc tu tail
        if(isEmpty())System.out.println("List is empty");
        else{
            if(from==0){
            Node p=head;
            while(p!= null){
                System.out.print(p.info.toString());
                p=p.next;
            }}
            else{
               Node p=tail;
            while(p!= null){
                System.out.print(p.info.toString());
                p=p.pre;
            }}
        }
    }
    void f1(String xTitle, int xPrice){ // chen vao sau node price max dau
        Node max=head, p=head;
        while(p!=null){
            if(max.info.price<p.info.price) max=p; // thay < bawng <= de tim node max cuoi
            p=p.next;
        }
        Node moi= new Node(new Book(xTitle,xPrice),null,null); 
        moi.next=max.next;
        moi.pre=max;
    }
    int Length() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;

        }
        return count;
    }
    void f2(){
       int mid=Length()/2,count=0;
        Node p=head,start=null;
        while(count!=mid){
            count++;p=p.next;
        }
        start=p.pre.pre;
        for(int i=0;i<4;i++){
            Node q=start.next;
            for(int k=i+1;k<5;k++){
                if(start.info.price>q.info.price){
                    Book tmp=start.info;
                    start.info=q.info;
                    q.info=tmp;
                }q=q.next;
                }start=start.next;
    }
    }
    // tìm node co title dai nhat roi chuyen qua vi tri len sau node head
//    void f3() {
//    if (isEmpty()) {
//        System.out.println("List is empty");
//        return;
//    }
//
//    // Find the node with the longest title
//    Node Max = head;
//    Node p = head;
//
//    while (p != null) {
//        if (Max.info.getTitle().length() < p.info.getTitle().length() ) {
//            Max = p;
//        }
//        p = p.next;
//    }
//
//    // Remove the longest title node from its p position
//    if (Max == head) {
//        head = head.next;
//        if (head != null) {
//            head.pre = null;
//        }
//    } else {
//        Max.pre.next = Max.next;
//        if (Max.next != null) {
//            Max.next.pre = Max.pre;
//        }
//    }
//
//    // Insert the longest title node immediately after the head
//    Max.next = head.next;
//    if (head.next != null) {
//        head.next.pre = Max;
//    }
//    head.next = Max;
//    Max.pre = head;
//}
void f3(){
            Node Max=head,p=head;
            while(p!=null){
                if(Max.info.title.length()<p.info.title.length()) Max=p;p=p.next;
            }
            if((Max==head)) DelHead();else if(Max==tail) DelTail();
            else{
                p=head;
                while(p!=null){
                    if(p==Max)break;
                    p=p.next;
                }Node truoc=p.pre,sau=p.next;
                truoc.next=sau;sau.pre=truoc;
                Max.next=head.next;head.next.pre=Max;
                head.next=Max;Max.pre=head;
            }
        }
//    void InsertAti(String xTitle, int xPrice, int pos){
//        int start=1;    //pos la vi tri can chen
//        if(pos<0)return;
//        Node p=head,q=head;
//        while(p!=null && start!=pos){// 1. lap duyet linked lisst
//            q=p; p=p.next;
//            start++;
//        }//2. Chen
//        if(start==pos){ //GSu Neu pos=1 thi chen o Head, hoac null
//            if(pos==1)AddFirst(xTitle, xPrice);// 0 co vi tri pos trong list thi
//            else if(p==null)AddLast(xTitle, xPrice);//chen o cuoi
//            else{
//                Node n= new Node(new Book(xTitle, xPrice), head);
//                q.next=n;
//                n.next=p;
//            }
//        }
//    }
    void DelHead(){
        if(isEmpty())return;
        if(head==tail) head=tail=null;//list chi co 1 node
        else{
            head=head.next;head=tail=null;// head duoc gan = node thu 2
        }
    }
    void DelTail(){
        if(isEmpty())return;
        if(head==tail) head=tail=null;//list chi co 1 node
        else{ //1. Duyet toi node tail
            Node p=head,q=head;
            while(p!=tail){
                q=p; p=p.next;
            }//2. Xoa node p
            tail=q; q.next=null;
        }
    }
// Xoa node co price Max
    void DelNodeMaxPrice(int pos){//b1 pos la vi tri max thu max thu? can xoa
        Node max=head,p=head,q=null;int count=0;
        while(p.next!=null){ // tim max
            if(p.info.price ==80 ){  //> max.info.price //max
                max=p;
            }p=p.next;
        } 
        p=head;
        while(p!=null){
            if(p.info.price==max.info.price){
                //DelAti(p);//xoa pt dau thi goi luon 
                count++;                    //xoa pt max thu pos
                if(count==pos) DelAti(p);   //xoa pt max thu pos
                //q=p;   //o cuoi
            }p=p.next;
        }  //DelAti(q);//o cuoi
    }
    void DelAti(Node p){
        if(p==head) DelHead();
        else if(p==tail)DelTail();
        else{ //Duyet tim toi node p
            Node q=head,k=head;
            while(k!=p){
                q=k;k=k.next;
            }// Xoa
            q.next=k.next;
        }
    }
    // Xoa node thu 2 co price =80
    void SortbyPriceASC(){
        Node p=head,q;
        while(p.next!=null){
            q=p.next;
            while(q!=null){
                if(q.info.price<p.info.price){
                    Book tmp=q.info;    q.info=p.info; p.info=tmp;
                }q=q.next;
            }p=p.next;
        }
    }
    // Xoa node thu 2 co price =80
    void Sort5byPriceDSC(){
        Node p=head,q;int count=0;
        while(count<5){
            q=p.next; int qc=count+1;
            while(qc<5){
                if(q.info.price>p.info.price){
                    Book tmp=q.info;    q.info=p.info; p.info=tmp;
                }q=q.next;qc++;
            }count++;p=p.next;
        }
    }
}

