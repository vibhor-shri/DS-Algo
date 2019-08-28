package binarytree;

public class TreeNode<T> {
	
	T data;
	TreeNode<?> leftNode;
	TreeNode<?> rightNode;

	public TreeNode(T data) {
		this.data = data;
	}

}
