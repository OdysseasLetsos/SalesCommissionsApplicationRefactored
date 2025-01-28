package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SalesmanTest {
	Salesman salesmanTest;
	
	@BeforeEach
	void setUp() throws Exception {
		salesmanTest=new Salesman();
		salesmanTest.setName("Odysseas Letsos");
		salesmanTest.setAfm("1234567890");
		
		Receipt receipt1=new Receipt();
		receipt1.receiptId=1;
		receipt1.date="11/12/2023";
		receipt1.sales=40000.0;
		receipt1.items=10;
		receipt1.kind="Trousers";
		receipt1.setCompanyName("ADIDAS");;
		receipt1.setCompanyCountry("GREECE");
		receipt1.setCompanyCity("Athens");
		receipt1.setCompanyStreet("Peramatos");
		receipt1.setCompanyNumber("10");
		
		Receipt receipt2=new Receipt();
		receipt2.receiptId=2;
		receipt2.date="11/12/2023";
		receipt2.sales=10000.0;
		receipt2.items=50;
		receipt2.kind="Shirts";
		receipt2.setCompanyName("ADIDAS");;
		receipt2.setCompanyCountry("GREECE");
		receipt2.setCompanyCity("Athens");
		receipt2.setCompanyStreet("Peramatos");
		receipt2.setCompanyNumber("10");
		
		salesmanTest.getReceipts().add(receipt1);
		salesmanTest.getReceipts().add(receipt2);
		
	}//test for two receipts



	@Test
	void testCalculateTotalSales() {
		assertEquals(50000.0, salesmanTest.calculateTotalSales());
	}
	@Test
	void testCalculateCommission() {
		assertEquals(7500.0,salesmanTest.calculateCommission());
	}
	@Test
	void testCalculateTrouserSales() {
        assertEquals(10, salesmanTest.calculateTrouserSales());
    }
	
	@Test
	void testCalculateShirtsSales() {
        assertEquals(50, salesmanTest.calculateShirtsSales());
    }
	
}
