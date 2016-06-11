package CICT;


public class TestLLGen{

	public static void main(String[] args) {

		//Delete All
		LinkedListGen<Character> ll = new LinkedListGen<Character>();
		ll.newNodeFromArray(new Character[]{'a', 'b', 'c', 'b' });
		println("\nDeleting All: b");	
		ll.printList();
		ll.deleteAll('b');
		ll.printList();	

		//Delete
		LinkedListGen<Integer> ld = new LinkedListGen<Integer>();
		ld.newNodeFromArray(new Integer[]{1, 1, 1, 30, 11 });
		println("\nDeleting First: 30");	
		ld.printList();
		ld.delete(30);
		ld.printList();	

		//getMid
		LinkedListGen<Integer> lmid = new LinkedListGen<Integer>();
		lmid.newNodeFromArray(new Integer[]{1, 2, 43, 30, 11 });
		lmid.printList();
		println("\nMid:" + lmid.getMid());	

		//Length
		println("Length: " + lmid.length());

		//Reverse
		LinkedListGen<Integer> lrev = new LinkedListGen<Integer>();
		lrev.newNodeFromArray(new Integer[]{1, 2, 3 });
		println("\nReversing.." );				
		lrev.printList();
		lrev.reverse();
		lrev.printList();

		//Remove Duplicates
		LinkedListGen<Integer> llremDups = new LinkedListGen<Integer>();
		llremDups.newNodeFromArray(new Integer[]{1, 2, 4, 4, 1, 2, 5, 6, 1});
		println("\nRemoving duplicates" );				
		llremDups.printList();
		llremDups.removeDups();
		llremDups.printList();

		//DeleteMiddleNode given only that node
		LinkedListGen<Integer> llremMid = new LinkedListGen<Integer>();
		llremMid.newNodeFromArray(new Integer[]{1, 2, 4, 6, 1});
		LinkedListGen<Integer>.Node<Integer> nDel = llremMid.getHead().next.next; //4
		println("\nDeleteMiddleNode given only that node, node:" + nDel.data );				
		llremMid.printList();
		llremMid.removeMidNode(nDel);
		llremMid.printList();

		//kth To Last Element
		LinkedListGen<Integer> llkToLast = new LinkedListGen<Integer>();
		llkToLast.newNodeFromArray(new Integer[]{1, 2, 4, 6, 1, 8, 5, 0, 45, 87, 9});
		println("\nFind 2rd last elem" );				
		llkToLast.printList();
		LinkedListGen<Integer>.Node<Integer> k =  llkToLast.kthToLast(6);
		println(k.data + "");

		//partition around given valvue v
		//All less than v on left, all greater than equal to v on right
		LinkedListGen<Integer> llpart = new LinkedListGen<Integer>();
		llpart.newNodeFromArray(new Integer[]{1, 2, 4, 6, 1, 8, 5, 0, 45, 87, 9});
		int v = 5;
		println("\npartition around given value v=" +  v);				
		llpart.printList();
		llpart.partition(v);
		llpart.printList();


		//is the LinkedList<Integer> a palindrome
		LinkedListGen<Integer> llPalin = new LinkedListGen<Integer>();
		llPalin.newNodeFromArray(new Integer[]{1, 2, 4, 6, 1, 6, 4, 2, 1});
		print("\nisPalindrome  " );
		llPalin.printList();
		boolean isPalin = llPalin.isPalindrome();
		println(isPalin + "");				


//		LinkedList<Integer> llsort012 = new LinkedList<Integer>();
//		llsort012.newNodeFromArray(new Integer[]{0, 2, 1, 2, 2, 1, 0, 1, 1});
//		println("\n Sort a Linked List of 0s, 1s and 2s  " );
//		llsort012.printList();
//		llsort012.sortLLWithOnly0s_1s_2s();
//		llsort012.printList();
		
		//** other type checks





	}


	static void println(Object a){
		System.out.println((String)a);
	}

	static void print(Object a){
		System.out.print((String)a);
	}
}
