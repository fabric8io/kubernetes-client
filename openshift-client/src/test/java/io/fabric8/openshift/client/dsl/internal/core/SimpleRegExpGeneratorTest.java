package io.fabric8.openshift.client.dsl.internal.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleRegExpGeneratorTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/regex_generator.csv", numLinesToSkip = 1)
  void generateStringFromRegEx(String input, String expected) {
    // Arrange
    Random random = new Random();
    random.setSeed(1);

    // Act
    String result = SimpleRegExGenerator.expandRegExp(input, random);

    // Assert
    assertEquals(expected, result);
  }
}
