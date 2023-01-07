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

/**
 * @deprecated It is no longer necessary to associate parameters prior to deserialization.
 *             <p>
 *             reference {@link MixedOperation} instead
 *
 * @param <T> The Kubernetes resource type.
 * @param <L> The list variant of the Kubernetes resource type.
 * @param <R> The resource operations.
 */
@Deprecated
public interface ParameterMixedOperation<T, L, R extends Resource<T>>
    extends MixedOperation<T, L, R>, Parameterizable<MixedOperation<T, L, R>> {
}
