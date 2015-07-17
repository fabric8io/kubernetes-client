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
import io.fabric8.kubernetes.api.model.KubernetesResourceList;

import java.util.Map;

public interface FilteredResourceList<T extends HasMetadata, L extends KubernetesResourceList> {

  L list() throws KubernetesClientException;

  void delete() throws KubernetesClientException;

  FilteredResourceList<T, L> withLabels(Map<String, String> labels) throws KubernetesClientException;

  FilteredResourceList<T, L> withLabel(String key, String value) throws KubernetesClientException;

  FilteredResourceList<T, L> withFields(Map<String, String> labels) throws KubernetesClientException;

  FilteredResourceList<T, L> withField(String key, String value) throws KubernetesClientException;

}
