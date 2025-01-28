package input;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.io.File;
import org.junit.Before;
import org.junit.Test;

public class InputTestTXT {
	String filePath;
	File mockFile;
	TXTInput inputTest;
	
	@Before
	public void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\eclipse-workspace\\soft-devII-2024-project-material\\test_input_files\\test-case-1-TXT.txt";
		mockFile=new File(filePath);
		inputTest=new TXTInput(mockFile);
	
	}

	@Test
	public void testReadFileTXT() {
		assertDoesNotThrow( ()->{
			inputTest.readFile();
		});
		
	}

}

