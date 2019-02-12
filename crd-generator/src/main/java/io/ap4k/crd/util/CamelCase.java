package io.ap4k.crd.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CamelCase  {

  public static final String CAMEL_CASE_PATTERN = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";

  public static final Function<String, List<String>> SPLIT = s -> Arrays.asList(s.split(CAMEL_CASE_PATTERN));
  public static final Function<List<String>, String> DASH_JOIN = l -> l.stream().collect(Collectors.joining(","));
  public static final Function<String, String> TO_DASH_SEPARATED = SPLIT.andThen(DASH_JOIN);
  public static final Function<String, String> TO_SHORTNAME = SPLIT.andThen(l -> l.stream().map(s -> s.substring(0, 1)).collect(Collectors.joining())).andThen(String::toLowerCase);
}
