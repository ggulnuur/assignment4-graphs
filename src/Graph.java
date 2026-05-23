import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;
    private List<Edge> edges;

    public Graph() {
        adjacencyList = new HashMap<>();
        edges = new ArrayList<>();
    }

    // Add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // Add edge
    public void addEdge(int source, int destination, int weight) {

        Edge edge = new Edge(
                new Vertex(source),
                new Vertex(destination),
                weight
        );

        edges.add(edge);

        adjacencyList.get(source).add(destination);
    }

    // Print graph
    public void printGraph() {

        for (int vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (int neighbor : adjacencyList.get(vertex)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    // BFS Traversal
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // DFS Traversal
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsHelper(start, visited);

        System.out.println();
    }

    private void dfsHelper(int current,
                           Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (int neighbor : adjacencyList.get(current)) {

            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra Algorithm
    public void dijkstra(int start) {

        int size = adjacencyList.size();

        int[] distance = new int[size];
        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;

        for (int i = 0; i < size - 1; i++) {

            int minDistance = Integer.MAX_VALUE;
            int currentVertex = -1;

            for (int j = 0; j < size; j++) {

                if (!visited[j] &&
                        distance[j] < minDistance) {

                    minDistance = distance[j];
                    currentVertex = j;
                }
            }

            visited[currentVertex] = true;

            for (Edge edge : edges) {

                int source =
                        edge.getSource().getId();

                int destination =
                        edge.getDestination().getId();

                int weight =
                        edge.getWeight();

                if (source == currentVertex &&
                        !visited[destination] &&
                        distance[source] != Integer.MAX_VALUE &&
                        distance[source] + weight < distance[destination]) {

                    distance[destination] =
                            distance[source] + weight;
                }
            }
        }

        System.out.println("\nDijkstra shortest paths:");

        for (int i = 0; i < size; i++) {

            System.out.println(
                    "From " + start +
                            " to " + i +
                            " = " + distance[i]
            );
        }
    }
}