import java.util.Stack;

public class No896 {
    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,3};
        System.out.println(new Solution().isMonotonic(A));
    }
    

    //单调栈
    static class Solution{
        public boolean isMonotonic(int[] A){
            Stack<Integer> s_up = new Stack<>();
            Stack<Integer> s_down = new Stack<>();
            for(int i : A){
                if(!s_up.empty() && s_up.peek() > i)
                    s_up.pop();
                s_up.push(i);
                if(!s_down.empty() && s_down.peek() > i)
                    s_down.pop();
                s_down.push(i);
            }
            if(s_up.size() == A.length || s_down.size() == A.length) return true;
            else return false;
        }
    }


    static class Solution1 {
        public boolean isMonotonic(int[] A) {
            int isPos = 0;
            for(int i = 1; i < A.length; i++){
                if(isPos == 1 && A[i-1] - A[i] > 0)
                    return false;
                else if(isPos == -1 && A[i-1] - A[i] < 0)
                    return false;
                else{ 
                    if(A[i-1] - A[i] < 0){
                        isPos = 1;
                    }else if(A[i-1] - A[i] > 0){
                        isPos = -1;
                    }
                }
            }return true;
        }
    }
}
