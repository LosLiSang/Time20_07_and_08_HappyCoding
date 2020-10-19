import java.util.Arrays;

public class No189 {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
        new Solution().rotate(test, 38);
        System.out.println(Arrays.toString(test)); 
    }
    
    static class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len == 0 ? 0 : k % len;
            if(k == 0) return;
            // itrN = (len % k == 0) ? k : len % k,
            int count = 0;
            for(int i = 0; count < len; i++){
                int j = i, t2 =nums[j%len];
                do{
                    int t1 = t2;
                    t2 = nums[(j+k)%len];
                    nums[(j+k)%len] = t1;
                    j += k;
                    j %= len;
                    count++;
                }while(j != i);
            }
        }
    }
}