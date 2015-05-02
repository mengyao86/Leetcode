package easy;

public class ExcelColumnTitle {
	public String convertToTitle(int n) {
		String lRe = "";
		
		int lReminder = n%26==0?26:n%26;
		char lLastChar = getAbcByNum(lReminder);
		
		lRe =  String.valueOf(lLastChar);
		
		int lLeft =  (n-lReminder)/26;		
		while( lLeft > 0 )
		{	
			lReminder = lLeft%26==0?26:lLeft%26;
			lLastChar = getAbcByNum(lReminder);
			lRe = String.valueOf(lLastChar) + lRe;
			lLeft = (lLeft - lReminder)/26;
		}
		
		return lRe;
	}

	private char getAbcByNum(int num) {
		
		return (char) ('A'+num-1);
	}
	
	public static void main(String[] args)
	{
		ExcelColumnTitle lExcelColumnTitle = new ExcelColumnTitle();
		String lRe = lExcelColumnTitle.convertToTitle(26*26*26 + 26*26 + 26);
		System.out.println(lRe);
	}
}
