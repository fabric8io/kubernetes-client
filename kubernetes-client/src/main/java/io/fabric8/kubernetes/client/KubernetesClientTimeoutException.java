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

import java.util.concurrent.TimeUnit;

public class KubernetesClientTimeoutException extends KubernetesClientException {

  private static final String RESOURCE_FORMAT = "Timed out waiting for [] milliseconds for [%s] with name:[%s] in namespace [%s].";
  private static final String RESOURCES_FORMAT = "Timed out waiting for [] milliseconds for multiple resources in namespace [%s].";

  public KubernetesClientTimeoutException(String kind, String name, String namespace, long amount, TimeUnit timeUnit) {
    super(String.format(RESOURCE_FORMAT, kind, name, namespace, timeUnit.toMillis(amount)));
  }

  public KubernetesClientTimeoutException(String namespace, long amount, TimeUnit timeUnit) {
    super(String.format(RESOURCES_FORMAT, namespace, timeUnit.toMillis(amount)));
  }
}
