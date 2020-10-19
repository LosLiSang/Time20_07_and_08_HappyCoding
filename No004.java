//4. 寻找两个正序数组的中位数
//标签：数组，二分查找，分治算法

public class No004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
    //骚方法不会(下次一定)(2020/09/17)
    static class Solution{
        public double findMedianSortedArrays(int[] nums1, int[] nums2){
            double result = 0;
            return result;
        }
    }
    //时间复杂度O(m+n) 空间复杂度O(m+n)
    static class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double result = 0;
            int[] nums = new int[nums1.length + nums2.length];
            int p1 = 0, p2 = 0;
            while(p1 < nums1.length && p2 < nums2.length){
                nums[p1+p2] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
            }
            int[] src = p1 < nums1.length ? nums1 : nums2;
            int srcPos = p1 < nums1.length ? p1 : p2;
            System.arraycopy(src, srcPos, nums, p1+p2, nums.length-p1-p2);
            //System.out.println(Arrays.toString(nums));
            result = nums.length % 2 != 0 ? nums[nums.length>>1]
                    : (double)(nums[nums.length>>1]+nums[(nums.length>>1) - 1])/2;
            return result;
        }
    }
}
