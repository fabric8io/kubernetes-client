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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.client.OperationInfo;

public class DefaultOperationInfo implements OperationInfo {

  private final String kind;
  private final String operationType;
  private final String name;
  private final String namespace;

  public DefaultOperationInfo(String kind, String operationType, String name, String namespace) {
    this.kind = kind;
    this.name = name;
    this.namespace = namespace;
    this.operationType = operationType;
  }


  @Override
  public String getKind() {
    return kind;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }

  @Override
  public String getOperationType() {
    return operationType;
  }

  @Override
  public OperationInfo forOperationType(String type) {
    return new DefaultOperationInfo(kind, type, name, namespace);
  }
}
