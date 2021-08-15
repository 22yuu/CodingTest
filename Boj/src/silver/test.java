package silver;

public class test {
	
	
	public static void main(String[] args) {
		String names[] = {"EMMA", "RODRIGO", "BRIAN", "DAVID"};
		
		for(int i =0; i< 4; i++) {
			if(names[i] == "EMMA") {
				System.out.println("Found");
				return;
			}
		}
		
		System.out.println(names[0].equals("EMMA"));
		System.out.println("Not Found");
		return;
	}
}
