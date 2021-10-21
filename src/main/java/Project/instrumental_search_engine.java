package Project;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class OptionSearch 
{	
		
	private List<Double> theta = new ArrayList<Double>();
	private List<Double> delta = new ArrayList<Double>(); 
	private List<Double> vega = new ArrayList<Double>();
	private List<Double> gamma = new ArrayList<Double>();
	private List<String> ticker = new ArrayList<String>();
	private String filename;
	private ArrayList<String[]> optionChain = new ArrayList<String[]>();	
	
	public final void setFileName(String filename)
	{
		this.filename=filename;
	}
	
	public void getOptionsFromList() 
	{
		Scanner optionFinder = null;
		try
		{
			optionFinder = new Scanner(new File(filename));
			while (optionFinder.hasNext())
			{
				String[] option = optionFinder.nextLine().split(",");
			    optionChain.add(option);
			}
		}
		catch (Exception e) 
	    {
	        System.out.println("xx");
	    }
		optionFinder.close();
	}
	
	
	public String[] getOptionChain()
	{
		for (String[] option : optionChain) 
			{
			System.out.println(option);
			}
		return null;
		
	}
	
	public void setTheta() 
	{
		for (String[] option : optionChain) 
		{
			theta.add(Double.parseDouble(option[9]));
		}
	}
	
	public void setDelta() 
	{
		for (String[] option : optionChain) 
		{
			delta.add(Double.parseDouble(option[6]));
		}
	}
	public void setGamma()
	{
		for (String[] option : optionChain) 
		{
			gamma.add(Double.parseDouble(option[7]));
		}
	}
	public void setVega() 
	{
		for (String[] option : optionChain) 
		{
			vega.add(Double.parseDouble(option[10]));
		}
	}
	public void setTicker()
	{
		for (String[] option : optionChain) 
		{
			ticker.add(option[1]);
		}
	}
	
	public List<Double> getTheta()
	{
		return theta;
	}
	public List<Double> getDelta()
	{
		return delta;
	}
	public List<Double> getGamma()
	{
		return gamma;
	}
	public List<Double> getVega() 
	{
		return vega;
	}
	public List<String> getTicker()
	{
		return ticker;
	}

	public void main(String[] args) 
	{
		for (String[] option : optionChain) 
		{
		System.out.println(option);
		}
	}
}




	 
