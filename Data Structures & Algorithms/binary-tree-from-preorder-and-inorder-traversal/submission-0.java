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
    private int preIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder values and their indices
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int mid = map.get(rootValue);

        // Build left subtree first
        root.left = build(preorder, left, mid - 1);

        // Build right subtree
        root.right = build(preorder, mid + 1, right);

        return root;
    }
}