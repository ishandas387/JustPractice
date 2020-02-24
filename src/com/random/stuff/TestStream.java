package com.random.stuff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Node {
    Integer id;
    Integer parentId;
}

public class TestStream {
    public static void main(String[] args) {
        Node root = new Node();
        root.id = 1;
        root.parentId = null;

        Node n2 = new Node();
        n2.id = 8;
        n2.parentId = 1;

        Node n3 = new Node();
        n3.id = 6;
        n3.parentId = 1;

        Node n4 = new Node();
        n4.id = 2;
        n4.parentId = 8;

        Node n5 = new Node();
        n5.id = 0;
        n5.parentId = 2;

        List<Node> list = new ArrayList<>();
        list.add(root);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);

        System.out.println(printFromGivenNode(list.stream(), 8));
    }

    private static List<Node>  printFromGivenNode(Stream<Node> stream, int i) {

        Set<Integer> set = new HashSet<>();
        List<Node> nodes =  stream.filter(node -> {
            if(node.id == i || set.contains(node.parentId)){
                set.add(node.id);
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(nodes.size());
        return nodes;
    }
}