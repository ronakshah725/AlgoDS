package CICT.sort.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CICT.AssortedMethods;
import CICT.sort.BasicSorts;

import java.util.Arrays;

public class BasicSortsTest{
	static int[] bigN, smallN, smallCopy, bigCopy;

	@Before
	public void init() {
		bigN = AssortedMethods.randomArray(1000000, 100, 500);
		bigCopy = new int [bigN.length];
		System.arraycopy (bigN, 0, bigCopy, 0, bigN.length);
		Arrays.sort(bigCopy);
//		System.out.println("Big: "+ Arrays.toString(bigCopy));
		smallN =  AssortedMethods.randomArray(10, 100, 500);
		smallCopy = new int[smallN.length];
		System.arraycopy(smallN, 0, smallCopy, 0, smallN.length);
		Arrays.sort(smallCopy);
//		System.out.println( "Small: "+Arrays.toString(smallCopy));
	}

	@Test
	public void testInsertion() throws Exception{
		int[] sorted = BasicSorts.sort("insertion", bigN);
		assertArrayEquals(bigCopy, sorted);

	}

}