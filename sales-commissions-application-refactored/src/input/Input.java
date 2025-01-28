package input;


import java.io.File;
import javax.swing.JOptionPane;

import data.Salesman;
import data.Receipt;


public abstract class Input {
	
	protected Salesman salesman;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;


	 public void readFile() {
	    	 try {
	        	parseFile();
	        	name = getNameAfm("Name");
				afm=getNameAfm("AFM");
				addAgent();
				createReceiptsList();
	            while(checkForReceiptsfields()){
	            	receiptID = Integer.parseInt(getTheValueOfLines( "Receipt ID"));
	            	date = getTheValueOfLines("Date");
	            	kind = getTheValueOfLines("Kind");
	            	sales = Double.parseDouble(getTheValueOfLines("Sales"));
	            	items = Integer.parseInt(getTheValueOfLines("Items"));
	            	companyName = getTheValueOfLines( "Company");
	            	companyCountry = getTheValueOfLines( "Country");
	            	companyCity = getTheValueOfLines( "City");
	            	companyStreet = getTheValueOfLines( "Street");
	            	companyStreetNumber = Integer.parseInt(getTheValueOfLines( "Number"));
					addReceipt();
					
	            }   
	            closeFile();
	        } catch (Exception e) {
	        	System.out.println(e);
	        	JOptionPane.showMessageDialog
				(null,"Προέκυψε κάποιο πρόβλημα κατά το διάβασμα του αρχείου");
			} 
	    	  
	    	 
	    }
	
	protected abstract void closeFile();

	protected abstract String getTheValueOfLines(String string);

	protected abstract boolean checkForReceiptsfields();

	protected abstract void createReceiptsList();

	protected abstract String getNameAfm(String string);

	protected abstract void parseFile();

	public Input() {
		salesman = new Salesman();
		kind  = new String("");
	}
	

	
	public void addAgent() {
		salesman.setName(name);
		salesman.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt=new Receipt();	
			if(kind.equals("Shirts")) {
				//kind="Shirts";
				receipt.setKind(kind);

			}
			else if (kind.equals("Skirts")) {
				//kind="Skirts";
				receipt.setKind(kind);

			}
			else if (kind.equals("Trousers")) {
				//kind="Trousers";
				receipt.setKind(kind);

			}
			else if(kind.equals("Coats")){
				//kind="Coats";
				receipt.setKind(kind);
			}
			
			receipt.setReceiptID(receiptID);			
			receipt.setDate(date);
			receipt.setSales(sales);
			receipt.setItems(items);
			receipt.getCompany().setName(companyName);
			receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
			receipt.getCompany().getCompanyAddress().setCity(companyCity);
			receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
			receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
			salesman.getReceipts().add(receipt);
	}
	public Salesman getAgent() {
		return salesman;
	}

	

	
}
