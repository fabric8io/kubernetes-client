/**
 * Copyright 2018 The original authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 **/

package io.dekorate.kubernetes.decorator;

import io.dekorate.utils.Strings;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class ResourceProvidingDecorator<T> extends Decorator<T> {

  private static final List<String> DEPLOYMENT_KINDS = Arrays
    .asList("Deployment", "DeploymentConfig", "Service",
      "Pipeline", "Task");

  protected static final String ANY = null;

  public boolean contains(KubernetesListBuilder list, String apiVersion, String kind, String name) {
    return list.getItems().stream().filter(i -> match(i, apiVersion, kind, name)).findAny()
      .isPresent();
  }

  public boolean match(HasMetadata h, String apiVersion, String kind, String name) {
    if (Strings.isNotNullOrEmpty(apiVersion) && !apiVersion.equals(h.getApiVersion())) {
      return false;
    }
    if (Strings.isNotNullOrEmpty(kind) && !kind.endsWith(h.getKind())) {
      return false;
    }
    if (Strings.isNotNullOrEmpty(name) && !name.equals(h.getMetadata().getName())) {
      return false;
    }
    return true;
  }

  public Optional<ObjectMeta> getDeploymentMetadata(KubernetesListBuilder list) {
    return list.getItems().stream().filter(h -> DEPLOYMENT_KINDS.contains(h.getKind()))
      .map(HasMetadata::getMetadata)
      .findFirst();
  }

  public Optional<HasMetadata> getDeploymentHasMetadata(KubernetesListBuilder list) {
    return list.getItems().stream().filter(h -> DEPLOYMENT_KINDS.contains(h.getKind())).findFirst();
  }

  public ObjectMeta getMandatoryDeploymentMetadata(KubernetesListBuilder list) {
    return getDeploymentMetadata(list).orElseThrow(() -> new IllegalStateException(
      "Expected at least one of: " + DEPLOYMENT_KINDS.stream().collect(Collectors.joining(","))
        + " to be present."));
  }

  public HasMetadata getMandatoryDeploymentHasMetadata(KubernetesListBuilder list) {
    return getDeploymentHasMetadata(list).orElseThrow(() -> new IllegalStateException(
      "Expected at least one of: " + DEPLOYMENT_KINDS.stream().collect(Collectors.joining(","))
        + " to be present."));
  }
}
