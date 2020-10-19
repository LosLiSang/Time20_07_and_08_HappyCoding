//172. 阶乘后的零

public class No172 {
    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(25));
    }
    //时间复杂度(log(n))
    static class Solution{
        public int trailingZeroes(int n){
            int result = 0;
            long fiveNo = 5;
            while(n >= fiveNo){
                result += n / fiveNo;
                fiveNo *= 5;
            }
            return result;
        }
    }
    //时间复杂度(nlog(n))
    static class Solution1 {
        public int trailingZeroes(int n) {
            int result = 0;
            for(int i = 5; i <= n; i += 5){
                int j = i;
                while(j % 5 == 0){
                    j /= 5;
                    result += 1;
                }
            }
            return result;
        }
    } 
}
