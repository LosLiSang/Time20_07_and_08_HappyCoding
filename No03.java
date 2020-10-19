import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class No03 {
    public static void main(String[] args){
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

    static class Solution{
        public int lengthOfLongestSubstring(String s){
            int res = 0;
            int left = 0, right = 0;
            Map<Character, Integer> count = new HashMap<>();
            while(right < s.length()){
                while(count.containsKey(s.charAt(right))){
                    count.remove(s.charAt(left));
                    left++;
                }
                count.put(s.charAt(right), 1);
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;
        }
    }
    //
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int length = s.length();
        char[] charArray = s.toCharArray();
        List<Character> sList = new ArrayList<Character>();
        for(int i = 0; i < length; i++){
            for(int j = i; j < length; j++){
                if(sList.contains(charArray[j])){
                    result = result > sList.size() ? result : sList.size();
                    break;
                }else{
                    sList.add(charArray[j]);
                }
            }
            result = result > sList.size() ? result : sList.size();
            sList.clear();
        }
        return result;
    }
}