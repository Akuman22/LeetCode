/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        traverse(0, finalList, root);
        return finalList;
    }
    
    private void traverse(int level, List<List<Integer>> list, TreeNode root) {
        if(root == null) { return; }
        try {
            list.get(level);
            } catch (Exception e) {
            list.add(level, new ArrayList<>());
            }
        list.get(level).add(root.val);
        traverse(level+1, list, root.left);
        traverse(level+1, list, root.right);
    }
}
