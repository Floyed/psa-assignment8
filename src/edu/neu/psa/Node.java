package edu.neu.psa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;

    Map<Node, Integer> neighbours = new HashMap<>();

    private List<Node> shortestPathFromSource = new LinkedList<>();

    private Integer shortestDistanceFromSource = Integer.MAX_VALUE;

    public void addDestination(Node destination, int distance) {
        neighbours.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPathFromSource() {
        return shortestPathFromSource;
    }

    public void setShortestPathFromSource(List<Node> shortestPath) {
        this.shortestPathFromSource = shortestPath;
    }

    public void printShortestPathFromSource(){
        for(Node n : shortestPathFromSource){
            System.out.print(n.name + "->");
        }
        System.out.print(name);
        System.out.println();
    }

    public Integer getShortestDistanceFromSource() {
        return shortestDistanceFromSource;
    }

    public void setShortestDistanceFromSource(Integer distance) {
        this.shortestDistanceFromSource = distance;
    }

    public Map<Node, Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Map<Node, Integer> adjacentNodes) {
        this.neighbours = adjacentNodes;
    }
}