public class No09 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("sdaag")); 
    }
    static class Solution {
        public String longestPalindrome(String s) {
            if(s.equals("")) return "";
            s = s + "\n";
            char[] charL = s.toCharArray();
            int maxLength = 1;
            int nowLength = 1;
            boolean allEqual = true;
            int maxStart = 0;
            int maxEnd = 0;
            int startIndex;
            int endIndex;
            for(int i = 0; i < s.length(); i++){
                startIndex = i - 1;
                endIndex = i + 1;
                while(startIndex >= 0 && endIndex < s.length()){
                    if(allEqual){
                        if(charL[i] == charL[startIndex] || charL[i] == charL[endIndex]){
                            if(charL[i] == charL[startIndex]){
                                startIndex--;
                                nowLength++;
                            }
                            if(charL[i] == charL[endIndex]){
                                endIndex++;
                                nowLength++;
                            }
                        }else allEqual = false;
                    }else{
                        if(charL[startIndex] == charL[endIndex]){
                            nowLength += 2;
                            startIndex--;
                            endIndex++;
                        }else{
                            break;
                        }
                    }
                }
                if(maxLength < nowLength){
                    maxStart = startIndex + 1;
                    maxEnd = endIndex - 1;
                    maxLength = nowLength;

                }
                nowLength = 1;
                allEqual = true;
            }
            return s.substring(maxStart, maxEnd + 1);
        }
    }
}