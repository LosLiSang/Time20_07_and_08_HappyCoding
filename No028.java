public class No028 {


    public static void main(String[] args) {
        
    }
    //KMP算法
    static class Solution {
        public int strStr(String haystack, String needle) {
            int j = 0, i = 0;
            int[] next = get_next(needle);
            while(i < haystack.length() && j < needle.length()){
                if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }else{
                    j = next[j];
                }
            }
            if(j == needle.length()) return i - j;
            return -1;
        }
        private int[] get_next(String needle){
            int[] res = new int[needle.length()];
            int i = 0, j = -1;
            res[0] = -1;
            while(i < res.length-1){
                if(j == -1 || needle.charAt(i) == needle.charAt(j)){
                    j++;
                    i++;
                    res[i] = j;
                }else
                    j = res[j];
            }
            return res;
        }
    }

    static class Solution1 {
        public static void main(String[] args) {
            System.out.println(new Solution1().strStr("leeeeyan", "ey"));
        }
        public int strStr(String haystack, String needle) {
            if(needle.equals("")) return 0;
            for(int i = 0; i < haystack.length() - needle.length(); i++){
                if(haystack.charAt(i) == needle.charAt(0)){
                    boolean allEequal = true;
                    for(int j = 1; j < needle.length(); j++){
                        if(needle.charAt(j) != haystack.charAt(i+j)){
                            allEequal = false;
                            break;
                        }
                    }
                    if(allEequal) return i;
                }
            }
            return -1;
        }
    }
}