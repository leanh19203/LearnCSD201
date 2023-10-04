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
public class Mylist {

    Node head = null, tail = null;

    boolean isEmpty() {
        return head == null; //if head =null return true ; else return failse
    }

    void addFirst(String xTitle, int xPrice) {
        book b = new book(xTitle, xPrice);
        addFirst(b);
    }

    void addFirst(book b) {
        Node p = new Node(b, null);
        addFirst(p);

    }

    void addFirst(Node p) {
        if (isEmpty()) {
            head = tail = p;
            tail.next = null;
        } else {
            p.next = head;//next cua node moi thi la head hien tai
            head = p;//head moi la node moi
        }
    }

    void Loadlist() {
        if (isEmpty()) {
            System.out.println("The List is Empty");
        } else {
            Node p = head;
            while (p != null) {
                System.out.print(p.info.toString());

                p = p.next;
            }
        }
    }

    void addLast(String xTitle, int xPrice) {
        if (xTitle.contains("f") || xPrice > 100) {
            return;
        }
        book b = new book(xTitle, xPrice);
        addLast(b);
    }

    void addLast(book b) {
        Node p = new Node(b, null);
        addLast(p);

    }

    void addLast(Node p) {
        if (isEmpty()) {
            head = tail = p;
            tail.next = null;
        } else {
            tail.next = p;//next cua node moi thi la head hien tai
            tail = p;//head moi la node moi
        }
    }

    //chen

    void insertAti(String xTitle, int xprice, int pos) {
        int start = 1;
        Node p = head, q = head; // Assuming you have a "head" variable defined somewhere in your code.

        while (start != pos && p != null) { // Fixed the while loop condition
            q = p; // q la node chay sau p truoc khi p next sang node tiep
            p = p.next;
            start++;
        }

        if (start == pos) {
            Node N = new Node(new book(xTitle, xprice), null);
            q.next = N;
            N.next = p;
        }
    }

    // chen vao sau phan tu thu 2 co price = 80 neu khong co thi chen o dau

    void f1() {
        //b1 duyet list tim node thu 2 =80
        int count = 0;
        Node p = head, q = head;
        while (p != null) {
            if (p.info.price == 80) {
                count++;
                if (count == 2) {
                    if (p == tail)// neu tim thay node 2 chinh la tail
                    {
                        addLast("MDA", 35);
                    } else {
                        Node n = new Node(new book("MDA", 35), null);
                        q = p.next;
                        p.next = n;
                        n.next = q;

                    }
                }

            }
            p = p.next;//duyen sang node tiep

        }
        if (count < 2) {
            addFirst("MDa", 35);//neu khong thay node thu 2 =80 thi chen o dau
        }
    }

    // f2 chen vao truoc node 

    void f2(String xTitle, int xPrice) {
        Node p = head, q = head;
        while (p != null) {
            if (p.info.price > 50) {
                if (p == head) {
                    addFirst(xTitle, xPrice);
                } else {
                    Node n = new Node(new book(xTitle, xPrice), null);
                    q.next = n;
                    n.next = p;
                }
                return;
            }
            p = p.next;
        }
        addLast(xTitle, xPrice);
    }

    void f3(String xTitle, int xPrice) {
        int max = Integer.MIN_VALUE, count = 0;
        Node p = head, q = head;
        while (p != null) {
            if (p.info.price == max) {
                count++;
                if (count == 2) {
                    if (p == tail)// neu tim thay node 2 chinh la tail
                    {
                        addLast(xTitle, xPrice);
                    } else {
                        Node n = new Node(new book(xTitle, xPrice), null);
                        q = p.next;
                        p.next = n;
                        n.next = q;

                    }
                }

            }
            p = p.next;//duyen sang node tiep

        }
        if (count < 2) {
            addFirst(xTitle, xPrice);//neu khong thay node thu 2 =80 thi chen o dau
        }
    }

    //viết f5 tìm phần tử cuối mà title bắt đầu bằng 'p' rồi chèn sau nó

    void f5(String xTitle, int xPrice) {
        Node p = head;
        Node q = null;
        Node newNode = new Node(new book(xTitle, xPrice), null);

        // Tìm phần tử cuối cùng có title bắt đầu bằng 'p'
        while (p != null) {
            if (p.info.title.startsWith("P")) {
                q = p; // Lưu lại phần tử hiện tại
            }
            p = p.next;
        }

        // Kiểm tra nếu tìm thấy phần tử và q không null
        if (q != null) {
            Node nextNode = q.next;
            q.next = newNode; // Chèn newNode sau phần tử cuối cùng có title bắt đầu bằng 'p'
            newNode.next = nextNode; // Cập nhật liên kết của newNode với phần tử sau nó
        } else {
            // Nếu không tìm thấy phần tử nào thỏa mãn điều kiện, chèn vào cuối danh sách
            addLast(newNode);
        }
    }
    //tim va sua danh sach 1, duyet danh sach toi node can tim 2, thay doi no

    // xoa 1 node trong ds 1
    void DelHead() {
        if (isEmpty()) {
            return;
        }
        head = head.next;//neu chi co 1 node
    }

    void DelTail() {
        if (isEmpty()) {
            return; // Không có phần tử để xóa nếu danh sách rỗng.
        }

        if (head == tail) {
            // Nếu danh sách chỉ có một phần tử, đặt head và tail thành null.
            head = tail = null;
        } else {
            Node p = head;
            Node q = null;

            while (p != tail) {
                q = p;
                p = p.next;
            }

            // Đặt tail thành node trước tail và đặt liên kết của tail thành null.
            tail = q;
            tail.next = null;
        }
    }

    void DelNode(int pos) {
        if (isEmpty()) {
            return;
        }

        if (pos == 1) {
            DelHead(); // Xóa phần tử đầu tiên nếu pos == 1.
        } else {
            int count = 1;
            Node p = head;
            Node q = null;

            while (p != null && count != pos) {
                q = p;
                p = p.next;
                count++;
            }

            if (p != null) {
                // Nếu tìm thấy node ở vị trí cần xóa (pos), thì xóa nó.
                q.next = p.next;
                if (p == tail) {
                    tail = q; // Nếu node cần xóa là tail, cập nhật tail mới.
                }
            }
        }
    }

    // f6 xoa node thu 2 co price =50

    void f6() {
        if (isEmpty() || head.next == null) {
            // Không có gì để xóa nếu danh sách trống hoặc chỉ có một phần tử.
            return;
        }

        Node p = head;
        Node q = p.next;

        if (q.info.price == 50) {
            // Nếu phần tử thứ 2 có giá price bằng 50, xóa nó.
            p.next = q.next;
            return;
        }

        while (q != null && q.info.price != 50) {
            p = q;
            q = q.next;
        }

        if (q != null) {
            // Nếu tìm thấy phần tử thứ 2 có giá price bằng 50, xóa nó.
            p.next = q.next;
        }
    }

    //f7 xoa node cuoi co price >30 vaf title co chua ky tu 'o'||'O'

    void f7() {
        if (isEmpty()) {
            // Không có gì để xóa nếu danh sách trống.
            return;
        }

        Node p = head;
        Node q = null;
        Node prevToDelete = null;

        while (p != null) {
            if (p.info.price > 30 && (p.info.title.contains("o") || p.info.title.contains("O"))) {
                // Nếu tìm thấy node thỏa mãn điều kiện, lưu lại node trước nó và node cần xóa.
                prevToDelete = q;
            }
            q = p;
            p = p.next;
        }

        if (prevToDelete != null) {
            // Nếu tìm thấy node thỏa mãn điều kiện, xóa nó bằng cách cập nhật liên kết của node trước nó.
            if (prevToDelete.next == tail) {
                tail = prevToDelete;
            }
            prevToDelete.next = prevToDelete.next.next;
        }
    }
//f10 xoa node dung truoc node co price max thu 2 tim thay

    void f10() {
        if (isEmpty() || head.next == null) {
            // Không có gì để xóa nếu danh sách trống hoặc chỉ có một phần tử.
            return;
        }

        Node p = head;
        Node maxNode = null;
        Node secondMaxNode = null;

        while (p != null) {
            if (maxNode == null || p.info.price > maxNode.info.price) {
                secondMaxNode = maxNode;
                maxNode = p;
            } else if (secondMaxNode == null || p.info.price > secondMaxNode.info.price) {
                secondMaxNode = p;
            }
            p = p.next;
        }

        if (secondMaxNode != null) {
            // Nếu tìm thấy node có giá price lớn thứ 2, xóa node đứng trước nó.
            if (secondMaxNode == head) {
                head = head.next;
            } else {
                p = head;
                while (p != null && p.next != secondMaxNode) {
                    p = p.next;
                }
                if (p != null) {
                    p.next = secondMaxNode.next;
                }
            }
        }
    }
  // f8 tim va xoa tat ca cac node co title trung voi node dung truoc
    //f9 tim va xoa tat ca cac node co price >price node dau
//sap xep danh sach
    //selection sort  theo price giam dan

    void SortAscByPrice() {
        Node p = head, q = null;
        while (p.next != tail) {
            q = p.next;
            while (q != null) {
                if (q.info.price > p.info.price) {
                    book tmp = q.info;
                    q.info = p.info;
                    p.info = tmp;
                }
                q = q.next;
            }
            p = p.next;

        }
    }
    /*
  
     f12: gia su ds co it nhat 5 phan tu hay sap xep 5 phan tu o giua danh sach theo  cuar ASC cua title(coi phan tu o giua vi tri = length/2)
     f13: sap xep ds theo giam dan title neu title trung nhau thi theo giam cua price
  
     */

    int Length() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;

        }
        return count;
    }

    void f12() {
        int mid = Length() / 2, count = 0, k = 0;
        Node p = head, start = null, q = null; // tim node start
        while (count < mid) {
            count++;
            if (count == 2) {
                start = p;
            }
            if (count > 3) {
                start = start.next;
            }
            p = p.next;
        }// start --> start+5;
        count = 0; //reset de dung lai bien count
        p = start;
        while (count < 4) {
            k = 0;
            while (k < 5 - count) {
                q = p.next;
                if (p.info.title.compareTo(q.info.title) < 0) {
                    book tmp = q.info;
                    q.info = p.info;
                    p.info = tmp; // swap
                }
                k++;
            }
            count++;
            p = p.next;
        }
// for(p=start; count<5; count++){
// for(q=p.next, k=0; k<5-count; k++){
// if(p.info.title.compareTo(q.info.title) >0){
// Book tmp = q.info; q.info=p.info; p.info=tmp; // swap
// }q=q.next;
// }p=p.next;
// }
    }
    //f11: sap xep 5 phan tu dau danh sach giam theo gia

    void F11() {
        Node p = head, q;
        int count = 0;
        while (count < 5) {
            q = p.next;
            int qc = count + 1;
            while (qc < 5) {
                if (q.info.price > p.info.price) {
                    book tmp = q.info;
                    q.info = p.info;
                    p.info = tmp;
                }
                q = q.next;
                qc++;
            }
            count++;
            p = p.next;
        }
    }

    public void sort5DSC() {
        Node p = head, q = head;
        for (int i = 0; i < 4; i++) {
            q = p.next;
            for (int j = i + 1; j <= 4; j++) {
                if (p.info.price < q.info.price) {
                    book tmp = p.info;
                    p.info = q.info;
                    q.info = tmp;
                }
                q = q.next;
            }
            p = p.next;
        }
    }
    //tim node co price max va min sau do doi cho cho nhau
    void f16() {
    if (isEmpty() || head.next == null) {
        // Không thể thực hiện nếu danh sách trống hoặc chỉ có một phần tử.
        return;
    }

    Node maxNode = head;
    Node minNode = head;
    Node p = head;

    // Tìm node có giá trị lớn nhất và nhỏ nhất
    while (p != null) {
        if (p.info.price > maxNode.info.price) {
            maxNode = p;
        }
        if (p.info.price < minNode.info.price) {
            minNode = p;
        }
        p = p.next;
    }

    // Đổi chỗ giữa maxNode và minNode
    book temp = maxNode.info;
    maxNode.info = minNode.info;
    minNode.info = temp;
}
//tim node co price lon thu 2 va nho thu 2 sau do doi vi tri cho nhau
    void f18() {
    if (isEmpty() || head.next == null) {
        // Không thể thực hiện nếu danh sách trống hoặc chỉ có một phần tử.
        return;
    }

    Node firstMaxNode = head;
    Node secondMaxNode = head;
    Node firstMinNode = head;
    Node secondMinNode = head;
    Node p = head;

    // Tìm node có giá trị lớn thứ hai và nhỏ thứ hai
    while (p != null) {
        if (p.info.price > firstMaxNode.info.price) {
            secondMaxNode = firstMaxNode;
            firstMaxNode = p;
        } else if (p.info.price < firstMaxNode.info.price && p.info.price > secondMaxNode.info.price) {
            secondMaxNode = p;
        }

        if (p.info.price < firstMinNode.info.price) {
            secondMinNode = firstMinNode;
            firstMinNode = p;
        } else if (p.info.price > firstMinNode.info.price && p.info.price < secondMinNode.info.price) {
            secondMinNode = p;
        }

        p = p.next;
    }

    // Đổi chỗ giữa secondMaxNode và secondMinNode
    book temp = secondMaxNode.info;
    secondMaxNode.info = secondMinNode.info;
    secondMinNode.info = temp;
}

}
