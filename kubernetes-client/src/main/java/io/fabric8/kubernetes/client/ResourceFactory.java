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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.Resource;
import okhttp3.OkHttpClient;

/**
 * A Factory class for {@link Resource}.
 * @param <O> The operation type.
 */
public interface ResourceFactory<O extends Resource> {

  Class<O> getResourceType();

  /**
   * Create a new operation for the specified items.
   * @param client        An instance of the http client.
   * @param config        The client config.
   * @param namespace     The target namespace.
   * @param items         The resources to use.
   * @return              The created operation.
   */
  O create(OkHttpClient client, Config config, String namespace, HasMetadata... items);
}
