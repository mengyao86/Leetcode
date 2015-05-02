package hard;

public class MedianOfTwoSortedArray {
	
	public static void main(String args[])
	{
		int [] A = {1};
		int [] B = {1};
		double lRe = findMedianSortedArrays(A, B);
		System.out.println("\n" + lRe);
	}
	
	public static double findMedianSortedArrays(int A[], int B[])
	{
		double lRe = 0;
		int lPosOfA =0;
		int lPosOfB =0;
		int lPosOfC =0;
		int C[] = new int[A.length+B.length];
		
		if( B.length == 0 )
		{
			if( A.length%2 == 0 )
			{
				lRe = ((double)(A[A.length/2-1]  + A[A.length/2]))/2;
			}
			else
			{
				lRe = A[A.length/2];

			}
			return lRe;
		}
		
		//Assume A and B are sorted ascending 			
		while( lPosOfB < B.length )
		{	
			if (lPosOfA == A.length  || B[lPosOfB] <= A[lPosOfA]) 
			{
				C[lPosOfC++] = B[lPosOfB];
				lPosOfB++;
				continue;
			} 
			else 
			{
				C[lPosOfC++] = A[lPosOfA];
				lPosOfA++;
				while( lPosOfA < A.length )
				{
					if( lPosOfB == B.length || A[lPosOfA] <= B[lPosOfB] )
					{
						C[lPosOfC++] = A[lPosOfA];
						lPosOfA ++;
						continue;
					}
					else
					{
						break;
					}
				}			
			}
		}
		
		while( lPosOfA < A.length )
		{
			if( lPosOfB == B.length || A[lPosOfA] <= B[lPosOfB] )
			{
				C[lPosOfC++] = A[lPosOfA];
				lPosOfA ++;
				continue;
			}
			else
			{
				break;
			}
		}	
		
		
			
		
		if( C.length%2 == 0 )
		{
			lRe = ((double)(C[C.length/2-1]  + C[C.length/2]))/2;
		}
		else
		{
			lRe = C[C.length/2];

		}
				
		return lRe;
	}
}
