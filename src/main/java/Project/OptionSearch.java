package Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OptionSearch 
{

	private List<Double> theta = new ArrayList<Double>();
	private List<Double> delta = new ArrayList<Double>(); 
	private List<String> ticker = new ArrayList<String>();
	private List<String> type = new ArrayList<String>();
	private String filename;
	private ArrayList<List<String>> optionChain=new ArrayList<List<String>>();
	
	public OptionSearch(String filename) throws IOException
	{
		this.filename=filename;
		Scanner optionFinder=null;
		optionFinder = new Scanner(new File(filename));
		while (optionFinder.hasNextLine())
		{
			List<String> temp= Arrays.asList(optionFinder.nextLine().split("	"));
			optionChain.add(temp);
		}
		optionFinder.close();
	}
	
	public ArrayList<List<String>> getOptionChain()
	{
		
		return optionChain;
	}
	
	public void setFile(String filename)
	{		
		this.filename=filename;
	}
	
	public void setType() throws IllegalStateException 
	{
		
		for (List<String> option : optionChain.subList(1, getOptionChain().size())) 
		{
			if(option.get(14).toUpperCase().equals("PUT")||option.get(14).toUpperCase().equals("CALL")==true&&option.get(14).length()==3||option.get(14).length()==4)
			{
				type.add(option.get(14));
			}
			else {throw new IllegalStateException("finner ingen put eller call. Sjekk om du har fylt inn riktig info");}
		}
	}
	
	public void setTheta() 
	{
		for (List<String> option : optionChain.subList(1, getOptionChain().size()))
		{
			try 
			{
				Double x=Double.parseDouble(option.get(9));
				theta.add(x);
			}
			catch(Exception e)
			{
				;
			}
			
		}
	}
	
	public void setDelta() 
	{
		for (List<String> option : optionChain.subList(1, getOptionChain().size())) 
		{
			try 
			{
				Double y=Double.parseDouble(option.get(5).replaceAll("%", ""));
				delta.add(y);
			}
			catch(Exception e)
			{
				;
			}
			
		}
	}
	public void setTicker()
	{
		for (List<String> option : optionChain.subList(1, getOptionChain().size())) 
		{
			if(option.get(1).contains("SPY")==true&&option.get(1).length()==3)
			{
				ticker.add(option.get(1));
			}
			else {throw new IllegalAccessError("vi analyserer bare SPY ETFen. Sjekk om du har riktig option-chain");}
		}
	}
	
	public List<String> getType()
	{
		return type;
	}
	
	public List<Double> getTheta()
	{
		return theta;
	}
	public List<Double> getDelta()
	{
		return delta;
	}
	public List<String> getTicker()
	{
		return ticker;
	}

	
	public static void main(String[] args) 
	{

	}

}

