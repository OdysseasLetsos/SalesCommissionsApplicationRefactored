package output;

import java.io.File;



import data.Receipt;



public abstract class ReceiptParser {

	protected File fileToAppend;
	protected Receipt receipt;
		
	public abstract void modifyReceipt(Receipt receipt);
	abstract void initialiseFile(File filetoAppend);
	abstract void closeFile(File filetoAppend);
	abstract void writeInFile(String thisreceiptFields,String receiptFields);
	
	
	public void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
	}
	
	
	public void appendFile(){
		
		initialiseFile(fileToAppend);
		writeInFile(String.valueOf(receipt.getReceiptID()),"Receipt ID");
		writeInFile(String.valueOf(receipt.getDate()),"Date");
		writeInFile(String.valueOf(receipt.getKind()),"Kind");
		writeInFile(String.valueOf(receipt.getSales()),"Sales");
		writeInFile(String.valueOf(receipt.getItems()),"Items");
		writeInFile(String.valueOf(receipt.getCompany().getName()),"Company");
		writeInFile(String.valueOf(receipt.getCompany().getCompanyAddress().getCountry()),"Country");
		writeInFile(String.valueOf(receipt.getCompany().getCompanyAddress().getCity()),"City");
		writeInFile(String.valueOf(receipt.getCompany().getCompanyAddress().getStreet()), "Street");
		writeInFile(String.valueOf(receipt.getCompany().getCompanyAddress().getStreetNumber()),"Number");
		closeFile(fileToAppend);
					
	}

}

