package jjayojjayo;

import java.util.List;

import jjayojjayo.food.Food;

public class Table {
	static int exp;
	static List<Food> list;
	static List<Food> tableList;
	static private int level;
	static int max_level = 101;
	
	//처음에 주문할 수 있는 주문 리스트
	static {
		level = 1;
		list.add(new Food("계란말이",1,1) {});
		list.add(new Food("김치찌개",1,2) {});
		list.add(new Food("된장찌개",1,3) {});
		
	}
	
	
	
	
	//내가 조정해야할 부분 부분
	synchronized static void add() {
		
	
		
	}
	
	synchronized void remove() {
		
		
		
		
	}
	
	static synchronized void setLevel(int exp) {
		if (Table.level + exp > max_level) {
			Table.level = 101;
		} else {
			Table.level += exp;
		}

		if (Table.level > 70) {
			for (int i = 0; i < Table.list.size(); i++) {
				if (Table.list.get(i).equals("애플파이")) {
				} else {
					list.add(new Food("애플파이", 3, 10));
				}

			}

		}

		if (Table.level > 30) {
			for (int i = 0; i < Table.list.size(); i++) {
				if (Table.list.get(i).equals("닭갈비")) {
				} else {
					list.add(new Food("닭갈비", 2, 5));
				}

			}

		}

	}

	static int getLevel() {
		return Table.level;
	}

}
