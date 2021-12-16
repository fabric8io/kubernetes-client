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

import io.fabric8.kubernetes.api.model.apps.ControllerRevision;
import io.fabric8.kubernetes.api.model.apps.ControllerRevisionList;
import io.fabric8.kubernetes.api.model.apps.DaemonSet;
import io.fabric8.kubernetes.api.model.apps.DaemonSetList;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.apps.ReplicaSet;
import io.fabric8.kubernetes.api.model.apps.ReplicaSetList;
import io.fabric8.kubernetes.api.model.apps.StatefulSet;
import io.fabric8.kubernetes.api.model.apps.StatefulSetList;
import io.fabric8.kubernetes.client.dsl.AppsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.RollableScalableResource;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.DeploymentOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.ReplicaSetOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.apps.v1.StatefulSetOperationsImpl;

public class AppsAPIGroupClient extends BaseClient implements AppsAPIGroupDSL {

  public AppsAPIGroupClient() {
    super();
  }

  public AppsAPIGroupClient(ClientContext clientContext) {
    super(clientContext);
  }

  @Override
  public MixedOperation<DaemonSet, DaemonSetList, Resource<DaemonSet>> daemonSets() {
    return Handlers.getOperation(DaemonSet.class, DaemonSetList.class, this);
  }

  @Override
  public MixedOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>> deployments() {
    return new DeploymentOperationsImpl(this);
  }

  @Override
  public MixedOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>> replicaSets() {
    return new ReplicaSetOperationsImpl(this);
  }

  @Override
  public MixedOperation<StatefulSet, StatefulSetList, RollableScalableResource<StatefulSet>> statefulSets() {
    return new StatefulSetOperationsImpl(this);
  }

  @Override
  public MixedOperation<ControllerRevision, ControllerRevisionList, Resource<ControllerRevision>> controllerRevisions() {
    return Handlers.getOperation(ControllerRevision.class, ControllerRevisionList.class, this);
  }
}
