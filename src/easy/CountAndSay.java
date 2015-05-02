package easy;

public class CountAndSay {

	public String countAndSay(int n) 
    {
        String lCountAndSay = "1";
        for( int i=1; i<n; i++ )
        {
            String lNext = getNPlusOneByN(lCountAndSay);
            lCountAndSay =lNext;
        }
        
        return lCountAndSay;
    }
    
    private String getNPlusOneByN(String n)
    {
        String lReturn = "";
        char[] lCharArray = n.toCharArray();
        
        int lLength = lCharArray.length;
        int lPosition = 0;
        while( lPosition < lLength  )
        {
            char lithChar = lCharArray[lPosition];
            int count = 1;
            while (lPosition+count<lLength && lCharArray[lPosition+1] == lithChar  )
            {
                count ++;
            }
            lReturn = lReturn + String.valueOf(count) + lithChar;
            
            lPosition = lPosition+count;
        }
        return lReturn;
        
    }
    
    public static void main (String[] args)
	{
    	CountAndSay lCountAndSay = new CountAndSay();
    	String lReturn = lCountAndSay.countAndSay(4);
		System.out.println(lReturn);
		
		lReturn = lCountAndSay.countAndSay(5);
		System.out.println(lReturn);
	}
}
