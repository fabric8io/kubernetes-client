
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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.openshift.api.model.DoneableTemplateInstance;
import io.fabric8.openshift.api.model.TemplateInstance;
import io.fabric8.openshift.api.model.TemplateInstanceList;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftAPIGroups;
import io.fabric8.openshift.client.dsl.TemplateInstanceResource;
import okhttp3.OkHttpClient;

public class TemplateInstanceOperationsImpl
  extends OpenShiftOperation<TemplateInstance, TemplateInstanceList, DoneableTemplateInstance, TemplateInstanceResource<TemplateInstance, KubernetesList, DoneableTemplateInstance>> {

  public TemplateInstanceOperationsImpl(OkHttpClient client, OpenShiftConfig config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public TemplateInstanceOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(OpenShiftAPIGroups.TEMPLATE)
      .withApiGroupVersion("v1")
      .withPlural("templateinstances"));
    this.type = TemplateInstance.class;
    this.listType = TemplateInstanceList.class;
    this.doneableType = DoneableTemplateInstance.class;
  }

  public TemplateInstanceOperationsImpl newInstance(OperationContext context) {
    return new TemplateInstanceOperationsImpl(context);
  }

}
