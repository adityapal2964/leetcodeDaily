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
class CBTInserter {
    TreeNode root = null;
    List<TreeNode> list = new ArrayList<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            this.list.add(node);
            if(node.left!= null){
                q.add(node.left);
            }
            if(node.right!= null){
                q.add(node.right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        this.list.add(node);
        int indx = list.size()-1;
        TreeNode par = list.get((indx-1)/2);
        if(par.left == null)par.left = node;
        else par.right = node;
        return par.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */