package data;

import java.util.ArrayList;

import output.ReceiptParser;
import output.ReceiptParserTXT;
import output.ReceiptParserXML;


public class Salesman {
	
	private String name;
	private String afm;
	private ArrayList <Receipt> allReceipts;
	private ReceiptParser receiptParser;
	
	
	public Salesman(){
		allReceipts = new ArrayList<Receipt>();
	}
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")){
			receiptParser = new ReceiptParserTXT();
		}	
		else if(fileType.equals("XML")){
			receiptParser = new ReceiptParserXML();
		}	
	}
	
	public ArrayList<Receipt> getReceipts(){
		return allReceipts;

	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAfm() {
		return afm;
	}
	
	public void setAfm(String afm) {
		this.afm = afm;
	}
	
	
	
	public float calculateKindSales(String kindString) {
		float kindsum=0;
		for (int i = 0; i< allReceipts.size(); i++){
			if(allReceipts.get(i).getKind().equals(kindString)){
				kindsum += allReceipts.get(i).getItems();
			}
		}		
		return kindsum;
	}
	
	
	
	public double calculateTotalSales(){
		double sumSales = 0;
		
		for(int i = 0; i< allReceipts.size(); i++){
			sumSales += allReceipts.get(i).getSales();
		}
		return sumSales;
	}
	
	
	public int calculateTotalItems(){
		int sumItems = 0;
		for(int i = 0; i< allReceipts.size(); i++){
			sumItems += allReceipts.get(i).getItems();
		}
		return sumItems;
	}
	
	
	public float calculateSkirtsSales(){
		return calculateKindSales("Skirts");
	}

	
	public float calculateCoatsSales(){
		return calculateKindSales("Coats");
	}
	
	public float calculateTrouserSales(){
		return calculateKindSales("Trousers");
	}
	
	
	public float calculateShirtsSales(){
		return calculateKindSales("Shirts");
	}
	
	//TO-DO inline temp
	public double calculateCommission(){
		if( this.calculateTotalSales() > 6000 && this.calculateTotalSales()<= 10000){
			 return 0.1*(calculateTotalSales()-6000);
		}
		else if(this.calculateTotalSales() > 10000 && this.calculateTotalSales() <= 40000 ){
			return (((calculateTotalSales() - 10000) * 0.15) + (10000*0.1));			
		}
		else if(this.calculateTotalSales() > 40000 ) {
			return 10000*0.1 + 30000*0.15 + (calculateTotalSales() - 40000)*0.2;			
		}else {
			return 0;
		}
		
	}


	public ReceiptParser getFileAppender() {
		return receiptParser; 
	}


}
