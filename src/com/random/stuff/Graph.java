package com.random.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Graph {
    
    Map<Vertex, List<Vertex>> adjListMap = new HashMap<>();

    public Map<Vertex, List<Vertex>> getAdjListMap() {
        return adjListMap;
    }

    public void setAdjListMap(Map<Vertex, List<Vertex>> adjListMap) {
        this.adjListMap = adjListMap;
    }
    
    
    //add a vertex

    public void addVertex(String node){
        adjListMap.put(new Vertex(node), new ArrayList<>());
    }

    public void removeVertex(String node){
        Vertex v = new Vertex(node);
        //delete all the edges where ever it is in the graph
        adjListMap.values().stream().map(l -> l.remove(v)).collect(Collectors.toList());
        //remove the node.
        adjListMap.remove(v);

    }

    public void addEdge(String l1, String l2){
        Vertex v1 = new Vertex(l1);
        Vertex v2= new Vertex(l2);
        adjListMap.get(v1).add(v2);
        adjListMap.get(v2).add(v1);
    }

    public void removeEdge(String l1, String l2){
        Vertex v1 = new Vertex(l1);
        Vertex v2= new Vertex(l2);
        adjListMap.get(v1).removeIf(v -> v.equals(v2));
        adjListMap.get(v2).removeIf(v -> v.equals(v1));
    }

    //DFS given a start node
    public void DepthFirst(Graph graph, String startNode){
        //dfs uses a stack 
        Stack<String> stack = new Stack();
        //set to keep the vissited node
        Set<String> visited = new HashSet<>();
        stack.push(startNode);
        while(!stack.isEmpty()){
            String vertex = stack.pop();
            if(!visited.contains(vertex)){
                List<Vertex> listOfVertex = this.getAdjListMap().get(new Vertex(vertex));
                for(Vertex v : listOfVertex){
                    stack.push(v.getNode());
                }
            }

        }
        for(String s : visited){
            System.out.println(s);
        }
    }

    public void breadthFirst(String startNode){
        //queue is used here.
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(startNode);
        visited.add(startNode);
        while(!q.isEmpty()){
            String vertex =  q.poll();
            for(Vertex v : this.getAdjListMap().get(new Vertex(vertex))){
                q.add(v.getNode());
                visited.add(v.getNode());
            }
        }
        for(String s : visited){
            System.out.println(s);
        }
    }
}