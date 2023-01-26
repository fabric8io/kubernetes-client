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
 * Interface for operations supporting creation from file.
 *
 * @param <T> resource type
 * @param <L> resource list type
 * @param <R> resource operation for resource type
 */
public interface FromFileCreatableOperation<T, L, R extends Resource<T>> extends MixedOperation<T, L, R>,
    FromFileCreatable<FromFileCreatableResource<T>> {
}
