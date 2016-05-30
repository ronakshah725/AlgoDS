package tree;
public class TreeNode<Key extends Comparable<Key>>{

	TreeNode left;
	TreeNode right;
	Key data;

	public TreeNode(Key data){
		this.data = data;
	}

	@Override
	public String toString(){

		return this.data.toString();
	}
}

