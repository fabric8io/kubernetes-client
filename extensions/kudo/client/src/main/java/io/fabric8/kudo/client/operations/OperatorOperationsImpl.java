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
import io.fabric8.kudo.v1beta1.DoneableOperator;
import io.fabric8.kudo.v1beta1.Operator;

import io.fabric8.kudo.v1beta1.OperatorList;
import io.fabric8.kudo.client.Constance;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/21
 */
// public class OperatorOperationsImpl extends HasMetadataOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>>  {
public class OperatorOperationsImpl extends HasMetadataOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>>  {
  public OperatorOperationsImpl(OkHttpClient client, Config config) {
    this(new OperationContext().withOkhttpClient(client).withConfig(config));
  }

  public OperatorOperationsImpl(OperationContext context) {
    super(context.withApiGroupName(Constance.ApiGroupName)
      .withApiGroupVersion(Constance.ApiGroupVersion)
      .withPlural("operators"));
    this.type = Operator.class;
    this.listType = OperatorList.class;
    this.doneableType = DoneableOperator.class;
  }

  public OperatorOperationsImpl newInstance(OperationContext context) {
    return new OperatorOperationsImpl(context);
  }
}
