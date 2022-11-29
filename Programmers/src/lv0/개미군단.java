package lv0;

public class 개미군단 {

	public static int solution(int hp) {
        int answer = 0;
        int ant[] = {5,3,1};
        int idx = 0;
        
        while(hp > 0) {
            int ants = hp / ant[idx];
            answer += ants;
            hp = hp - (ant[idx] * ants);
            idx++;
            System.out.println(hp);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		System.out.println(solution(23));
	}
}
