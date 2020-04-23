package com.leetfree;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;


/**
 * /** Definition for a binary tree node. public class TreeNode { int val;
 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
 
 class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; 
        }
    }
public class DeleteNodeForForest {
    
    public static void main(String[] args) {
        //Add tree 
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printTreePostOrder(root);

        System.out.println("----------");
        int[] tobeDeleted = {3,5};
        List<TreeNode> li = daleteAndReturnForest(root, tobeDeleted);
        li.forEach(n -> System.out.println(n.val));
    }

	public static List<TreeNode> daleteAndReturnForest(TreeNode root, int[] tobeDeleted){
        
        List<TreeNode> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Set<Integer> set = new HashSet<>();
        for(int i : tobeDeleted){
            set.add(i);
        }

        processDelete(root, set, list);
        if(!set.contains(root.val)){
            list.add(root);
        }

        return list;

    }

    private static TreeNode processDelete(TreeNode root, Set<Integer> set, List<TreeNode> list) {

        if(root == null){
            return null;
        }

        root.left = processDelete(root.left, set, list);
        root.right = processDelete(root.right, set, list);

        if(set.contains(root.val)){
            if(root.left != null){
                list.add(root.left);
            }
            if(root.right != null){
                list.add(root.right);
            }

            return null;
        }
        return root;
    }

    public static void printTreePostOrder(TreeNode root){
        if (root == null){
            return;
        }
        else { 
            System.out.println(root.val);
        }
        if(root.left!= null){
            printTreePostOrder(root.left);
        }

        if(root.right != null){
            printTreePostOrder(root.right);
        }
    }
}