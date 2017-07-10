package enbledu.after_class.practice.third_session;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public class BubbleArray {

    private int[] a;

    public BubbleArray(int[] a) {
        this.a = a;
    }

    public void bubbleSort() {
        for (int i=a.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (a[j]>a[j+1]) {
                    swap(a[j], a[j+1]);
                }
            }
        }
    }
    public void print() {
        for (int a:a
             ) {
            System.out.println(a);
        }
    }
    public void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }

    public static void main(String[] args) {
        int[] a = {4,2,1};
        BubbleArray ba = new BubbleArray(a);
        ba.bubbleSort();
        ba.print();

    }
}
