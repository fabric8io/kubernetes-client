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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.scheduling.DoneablePriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.PriorityClass;
import io.fabric8.kubernetes.api.model.scheduling.PriorityClassList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import okhttp3.OkHttpClient;


public class PriorityClassOperationsImpl extends HasMetadataOperation<PriorityClass, PriorityClassList, DoneablePriorityClass, Resource<PriorityClass, DoneablePriorityClass>> {

  public PriorityClassOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public PriorityClassOperationsImpl(OperationContext context) {
    super(context.withApiGroupName("scheduling.k8s.io")
      .withApiGroupVersion("v1beta1")
      .withPlural("priorityclasses"));

    this.type = PriorityClass.class;
    this.listType = PriorityClassList.class;
    this.doneableType = DoneablePriorityClass.class;
  }

  @Override
  public PriorityClassOperationsImpl newInstance(OperationContext context) {
    return new PriorityClassOperationsImpl(context);
  }

  @Override
  public boolean isResourceNamespaced() {
    return false;
  }
}
