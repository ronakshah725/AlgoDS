public class TestLL{

	public static void main(String[] args) {
		
		//Delete All
		LinkedList ll = new LinkedList();
		ll.newNodeFromArray(new int[]{1, 1, 1, 30, 11 });
		ll.printList();
		println("Deleting All: 1");	
		ll.deleteAll(1);
		ll.printList();	

		//Delete
		LinkedList ld = new LinkedList();
		ld.newNodeFromArray(new int[]{1, 1, 1, 30, 11 });
		ld.printList();
		println("Deleting First: 30");	
		ld.delete(30);
		ld.printList();	

		//getMid
		LinkedList lmid = new LinkedList();
		lmid.newNodeFromArray(new int[]{1, 2, 43, 30, 11 });
		lmid.printList();
		println("Mid:" + lmid.getMid());	

		//Length
		println("Length: " + lmid.length());

		//Reverse
		LinkedList lrev = new LinkedList();
		lrev.newNodeFromArray(new int[]{1, 2, 3 });
		println("Reversing.." );				
		lrev.printList();
		
		lrev.reverse();
		
		lrev.printList();

		

	}


	static void println(Object a){
		System.out.println((String)a);
	}

	static void print(Object a){
		System.out.print((String)a);
	}
}