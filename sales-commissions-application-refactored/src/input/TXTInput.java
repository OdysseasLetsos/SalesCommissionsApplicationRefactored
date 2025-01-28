 package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class TXTInput extends Input{
	protected BufferedReader br=null;
	protected String line;
	
	public TXTInput(File recieptFileTXT){
	
		super();
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
		
	}
	
	
	

	

	public void parseFile() {
		   try {
		            	
				br = new BufferedReader(new FileReader(inputFilePath));
			} catch (FileNotFoundException e1) {
					e1.printStackTrace();
			}
	}

	protected String getTheValueOfLines(String elementString) {
		String valueOflineString=""; 
			valueOflineString=(line.substring(line.indexOf(":") + 1).trim());
			try {
				getLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return valueOflineString;
	}
	
	protected String getNameAfm(String NameAfm) {
			try {
				NameAfm=getLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return (NameAfm.substring(line.indexOf(":")+1).trim());
		
	}

	private String getLine() throws IOException {
		line=br.readLine();
		return line;
	}
	
	protected void createReceiptsList() {
		try {
			getLine();
			getLine();
			getLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	protected boolean checkForReceiptsfields() {
		try {
			if ((getLine() != null)) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	protected void closeFile() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
