package input;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTestHTML {
	String filePath;
	File mockFile;
	HTMLInput inputTest;
	
	@BeforeEach
	void setUp() throws Exception {
		filePath="C:\\Users\\Οδυσσέας Λέτσος\\Desktop\\";
		mockFile=new File(filePath);
		inputTest=new HTMLInput(mockFile);
	}

	@Test
	public void testReadFileHTML() {
		assertDoesNotThrow( ()->{
			inputTest.readFile();
		});
		
	}

}
