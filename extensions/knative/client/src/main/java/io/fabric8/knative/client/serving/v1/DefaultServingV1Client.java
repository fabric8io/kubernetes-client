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
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;

public class DefaultServingV1Client extends ClientAdapter<DefaultServingV1Client> implements NamespacedServingV1Client {

  @Override
  public DefaultServingV1Client newInstance() {
    return new DefaultServingV1Client();
  }

  @Override
  public FunctionCallable<NamespacedServingV1Client> withRequestConfig(RequestConfig requestConfig) {
    return new WithRequestCallable<>(this, requestConfig);
  }

  @Override
  public MixedOperation<Service, ServiceList, Resource<Service>> services() {
    return resources(Service.class, ServiceList.class);
  }

  @Override
  public MixedOperation<Route, RouteList, Resource<Route>> routes() {
    return resources(Route.class, RouteList.class);
  }

  @Override
  public MixedOperation<Revision, RevisionList, Resource<Revision>> revisions() {
    return resources(Revision.class, RevisionList.class);
  }

  @Override
  public MixedOperation<Configuration, ConfigurationList, Resource<Configuration>> configurations() {
    return resources(Configuration.class, ConfigurationList.class);
  }

}
