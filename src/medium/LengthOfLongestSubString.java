package medium;

import java.util.LinkedHashSet;
import java.util.Set;

public class LengthOfLongestSubString {

	public int lengthOfLongestSubstring(String s) {
		
		if ( s.isEmpty())
		{
			return 0;
		}
		int length = 1;
		Set<String> lSet = new LinkedHashSet<String>();
		for( int i=0; i<s.length(); i++ )
		{
			int lTmp = getlengthFromIndex( s, i, lSet);
			
			if( lTmp > length )
			{
				length = lTmp;
			}
			
			lSet.remove(String.valueOf(s.charAt(i)));
		}
		return length;
	}

	private int getlengthFromIndex(String s, int i, Set<String> set) {
		int sizeOfSet =set.size();
		for( int j=i+set.size();j<s.length() ;j++ )
		{
			String lChar = String.valueOf(s.charAt(j));
			set.add(lChar);
			if( set.size() >sizeOfSet )
			{
				sizeOfSet++;
			}
			else
			{
				return sizeOfSet;
			}
		}
		return sizeOfSet;
	}
	
	
	public static void main(String[] args) 
	{
		String lString ="123456789012345678901234567890";
		LengthOfLongestSubString lLengthOfLongestSubString = new LengthOfLongestSubString();
		int length = lLengthOfLongestSubString.lengthOfLongestSubstring(lString);
		System.out.println(length);
	}
	
}
