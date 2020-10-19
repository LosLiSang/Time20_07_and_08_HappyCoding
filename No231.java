public class No231 {
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(128));
    }
    
    static class Solution {
        public boolean isPowerOfTwo(int n) {
            boolean result = false;
            while(n % 2 == 0){
                n /= 2;
                if(n == 1){
                    result = true;
                }
            }
            return result;
        }
    }
}
