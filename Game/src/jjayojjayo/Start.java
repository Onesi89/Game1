package jjayojjayo;

public class Start {
	public static void main(String[] args) {
		Table table = new Table();
		
		Customer cus1 = new Customer(table,1,5);
		Customer cus2 = new Customer(table,2,5);
		Cook cook = new Cook(table);
		
		Delay.del(1000);
		cook.setDaemon(true);
		cook.start();
		
	
		cus1.start();
		cus2.start();
		
		try {
			cus1.join();
			cus2.join();
		} catch (InterruptedException e) {
			System.out.println("오류가 났습니다.");
		}
		System.out.println("손님이 다 먹었습니다.");
		System.exit(0);
	}

}
