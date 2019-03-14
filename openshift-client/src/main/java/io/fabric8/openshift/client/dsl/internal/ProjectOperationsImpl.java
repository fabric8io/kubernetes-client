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

import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;
import io.fabric8.openshift.api.model.DoneableProject;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.client.OpenShiftConfig;

import java.util.Map;
import java.util.TreeMap;

import static io.fabric8.openshift.client.OpenShiftAPIGroups.PROJECT;

public class ProjectOperationsImpl extends OpenShiftOperation<Project, ProjectList, DoneableProject,
  Resource<Project, DoneableProject>> {

  public ProjectOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ProjectOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(PROJECT)
      .withPlural("projects"));
    this.type = Project.class;
    this.listType = ProjectList.class;
    this.doneableType = DoneableProject.class;
  }
  @Override
  public ProjectOperationsImpl newInstance(OperationContext context) {
    return new ProjectOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
