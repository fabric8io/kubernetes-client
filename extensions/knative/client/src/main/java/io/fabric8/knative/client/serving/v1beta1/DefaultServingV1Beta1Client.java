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
package io.fabric8.knative.client.serving.v1beta1;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.knative.serving.v1beta1.*;
import io.fabric8.knative.client.serving.v1beta1.internal.*;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class DefaultServingV1Beta1Client extends BaseClient implements NamespacedServingV1Beta1Client {

  public DefaultServingV1Beta1Client() {
    super();
  }

  public DefaultServingV1Beta1Client(Config configuration) {
    super(configuration);
  }

  public DefaultServingV1Beta1Client(OkHttpClient httpClient, Config configuration) {
    super(httpClient, configuration);
  }

  @Override
  public NamespacedServingV1Beta1Client inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedServingV1Beta1Client inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();

    return new DefaultServingV1Beta1Client(getHttpClient(), updated);
  }

  @Override
  public FunctionCallable<NamespacedServingV1Beta1Client> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<NamespacedServingV1Beta1Client>(this, requestConfig);
  }

  @Override
  public MixedOperation<Service, ServiceList, Resource<Service>> services() {
    return new ServiceOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return new RouteOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Revision, RevisionList, Resource<Revision>> revisions() {
    return new RevisionOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

  @Override
  public MixedOperation<Configuration, ConfigurationList, Resource<Configuration>> configurations() {
    return new ConfigurationOperationsImpl(this.getHttpClient(), this.getConfiguration());
  }

}
