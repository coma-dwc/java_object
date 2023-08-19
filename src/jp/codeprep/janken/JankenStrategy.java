package jp.codeprep.janken;

import java.util.Random;

//じゃんけん戦略を分離する JankenStrategyを定義
public interface JankenStrategy {
	//JankenStrategyにprevHandsを追加
	public default void prevHands(JankenHand myHand, JankenHand opponentHand) {}
	
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

class ChottoKashikoiStrategy implements JankenStrategy {
	
	private JankenHand prevMyHand;
	private JankenHand prevOpponentHand;
	
	@Override
	public void prevHands(JankenHand myHand, JankenHand opponentHand) {
		prevMyHand = myHand;
		prevOpponentHand = opponentHand;
	}
	
	public JankenHand nextHand() {
		//初回は前回の手がないのでRandomStrategyを流用
		if(prevMyHand == null || prevOpponentHand == null) {
			return new RandomStrategy().nextHand();
		}
		if(prevMyHand.winTo(prevOpponentHand)) { //自分が勝った場合
			return JankenHand.fromInt(prevMyHand.ordinal() + 1);
		} else if (prevMyHand.loseTo(prevMyHand)) { //相手が勝った場合
			return prevOpponentHand;
		} else {
			return prevMyHand;
		}
	}
}