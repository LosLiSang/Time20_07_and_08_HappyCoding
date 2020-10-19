public class No035 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 10};
        System.out.println(new Solution().searchInsert(nums, 4));
    }
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length-1;
            while(left <= right){
                int mid = left + right;
                if(nums[mid] == target) return mid;
                else if(nums[mid] > target) right = mid - 1;
                else if(nums[mid] < target) left = mid + 1;
            }
            return left;
        }
    }
}
