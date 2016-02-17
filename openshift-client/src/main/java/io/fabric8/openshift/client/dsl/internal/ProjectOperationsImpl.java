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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.openshift.api.model.DoneableProject;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.client.OpenShiftConfig;

public class ProjectOperationsImpl extends OpenShiftOperation<Project, ProjectList, DoneableProject,
  ClientResource<Project, DoneableProject>> {

  public ProjectOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(client, config, null, null, null, true, null, null, false);
  }

  public ProjectOperationsImpl(OkHttpClient client, OpenShiftConfig config, String apiVersion, String namespace, String name, Boolean cascading, Project item, String resourceVersion, Boolean reloadingFromServer) {
    super(client, config, null, apiVersion, "projects", namespace, name, cascading, item, resourceVersion, reloadingFromServer);
  }


  @Override
  public boolean isNamespaceRequired() {
    return false;
  }
}
