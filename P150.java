import java.util.Objects;
import java.util.Stack;

public class P150 {

    public boolean isOperator (String s){
        return Objects.equals(s, "+") || Objects.equals(s, "-") || Objects.equals(s, "*") || Objects.equals(s, "/");
    }

    public int convert (String s){
        if (s.charAt(0) == '-'){
            int ans = 0;
            for (int i=1; i < s.length(); i++){
                ans *= 10;
                ans += s.charAt(i)-'0';
            }
            return -ans;
        }
        else {
            int ans = 0;
            for (int i=0; i < s.length(); i++){
                ans *= 10;
                ans += s.charAt(i)-'0';
            }
            return ans;
        }
    }

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < n; i++){
            if (isOperator(tokens[i])){
                int n2 = stack.pop();
                int n1 = stack.pop();
                if (tokens[i].equals("+")){
                    stack.add(n1+n2);
                }
                else if (tokens[i].equals("-")){
                    stack.add(n1-n2);
                }
                else if (tokens[i].equals("*")){
                    stack.add(n1*n2);
                }
                else {
                    stack.add(n1/n2);
                }
            }
            else {
                stack.add(convert(tokens[i]));
            }
        }
        return stack.pop();
    }
}
