package solution232;

import java.util.Stack;

/**
* MyQueue
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月21日
*/
public class MyQueue {

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        if(stackOut.empty()){
            while(!stackIn.empty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }
    
    public int peek() {
        int result = this.pop();
        this.stackOut.push(result);
        return result;
    }
    
    public boolean empty() {
        return this.stackIn.empty() && this.stackOut.empty();
    }
}
