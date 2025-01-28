package input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {
	String filePath;
	File mockFile;
	TXTInput inputTest;
	
	@BeforeEach
	void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-1-TXT.txt";
		mockFile=new File(filePath);
		inputTest=new TXTInput(mockFile);
		inputTest.readFile();
		
	}
	
	//auto xrhsimopoieitai sthn inputwindow
	@Test
	void testGetAgent() {
		assertEquals("Apostolos Zarras", inputTest.getAgent().getName());
	}

}
