import java.util.Stack;

public class No150 {
    public static void main(String[] args) {
        int res = new Solution().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(res);
    
    }
    
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> nums = new Stack<Integer>();
            for(String s : tokens){
                if(s.equals("/") || s.equals("+") || s.equals("*") || s.equals("-")){
                    int num2 = nums.pop();
                    int num1 = nums.pop();
                    if(s.equals("/")) nums.push((Integer)(num1/num2));
                    if(s.equals("-")) nums.push((Integer)(num1-num2));
                    if(s.equals("*")) nums.push((Integer)(num1*num2));
                    if(s.equals("+")) nums.push((Integer)(num1+num2));
                }else
                    nums.push(Integer.parseInt(s));
            }
            return nums.peek();
        }
    }
}
