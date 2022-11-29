/**
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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectReference;

import java.util.Map;

/**
 * Each filter method applies in an additive way to the previous filter state.
 * 
 * @param <T>
 */
public interface Filterable<T> {

  T withLabels(Map<String, String> labels);

  /**
   * @deprecated as the underlying implementation does not align with the arguments anymore.
   *             It is possible to negate multiple values with the same key, e.g.:
   *             foo != bar , foo != baz
   *             To support this a multi-value map is needed, as a regular map would override the key with the new value.
   */
  @Deprecated
  T withoutLabels(Map<String, String> labels);

  T withLabelIn(String key, String... values);

  T withLabelNotIn(String key, String... values);

  T withLabel(String key, String value);

  default T withLabel(String key) {
    return withLabel(key, null);
  }

  T withoutLabel(String key, String value);

  default T withoutLabel(String key) {
    return withoutLabel(key, null);
  }

  T withFields(Map<String, String> fields);

  T withField(String key, String value);

  /**
   * @deprecated as the underlying implementation does not align with the arguments fully.
   *             Method is created to have a similar API as `withoutLabels`, but should eventually be replaced
   *             with something better for the same reasons.
   *             It is possible to negate multiple values with the same key, e.g.:
   *             foo != bar , foo != baz
   *             To support this a multi-value map is needed, as a regular map would override the key with the new value.
   */
  @Deprecated
  T withoutFields(Map<String, String> fields);

  T withoutField(String key, String value);

  T withLabelSelector(LabelSelector selector);

  T withLabelSelector(String selectorAsString);

  /**
   * Filter with the object that this event is about.
   * 
   * @param objectReference {@link ObjectReference} for providing information of referred object
   * @return filtered resource
   */
  T withInvolvedObject(ObjectReference objectReference);
}
