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

import io.fabric8.kubernetes.api.model.extensions.ConfigMap;
import io.fabric8.kubernetes.api.model.extensions.ConfigMapList;
import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetList;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.DoneableConfigMap;
import io.fabric8.kubernetes.api.model.extensions.DoneableDaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DoneableDeployment;
import io.fabric8.kubernetes.api.model.extensions.DoneableIngress;
import io.fabric8.kubernetes.api.model.extensions.DoneableJob;
import io.fabric8.kubernetes.api.model.extensions.DoneableThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.api.model.extensions.Job;
import io.fabric8.kubernetes.api.model.extensions.JobList;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceList;
import io.fabric8.kubernetes.client.Client;

public interface ExtensionsAPIGroupDSL extends Client {

  ClientMixedOperation<Job, JobList, DoneableJob, ClientResource<Job, DoneableJob>> jobs();

  ClientMixedOperation<Deployment, DeploymentList, DoneableDeployment, ClientResource<Deployment, DoneableDeployment>> deployments();

  @Deprecated
  ClientMixedOperation<Ingress, IngressList, DoneableIngress, ClientResource<Ingress, DoneableIngress>> ingress();

  ClientMixedOperation<Ingress, IngressList, DoneableIngress, ClientResource<Ingress, DoneableIngress>> ingresses();

  ClientMixedOperation<DaemonSet, DaemonSetList, DoneableDaemonSet, ClientResource<DaemonSet, DoneableDaemonSet>> daemonSets();

  ClientMixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap, ClientResource<ConfigMap, DoneableConfigMap>> configMaps();

  ClientMixedOperation<ThirdPartyResource, ThirdPartyResourceList, DoneableThirdPartyResource, ClientResource<ThirdPartyResource, DoneableThirdPartyResource>> thirdPartyResources();
}
