public class No25 {
    public static void main(String[] args) {
        System.out.println(new Solution14().longestCommonPrefix(
            new String[]{
            "aaaccc",
            "aaabbb", 
            "aa",
            "aoo",
            ""}));
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        if(strs.length == 0) return "";
        String result = "";
        int ptr = 0;
        try {
            while(true){
                boolean allEqual = true;
                for(int i = 1; i < strs.length; i++){
                    if(strs[i-1].charAt(ptr) != strs[i].charAt(ptr)){
                        allEqual = false;
                        break;
                    }
                }
                if(allEqual) result += strs[0].charAt(ptr);
                else break;
                ptr++;
            }
        } catch (IndexOutOfBoundsException e) {
            
        }
            
        return result;
    }
}