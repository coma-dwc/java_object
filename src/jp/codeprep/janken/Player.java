package jp.codeprep.janken;

import java.util.Random;

public class Player {
	private String name;
	private Random random = new Random();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
//	public JankenHand nextHand() {
//		int n = random.nextInt(3);
//		switch (n) {
//		case 0: return JankenHand.Rock;
//		case 1: return JankenHand.Scissors;
//		case 2: return JankenHand.Paper;
//		}
//		throw new IllegalStateException();
//	}
	
	public JankenHand nextHand() {
		int n = random.nextInt(3);
		return JankenHand.fromInt(n);
	}
}