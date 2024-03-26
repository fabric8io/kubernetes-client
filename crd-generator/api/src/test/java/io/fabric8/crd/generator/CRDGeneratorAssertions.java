package io.fabric8.crd.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CRDGeneratorAssertions {

  private CRDGeneratorAssertions(){
  }

  /**
   * Compares two YAML files and fails if they are not equal.
   * Comments and empty lines are ignored.
   *
   * @param expectedFile the file which contains the expected content
   * @param actualFile the file which contains the content to test
   */
  public static void assertFileEquals(final File expectedFile, final File actualFile) {
    try (final BufferedReader expectedReader = new BufferedReader(new FileReader(expectedFile));
         final BufferedReader actualReader = new BufferedReader(new FileReader(actualFile))) {
      // skip license headers
      String expectedLine = skipCommentsAndEmptyLines(expectedReader);
      String actualLine = skipCommentsAndEmptyLines(actualReader);
      // compare both files
      final String message = String.format("Expected %s and actual %s files are not equal", expectedFile, actualFile);
      while (expectedLine != null || actualLine != null) {
        assertEquals(expectedLine, actualLine, message);
        expectedLine = expectedReader.readLine();
        actualLine = actualReader.readLine();
      }
    } catch (final IOException e) {
      fail(String.format("Cannot compare files %s and %s: %s", expectedFile, actualFile, e.getMessage()));
    }
  }

  private static String skipCommentsAndEmptyLines(final BufferedReader reader) throws IOException {
    String line = reader.readLine();
    while (line.startsWith("#") || line.isEmpty()) {
      line = reader.readLine();
    }
    return line;
  }

}
