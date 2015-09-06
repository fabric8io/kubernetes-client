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

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.CreateFromLoadable;
import io.fabric8.kubernetes.client.dsl.internal.HasMetadataOperation;
import io.fabric8.openshift.client.OpenShiftClient;

import java.net.URL;

public class OpenshiftOperation<K extends OpenShiftClient, T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>, C extends CreateFromLoadable<T, D>>
  extends HasMetadataOperation<K, T, L, D, R, C> {

  protected OpenshiftOperation(K client, String resourceT, String namespace, String name) {
    super(client, resourceT, namespace, name);
  }

  protected OpenshiftOperation(K client, String resourceT, String namespace, T o) {
    super(client, resourceT, namespace, o);
  }

  @Override
  public URL getRootUrl() {
    return getClient().getOpenshiftUrl();
  }
}
