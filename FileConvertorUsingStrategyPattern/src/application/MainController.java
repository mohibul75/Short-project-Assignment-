package application;

import java.io.File;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class MainController {
	
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	
	@FXML
	private Button btn3;
	
	@FXML
	private Button btn4;
	
	@FXML
	private Label lbl1;
	
	private String fileName=null;
	
	public void fileSelection(ActionEvent event) throws Exception {
		
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("txt file", "*.txt")
				,new FileChooser.ExtensionFilter("txt file", "*.TXT"));
		
		File seletedFile = fc.showOpenDialog(null);
		
		if(seletedFile != null) {
			
			fileName= seletedFile.getAbsolutePath();
			
			File file=new  java.io.File(fileName);
			
			  Scanner input = new Scanner(file);
			  
			  lbl1.setText(fileName);
  
		}
		
		else {
			
			System.out.println("file not found ");
			
		}
	}
	
	public void xml() {
		new Converter().convert(new Xml(fileName));;
		
	}
	
	public void csv() {
		new Converter().convert(new Csv(fileName));;
		
	}
	
	public void json() {
		new Converter().convert(new Json(fileName));;
		
	}

		
}
