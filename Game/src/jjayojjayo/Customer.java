package jjayojjayo;

import java.util.Random;

import jjayojjayo.food.Food;

public class Customer extends Thread {
	Food food; //주문한 음식
	Table table; //주문번호 표시판
	int w; //반복횟수.
	int p;


	Customer(Table table,int i,int w) {
		this.setName(i + "번째 손님");
		this.food = Table.list.get(new Random().nextInt(Table.list.size()));
		this.food.setJ(w); 
		this.table = table;
		
	}

	@Override
	public void run() {
		Delay.del(4000);

		try {
			table.remove1(this);
		} catch (InterruptedException e) {
			System.out.println("인터럽트 오류");
		}
		
	}
		
		

}