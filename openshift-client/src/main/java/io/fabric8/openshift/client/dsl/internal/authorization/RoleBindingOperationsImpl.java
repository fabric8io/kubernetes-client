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
package io.fabric8.openshift.client.dsl.internal.authorization;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingBuilder;
import io.fabric8.openshift.api.model.RoleBindingList;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.AUTHORIZATION;

public class RoleBindingOperationsImpl extends HasMetadataOperation<RoleBinding, RoleBindingList, Resource<RoleBinding>> {

  public static final String SERVICE_ACCOUNT = "ServiceAccount";
  public static final String USER = "User";
  public static final String GROUP = "Group";

  public RoleBindingOperationsImpl(Client client) {
    this(HasMetadataOperationsImpl.defaultContext(client));
  }

  public RoleBindingOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(AUTHORIZATION)
        .withPlural("rolebindings"), RoleBinding.class, RoleBindingList.class);
  }

  @Override
  public RoleBindingOperationsImpl newInstance(OperationContext context) {
    return new RoleBindingOperationsImpl(context);
  }

  @Override
  protected RoleBinding handleCreate(RoleBinding resource) throws InterruptedException, IOException {
    return super.handleCreate(enrichRoleBinding(resource));
  }

  @Override
  protected RoleBinding modifyItemForReplaceOrPatch(Supplier<RoleBinding> current, RoleBinding binding) {
    return enrichRoleBinding(binding);
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
        if (o.getKind() != null && o.getKind().equals(SERVICE_ACCOUNT)
            && (o.getNamespace() == null || o.getNamespace().isEmpty())) {
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
            builder.addNewSubject().withKind(SERVICE_ACCOUNT).withNamespace(splitUserName[2]).withName(splitUserName[3])
                .endSubject();
            continue;
          }
        }

        builder.addNewSubject().withKind(USER).withName(userName).endSubject();
      }
    }

    if (groupNames != null) {
      for (String groupName : groupNames) {
        builder.addNewSubject().withKind(GROUP).withName(groupName).endSubject();
      }
    }
  }

  private void enrichFromSubjects(RoleBindingBuilder builder, List<ObjectReference> subjects) {
    for (ObjectReference ref : subjects) {
      switch (ref.getKind()) {
        case USER:
          builder.addToUserNames(ref.getName());
          break;
        case SERVICE_ACCOUNT:
          String namespace = ref.getNamespace();
          if (namespace == null || namespace.isEmpty()) {
            namespace = getNamespace();
          }
          builder.addToUserNames("system:serviceaccount:" + namespace + ":" + ref.getName());
          break;
        case GROUP:
          builder.addToGroupNames(ref.getName());
          break;
      }
    }
  }
}
