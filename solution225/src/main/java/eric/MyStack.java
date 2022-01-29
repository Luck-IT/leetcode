package solution225;

import java.util.LinkedList;
import java.util.Queue;

/**
* MyStack
* #description#
* @author:Eric
* @since 1.8
* create 2022年1月24日
*/
public class MyStack {
    private Queue<Integer> queue;


    public MyStack(){
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        this.queue.add(x);
    }
    
    public int pop() {
        int size = this.queue.size();
        while(size > 1){
            size--;
            int x = this.queue.poll();
            this.queue.add(x);
        }
        int result = this.queue.poll();
        return result;
    }
    
    public int top() {
        int x = this.pop();
        this.queue.add(x);
        return x;
    }
    
    public boolean empty() {
        return this.queue.isEmpty();
    }

}
