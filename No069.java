public class No069 {
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
    }
    
    
    static class Solution {
        public int mySqrt(int x) {
            int left = 0, right = x;
            while(left <= right){
                //避免数字越界
                long mid = left + (right - left)/2;
                if(mid * mid == x) return (int)mid;
                else if(mid * mid > x) right = (int)mid - 1;
                else if(mid * mid < x) left = (int)mid + 1;
            }
            return left-1;
        }
    }
}
