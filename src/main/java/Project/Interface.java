package Project;

import java.io.FileNotFoundException;

public interface Interface 
{
	public void writeOptions() throws Exception;
	public void clearOptions() throws FileNotFoundException;
	public String readOptimalOptions();

}
