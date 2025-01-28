package output;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import input.XMLInput;

class ReportHTMLTest {
	private String fullpathName="C:\\Users\\Οδυσσέας Λέτσος\\Desktop";
	String filePath;
	File mockFile;
	XMLInput inputTest;
	XMLReportSaver xmlReportSaver;
	
	@Before
	void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-2-XML.xml";
		mockFile=new File(filePath);
		inputTest=new XMLInput(mockFile);
		inputTest.readFile();
		
		xmlReportSaver=new XMLReportSaver(inputTest.getAgent());
	}


	@Test
	public void testSaveFile() {
		assertDoesNotThrow( ()->{
			xmlReportSaver.saveFile(fullpathName);
			
		});	
	}

}
