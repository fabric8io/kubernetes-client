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

package io.fabric8.crdv2.generator;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface KubernetesJSONSchemaProps {

  String getType();

  String getFormat();

  String getDescription();

  void setXKubernetesPreserveUnknownFields(Boolean b);

  void setMaximum(Double max);

  void setExclusiveMaximum(Boolean b);

  void setMinimum(Double min);

  void setExclusiveMinimum(Boolean b);

  void setMinLength(Long min);

  void setMaxLength(Long max);

  void setMinItems(Long min);

  void setMaxItems(Long max);

  void setMinProperties(Long min);

  void setMaxProperties(Long max);

  void setPattern(String pattern);

  void setFormat(String format);

  void setNullable(Boolean nullable);

  void setDefault(JsonNode tree);

  void setDescription(String description);

  void setRequired(List<String> required);

}
