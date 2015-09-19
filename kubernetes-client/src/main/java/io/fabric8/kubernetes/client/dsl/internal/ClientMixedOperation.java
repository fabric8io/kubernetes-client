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

import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;

/**
 * A Client Namespace or Non Namespace Operation. This acts as an umbrella for {@link io.fabric8.kubernetes.client.dsl.ClientOperation} and {@link io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation}.
 * Its not intended to be exposed directly into the client and is only usable as a convinient interface internally.
 *
 * @param <C> The type of {@link io.fabric8.kubernetes.client.Client}.
 * @param <T> The Kubernetes resource type.
 * @param <L> The list variant of the Kubernetes resource type.
 * @param <D> The doneable variant of the Kubernetes resource type.
 * @param <R> The resource operations.
 */
public interface ClientMixedOperation<C extends Client, T, L, D, R extends ClientResource<T, D>>
  extends ClientResource<T, D>,
  ClientOperation<C, T, L, D, R>,
  ClientNonNamespaceOperation<C, T, L, D, R> {
}
