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
package io.fabric8.zjsonpatch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is ported from <a href=
 * "https://github.com/flipkart-incubator/zjsonpatch/blob/a446bf598231c06006d4e3df69b846cdb16d8889/src/main/java/com/flipkart/zjsonpatch/Operation.java">FlipKart
 * zjsonpatch repository</a>
 */
public enum Operation {
  ADD("add"),
  REMOVE("remove"),
  REPLACE("replace"),
  MOVE("move"),
  COPY("copy"),
  TEST("test");

  private final static Map<String, Operation> OPS = createImmutableMap();

  private static Map<String, Operation> createImmutableMap() {
    Map<String, Operation> map = new HashMap<>();
    map.put(ADD.rfcName, ADD);
    map.put(REMOVE.rfcName, REMOVE);
    map.put(REPLACE.rfcName, REPLACE);
    map.put(MOVE.rfcName, MOVE);
    map.put(COPY.rfcName, COPY);
    map.put(TEST.rfcName, TEST);
    return Collections.unmodifiableMap(map);
  }

  private final String rfcName;

  Operation(String rfcName) {
    this.rfcName = rfcName;
  }

  public static Operation fromRfcName(String rfcName) {
    if (rfcName == null) {
      throw new JsonPatchException("rfcName cannot be null");
    }
    Operation op = OPS.get(rfcName.toLowerCase());
    if (op == null) {
      throw new JsonPatchException("unknown / unsupported operation " + rfcName);
    }
    return op;
  }

  public String rfcName() {
    return this.rfcName;
  }

}
