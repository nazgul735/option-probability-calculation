package Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Probability
{
	private static final int Double = 0;
	private final OptionSearch oS= new OptionSearch("spy.txt");
	private FileHandling fileTasks;
	private List<String> ticker = new ArrayList<String>();
	private List<Double> theta = new ArrayList<Double>();
	private ArrayList<List<String>> optimalOptions = new ArrayList<List<String>>();
	private String type;
	private String filename;


	public Probability(int minprob, int maxprob, String type, String filename) throws IllegalArgumentException, IllegalAccessException, IOException
	{
		oS.setType();
		oS.setTheta();
		oS.setDelta();
		oS.setTicker();
		oS.getType();
		oS.getTheta();
		oS.getDelta();
		oS.getTicker();
		oS.getOptionChain();
		
		this.type=type.toUpperCase();
		
		if((this.type.equals("PUT"))||(this.type.equals("CALL")))
		{
			if(maxprob>0&&minprob>0)
			{
				if(100>maxprob)
				{
					if(minprob<=maxprob)
					{
						this.filename=filename;
						List<Double> x= oS.getDelta();
						List<String> y = oS.getType();
						
						for(int i=0; i<x.size(); i++)
						{
							if(type.toUpperCase().equals(y.get(i).toUpperCase()))
							{
								if(minprob<100-((x.get(i)))&&100-((x.get(i)))<maxprob)
								{
									optimalOptions.add(oS.getOptionChain().get(i+1));
									ticker.add(oS.getTicker().get(i));
									theta.add(oS.getTheta().get(i));
								}
							}
						}
					}
					else if(minprob>maxprob)
					{
						throw new IllegalArgumentException("The minimum probability needs to be lower then the max probability");
					}
				}
				else if(maxprob>100)
				{
					throw new IllegalArgumentException("You won't creat any value with this value. Have a lower max probability");
				}
			}
			
			else if(maxprob<0||minprob<0)
			{
				throw new IllegalArgumentException("Can't be negative");
			}
		}	
		
		else if(minprob>maxprob)
		{
			throw new IllegalArgumentException("The minimum probability needs to be lower then the max probability");
		}
		else if(maxprob>=100)
		{
			throw new IllegalArgumentException("You won't creat any value with this value. Have a lower max probability");
		}
		else if(minprob<30)
		{
			throw new IllegalArgumentException("Bad idea. To low probability for success");
		}

		else 
		{
			throw new IllegalArgumentException("It needs to be a call or a put. Nothing in between");
		}
		
		fileTasks=new FileHandling(filename, oS.getOptionChain(), optimalOptions);
	}
	
	public FileHandling getFileHandling()
	{
		return fileTasks;
	}
	
	public List<Double> getTheta()
	{
		return theta;
	}

	public List<String> getTicker()
	{
		return ticker;
	}
	public Object getFileTasks()
	{
		return fileTasks;
	}

	public void timeDecayFilter()
	{
		if(theta.size()==0)
		{
			throw new IllegalStateException("There's no options that satisfy your demands. Try a greater interval");
		}
		
		for(int i=0; i<theta.size(); i++)
		{
			if(-0.1<theta.get(i))
			{
				optimalOptions.remove(i+1);
				ticker.remove(i);
				theta.remove(i);
			}
			else
			{
				;
			}
		}
	}
	
	public ArrayList<List<String>> getOptimalOptions()
	{
		return optimalOptions;
	}
	
	
	public static void main(String[] args) 
	{
	}





}
