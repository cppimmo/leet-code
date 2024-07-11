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
        List<Integer> elements = new ArrayList<Integer>(); // List formed from the traversal
        Stack<TreeNode> stack = new Stack<TreeNode>(); // Stack for iterative approach
        // Return the 
        if (root == null) {
            return elements;
        }
        // Start with the root element
        stack.push(root);
        while (!stack.empty()) {
            TreeNode current = stack.pop(); // Store current node then remove it
            elements.add(current.val); // Add the current node's value
            // Emplace right node first, so left node will be popped first
            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
        return elements;
    }
}
