package input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTestXML {
	String filePath;
	File mockFile;
	XMLInput inputTest;
	
	@BeforeEach
	void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-2-XML.xml";
		mockFile=new File(filePath);
		inputTest=new XMLInput(mockFile);
	}

	@Test
	public void testReadFileXML() {
		assertDoesNotThrow( ()->{
			inputTest.readFile();
		});
		
	}

}
