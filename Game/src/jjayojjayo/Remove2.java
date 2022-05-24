package jjayojjayo;

import javax.swing.JOptionPane;

public class Remove2 extends Thread {

	@Override
	public void run() {
		Delay.del(1000);
		
		while(true) {
		Delay.del(500);
		
		int remove = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력하세요."));
		Table.ready.remove(remove);
		Table.show();
		
		


		}
	}
}
