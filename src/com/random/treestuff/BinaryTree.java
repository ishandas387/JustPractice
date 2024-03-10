package com.random.treestuff;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryTree {
    TreeNode root;

    public void add(int val) {
        root = addRecursive(root, val);
    }

    private TreeNode addRecursive(TreeNode node, int val) {

        if (node == null) {
            return new TreeNode(val);
        }

        if (node.value > val) {
            node.left = addRecursive(node.left, val);
        }

        if (node.value < val) {
            node.right = addRecursive(node.right, val);
        }

        else if (node.value == val) {
            return node;
        }

        return node;

    }

    // preoder traversal

    public void preOrderTraversal(TreeNode root) {
        preOrderTraversalRecurssive(root);
    }

    private void preOrderTraversalRecurssive(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        preOrderTraversalRecurssive(root.left);
        preOrderTraversalRecurssive(root.right);
    }

    // postorder

    public void postOrderTraversal(TreeNode root) {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(TreeNode root) {

        if (root == null) {
            return;
        }

        postOrderTraversalRecursive(root.left);
        postOrderTraversalRecursive(root.right);
        System.out.println(root.value);

    }

    public void inOrderTraversal(TreeNode root) {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(TreeNode root) {

        if (root == null) {
            return;
        }

        inOrderTraversalRecursive(root.left);
        System.out.println(root.value);
        inOrderTraversalRecursive(root.right);

    }

    public void preOrderTraversalIterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }

        stack.add(root);

        // rearrange this part for pre post and inorder traversal
        while (!stack.isEmpty()) {
            TreeNode poll = stack.pop();
            System.out.println(poll.value);
            if (poll.right != null) {
                stack.push(poll.right);
            }
            if (poll.left != null) {
                stack.push(poll.left);
            }

        }
    }

    public void postOrderTraversalIterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
   
                current = current.left;
                stack.push(current);
            }

            // Process the current node
            current = stack.pop();
            System.out.println(current.value);

            current = current.left;
        }
    }

    public void inOrderTraversalIterative(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Process the current node
            current = stack.pop();
            System.out.println(current.value);

            // Move to the right subtree
            current = current.right;
        }
    }

    public void levelOrderTraversal(TreeNode root) {
        // queue can be used for level order
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.println(poll.value);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    // getting the height
    public int getHeight(TreeNode root) {
        return getHeightGivenTheNode(root);
    }

    private int getHeightGivenTheNode(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftMax = getHeightGivenTheNode(node.left);
        int rightMax = getHeightGivenTheNode(node.right);

        if (leftMax > rightMax) {
            return leftMax + 1;
        } else {
            return rightMax + 1;
        }

    }

    public int fullNodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null && poll.right != null) {
                count++;
            }

            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }

        return count;
    }

    public boolean checkIsSymmetric(TreeNode root) {
        return checkIsSymmetricWithRecurssion(root, root);
    }

    private boolean checkIsSymmetricWithRecurssion(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.value == node2.value && checkIsSymmetricWithRecurssion(node1.left, node2.right)
                && checkIsSymmetricWithRecurssion(node1.right, node2.left);

    }

    public boolean checkIsSymmetricNoRecurssion(TreeNode root) {
        return checkIsSymmetricWithIteration(root, root);
    }

    private boolean checkIsSymmetricWithIteration(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node1);
        queue.add(node2);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if (n1 == null && n2 == null) {
                return true;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.value != n2.value) {
                return false;
            }

            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }

        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
        return findLcaWithRecurssion(root, p, q);

    }

    private TreeNode findLcaWithRecurssion(TreeNode current, TreeNode p, TreeNode q) {
        if (current == null) {
            return null;
        }

        if (current == p || current == q) {
            return current;
        }

        TreeNode left = findLcaWithRecurssion(current.left, p, q);
        TreeNode right = findLcaWithRecurssion(current.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return current;
    }

    public TreeNode lowestCommonAncestorIteration(TreeNode p, TreeNode q) {

        Deque<TreeNode> stack = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        parentMap.put(root, null);
        stack.push(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode pop = stack.pop();
            if (pop.left != null) {
                parentMap.put(pop.left, pop);
                stack.push(pop.left);
            }
            if (pop.right != null) {
                parentMap.put(pop.right, pop);
                stack.push(pop.right);
            }
        }

        Set<TreeNode> pParents = new HashSet<>();
        while (p != null) {

            pParents.add(p);
            p = parentMap.get(p);
        }

        while (!pParents.contains(q)) {
            q = parentMap.get(q);
        }

        return q;

        /*
         * Stack<TreeNode> stack = new Stack<>();
         * Map<TreeNode, TreeNode> parentPointer = new HashMap<>();
         * 
         * parentPointer.put(root, null);
         * stack.push(root);
         * 
         * while(!parentPointer.containsKey(p) || !parentPointer.containsKey(q)){
         * TreeNode node = stack.pop();
         * 
         * if(node.left != null){
         * parentPointer.put(node.left, node);
         * stack.push(node.left);
         * }
         * 
         * if(node.right != null){
         * parentPointer.put(node.right, node);
         * stack.push(node.right);
         * }
         * 
         * }
         * 
         * Set<TreeNode> ancestor = new HashSet<>();
         * while(p != null){
         * ancestor.add(p);
         * p = parentPointer.get(p);
         * }
         * while(!ancestor.contains(q)){
         * q = parentPointer.get(q);
         * }
         * return q;
         */
    }

    // given inorder and preorder array construct the tree and
    public TreeNode createFromGivenArrays(int[] inOrder, int[] preOrder) {
        // have a map of value and index created.
        Map<Integer, Integer> indexMap = IntStream.range(0, inOrder.length - 1).boxed()
                .collect(Collectors.toMap(i -> inOrder[i], i -> i));
        int indexTraverse = 0;
        return createRecursively(0, inOrder.length, indexMap, inOrder, preOrder, indexTraverse);
        // returns the root node created.
    }

    private TreeNode createRecursively(int start, int end, Map<Integer, Integer> indexMap, int[] inOrder,
            int[] preOrder, int indexTraverse) {
        if (start == end) {
            return null;
        }

        int rootIndexValue = preOrder[indexTraverse];
        indexTraverse++;
        // create the root node.
        TreeNode rootNode = new TreeNode(rootIndexValue);
        int indexInorder = indexMap.get(rootIndexValue);
        rootNode.left = createRecursively(start, indexInorder, indexMap, inOrder, preOrder, indexTraverse);
        rootNode.right = createRecursively(indexInorder + 1, end, indexMap, inOrder, preOrder, indexTraverse);
        return rootNode;
    }

    public TreeNode getRoot() {
        return root;
    }
}
