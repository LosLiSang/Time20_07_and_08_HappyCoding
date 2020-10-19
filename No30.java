
public class No30 {
    static class Solution {
        public static void main(String[] args) {
            System.out.println(new Solution().romanToInt("MCMXCIV"));
        }
        public int romanToInt(String s) {
            int result = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == 'M') result += 1000;
                else if(s.charAt(i) == 'D') result += 500;
                else if(s.charAt(i) == 'C'){
                    try{
                        if(s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D')
                            {result -= 100; continue;}
                    }catch(Exception e){}
                    result += 100;
                ;
                }
                else if(s.charAt(i) == 'L') result += 50;
                else if(s.charAt(i) == 'X'){
                    try{
                        if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') 
                            {result -= 10; continue;}
                    }catch(Exception e){}
                    result += 10;
                }
                else if(s.charAt(i) == 'V') result += 5;
                else if(s.charAt(i) == 'I'){
                    try{
                        if(s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')
                            {result -= 1; continue;}
                    }catch(Exception e){}
                    result += 1;
                }
            }
            return result;
        }
    }
}