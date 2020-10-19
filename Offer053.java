public class Offer053 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(new Solution().search(nums, 8));
    }
    static class Solution {
        public int search(int[] nums, int target) {
            int left = left_border(nums, target);
            int right = right_border(nums, target);
            return nums[left] == target ? right - left + 1 : 0;
        }
        private int left_border(int[] nums, int target){
            int left = 0, right = nums.length;
            while(left < right){
                int mid = left + (right - left)/2;
                //System.out.println(String.format("left left:%d right:%d mid:%d", left, right, mid));
                if(nums[mid] == target) right = mid;
                else if(nums[mid] > target) right = mid;
                else if(nums[mid] < target) left = mid + 1;
            }
            System.out.println(left);
            return left;
        }
        private int right_border(int[] nums, int target){
            int left = 0, right = nums.length;
            while(left < right){
                int mid = left + (right - left)/2;
                //System.out.println(String.format("right left:%d right:%d mid:%d", left, right, mid));
                if(nums[mid] == target) left = mid + 1;
                else if(nums[mid] > target) right = mid;
                else if(nums[mid] < target) left = mid + 1;
            }
            System.out.println(left-1);
            return left - 1;
        }
    }
}
