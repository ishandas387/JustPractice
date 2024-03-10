package com.random.treestuff;

public class TreeUse {

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.add(10);
        myTree.add(1);
        myTree.add(12);
        myTree.add(0);
        myTree.add(8);
        myTree.add(2);

        TreeNode root = myTree.getRoot();

        BinaryTree nbt = new BinaryTree();
        nbt.root = new TreeNode(1);
        nbt.root.left = new TreeNode(2);
        nbt.root.right = new TreeNode(2);
        nbt.root.left.left = new TreeNode(3);
        nbt.root.left.right = new TreeNode(4);
        nbt.root.right.left = new TreeNode(4);
        nbt.root.right.right = new TreeNode(3);
        System.out.println("*******is symmetry*****");
        System.out.println(nbt.checkIsSymmetric(nbt.root));

        /**
         * 
         * 10
         * 1 12z
         * 0 8
         * 
         * 2
         * 
         * 
         */

        // inorder LPR
        // 0 1 2 8 10 12
        // post LRP
        // 0 2 8 1 12 10
        // pre PLR
        // 10 1 0 8 2 12

        System.out.println("*******pre order recursion****PLR*****");
        myTree.preOrderTraversal(root);
        System.out.println("*****pre order iterative**** PLR*******");
        myTree.preOrderTraversalIterative(root);
        System.out.println("******in order recursion LPR**********");
        myTree.inOrderTraversal(root);
        System.out.println("*******in order iterative LPR*********");
        myTree.inOrderTraversalIterative(root);
        System.out.println("*******post order recursion LRP*********");
        myTree.postOrderTraversal(root);
        System.out.println("******post order iterative LRP**********");
        // myTree.postOrderTraversalIterative(root);

        System.out.println("******level order traversal**********");

        myTree.levelOrderTraversal(root);

        System.out.println("******full node count **********");

        System.out.println(myTree.fullNodeCount(root));
    }
}