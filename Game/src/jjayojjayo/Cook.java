package jjayojjayo;

public class Cook extends Thread {
	Table table;
	
	Cook(Table table){
		this.table = table;
	}

	@Override
	public void run() {
		Delay.del(1000);
		
		try {
			table.add();
		} catch (InterruptedException e) {
			System.out.println("오류가 났어요.");
		}

	}
}