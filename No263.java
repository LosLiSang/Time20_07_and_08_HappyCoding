public class No263{
    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(14));
    }

    static class Solution {
        public boolean isUgly(int num) {
            boolean result = false;
            if(num <= 0) return result;
            while(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
                if(num % 2 == 0) num /= 2;
                if(num % 3 == 0) num /= 3;
                if(num % 5 == 0) num /= 5;
            }
            if(num == 1) result = true;
            return result;
        }
    }
}