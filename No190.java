//190. 颠倒二进制位
//颠倒给定的 32 位无符号整数的二进制位。


public class No190 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
    static public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int res = 0;
            for(int i = 0; i < 32; i++){
                res = (res << 1) + (n & 1);
                n = n >> 1;
            }
            return res;
        }
    }
}
