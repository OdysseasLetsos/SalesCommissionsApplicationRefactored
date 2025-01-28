package output;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Before;
import org.junit.Test;

import data.Receipt;
import data.Salesman;

public class ReportTXTTest {
	private Salesman salesman;
	private String fullpathName="C:\\Users\\Οδυσσέας Λέτσος\\Desktop";
	TXTReportSaver txtReport;
	@Before
	public void setUp() throws Exception {
		salesman=new Salesman();
		salesman.setName("Odysseas Letsos");
		salesman.setAfm("1234567890");
		Receipt receiptTest=new Receipt();
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
		salesman.getReceipts().add(receiptTest);
		System.out.println(salesman.calculateCoatsSales());
		txtReport=new TXTReportSaver(salesman);
		
	}

	@Test
	public void testSaveFile() {
		assertDoesNotThrow( ()->{
			txtReport.saveFile(fullpathName);
		});		
	}

}
