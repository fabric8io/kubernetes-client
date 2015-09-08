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

import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.kubernetes.client.dsl.ReplicationControllerClientResource;
import io.fabric8.kubernetes.client.dsl.Scaleable;

public class ReplicationControllerOperationsImpl extends HasMetadataOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ReplicationControllerClientResource<ReplicationController, DoneableReplicationController>, CreateFromLoadable<ReplicationController, DoneableReplicationController>>
  implements ReplicationControllerClientResource<ReplicationController, DoneableReplicationController> {

  public ReplicationControllerOperationsImpl(KubernetesClient client) {
    super(client, "replicationcontrollers", null, (String) null);
  }

  public ReplicationControllerOperationsImpl(KubernetesClient client, String namespace, String name) {
    super(client, "replicationcontrollers", namespace, name);
  }

  public ReplicationControllerOperationsImpl(KubernetesClient client, String namespace, ReplicationController o) {
    super(client, "replicationcontrollers", namespace, o);
  }

  @Override
  public ReplicationController scale(int count) {
    return scale(count, false);
  }

  @Override
  public ReplicationController scale(int count, boolean wait) {
    ReplicationController res = edit(false).editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      res = get();
      while (res.getStatus().getReplicas() != count) {
        try {
          Thread.sleep(Scaleable.POLL_INTERVAL_MS);
          res = get();
        } catch (InterruptedException e) {
          throw new KubernetesClientException("Interrupted sleep", e);
        }
      }
    }
    return res;
  }

  @Override
  public RollingOperation rolling() {
    return new RollingOperation(getClient(), getNamespace(), getName());
  }
}
