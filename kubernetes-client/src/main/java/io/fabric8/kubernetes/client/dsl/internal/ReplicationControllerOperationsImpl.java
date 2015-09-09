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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.kubernetes.client.dsl.ImageEditReplaceable;
import io.fabric8.kubernetes.client.dsl.RollableScallableClientResource;
import io.fabric8.kubernetes.client.dsl.Scaleable;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

public class ReplicationControllerOperationsImpl extends HasMetadataOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, RollableScallableClientResource<ReplicationController, DoneableReplicationController>, CreateFromLoadable<ReplicationController, DoneableReplicationController>>
  implements RollableScallableClientResource<ReplicationController, DoneableReplicationController>,
  ImageEditReplaceable<ReplicationController, ReplicationController, DoneableReplicationController> {

  private final Boolean rolling;

  public ReplicationControllerOperationsImpl(KubernetesClient client) {
    this(client, null, null, true, null, false);
  }


  public ReplicationControllerOperationsImpl(KubernetesClient client, String namespace, String name, Boolean cascading, ReplicationController item, Boolean rolling) {
    super(client, "replicationcontrollers", namespace, name, cascading, item);
    this.rolling = rolling;
  }

  @Override
  public ReplicationController scale(int count) {
    return scale(count, false);
  }

  @Override
  public ReplicationController scale(int count, boolean wait) {
    ReplicationController res = edit().editSpec().withReplicas(count).endSpec().done();
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
  public ReplicationControllerOperationsImpl rolling() {
    return new ReplicationControllerOperationsImpl(getClient(), getNamespace(), getName(), isCascading(), getItem(), true);
  }


  @Override
  public ReplicationController updateImage(String image) {
    ReplicationController oldRC = get();

    if (oldRC == null) {
      throw new KubernetesClientException("Existing replication controller doesn't exist");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() > 1) {
      throw new KubernetesClientException("Image update is not supported for multicontainer pods");
    }
    if (oldRC.getSpec().getTemplate().getSpec().getContainers().size() == 0) {
      throw new KubernetesClientException("Pod has no containers!");
    }

    Container updatedContainer = new ContainerBuilder(oldRC.getSpec().getTemplate().getSpec().getContainers().iterator().next()).withImage(image).build();

    ReplicationControllerBuilder newRCBuilder = new ReplicationControllerBuilder(oldRC);
    newRCBuilder.editMetadata().withResourceVersion(null).endMetadata()
      .editSpec().editTemplate().editSpec().withContainers(Collections.singletonList(updatedContainer))
      .endSpec().endTemplate().endSpec();

    return new RollingUpdater(getClient()).rollUpdate(oldRC, newRCBuilder.build());
  }

  @Override
  public DoneableReplicationController edit() {
    if (!rolling) {
      return super.edit();
    }

    final Visitor<ReplicationController> visitor = new Visitor<ReplicationController>() {
      @Override
      public void visit(ReplicationController rc) {
        try {
          new RollingUpdater(getClient()).rollUpdate(get(), rc);
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

  @Override
  public ReplicationController replace(ReplicationController rc) {
    if (!rolling) {
      return super.replace(rc);
    }
    return new RollingUpdater(getClient()).rollUpdate(get(), rc);
  }

  @Override
  public ReplicationController update(ReplicationController item) {
    return replace(item);
  }
}
