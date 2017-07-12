package enbledu.after_class.practice.fourth_session.calculater;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack(int s) {
        stackArray = new char[s];
        maxSize = s;
        top = -1;
    }
    public void push(char c) {
        top++;
        stackArray[top] = c;
    }

    public char pop() {
        char c = stackArray[top];
        top--;
        return c;
    }

    public char peek() {return stackArray[top];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        else return false;
    }

    public int size() {
        return top+1;
    }

    public int peekN(int n) {
        return stackArray[n];
    }

    public void printStack() {
        for (int i = 0; i <= top;i++) {
            System.out.println(stackArray[i]);
        }
    }
}
