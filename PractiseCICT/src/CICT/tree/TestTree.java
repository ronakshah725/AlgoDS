
public class TestTree{


	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();	
		println("Sorted");
		TreeNode sorted = TreeNode.makeMinimalBinTree(new int[]{3,5,7,9,11,12,17});
		print("Inorder:");
		bt.inorder(sorted);
		print("\nPre-order:");
		bt.preorder(sorted);
		print("\nPost-order:");
		bt.postorder(sorted);
		println("");
		BTreePrinter.printNode(sorted);
	}

/*
	private static TreeNode makeTree() {
		TreeNode n = new TreeNode(15);
		n.left = new TreeNode(12);
		n.right = new TreeNode(17);

		n.left.left = new TreeNode(9);
		n.left.right = new TreeNode(13);

		n.left.left.left = new TreeNode(7);
		n.left.left.right = new TreeNode(10);

		n.left.right.left = new TreeNode(12);
		n.left.right.right = new TreeNode(14);



		n.right.left = new TreeNode(16);
		n.right.right = new TreeNode(18);

		n.right.left.left = new TreeNode(15);
		n.right.left.right = new TreeNode(14);

		n.right.right.left = new TreeNode(12);
		n.right.right.right = new TreeNode(14);
		return n;
	}
*/

	static void println(Object a){
		System.out.println(a.toString());
	}

	static void print(Object a){
		System.out.print(a.toString());
	}
}
