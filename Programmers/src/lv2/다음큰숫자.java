package lv2;

public class 다음큰숫자 {

	static class BigNumber {
	    public int solution(int n) {
	        int answer = 0;
	        int count = CountNum(binary("", n));
	        
	        int tempCount = 0;
	        while(true) {
	        	n += 1;
	        	tempCount = CountNum(binary("", n));
	        	
	        	if(count == tempCount) break;
	        }
	        return answer = n;
	    }
	    
	    public String binary(String str, int n) {
	        // 10진수를 2진법으로
	        if(n == 1) return str+=1;
	        
	        if(n % 2 == 0 ) {
	            str += "0";
	        } else {
	            str += "1";
	        }
	        return binary(str, n/2);
	    }

	    public int CountNum(String str) {
	    	
	    	int count = 0;
	    	
	    	for(int i = 0 ; i < str.length(); i++) {
	    		if(str.charAt(i) == '1') count++;
	    	}
	    	return count;
	    }
	}
	
	public static void main(String[] args) {
		BigNumber bn = new BigNumber();
		
		bn.solution(78);
		
	}
}
