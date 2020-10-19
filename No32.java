import java.util.Arrays;

public class No32 {
    static class Solution {
        public static void main(String[] args) {
            int[] i = new int[]{1, 2, 2, 3, 3, 5, 2, 1, 1};
            System.out.println(new Solution().removeElement(i, 1));
            System.err.println(Arrays.toString(i));
        }
        public int removeElement(int[] nums, int val) {
            int ptr = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != val){
                    nums[ptr] = nums[i];
                    ptr++;
                }
            }
            return ptr;
        }
    }
}