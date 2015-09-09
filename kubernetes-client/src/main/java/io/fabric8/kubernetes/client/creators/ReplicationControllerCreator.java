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
package io.fabric8.kubernetes.client.creators;

import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.ResourceCreator;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;

public class ReplicationControllerCreator implements ResourceCreator<ReplicationController> {
  @Override
  public Class<ReplicationController> getKind() {
    return ReplicationController.class;
  }

  @Override
  public ReplicationController create(KubernetesClient client, String namespace, ReplicationController item) {
    return new ReplicationControllerOperationsImpl(client, namespace, null, true, item, false).create();
  }
}
