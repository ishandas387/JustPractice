package com.random.stuff;

import java.util.ArrayList;
import java.util.Stack;

public class AdjListGraph {
    
    int numberOfVertex;

    ArrayList<Integer> [] adjList;
    
    AdjListGraph(int vertex){
        this.numberOfVertex = vertex;
        adjList = new ArrayList[vertex];
        for(int i=0; i< vertex;i++){
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int a, int b){
        adjList[a].add(b);
    }

    //print all paths between two nodes
    public void printPath(int s, int d){

        boolean [] visited = new boolean[numberOfVertex];
        ArrayList<Integer> path = new ArrayList<>();

        path.add(s);

        printPathRecursive(s,d,visited,path);
    }


    private void printPathRecursive(int s, int d, boolean[] visited, ArrayList<Integer> path) {

        visited[s] = true;

        if(s == d){
            System.out.println(path);
            visited[s] = false;
            return;

        }

        for(int i : adjList[s]){
            path.add(i);
            printPathRecursive(i, d, visited,path);
            path.remove(i);

        }

        visited[s] = false;
    }

    public boolean checkIfCyclic(int start) {
        Stack<Integer> stack = new Stack<>();
        if(isCyclicRecursive(start, stack)){
            return true;
        }
        return false;
    }

    private boolean isCyclicRecursive(int node, Stack<Integer> stack) {
        if(stack.contains(node)){
            return true;
        }
        while(!stack.isEmpty()){
            for(int i : this.adjList[node]){
                if(isCyclicRecursive(i, stack)){
                    return true;
                }
            }
            stack.pop();
            break;
        }
        return false;
    }
    
}