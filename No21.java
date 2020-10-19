import java.util.List;
import java.util.ArrayList;

public class No21{
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> result = new Solution11().permute(nums);
        System.out.println(result);
    }
}
class Solution11 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;

        boolean[] used = new boolean[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(nums.length, result, temp, nums, used);
        return result;
    }
    
    private void backtrack(int n, List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i = 0; i < nums.length; i++){
                if(!used[i]){
                    temp.add(nums[i]);
                    used[i] = true;
                    backtrack(n, result, temp, nums, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
                
            }
        }        
    }
}