public class TestLL{

	public static void main(String[] args) {
		
		//Delete All
		LinkedList ll = new LinkedList();
		ll.newNodeFromArray(new int[]{1, 1, 1, 30, 11 });
		println("\nDeleting All: 1");	
		ll.printList();
		ll.deleteAll(1);
		ll.printList();	

		//Delete
		LinkedList ld = new LinkedList();
		ld.newNodeFromArray(new int[]{1, 1, 1, 30, 11 });
		println("\nDeleting First: 30");	
		ld.printList();
		ld.delete(30);
		ld.printList();	

		//getMid
		LinkedList lmid = new LinkedList();
		lmid.newNodeFromArray(new int[]{1, 2, 43, 30, 11 });
		lmid.printList();
		println("\nMid:" + lmid.getMid());	

		//Length
		println("Length: " + lmid.length());

		//Reverse
		LinkedList lrev = new LinkedList();
		lrev.newNodeFromArray(new int[]{1, 2, 3 });
		println("\nReversing.." );				
		lrev.printList();
		lrev.reverse();
		lrev.printList();

		//Remove Duplicates
		LinkedList llremDups = new LinkedList();
		llremDups.newNodeFromArray(new int[]{1, 2, 4, 4, 1, 2, 5, 6, 1});
		println("\nRemoving duplicates" );				
		llremDups.printList();
		llremDups.removeDups();
		llremDups.printList();

		//DeleteMiddleNode given only that node
		LinkedList llremMid = new LinkedList();
		llremMid.newNodeFromArray(new int[]{1, 2, 4, 6, 1});
		LinkedList.Node nDel = llremMid.getHead().next.next; //4
		println("\nDeleteMiddleNode given only that node, node:" + nDel.data );				
		llremMid.printList();
		llremMid.removeMidNode(nDel);
		llremMid.printList();

		//kth To Last Element
		LinkedList llkToLast = new LinkedList();
		llkToLast.newNodeFromArray(new int[]{1, 2, 4, 6, 1, 8, 5, 0, 45, 87, 9});
		println("\nFind 2rd last elem" );				
		llkToLast.printList();
		LinkedList.Node k =  llkToLast.kthToLast(6);
		println(k.data + "");

		//partition around given valvue v
		//All less than v on left, all greater than equal to v on right
		LinkedList llpart = new LinkedList();
		llpart.newNodeFromArray(new int[]{1, 2, 4, 6, 1, 8, 5, 0, 45, 87, 9});
		int v = 5;
		println("\npartition around given value v=" +  v);				
		llpart.printList();
		llpart.partition(v);
		llpart.printList();


		//is the linkedList a palindrome
		LinkedList llPalin = new LinkedList();
		// llPalin.newNodeFromArray(new int[]{1, 2, 2, 1});
		llPalin.newNodeFromArray(new int[]{1, 2, 4, 6, 1, 6, 4, 2, 1});

		print("\nisPalindrome  " );
		llPalin.printList();
		boolean isPalin = llPalin.isPalindrome();
		println(isPalin + "");				



		

	}


	static void println(Object a){
		System.out.println((String)a);
	}

	static void print(Object a){
		System.out.print((String)a);
	}
}