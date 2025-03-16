
public class LetterPyramid {

	public static String generatePyramid(int rows) {
		StringBuilder pyramid = new StringBuilder();
		        
		        for (int i = 0; i < rows; i++) {
		            int spaces = rows - i - 1;
		            
		            for (int j = 0; j < spaces; j++) {
		                pyramid.append(" ");
		            }

		            for (char c = 'A'; c <= 'A' + i; c++) {
		                pyramid.append(c);
		            }

		            for (char c = (char) ('A' + i - 1); c >= 'A'; c--) {
		                pyramid.append(c);
		            }

		            pyramid.append("\n");
		        }
		        
		        return pyramid.toString();
			}
			
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				int rows = 5;
		        String result = generatePyramid(rows);
		        System.out.println(result);
			}
}
