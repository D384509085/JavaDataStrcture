package enbledu.after_class.practice.fourth_session.calculater;

/**
 * Created by Administrator on 2017/7/12 0012.
 */

public class Calculater {

    private String input;
    private Stack stack;
    private String suffix;

    public Calculater(String input) {
        stack = new Stack(input.length());
        this.input = input;
        suffix = Tool.doTrans(input);
    }
    public int calculate() {
        for (int i = 0; i < suffix.length(); i++) {
            char c = suffix.charAt(i);
            if('1'<=c&&c<='9') {
                stack.push((char)(c-'0'));
            }
            else {
                char right = stack.pop();
                char left = stack.pop();
                switch (c) {
                    case '-': stack.push( (char)((int)left - (int)right) ); break;
                    case '+': stack.push( (char)((int)left + (int)right) ); break;
                    case '*': stack.push( (char)((int)left * (int)right) ); break;
                    case '/': stack.push( (char)((int)left / (int)right) ); break;
                }
            }
        }
        return (int)stack.pop();
    }
    public static void main(String[] args) {
        Calculater calculater = new Calculater("1+(2+4)/3");
        System.out.println(calculater.calculate());
    }
}
