package io.fabric8.crd.generator.apt;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClassPathUtils {
  private ClassPathUtils() {
  }

  public static List<String> getClassPaths() {
    return Arrays.asList(getProperty("java.class.path")
        .split(getProperty("path.separator")));
  }

  public static List<String> getClassPathsAndReplace(String identifyingClassPathEnding, String appendingPath) {
    return getClassPaths().stream()
        .map(s -> s.endsWith(identifyingClassPathEnding) ? s + "/" + appendingPath : s)
        .collect(Collectors.toList());
  }

  private static String getProperty(String key) {
    return Optional.ofNullable(System.getProperty(key))
        .orElseThrow(() -> new RuntimeException("Could not find system property: " + key));
  }
}
