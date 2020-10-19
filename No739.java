import java.util.Stack;

public class No739{
    public static void main(String[] args) {
        
    }
    static class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] res = new int[T.length];    
            Stack<Integer> down = new Stack<>();
            Stack<Integer> index = new Stack<>();
            for(int i = 0; i < T.length; i++){
                while(!down.empty() && T[i] > down.peek()){
                    res[index.peek()] = i - index.pop();
                    down.pop();
                }
                index.push(i);
                down.push(T[i]);
            }
            return res;
        }
    }
}