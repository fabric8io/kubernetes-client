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
package io.fabric8.kudo.client.operations;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kudo.v1beta1.DoneableInstance;
import io.fabric8.kudo.client.Constance;
import io.fabric8.kudo.v1beta1.Instance;
import io.fabric8.kudo.v1beta1.InstanceList;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/21
 */
public class InstanceOperationsImpl extends HasMetadataOperation<Instance, InstanceList, DoneableInstance, Resource<Instance, DoneableInstance>>  {
  public InstanceOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public InstanceOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(Constance.ApiGroupName)
      .withApiGroupVersion(Constance.ApiGroupVersion)
      .withPlural(Constance.InstancesPlural));
    this.type = Instance.class;
    this.listType = InstanceList.class;
    this.doneableType = DoneableInstance.class;
  }

  public InstanceOperationsImpl newInstance(OperationContext context) {
    return new InstanceOperationsImpl(context);
  }
}
