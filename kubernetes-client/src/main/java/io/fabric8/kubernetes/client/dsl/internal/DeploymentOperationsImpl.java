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

import com.squareup.okhttp.OkHttpClient;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.api.model.extensions.DoneableDeployment;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;

public class DeploymentOperationsImpl extends HasMetadataOperation<Deployment, DeploymentList, DoneableDeployment, ClientResource<Deployment, DoneableDeployment>> {

  public DeploymentOperationsImpl(OkHttpClient client, Config config, String namespace) {
      this(client, config, "v1beta1", namespace, null, true, null, null, false);
  }

  public DeploymentOperationsImpl(OkHttpClient client, Config config, String apiVersion, String namespace, String name, Boolean cascading, Deployment item, String resourceVersion, Boolean reloadingFromServer) {
    super(client, config, "extensions", apiVersion, "deployments", namespace, name, cascading, item, resourceVersion, reloadingFromServer);
  }
}
