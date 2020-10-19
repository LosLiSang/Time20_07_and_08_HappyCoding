import java.util.List;
import java.util.ArrayList;

public class No22 {
    public static void main(String[] args) {
        System.out.println(new Solution12().subsets(new int[]{1, 2, 3, 4}));
    }
}
class Solution12 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i <= nums.length; i++){
            backTrace(i, result, nums, temp, 0);
        }
        return result;
    }

    private void backTrace(int n, List<List<Integer>> result, int[] nums, List<Integer> temp, int start){
        if(temp.size() == n){
            result.add(new ArrayList<Integer>(temp));
            return;
        }else{
            for(int i = start; i < nums.length; i++){
                if(!temp.contains(nums[i])){
                    temp.add(nums[i]);
                    backTrace(n, result, nums, temp, i++);
                    i--;
                    temp.remove(temp.size() - 1);
                    
                }
            }
        }
        
    }
}