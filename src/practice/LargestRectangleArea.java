package practice;

public class LargestRectangleArea 
{
	public int largestRectangleArea(int[] height) 
	{
        int lReturn = 0;
        int left = 0;
        int right = height.length-1;
        	
        lReturn = calculateLargestRectangle(height, left, right);
        return lReturn;
    }
	
	private int getMinValuePosition(int[] height, int left, int right)
	{
		int lMinValue = height[left];
		int lMinValuePosition = left;

		for( int i=left; i<=right; i++ )
		{
			if( lMinValue > height[i] )
			{
				lMinValue = height[i];
				lMinValuePosition =i;
			}
		}
		return lMinValuePosition;
	}
	
	private int calculateLargestRectangle(int[] height, int left, int right)
	{
		if( left==right-1 )
		{
			
			return height[left]<height[right]?height[left]:height[right]*2;
		}
		else if( left == right)
		{
			return height[left];
		}
		else if( left > right )
		{
			return 0;
		}
		
				
		int minValuePosition = getMinValuePosition(height, left, right);
        
		int largest = height[minValuePosition] * (right-left+1);
		
		int leftArea = calculateLargestRectangle(height, left, minValuePosition-1); 
		int rightArea = calculateLargestRectangle(height, minValuePosition+1, right); 

        if( leftArea>largest )
        {
        	largest = leftArea;
        }
        
        if( rightArea>largest )
        {
        	largest = rightArea;
        }
        return largest;
	}
	
	
	
	
	
	
	public static void main (String[] args)
	{
		
		LargestRectangleArea lLargestRectangleArea = new LargestRectangleArea();
		
		int[] height = {1,6,6,6,1,20};
		int lReturn = lLargestRectangleArea.largestRectangleArea(height);
		System.out.println(lReturn);

	}
}
