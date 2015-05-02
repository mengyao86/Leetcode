package easy;

public class NumOfOneBits {

	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {	
    	int lRe = 0;
    	
    	while(n!=0)
    	{
    		n = n & (n-1);
    		lRe ++;
    	}
    	return lRe;
    }
    
    public static void main(String[] args)
    {
    	NumOfOneBits lNumOfOneBits = new NumOfOneBits();
    	
    	int re = lNumOfOneBits.hammingWeight(0x11111111);
    	System.out.println( re );
    }
    
    
}
