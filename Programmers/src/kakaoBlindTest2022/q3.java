package kakaoBlindTest2022;
import java.util.*;

public class q3 {


	class Solution {
	    
	    public int closeTime = 1439;
	    
	    public class Parking {
	        String carNumber;
	        int time;
	        boolean state;
	        
	        public Parking(String carNumber, int time, boolean state) {
	            this.carNumber = carNumber;
	            this.time = time;
	            this.state = state;
	        }
	    }
	    
	    public int[] solution(int[] fees, String[] records) {
	        int[] answer;
	        int totalCars = 0; // 총 차량의 수
	        
	        StringTokenizer st;
	        HashMap<String, Integer> hm = new HashMap<>(); // 차량의 주차 누적 시간을 저장
	        
	        List<String> carList = new ArrayList<>();
	        List<Parking> parkingList = new ArrayList<>();
	        
	        for(int i = 0; i < records.length; i++) {
	            st = new StringTokenizer(records[i]);
	            
	            String tempTimeValue = st.nextToken();
	            String carNumber = st.nextToken();
	            String state = st.nextToken();
	            boolean isOut = state.equals("IN") ? false : true;
	            
	            int hh = Integer.parseInt(tempTimeValue.split(":")[0]);
	            int mm = Integer.parseInt(tempTimeValue.split(":")[1]);
	            
	            int time = hh*60 + mm;
	            
	            if(!carList.contains(carNumber)) {
	                carList.add(carNumber);
	                hm.put(carNumber, 0);
	            }
	            
	            if(!isOut) {
	                // IN
	                parkingList.add(new Parking(carNumber, time, isOut));
	            } else {
	                // OUT
	                int idx = 0;
	                for(Parking p : parkingList) {
	                    String cno = p.carNumber;
	                    
	                    if(cno.equals(carNumber)) {
	                        int newTime = time - p.time;
	                        parkingList.remove(idx);
	                        hm.put(carNumber, hm.get(carNumber) + newTime);
	                        break;
	                    }
	                    
	                    idx++;
	                }
	            }
	        }
	        
	        totalCars = carList.size();
	        answer = new int[totalCars];
	        
	        if(!parkingList.isEmpty()) {
	            for(Parking p : parkingList) {
	                int newTime = closeTime - p.time;
	                hm.put(p.carNumber, hm.get(p.carNumber) + newTime);
	            }
	        }
	        
	        Collections.sort(carList);
	        
	        int freeTime  = fees[0]; // 기본 시간
	        int basicFee  = fees[1]; // 기본 요금
	        int perMinute = fees[2]; // 단위 시간
	        int perFee    = fees[3]; // 단위 요금
	                
	        for(int i = 0; i < totalCars; i++) {
	            int resultTime = hm.get(carList.get(i)); // 누적 시간
	            int totalPrice = 0;
	            //System.out.println("result Time : " + resultTime);
	            
	            //주차 요금 : 기본 요금 + [(누적시간 - 기본시간) / 단위 시간] x 단위요금
	            if(resultTime <= freeTime ) {
	                answer[i] = basicFee;
	                continue;
	            } else {
	                int price = (int)Math.ceil((double)(resultTime - freeTime) / perMinute);
	                price = price * perFee;
	                totalPrice = basicFee + price;
	            }
	            
	            //System.out.println(basicFee + "+" + "((" + resultTime + " - " + freeTime + ") / " + perMinute + ") * " + perFee);
	            answer[i] = totalPrice;
	            
	        }
	        
	  
	        
	        return answer;
	    }
	}
}
