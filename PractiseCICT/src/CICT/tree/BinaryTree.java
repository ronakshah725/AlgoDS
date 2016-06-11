
class BinaryTree {
	TreeNode root;

	BinaryTree(TreeNode root){
		this.root = root;
	}


	BinaryTree(){}
	
//	public TreeNode makeTreeFromSortedIterative(int[]a){
//		if (a.length == 0) 
//			return null;
//		int mid = a.len
//		TreeNode n = new TreeNode()
//		return null;
//	}

	void inorder(TreeNode root){

		if(root == null)
			return;

		inorder(root.left);
		print(root.data + " ");
		inorder(root.right);

	}


	void preorder(TreeNode root){

		if(root == null)
			return;

		print(root.data + " ");
		preorder(root.left);
		preorder(root.right);

	}


	void postorder(TreeNode root){

		if(root == null)
			return;

		postorder(root.left);
		postorder(root.right);		
		print(root.data + " ");

	}
	

	
	

	static void println(Object a){
		System.out.println(a.toString());
	}

	static void print(Object a){
		System.out.print(a.toString());
	}


	
}
