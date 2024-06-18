package io.fabric8.openshift.client.dsl.internal.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class ExpressionValueGenerator {
  private static final String Alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String Numerals = "0123456789";
  private static final String Symbols = "~!@#$%^&*()-_+={}[]\\|<,>.?/\"';:`";
  private static final String ASCII = Alphabet + Numerals + Symbols;

  private static final Pattern rangeExp = Pattern.compile("([\\\\]?[a-zA-Z0-9]\\-?[a-zA-Z0-9]?)");
  private static final Pattern generatorsExp = Pattern.compile("\\[([a-zA-Z0-9\\-\\\\]+)\\](\\{([0-9]+)\\})");
  private static final Pattern expressionExp = Pattern.compile("\\[(\\\\w|\\\\d|\\\\a|\\\\A)|([a-zA-Z0-9]\\-[a-zA-Z0-9])+\\]");

  private final Random random;

  public ExpressionValueGenerator(Random random) {
    this.random = random;
  }

  public String generateValue(final String expression) {
    String result = expression;
    Matcher matcher = generatorsExp.matcher(result);
    while (matcher.find()) {
      String matched = result.substring(matcher.start(), matcher.end());
      String[] rangeAndLength = rangesAndLength(matched);
      String ranges = rangeAndLength[0];
      int length = Integer.parseInt(rangeAndLength[1]);

      result = replaceWithGenerated(
        result,
        matched,
        findExpressionPos(ranges),
        length,
        random
      );
      matcher = generatorsExp.matcher(result);
    }
    return result;
  }

  private static String alphabetSlice(char from, char to) {
    int leftPos = ASCII.indexOf(from);
    int rightPos = ASCII.lastIndexOf(to) + 1;
    if (leftPos > rightPos) {
      throw new IllegalArgumentException("invalid range specified: " + from + "-" + to);
    }
    return ASCII.substring(leftPos, rightPos);
  }

  private static String replaceWithGenerated(String s, String expression, List<byte[]> ranges, int length, Random random) {
    StringBuilder alphabet = new StringBuilder();
    for (byte[] r : ranges) {
      String rangeStr = new String(r);
      switch (rangeStr) {
        case "\\w":
          alphabet.append(Alphabet).append(Numerals).append("_");
          break;
        case "\\d":
          alphabet.append(Numerals);
          break;
        case "\\a":
          alphabet.append(Alphabet).append(Numerals);
          break;
        case "\\A":
          alphabet.append(Symbols);
          break;
        default:
          alphabet.append(alphabetSlice((char) r[0], (char) r[1]));
          break;
      }
    }
    String alphabetStr = removeDuplicateChars(alphabet.toString());
    StringBuilder result = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      result.append(alphabetStr.charAt(random.nextInt(alphabetStr.length())));
    }
    return s.replace(expression, result.toString());
  }

  private static String removeDuplicateChars(String input) {
    return input.chars()
      .distinct()
      .mapToObj(c -> String.valueOf((char) c))
      .collect(Collectors.joining());
  }

  private static List<byte[]> findExpressionPos(String s) {
    Matcher matcher = rangeExp.matcher(s);
    List<byte[]> result = new ArrayList<>();
    while (matcher.find()) {
      result.add(new byte[]{(byte) s.charAt(matcher.start()), (byte) s.charAt(matcher.end() - 1)});
    }
    return result;
  }

  private static String[] rangesAndLength(String s) {
    int lastOpenCurly = s.lastIndexOf("{");
    String expr = s.substring(0, lastOpenCurly);
    if (!expressionExp.matcher(expr).find()) {
      throw new IllegalArgumentException("malformed expresion syntax: " + expr);
    }
    String lengthStr = s.substring(lastOpenCurly + 1, s.length() - 1);
    int length = Integer.parseInt(lengthStr);
    if (length > 0 && length <= 255) {
      return new String[]{expr, lengthStr};
    }
    throw new IllegalArgumentException("range must be within [1-255] characters (" + length + ")");
  }

}
