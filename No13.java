public class No13 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        System.out.print(new Solution4().checkSubarraySum(nums, 0));
    }
}
class Solution4 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // int[][] sumNum = new int[nums.length][];
        // for(int i = 0; i < nums.length; i++) sumNum[i] = new int[i + 1];
        // for(int i = 0; i < nums.length; i++) sumNum[i][i] = nums[i];
        // for(int end = 1; end < nums.length; end++){
        //     for(int start = end - 1; start >= 0; start--){
        //         sumNum[end][start] = sumNum[end][start + 1] + nums[start];
        //         if((k == 0 & sumNum[end][start] == 0)) return true;
        //         else if(k != 0 && sumNum[end][start] % k == 0) return true; 
        //     }
        // }
        // return false;
        int[] sumNum = new int[nums.length];
        for(int end = 1; end < nums.length; end++){
            sumNum[end] = nums[end];
            for(int start = end - 1; start >= 0; start--){
                sumNum[start] = sumNum[start + 1] + nums[start];
                if((k == 0 & sumNum[start] == 0)) return true;
                else if(k != 0 && sumNum[start] % k == 0) return true; 
            }
        }
        return false;
    }
}