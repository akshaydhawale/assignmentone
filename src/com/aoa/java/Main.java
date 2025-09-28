package com.aoa.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Analysis of Algorithms: Assignment 1");
        System.out.println("Author: Akshay Dhawale | UFID: 39610668");

        System.out.print("Input the number of nodes: ");
        Scanner scanner = new Scanner(System.in);
        int numNodes = scanner.nextInt();

        System.out.print("\nInput the number of edges: ");
        int numEdges = scanner.nextInt();

        ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graphList.add(new ArrayList<>());
        }

        System.out.println("\nInput the edges (format: u v) one per line:");
        for (int i = 0; i < numEdges; i++) {    
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graphList.get(u).add(v);
        }
        
        System.out.println("\nGraph representation (Adjacency List):");
        for (int i = 0; i < graphList.size(); i++) {
            System.out.print(i + ": ");
            for (int neighbor : graphList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}