package lv2;

public class 문자열압축1 {

	public static String cutString(String s, int m) {
        String str = new String(s);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        while(str.length() > 0) {
            
            if(str.length() <= m) {
                sb.append(count).append(str);
                break;
            }
            
            String peek = str.substring(0, m);
            
            str = str.substring(m);
            // System.out.println(str);
            if(str.length() >= m && peek.equals(str.substring(0, m))) {
                count++;
            } else {
                sb.append(count).append(peek);
                count = 1;
            }
        }
        
        return sb.toString().replaceAll("1", "");
    }
    
    public static int solution(String s) {
        int length = s.length(); // string 길이
        int min = Integer.MAX_VALUE;
        
        for(int i = 1; i <= (length/2) + 1; i++ ) {
            String str = cutString(s, i);
            // System.out.println(str);
            if(min > str.length()) min = str.length();
        }
        
        // System.out.println(min);
        
        return min;
    }
    
    public static void main(String[] args) {
    	// 74/100
    	String[] s = new String[] {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};
    	for(String str : s) System.out.println(solution(str));
    	
    }
}
