package jjayojjayo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import jjayojjayo.food.Food;

public class Table {
	static private int level;
	static private int exp; // 식당 경험치
	static public List<Food> list; // 만들 수 있는 음식 리스트
	static public List<Food> ready; // 준비가 된 음식 리스트
	static private int maxReady;
	Integer key;

	// 처음에 주문할 수 있는 주문 리스트, static 필드로 초기화
	static {

		level = 1;
		exp = 0;
		list = new ArrayList<Food>();
		ready = new ArrayList<Food>();
		list.add(new Food("계란말이", 1, 1) {
		});
		list.add(new Food("김치찌개", 1, 2) {
		});
		list.add(new Food("된장찌개", 1, 3) {
		});
		maxReady = 3;

	}
	
	// 준비된 음식 음식
	public void add() throws InterruptedException {
		synchronized (this){
		Delay.del(500);

		while (true) {
			if (ready.size() == maxReady) {
				show();
				wait();
			}

			while (ready.size() < maxReady) {
				int n = new Random().nextInt(list.size());
				ready.add(list.get(n));
				// System.out.println(list.get(n).getName() + " 준비되었습니다.");
				show();
				notifyAll(); // 준비된것을 다른 쓰레들에게 알림.
			}
		}
		}
	}

	// 손님들이 먹음
	public synchronized void remove1(Customer cus) throws InterruptedException {
		System.out.println("& " + cus.getName() + "은 " + cus.food.getName() + "가 먹고 싶다.");

		// 반복 횟수
		int j = 0;

		// 반복 문
		while (true) {

			// 준비된 음식이 없을 때 기다려라.
			if (Table.ready.size() == 0) {
				j++;
				System.out.println(cus.getName() + " " + j + "번 째 기다리는 중 - 준비된 음식 없음");
				wait();

			} else {
				// r = new Random();
				//
				// int number = r.nextInt(Table.list.size());

				// 준비된 음식과 내가 주문한 하는 음식이 같다면 먹고, 다른 쓰레드들을 깨우자.
				for (int i = 0; i < Table.ready.size(); i++) {
					if (Table.ready.get(i).equals(cus.food)) {

						Table.ready.remove(i);
						System.out.println("!--  " + cus.getName() + "이 " + cus.food.getName() + "를 먹었습니다.");
						show();
						notifyAll();
						Table.setExp(cus.food.getExp());
						System.out.println("■ 경험치 " + cus.food.getExp() + " 를 획득했습니다.");
						return;

						// 준비된 음식과 내가 주문한 음식이 다르면 기다리자.
					} else {
					}
				}

				j++;
				System.out.println(cus.getName() + " " + j + "번 째 기다리는 중 - 내가 원하는 음식 없음");
				if (j == cus.w) {
					System.out.println(cus.getName() + "님이 떠나갔습니다.");
					Table.setExp(-3);
					return;
				}
				wait();

			}
		}
	}

	// 나의 캐릭터가 조정해야할 부분 부분
	public synchronized void remove2() {

	}

	static void setExp(int exp) {
		if ((Table.exp + exp) > 100) {
			Table.level -= 100;
			Table.levelup();
			System.out.println("레벨업을 하셨습니다.");

		} else {
			Table.exp += exp;
		}

	}

	static synchronized void levelup() {
		Table.level++;

		if (Table.level > 20) {
			for (int i = 0; i < Table.list.size(); i++) {
				if (Table.list.get(i).equals("애플파이")) {
				} else {
					list.add(new Food("애플파이", 3, 10) {
					});
				}

			}
		}

		if (Table.level > 10) {
			for (int i = 0; i < Table.list.size(); i++) {
				if (Table.list.get(i).equals("닭갈비")) {
				} else {
					list.add(new Food("닭갈비", 2, 5) {
					});
				}

			}

		}
	}

	static int getLevel() {

		return Table.level;
	}

	static synchronized void show() {
		String readylist[] = new String[3];
		for (int i = 0; i < ready.size(); i++) {
			readylist[i] = ready.get(i).getName();
		}
		System.out.println(Arrays.toString(readylist));

	}

}
