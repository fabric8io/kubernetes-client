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

import io.fabric8.kubernetes.api.model.DoneableNamespace;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.ClientResource;

public class NamespaceOperationsImpl<C extends Client>  extends HasMetadataOperation<C, Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> {

  public NamespaceOperationsImpl(C client) {
    this(client, null, null, true, null);
  }

  public NamespaceOperationsImpl(C client, String namespace, String name, Boolean cascading, Namespace item) {
    super(client, "namespaces", namespace, name, cascading, item);
  }
}
