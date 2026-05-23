public class Experiment {

    public void runTraversals(Graph g) {

        long startBFS = System.nanoTime();
        g.dijkstra(0);
        long endBFS = System.nanoTime();

        long bfsTime = endBFS - startBFS;

        long startDFS = System.nanoTime();
        g.dijkstra(0);
        long endDFS = System.nanoTime();

        long dfsTime = endDFS - startDFS;

        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
    }

    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\n========================");
            System.out.println("Graph Size: " + size);
            System.out.println("========================");

            Graph graph = new Graph();

            // Add vertices
            for (int i = 0; i < size; i++) {
                graph.addVertex(new Vertex(i));
            }

            // Add edges
            for (int i = 0; i < size - 1; i++) {
                graph.addEdge(i, i + 1, 4);
            }

            // Extra edges
            for (int i = 0; i < size - 5; i += 5) {
                graph.addEdge(i, i + 5, 2);
            }

            // Print only small graph
            if (size == 10) {
                graph.printGraph();
            }

            runTraversals(graph);
        }
    }

    public void printResults() {

        System.out.println("\nExperiments completed successfully.");
    }
}