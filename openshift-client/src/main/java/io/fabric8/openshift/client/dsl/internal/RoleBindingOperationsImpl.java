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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.DoneableRoleBinding;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingBuilder;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class RoleBindingOperationsImpl extends OpenShiftOperation<RoleBinding, RoleBindingList, DoneableRoleBinding, Resource<RoleBinding, DoneableRoleBinding>> {
  public RoleBindingOperationsImpl(OkHttpClient client, OpenShiftConfig config, String namespace) {
    this(client, config, null, namespace, null, true, null, null, false, -1, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public RoleBindingOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, RoleBinding item, String resourceVersion, Boolean reloadingFromServer, long gracePeriodSeconds, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    super(client, OpenShiftOperation.withApiGroup(client, AUTHORIZATION, apiVersion, config), "rolebindings", namespace, name, cascading, item, resourceVersion, reloadingFromServer, gracePeriodSeconds, labels, labelsNot, labelsIn, labelsNotIn, fields);
  }

  @Override
  public RoleBinding replace(RoleBinding item) {
    RoleBinding enriched = enrichRoleBinding(item);
    return super.replace(enriched);
  }

  @Override
  public RoleBinding patch(RoleBinding item) {
    RoleBinding enriched = enrichRoleBinding(item);
    return super.patch(enriched);
  }

  @Override
  public RoleBinding create(RoleBinding... resources) throws KubernetesClientException {
    RoleBinding[] enriched = new RoleBinding[resources.length];
    for (int i = 0; i < resources.length; i++) {
      enriched[i] = enrichRoleBinding(resources[i]);
    }
    return super.create(enriched);
  }

  private RoleBinding enrichRoleBinding(RoleBinding binding) {
    RoleBindingBuilder builder = new RoleBindingBuilder(binding);

    if ((binding.getUserNames() != null && !binding.getUserNames().isEmpty()) ||
      (binding.getGroupNames() != null && !binding.getGroupNames().isEmpty())) {
      enrichFromUsersAndGroups(builder, binding.getUserNames(), binding.getGroupNames());
    } else {
      enrichFromSubjects(builder, binding.getSubjects());
      enrichSubjectsNamespace(builder);
    }

    return builder.build();
  }

  private void enrichSubjectsNamespace(RoleBindingBuilder builder) {
    builder.accept(new TypedVisitor<ObjectReferenceBuilder>() {
      @Override
      public void visit(ObjectReferenceBuilder o) {
        if (o.getKind() != null && o.getKind().equals("ServiceAccount") && (o.getNamespace() == null || o.getNamespace().isEmpty())) {
          o.withNamespace(getNamespace());
        }
      }
    });
  }

  private void enrichFromUsersAndGroups(RoleBindingBuilder builder, List<String> userNames, List<String> groupNames) {
    builder.withSubjects();

    if (userNames != null) {
      for (String userName : userNames) {
        if (userName.startsWith("system:serviceaccount:")) {
          String[] splitUserName = userName.split(":");
          if (splitUserName.length == 4) {
            builder.addNewSubject().withKind("ServiceAccount").withNamespace(splitUserName[2]).withName(splitUserName[3]).endSubject();
            continue;
          }
        }

        builder.addNewSubject().withKind("User").withName(userName).endSubject();
      }
    }

    if (groupNames != null) {
      for (String groupName : groupNames) {
        builder.addNewSubject().withKind("Group").withName(groupName).endSubject();
      }
    }
  }

  private void enrichFromSubjects(RoleBindingBuilder builder, List<ObjectReference> subjects) {
    for (ObjectReference ref : subjects) {
      switch (ref.getKind()) {
        case "User":
          builder.addToUserNames(ref.getName());
          break;
        case "ServiceAccount":
          String namespace = ref.getNamespace();
          if (namespace == null || namespace.isEmpty()) {
            namespace = getNamespace();
          }
          builder.addToUserNames("system:serviceaccount:" + namespace + ":" + ref.getName());
          break;
        case "Group":
          builder.addToGroupNames(ref.getName());
          break;
      }
    }
  }
}
