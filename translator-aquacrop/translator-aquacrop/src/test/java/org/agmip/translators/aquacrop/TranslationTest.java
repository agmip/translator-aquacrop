package org.agmip.translators.aquacrop;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.agmip.util.JSONAdapter;

/**
 * Unit test for simple App.
 */
public class TranslationTest extends TestCase {

	private Map inputMap;

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public TranslationTest(String testName) {
		super(testName);

		try {
			File f = new File("src/test/resources/ufga8201_mzx.json");
			List<String> lines = Files.readAllLines(f.toPath(), Charset.forName("UTF-8"));

			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				sb.append(line);
			}
			inputMap = JSONAdapter.fromJSON(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TranslationTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testTranslation() {
		ClimateTranslatorOutput t = new ClimateTranslatorOutput();

		try {
			File tempFile = File.createTempFile("tmp_agmip_aquacrop_climate", ".txt");
			t.writeFile(tempFile.getAbsolutePath(), inputMap);
			
			// TODO: Add real tests!!!
			
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}