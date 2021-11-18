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
package io.fabric8.knative.client.serving.v1;

import io.fabric8.knative.serving.v1.Configuration;
import io.fabric8.knative.serving.v1.ConfigurationList;
import io.fabric8.knative.serving.v1.Revision;
import io.fabric8.knative.serving.v1.RevisionList;
import io.fabric8.knative.serving.v1.Route;
import io.fabric8.knative.serving.v1.RouteList;
import io.fabric8.knative.serving.v1.Service;
import io.fabric8.knative.serving.v1.ServiceList;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientState;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;

public class DefaultServingV1Client extends BaseClient implements NamespacedServingV1Client {

  public DefaultServingV1Client() {
    super();
  }

  public DefaultServingV1Client(Config configuration) {
    super(configuration);
  }

  public DefaultServingV1Client(ClientState clientState) {
    super(clientState);
  }

  @Override
  public NamespacedServingV1Client inAnyNamespace() {
    return inNamespace(null);
  }

  @Override
  public NamespacedServingV1Client inNamespace(String namespace) {
    Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();

    return new DefaultServingV1Client(newState(updated));
  }

  @Override
  public FunctionCallable<NamespacedServingV1Client> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public MixedOperation<Service, ServiceList, Resource<Service>> services() {
    return Handlers.getOperation(Service.class, ServiceList.class, this);
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return Handlers.getOperation(Route.class, RouteList.class, this);
  }

  @Override
  public MixedOperation<Revision, RevisionList, Resource<Revision>> revisions() {
    return Handlers.getOperation(Revision.class, RevisionList.class, this);
  }

  @Override
  public MixedOperation<Configuration, ConfigurationList, Resource<Configuration>> configurations() {
    return Handlers.getOperation(Configuration.class, ConfigurationList.class, this);
  }

}
