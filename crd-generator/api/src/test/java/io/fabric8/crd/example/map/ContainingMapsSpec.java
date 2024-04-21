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
package io.fabric8.crd.example.map;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ContainingMapsSpec {

  private Map<String, List<String>> test = null;

  public Map<String, List<String>> getTest() {
    return test;
  }

  private Map<String, Map<String, List<Boolean>>> test2 = null;

  public Map<String, Map<String, List<Boolean>>> getTest2() {
    return test2;
  }

  private MultiHashMap<String, Integer> stringToIntMultiMap1;
  private MultiMap<String, Integer> stringToIntMultiMap2;
  private SwappedParametersMap<List<Integer>, String> stringToIntMultiMap3;
  private RedundantParametersMap<Object, Runnable, String, List<Integer>> stringToIntMultiMap4;
  private RedundantParametersStringToIntMultiMap<Integer, Long> stringToIntMultiMap5;
  private StringKeyedMultiHashMap<Integer> stringToIntMultiMap6;
  private IntValuedMultiMap<String> stringToIntMultiMap7;

  static class MultiHashMap<K, V> extends HashMap<K, List<V>> {
  }

  interface MultiMap<K, V> extends Map<K, List<V>> {
  }

  interface SwappedParametersMap<V, K> extends Map<K, V> {
  }

  interface RedundantParametersMap<A, B, K, V> extends Map<K, V> {
  }

  interface RedundantParametersStringToIntMultiMap<K, V> extends Map<String, List<Integer>> {
  }

  static class StringKeyedMultiHashMap<V> extends MultiHashMap<String, V> {
  }

  interface IntValuedMultiMap<K> extends MultiMap<K, Integer> {
  }
}
