
public class EstimateLn2 {
	public static double estimateLn2() {
		
		int iterations = 0;
        double targetValue = Math.log(2.0);
        double sum = 0.0;
        double tolerance = 1e-5;

        while (Math.abs(sum - targetValue) > tolerance) {
            iterations++;
            sum += Math.pow(-1, iterations + 1) / iterations;
            System.out.println("Iteration " + iterations + ": Sum = " + sum);
            System.out.println("Difference = " + Math.abs(sum - targetValue));
        }

        System.out.println("Terminated after " + iterations + " iterations.");
        System.out.println("Final approximated value: " + sum);
        return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("ln2 is  "+ estimateLn2());
	}
}
