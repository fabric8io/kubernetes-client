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
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.DoneableBuild;
import io.fabric8.openshift.client.OpenShiftClient;

public class BuildOperationsImpl extends OpenshiftOperation<OpenShiftClient, Build, BuildList, DoneableBuild,
  ClientResource<Build, DoneableBuild>> {

  public BuildOperationsImpl(OpenShiftClient client) {
    this(client, client.getNamespace(), null, true, null);
  }

  public BuildOperationsImpl(OpenShiftClient client, String namespace, String name, Boolean cascading, Build item) {
    super(client, "builds", namespace, name, cascading, item);
  }
}
