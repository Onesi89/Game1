package jjayojjayo;

import jjayojjayo.food.Food;

public class Customer extends Thread {
	Food food; //주문한 음식
	Table table; //주문번호 ㅍ표시판
	int w; //반복횟수.


	Customer(Table table,int i,int w) {
		this.setName(i + "번째 손님");
		this.food = Food.foodlist.get(i);
		this.food.setJ(w); 

	}

	@Override
	public void run() {
		try {
			table.remove1(this);
		} catch (InterruptedException e) {
			System.out.println("인터럽트 오류");
		}
		
	}
		
		

}