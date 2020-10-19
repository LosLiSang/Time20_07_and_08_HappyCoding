public class Offero58 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("12345", 4));
    }

    static class Solution {
        public String reverseLeftWords(String s, int n) {
            String result = "";
            result = s.substring(n, s.length());
            result += s.substring(0, n);
            return result;
        }
    }
}
