package io.fabric8.openshift.client.dsl.internal.core;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionValueGeneratorTest {

  static class ExpressionValuesArgumentsProvider implements ArgumentsProvider {
    public ExpressionValuesArgumentsProvider() {}

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
      return Stream.of(
        Arguments.of("test[0-9]{1}x", "test6x"),
        Arguments.of("[0-1]{8}", "00011001"),
        Arguments.of("0x[A-F0-9]{4}", "0x8DEE"),
        Arguments.of("[a-zA-Z0-9]{8}", "aJ46KXFq"),
        Arguments.of("test[A-Z0-9]{4}template", "testQ3HVtemplate"),
        Arguments.of("[\\d]{3}", "889"),
        Arguments.of("[\\w]{20}", "hiG4uRbcUDd5PEJLyHZ7"),
        Arguments.of("[\\a]{10}", "4U390O49B9"),
        Arguments.of("[\\A]{10}", ")^&-|_:[><"),
        Arguments.of("strongPassword[\\w]{3}[\\A]{3}", "strongPasswordhiG-|_"),
        Arguments.of("admin[0-9]{2}[A-Z]{2}", "admin78YB"),
        Arguments.of("admin[0-9]{2}test[A-Z]{2}", "admin78testYB")
      );
    }
  }

  @ParameterizedTest
  @ArgumentsSource(ExpressionValuesArgumentsProvider.class)
  void generateStringFromRegEx(String input, String expected) {
    // Arrange
    Random random = new Random();
    random.setSeed(1337);
    ExpressionValueGenerator generator = new ExpressionValueGenerator(random);

    // Act
    String result = generator.generateValue(input);

    // Assert
    assertEquals(expected, result);
  }
}
