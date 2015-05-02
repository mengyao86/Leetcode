package easy;

import practice.Test;

public class HouseRobber {

	public static void main(String[] args) 
	{	
		int [] houses = {2,1,1,2};
		int re = new HouseRobber().rob(houses);
		System.out.println(re);
		
	}
	
	public int rob(int[] nums)
	{
		if( nums.length == 0 )
		{
			return 0;
		}
		else if( nums.length == 1 )
		{
			return nums[0];
		}
		else if( nums.length == 2 )
		{
			return Math.max(nums[0], nums[1]);
		}
		
		int best0 = nums[0]; 
		int best1 = nums[1];  
		for( int i=2; i<nums.length; i++ )
		{
			int tmp = best0 + nums[i];
			if( tmp > best1 )
			{
				best0 = Math.max(best0, best1);
				best1 = tmp;
			}
			else
			{
				best0=best1;
			}
		}
		
        return Math.max(best0, best1);
    }
}
