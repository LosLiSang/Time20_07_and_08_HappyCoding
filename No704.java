//704. 二分查找


public class No704 {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{-1,0,3,5,9,12}, 1));
    }
    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                System.out.println(String.format("left:%d right:%d mid:%d", left, right, mid));
                if(nums[mid] > target){
                    right = mid - 1;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }else if(nums[mid] == target){
                    return mid;
                }
            }
            return -1;
        }
    }
}
