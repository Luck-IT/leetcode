package eric;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Solution
 * #description#
 *
 * @author:Eric
 * @since 1.8
 * create 2022年1月25日
 */
public class Solution {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Set<String> operations = Stream.of("+", "-", "*", "/").collect(Collectors.toSet());
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if (operations.contains(tokens[i])) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                if ("+".equals(tokens[i])) {
                    stack.add(a + b);
                } else if ("-".equals(tokens[i])) {
                    stack.add(b - a);
                } else if ("*".equals(tokens[i])) {
                    stack.add(a * b);
                } else if ("/".equals(tokens[i])) {
                    stack.add(b / a);
                }
            } else {
                stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
