/*
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) return new ArrayList<>(Arrays.asList(root.val));
        List<Integer> finalList = new ArrayList<>();
        List<TreeNode> treeNodeList = new ArrayList<>();
        int newNodeFlag = 1;
        treeNodeList.add(root);
        TreeNode currentNode;
        int size = treeNodeList.size();
        while(size != 0) {
            currentNode = treeNodeList.get(size - 1);
            if(newNodeFlag == 1) {
                finalList.add(currentNode.val);
            }
            if(currentNode.left != null) {
                treeNodeList.add(currentNode.left);
                newNodeFlag = 1;
            } else if(currentNode.right != null) {
                treeNodeList.add(currentNode.right);
                newNodeFlag = 1;
            } else if(size > 1) {
                if(treeNodeList.get(size - 2).left == currentNode) treeNodeList.get(size - 2).left = null; 
                if(treeNodeList.get(size - 2).right == currentNode) treeNodeList.get(size - 2).right = null; 
                treeNodeList.remove(size - 1);
                newNodeFlag = 0;
            } else {
                treeNodeList.remove(size - 1);
            }
            size = treeNodeList.size();
        }
        return finalList;
    }
}
