import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node {
    char label;
    double heuristic;
    double cost;
    boolean visited;
    Node parent;
    List<Edge> neighbors;

    public Node(char label, double heuristic) {
        this.label = label;
        this.heuristic = heuristic;
        this.cost = Double.MAX_VALUE;
        this.visited = false;
        this.parent = null;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Edge edge) {
        this.neighbors.add(edge);
    }
}

class Edge {
    Node target;
    double cost;

    public Edge(Node target, double cost) {
        this.target = target;
        this.cost = cost;
    }
}

public class Graph {

    public static double aStar(Node start, Node goal) {
        List<Node> openList = new ArrayList<Node>();
        List<Node> closedList = new ArrayList<Node>();

        start.cost = 0;
        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = findLowestCost(openList);
            openList.remove(current);
            closedList.add(current);

            if (current == goal) {
                return current.cost;
            }

            for (Edge neighborEdge : current.neighbors) {
                Node neighbor = neighborEdge.target;
                double tentativeCost = current.cost + neighborEdge.cost;

                if (!closedList.contains(neighbor)) {
                    if (!openList.contains(neighbor) || tentativeCost < neighbor.cost) {
                        neighbor.cost = tentativeCost;
                        neighbor.parent = current; // Update the parent
                        if (!openList.contains(neighbor)) {
                            openList.add(neighbor);
                        }
                    }
                }
            }
        }

        return -1; // No path found
    }

    private static Node findLowestCost(List<Node> nodes) {
        Node lowestCostNode = null;
        double lowestCost = Double.MAX_VALUE;

        for (Node node : nodes) {
            if (node.cost + node.heuristic < lowestCost) {
                lowestCost = node.cost + node.heuristic;
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }

    private static List<Node> getPath(Node start, Node goal) {
        List<Node> path = new ArrayList<>();
        Node current = goal;

        while (current != null) {
            path.add(current);
            current = current.parent;
        }

        Collections.reverse(path); // Reverse the path to get it from start to goal
        return path;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = input.nextInt();

        Node[] nodes = new Node[numVertices];

        for (int i = 0; i < numVertices; i++) {
            System.out.print("Enter vertex details (label heuristic) for vertex " + (i + 1) + ": ");
            char label = input.next().charAt(0);
            double heuristic = input.nextDouble();
            nodes[i] = new Node(label, heuristic);
        }

        System.out.print("Enter the number of edges: ");
        int numEdges = input.nextInt();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge details (source destination cost) for edge " + (i + 1) + ": ");
            char sourceLabel = input.next().charAt(0);
            char targetLabel = input.next().charAt(0);
            double cost = input.nextDouble();

            Node source = getNodeByLabel(nodes, sourceLabel);
            Node target = getNodeByLabel(nodes, targetLabel);

            if (source != null && target != null) {
                source.addNeighbor(new Edge(target, cost));
            } else {
                System.out.println("Invalid vertex label. Please try again.");
                i--; // Decrement i to re-enter the current edge
            }
        }

        System.out.print("Enter the start vertex label: ");
        char startLabel = input.next().charAt(0);
        System.out.print("Enter the goal vertex label: ");
        char goalLabel = input.next().charAt(0);

        input.close();

        Node start = getNodeByLabel(nodes, startLabel);
        Node goal = getNodeByLabel(nodes, goalLabel);

        if (start != null && goal != null) {
            double shortestPathCost = aStar(start, goal);

            if (shortestPathCost != -1) {
                System.out.println("Shortest path cost: " + shortestPathCost);
                List<Node> path = getPath(start, goal);
                System.out.print("Path: ");
                for (Node node : path) {
                    System.out.print(node.label + " ");
                }
            } else {
                System.out.println("No path found");
            }
        } else {
            System.out.println("Invalid start or goal vertex label");
        }
    }

    private static Node getNodeByLabel(Node[] nodes, char label) {
        for (Node node : nodes) {
            if (node.label == label) {
                return node;
            }
        }
        return null;
    }
}
