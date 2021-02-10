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

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;

import java.util.List;
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
        return isDeleted(((OpenShiftClient)this.client).routes().inNamespace(this.namespace).list().getItems());
      case "Template":
        return isDeleted(((OpenShiftClient)this.client).templates().inNamespace(this.namespace).list().getItems());
      case "ImageStream":
        return isDeleted(((OpenShiftClient)this.client).imageStreams().inNamespace(this.namespace).list().getItems());
      case "ImageStreamTag":
        return isDeleted(((OpenShiftClient)this.client).imageStreamTags().inNamespace(this.namespace).withName(this.name).get());
      case "DeploymentConfig":
        return isDeleted(((OpenShiftClient)this.client).deploymentConfigs().inNamespace(this.namespace).list().getItems());
      case "BuildConfig":
        return isDeleted(((OpenShiftClient)this.client).buildConfigs().inNamespace(this.namespace).list().getItems());
      case "ConfigMap":
        return isDeleted(this.client.configMaps().inNamespace(this.namespace).list().getItems());
      case "StatefulSet":
        return isDeleted(this.client.apps().statefulSets().inNamespace(this.namespace).list().getItems());
      case "Deployment":
      return isDeleted(this.client.apps().deployments().inNamespace(this.namespace).list().getItems());
      case "Service":
        return isDeleted(this.client.services().inNamespace(this.namespace).list().getItems());
      case "ServiceAccount":
        return isDeleted(this.client.serviceAccounts().inNamespace(this.namespace).withName(this.name).get());
      case "Secret":
        return isDeleted(this.client.secrets().inNamespace(this.namespace).withName(this.name).get());
      case "ReplicationController":
        return isDeleted(this.client.replicationControllers().inNamespace(this.namespace).list().getItems());
      case "ReplicaSet":
        if (this.name == null) {
          return isDeleted(this.client.apps().replicaSets().inNamespace(this.namespace).list().getItems());
        } else {
          return isDeleted(this.client.apps().replicaSets().inNamespace(this.namespace).withName(this.name).get());
        }
      case "NetworkPolicy":
        return isDeleted(this.client.network().networkPolicies().inNamespace(this.namespace).withName(name).get());
      case "SecurityContextConstraints":
        return isDeleted(((OpenShiftClient)this.client).securityContextConstraints().withName(this.name).get());
      case "ClusterRoleBinding":
        return isDeleted(this.client.rbac().clusterRoleBindings().withName(this.name).get());
      case "ClusterRole":
        return isDeleted(this.client.rbac().clusterRoles().withName(this.name).get());
      case "CustomResourceDefinition":
        return isDeleted(this.client.apiextensions().v1beta1().customResourceDefinitions().withName(this.name).get());
      case "RoleBinding":
        return isDeleted(this.client.rbac().roleBindings().inNamespace(this.namespace).withName(this.name).get());
      case "Role":
        return isDeleted(this.client.rbac().roles().inNamespace(this.namespace).withName(this.name).get());
      case "PodSecurityPolicy":
        return isDeleted(this.client.extensions().podSecurityPolicies().withName(this.name).get());
      default:
        return false;
    }
  }

  private <T extends HasMetadata> boolean isDeleted(List<T> items) {
    // If zero items exists of this kind, everything is cleaned up.
    if (items.size() == 0) {
      return true;
    }

    // If not, iterate through list and check metadata.deletionTimestamp field
    for (T item : items) {
      if (item.getMetadata().getDeletionTimestamp() == null) {
        return false;
      }
    }
    return true;
  }

  private boolean isDeleted(HasMetadata item) {
    if (item == null) {
      return true;
    }

    return item.getMetadata().getDeletionTimestamp() != null;
  }
}
