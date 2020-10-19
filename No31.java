import java.util.Arrays;

public class No31 {
    static class Solution {
        public static void main(String[] args) {
            int[] i = new int[]{0, 1, 1, 2, 3, 4, 4, 5, 5, 5};
            System.out.println(new Solution().removeDuplicates(i));
            System.out.println(Arrays.toString(i)); 
        }
        public int removeDuplicates(int[] nums) {
            int count = 0, toComp = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(nums[i] != toComp) {
                    nums[count] = toComp;
                    toComp = nums[i];
                    count++;
                }
            }
            nums[count] = toComp; 
            count += 1;
            return count;
        }
    }

}