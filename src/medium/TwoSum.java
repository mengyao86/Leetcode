package medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main( String[] args )
	{
		int[] lResult = new int[2];
		int[] array = {1,2,3,4,5,6};
		
		lResult = twoSum(array, 5);
		System.out.println(lResult[0]);
		System.out.println(lResult[1]);

	}

	 public static int[] twoSum(int[] numbers, int target) 
	 {
	        int[] lReturn = new int[2];
	        
	        //store in hash set
	        Map<Integer, String> lMap = new HashMap<Integer, String>();
	        for( int i =0; i< numbers.length; i++ )
	        {
	        	String lPreviousValue = lMap.put(numbers[i], String.valueOf(i));
	        	if( lPreviousValue != null)
	        	{
	        		//if duplicated value exist, then concrete the indices with common as seperator
	        		String lConcrete = lPreviousValue+","+String.valueOf(i);
	        		lMap.put(numbers[i], lConcrete);
	        	}
	        }
	        
	        for( int key : lMap.keySet() )
	        {
	        	int lLeft = target - key;
	        	String lValue = lMap.get(lLeft);
	        	if( lValue != null )
	        	{
	        		//found the pair
	        		String[] lString = lValue.split(",");
	        		if( lString.length == 1 )
	        		{
	        			lReturn[0] = Integer.parseInt(lMap.get(key)) + 1;
	        			lReturn[1] = Integer.parseInt(lString[0]) + 1;
	         		}
	        		else if( lString.length == 2 )
	        		{
	        			//the result was 2 numbers with same value 
	        			lReturn[0] = Integer.parseInt(lString[0]) + 1;
	        			lReturn[1] = Integer.parseInt(lString[1]) + 1;
	        		}
	        	}
	        }
	        if( lReturn[0] > lReturn[1] )
	        {
	        	int lTmp = lReturn[0];
	        	lReturn[0] = lReturn[1];
	        	lReturn[1] = lTmp;
	        }
	        
	        return lReturn;
	    }
}
