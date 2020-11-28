package sudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Game {

	public boolean[][] block;
	public boolean[][] x_ary;
	public boolean[][] y_ary;
	public String[][] question;
	public Map<String, List<Integer>> answerMap;

	public Game() {
		this.block = new boolean[9][9];
		this.x_ary = new boolean[9][9];
		this.y_ary = new boolean[9][9];
		this.answerMap = new HashMap<>();
	}

	public Game(String[][] question) {
		this.block = new boolean[9][9];
		this.x_ary = new boolean[9][9];
		this.y_ary = new boolean[9][9];

		this.question = question;
		this.answerMap = new HashMap<>();

		System.out.println("Quesrion:");
		DataPrinter.printData(question);

		for (int ix = 0; ix < 9; ix++) {
			for (int iy = 0; iy < 9; iy++) {
				List<Integer> numList = new ArrayList<>();
				if (this.question[iy][ix] != "_") {
					int num = Integer.valueOf(this.question[iy][ix]);
					this.setFixedNum(num, ix, iy);
					numList.add(num);
				}
				this.answerMap.put(ix + "" + iy, numList);
			}
		}
	}

	public void setFixedNum(final Integer num, int ix, int iy) {
		int blockNum = (ix / 3) + 3 * (iy / 3);
		this.block[blockNum][num - 1] = true;
		this.x_ary[ix][num - 1] = true;
		this.y_ary[iy][num - 1] = true;
	}

	public void updateAnswerMap() {
		List<Integer> possibleNum;

		for (int ix = 0; ix < 9; ix++) {
			for (int iy = 0; iy < 9; iy++) {
				int blockNum = (ix / 3) + 3 * (iy / 3);
				if (this.answerMap.get(ix + "" + iy).size() != 1) {
					possibleNum = new ArrayList<>();
					for (int ik = 0; ik < 9; ik++) {
						if (!this.block[blockNum][ik] && !this.x_ary[ix][ik] && !this.y_ary[iy][ik]) {
							possibleNum.add(ik + 1);
						}
					}
					if (possibleNum.size() == 1) {
						setFixedNum(possibleNum.get(0), ix, iy);
					}
					this.answerMap.put(ix + "" + iy, possibleNum);
				}
			}
		}
	}

	public void printAnswer() {
		String[][] answer = new String[9][9];

		for (Entry<String, List<Integer>> entry : this.answerMap.entrySet()) {
			int ix = Character.getNumericValue(entry.getKey().charAt(0));
			int iy = Character.getNumericValue(entry.getKey().charAt(1));
			answer[iy][ix] = entry.getValue().get(0).toString();
		}

		System.out.println("Answer:");
		DataPrinter.printData(answer);
	}
}
