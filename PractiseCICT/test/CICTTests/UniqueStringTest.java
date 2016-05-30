package CICTTests;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import CICT.UniqueString;


public class UniqueStringTest {

	@Test
	public void testIsUnique() {
		String s = "Ronak is!";
		
		assertTrue(s + " is not unique" , UniqueString.isUniqueASCII(s)) ;
		
		StringBuffer longStr = new StringBuffer("");
		for (int i = 0; i<255; i++){
			longStr.append( (char)i ); 
		}
		assertTrue(longStr + " is not Unique", UniqueString.isUniqueASCII(longStr.toString()));

	}

}
