public class No39 {
    static class Solution {
        public static void main(String[] args) {
            char[] t = "abdc".toCharArray();
            new Solution().reverseString(t);
            System.out.println(t);
        }
        public void reverseString(char[] s) {
            for(int i = 0; i < s.length/2; i++){
                char t = s[i];
                s[i] = s[s.length-1-i];
                s[s.length-1-i] = t;
            }
        }
        
    }
}