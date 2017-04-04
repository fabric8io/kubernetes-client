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
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;

import java.util.Map;

public interface Filterable<T> {

  T withLabels(Map<String, String> labels);

  T withoutLabels(Map<String, String> labels);

  T withLabelIn(String key, String ... values);

  T withLabelNotIn(String key, String ... values);

  T withLabel(String key, String value);

  T withLabel(String key);

  T withoutLabel(String key, String value);

  T withoutLabel(String key);

  T withFields(Map<String, String> labels);

  T withField(String key, String value);

  T withLabelSelector(LabelSelector selector);
}

