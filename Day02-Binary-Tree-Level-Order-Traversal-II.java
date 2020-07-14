/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

// SOLUTION

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;
        Queue<TreeNode> Q = new LinkedList();
        Q.add(root);

        while (Q.isEmpty() == false) {
            int n = Q.size();
            List<Integer> nodes = new ArrayList();
            for (int i = 0; i < n; ++i) {
                TreeNode node = Q.poll(); // q.poll() returns and deletes the head.
                nodes.add(node.val);
                if (node.left != null)
                    Q.add(node.left);
                if (node.right != null)
                    Q.add(node.right);

            }
            result.add(0, nodes);
        }

        return result;
    }
}