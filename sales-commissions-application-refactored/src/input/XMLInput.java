package input;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLInput extends Input {
	protected DocumentBuilderFactory docBuilderFactory;
	protected DocumentBuilder docBuilder;
	protected	Document doc;
	protected	NodeList nodeLst;
	protected	NodeList receiptsNodeList;
	protected int element=-1;
	
	public XMLInput(File receiptFileXML ){

		super();
		inputFile = receiptFileXML;
		
	}
	
    

	protected void parseFile() throws DOMException{

    	this.docBuilderFactory = DocumentBuilderFactory.newInstance();
    	try {
			this.docBuilder= docBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
    	try {
			this.doc = docBuilder.parse(inputFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	doc.getDocumentElement().normalize();
        nodeLst = doc.getElementsByTagName("Agent");
    }

    protected void createReceiptsList() throws DOMException {
    	receiptsNodeList = ((Element) nodeLst.
    			item(0)).getElementsByTagName("Receipt");
    }
    private int parseSize() throws DOMException{
    	
    	return receiptsNodeList.getLength();
    }
    
    protected boolean checkForReceiptsfields() {
    	 int size = parseSize();
    	 element++;
    	if (element<size-1) {
			return true;
		}
    	return false;
    }
    
    protected String getTheValueOfLines(String elementString) {
    	if(elementString.equals("Receipt ID")) {
    		elementString="ReceiptID";
    	}
    	return ((Element) receiptsNodeList.item(element)).
    			getElementsByTagName(elementString).item(0).getChildNodes().item(0).getNodeValue().trim();
    }
    
    protected String getNameAfm(String NameAfm) {
    	return ((Element) nodeLst.item(0)).getElementsByTagName(NameAfm).
    			item(0).getChildNodes().item(0).getNodeValue().trim();
    }
    
    protected void closeFile() {
    	// TODO Auto-generated method stub
        }
  
}


