package enbledu.personal_link;

/**
 * Created by enbodu on 7/5/17.
 */
/**、、、、
 *
 * 构造方法：
 * public Node MyLink()
 * public Node MyLink(int[] datas)
 *
 * method:
 *
 * 添加节点
 * public boolean addNode(int d);
 *
 * 删除节点
 * public boolean deleteNode(int index);
 * public boolean deleteNode(int num);
 *
 * 输出长度
 * public int length();
 *
 * 输出链表
 * public void printList();
 *
 * 反转链表
 * public Node reverse(Node head);
 *
 * 寻找中间节点
 * public Node findTheMid(Node head);
 *
 * 寻找倒数第k个节点
 * public Node findElem(Node head, int k);
 *
 * 给链表排序
 * public void sort(Node head);
 *
 * 删除重复元素
 * public Node deleteDuplecate(Node head);
 *
 * 输出反转后的链表
 * public void printreverse(Node head);
 */


public class MyLink {
    Node head = null; // the head node

    class Node {
        Node next = null;
        int data;// num

        public Node(int data) {
            this.data = data;
        }
    }

    public MyLink (){

    }

    public MyLink(int[] datas) {
        if (datas==null) {
            return;
        }
        Node firstNode = new Node(datas[0]);
        head = firstNode;
        Node tmp = head;
        for (int i=1; i<datas.length; i++) {
            Node newNode = new Node(datas[i]);
            tmp.next = newNode;
            tmp = tmp.next;
        }
    }

    public void addNode(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }
        if (index == 1) {
            head = head.next;
            return true;
        }
        Node pretmp = head;
        Node tmp = pretmp.next;
        for (int i=0; i<index-2; i++) {
            if (tmp==null) {
               return false;
            }
            tmp = tmp.next;
            pretmp = pretmp.next;
        }
        pretmp = tmp.next;
        return true;
    }


    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }


    public boolean deleteNode(Node n) {
        if (n == null || n.next == null)
            return false;
        int tmp = n.data;
        n.data = n.next.data;
        n.next.data = tmp;
        n.next = n.next.next;
        System.out.println("删除成功！");
        return true;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public void reverse() {
        if (head==null || head.next==null) {
            return;
        }
        Node pretmp = head;
        Node midtemp = head;
        Node ahetmp = head.next;
        head.next = null;
        while (ahetmp.next!=null) {
            midtemp = ahetmp;
            ahetmp = ahetmp.next;
            midtemp.next = pretmp;
            pretmp = midtemp;
        }
        ahetmp.next = pretmp;
        head = ahetmp;
        return;
    }

    public Node findTheMid() {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node fasttmp = head;
        Node slowtmp = head;
        while (fasttmp.next.next != null) {
            fasttmp = fasttmp.next.next;
            slowtmp = slowtmp.next;
        }
        return slowtmp;
    }

    public Node findElem(MyLink link, int k) {
        if (k>link.length()) {
            return null;
        }
        Node tmp = head;
        Node pretmp = head;
        for (int i=0; i<k-1; i++) {
           tmp = tmp.next;
        }
        while (tmp.next!=null) {
            tmp = tmp.next;
            pretmp = pretmp.next;
        }
        return pretmp;
    }

    public Node sort(Node head) {
        if(head == null || head.next == null) return head;

        Node left = new Node(0), leftHead = left;
        Node right = new Node(0), rightHead = right;
        Node mid = new Node(0), midHead = mid;
        int data = head.data;

        while(head != null) {
            if(head.data < data) {
                left.next = head;
                left = head;
            } else if(head.data > data) {
                right.next = head;
                right = head;
            } else {
                mid.next = head;
                mid = head;
            }
            head = head.next;
        }

        left.next = null;
        right.next = null;
        mid.next = null;
        return merge(sort(leftHead.next), midHead.next, sort(rightHead.next));
    }

    public Node merge(Node left, Node mid, Node right) {
        Node leftTail = getTail(left);
        Node midTail = getTail(mid);
        midTail.next = right;
        if(leftTail != null) {
            leftTail.next = mid;
            return left;
        } else {
            return mid;
        }
    }

    public Node getTail(Node head) {
        if(head == null) return head;
        while(head.next != null) {
            head = head.next;
        }
        return head;
    }

    public Node deleteDuplecate(Node head) {
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            if (head.data == head.next.data) {
                head.next = null;
                return head;
            }
            return head;
        }
        //设链表不长于10000
        int[] count = new int[10000];
        Node pretmp = head;
        Node midtmp = head.next;
        Node ahetmp = head.next.next;
        count[head.data] = 1;
        while (ahetmp!=null) {
            if (count[midtmp.data] !=1) {
                count[midtmp.data] = 1;
                pretmp = pretmp.next;
                midtmp = midtmp.next;
                ahetmp = ahetmp.next;
            }
            else {
                pretmp.next = ahetmp;
                midtmp = ahetmp;
                ahetmp = ahetmp.next;
            }
        }
        if (count[midtmp.data] == 1) {
            pretmp.next = ahetmp;
            if (count[ahetmp.data] == 1) {
                pretmp.next = null;
            }
        }
        else {
            count[midtmp.data] = 1;
            if (count[ahetmp.data] == 1) {
                midtmp.next = null;
            }
        }
        return head;
    }

    public void printreverse(MyLink link) {
        link.reverse();
        link.printList();
    }

    public static void main(String[] args) {
        MyLink link2 = new MyLink(new int[]{1,2,3,4});

        System.out.println(link2.findElem(link2, 1).data);
    }
}