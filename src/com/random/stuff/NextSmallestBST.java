package com.random.stuff;

import java.util.Arrays;
import java.util.List;

public class NextSmallestBST {

    /*
     * Every node will maintain a val sum recording the total of number on it's left
     * bottom side, dup counts the duplication. For example, [3, 2, 2, 6, 1], from
     * back to beginning,we would have:
     * 
     * 1(0, 1) \ 6(3, 1) / 2(0, 2) \ 3(0, 1) When we try to insert a number, the
     * total number of smaller number would be adding dup and sum of the nodes where
     * we turn right. for example, if we insert 5, it should be inserted on the way
     * down to the right of 3, the nodes where we turn right is 1(0,1), 2,(0,2),
     * 3(0,1), so the answer should be (0 + 1)+(0 + 2)+ (0 + 1) = 4
     */
    class Node {
        int val, leftSum = 0, count = 0;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[] count = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(count);
        }
        Node root = new Node(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            count[i] = insert(root, nums[i]);
        }
        return Arrays.asList(count);
    }

    private int insert(Node node, int num) {
        int sum = 0;
        while (node.val != num) {
            if (node.val > num) {
                if (node.left == null)
                    node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            } else {
                sum += node.leftSum + node.count;
                if (node.right == null)
                    node.right = new Node(num);
                node = node.right;
            }
        }
        node.count++;
        return sum + node.leftSum;
    }
}
