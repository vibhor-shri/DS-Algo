package binarytree;

/*
 * Check if two given binary trees are identical or not, ie, their structure should be the same 
 * as well as the data in it should be the same.
 * 
 * There are 2 approaches to solve this problem, both are given below.
 */

public class CheckIfTwoBinaryTreesAreIdentical {

	public static void main(String[] args) {
		TreeNode<?> root = new TreeNode<>(10);
		root.leftNode = new TreeNode<>(5);
		root.rightNode = new TreeNode<>(3);

		TreeNode<?> root1 = new TreeNode<>(10);
		root1.leftNode = new TreeNode<>(5);
		root1.rightNode = new TreeNode<>(3);

		System.out.println(isBalanced(root, root1));

	}

	/*
	 * Recursive approach
	 * 
	 * Time complexity O(n)
	 * Space complexity O(1)
	 */
	
	private static boolean isBalanced(TreeNode<?> node1, TreeNode<?> node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		return (node1 != null && node2 != null) && (node1.data == node2.data)
				&& isBalanced(node1.leftNode, node2.leftNode) && isBalanced(node1.rightNode, node2.rightNode);

	}

}
