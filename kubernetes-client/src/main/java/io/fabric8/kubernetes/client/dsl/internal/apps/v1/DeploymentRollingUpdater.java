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
package io.fabric8.kubernetes.client.dsl.internal.apps.v1;

import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.LabelSelectorRequirement;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Operation;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;

class DeploymentRollingUpdater extends RollingUpdater<Deployment, DeploymentList> {

  DeploymentRollingUpdater(OkHttpClient client, Config config, String namespace) {
    super(client, config, namespace);
  }

  DeploymentRollingUpdater(OkHttpClient client, Config config, String namespace, long rollingTimeoutMillis, long loggingIntervalMillis) {
    super(client, config, namespace, rollingTimeoutMillis, loggingIntervalMillis);
  }

  @Override
  protected Deployment createClone(Deployment obj, String newName, String newDeploymentHash) {
    return new DeploymentBuilder(obj)
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
  protected PodList listSelectedPods(Deployment obj) {
    FilterWatchListDeletable<Pod, PodList> podLister = pods().inNamespace(namespace);
    if (obj.getSpec().getSelector().getMatchLabels() != null) {
      podLister.withLabels(obj.getSpec().getSelector().getMatchLabels());
    }
    if (obj.getSpec().getSelector().getMatchExpressions() != null) {
      for (LabelSelectorRequirement req : obj.getSpec().getSelector().getMatchExpressions()) {
        switch (req.getOperator()) {
          case "In":
            podLister.withLabelIn(req.getKey(), req.getValues().toArray(new String[]{}));
            break;
          case "NotIn":
            podLister.withLabelNotIn(req.getKey(), req.getValues().toArray(new String[]{}));
            break;
          case "DoesNotExist":
            podLister.withoutLabel(req.getKey());
            break;
          case "Exists":
            podLister.withLabel(req.getKey());
            break;
        }
      }
    }
    return podLister.list();
  }

  @Override
  protected Deployment updateDeploymentKey(String name, String hash) {
     return resources().inNamespace(namespace).withName(name).edit(old->new DeploymentBuilder(old).editSpec()
         .editSelector().addToMatchLabels(DEPLOYMENT_KEY, hash).endSelector()
         .editTemplate().editMetadata().addToLabels(DEPLOYMENT_KEY, hash).endMetadata().endTemplate()
         .endSpec()
         .build());
  }

  @Override
  protected Deployment removeDeploymentKey(String name) {
     return resources().inNamespace(namespace).withName(name).edit(old->new DeploymentBuilder(old).editSpec()
         .editSelector().removeFromMatchLabels(DEPLOYMENT_KEY).endSelector()
         .editTemplate().editMetadata().removeFromLabels(DEPLOYMENT_KEY).endMetadata().endTemplate()
         .endSpec()
         .build());
  }

  @Override
  protected int getReplicas(Deployment obj) {
    return obj.getSpec().getReplicas();
  }

  @Override
  protected Deployment setReplicas(Deployment obj, int replicas) {
    return new DeploymentBuilder(obj).editSpec().withReplicas(replicas).endSpec().build();
  }

  @Override
  protected Operation<Deployment, DeploymentList, RollableScalableResource<Deployment>> resources() {
    return new DeploymentOperationsImpl(client, config);
  }
}
