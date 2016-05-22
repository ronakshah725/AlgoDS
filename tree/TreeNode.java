package tree;
class TreeNode{

	TreeNode left;
	TreeNode right;
	int data;

	public TreeNode(int data){
		this.data = data;
	}

	@Override
	public String toString(){

		return "TreeNode = " + this.data;
	}
}

