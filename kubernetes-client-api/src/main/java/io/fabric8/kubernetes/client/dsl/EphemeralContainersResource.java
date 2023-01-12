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
package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.api.model.Pod;

/**
 * Operations for Pod Ephemeral Containers. Ephemeral containers are a special type of container that runs temporarily
 * in an existing Pod to accomplish user-initiated actions such as troubleshooting. You use ephemeral containers to
 * inspect services rather than to build applications.
 *
 * @see <a href="https://kubernetes.io/docs/concepts/workloads/pods/ephemeral-containers/">About Ephemeral Containers</a>
 * @see <a href=
 *      "hhttps://kubernetes.io/docs/reference/generated/kubernetes-api/v1.26/#-strong-ephemeralcontainers-operations-pod-v1-core-strong-">Ephemeral
 *      Containers Operations</a>
 */
public interface EphemeralContainersResource extends EditReplacePatchable<Pod> {
}
