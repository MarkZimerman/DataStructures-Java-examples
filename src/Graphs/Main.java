package Graphs;

public class Main {
    public static void main(String[] args) {
//        MyGraph graph = new MyGraph();
        MoshGraph graph = new MoshGraph();

        /*
        graph.addNode("Anna");
        graph.addNode("Mark");
        graph.addNode("Shimon");
        graph.addNode("Beny");

        graph.addEdge("Anna", "Mark");
        graph.addEdge("Mark", "Anna");
        graph.addEdge("Mark", "Shimon");
        graph.addEdge("Mark", "Beny");
        graph.addEdge("Beny", "Shimon");

        graph.removeEdge("Mark", "Beny");
//        graph.removeNode("Beny");
        */

        /*
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.print();
        System.out.println("------------------");
        graph.traverseDepthFirstIter("A");
        System.out.println("------------------");
        graph.traverseBreadthFirstIter("A");
         */

        /*
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");

        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        graph.print();
        System.out.println("------------------");
        System.out.println(graph.topologicalSort());
         */

        /*
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        System.out.println(graph.hasCycle());
         */

//        MyWeightedGraph WeightedGraph = new MyWeightedGraph();
        MoshWeightedGraph WeightedGraph = new MoshWeightedGraph();
        WeightedGraph.addNode("A");
        WeightedGraph.addNode("B");
        WeightedGraph.addNode("C");
        WeightedGraph.addEdge("A", "B", 1);
        WeightedGraph.addEdge("B", "C", 2);
        WeightedGraph.addEdge("A", "C", 10);
        WeightedGraph.print();
        System.out.println("===========================");
        System.out.println(WeightedGraph.getShortestPath("A", "C"));
    }
}
