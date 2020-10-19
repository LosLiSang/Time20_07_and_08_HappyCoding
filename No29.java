import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class No29 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2}));
        }
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                if(i == 0 || nums[i] != nums[i-1]){
                    for(int j = i+1, k = nums.length-1; j < k;){
                        if(nums[i] + nums[j] + nums[k] == 0){
                            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                            int t;
                            for(t = 0; nums[j+t] == nums[j]; t++);
                            j += t;
                            for(t = 0; nums[k-t] == nums[j]; t++);
                            k -= t;
                        }else if(nums[i] + nums[j] + nums[k] > 0) k--;
                        else if(nums[i] + nums[j] + nums[k] < 0) j++;
                    }    
                }
            }
            return result;
        }

    }
    
}