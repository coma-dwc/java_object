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
}