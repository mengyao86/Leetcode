package hard;

public class LargestRectangleArea_stack {

	public int largestRectangleArea(int[] height) {

		int area = 0;
		int[] stack = new int[height.length+1];
		int[] width = new int[height.length+1];

		if (height.length == 0)
			return 0;

		int top = 0;
		stack[top] = height[0];
		width[top] = 1;
		int newHeight;
		for (int i = 1; i <= height.length; i++) {
			if (i == height.length) {
				newHeight = -1;
			} else {
				newHeight = height[i];
			}

			if (newHeight >= stack[top]) {
				// push in
				top++;
				stack[top] = newHeight;
				width[top] = 1;
			} else {
				// pop up
				int widthAccu = 0;
				while (stack[top] >= newHeight && top >= 0) {
					widthAccu += width[top];
					area = area > stack[top] * (widthAccu) ? area : stack[top]
							* (widthAccu);
					top--;
					if( top <0 )
					{
						break;
					}
				}
				top++;
				stack[top] = newHeight;
				width[top] = widthAccu+1;
			}
		}

		return area;
	}

	public static void main(String[] args) {

		LargestRectangleArea_stack lLargestRectangleArea = new LargestRectangleArea_stack();

		int height[] = { 1};
		int lReturn = lLargestRectangleArea.largestRectangleArea(height);
		System.out.println(lReturn);

	}
}
