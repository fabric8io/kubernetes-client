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

import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.OpenShiftClient;

public class RouteOperationsImpl extends OpenshiftOperation<OpenShiftClient, Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>, CreateFromLoadable<Route, DoneableRoute>> {

  public RouteOperationsImpl(OpenShiftClient client) {
    super(client, "routes", null, (String) null);
  }

  public RouteOperationsImpl(OpenShiftClient client, String namespace, String name) {
    super(client, "routes", namespace, name);
  }

  public RouteOperationsImpl(OpenShiftClient client, String namespace, Route o) {
    super(client, "routes", namespace, o);
  }

}
