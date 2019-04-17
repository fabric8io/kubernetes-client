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
package io.fabric8.commons;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;

import java.util.concurrent.Callable;

public class DeleteEntity<T> implements Callable<Boolean> {

  private KubernetesClient client;
  private String name;
  private String namespace;
  private Class<T> typeParameterClass;

  public DeleteEntity(Class<T> typeParameterClass, KubernetesClient client, String name, String namespace) {
    this.typeParameterClass = typeParameterClass;
    this.client = client;
    this.name = name;
    this.namespace = namespace;
  }

  @Override
  public Boolean call() {
    switch (this.typeParameterClass.getSimpleName()) {
      case "Route":
        return ((OpenShiftClient)this.client).routes().inNamespace(this.namespace).list().getItems().size() == 0;
      case "Template":
        return ((OpenShiftClient)this.client).templates().inNamespace(this.namespace).list().getItems().size() == 0;
      case "ImageStream":
        return ((OpenShiftClient)this.client).imageStreams().inNamespace(this.namespace).list().getItems().size() == 0;
      case "DeploymentConfig":
        return ((OpenShiftClient)this.client).deploymentConfigs().inNamespace(this.namespace).list().getItems().size() == 0;
      case "BuildConfig":
        return ((OpenShiftClient)this.client).buildConfigs().inNamespace(this.namespace).list().getItems().size() == 0;
      case "ConfigMap":
        return this.client.configMaps().inNamespace(this.namespace).list().getItems().size() == 0;
      case "StatefulSet":
        return this.client.apps().statefulSets().inNamespace(this.namespace).list().getItems().size() == 0;
      case "Deployment":
      return this.client.apps().deployments().inNamespace(this.namespace).list().getItems().size() == 0;
      case "Service":
        return this.client.services().inNamespace(this.namespace).list().getItems().size() == 0;
      case "ServiceAccount":
        return client.serviceAccounts().inNamespace(this.namespace).withName(this.name).get() == null;
      case "Secret":
        return this.client.secrets().inNamespace(this.namespace).withName(this.name).get() == null;
      case "ReplicationController":
        return this.client.replicationControllers().inNamespace(this.namespace).list().getItems().size() == 0;
      case "ReplicaSet":
        return this.client.apps().replicaSets().inNamespace(this.namespace).list().getItems().size() == 0;
      case "NetworkPolicy":
        return this.client.network().networkPolicies().inNamespace(this.namespace).list().getItems().size() == 0;
      case "SecurityContextConstraints":
        return ((OpenShiftClient)this.client).securityContextConstraints().withName(this.name).get() == null;
      case "ClusterRoleBinding":
        return this.client.rbac().clusterRoleBindings().withName(this.name).get() == null;
      case "ClusterRole":
        return this.client.rbac().clusterRoles().withName(this.name).get() == null;
      case "CustomResourceDefinition":
        return this.client.customResourceDefinitions().withName(this.name).get() == null;
      case "RoleBinding":
        return this.client.rbac().roleBindings().inNamespace(this.namespace).withName(this.name).get() == null;
      case "Role":
        return this.client.rbac().roles().inNamespace(this.namespace).withName(this.name).get() == null;
      case "PodSecurityPolicy":
        return this.client.extensions().podSecurityPolicies().withName(this.name).get() == null;
      default:
        return false;
    }
  }
}
