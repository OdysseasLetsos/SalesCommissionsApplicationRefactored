package output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import data.Receipt;


public class ReceiptParserTXT extends ReceiptParser{
	private FileWriter fileWriter;
		
	public ReceiptParserTXT() {
		super();
	}
	
	protected void initialiseFile(File filetoAppend) {	
			try {
				showThePath();
				FileWriter fileWriter = new FileWriter(fileToAppend,true);		
				this.fileWriter=fileWriter;
				fileWriter.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}



	private void showThePath() {
		System.out.println("Mpike sto TXT");
		System.out.println(fileToAppend.getAbsolutePath());
	}


	public void modifyReceipt(Receipt receipt) {
		this.receipt=receipt;
		
	}


	//writeInFile anti gia tiw prohgolumenes methodous
	protected void writeInFile(String thisreceipt,String receiptFields) {
		try {
			fileWriter.write(receiptFields+":");
			fileWriter.write(thisreceipt);
			fileWriter.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void closeFile(File filetoAppend) {
		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
