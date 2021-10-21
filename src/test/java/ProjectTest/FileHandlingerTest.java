package ProjectTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Project.Probability;



public class FileHandlingerTest 

{
	private Probability probability;
	@BeforeEach
	public void TestFileHandlinger() 
	{
		try {
			probability = new Probability(30, 90, "Call", "OptimalOptions.txt");
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		probability.timeDecayFilter();
	}
	
	@Test
	public void testOptionReaderAndWriter() 
	{
		try 
		{
			probability.getFileHandling().writeOptions();
			probability.getFileHandling().readOptimalOptions();
			assertFalse(probability.getFileHandling().getResult()==null);
		} 
		catch (IOException e)
		{
			fail("resultater skal ikke være null");
			
		}
		
	}
	@Test
	public void testClearOptions()
	{
		try 
		{
			probability.getFileHandling().writeOptions();
			probability.getFileHandling().clearOptions();
			probability.getFileHandling().readOptimalOptions();
			assertTrue(probability.getFileHandling().getResult()=="");
		} 
		catch (IOException e)
		{
			fail("resultater skal være tom");
		}
	}
}
