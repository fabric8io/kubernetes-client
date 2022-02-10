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

package io.fabric8.kubernetes.client.dsl;

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
import io.fabric8.kubernetes.client.Client;

public interface AppsAPIGroupDSL extends Client {

  MixedOperation<DaemonSet, DaemonSetList, Resource<DaemonSet>> daemonSets();

  MixedOperation<Deployment, DeploymentList, RollableScalableResource<Deployment>> deployments();

  MixedOperation<ReplicaSet, ReplicaSetList, RollableScalableResource<ReplicaSet>> replicaSets();

  MixedOperation<StatefulSet, StatefulSetList, RollableScalableResource<StatefulSet>> statefulSets();

  /**
   * DSL entrypoint for ControllerRevision in api group apps/v1
   *
   * @return {@link MixedOperation} for ControllerRevision resource
   */
  MixedOperation<ControllerRevision, ControllerRevisionList, Resource<ControllerRevision>> controllerRevisions();

}
