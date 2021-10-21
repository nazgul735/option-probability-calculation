package Project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AppController 
{
	@FXML private TextField minProbTextField, maxProbTextField;
	@FXML private TextArea textPanel=new TextArea();
	@FXML private Button button;
	@FXML private RadioButton putRadioButton, callRadioButton;
	@FXML private ToggleGroup group=new ToggleGroup();
	
	private Probability probability;
	private FileHandling preRead;
	private String result;
	private String type;

	
	@FXML
	void initialize() 
	{		
		textPanel.setEditable(false);
		textPanel.setWrapText(true);
		putRadioButton.setUserData("put");
		callRadioButton.setUserData("call");
		
		putRadioButton.setToggleGroup(group);
		callRadioButton.setToggleGroup(group);
		
		preRead=new FileHandling("optimalOptions.txt");
		result=preRead.readOptimalOptions();
		textPanel.setText(result + "\n"+"From last time");
	}

	public void onButtonPush() 
	{

		
		if(putRadioButton.isSelected()){type="put";}
		else if(callRadioButton.isSelected()){type="call";}
		
		try
		{
			int minProbInt=Integer.parseInt(minProbTextField.getText());
			int maxProbInt=Integer.parseInt(maxProbTextField.getText());
			probability=new Probability(minProbInt, maxProbInt, type, "OptimalOptions.txt");
			probability.timeDecayFilter();
			probability.getFileHandling().clearOptions();
			probability.getFileHandling().writeOptions();
			result = probability.getFileHandling().readOptimalOptions();
			textPanel.setText(result);
		}
		catch(Exception e)
		{
			textPanel.setText(e.getMessage());
		}
	}
}
