package PartII;
import java.util.*;

public class ShortestPath {

    static class Edge {
        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        String name;
        int distance;

        public Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static class PathResult {
        List<String> path;
        int totalDistance;

        public PathResult(List<String> path, int totalDistance) {
            this.path = path;
            this.totalDistance = totalDistance;
        }
    }

    public static PathResult getShortestPath(Map<String, List<Edge>> graph, String start, String end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        Map<String, Integer> distances = new HashMap<>();
        distances.put(start, 0);

        Map<String, String> previous = new HashMap<>();

        Set<String> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            if (current.name.equals(end)) {
                return new PathResult(reconstructPath(previous, end), distances.get(end));
            }

            for (Edge edge : graph.getOrDefault(current.name, new ArrayList<>())) {
                if (visited.contains(edge.destination)) continue;

                int newDistance = distances.get(current.name) + edge.weight;
                if (newDistance < distances.getOrDefault(edge.destination, Integer.MAX_VALUE)) {
                    distances.put(edge.destination, newDistance);
                    previous.put(edge.destination, current.name);
                    pq.add(new Node(edge.destination, newDistance));
                }
            }
        }
        return new PathResult(Collections.emptyList(), -1);
    }

    private static List<String> reconstructPath(Map<String, String> previous, String end) {
        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
    	
        Map<String, List<Edge>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Edge("B", 5), new Edge("C", 8)));
        graph.put("B", Arrays.asList(new Edge("A", 5), new Edge("C", 5), new Edge("D", 7), new Edge("E", 7)));
        graph.put("C", Arrays.asList(new Edge("A", 8), new Edge("B", 5), new Edge("D", 9), new Edge("E", 6)));
        graph.put("D", Arrays.asList(new Edge("B", 7), new Edge("C", 9), new Edge("Z", 4), new Edge("E", 6)));
        graph.put("E", Arrays.asList(new Edge("C", 6), new Edge("B", 7), new Edge("D", 6), new Edge("Z", 3)));
        graph.put("Z", Arrays.asList(new Edge("D", 4), new Edge("E", 3)));

        System.out.println("Given Graph:");
        for (Map.Entry<String, List<Edge>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Edge edge : entry.getValue()) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }

        PathResult result = getShortestPath(graph, "A", "Z");
        System.out.println();
        System.out.println("Shortest Path from A to Z: " + result.path);
        System.out.println("Total Distance: " + result.totalDistance);
    }
}
