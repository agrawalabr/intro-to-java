package partIII;

import java.util.ArrayList;
import java.util.Collections;

public class Triplet<A, B, C> implements Comparable<Triplet<A, B, C>> {
    private A first;
    private B second;
    private C third;
    
    public Triplet(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public A getFirst() {
        return first;
    }
    
    public B getSecond() {
        return second;
    }
    
    public C getThird() {
        return third;
    }
    
    @Override
    public String toString() {
        return "Triplet [first=" + first + ", second=" + second + ", third=" + third + "]";
    }
    
    // Calculate magnitude for numeric types
    public double magnitude() {
        if (first instanceof Number && second instanceof Number && third instanceof Number) {
            double a = ((Number) first).doubleValue();
            double b = ((Number) second).doubleValue();
            double c = ((Number) third).doubleValue();
            return Math.sqrt(a * a + b * b + c * c);
        }
        return 0;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Triplet<A, B, C> other) {
        if (first instanceof Number && second instanceof Number && third instanceof Number) {
            // Compare by magnitude for numeric types
            return Double.compare(this.magnitude(), other.magnitude());
        } else if (first instanceof Comparable && second instanceof Comparable && third instanceof Comparable) {
            // Compare each component if they are Comparable
            int firstComp = ((Comparable<A>) first).compareTo(other.first);
            if (firstComp != 0) return firstComp;
            
            int secondComp = ((Comparable<B>) second).compareTo(other.second);
            if (secondComp != 0) return secondComp;
            
            return ((Comparable<C>) third).compareTo(other.third);
        }
        return 0;
    }
    
    public static void main(String[] args) {
        // Create ArrayList of Triplets with Double values
        ArrayList<Triplet<Double, Double, Double>> triplets = new ArrayList<>();
        
        triplets.add(new Triplet<>(3.0, 4.0, 5.0));
        triplets.add(new Triplet<>(1.0, 2.0, 2.0));
        triplets.add(new Triplet<>(5.0, 5.0, 5.0));
        triplets.add(new Triplet<>(2.0, 2.0, 8.0));
        
        System.out.println("Original triplets:");
        triplets.forEach(t -> System.out.printf("%s (magnitude: %.2f)%n", t, t.magnitude()));
        
        // Sort using lambda
        System.out.println("\nSorted by magnitude (lambda):");
        triplets.sort((t1, t2) -> Double.compare(t1.magnitude(), t2.magnitude()));
        triplets.forEach(t -> System.out.printf("%s (magnitude: %.2f)%n", t, t.magnitude()));
        
        // Sort using Comparable
        System.out.println("\nSorted using Comparable:");
        Collections.sort(triplets);
        triplets.forEach(t -> System.out.printf("%s (magnitude: %.2f)%n", t, t.magnitude()));
    }
}