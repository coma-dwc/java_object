package jp.codeprep.janken;

public class Main {
	public static void main(String[] args) {
		Player player1 = new Player("Taro");
		Player player2 = new Player("Hanako");
//		System.out.println(player1.getName());
//		System.out.println(player2.getName());
		JankenHand hand1 = player1.nextHand();
		JankenHand hand2 = player2.nextHand();
		
		System.out.println(
			String.format("%s: %s - %s :%s",
				player1.getName(), hand1,
				hand2, player2.getName()
			)
		);
	}
}