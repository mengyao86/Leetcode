package easy;

public class ExcelColumnNumber {

	public int titleToNumber(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			char lChar = s.charAt(i);
			num += getNumForCol(lChar, s.length() - i);
		}
		return num;
	}

	private int getNumForCol(char lChar, int i) {
		int num = 1;

		while (i > 1) {
			num = num * 26;
			i--;
		}

		if (num > 1) {
			num = num * (lChar - 'A' + 1);
		} else {
			num = lChar - 'A' + 1;
		}

		return num;
	}

	public static void main(String[] argus) {
		ExcelColumnNumber lExcelColumnNumber = new ExcelColumnNumber();
		int num = lExcelColumnNumber.titleToNumber("AAA");
		System.out.println(num);
	}
}
