import java.util.List;
import java.util.ArrayList;

public class No33 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().multiply("9", "9"));
        }
        public String multiply(String num1, String num2) {
            List<Integer> result = new ArrayList<Integer>();
            for(int i = num1.length() - 1; i >= 0; i--){
                for(int j = num2.length() - 1; j >= 0; j--){
                    int index = num1.length()+num2.length()-i-j-1-1;
                    int mulRes = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                    if(result.size() <= index){
                        result.add(mulRes);
                    }else{
                        result.set(index, result.get(index) + mulRes);
                    }
                }
            }
            System.out.println(result);
            String res = "";
            for(int i = 0; i < result.size(); i++){
                int full = result.get(i) / 10;
                if(full > 0){
                    if(i == result.size() - 1)
                        result.add(full);
                    else
                        result.set(i+1, result.get(i+1) + full);
                }
                res = (result.get(i) % 10) + res;
            }
            
            return res;
        }
    }
}