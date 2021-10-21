package ProjectTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project.OptionSearch;

public class OptionsSearchTest 
{
	private OptionSearch test1;
	@BeforeEach
	public void testConstructure() 
	{
		try {
		test1=new OptionSearch("spy.txt");
		}
		catch(IOException e){
			fail("Konstruktøren feilet.");
		}
	}
	@Test
	public void testScanner()
	{
		assertFalse(test1.getOptionChain().isEmpty());
	
	}
	@Test
	public void testOptionChain()
	{
		assertEquals("Symbol",test1.getOptionChain().get(0).get(0));
		assertEquals("381", test1.getOptionChain().get(1).get(2));
		assertEquals("54.53", test1.getOptionChain().get(5).get(6));
	}
	
	@Test
	public void testSetType()
	{
		test1.setType();
		for(int i=0; i<test1.getType().size();i++)
		{
			if(test1.getType().get(i).equals("Call")) {assertEquals("Call",test1.getType().get(i));}
			else if(test1.getType().get(i).equals("Put")){assertEquals("Put",test1.getType().get(i));}
			else {fail("The list of type should be all calls and puts");}
		}
	}
	
	@Test
	public void testSetTicker()
	{
		test1.setTicker();
		for(int i=0; i<test1.getTicker().size();i++)
		{
			assertTrue(test1.getTicker().get(i).equals("SPY"));
		}
		
	}
	
	@Test
	public void testSetTheta()
	{
		test1.setTheta();
		assertEquals(-0.0429, test1.getTheta().get(0));
		assertEquals(-0.0428, test1.getTheta().get(1));
		assertEquals(-0.0427, test1.getTheta().get(2));
		assertEquals(-0.04259, test1.getTheta().get(3));


	}
	
	@Test
	public void testSetDelta()
	{
		test1.setDelta();
		assertEquals(22.97, test1.getDelta().get(0));
		assertEquals(22.85, test1.getDelta().get(1));
		assertEquals(22.74, test1.getDelta().get(2));
		assertEquals(22.62, test1.getDelta().get(3));
		assertEquals(22.51, test1.getDelta().get(4));
		assertEquals(22.4, test1.getDelta().get(5));
	}
			
		
	
		
	
	
	

}
