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
package io.fabric8.kubernetes.api.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface HasMetadata extends KubernetesResource {
  String DNS_NAME_REGEXP = "(?!-)[A-Za-z0-9-]{1,63}(?<!-)";
  Matcher DOMAIN_NAME_MATCHER = Pattern.compile("^(" + DNS_NAME_REGEXP + "\\.)+[A-Za-z]{2,6}/" + DNS_NAME_REGEXP).matcher("");
  
  ObjectMeta getMetadata();
  
  void setMetadata(ObjectMeta metadata);
  
  String getKind();
  
  String getApiVersion();
  
  void setApiVersion(String version);
  
  /**
   * Determines whether this {@code HasMetadata} is marked for deletion or not.
   *
   * @return {@code true} if the cluster marked this {@code HasMetadata} for deletion, {@code false} otherwise
   */
  @JsonIgnore
  default boolean isMarkedForDeletion() {
    final String deletionTimestamp = getMetadata().getDeletionTimestamp();
    return deletionTimestamp != null && !deletionTimestamp.isEmpty();
  }
  
  /**
   * Determines whether this {@code HasMetadata} holds the specified finalizer.
   *
   * @param finalizer the identifier of the finalizer we want to check
   * @return {@code true} if this {@code HasMetadata} holds the specified finalizer, {@code false} otherwise
   */
  default boolean hasFinalizer(String finalizer) {
    return getMetadata().getFinalizers().contains(finalizer);
  }
  
  /**
   * Adds the specified finalizer to this {@code HasMetadata}.
   * <p>
   * See https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#finalizers for more details.
   *
   * @param finalizer the identifier of the finalizer to add to this {@code HasMetadata} in {@code <domain name>/<finalizer name>} format.
   * @return {@code true} if the finalizer was successfully added, {@code false} otherwise (in particular, if the object is marked for deletion)
   * @throws IllegalArgumentException if the specified is null or is invalid
   */
  default boolean addFinalizer(String finalizer) {
    if (finalizer == null) {
      throw new IllegalArgumentException("Must pass a non-null finalizer.");
    }
    if (isMarkedForDeletion() || hasFinalizer(finalizer)) {
      return false;
    }
    if (DOMAIN_NAME_MATCHER.reset(finalizer).matches()) {
      return getMetadata().getFinalizers().add(finalizer);
    } else {
      throw new IllegalArgumentException("Invalid finalizer name: '" + finalizer + "'. Must consist of a domain name, a forward slash and the valid kubernetes name.");
    }
  }
  
  /**
   * Removes the specified finalizer if it's held by this {@code HasMetadata}.
   *
   * @param finalizer the identifier of the finalizer we want to remove
   * @return {@code true} if the finalizer was successfully removed, {@code false} otherwise
   */
  default boolean removeFinalizer(String finalizer) {
    return getMetadata().getFinalizers().remove(finalizer);
  }
}
