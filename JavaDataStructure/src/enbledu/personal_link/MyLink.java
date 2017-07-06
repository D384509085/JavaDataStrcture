package enbledu.personal_link;

/**
 * Created by enbodu on 7/5/17.
 */
/**、、、、
 * method:
 *
 * add a new num
 * public boolean addNode(int d);
 *
 * delete a Node according to the index or num
 * public boolean deleteNode(int index);
 * public boolean deleteNode(int num);
 *
 * return the length
 * public int length();
 *
 * print all the num
 * public void printList();
 *
 * reverse the link
 * public Node reverse(Node head);
 *
 * find the middle Node
 * public Node findTheMid(Node head);
 *
 * find the last k Node
 * public Node findElem(Node head, int k);
 *
 * sort the link
 * public void sort(Node head);
 *
 * delete the Duplecate
 * public Node deleteDuplecate(Node head);
 *
 * print the reverselink
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
        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;
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
    }
}