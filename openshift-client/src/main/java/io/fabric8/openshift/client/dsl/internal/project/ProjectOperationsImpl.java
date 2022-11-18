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
package io.fabric8.openshift.client.dsl.internal.project;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.rbac.RoleBinding;
import io.fabric8.kubernetes.api.model.rbac.RoleBindingBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectBuilder;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.client.dsl.ProjectOperation;

import java.util.ArrayList;
import java.util.List;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.PROJECT;

public class ProjectOperationsImpl extends HasMetadataOperation<Project, ProjectList, Resource<Project>>
    implements ProjectOperation {
  public static final String OPENSHIFT_IO_DESCRIPTION_ANNOTATION = "openshift.io/description";
  public static final String OPENSHIFT_IO_DISPLAY_NAME_ANNOTATION = "openshift.io/display-name";
  public static final String OPENSHIFT_IO_REQUESTER_ANNOTATION = "openshift.io/requester";
  public static final String RBAC_AUTHORIZATION_APIGROUP = "rbac.authorization.k8s.io";
  public static final String CLUSTER_ROLE = "ClusterRole";

  public ProjectOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  public ProjectOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(PROJECT)
        .withPlural("projects"), Project.class, ProjectList.class);
  }

  @Override
  public ProjectOperationsImpl newInstance(OperationContext context) {
    return new ProjectOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }

  @Override
  public List<HasMetadata> createProjectAndRoleBindings(String name, String description, String displayName, String adminUser,
      String requestingUser) {
    List<HasMetadata> result = new ArrayList<>();
    Project project = initProject(name, description, displayName, requestingUser);
    List<HasMetadata> projectRoleBindings = initRoleBindings(name, adminUser);

    // Create Project
    result.add(create(project));

    // Create Role Bindings
    NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl listOp = new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(
        context.withItem(projectRoleBindings));
    result.addAll(listOp.createOrReplace());

    return result;
  }

  private Project initProject(String name, String description, String displayName, String requestingUser) {
    return new ProjectBuilder()
        .withNewMetadata()
        .addToAnnotations(OPENSHIFT_IO_DESCRIPTION_ANNOTATION, description)
        .addToAnnotations(OPENSHIFT_IO_DISPLAY_NAME_ANNOTATION, displayName)
        .addToAnnotations(OPENSHIFT_IO_REQUESTER_ANNOTATION, requestingUser)
        .withName(name)
        .endMetadata()
        .build();
  }

  private List<HasMetadata> initRoleBindings(String name, String adminUser) {
    RoleBinding roleBindingPuller = new RoleBindingBuilder()
        .withNewMetadata()
        .addToAnnotations(OPENSHIFT_IO_DESCRIPTION_ANNOTATION,
            "Allows all pods in this namespace to pull images from this namespace.  It is auto-managed by a controller; remove subjects to disable.")
        .withName("system:image-pullers")
        .withNamespace(name)
        .endMetadata()
        .withNewRoleRef()
        .withApiGroup(RBAC_AUTHORIZATION_APIGROUP)
        .withKind(CLUSTER_ROLE)
        .withName("system:image-puller")
        .endRoleRef()
        .addNewSubject()
        .withApiGroup(RBAC_AUTHORIZATION_APIGROUP)
        .withKind("Group")
        .withName("system:serviceaccounts:" + name)
        .endSubject()
        .build();
    RoleBinding roleBindingBuilder = new RoleBindingBuilder()
        .withNewMetadata()
        .addToAnnotations(OPENSHIFT_IO_DESCRIPTION_ANNOTATION, "Allows builds in this namespace to push images to" +
            "this namespace.  It is auto-managed by a controller; remove subjects to disable.")
        .withName("system:image-builders")
        .withNamespace(name)
        .endMetadata()
        .withNewRoleRef()
        .withApiGroup(RBAC_AUTHORIZATION_APIGROUP)
        .withKind(CLUSTER_ROLE)
        .withName("system:image-builder")
        .endRoleRef()
        .addNewSubject()
        .withKind("ServiceAccount")
        .withName("builder")
        .withNamespace(name)
        .endSubject()
        .build();
    RoleBinding roleBindingDeployer = new RoleBindingBuilder()
        .withNewMetadata()
        .addToAnnotations(OPENSHIFT_IO_DESCRIPTION_ANNOTATION, " Allows deploymentconfigs in this namespace to rollout" +
            " pods in this namespace.  It is auto-managed by a controller; remove subjects" +
            " to disable.")
        .withName("system:deployers")
        .withNamespace(name)
        .endMetadata()
        .withNewRoleRef()
        .withApiGroup(RBAC_AUTHORIZATION_APIGROUP)
        .withKind(CLUSTER_ROLE)
        .withName("system:deployer")
        .endRoleRef()
        .addNewSubject()
        .withKind("ServiceAccount")
        .withName("deployer")
        .withNamespace(name)
        .endSubject()
        .build();

    RoleBinding roleBindingAdmin = new RoleBindingBuilder()
        .withNewMetadata()
        .withName("admin")
        .withNamespace(name)
        .endMetadata()
        .withNewRoleRef()
        .withApiGroup(RBAC_AUTHORIZATION_APIGROUP)
        .withKind(CLUSTER_ROLE)
        .withName("admin")
        .endRoleRef()
        .addNewSubject()
        .withApiGroup(RBAC_AUTHORIZATION_APIGROUP)
        .withKind("User")
        .withName(adminUser)
        .endSubject()
        .build();

    List<HasMetadata> resources = new ArrayList<>();
    resources.add(roleBindingPuller);
    resources.add(roleBindingBuilder);
    resources.add(roleBindingDeployer);
    resources.add(roleBindingAdmin);

    return resources;
  }

}
