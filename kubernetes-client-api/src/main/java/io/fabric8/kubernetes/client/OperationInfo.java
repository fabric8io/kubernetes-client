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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface OperationInfo {

  String getKind();

  String getName();

  String getNamespace();

  String getOperationType();

  OperationInfo forOperationType(String type);

  default String getGroup() {
    return null;
  }

  default String getPlural() {
    return null;
  }

  default String getVersion() {
    return null;
  }

  default String getFullResourceName() {
    final String plural = getPlural();
    final String group = getGroup();
    if (plural != null && group != null) {
      return HasMetadata.getFullResourceName(plural, group);
    }
    return null;
  }
}
