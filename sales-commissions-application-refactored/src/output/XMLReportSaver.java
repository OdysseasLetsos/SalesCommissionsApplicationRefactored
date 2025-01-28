package output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import data.Salesman;

public class XMLReportSaver extends ReportSaver{
	private String fullPathName;
	private Document document;
	private Element agentElem;
	private DocumentBuilder documentBuilder;
	private DocumentBuilderFactory documentFactory;
		
	public XMLReportSaver(Salesman a){
			super();
			salesman = a;
	}	

	
	protected void initialiseSaveFile(String fullpathnameString) {
		createFileName(fullpathnameString);
		this.documentFactory = DocumentBuilderFactory.newInstance();
   	 	try {
			this.documentBuilder = documentFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
   	 	this.document = documentBuilder.newDocument();
   	 	// root element
   	 	this.agentElem = document.createElement("Agent");
   	 	document.appendChild(agentElem);
	}
	
	private void createFileName(String fullpathnameString) {
		this.fullPathName =  fullpathnameString +"\\"+ salesman.getAfm() + "_SALES.xml";
		System.out.println(fullPathName);
	}
	
	protected void saveInFile(String calculatedFields,String fieldsToSaveInFile) {
		Element calculatedElements = document.createElement(fieldsToSaveInFile.replace(" ",""));
		 calculatedElements.appendChild(document.createTextNode(calculatedFields));
		 agentElem.appendChild(calculatedElements);
	}

	
	protected void closeSaveFile() {
		 
	   	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
	   	 Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
	   	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	   	 transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	   	 DOMSource domSource = new DOMSource(document);
	   	 StreamResult streamResult = new StreamResult(new File(fullPathName));
	   	 try {
			transformer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	
}

