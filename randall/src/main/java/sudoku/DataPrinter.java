package sudoku;

public class DataPrinter {
	public static String lineHor = "-------------------------------";
	public static String lineVer = "|";

	public static void printData(String[][] data) {
		for (int i = 0; i < data.length; i++) {
			if (i % 3 == 0) {
				System.out.println(lineHor);
			}
			for (int j = 0; j < data[i].length; j++) {
				if (j % 3 == 0) {
					System.out.print(lineVer);
				}
				System.out.print(" " + data[i][j] + " ");
			}
			System.out.print(lineVer);
			System.out.println();
		}
	}
}
