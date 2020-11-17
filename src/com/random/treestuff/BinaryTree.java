package com.random.treestuff;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public TreeNode add(TreeNode node, int val){
        return addRecursive(node, val);
    }

    private TreeNode addRecursive(TreeNode node, int val) {
        if(node == null){
            return new TreeNode(val);
        }

        if(node.value > val){
            node.left = new TreeNode(val);
        }
        if(node.value < val){
            node.right = new TreeNode(val);
        } else if(node.value == val){
            return node;
        }

        return node;

    }

    // preoder traversal

    public void preOrderTraversal(TreeNode root){
        preOrderTraversalRecurssive(root);
    }

    private void preOrderTraversalRecurssive(TreeNode root) {
        if(root == null){
            return;
        }

        System.out.println(root.value);
        preOrderTraversalRecurssive(root.left);
        preOrderTraversalRecurssive(root.right);
    }

    //postorder

    public void postOrderTraversal(TreeNode root){
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(TreeNode root) {

        if(root == null){
            return ;
        }

        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.println(root.value);

    }

    public void inOrderTraversal(TreeNode root){
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(TreeNode root) {

        if(root == null){
            return ;
        }

        inOrderTraversalRecursive(root.left);
        System.out.println(root.value);
        inOrderTraversalRecursive(root.right);

    }

    public void preOrderTraversalIterative(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return;
        }

        stack.add(root);

        // rearrange this part for pre post and inorder traversal
        while(!stack.isEmpty()){
            TreeNode poll = stack.pop();
            System.out.println(poll.value);
            if(poll.right != null){
                stack.push(poll.right);
            }
            if(poll.left != null){
                stack.push(poll.left);
            }

        }
    }

    public void levelOrderTraversal(TreeNode root){
        //queue can be used for level order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll.value);
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }
    }
    

    // getting the height 
    public int getHeight(TreeNode root){
        return getHeightGivenTheNode(root);
    }

    private int getHeightGivenTheNode(TreeNode node) {

        if(node == null){
            return 0;
        }

        int leftMax = getHeightGivenTheNode(node.left);
        int rightMax = getHeightGivenTheNode(node.right);

        if(leftMax > rightMax){
            return leftMax+1;
        } else {
            return rightMax +1;
        }

        
    }

    public int fullNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left != null && poll.right != null){
                count++;
            }

            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }

        return count;
    }

    public boolean checkIsSymmetric(TreeNode root){
            return checkIsSymmetricWithRecurssion(root, root);
    }

    private boolean checkIsSymmetricWithRecurssion(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }

        return node1.value == node2.value && checkIsSymmetricWithRecurssion(node1.left, node2.right) && checkIsSymmetricWithRecurssion(node1.right, node2.left);
        
    }

    public boolean checkIsSymmetricNoRecurssion(TreeNode root){
        return checkIsSymmetricWithIteration(root, root);
}

private boolean checkIsSymmetricWithIteration(TreeNode node1, TreeNode node2) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node1);
    queue.add(node2);
    while(!queue.isEmpty()){
        TreeNode n1 = queue.poll();
        TreeNode n2 = queue.poll();

        if(n1 == null && n2 == null){
            return true;
        }
        String s ="";
        s.sub
        if(n1 == null || n2 == null){
            return false;
        }

        if(n1.value != n2.value){
            return false;
        }

        queue.add(n1.left);
        queue.add(n2.right);
        queue.add(n1.right);
        queue.add(n2.left);
    }

    return true;
}
}
