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

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.openshift.api.model.DoneableGroup;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.client.OpenShiftClient;

public class GroupOperationsImpl extends OpenshiftOperation<OpenShiftClient, Group, GroupList, DoneableGroup, ClientResource<Group, DoneableGroup>, CreateFromLoadable<Group, DoneableGroup>> {
  public GroupOperationsImpl(OpenShiftClient client) {
    super(client, "groups", null, (String) null);
  }

  public GroupOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "groups", namespace, name);
  }

  public GroupOperationsImpl(OpenShiftClient client, String namespace, Group o) {
    super(client, "groups", namespace, o);
  }
}
