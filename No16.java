public class No16 {
    public static void main(String[] args) {
        System.out.println(new Solution7().isPalindrome(10101));
    
    }
}

class Solution7 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int t = x;
        long result = 0;
        while(t != 0){
            result = result * 10 + (t % 10);
            t = t / 10;
        }
        if(result == x) return true;
        return false;
    }
}