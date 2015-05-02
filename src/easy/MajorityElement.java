package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] num) {		
		Map<Integer, Integer> lIntAndCount = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < num.length; i++) {

			if (lIntAndCount.containsKey(num[i])) {
				int value = lIntAndCount.get(num[i]) + 1;
				lIntAndCount.put(num[i], value);
				if( value > (num.length/2) )
				{
					return num[i];
				}
			}
			else
			{
				lIntAndCount.put(num[i], 1);
			}
		}

		return num[0];
	}

	public static void main(String[] args) {
		MajorityElement lMajorityElement = new MajorityElement();
		int[] num = { 1,2};
		int majority = lMajorityElement.majorityElement(num);
		System.out.println(majority);
	}
}
