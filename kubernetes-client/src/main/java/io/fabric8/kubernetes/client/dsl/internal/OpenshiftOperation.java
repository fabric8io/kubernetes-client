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

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.OpenShiftClient;
import io.fabric8.kubernetes.client.dsl.ClientResource;

import java.net.URL;

public class OpenshiftOperation<C extends OpenShiftClient, T extends HasMetadata, L extends KubernetesResourceList, D extends Doneable<T>, R extends ClientResource<T, D>>
extends HasMetadataOperation<C,T,L,D,R> {

  protected OpenshiftOperation(C client, String resourceT, String namespace, String name) {
    super(client, resourceT, namespace, name);
  }

  @Override
  public URL getRootUrl() {
    return getClient().getOpenshiftUrl();
  }
}
