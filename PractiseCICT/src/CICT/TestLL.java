package CICT;


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
		llPalin.newNodeFromArray(new int[]{1, 2, 4, 6, 1, 6, 4, 2, 1});
		print("\nisPalindrome  " );
		llPalin.printList();
		boolean isPalin = llPalin.isPalindrome();
		println(isPalin + "");				

		// sort ll with only 0 or 1 or 2 
		LinkedList llsort012 = new LinkedList();
		llsort012.newNodeFromArray(new int[]{0, 2, 1, 2, 2, 1, 0, 1, 1});
		println("\n Sort a Linked List of 0s, 1s and 2s  " );
		llsort012.printList();
		llsort012.sortLLWithOnly0s_1s_2s();
		llsort012.printList();

/*
TODO
 
		//
		LinkedList ll1 = new LinkedList();
		ll1.newNodeFromArray(new int[]{7,1,6});
		LinkedList ll2 = new LinkedList();
		ll2.newNodeFromArray(new int[]{5,2,9});
		LinkedList llsumRev = new LinkedList();
		println("\n Sum of Two linkedList numbers in reverse order" );
		ll1.printList();
		ll2.printList();
		llsumRev.printList();
		LinkedList.Node sumHead = llsumRev.sumTwoLLReverse(ll1.getHead(), ll2.getHead());
		llsumRev.printList("Sum: ", sumHead);

*/		
		//Intersection
		intersection();









		

	}
	static void intersection(){
		//Test: create nodes for 1

		LinkedList llInter1 = new LinkedList();
		llInter1.DEBUG = true;
		llInter1.appendToTail(3);
		llInter1.appendToTail(1);
		llInter1.appendToTail(5);
		llInter1.appendToTail(9);
		llInter1.appendToTail(7);
		llInter1.appendToTail(2);
		llInter1.appendToTail(1);
		LinkedList.Node intersectingNode = llInter1.getHead().next.next.next.next;
		println("\nIntersection: " + intersectingNode.data);
		llInter1.printList("ll1: ",llInter1.getHead());
		LinkedList llInter2 = new LinkedList();
		llInter2.appendToTail(4);
		llInter2.appendToTail(6);
		llInter2.appendToTail(intersectingNode);
		llInter2.printList("ll2: ",llInter2.getHead());
		LinkedList llInter3 = new LinkedList();
		llInter3.appendToTail(3);
		llInter3.appendToTail(1);
		llInter3.appendToTail(5);
		llInter3.appendToTail(9);
		llInter3.appendToTail(7);
		llInter3.printList("ll3: ",llInter3.getHead());
		LinkedList.Node foundIntersectingNode12 = llInter1.intersection(llInter2.getHead());
		println("Found Intersection 1,2: " + foundIntersectingNode12.data);
		LinkedList.Node foundIntersectingNode13 = llInter1.intersection(llInter3.getHead());
		println("Found Intersection 1,3: " + (foundIntersectingNode13!=null?foundIntersectingNode13.data:"Not Found"));
	}


	static void println(Object a){
		System.out.println((String)a);
	}

	static void print(Object a){
		System.out.print((String)a);
	}
}
