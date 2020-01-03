package yingjia67.arithmetic.HeapStackQueue;

import java.util.Stack;

public class MinimumStack {
    static class MinStack {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            stack1.push(x);
            if(stack2.empty()){
                stack2.push(x);
                return;
            }
            Integer currentMin = stack2.peek();
            if(currentMin>x){
                stack2.push(x);
                return;
            }else {
                stack2.push(currentMin);
            }
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
