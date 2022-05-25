package jjayojjayo;

public class Remove2 extends Thread {
	
	Table table;
	
	Remove2(Table table){
		this.table = table;
	}
	
	

	

	@Override
	public void run() {
		table.remove2();
		}

}
