

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SubsetTest {

	@Before
	public void setUp() {
		  RandomizedQueue<String> inputList = new RandomizedQueue<String>();
		    while(!edu.princeton.cs.introcs.StdIn.isEmpty()){	
		    	String input = edu.princeton.cs.introcs.StdIn.readString();
		    	if(input != null){
		    		inputList.enqueue(input);
		    	}
		    }
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test() {
		
		fail("Not yet implemented");
	}

}
