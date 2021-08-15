package lv3;

import java.util.*;

public class 셔틀버스 {
	
	static PriorityQueue<Crew> pq;
    static Crew crew;
    
    public static class Crew implements Comparable<Crew> {
        int time;

        public Crew(String busTime) {
            int hh = Integer.parseInt(busTime.split(":")[0]);
            int mm = Integer.parseInt(busTime.split(":")[1]);
            this.time = hh*60 + mm;
        }
        
        @Override
        public int compareTo(Crew crew) {
            return Integer.compare(this.time, crew.time);
        }
    }
    
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer         = "";
        int currentBusTime    = 540;
        int numOfCrews        = timetable.length;
        pq                    = new PriorityQueue<>();
        
        
        for(int i = 0; i < numOfCrews; i++) {
            pq.offer(new Crew(timetable[i]));
        }
        
        for(int i = 0; i < n; i++) {
            int count = 0;

            while(!pq.isEmpty()) {
                crew = pq.poll();

                if(isGetOn(crew, currentBusTime)) {
                    // 탑승할 수 있으면?
                    count++;
                    if(m == count) break;
                } else {
                    // 탑승할 수 없으면?
                    pq.offer(crew);
                    break;
                }
                
                
            } // while end
            
            if(i == n-1) {
                // 마지막 버스
                int time = crew.time - 1;
                if(m > count) {
                    //충분히 다 탈 수 있을 때 버스 도착 시간에 옴
                    answer = convertToString(currentBusTime/60, currentBusTime%60);
                } else {
                    // 기다리는 크루원들의 수가 같을 때 혹은 보다 많을 때 마지막 앞에 도착해야함
                    answer = convertToString(time/60, time%60);
                }
            }
            // 다음 셔틀버스 갱신    
            currentBusTime += t;
            
        }// for end

        return answer;
    }
    
    public static boolean isGetOn(Crew crew, int busTime) {
        
        int time = crew.time;
       
        if(busTime >= time) {
            // 탑승 가능
            return true;
        } else {
            // 탑승 불가
            return false;
        }
    }

    
    public static String convertToString(int hh, int mm) {
        
        StringBuilder sb = new StringBuilder();
        
        if(mm >= 60) {
            hh += 1;
            mm = 0;
        }
        
        if(hh / 10 == 0) {
            sb.append("0").append(hh);
        } else {
            sb.append(hh);
        }
        
        if(mm / 10 == 0) {
            sb.append(":").append("0").append(mm);
        } else {
            sb.append(":").append(mm);
        }
        
        return sb.toString();
    }
	
    static class InputData {
    	int n, t, m;
    	String[] timetable;
    	
    	public InputData(int n, int t, int m, String[] timetable) {
    		this.n = n;
    		this.t = t;
    		this.m = m;
    		this.timetable = timetable;
    	}
    }
    
	public static void main(String[] args) {
		
		InputData[] datas = new InputData[6];
		String[] str1 = {"08:00", "08:01", "08:02", "08:03"};
		String[] str2 = {"09:10", "09:09", "08:00"};
		String[] str3 = {"09:00", "09:00", "09:00", "09:00"};
		String[] str4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
		String[] str5 = {"23:59"};
		String[] str6 = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
		
		
		datas[0] = new InputData(1, 1, 5, str1);
		datas[1] = new InputData(2, 10,2, str2);
		datas[2] = new InputData(2, 1, 2, str3);
		datas[3] = new InputData(1, 1, 5, str4);
		datas[4] = new InputData(1, 1, 1, str5);
		datas[5] = new InputData(10, 60, 45, str6);
		
		
		
		for(int i = 0; i < datas.length; i++) {
			System.out.println(solution(datas[i].n, datas[i].t, datas[i].m, datas[i].timetable));
		}
	}
}
