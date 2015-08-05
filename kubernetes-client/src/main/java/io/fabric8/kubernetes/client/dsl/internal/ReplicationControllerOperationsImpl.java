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

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ReplicationControllerClientResource;
import io.fabric8.kubernetes.client.dsl.Scaleable;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public class ReplicationControllerOperationsImpl extends HasMetadataOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ReplicationControllerClientResource<ReplicationController, DoneableReplicationController>>
  implements ReplicationControllerClientResource<ReplicationController, DoneableReplicationController> {

  public ReplicationControllerOperationsImpl(KubernetesClient client) {
    super(client, "replicationcontrollers", null, null);
  }

  public ReplicationControllerOperationsImpl(KubernetesClient client, String namespace, String name) {
    super(client, "replicationcontrollers", namespace, name);
  }

  @Override
  public void scale(int count) {
    scale(count, false);
  }

  @Override
  public void scale(int count, boolean wait) {
    edit(false).editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      while (get().getStatus().getReplicas() != count) {
        try {
          Thread.sleep(Scaleable.POLL_INTERVAL_MS);
        } catch (InterruptedException e) {
          throw new KubernetesClientException("Interrupted sleep", e);
        }
      }
    }
  }

  @Override
  public ReplicationController rollImageUpdate(String newRCName, String image) {
    ReplicationController oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing replication controller doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multi-container pods");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() == 0) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container updatedContainer = new ContainerBuilder(oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next()).withImage(image).build();

    ReplicationControllerBuilder newRCBuilder = new ReplicationControllerBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    if (newRCName != null) {
      newRCBuilder.editMetadata().withName(newRCName).endMetadata();
    }

    return new RollingUpdater(getClient()).rollUpdate(oldRC, newRCBuilder.build());
  }

  @Override
  public ReplicationController rollImageUpdate(String image) {
    return rollImageUpdate(null, image);
  }

  @Override
  public DoneableReplicationController editForRollingUpdate() {
    final Visitor<ReplicationController> visitor = new Visitor<ReplicationController>() {
      @Override
      public void visit(ReplicationController resource) {
        try {
          new RollingUpdater(getClient()).rollUpdate(get(), resource);
        } catch (Exception e) {
          throw KubernetesClientException.launderThrowable(e);
        }
      }
    };

    try {
      return getDoneableType().getDeclaredConstructor(getType(), Visitor.class).newInstance(get(), visitor);
    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
}
