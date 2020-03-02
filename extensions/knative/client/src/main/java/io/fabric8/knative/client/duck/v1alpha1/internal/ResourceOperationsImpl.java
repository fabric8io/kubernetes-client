/**
 * Copyright (C) 2015 Fabric8 Authors.
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



package io.fabric8.knative.client.duck.v1alpha1.internal;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;

import okhttp3.OkHttpClient;

import io.fabric8.knative.duck.v1alpha1.DoneableResource;
import io.fabric8.knative.duck.v1alpha1.ResourceList;


public class ResourceOperationsImpl extends HasMetadataOperation<io.fabric8.knative.duck.v1alpha1.Resource, ResourceList, DoneableResource, io.fabric8.kubernetes.client.dsl.Resource<io.fabric8.knative.duck.v1alpha1.Resource, io.fabric8.knative.duck.v1alpha1.DoneableResource>> {

  public ResourceOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public ResourceOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("duck.knative.dev")
      .withApiGroupVersion("v1alpha1")
      .withPlural("resources"));
    this.type = io.fabric8.knative.duck.v1alpha1.Resource.class;
    this.listType = ResourceList.class;
    this.doneableType = DoneableResource.class;
  }

  public ResourceOperationsImpl newInstance(OperationContext context) {
    return new ResourceOperationsImpl(context);
  }
}
