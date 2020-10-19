public class No724 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(new Solution().pivotIndex(nums));
    }


    static class Solution{
        public int pivotIndex(int[] nums){
            int sum = 0;
            for(int i = 1; i < nums.length; i++) sum += nums[i];
            int left_sum = 0;
            if(sum == 0) return 0;
            for(int i = 0; i < nums.length; i++){
                left_sum += nums[i];
                sum -= nums[i+1];
                if(left_sum == sum) return i+1;
                if(left_sum > sum) return -1;
            }
            return -1;
        }
    }


    //暴力破解 时间复杂度O(n^2)
    static class Solution1 {
        public int pivotIndex(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                int left_sum = 0, right_sum = 0;
                for(int j = 0; j < i; j++)
                    left_sum += nums[j];
                for(int j = i+1; j < nums.length; j++)
                    right_sum += nums[j];
                if(right_sum == left_sum) return i;
            }
            return -1;
        }
    }
}
