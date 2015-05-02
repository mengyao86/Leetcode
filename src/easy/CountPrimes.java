package easy;

import practice.Test;

public class CountPrimes 
{
	public static void main(String[] args) 
	{
		int re = new CountPrimes().countPrimes(2);
		System.out.println(re);
		
	}
	public int countPrimes(int n)
	{
		n=n-1;
		if( n<=1 )
		{
			return 0;
		}
		
		int re = 0;
		int maxDivisor = (int) Math.sqrt(n) +1;
		
		boolean[] booleanArray = new boolean[n+1];
		for( int i=0; i<=n; i++ )
		{
			booleanArray[i] = true;
		}
		
		booleanArray[0]=false;
		booleanArray[1]=false;
		for( int i=2; i<=maxDivisor; i++ )
		{
			if( booleanArray[i] )
			{
				for( int j=2; j*i<=n; j++ )
				{
					booleanArray[j*i]=false;
				}
			}
		}
		
		for( int i=0; i<= n; i++ )
		{
			if( booleanArray[i] )
				re++;
		}
		
		return re;
    }
}
