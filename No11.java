public class No11 {
    public static void main(String[] args) {
        System.out.print(new Solution2().reverse(1534236469));
    }
}

class Solution2 {
    public int reverse(int x) {
        int isNag = x < 0 ? -1 : 1;
        long result = 0;
        x *= isNag;
        while(x > 0){
            if(result == 0) result += x % 10;
            else result = result * 10 + x % 10;
            x = x / 10;
        }
        result *= isNag;
        if(Integer.MAX_VALUE < result | Integer.MIN_VALUE > result) return 0;
        return (int)result;
    }
}