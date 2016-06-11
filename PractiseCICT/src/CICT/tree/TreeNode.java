package CICT.tree;
public class TreeNode{

	TreeNode left;
	TreeNode right;
	int data;

	public TreeNode(int data){
		this.data = data;
	}
	
	static TreeNode makeMinimalBinTree(int[] a){
		
		return makeMinimalBinTree(a, 0, a.length-1);
		
	}
	
	private static TreeNode makeMinimalBinTree(int[] a, int l, int r) {
		if(l>r){
			return null;
		}
		
		int mid = (l+r)/2;
		TreeNode midNode = new TreeNode(a[mid]);
		midNode.left = makeMinimalBinTree(a, l,mid-1);
		midNode.right = makeMinimalBinTree(a, mid+1, r);
		
		
		return midNode;
	}
	
	private static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		
		
		return commonAncestor(root, p, q, false, false);
	}

	private static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q, boolean foundLeft, boolean foundRight) {
		if(root.data == q.data)
			return root;
		
		return null;
	}
}

