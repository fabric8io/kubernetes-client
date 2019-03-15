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
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.api.model.DoneableOpenshiftRoleBinding;
import io.fabric8.openshift.api.model.OpenshiftRoleBinding;
import io.fabric8.openshift.api.model.OpenshiftRoleBindingBuilder;
import io.fabric8.openshift.api.model.OpenshiftRoleBindingList;
import io.fabric8.openshift.client.OpenShiftConfig;
import okhttp3.OkHttpClient;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class OpenshiftRoleBindingOperationsImpl extends OpenShiftOperation<OpenshiftRoleBinding, OpenshiftRoleBindingList, DoneableOpenshiftRoleBinding, Resource<OpenshiftRoleBinding, DoneableOpenshiftRoleBinding>> {

  public OpenshiftRoleBindingOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OpenshiftRoleBindingOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION)
      .withPlural("rolebindings"));
    this.type = OpenshiftRoleBinding.class;
    this.listType = OpenshiftRoleBindingList.class;
    this.doneableType = DoneableOpenshiftRoleBinding.class;
  }

  @Override
  public OpenshiftRoleBindingOperationsImpl newInstance(OperationContext context) {
    return new OpenshiftRoleBindingOperationsImpl(context);
  }

  @Override
  public OpenshiftRoleBinding replace(OpenshiftRoleBinding item) {
    OpenshiftRoleBinding enriched = enrichRoleBinding(item);
    return super.replace(enriched);
  }

  @Override
  public OpenshiftRoleBinding patch(OpenshiftRoleBinding item) {
    OpenshiftRoleBinding enriched = enrichRoleBinding(item);
    return super.patch(enriched);
  }

  @Override
  protected OpenshiftRoleBinding handleCreate(OpenshiftRoleBinding resource) throws ExecutionException, InterruptedException, KubernetesClientException, IOException {
    return super.handleCreate(enrichRoleBinding(resource));
  }

  private OpenshiftRoleBinding enrichRoleBinding(OpenshiftRoleBinding binding) {
    OpenshiftRoleBindingBuilder builder = new OpenshiftRoleBindingBuilder(binding);

    if ((binding.getUserNames() != null && !binding.getUserNames().isEmpty()) ||
      (binding.getGroupNames() != null && !binding.getGroupNames().isEmpty())) {
      enrichFromUsersAndGroups(builder, binding.getUserNames(), binding.getGroupNames());
    } else {
      enrichFromSubjects(builder, binding.getSubjects());
      enrichSubjectsNamespace(builder);
    }

    return builder.build();
  }

  private void enrichSubjectsNamespace(OpenshiftRoleBindingBuilder builder) {
    builder.accept(new TypedVisitor<ObjectReferenceBuilder>() {
      @Override
      public void visit(ObjectReferenceBuilder o) {
        if (o.getKind() != null && o.getKind().equals("ServiceAccount") && (o.getNamespace() == null || o.getNamespace().isEmpty())) {
          o.withNamespace(getNamespace());
        }
      }
    });
  }

  private void enrichFromUsersAndGroups(OpenshiftRoleBindingBuilder builder, List<String> userNames, List<String> groupNames) {
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

  private void enrichFromSubjects(OpenshiftRoleBindingBuilder builder, List<ObjectReference> subjects) {
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
