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
public class BStree {
    Node root = null;
    public boolean isEmpty(){
        return root == null;
    }// khai niem KEY la khoa dung de sap xep cay
    public void insert(Node p){ // coi KEY la price
        if(isEmpty()) {
            root = p; return; } // neu rong thi cho goc =node p la xong
        else{ //b1 duyet cay de tim vi tri can chen
            Node c=root; // dung node d de duyet cay coi la node con
            Node f=null; // node nay chay phia tren luu node cha cua node c
            while(c!=null){
                if(p.info.price==c.info.price){// neu trung key thi 0 them
                    System.out.println("This price key is dulicate"); return;
                }
                if(p.info.price>c.info.price){ // duyet sang ben phai cua cay
                    f = c; c = c.right;
                }else{
                    f=c;
                    c=c.Left; //duyet sang trai
                }
            }// tim dc node f la node can gan con moi
            if(p.info.price > f.info.price) f.right = p;
            else f.Left=p;
        }
    }
    public void insert(Car c){
        if(c==null) return;
        Node p = new Node(c, null, null);
        insert(p);
    }
    public void insert(String xbrand, String xcolor, double xprice){
        Car c = new Car(xbrand, xcolor, xprice);
        insert(c);
    }
    public void visit(Node p){ // tham node p
        if(p!=null){
            System.out.print(p.info.toString());
        }
    }
    public void pre_order(Node p){//duyet truoc Goc-Trai-Phai
        if(p!=null) {
            visit(p);
            pre_order(p.Left); // lap lai viec duyet tham cay con trai
            pre_order(p.right); // lap lai viec tham cay con phai
    }
} // viet ham main - chen vao 6 den 10 node - roi duyet lai pre_order
    public void post_order(Node p){
        if(p!=null) {
            post_order(p.Left); // lap lai viec duyet tham cay con trai
            post_order(p.right);
            visit(p);// lap lai viec tham cay con phai
    }// duyet sau: Trai - Phai - Goc
}
    public void in_order(Node p){ // duyet giua: trai - goc - phai
        if(p!=null) {
            in_order(p.Left);// lap lai viec duyet tham cay con trai
            visit(p);
            in_order(p.right);
    }
}
    public void BreadthFirst(Node p){
        if(p==null) return; Queue q = new Queue();
        q.enQueue(p); // dua p vao trong queue
        while(!q.isEmpty()){
            Node x = q.deQueue(); //lay node dau hang doi ra khoi queue
            visit(x);       // tham no = hien thong tin len
            if(x.Left!=null) q.enQueue(x.Left); // dua con trai vao queue
            if(x.right!=null) q.enQueue(x.right); // dua con phai vao queue
        }       
    }
    
   public void f1(Node p) {
    if (p != null) {
        if ((p.Left != null || p.right != null) && p.Left != null) { // Kiểm tra nút có ít nhất một nút con trái
            visit(p);
        }
        f1(p.Left); // Lặp lại việc duyệt cây con trái
        f1(p.right); // Lặp lại việc duyệt cây con phải
    }
}

   public void f2(Node p) {
    if (p != null) {
        f2(p.Left); // Duyệt cây con trái
        f2(p.right); // Duyệt cây con phải
        
        if ((p.info.price >= 800) && (p.Left != null || p.right != null)) {
            System.out.println(p.info);
        }
    }
}
   public void f3(Node p){
       if(p==null) return; Queue q = new Queue();
       q.enQueue(p);
       while(!q.isEmpty()){
           Node x = q.deQueue();
           if(x.info.price <= 900 && x.right!=null) visit(x);
           if(x.Left!=null) q.enQueue(x.Left);
           if(x.right!=null) q.enQueue(x.right);
       }
   }
   
   // dung inorder in ra cac node co chu cai dau cua bran trong khoang tu A-F
   public void f4(Node p){
       if(p!=null) {
            f4(p.Left);// lap lai viec duyet tham cay con trai
            visit(p);
            f4(p.right);
            if (p.info.brand.startsWith("A") && p.info.brand.charAt(0) <= 'F') {
            System.out.println(p.info.brand); // In ra node thỏa mãn điều kiện
        }
    }
}

   public void DelByCopy(Node xNode){ //keyby price
        if(xNode==null || root==null) return;
        // b1. di tim vi tri node xNode bi xoa & tim cha cua no
        Node pa= root, fa=null;// pa se la node can xoa, fa la node cha cua no
        while(pa!=null){
            if(pa==xNode)break;
            fa=pa;// if(xNode.info.owner.equals(pa.info.owner)) keyby string
            if(xNode.info.price<pa.info.price) pa=pa.Left;
            else pa=pa.right;
        }// tim xong thay thi pa != null.=> b2 Xoa
        if(pa.Left==null && pa.right==null){ //TH1. pa la node leaf
            if(fa==null) root=null; // pa la goc. cay chi co 1 node
            else{ //pa la con trai cua node cha fa thi ngat fa.Left nc lai fa.right
                if(fa.Left==pa)fa.Left=null;
                else fa.right=null;      
            }
        }// TH2. Pa co con trai
        else if(pa.Left!=null && pa.right==null){
            if(fa==null) root=root.Left;// pa la goc.
            else{ // pa la con trai cua fa thi fa.Left = pa.Left
                if(fa.Left==pa)fa.Left=pa.Left;
                else fa.right=pa.Left;//pa la con phai cua fa
            }
        }// TH3. Pa co con phai
        else if(pa.Left==null && pa.right!=null){
            if(fa==null) root=root.right;// pa la goc.
            else{
                // pa la con trai cua fa thi fa.Left = pa.Left
                if(fa.Left==pa)fa.Left=pa.right;
                else fa.right=pa.right;//pa la con phai cua fa
            }
        }//TH4. Pa co 2 con. tim toi node phai nhat cua cay con trai cua pa
        // copy node do len pa va xoa node do di
        else if(pa.Left!=null && pa.right!=null){//b1 tim node con phai nhat
            Node rightmost=pa.Left, far=null; // far la cha cua rightmost
            while(rightmost.right!=null){
                far=rightmost; rightmost=rightmost.right;
            }// da tim dc rightmost va cha cua no far
            //b2. copy infor cua rightmost len pa
            pa.info=rightmost.info;// b3 Xoa rightmost di
            if(far==null){
                if(rightmost.Left!=null) pa.Left=rightmost.Left;
                else pa.Left=null;
            }else{
                if(rightmost.Left!=null) far.right=rightmost.Left;
                else far.right=null;
            }    
        }
    }
    public void DelbyCopy(int Price){
        Node xNode=root;
        while(xNode!=null){
            if(xNode.info.price==Price)break;
            if(Price<xNode.info.price)xNode=xNode.Left;
            else xNode=xNode.right;
        }
        if(xNode!=null)    DelByCopy(xNode);
    }
   int del1=0;Node delete=null;
   
    public void in_order2(Node p) {
        if (p != null) {
            in_order2(p.Left);
            if (p.info.price > 80 && p.Left != null && del1 == 0) {
                delete = p;
                del1++;
            }
            in_order2(p.right);
        }
    }

    public void d1() {
        in_order2(root);
        if (delete != null) {
            DelByCopy(delete);
        }
    }//d2 xoa node thu 2 theo post order co 2 con va price <120

    int del2 = 0;
    Node delete2 = null;

    public void post_order2(Node p) {
        if (p != null) {
            post_order2(p.Left); // lap lai viec duyet tham cay con trai
            post_order2(p.right);
            if (p.Left != null && p.right != null && p.info.price < 120) {
                del2++;
                if (del2 == 2) {
                    delete2 = p;
                }
            }
            visit(p);// lap lai viec tham cay con phai
        }// duyet sau: Trai - Phai - Goc
    }

    public void d2() {
        in_order2(root);
        if (delete2 != null) {
            DelByCopy(delete2);
        }
    }//d3 xoa node cuoi cung theo pre_order co con phai va price <=120
     //d4 node dau tien theo breadfirst 0 co con
    int del3 = 0;
Node delete3 = null;

    public void pre_order2(Node p) {
        if (p != null) {
            if (p.right != null && p.info.price <= 120) {
                del3++;
                delete3 = p;
            }
            pre_order2(p.Left);
            pre_order2(p.right);
            visit(p);
        }
    }

    public void d3() {
        pre_order2(root);
        if (delete3 != null) {
            DelByCopy(delete3);
        }
    }

// d4) Delete first node in breadth-first traversal with no children
    public void d4() {
        Queue q = new Queue();
        q.enQueue(root);
        while (!q.isEmpty()) {
            Node x = q.deQueue();
            if (x.Left == null && x.right == null) {
                DelByCopy(x);
                return;
            }
            if (x.Left != null) {
                q.enQueue(x.Left);
            }
            if (x.right != null) {
                q.enQueue(x.right);
            }
        }
    }
//fall 2022 f3 tim node thu 5 theo post_order, tinh so node do, gan cho thuoc tinh color
    int Count =0;
     public int CountNode (Node p){//dem so node con cua 1 node trong cay
     if(p==null&&p.right==null) return 0;
     else if(p.Left!=null&& p.right==null) return 1+CountNode(p.Left);
     else if(p.Left==null&&p.right!=null) return 1+CountNode(p.right);
     else return (2+CountNode(p.Left)+ CountNode(p.right));
     }
     public Node SearchNodebyprice (int xprice){//tim 1 node trong cay theo key
        Node p = null,x=null;
        if(root==null)return p;
        p=root;
        while(p!=null){
            if(p.info.price==xprice){
                x=p;
            }
            if(xprice<p.info.price){
                p=p.Left;
            }else{
                p=p.right;
            }
        }return x;
    }
      Node update = null; int demup = 0;
      public void post_order3(Node p) {
        if (p != null) {
            post_order3(p.Left); // lap lai viec duyet tham cay con trai
            post_order3(p.right);
            demup++;
            if(demup==5)p.info.color= String.valueOf(CountNode(p));  
        }
    }
     
      public int HighOfSubTree (Node p){//dem chieu cao cay cua 1 Node
          if(p.Left==null&&p.right==null)return 1;
          else if (p.Left!= null&&p.right==null)return 1+HighOfSubTree(p.Left);
          else if (p.Left== null&&p.right!=null)return 1+HighOfSubTree(p.right);
          else {
              if(HighOfSubTree(p.Left)>HighOfSubTree(p.right))return 1+HighOfSubTree(p.Left);
              else {
                  return 1+ HighOfSubTree(p.right);
              }
          }
      }
      int level = 0;
      public int LevelOfNode(Node p){//tim lv cua 1 node
          if(root==null)return 0;
          if(root==p) return 1;
          else{
              Node d = root; level = 1;
              while(d!=null){
                  if(d==p)break;
                  else{
                      level++;
                      if(p.info.price<d.info.price)d=d.Left;
                      else d=d.right;
                  }
              }
              return level;
          }
      }
       
      public void DelByMerge(Node xNode) { //keyby price
        if (xNode == null || root == null) {
            return;
        }
        // b1. di tim vi tri node xNode bi xoa & tim cha cua no
        Node pa = root, fa = null;// pa se la node can xoa, fa la node cha cua no
        while (pa != null) {
            if (pa == xNode) {
                break;
            }
            fa = pa;// if(xNode.info.owner.equals(pa.info.owner)) keyby string
            if (xNode.info.price < pa.info.price) {
                pa = pa.Left;
            } else {
                pa = pa.right;
            }
        }// tim xong thay thi pa != null.=> b2 Xoa
        if (pa.Left == null && pa.right == null) { //TH1. pa la node leaf
            if (fa == null) {
                root = null; // pa la goc. cay chi co 1 node
            } else { //pa la con trai cua node cha fa thi ngat fa.Left nc lai fa.right
                if (fa.Left == pa) {
                    fa.Left = null;
                } else {
                    fa.right = null;
                }
            }
        }// TH2. Pa co con trai
        else if (pa.Left != null && pa.right == null) {
            if (fa == null) {
                root = root.Left;// pa la goc.
            } else { // pa la con trai cua fa thi fa.Left = pa.Left
                if (fa.Left == pa) {
                    fa.Left = pa.Left;
                } else {
                    fa.right = pa.Left;//pa la con phai cua fa
                }
            }
        }// TH3. Pa co con phai
        else if (pa.Left == null && pa.right != null) {
            if (fa == null) {
                root = root.right;// pa la goc.
            } else {
                // pa la con trai cua fa thi fa.Left = pa.Left
                if (fa.Left == pa) {
                    fa.Left = pa.right;
                } else {
                    fa.right = pa.right;//pa la con phai cua fa
                }
            }
        }//TH4. Pa co 2 con. tim toi node phai nhat cua cay con trai cua pa can xoa 
        // gan con phai cua pa vao lam con phai cua node vua tim duoc
        else if (pa.Left != null && pa.right != null) {//b1 tim node con phai nhat
            Node rightmost = pa.Left, far = null; // far la cha cua rightmost
            while (rightmost.right != null) {
                far = rightmost;
                rightmost = rightmost.right;
            }// da tim dc rightmost va cha cua no far
            //b2 merger..............................
            if(pa==root) root=root.Left;
            else{
                if(fa.Left==pa){
                    fa.Left=pa.Left;         
                }else{
                    fa.right=pa.Left;
                }
            }
           rightmost.right=pa.right;
        }
        //copy delbycopy xuong chi sua tu buoc 2 cua truong hop co 2 con
  }
}
