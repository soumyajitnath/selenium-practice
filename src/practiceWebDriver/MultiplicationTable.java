package practiceWebDriver;

public class MultiplicationTable {
	
	private int number;

	public void setNumber(int n){
		this.number = n;
		System.out.println("Number set by object : "+ number);
		
	}
	
	public static void multiplication(int number){
		
		System.out.println("Multiplication Table of Number :" + number);
		
		for(int i=1;i<=10;i++){
			
			System.out.println(number +" x " +i+" = "+ number * i);
			
		}
	}

	public static void main(String[] args) {
		
		//Create object
		//ClassName referencevariable = new ClassName();
		MultiplicationTable obj = new MultiplicationTable();
		
		// Local variable initialised
		int number = 9;
		
		//Invoke set method
		obj.setNumber(number);
		
		multiplication(number);

	}

}
