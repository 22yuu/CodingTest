package lv2;

public class �������ǥ {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 1���忡�� ������?
        if(a % 2 == 0) {
            if(a - 1 == b) return 1;
        } else {
            if(a + 1 == b) return 1;
        }
        
        // ���庰�� ������ Ƚ�� ī��Ʈ
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
