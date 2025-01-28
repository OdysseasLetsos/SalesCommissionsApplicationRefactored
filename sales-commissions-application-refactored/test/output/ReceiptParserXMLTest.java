package output;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Receipt;
import input.XMLInput;

class ReceiptParserXMLTest {

	String filePath;
	File mockFile;
	XMLInput inputTest;
	private ReceiptParserXML receiptParser;
	
	@BeforeEach
	void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-2-XML.xml";
		mockFile=new File(filePath);
		inputTest=new XMLInput(mockFile);
		Receipt receiptTest = new Receipt();
		receiptTest.setReceiptID(1);
		receiptTest.setDate("11/12/2023");
		receiptTest.setSales(60000.0);
		receiptTest.setItems(10);
		receiptTest.setKind("Trousers");
		receiptTest.setCompanyName("ADIDAS");;
		receiptTest.setCompanyCountry("GREECE");
		receiptTest.setCompanyCity("Athens");
		receiptTest.setCompanyStreet("Peramatos");
		receiptTest.setCompanyNumber("10");
		receiptParser=new ReceiptParserXML();
		receiptParser.setFileToAppend(mockFile);
		receiptParser.modifyReceipt(receiptTest);
	}



	@Test
	public void testAppendFile() {
		assertDoesNotThrow( ()->{
			receiptParser.appendFile();
		});
	}
}
