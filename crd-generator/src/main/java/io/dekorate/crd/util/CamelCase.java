/**
 * Copyright 2018 The original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dekorate.crd.util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CamelCase  {

  public static final String CAMEL_CASE_PATTERN = "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";

  public static final Function<String, List<String>> SPLIT = s -> Arrays.asList(s.split(CAMEL_CASE_PATTERN));
  public static final Function<List<String>, String> DASH_JOIN = l -> String.join(",", l);
  public static final Function<String, String> TO_DASH_SEPARATED = SPLIT.andThen(DASH_JOIN);
  public static final Function<String, String> TO_SHORTNAME = SPLIT.andThen(l -> l.stream().map(s -> s.substring(0, 1)).collect(Collectors.joining())).andThen(String::toLowerCase);
}
