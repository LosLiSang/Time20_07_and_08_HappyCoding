public class No14{
    public static void main(String[] args) {
        System.out.println(new Solution5().myAtoi("-91283472332"));
    }
}
class Solution5 {
    public int myAtoi(String str) {
        int isNag = 1;
        long result = 0;
        boolean isStart = true;
        char[] charArray = str.toCharArray();
        for(char c : charArray){
            if(c == ' ' & isStart) continue;
            if(c >= '0' && c <= '9'){
                result = result * 10 + (int)c - '0';
                isStart = false;
            }else if((c == '-' | c == '+') & isStart){
                isStart = false;
                if(c == '-') isNag = -1;
            }else break;
            if(isNag == -1 & result * -1 < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(isNag == 1 & result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        result *= isNag;
        return (int)result;
    }
}