import java.util.Arrays;

public class MaximumSubarray {
	
	public static int[] maxSubarray(int[] arr) {
		
		int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        System.out.println("Output: " + Arrays.toString(Arrays.copyOfRange(arr, start, end + 1)));
        System.out.println("Maximum Sum: " + maxSum);
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] testArray = {-2,1,-3,4,-1,2,1,-5,4};
		maxSubarray(testArray);
		
	}
}
