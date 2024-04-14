/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.java.generator.cli;

import picocli.CommandLine;

import java.util.*;

/*
* Convert CLI parameters such as: -O key=value-1 -O key=value-2
* To a map of the form: {key=[value-1, value-2]}
* */
class MapOfStringToListOfStringParameterConsumer implements CommandLine.IParameterConsumer {
  public void consumeParameters(Stack<String> args, CommandLine.Model.ArgSpec argSpec,
      CommandLine.Model.CommandSpec commandSpec) {
    Map<String, List<String>> map = argSpec.getValue();
    if (null == map) {
      argSpec.setValue(map = new HashMap<>());
    }
    String[] fields = args.pop().split("=");
    map.computeIfAbsent(fields[0], __ -> new ArrayList<>()).add(fields[1]);
  }
}
