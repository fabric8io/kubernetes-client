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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KubernetesClientTimeoutException extends KubernetesClientException {

  private static final String RESOURCE_FORMAT = "Timed out waiting for [%d] milliseconds for [%s] with name:[%s] in namespace [%s].";
  private static final String KNOWS_RESOURCES_FORMAT = "Timed out waiting for [%d] milliseconds for multiple resources. %s";

  private final List<HasMetadata> resourcesNotReady;

  public KubernetesClientTimeoutException(HasMetadata resource, long amount, TimeUnit timeUnit) {
    super(String.format(RESOURCE_FORMAT, timeUnit.toMillis(amount), resource.getKind(), resource.getMetadata().getName(), resource.getMetadata().getNamespace()));
    this.resourcesNotReady = Collections.unmodifiableList(Arrays.asList(resource));
  }

  public KubernetesClientTimeoutException(Collection<HasMetadata> resourcesNotReady, long amount, TimeUnit timeUnit) {
    super(String.format(KNOWS_RESOURCES_FORMAT, timeUnit.toMillis(amount), notReadyToString(resourcesNotReady)));
    this.resourcesNotReady = Collections.unmodifiableList(new ArrayList<>(resourcesNotReady));
  }

  public List<HasMetadata> getResourcesNotReady() {
    return resourcesNotReady;
  }

  /**
   * Creates a string listing all the resources that are not ready.
   * @param resources The resources that are not ready.
   * @return
     */
  private static String notReadyToString(Iterable<HasMetadata> resources) {
    StringBuilder sb = new StringBuilder();
    sb.append("Resources that are not ready: ");
    boolean first = true;
    for (HasMetadata r : resources) {
      if (first) {
        first = false;
      } else {
        sb.append(", ");
      }
      sb.append("[Kind:").append(r.getKind())
        .append(" Name:").append(r.getMetadata().getName())
        .append(" Namespace:").append(r.getMetadata().getNamespace())
        .append("]");
    }
    return sb.toString();
  }
}
