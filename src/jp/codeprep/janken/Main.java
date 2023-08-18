package jp.codeprep.janken;

public class Main {
	//じゃんけん10回繰り返し
	private static int JANKEN_COUNT = 10;
	
	public static void main(String[] args) {
		Player player1 = new Player("Taro");
		Player player2 = new Player("Hanako");
		
		//勝利数初期化
		int player1win = 0;
		int player2win = 0;
		
//		System.out.println(player1.getName());
//		System.out.println(player2.getName());
		for (int i=0; i<JANKEN_COUNT; i++) {
			JankenHand hand1 = player1.nextHand();
			JankenHand hand2 = player2.nextHand();
		
		
		//勝敗を表示する
		String result = hand1.winTo(hand2) ?
							player1.getName() + "の勝利" :
						hand1.loseTo(hand2) ?
							player2.getName() + "の勝利" : "あいこ";
		
		
		System.out.println(
			String.format("%s: %s - %s :%s (%s)",  //(%s)を追記
				player1.getName(), hand1,
				hand2, player2.getName(),
				result  //resultを追記
			)
		);
		if (hand1.winTo(hand2)) {
			player1win++;
		}
		if (hand2.winTo(hand1)) {
			player2win++;
		}
		}
		String finalResult = player1win > player2win ?
								player1.getName() + "の勝利" :
							player2win > player1win ?
								player2.getName() + "の勝利" : "引き分け";
		System.out.println(
				String.format("%s!!!(%s: %d - %d :%s)",
					finalResult,
					player1.getName(), player1win,
					player2win, player2.getName()
				)
		);
	}
}