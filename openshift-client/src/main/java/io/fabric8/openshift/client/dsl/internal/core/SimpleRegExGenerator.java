package io.fabric8.openshift.client.dsl.internal.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleRegExGenerator {

  // TODO: missing escapes and special characters handling
  // https://docs.openshift.com/container-platform/4.15/openshift_images/using-templates.html#templates-writing-parameters_using-templates
public static String expandRegExp(String in, Random random) {
  final StringBuilder result = new StringBuilder(in.length() * 2);
  boolean inRange = false;
  boolean rangeStart = false;
  boolean rangeEnd = false;
  CharRange.Builder rangeBuilder = null;
  boolean inLength = false;
  final List<CharRange> ranges = new ArrayList<>();
  final StringBuilder length = new StringBuilder(3);

  for (int i = 0; i < in.length(); i++) {
    char character = in.charAt(i);
    switch (character) {
      case '[':
      {
        inRange = true;
        rangeStart = true;
        rangeEnd = false;
        rangeBuilder = CharRange.builder();
        inLength = false;
        break;
      }
      case ']':
      {
        if (!inRange) {
          throw new IllegalArgumentException("Malformed regular expression detected");
        }
        // check that lenght is following
        char nextChar = in.charAt(++i);
        if (nextChar != '{') {
          throw new IllegalArgumentException("Regular Expression should be followed by the length");
        }
        inRange = false;
        inLength = true;
        break;
      }
      case '}':
      {
        if (!inLength) {
          throw new IllegalArgumentException("Mismatched closing length token");
        }
        inRange = false;
        inLength = false;
        result.append(generateExpression(ranges, length.toString(), random));
        ranges.clear();
        length.setLength(0);
        break;
      }
      case '-':
      {
        if (inRange && !rangeStart) {
          rangeEnd = true;
        } else {
          // Allowing for dash in the external string
          result.append(character);
        }
        break;
      }
      default:
      {
        if (inRange) {
          if (rangeStart) {
            rangeBuilder.withStart(character);
            rangeStart = false;
          } else if (rangeEnd) {
            rangeBuilder.withEnd(character);
            ranges.add(rangeBuilder.build());
            rangeBuilder = CharRange.builder();
            rangeEnd = false;
            rangeStart = true;
          } else {
            throw new IllegalArgumentException("Failed to parse range");
          }
        } else if (inLength) {
          length.append(character);
        } else {
          result.append(character);
        }
      }
    }
  }
  return result.toString();
}

  private static String generateExpression(List<CharRange> ranges, String length, Random random) {
    int resultLen = Integer.valueOf(length);
    StringBuilder result = new StringBuilder(resultLen);
    for (int i = 0; i < resultLen; i++) {
      int rangeIdx = random.nextInt(ranges.size());
      CharRange range = ranges.get(rangeIdx);
      char value = (char) (random.nextInt(range.end() - range.start() + 1) + range.start());
      result.append(value);
    }
    return result.toString();
  }

}
