import java.util.List;
import java.util.ArrayList;

public class No28 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] nums;
        public List<List<Integer>> permuteUnique(int[] nums) {
            this.nums = nums;

            if(nums.length == 0) return result;
            
            boolean[] used = new boolean[nums.length];
            List<Integer> temp = new ArrayList<Integer>();
            backtrack(nums.length, temp, used);
            return result;
        }
        
        private void backtrack(int n, List<Integer> temp, boolean[] used){
            if(temp.size() == n){
                result.add(new ArrayList<>(temp));
                return;
            }else{
                List<Integer> tList = new ArrayList<>();
                for(int i = 0; i < nums.length; i++){
                    if(!used[i] && !tList.contains(nums[i])){
                        temp.add(nums[i]);
                        used[i] = true;
                        tList.add(nums[i]);
                        backtrack(n, temp, used);
                        used[i] = false;
                        temp.remove(temp.size() - 1);
                    }
                    
                }
            }        
        }
    }
}