package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Salesman;


public class TXTReportSaver extends ReportSaver{
	  private BufferedWriter bufferedWriter = null;
	  private String fullPathName;
	
	public TXTReportSaver(Salesman a){
		super();
		salesman = a;
	}
	
	
	protected void initialiseSaveFile(String fullpathnameString) {
		System.out.println(fullpathnameString);
		this.fullPathName =  fullpathnameString+"\\" + salesman.getAfm() + "_SALES.txt";
    	try {
			bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void closeSaveFile() {
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected void saveInFile(String calculatedFields,String fieldsToSaveInFile) {
		try {
			bufferedWriter.write(fieldsToSaveInFile +":"+calculatedFields);
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
