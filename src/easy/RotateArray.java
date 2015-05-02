package easy;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		for( int i=0; i<k; i++ )
		{
			rotateToRightOneStep(nums);
		}
	}

	private void rotateToRightOneStep(int[] nums) {
		int pos = nums[nums.length-1];
		for( int i=nums.length-1; i>0; i-- )
		{
			nums[i] = nums[i-1];
		}
		nums[0] = pos;
	}

	public static void main(String[] args) {
		RotateArray lRotateArray = new RotateArray();
		int[] nums = {1};
		int k =2;
		lRotateArray.rotate(nums, k);
		
		for( int i=0; i<nums.length; i++ )
		{
		System.out.println( nums[i] );
		}
	}

}
