/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

// SOLUTION

// Definition for a binary tree node.
//   public class TreeNode {
//       int val;
//       TreeNode left;
//       TreeNode right;
//       TreeNode() {}
//       TreeNode(int val) { this.val = val; }
//       TreeNode(int val, TreeNode left, TreeNode right) {
//           this.val = val;
//           this.left = left;
//           this.right = right;
//       }
//   }
 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return result;
        queue.add(root);
        boolean zigzag = false;
        while(!queue.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                
                if(zigzag) 
                    ls.add(0,node.val);
                else
                    ls.add(node.val);
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            
            result.add(ls);
            zigzag = !zigzag;
            
        }
        return result;
    }
}