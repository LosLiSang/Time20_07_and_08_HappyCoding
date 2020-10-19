import java.util.Arrays;


public class No88 {
    static class Solution {
        public static void main(String[] args) {
            int[] a = new int[]{1,2,3,0,0,0};
            int[] b = new int[]{2,5,6};
            new Solution().merge(a, 3, b, 3);
            System.out.println(Arrays.toString(a));
        }
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m-1, p2 = n-1, p = nums1.length-1;
            while(p1 >= 0 && p2 >= 0){
                if(nums1[p1] > nums2[p2]){
                    nums1[p] = nums1[p1];
                    p1--;
                }else{
                    nums1[p] = nums2[p2];
                    p2--;
                }
                p--;
            }
            if(p1 < 0){
                System.arraycopy(nums2, 0, nums1, 0, p2+1);
            }
            
        }
    }
}