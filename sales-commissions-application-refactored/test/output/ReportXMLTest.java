package output;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import input.HTMLInput;

class ReportXMLTest {

	private String fullpathName="C:\\Users\\Οδυσσέας Λέτσος\\Desktop";
	String filePath;
	File mockFile;
	HTMLInput inputTest;
	HTMLReportSaver htmlReportSaver;
	
	@BeforeEach
	void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-HTML.html";
		mockFile=new File(filePath);
		inputTest=new HTMLInput(mockFile);
		inputTest.readFile();
		
		htmlReportSaver=new HTMLReportSaver(inputTest.getAgent());
	}


	@Test
	public void testSaveFile() {
		assertDoesNotThrow( ()->{
			htmlReportSaver.saveFile(fullpathName);
			
		});	
	}
}
