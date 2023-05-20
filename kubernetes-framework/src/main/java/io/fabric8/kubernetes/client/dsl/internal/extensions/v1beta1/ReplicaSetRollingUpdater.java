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
package io.fabric8.kubernetes.client.dsl.internal.extensions.v1beta1;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.PodResource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.RollingUpdater;

class ReplicaSetRollingUpdater extends RollingUpdater<ReplicaSet, ReplicaSetList> {

  ReplicaSetRollingUpdater(Client client, String namespace, long rollingTimeoutMillis, long loggingIntervalMillis) {
    super(client, namespace, rollingTimeoutMillis, loggingIntervalMillis);
  }

  @Override
  protected ReplicaSet createClone(ReplicaSet obj, String newName, String newDeploymentHash) {
    return new ReplicaSetBuilder(obj)
        .editMetadata()
        .withResourceVersion(null)
        .withName(newName)
        .endMetadata()
        .editSpec()
        .withReplicas(0)
        .editSelector().addToMatchLabels(DEPLOYMENT_KEY, newDeploymentHash).endSelector()
        .editTemplate().editMetadata().addToLabels(DEPLOYMENT_KEY, newDeploymentHash).endMetadata().endTemplate()
        .endSpec()
        .build();
  }

  @Override
  protected FilterWatchListDeletable<Pod, PodList, PodResource> selectedPodLister(ReplicaSet obj) {
    return selectedPodLister(obj.getSpec().getSelector());
  }

  @Override
  protected ReplicaSet updateDeploymentKey(String name, String hash) {
    return resources().inNamespace(namespace).withName(name).edit(r -> new ReplicaSetBuilder(r)
        .editSpec()
        .editSelector().addToMatchLabels(DEPLOYMENT_KEY, hash).endSelector()
        .editTemplate().editMetadata().addToLabels(DEPLOYMENT_KEY, hash).endMetadata().endTemplate()
        .endSpec()
        .build());
  }

  @Override
  protected ReplicaSet removeDeploymentKey(String name) {
    return resources().inNamespace(namespace).withName(name).edit(r -> new ReplicaSetBuilder(r)
        .editSpec()
        .editSelector().removeFromMatchLabels(DEPLOYMENT_KEY).endSelector()
        .editTemplate().editMetadata().removeFromLabels(DEPLOYMENT_KEY).endMetadata().endTemplate()
        .endSpec()
        .build());
  }

  @Override
  protected int getReplicas(ReplicaSet obj) {
    return obj.getSpec().getReplicas();
  }

  @Override
  protected ReplicaSet setReplicas(ReplicaSet obj, int replicas) {
    return new ReplicaSetBuilder(obj).editSpec().withReplicas(replicas).endSpec().build();
  }

  @Override
  protected MixedOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>> resources() {
    return new ReplicaSetOperationsImpl(client);
  }
}
