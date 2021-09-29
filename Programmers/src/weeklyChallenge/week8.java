package weeklyChallenge;

public class week8 {

	 public static int solution(int[][] sizes) {
	        int answer = 0;
	        int length = sizes.length;
	        int widthMax = 0;
	        int heightMax = 0;
	        
	        for(int i = 0; i < length; i++) {
	            if(sizes[i][0] < sizes[i][1]) {
	                int temp = sizes[i][0];
	                sizes[i][0] = sizes[i][1];
	                sizes[i][1] = temp;
	            }
	        }
	        
	        for(int i = 0; i < length; i++) {
	            widthMax = Math.max(widthMax, sizes[i][0]);
	            heightMax = Math.max(heightMax, sizes[i][1]);
	        }
	        
	        
	        answer = widthMax * heightMax;
	        
	        return answer;
	    }
    
	public static void main(String[] args) {
		int[][] arr1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int[][] arr2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		int[][] arr3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
		System.out.println(solution(arr3));
	}
}
