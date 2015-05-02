package medium;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int area = 0;
		int left=0;
		int right=height.length-1;
		
		while( left<right )
		{
			int tmp = getContainerSize(left + 1, height[left], right + 1, height[right]);
			if (area < tmp) 
			{
				area = tmp;
			}
			
			if( height[left]<height[right] )
			{
				left ++;
			}
			else
			{
				right --;
			}
		}

		return area;
	}

	private static int getContainerSize(int aInfirstX, int aInFirstY,
			int aInSecondX, int aInSecondY) {
		Integer lSize = (aInSecondX-aInfirstX)
				* (aInFirstY > aInSecondY ? aInSecondY : aInFirstY);
		return lSize;
	}
	
	public static void main (String[] args)
	{
		ContainerWithMostWater lContainerWithMostWater = new ContainerWithMostWater();
		int[] height = {2,2,10,1};
		int lreturn = lContainerWithMostWater.maxArea(height);
		
		System.out.println(lreturn);
	}
}
