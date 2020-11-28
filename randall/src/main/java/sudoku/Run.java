package sudoku;

class Run {
	
	private static boolean flg;

	public static void main(String[] args) {

		long startSec = System.currentTimeMillis();

		String[][] question = new String[][] { { "_", "4", "_", "2", "5", "_", "_", "_", "8" },
				{ "_", "3", "_", "4", "_", "9", "1", "7", "_" }, { "_", "_", "_", "_", "8", "1", "2", "_", "_" },
				{ "_", "_", "6", "_", "_", "_", "7", "2", "_" }, { "_", "_", "_", "6", "_", "4", "_", "_", "_" },
				{ "_", "1", "2", "_", "_", "_", "3", "_", "_" }, { "_", "_", "3", "8", "1", "_", "_", "_", "_" },
				{ "_", "6", "4", "9", "_", "2", "_", "1", "_" }, { "7", "_", "_", "_", "4", "5", "_", "9", "_" } };

		Game game = new Game(question);

		setFlg(true);

		while (flg) {

			setFlg(false);
			game.answerMap.entrySet().stream().filter(map -> map.getValue().size() != 1).forEach(map -> {
				game.updateAnswerMap();
				setFlg(true);
			});
		}
		game.printAnswer();

		System.out.printf("Spent Time: %d milliseconds", System.currentTimeMillis() - startSec);
	}

	private static void setFlg(boolean bool) {
		flg = bool;
	}
}