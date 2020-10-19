
import java.util.LinkedList;
// import java.util.List;

public class No17 {
    
}

class Solution8 {
    public boolean isValid(String s) {
        LinkedList<Character> l = new LinkedList<Character>();
        for(char c : s.toCharArray()){
            if((c == ']' | c == ')' | c == '}') && l.isEmpty()) return false;
            if(c == ']' && l.pollLast() == '[') continue;
            if(c == ')' && l.pollLast() == '(') continue;
            if(c == '}' && l.pollLast() == '{') continue;
            
            if(c == '['){ l.add(c); continue;}
            if(c == '('){ l.add(c); continue;}
            if(c == '{'){ l.add(c); continue;}
            return false;
        }
        return true & l.isEmpty();
    }
}