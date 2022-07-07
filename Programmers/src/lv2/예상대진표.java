package lv2;

public class 예상대진표 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 1라운드에서 만나냐?
        if(a % 2 == 0) {
            if(a - 1 == b) return 1;
        } else {
            if(a + 1 == b) return 1;
        }
        
        // 라운드별로 만나는 횟수 카운트
        while(n >= 1) {
            
            int newA = a / 2;
            int newB = b / 2;
            
            if(newA % 2 == 0) {
                if(newA - 1 == newB) return ++answer;
            } else {
                if(newA + 1 == newB) return ++answer;
            }
            
            n /= 2;
            answer++;
        }

        return answer;
    }
}
