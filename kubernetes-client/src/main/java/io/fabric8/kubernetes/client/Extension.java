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

/**
 * An Extension to the KubernetesClient.
 * The {@link io.fabric8.kubernetes.client.KubernetesClient} can be "adapted" to any Extension as long as there is an {@link io.fabric8.kubernetes.client.ExtensionAdapter}
 * available via {@link java.util.ServiceLoader}.
 */
public interface Extension extends KubernetesClient {
}
