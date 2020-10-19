import java.util.List;
import java.util.ArrayList;

public class No26 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().generateParenthesis(3));
        }
        List<String> result = new ArrayList<String>();
        public List<String> generateParenthesis(int n) {
            String path = "";
            backtrack(n, path, 0, 0);
            return result;
        }

        private void backtrack(int n, String path, int leftCount, int rightCount){
            if(rightCount == n){
                result.add(new String(path));
                return;
            }else if(leftCount == n){
                backtrack(n, path + ")", leftCount, rightCount + 1);
            }else if(leftCount > rightCount){
                backtrack(n, path + ")", leftCount, rightCount + 1);
                backtrack(n, path + "(", leftCount + 1, rightCount);
            }else if(leftCount == rightCount){
                backtrack(n, path + "(", leftCount + 1, rightCount);
            }
        }
    }   
}