package jjayojjayo;

public class Start {
	public static void main(String[] args) {
		Table table = new Table();
		
		Customer cus1 = new Customer(table,1,5);
		Customer cus2 = new Customer(table,2,5);
		Cook cook = new Cook(table);
		
		cook.start();
		cus1.start();
		cus2.start();
		
		
	}

}
