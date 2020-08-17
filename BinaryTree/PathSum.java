/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum) {
            if((root.left == null) && (root.right == null)) {
                return true;
            }
        }
        return findPath(root.left, sum, root.val) || findPath(root.right, sum, root.val);
    }
    
    private boolean findPath(TreeNode node, int targetSum, int currSum) {
        if(node == null) return false;
        if((node.left == null) && (node.right == null)){
            return (currSum + node.val) == targetSum;
        }
        return findPath(node.left, targetSum, (currSum + node.val)) || findPath(node.right, targetSum, (currSum + node.val));
    }
    
}
