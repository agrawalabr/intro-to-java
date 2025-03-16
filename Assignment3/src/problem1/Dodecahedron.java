package problem1;

public class Dodecahedron {
    private static int nextId = 1;
    private int id;
    private double edge;
    
    public Dodecahedron(double edge) {
        this.id = nextId++;
        this.edge = edge;
    }
    
    public int getId() {
        return id;
    }
    
    public double getEdge() {
        return edge;
    }
    
    public void setEdge(double edge) {
        this.edge = edge;
    }
    
    public double getVolume() {
        return ((15 + 7 * Math.sqrt(5)) / 4) * Math.pow(edge, 3);
    }
    
    public double getSurfaceArea() {
        return 3 * Math.sqrt(25 + 10 * Math.sqrt(5)) * Math.pow(edge, 2);
    }
    
    public double getHeight() {
        return edge * ((Math.sqrt(5) + 1) / 2);
    }
    
    public String toString() {
        return "Dodecahedron{id=" + id + ", edge=" + edge + ", volume=" + getVolume() + ", surface area=" + getSurfaceArea() + ", height=" + getHeight() + "}";
    }
    
    public static void main(String[] args) {
        Dodecahedron d1 = new Dodecahedron(2);
        Dodecahedron d2 = new Dodecahedron(3);
        
        System.out.println(d1);
        System.out.println(d2);
    }
}
