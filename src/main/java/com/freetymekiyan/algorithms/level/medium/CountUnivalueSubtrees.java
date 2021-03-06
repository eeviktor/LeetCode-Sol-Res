package com.freetymekiyan.algorithms.level.medium;

import com.freetymekiyan.algorithms.utils.Utils.TreeNode;

/**
 * 250. Count Univalue Subtrees
 * <p>
 * Given a binary tree, count the number of uni-value subtrees.
 * <p>
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * Example :
 * <p>
 * Input:  root = [5,1,5,5,5,null,5]
 * <p>
 * |              5
 * |             / \
 * |            1   5
 * |           / \   \
 * |          5   5   5
 * <p>
 * Output: 4
 * <p>
 * Companies: Box, Google, Amazon, Splunk, Bloomberg
 * <p>
 * Related Topics: Tree
 * <p>
 * Similar Questions: (E) Subtree of Another Tree, (E) Longest Univalue Path
 */
public class CountUnivalueSubtrees {

  public int countUnivalSubtrees(TreeNode root) {
    int[] count = new int[1];
    helper(root, count);
    return count[0];
  }

  private boolean helper(TreeNode node, int[] count) {
    if (node == null) {
      return true;
    }
    boolean left = helper(node.left, count);
    boolean right = helper(node.right, count);
    if (left && right) {
      if (node.left != null && node.val != node.left.val) {
        return false;
      }
      if (node.right != null && node.val != node.right.val) {
        return false;
      }
      count[0]++;
      return true;
    }
    return false;
  }
}