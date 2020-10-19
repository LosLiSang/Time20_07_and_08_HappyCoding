import java.util.List;
import java.util.ArrayList;


public class No93 {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525011135"));
    }
    static class Solution {
        List<String> result = new ArrayList<String>();
        String s;
        public List<String> restoreIpAddresses(String s) {
            this.s = s;
            int[] path = new int[4];
            backTrack(0, path, 0);
            return result;
        } 
        private void backTrack(int count, int[] path, int itr){
            //找到解集
            if(count == 4){
                result.add(arrayToString(path));
                return;
            }else{                
                //截取数字区间不合理 | 截取的数字过大--截取长度减少
                //截取长度小于0--向前回溯,回溯到上一个数字
                for(int len = 1; len <= 3; len++){
                    
                    int maxL = (3 - count) * 3;
                    int minL = 3 - count;

                    if(maxL < s.length()-len-itr) continue;
                    if(minL >  s.length()-len-itr) return;
                    if(s.charAt(itr) == '0' && len != 1) return;              
                    int i = Integer.parseInt(s, itr, itr+len, 10);
                    if(i < 256){
                        path[count] = i;
                        backTrack(count+1, path, itr+len);
                        path[count] = -1;
                    }else return;
                }
            }
        }
        private String arrayToString(int[] path){
            String res = "";
            res += path[0];
            for(int i = 1; i < 4; i++) res = res + "." + path[i];
            return res;
        }

    }
}