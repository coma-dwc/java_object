package jp.codeprep.janken;

import java.util.Random;

//じゃんけん戦略を分離する JankenStrategyを定義
public interface JankenStrategy {
	public JankenHand nextHand();
}

class RandomStrategy implements JankenStrategy {
	private Random random = new Random();
	
	public JankenHand nextHand() {
		int n = random.nextInt(3);
		return JankenHand.fromInt(n);
	}
}

class FixedHandStrategy implements JankenStrategy {
	
	private JankenHand hand;
	
	public FixedHandStrategy(JankenHand hand) {
		this.hand = hand;
	}
	
	public JankenHand nextHand() {
		return this.hand;
	}
}