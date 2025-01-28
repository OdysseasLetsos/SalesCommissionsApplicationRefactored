package output;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import data.Receipt;

public class ReceiptParserTXTTest {
	Receipt receiptTest;
	String filePath;
	File mockFile;
	ReceiptParser receiptParser;
	
	@Before
	public void setUp() throws Exception {
		receiptTest=new Receipt();
		receiptTest.setReceiptID(1);
		receiptTest.setDate("11/12/2023");
		receiptTest.setSales(40000.0);
		receiptTest.setItems(10);
		receiptTest.setKind("Trousers");
		receiptTest.setCompanyName("ADIDAS");;
		receiptTest.setCompanyCountry("GREECE");
		receiptTest.setCompanyCity("Athens");
		receiptTest.setCompanyStreet("Peramatos");
		receiptTest.setCompanyNumber("10");
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-1-TXT.txt";
		mockFile=new File(filePath);
		receiptParser=new ReceiptParserTXT();
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
