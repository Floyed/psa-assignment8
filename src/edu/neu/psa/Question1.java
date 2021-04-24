package edu.neu.psa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Question1 {

    public static void main(String[] args) {

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");

        node1.addDestination(node2, 7);
        node1.addDestination(node3, 9);
        node1.addDestination(node6, 14);

        node2.addDestination(node1, 7);
        node2.addDestination(node3, 10);
        node2.addDestination(node4, 15);

        node3.addDestination(node1, 9);
        node3.addDestination(node2, 10);
        node3.addDestination(node4, 11);
        node3.addDestination(node6, 2);

        node4.addDestination(node2, 15);
        node4.addDestination(node3, 11);
        node4.addDestination(node5, 6);

        node5.addDestination(node4, 6);
        node5.addDestination(node6, 9);

        node6.addDestination(node1, 14);
        node6.addDestination(node3, 2);
        node6.addDestination(node5, 9);

        calculateShortestPathFromSource(node1);

        node1.printShortestPathFromSource();
        node2.printShortestPathFromSource();
        node3.printShortestPathFromSource();
        node4.printShortestPathFromSource();
        node5.printShortestPathFromSource();
        node6.printShortestPathFromSource();

        System.out.println();
    }

    public static void calculateShortestPathFromSource(Node source) {

        Set<Node> calculated = new HashSet<>();
        Set<Node> unCalculated = new HashSet<>();

        unCalculated.add(source);
        source.setShortestDistanceFromSource(0);

        while (!unCalculated.isEmpty()) {

            Node currentNode = getNearestNode(unCalculated);

            unCalculated.remove(currentNode);

            for (Map.Entry<Node,Integer> neighbourEntry : currentNode.getNeighbours().entrySet()) {

                Node neighbour = neighbourEntry.getKey();

                Integer neighbourEdgeWeight = neighbourEntry.getValue();

                if (!calculated.contains(neighbour)) {

                    getMinDistanceFromSourceNode(neighbour, neighbourEdgeWeight, currentNode);

                    unCalculated.add(neighbour);
                }
            }

            calculated.add(currentNode);
        }
    }

    private static Node getNearestNode(Set<Node> unCalculated) {

        Node ret = null;

        int dist = Integer.MAX_VALUE;

        for (Node node: unCalculated) {

            int nodeDistance = node.getShortestDistanceFromSource();

            if (nodeDistance < dist) {
                dist = nodeDistance;
                ret = node;
            }
        }

        return ret;
    }


    private static void getMinDistanceFromSourceNode(Node destinationNode, Integer weight, Node sourceNode) {

        Integer sourceDistance = sourceNode.getShortestDistanceFromSource();

        if (sourceDistance + weight < destinationNode.getShortestDistanceFromSource()) {

            destinationNode.setShortestDistanceFromSource(sourceDistance + weight);

            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPathFromSource());

            shortestPath.add(sourceNode);

            destinationNode.setShortestPathFromSource(shortestPath);
        }
    }
}