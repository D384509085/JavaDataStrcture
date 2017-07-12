package enbledu.after_class.practice.fourth_session.calculater;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
//中缀转后缀工具类
public class Tool {
    public static String doTrans(String input) {
        Stack stack = new Stack(input.length());
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('1' <= c && c <= '9') {
                output += c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output += stack.pop();
                }
                stack.push(c);
            } else if (c == '*' || c == '/') {
                if (!stack.isEmpty()) {
                    while (stack.peek() == '*' || stack.peek() == '/') {
                        output += stack.pop();
                    }
                }
                stack.push(c);
            } else if(c == ')') {
                while (stack.peek() != '(') {
                    output += stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            output += stack.pop();
        }
        return output;
    }


    public static void main(String[] args) {
        String s = doTrans("(1+3)/2");
        System.out.println(s);
    }
}
