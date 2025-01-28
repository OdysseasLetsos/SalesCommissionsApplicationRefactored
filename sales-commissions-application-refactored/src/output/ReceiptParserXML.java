package output;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import data.Receipt;

public class ReceiptParserXML  extends ReceiptParser{
		private Document doc;
		private Element receiptElem;
		private DocumentBuilder docBuilder;
		private DocumentBuilderFactory docFactory;
		private Node agent;
		
		
		public ReceiptParserXML() {
				super();
		}
		
		protected void initialiseFile(File filetoAppend) {
			
			try {
				docFactory = DocumentBuilderFactory.newInstance();
				docBuilder = docFactory.newDocumentBuilder();
				doc = docBuilder.parse(fileToAppend);
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			agent = doc.getFirstChild();
			receiptElem=doc.createElement("Receipts");
			receiptElem = doc.createElement("Receipt");
			agent.appendChild(receiptElem);
		}
		
		
		
		public void modifyReceipt(Receipt receipt) {
				this.receipt=receipt;
		}
					

		protected void writeInFile(String thisreceipt,String receiptFields) {
			if (receiptFields.equals("Receipt ID")) {
				receiptFields="ReceiptID";
				
			}
				Element ElemFields = doc.createElement(receiptFields);
				ElemFields.appendChild(doc.createTextNode(thisreceipt));
				receiptElem.appendChild(ElemFields);
		}
		
		
		protected void closeFile(File filetoAppend) {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = null;
			try {
				transformer = transformerFactory.newTransformer();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fileToAppend);
			try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
