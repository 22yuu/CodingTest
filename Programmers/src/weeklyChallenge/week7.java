package weeklyChallenge;

import java.util.*;

public class week7 {

    public static int[] solution(int[] enter, int[] leave) {
        int nPeople = enter.length;
        int[] answer = new int[nPeople];
        
        ArrayList<Integer> room = new ArrayList<>();
        
        for(int i = 0; i < nPeople; i++) {
            room.add(enter[i]);
            
            // 퇴실처리
            for(int j = 0; j < nPeople; j++) {
                
                if(leave[j] == 0) continue;
                
                if(room.contains(leave[j])) {
                	//System.out.println(leave[j]);
                	//System.out.println(room);
                	
                	room.remove(Integer.valueOf(leave[j]));
                	answer[leave[j] - 1] += room.size();
                	
                	for(int k = 0; k < room.size(); k++) {
                    	//System.out.println("size : " + room.size() + ", number : " + room.get(k));
                        answer[room.get(k) - 1]++;
                    }
                	leave[j] = 0;
                } else {
                	// 아직 입실을 안했을 경우
                	break;
                }
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] enter = {1,4,2,3};
		int[] leave = {2,1,3,4};
		
		int[] answer = solution(enter, leave);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}
}
