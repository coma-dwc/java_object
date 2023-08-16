package jp.codeprep.janken;

public enum JankenHand {
	Rock,
	Scissors,
	Paper;
	
	@Override
	public String toSting() {
		switch (this) {
			case Rock: return "✊グー";
			case Scissors: return "✌チョキ";
			case Paper: return "✋パー";
		}
		throw new IllegalStateException();
	}
}