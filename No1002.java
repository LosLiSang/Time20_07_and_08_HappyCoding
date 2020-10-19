import java.util.List;
import java.util.ArrayList;
//1002. 查找常用字符

public class No1002 {
    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"love", "lhate", "like"}));
    }
    //时间复杂度O(n^2)
    static class Solution {
        public List<String> commonChars(String[] A) {
            List<String> result = new ArrayList<>();
            int[][] count = new int[26][A.length];
            for(int i = 0; i < A.length; i++){
                String s = A[i];
                for(char c : s.toCharArray()){
                    count[c-'a'][i] += 1;
                }
            }
            for(int i = 0; i < 26; i++){
                int minCount = 1000;
                for(int j = 0; j < count[i].length; j++)
                    minCount = minCount > count[i][j] ? count[i][j] : minCount;
                for(int k = 0; k < minCount; k++){
                    int t = i+'a';
                    result.add(Character.toString(t));
                }
            }
            return result;
        }
    }
}
                                                                                                        