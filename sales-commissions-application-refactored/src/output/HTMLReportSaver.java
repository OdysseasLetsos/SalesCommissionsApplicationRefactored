package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import data.Salesman;

public class HTMLReportSaver extends ReportSaver{
	private String fullPathName;
	private BufferedWriter bufferedWriter=null;
	
	public HTMLReportSaver(Salesman a) {
		super();
		salesman = a;
	}

	@Override
	void initialiseSaveFile(String fullpathnameString) {
		this.fullPathName =  fullpathnameString +"\\" + salesman.getAfm() + "_SALES.html";
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Your Information</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Receipt Information</h1>\n";
		try {
			bufferedWriter.write(htmlContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("unused")
	private void createFileName(String fullpathnameString)  {
		this.fullPathName =  fullpathnameString +"\\" + salesman.getAfm() + "_SALES.html";
		System.out.println(fullPathName);
		
	}
	protected void saveInFile(String calculatedFields,String fieldsToSave) {
		try {
			bufferedWriter.write( "<p><strong>"+fieldsToSave+":</strong> " + calculatedFields+ "</p>\n"); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void closeSaveFile() {
		String strHtml= "</body>\n" +
                "</html>";
		try {
			bufferedWriter.write(strHtml);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
