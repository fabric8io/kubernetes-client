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

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import java.util.Locale;

/**
 * @author <a href="claprun@redhat.com">Christophe Laprun</a>
 */
public interface CustomResourceMetadata<S, T> extends HasMetadata {

  String NAMESPACE_SCOPE = "Namespaced";
  String CLUSTER_SCOPE = "Cluster";

  /**
   * Retrieves the scope name for the specified CustomResourceMetadata class.
   *
   * @param clazz the CustomResourceMetadata whose scope we want to retrieve
   * @return the scope associated with the specified CustomResourceMetadata
   */
  static String getScope(Class<? extends CustomResourceMetadata> clazz) {
    return Utils.isResourceNamespaced(clazz) ? NAMESPACE_SCOPE : CLUSTER_SCOPE;
  }

  /**
   * Retrieves the served status of the specified CustomResource classas determined by its
   * associated {@link io.fabric8.kubernetes.model.annotation.Version} annotation.
   *
   * @param clazz the CustomResourceMetadata whose served status we want to determine
   * @return {@code true} if the specified CustomResourceMetadata is served, {@code false} otherwise
   */
  static boolean getServed(Class<? extends CustomResourceMetadata> clazz) {
    final io.fabric8.kubernetes.model.annotation.Version annotation = clazz.getAnnotation(
      io.fabric8.kubernetes.model.annotation.Version.class);
    return annotation == null || annotation.served();
  }

  /**
   * Retrieves the storage status of the specified CustomResourceMetadata class as determined by its
   * associated {@link io.fabric8.kubernetes.model.annotation.Version} annotation.
   *
   * @param clazz the CustomResourceMetadata whose storage status we want to determine
   * @return {@code true} if the specified CustomResourceMetadata is persisted, {@code false} otherwise
   */
  static boolean getStorage(Class<? extends CustomResourceMetadata> clazz) {
    final io.fabric8.kubernetes.model.annotation.Version annotation = clazz
      .getAnnotation(Version.class);
    return annotation == null || annotation.storage();
  }

  /**
   * Retrieves the plural form associated with the specified CustomResourceMetadata if annotated with {@link
   * Plural} or computes a default value using the value returned by {@link #getSingular(Class)} as
   * input to {@link Pluralize#toPlural(String)}.
   *
   * @param clazz the CustomResourceMetadata whose plural form we want to retrieve
   * @return the plural form defined by the {@link Plural} annotation or a computed default value
   */
  static String getPlural(Class<? extends CustomResourceMetadata> clazz) {
    final Plural fromAnnotation = clazz.getAnnotation(Plural.class);
    return (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT)
      : Pluralize.toPlural(getSingular(clazz)));
  }

  /**
   * Retrieves the singular form associated with the specified CustomResourceMetadata as defined by the
   * {@link Singular} annotation or computes a default value (lower-cased version of the value
   * returned by {@link HasMetadata#getKind(Class)}) if the annotation is not present.
   *
   * @param clazz the CustomResourceMetadata whose singular form we want to retrieve
   * @return the singular form defined by the {@link Singular} annotation or a computed default
   * value
   */
  static String getSingular(Class<? extends CustomResourceMetadata> clazz) {
    final Singular fromAnnotation = clazz.getAnnotation(Singular.class);
    return (fromAnnotation != null ? fromAnnotation.value() : HasMetadata.getKind(clazz))
      .toLowerCase(Locale.ROOT);
  }

  /**
   * Computes the name of the Custom Resource Definition (CRD) associated with the specified
   * CustomResourceMetadata. See https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/
   * for more details.
   *
   * @param clazz the CustomResourceMetadata whose CRD name we want to compute
   * @return the CRD name associated with the CustomResourceMetadata
   */
  static String getCRDName(Class<? extends CustomResourceMetadata> clazz) {
    return getCRDName(getPlural(clazz), HasMetadata.getGroup(clazz));
  }

  static String getCRDName(String plural, String group) {
    return plural + "." + group;
  }

  @JsonIgnore
  default String getPlural() {
    return getPlural(getClass());
  }

  @JsonIgnore
  default String getSingular() {
    return getSingular(getClass());
  }


  @JsonIgnore
  default String getCRDName() {
    return getCRDName(getClass());
  }

  /**
   * Retrieves the scope that this CustomResource targets
   *
   * @return the scope that this CustomResource targets. Possible values are {@link #CLUSTER_SCOPE}
   * or {@link #NAMESPACE_SCOPE}.
   */
  @JsonIgnore
  default String getScope() {
    return getScope(getClass());
  }

  @JsonIgnore
  default String getGroup() {
    return HasMetadata.getGroup(getClass());
  }

  @JsonIgnore
  default String getVersion() {
    return HasMetadata.getVersion(getClass());
  }

  @JsonIgnore
  default boolean isServed() {
    return getServed(getClass());
  }

  @JsonIgnore
  default boolean isStorage() {
    return getStorage(getClass());
  }

  S getSpec();

  T getStatus();
}
