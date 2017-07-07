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

    public Node reverse(Node head) {
        return null;
    }

    public Node findTheMid(Node head) {
        return null;
    }

    public Node findElem(Node head, int k) {
        return null;
    }

    public void sort(Node head) {
        return;
    }

    public Node deleteDuplecate(Node head) {
        return null;
    }

    public void printreverse(Node head) {
        return;
    }

    public static void main(String[] args) {
        MyLink list = new MyLink();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(55);
        list.addNode(36);
        System.out.println("linkLength:" + list.length());
        System.out.println("head.data:" + list.head.data);
        list.printList();
        list.deleteNode(4);
        System.out.println("After deleteNode(4):");
        list.printList();

        MyLink link2 = new MyLink(new int[]{1,2,3});
        link2.printList();
        link2.printList();
    }
}