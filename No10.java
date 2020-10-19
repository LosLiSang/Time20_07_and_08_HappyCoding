public class No10 {
    public static void main(String[] args) {
        System.out.println(new Solution1().convert("aba", 1));
    }

    
}
class Solution1 {
    
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char[] nowCharArray = s.toCharArray();
        String[] strArray = new String[numRows];
        for(int i = 0; i < numRows; i++) strArray[i] = "";
        int isAdd = 1;
        for(int i = 0, count = 0; i < s.length(); i++){
            if(count == 0) isAdd = 1;
            else if(count == numRows - 1) isAdd = -1;
            strArray[count] = strArray[count] + nowCharArray[i];
            count += isAdd;
        }
        String result = "";
        for(String str : strArray) result += str;
        return result;
    }
}