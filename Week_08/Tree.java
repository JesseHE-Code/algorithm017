// 二叉树层序遍历
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
        return result;
    }
    List<TreeNode> currentNodeList = new ArrayList<>();
    currentNodeList.add(root);
    while (!currentNodeList.isEmpty()) {
        List<TreeNode> nextNodeList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (TreeNode node : currentNodeList) {
            temp.add(node.val);
            if (node.left != null) {
                nextNodeList.add(node.left);
            }
            if (node.right != null) {
                nextNodeList.add(node.right);
            }
        }
        result.add(temp);
        currentNodeList.clear();
        for (TreeNode node : nextNodeList) {
            currentNodeList.add(node);
        }
        nextNodeList.clear();
    }
    return result;
}
