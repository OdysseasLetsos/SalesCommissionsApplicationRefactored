package data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {
	private  Receipt receiptTest;
	
	@Before
	public void setUp() throws Exception {
		receiptTest=new Receipt();
		receiptTest.setSales(1000);
	}

	
	@Test
	public void testGetSales() {
		assertTrue(false);
	}

}
