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

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Version;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents any {@link KubernetesResource} which possesses a {@link ObjectMeta} and is associated with a kind and API version.
 */
public interface HasMetadata extends KubernetesResource {
  String DNS_LABEL_START = "(?!-)[A-Za-z0-9-]{";
  String DNS_LABEL_END = ",63}(?<!-)";
  String DNS_LABEL_REGEXP = DNS_LABEL_START + 1 + DNS_LABEL_END;
  /**
   * Pattern that checks the format of finalizer identifiers, which should be in {@code <domain name>/<finalizer name>} format.
   */
  Pattern FINALIZER_NAME_MATCHER = Pattern.compile("^((" + DNS_LABEL_REGEXP + "\\.)+" + DNS_LABEL_START + 2 + DNS_LABEL_END + ")/" + DNS_LABEL_REGEXP);
  
  ObjectMeta getMetadata();
  
  void setMetadata(ObjectMeta metadata);
  
  /**
   * Retrieves the kind associated with the specified HasMetadata implementation. If the implementation is annotated with
   * {@link Kind}, the annotation value will be used, otherwise the value will be derived from the class name.
   *
   * @param clazz the HasMetadata implementation whose Kind we want to retrieve
   * @return the kind associated with the specified HasMetadata
   */
  static String getKind(Class<?> clazz) {
    final Kind kind = clazz.getAnnotation(Kind.class);
    return kind != null ? kind.value() : clazz.getSimpleName();
  }
  
  default String getKind() {
    return getKind(getClass());
  }
  
  /**
   * Computes the {@code apiVersion} associated with this HasMetadata implementation. The value is derived from the
   * {@link Group} and {@link Version} annotations.
   *
   * @param clazz the HasMetadata whose {@code apiVersion} we want to compute
   * @return the computed {@code apiVersion} or {@code null} if neither {@link Group} or {@link Version} annotations are present
   * @throws IllegalArgumentException if only one of {@link Group} or {@link Version} is provided
   */
  static String getApiVersion(Class<?> clazz) {
    final String group = getGroup(clazz);
    final String version = getVersion(clazz);
    if (group != null && version != null) {
      return group + "/" + version;
    }
    if (group != null || version != null) {
      throw new IllegalArgumentException("You need to specify both @" + Group.class.getSimpleName() + " and @" + Version.class.getSimpleName() + " annotations if you specify either");
    }
    return null;
  }
  
  /**
   * Retrieves the group associated with the specified HasMetadata as defined by the {@link Group} annotation.
   *
   * @param clazz the HasMetadata whose group we want to retrieve
   * @return the associated group or {@code null} if the HasMetadata is not annotated with {@link Group}
   */
  static String getGroup(Class<?> clazz) {
    final Group group = clazz.getAnnotation(Group.class);
    return group != null ? group.value() : null;
  }
  
  /**
   * Retrieves the version associated with the specified HasMetadata as defined by the {@link Version} annotation.
   *
   * @param clazz the HasMetadata whose version we want to retrieve
   * @return the associated version or {@code null} if the HasMetadata is not annotated with {@link Version}
   */
  static String getVersion(Class<?> clazz) {
    final Version version = clazz.getAnnotation(Version.class);
    return version != null ? version.value() : null;
  }
  
  default String getApiVersion() {
    return getApiVersion(getClass());
  }
  
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
