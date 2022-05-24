package jjayojjayo;

public class Delay {
	public static void del(long a) {
		try{Thread.sleep(a);}catch(InterruptedException e) {};
	}

}
