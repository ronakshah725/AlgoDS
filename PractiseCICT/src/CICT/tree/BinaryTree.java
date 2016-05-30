package CICT.tree;

class BinaryTree <Key extends Comparable<Key>>{
	TreeNode<Key> root;

	BinaryTree(TreeNode<Key> root){
		this.root = root;
	}

	BinaryTree(Key data){
		TreeNode<Key> n = new TreeNode<Key>(data);
		root = n;
	}


	void inorder(TreeNode<Key> root){

		if(root == null)
			return;

		inorder(root.left);
		print(root.data + " ");
		inorder(root.right);

	}


	void preorder(TreeNode<Key> root){

		if(root == null)
			return;

		print(root.data + " ");
		preorder(root.left);
		preorder(root.right);

	}


	void postorder(TreeNode<Key> root){

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