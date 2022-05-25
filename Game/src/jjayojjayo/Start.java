package jjayojjayo;

import java.util.ArrayList;
import java.util.List;

public class Start {
	static List<Customer> customerList;
	
	
	public static void main(String[] args) {
		Table table = new Table();
		Cook cook = new Cook(table);
		Remove2 remove = new Remove2(table);

		Delay.del(1000);
		cook.setDaemon(true);
		cook.start();
		remove.setDaemon(true);
		remove.start();

		//초기 손님
		
		Start.customerList = new ArrayList<Customer>(); 
		Start.customerList.add(new Customer(table, 1, 5));
		Start.customerList.add(new Customer(table, 2, 5));
		Start.customerList.add(new Customer(table, 3, 5));
		
		Start.customerList.get(0).start();
		Start.customerList.get(1).start();
		Start.customerList.get(2).start();
	
		int i = 4;
		
		while (true) {
			Delay.del(5000);
			
			if (Start.customerList.size() < table.maxCustomerNumber) {
				System.out.println("새로운 손님이 왔습니다.");
				Start.customerList.add(new Customer(table, i++, 5));
				Start.customerList.get(Start.customerList.size()-1).start();

//				System.out.println("모든 손님이 다 먹었습니다.");

			}
			
//			try {
//				cus1.join();
//				cus2.join();
//			} catch (InterruptedException e) {
//				System.out.println("오류가 났습니다.");
//			}

//			System.exit(0);
		}
	}
}
