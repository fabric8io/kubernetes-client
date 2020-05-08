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
package io.fabric8.kudo.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kudo.client.operations.InstanceOperationsImpl;
import io.fabric8.kudo.client.operations.OperatorOperationsImpl;
import io.fabric8.kudo.client.operations.OperatorVersionOperationsImpl;
import io.fabric8.kudo.v1beta1.*;
import io.fabric8.kudo.v1beta1.DoneableInstance;
import io.fabric8.kudo.v1beta1.DoneableOperator;
import io.fabric8.kudo.v1beta1.DoneableOperatorVersion;
import okhttp3.OkHttpClient;

/**
 * @author pangms
 * @date 2020/4/20
 */
public class DefaultKudoClient extends BaseClient implements KudoClient {
  public DefaultKudoClient() throws KubernetesClientException {
    super();
  }

  public DefaultKudoClient(String masterUrl) throws KubernetesClientException {
    super(masterUrl);
  }

  public DefaultKudoClient(Config config) throws KubernetesClientException {
    super(config);
  }


  public DefaultKudoClient(OkHttpClient httpClient, Config config) throws KubernetesClientException {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Operator, OperatorList, DoneableOperator, Resource<Operator, DoneableOperator>> operators() {
    return new OperatorOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Instance, InstanceList, DoneableInstance, Resource<Instance, DoneableInstance>> instances() {
    return new InstanceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<OperatorVersion, OperatorVersionList, DoneableOperatorVersion, Resource<OperatorVersion, DoneableOperatorVersion>> operatorVersion() {
    return new OperatorVersionOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }
}
