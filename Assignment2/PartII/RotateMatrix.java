import java.util.Arrays;

public class RotateMatrix {
	
	public static int[][] rotatedMatrix(int[][] matrix) {
		int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotatedMatix = new int[cols][rows];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
            	rotatedMatix[col][rows - 1 - row] = matrix[row][col];
            }
        }
		
		return rotatedMatix;
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {
			    {1, 2, 3},
			    {4, 5, 6},
			    {7, 8, 9}
			};
		int[][] matrix2 = {
			    {1, 2, 3, 4},
			    {5, 6, 7, 8},
			    {9, 10, 11, 12}
			};
		int[][] matrix3 = {
			    {1, 2, 3},
			    {4, 5, 6},
			    {7, 8, 9},
			    {10, 11, 12}
		};
		
		int[][] newMatrix = rotatedMatrix(matrix);
		System.out.println("Rotated Matrix : ");
		for (int[] row : newMatrix) {
            System.out.println(Arrays.toString(row));
        }
		
		newMatrix = rotatedMatrix(matrix2);
		System.out.println("Rotated Matrix : ");
		for (int[] row : newMatrix) {
            System.out.println(Arrays.toString(row));
        }
		
		newMatrix = rotatedMatrix(matrix3);
		System.out.println("Rotated Matrix : ");
		for (int[] row : newMatrix) {
            System.out.println(Arrays.toString(row));
        }
	}

}
