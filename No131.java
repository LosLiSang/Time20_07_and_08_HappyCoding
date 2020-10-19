import java.util.List;
import java.util.ArrayList;


public class No131{
    public static void main(String[] args) {
        System.out.println(new Solution().partition("aacabdb"));     

    }

    static class Solution {
        List<List<String>> result = new ArrayList<>();
        String s; 
        public List<List<String>> partition(String s) {
            this.s = s;
            List<String> path = new ArrayList<String>();
            backTrack(path, 0);
            return result;
        }
        private void backTrack(List<String> path, int itr){
            if(itr == s.length()){
                result.add(new ArrayList<>(path));
                return;
            }
            for(int i = itr; i < s.length(); i++){
                int left = itr, right = i;
                boolean isCov = true;
                while(left < right){
                    if(s.charAt(left) != s.charAt(right)) {isCov = false; break;}
                    left++;
                    right--;
                }
                if(isCov){
                    path.add(s.substring(itr, i+1));
                    backTrack(path, i+1);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}