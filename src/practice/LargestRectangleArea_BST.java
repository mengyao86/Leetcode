package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public class LargestRectangleArea_BST {
	public int largestRectangleArea(int[] height) {
		int lReturn = 0;
		int left = 0;
		int right = height.length - 1;

		// order using TreeMap
		ArrayList<Integer> rankOfPos = rankHeight(height);

		lReturn = calculateLargestRectangle(height, rankOfPos, left, right);
		return lReturn;
	}

	// order the given array in ascent and the returned array stores the
	// position of the elements in height
	private ArrayList<Integer> rankHeight(int[] height) {

		ArrayList<Integer> rankOfPos = new ArrayList<Integer>(height.length);

		Map<Double, Integer> map = new TreeMap<Double, Integer>(
				new Comparator<Object>() {
					public int compare(Object o1, Object o2) {
						Double key1 = (Double) o1;
						Double key2 = (Double) o2;
						return Double.compare(key1, key2);
					}
				});

		// Add the elements one by one and the results would be ordered by
		// predefined Comparator
		int numOfMap = 0;
		for (int i = 0; i < height.length; i++) {
			if (map.containsKey((double) height[i])) {
				while (map.size() == numOfMap) {
					// this key already exist in map
					Random randomGenerator = new Random();
					double randomPlus = randomGenerator.nextInt(100000000) * 0.00000001;
					double fakeKey = height[i] + randomPlus;
					map.put(fakeKey, i);
				}
			} else {
				map.put((double) height[i], i);

			}
			numOfMap++;
		}

		// rankOfPos store the position of elements
		Set<Double> keySet = map.keySet();
		for (Double lkey : keySet) {
			Integer value = map.get(lkey);
			rankOfPos.add(value);
		}

		return rankOfPos;
	}

	//calculate the largest rectangle between the position of left and the position of right
	private int calculateLargestRectangle(int[] height,
			ArrayList<Integer> rankOfPos, int left, int right) {
		if (left == right - 1) {

			return height[left] < height[right] ? height[left]
					: height[right] * 2;
		} else if (left == right) {
			return height[left];
		} else if (left > right) {
			return 0;
		}

		int minValuePosition = getMinValuePosition(height, rankOfPos, left,
				right);

		// the current minimum has been used
		rankOfPos.remove(0);

		int largest = height[minValuePosition] * (right - left + 1);

		int leftArea = calculateLargestRectangle(height, rankOfPos, left,
				minValuePosition - 1);
		int rightArea = calculateLargestRectangle(height, rankOfPos,
				minValuePosition + 1, right);

		if (leftArea > largest) {
			largest = leftArea;
		}

		if (rightArea > largest) {
			largest = rightArea;
		}
		return largest;
	}

	// return the minimum value between height[left] and height[right] inclusively
	private int getMinValuePosition(int[] height, ArrayList<Integer> rankOfPos,
			int left, int right) {
		for (Integer lInt : rankOfPos) {
			if (lInt >= left && lInt <= right)
				return lInt;
		}
		return left;

	}

	public static void main(String[] args) {

		LargestRectangleArea_BST lLargestRectangleArea = new LargestRectangleArea_BST();

		int height[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15,
				14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int lReturn = lLargestRectangleArea.largestRectangleArea(height);
		System.out.println(lReturn);

	}
}
