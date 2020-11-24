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
  String DNS_LABEL_START = "(?!-)[A-Za-z0-9-]{";
  String DNS_LABEL_END = ",63}(?<!-)";
  String DNS_LABEL_REGEXP = DNS_LABEL_START + 1 + DNS_LABEL_END;
  Pattern FINALIZER_NAME_MATCHER = Pattern.compile("^((" + DNS_LABEL_REGEXP + "\\.)+" + DNS_LABEL_START + 2 + DNS_LABEL_END + ")/" + DNS_LABEL_REGEXP);
  
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
   * Adds the specified finalizer to this {@code HasMetadata} if it's valid. See {@link #isFinalizerValid(String)}.
   *
   * @param finalizer the identifier of the finalizer to add to this {@code HasMetadata} in {@code <domain name>/<finalizer name>} format.
   * @return {@code true} if the finalizer was successfully added, {@code false} otherwise (in particular, if the object is marked for deletion)
   * @throws IllegalArgumentException if the specified finalizer identifier is null or is invalid
   */
  default boolean addFinalizer(String finalizer) {
    if (finalizer == null || finalizer.trim().isEmpty()) {
      throw new IllegalArgumentException("Must pass a non-null, non-blank finalizer.");
    }
    if (isMarkedForDeletion() || hasFinalizer(finalizer)) {
      return false;
    }
    if (isFinalizerValid(finalizer)) {
      return getMetadata().getFinalizers().add(finalizer);
    } else {
      throw new IllegalArgumentException("Invalid finalizer name: '" + finalizer + "'. Must consist of a domain name, a forward slash and the valid kubernetes name.");
    }
  }
  
  /**
   * Determines whether the specified finalizer is valid according to the
   * <a href='https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#finalizer'>finalizer specification</a>.
   * 
   * @param finalizer the identifier of the finalizer which validity we want to check
   * @return {@code true} if the identifier is valid, {@code false} otherwise
   */
  default boolean isFinalizerValid(String finalizer) {
    if (finalizer == null) {
      return false;
    }
    final Matcher matcher = FINALIZER_NAME_MATCHER.matcher(finalizer);
    if (matcher.matches()) {
      final String group = matcher.group(1);
      return group.length() < 256;
    } else {
      return false;
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
