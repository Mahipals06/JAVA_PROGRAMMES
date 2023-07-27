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
    public int kthSmallest(TreeNode root, int k) {
          List<Integer> re=new ArrayList();
          iot(root,re);  //get binary search tree inorder i.e converted to sorted list and get smallest 
          return re.get(k-1);
    }
     public void iot(TreeNode root,List<Integer> res){
        if(root==null)
        return;

        iot(root.left,res);
        res.add(root.val);
        iot(root.right,res); 
    }
}
