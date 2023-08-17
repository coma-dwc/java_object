package jp.codeprep.janken;

public enum JankenHand {
	Rock,
	Scissors,
	Paper;
	
	@Override
	public string tosting() {
		switch (this) {
			case Rock: return "✊グー";
			case Scissors: return "✌チョキ";
			case Paper: return "✋パー";
		}
		throw new IllegalStateException();
	}
	
	public static JankenHand fromInt(int n) {
		switch (n % 3) {
			case 0: return Rock;
			case 1: return Scissors;
			case 2: return Paper;
		}
		throw new IllegalStateException(Integer.toString(n));
	}
	
	//winToメソッド
	public boolean winTo(JankenHand hand) {
		switch(this) {
			case Rock: return hand == Scissors;
			case Scissors: return hand == Paper;
			case Paper: return hand == Rock;
		}
		throw new IllegalStateException();
	}
	
	//loseToメソッド
	public boolean loseTo(JankenHand hand) {
		return this != hand && !winTo(hand);
	}
}