package ProjectTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Project.Probability;

public class ProbabilityTest 
{
	
	private Probability test1;
	private Probability test2;
	private Probability test3;
	private Probability test4;
	private Probability test5;
	
	@Test
	public void testWrongType()
	{
		assertThrows(
				IllegalArgumentException.class, 
				() -> test1 = new Probability(10, 85, "calle", "optimalOptions.txt"),
				"IllegalArgumentException kastes for ugyldige typer");
	}
	
	@Test
	public void testWrongMinnMax()
	{
		assertThrows(
				IllegalArgumentException.class, 
				() -> test2 = new Probability(20, 15, "put", "optimalOptions.txt"),
				"IllegalArgumentException kastes når laveste sannsynlighet er høyere enn max sannsynlighet");
	}
	
	@Test
	public void testWrongMaxProb()
	{
		assertThrows(
				IllegalArgumentException.class, 
				() -> test3 = new Probability(20, 105, "put", "optimalOptions.txt"),
				"IllegalArgumentException kastes når høyeste sannsynlighet er for høy til å skape verdier i form av delta");
	}
	
	@Test
	public void timeDecayFilter() 
	{
		try{
		test4=new Probability(40, 80, "put", "optimalOptions.txt");
		test4.timeDecayFilter();
		test4.getTicker().size();
		}
		catch(Exception e)
		{
			fail("Check your list of theta values.");
		}
	}
	
	@Test
	
	public void testTopToBottom() 
	{
		try
		{
			test5 = new Probability(40, 80, "put", "optimalOptions.txt");
			test5.timeDecayFilter();
			assertTrue(test5.getTheta().get(0).equals(-0.05543));
			assertTrue(test5.getTheta().get(1).equals(-0.0555));
			assertTrue(test5.getTheta().get(2).equals(-0.05495));
			assertTrue(test5.getTheta().get(3).equals(-0.05499));
		}
		catch(Exception e)
		{
			fail("");
		}
		
	}
}
	


