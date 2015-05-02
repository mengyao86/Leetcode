package easy;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		
		int lReturn[] = new int[digits.length +1];
		
		boolean isCarry = true;
		for( int i=digits.length-1; i>=0; i-- )
		{
			
			int currentDig = digits[i];
			if( isCarry )
			{
				currentDig = digits[i] +1;

			}
			if( currentDig <=9 )
			{
				lReturn[i+1] = currentDig;
				isCarry = false;
			}
			else
			{
				lReturn[i+1] = 0;
				isCarry = true;
				if( i==0 )
				{
					lReturn[0]=1;
				}
			}
			
		}
			
		if( lReturn[0] ==0 )
		{
			int[] lRe = new int[lReturn.length-1];
			for( int i=1; i< lReturn.length; i++ )
			{
				lRe[i-1] = lReturn[i];
			}
			
			return lRe;
		}
		return lReturn;
	}

	public static void main(String[] args) {
			PlusOne lPlusOne = new PlusOne();
			int[] digits = {9,9,9,9,9,9,9,9,9,9,9,9};
			int[] lRe = lPlusOne.plusOne(digits);
			
			for( int i=0; i< lRe.length; i++ )
			{
				System.out.println(lRe[i]);
			}
	}
}
