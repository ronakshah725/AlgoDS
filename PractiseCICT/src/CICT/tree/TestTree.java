package tree;

public class TestTree{


	public static void main(String[] args) {
		
		TreeNode<Integer> n = new TreeNode<Integer>(15);
		n.left = new TreeNode<Integer>(12);
		n.right = new TreeNode<Integer>(17);

		n.left.left = new TreeNode<Integer>(9);
		n.left.right = new TreeNode<Integer>(13);

		n.left.left.left = new TreeNode<Integer>(7);
		n.left.left.right = new TreeNode<Integer>(10);

		n.left.right.left = new TreeNode<Integer>(12);
		n.left.right.right = new TreeNode<Integer>(14);



		n.right.left = new TreeNode<Integer>(16);
		n.right.right = new TreeNode<Integer>(18);

		n.right.left.left = new TreeNode<Integer>(15);
		n.right.left.right = new TreeNode<Integer>(14);

		n.right.right.left = new TreeNode<Integer>(12);
		n.right.right.right = new TreeNode<Integer>(14);




		
		BinaryTree<Integer> bt = new BinaryTree<Integer>(n);
		println("Inorder:");
		bt.inorder(n);

		println("Pre-order:");
		bt.preorder(n);

		println("Post-order:");
		bt.postorder(n);
	}


	static void println(Object a){
		System.out.println(a.toString());
	}

	static void print(Object a){
		System.out.print(a.toString());
	}
}