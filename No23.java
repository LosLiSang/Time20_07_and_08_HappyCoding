import java.util.HashMap;
import java.util.Map;

public class No23 {
    public static void main(String[] args) {
        System.out.println(new Solution13().intToRoman(3152));
    }
}

class Solution13 {
    private Map<Integer, String> Map = new HashMap<>();
    {
        Map.put(0, "");
        Map.put(1, "I");
        Map.put(2, "II");
        Map.put(3, "III");
        Map.put(4, "IV");
        Map.put(5, "V");
        Map.put(6, "VI");
        Map.put(7, "VII");
        Map.put(8, "VIII");
        Map.put(9, "IX");
        Map.put(10, "X");
        Map.put(20, "XX");
        Map.put(30, "XXX");
        Map.put(40, "XL");
        Map.put(50, "L");
        Map.put(60, "LX");
        Map.put(70, "LXX");
        Map.put(80, "LXXX");
        Map.put(90, "XC");
        Map.put(100, "C");
        Map.put(200, "CC");
        Map.put(300, "CCC");
        Map.put(400, "CD");
        Map.put(500, "D");
        Map.put(600, "DC");
        Map.put(700, "DCC");
        Map.put(800, "DCCC");
        Map.put(900, "CM");
        Map.put(1000, "M");
        Map.put(2000, "MM");
        Map.put(3000, "MMM");
    }
    public String intToRoman(int num) {
        String result = ""; 
        for(int i = 1; num != 0; num /= 10, i *= 10)
            result = Map.get((num % 10) * i) + result;
        return result;
    }
}