package Project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileHandling implements Interface {
	
	private final OptionSearch oS;
	private String filename;
	private ArrayList<List<String>> optionChain;
	private ArrayList<List<String>> optimalOptions;
	private String result;
	

	
	
	public FileHandling(String filename, ArrayList<List<String>> optionChain, ArrayList<List<String>> optimalOptions) throws IOException
	{
		this.filename=filename;
		this.optimalOptions=optimalOptions;
		this.optionChain=optionChain;
		oS=new OptionSearch("spy.txt");
		
	}
	public FileHandling(String filename)
	{
		this.oS = null;
		this.filename= filename;
	}
	
	@Override
	public void writeOptions() throws IOException  
	
	{
		try
		{
			PrintWriter writer = new PrintWriter(filename);
			writer.println(oS.getOptionChain().get(0));
			for(int i=0; i<optimalOptions.size(); i++)
			{
				writer.println(optimalOptions.get(i));
			}
			writer.flush();
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void clearOptions() throws FileNotFoundException 
	{
		PrintWriter deleter = new PrintWriter(filename);
		deleter.print("");
		deleter.close();
	}
	
	@Override
	public String readOptimalOptions()
	{
		BufferedReader br = null;
		result="";
		try
		{
			String strCurrentLine;
			br = new BufferedReader(new FileReader(filename));
			while((strCurrentLine=br.readLine()) != null)
			{
				result=result.concat(strCurrentLine+"\n");
			}
			
		} 
		catch(IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				br.close();
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public String getResult()
	{
		return result;
	}
		
	public static void main(String[] args) 
	{

		
	}

}
