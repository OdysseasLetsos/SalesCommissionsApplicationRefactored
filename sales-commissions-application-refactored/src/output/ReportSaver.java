package output;

import data.Salesman;

public abstract class ReportSaver {

	protected Salesman salesman;
	protected String fullpathnameString;
	
	abstract void initialiseSaveFile(String fullpathnameString);
	abstract void closeSaveFile();
	abstract void saveInFile(String name, String fieldsStr);

	
	public void saveFile(String fullpathnameString) {
		
		initialiseSaveFile(fullpathnameString);
    	saveInFile(salesman.getName(),"Name");
        saveInFile(salesman.getAfm(),"AFM");
        saveInFile(Double.toString(salesman.calculateTotalSales()),"Total Sales");
        saveInFile(Float.toString(salesman.calculateTrouserSales()),"Trousers Sales");
        saveInFile(Float.toString(salesman.calculateSkirtsSales()),"Skirts Sales");
        saveInFile(Float.toString(salesman.calculateShirtsSales()),"Shirts Sales");
        saveInFile(Float.toString(salesman.calculateCoatsSales()),"Coats Sales");
        saveInFile(Double.toString(salesman.calculateCommission()),"Comission");
    	closeSaveFile();
	
	}
	
}
