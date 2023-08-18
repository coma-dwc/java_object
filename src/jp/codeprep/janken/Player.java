package jp.codeprep.janken;

public class Player {
	private String name;
//	private Random random = new Random();
	private JankenStrategy strategy = new RandomStrategy();
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	//PlayerにStrategyのgetter/setterを追加
	public JankenStrategy getStrategy() {
		return this.strategy;
	}
	
	public void setStrategy(JankenStrategy strategy) {
		this.strategy = strategy;
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
	
//	public JankenHand nextHand() {
//		int n = random.nextInt(3);
//		return JankenHand.fromInt(n);
//	}
	
	
	//Randomを使用していたものからstrategyを使用するように置き換え
	public JankenHand nextHand() {
		return strategy.nextHand();
	}
}