package CICT;

import java.util.Arrays;

public class HashTable{
	
	@Override
	public String toString() {
		return "HashTable [arr_of_lists=" + Arrays.toString(arr_of_lists) + ", N=" + N + ", Cap=" + Cap
				+ ", hashCode()=" + hashCode() + "]";
	}

	LinkedList[] arr_of_lists;
	int N;
	int Cap;
	private static final int DEFAULT_CAP = 10000;
		
	public HashTable() {
		this.Cap = DEFAULT_CAP;
		arr_of_lists = new LinkedList[Cap];
		this.N = 0;
		initList();
		
	}

	private void initList() {
		for (int i=0; i<Cap; i++){
			arr_of_lists[i] = new LinkedList();
		}
	}

	public HashTable(int initCap) {
		this.Cap = initCap > DEFAULT_CAP ? initCap : DEFAULT_CAP; 
		arr_of_lists = new LinkedList[Cap];
		this.N = 0;
		initList();

	}

	//get
	public Integer get(Integer key){
		
		LinkedList keyList = getLinkedList(key);
		Node val = keyList.get(key) ;
		return val!=null ? val.value : null;		
	}


	//put
	public void put(Integer key, Integer value){
		LinkedList keyList = getLinkedList(key);
		keyList.add(key, value);
		
	}
	
	//containsKey
	public boolean containsKey(Integer key){
		LinkedList keyList = getLinkedList(key);
		Node val = keyList.get(key) ;
		return val!=null ? true : false;		
	}
	
	private LinkedList getLinkedList(Integer key) {
		int hashcode = Integer.hashCode(key);
		int pos = hashcode%Cap;
		return arr_of_lists[pos];
	}
		

	class LinkedList {
		@Override
		public String toString() {
			return "LinkedList [head=" + head + ", N=" + N + "]";
		}

		Node head;
		int N;
		
		public LinkedList(Node head) {
			this.head = head;
			N = 0;
		}
		
		public LinkedList() {
			this.head = null;
			N = 0;
		}
		
		private void add (int k, int v){
			System.out.println(k);
			Node node = new Node(k,v);
			if(head == null) {
				head = node;
			}
			node.next = head;
			head = node;
			N++;
		}
		
		private void remove(int v){
			if(head == null)
				return;
			if(head.key == v){
				head = head.next;
				return;
			}
			Node n = head.next;
			Node prev = head;
			while(n!=null){
				if(n.key == v){
					prev.next = n.next;
					return;
				}
				prev = n;
				n = n.next;
			}
		}
		
		//return node if found, else returns null
		private Node get(int key){
			if(head==null)
				return head;
			if(head.key == key){
				return head;
			}
			Node n = head.next;
			while(n!= null){
				if(n.key == key)
					return n;
				n = n.next;
			}
			return null;
		}
		


	}
	
	private class Node{
		int key;
		int value;
		Node next;
		
		Node(int data, int value){
			this.key = data;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[" + key + ", " + value + "]";
		}
		
		
		
	}

	public static void main(String[] args) {
		HashTable map = new HashTable();
		map.put(1000101, 10);
		map.put(2, 200);
		map.put(3, 3000);
		
		System.out.println(map.containsKey(1000101));
		System.out.println(map.get(3));
	
	}
}