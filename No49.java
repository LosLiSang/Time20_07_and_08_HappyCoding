import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
//49. 字母异位词分组
//运用到HashMap（不会）
public class No49{
    static class Solution {
        List<List<String>> result = new ArrayList<>();
        public List<List<String>> groupAnagrams(String[] strs) {
            List<String> temp = new ArrayList<String>();
            temp.add("");
            char[][] copy = new char[strs.length][];
            for(int i = 0; i < strs.length; i++){
                copy[i] = strs[i].toCharArray();
                Arrays.sort(copy[i]);
            }
            Set<char[]> t = new HashSet<>(Arrays.asList(copy));
            t.add(new char[]{'1'});
            for(int i = 0; i < strs.length; i++){
                
            }
            return result;
        }
        
    }
}