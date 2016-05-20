/*
Binary Heap:
-	Complete Binary tree, only bottom level not balanced, 
	all the leaves stick to the left side
-	Height = Floor[log N], where N is the number of nodes
- 	Array reprststn, starting from a[1]
-	For k
		 Parent: 	k/2
		 Children:	2k, 2k+1
-	Swim: U move up in life upto certain level,  


 */

class MaxPriorityQ{
	private int capacity;
	private int heap[];
	private int N; //items

	MaxPQ(int capacity){
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.N = 0;
	}

	



}