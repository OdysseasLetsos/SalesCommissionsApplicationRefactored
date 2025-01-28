package input;

import java.io.File;
import org.jsoup.select.Elements;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class HTMLInput extends Input{
	protected Document doc;
	protected Elements receiptElements;
	protected Element receiptElement;
	protected	Element targetElement;
	protected int element=0;
	
	public HTMLInput(File receiptFileHTML ){

		super();
		this.inputFile = receiptFileHTML;
		
	}
	
	@Override
	protected void parseFile() {
		try {
			System.out.println("");
			doc=Jsoup.parse(inputFile,"UTF-8");
		} catch (IOException e) {
			JOptionPane.showMessageDialog
			(null,"Προέκυψε κάποιο πρόβλημα κατά το διάβασμα του αρχείου");
		}
	}
	
	@Override
	protected String getNameAfm(String NameAfm) {
		return getValue(doc,"p:contains("+NameAfm+")");
	}
	
	@Override
	protected void createReceiptsList() {
		receiptElements=doc.select(".receipt");
		
		
	}
	private int parseSize(){
    	return receiptElements.size();
    }
	
	@Override
	protected boolean checkForReceiptsfields() {
		int size=parseSize();
		if(element<size) {	
			receiptElement = receiptElements.get(element);
			element++;
			return true;
		}else {
			
			return false;
		}
		
		
	}
	
	@Override
	protected String getTheValueOfLines(String elementString) {
		return getValue(receiptElement, "p:contains("+elementString+")");

	}
	
	
	 private  String getValue(Element element, String htmlLine) {
	        targetElement = element.selectFirst(htmlLine);
	        return (targetElement != null) ? targetElement.ownText().trim() : "";
	    }
	 
	 @Override
		protected void closeFile() {
			// TODO Auto-generated method stub
			
		}

}
