public class No38 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().isPalindrome("A man, a_____ plan, a canal: Panama"));
        }

        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            s = s.replaceAll("[\\W|_]", "");
            System.out.println(s);
            for(int i = 0, j = s.length() - 1; i <= j; i++, j--){
                if(s.charAt(i) != s.charAt(j)) return false;
            }
            return true;
        }
    }
}