import java.util.Stack;

//155. 最小栈
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

//push(x) —— 将元素 x 推入栈中。
//pop() —— 删除栈顶的元素。
//top() —— 获取栈顶元素。
//getMin() —— 检索栈中的最小元素。

public class No155 {
    //辅助栈解法
    class MinStack {

        /** initialize your data structure here. */
        private Stack<Integer> _nums;
        private Stack<Integer> _mins;
        public MinStack() {
            _nums = new Stack<>();
            _mins = new Stack<>();
        }
        
        public void push(int x) {
            _nums.push(x);
            int minEle = (_mins.empty()) ? x : (x > _mins.peek() ? _mins.peek() : x);
            _mins.push(minEle);
        }
        
        public void pop() {
            _nums.pop();
            _mins.pop();
        }
        
        public int top() {
            return _nums.peek();
        }
        
        public int getMin() {
            return _mins.peek();
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
