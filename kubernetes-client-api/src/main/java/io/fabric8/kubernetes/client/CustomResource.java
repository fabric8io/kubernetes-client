/*
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.Scope;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;

import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

/**
 * A base class for implementing a custom resource kind. Implementations must be annotated with
 * {@link io.fabric8.kubernetes.model.annotation.Group} and {@link io.fabric8.kubernetes.model.annotation.Version}.
 *
 * Properties are set up automatically as follows:
 * <ul>
 * <li>group is set using {@link io.fabric8.kubernetes.api.model.HasMetadata#getGroup(Class)}</li>
 * <li>version is set using {@link io.fabric8.kubernetes.api.model.HasMetadata#getVersion(Class)}</li>
 * <li>singular is set using {@link io.fabric8.kubernetes.api.model.HasMetadata#getSingular(Class)}</li>
 * <li>plural is set using {@link io.fabric8.kubernetes.api.model.HasMetadata#getPlural(Class)}</li>
 * <li>computed CRD name using {@link CustomResource#getCRDName(Class)}</li>
 * </ul>
 *
 * In addition, {@link CustomResource#setApiVersion(String)} and {@link CustomResource#setKind(String)} are overridden to not do
 * anything since these values
 * are set.
 *
 * @param <S> the class providing the {@code Spec} part of this CustomResource
 * @param <T> the class providing the {@code Status} part of this CustomResource
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "spec",
    "status"
})
@JsonInclude(Include.NON_NULL)
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
})
public abstract class CustomResource<S, T> implements HasMetadata {
  private static final Logger LOG = LoggerFactory.getLogger(CustomResource.class);

  private ObjectMeta metadata = new ObjectMeta();

  @JsonProperty("spec")
  protected S spec;

  @JsonProperty("status")
  protected T status;

  private final String singular;
  private final String crdName;
  @JsonProperty(access = Access.READ_ONLY)
  private final String kind;
  @JsonProperty(access = Access.READ_ONLY)
  private final String apiVersion;
  private final String scope;
  private final String plural;
  private final boolean served;
  private final boolean storage;
  private final boolean deprecated;
  private final String deprecationWarning;

  public CustomResource() {
    final String version = HasMetadata.super.getApiVersion();
    final Class<? extends CustomResource> clazz = getClass();
    if (isNullOrEmpty(version)) {
      throw new IllegalArgumentException(clazz.getName() + " CustomResource must provide an API version using @"
          + Group.class.getName() + " and @" + Version.class.getName() + " annotations");
    }
    this.apiVersion = version;
    this.kind = HasMetadata.super.getKind();
    scope = this instanceof Namespaced ? Scope.NAMESPACED.value() : Scope.CLUSTER.value();
    this.singular = HasMetadata.super.getSingular();
    this.plural = HasMetadata.super.getPlural();
    this.crdName = getCRDName(clazz);
    this.served = getServed(clazz);
    this.storage = getStorage(clazz);
    this.deprecated = getDeprecated(clazz);
    this.deprecationWarning = getDeprecationWarning(clazz);
    this.spec = initSpec();
    this.status = initStatus();
  }

  public static boolean getServed(Class<?> clazz) {
    final Version annotation = clazz.getAnnotation(Version.class);
    return annotation == null || annotation.served();
  }

  public static boolean getStorage(Class<?> clazz) {
    final Version annotation = clazz.getAnnotation(Version.class);
    return annotation == null || annotation.storage();
  }

  public static boolean getDeprecated(Class<?> clazz) {
    final Version annotation = clazz.getAnnotation(Version.class);
    return annotation == null || annotation.deprecated();
  }

  public static String getDeprecationWarning(Class<?> clazz) {
    final Version annotation = clazz.getAnnotation(Version.class);
    return annotation != null && Utils.isNotNullOrEmpty(annotation.deprecationWarning())
        ? annotation.deprecationWarning()
        : null;
  }

  /**
   * Override to provide your own Spec instance
   *
   * @return a new Spec instance or {@code null} if the responsibility of instantiating the Spec is left to users of this
   *         CustomResource
   */
  protected S initSpec() {
    return null;
  }

  /**
   * Override to provide your own Status instance
   *
   * @return a new Status instance or {@code null} if the responsibility of instantiating the Status is left to users of this
   *         CustomResource
   */
  protected T initStatus() {
    return null;
  }

  @Override
  public String toString() {
    return "CustomResource{" +
        "kind='" + getKind() + '\'' +
        ", apiVersion='" + getApiVersion() + '\'' +
        ", metadata=" + metadata +
        ", spec=" + spec +
        ", status=" + status +
        ", deprecated=" + deprecated +
        ", deprecationWarning=" + deprecationWarning +
        '}';
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public void setApiVersion(String version) {
    // already set in constructor
    LOG.debug(
        "Calling CustomResource#setApiVersion doesn't do anything because the API version is computed and shouldn't be changed");
  }

  @Override
  public String getKind() {
    return this.kind;
  }

  public void setKind(String kind) {
    // already set in constructor
    LOG.debug("Calling CustomResource#setKind doesn't do anything because the Kind is computed and shouldn't be changed");
  }

  @Override
  public ObjectMeta getMetadata() {
    return metadata;
  }

  @Override
  public void setMetadata(ObjectMeta metadata) {
    this.metadata = metadata;
  }

  /**
   * @deprecated use {@link HasMetadata#getPlural(Class)} instead
   */
  @Deprecated
  public static String getPlural(Class<?> clazz) {
    return HasMetadata.getPlural(clazz);
  }

  @Override
  @JsonIgnore
  public String getPlural() {
    return plural;
  }

  /**
   * @deprecated use {@link HasMetadata#getSingular(Class)} instead
   */
  @Deprecated
  public static String getSingular(Class<?> clazz) {
    return HasMetadata.getSingular(clazz);
  }

  @Override
  @JsonIgnore
  public String getSingular() {
    return singular;
  }

  /**
   * Computes the name of the Custom Resource Definition (CRD) associated with the specified CustomResource.
   * See https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/ for more details.
   *
   * @param clazz the CustomResource whose CRD name we want to compute
   * @return the CRD name associated with the CustomResource
   */
  public static String getCRDName(Class<?> clazz) {
    return HasMetadata.getFullResourceName(clazz);
  }

  @JsonIgnore
  public String getCRDName() {
    return crdName;
  }

  /**
   * Retrieves the short names associated with this CustomResource or an empty array if none was provided
   *
   * @param clazz the CustomResource class which short names we want to retrieve
   * @return the short names associated with this CustomResource or an empty array if none was provided
   */
  public static String[] getShortNames(Class<?> clazz) {
    return Optional.ofNullable(clazz.getAnnotation(ShortNames.class))
        .map(ShortNames::value)
        .orElse(new String[] {});
  }

  /**
   * Retrieves the scope that this CustomResource targets
   *
   * @return the scope that this CustomResource targets. Possible values are {@link Scope#CLUSTER} or {@link Scope#NAMESPACED}.
   */
  @JsonIgnore
  public String getScope() {
    return scope;
  }

  @JsonIgnore
  public String getGroup() {
    return HasMetadata.getGroup(getClass());
  }

  @JsonIgnore
  public String getVersion() {
    return HasMetadata.getVersion(getClass());
  }

  @JsonIgnore
  public boolean isServed() {
    return served;
  }

  @JsonIgnore
  public boolean isStorage() {
    return storage;
  }

  @JsonIgnore
  public boolean isDeprecated() {
    return deprecated;
  }

  @JsonIgnore
  public String getDeprecationWarning() {
    return deprecationWarning;
  }

  public S getSpec() {
    return spec;
  }

  public void setSpec(S spec) {
    this.spec = spec;
  }

  public T getStatus() {
    return status;
  }

  public void setStatus(T status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof CustomResource))
      return false;

    CustomResource<?, ?> that = (CustomResource<?, ?>) o;

    if (served != that.served)
      return false;
    if (storage != that.storage)
      return false;
    if (deprecated != that.deprecated)
      return false;
    if (!Objects.equals(deprecationWarning, that.deprecationWarning))
      return false;
    if (!metadata.equals(that.metadata))
      return false;
    if (!Objects.equals(spec, that.spec))
      return false;
    if (!Objects.equals(status, that.status))
      return false;
    if (!singular.equals(that.singular))
      return false;
    if (!crdName.equals(that.crdName))
      return false;
    if (!kind.equals(that.kind))
      return false;
    if (!apiVersion.equals(that.apiVersion))
      return false;
    if (!scope.equals(that.scope))
      return false;
    return plural.equals(that.plural);
  }

  @Override
  public int hashCode() {
    int result = metadata.hashCode();
    result = 31 * result + (spec != null ? spec.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + singular.hashCode();
    result = 31 * result + crdName.hashCode();
    result = 31 * result + kind.hashCode();
    result = 31 * result + apiVersion.hashCode();
    result = 31 * result + scope.hashCode();
    result = 31 * result + plural.hashCode();
    result = 31 * result + (served ? 1 : 0);
    result = 31 * result + (storage ? 1 : 0);
    result = 31 * result + (deprecated ? 1 : 0);
    result = 31 * result + (deprecationWarning != null ? deprecationWarning.hashCode() : 0);
    return result;
  }
}
