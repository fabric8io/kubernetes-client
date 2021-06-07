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

import io.fabric8.kubernetes.client.utils.Utils;

public interface OperationInfo {

  String getKind();

  String getName();

  String getNamespace();

  String getOperationType();

  OperationInfo forOperationType(String type);
  
  default String describe() {
    StringBuilder sb = new StringBuilder();
    sb.append("Operation");
    final String type = getOperationType();
    if (Utils.isNotNullOrEmpty(type)) {
      sb.append(": [").append(type).append("]");
    }
    sb.append(" for kind: [").append(getKind()).append("]");
    final String name = getName();
    if (Utils.isNotNullOrEmpty(name)) {
      sb.append(" with name: [").append(name).append("]");
    }
    sb.append(" in namespace: [").append(getNamespace()).append("]");
    return sb.toString();
  }
}
