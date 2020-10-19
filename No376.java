public class No376 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        }
        public int wiggleMaxLength(int[] nums) {
            int[] differ = new int[nums.length-1];
            int last = 0;
            int count = 0, maxCount = 0;
            for(int i = 1; i < nums.length; i++){
                differ[i-1] = nums[i] - nums[i-1];
                if(count == 0){
                    if(differ[i-1] != 0){
                        count++;
                        maxCount = maxCount > count ? maxCount : count;
                        last = differ[i-1] > 0 ? 1 : -1;
                    }
                }else if(count > 0){
                    if(differ[i-1] * last < 0){
                        count++;
                        maxCount = maxCount > count ? maxCount : count;
                        last = last * -1;
                    }
                }
            }
            return maxCount+1;
        }
    }
}