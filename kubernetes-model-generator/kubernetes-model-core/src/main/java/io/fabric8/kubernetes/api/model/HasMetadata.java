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
import io.fabric8.kubernetes.api.Pluralize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;
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
  Pattern FINALIZER_NAME_MATCHER = Pattern.compile(
      "^((" + DNS_LABEL_REGEXP + "\\.)+" + DNS_LABEL_START + 2 + DNS_LABEL_END + ")/"
          + DNS_LABEL_REGEXP);

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
      throw new IllegalArgumentException(
          "You need to specify both @" + Group.class.getSimpleName() + " and @" + Version.class.getSimpleName()
              + " annotations if you specify either");
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
   * Retrieves the plural form associated with the specified class if annotated with {@link
   * Plural} or computes a default value using the value returned by {@link #getSingular(Class)} as
   * input to {@link Pluralize#toPlural(String)}.
   *
   * @param clazz the CustomResource whose plural form we want to retrieve
   * @return the plural form defined by the {@link Plural} annotation or a computed default value
   */
  static String getPlural(Class<?> clazz) {
    final Plural fromAnnotation = clazz.getAnnotation(Plural.class);
    return (fromAnnotation != null ? fromAnnotation.value().toLowerCase(Locale.ROOT)
        : Pluralize.toPlural(getSingular(clazz)));
  }

  @JsonIgnore
  default String getPlural() {
    return getPlural(getClass());
  }

  /**
   * Retrieves the singular form associated with the specified class as defined by the
   * {@link Singular} annotation or computes a default value (lower-cased version of the value
   * returned by {@link HasMetadata#getKind(Class)}) if the annotation is not present.
   *
   * @param clazz the class whose singular form we want to retrieve
   * @return the singular form defined by the {@link Singular} annotation or a computed default
   *         value
   */
  static String getSingular(Class<?> clazz) {
    final Singular fromAnnotation = clazz.getAnnotation(Singular.class);
    return (fromAnnotation != null ? fromAnnotation.value() : HasMetadata.getKind(clazz))
        .toLowerCase(Locale.ROOT);
  }

  @JsonIgnore
  default String getSingular() {
    return getSingular(getClass());
  }

  static String getFullResourceName(Class<?> clazz) {
    final String plural = getPlural(clazz);
    final String group = getGroup(clazz);
    if (group == null) {
      throw new IllegalArgumentException(
          "Should provide non-null group. Is " + clazz.getName() + " properly annotated with @"
              + Group.class.getSimpleName() + " and/or @" + Version.class.getSimpleName() + "?");
    }
    return getFullResourceName(plural, group);
  }

  static String getFullResourceName(String plural, String group) {
    Objects.requireNonNull(plural);
    Objects.requireNonNull(group);
    return group.isEmpty() ? plural : plural + "." + group;
  }

  @JsonIgnore
  @SuppressWarnings("unused")
  default String getFullResourceName() {
    return getFullResourceName(getClass());
  }

  /**
   * Determines whether this {@code HasMetadata} is marked for deletion or not.
   *
   * @return {@code true} if the cluster marked this {@code HasMetadata} for deletion, {@code false} otherwise
   */
  @JsonIgnore
  default boolean isMarkedForDeletion() {
    final String deletionTimestamp = optionalMetadata().map(ObjectMeta::getDeletionTimestamp)
        .orElse(null);
    return deletionTimestamp != null && !deletionTimestamp.isEmpty();
  }

  /**
   * Determines whether this {@code HasMetadata} holds the specified finalizer.
   *
   * @param finalizer the identifier of the finalizer we want to check
   * @return {@code true} if this {@code HasMetadata} holds the specified finalizer, {@code false} otherwise
   */
  default boolean hasFinalizer(String finalizer) {
    return getFinalizers().contains(finalizer);
  }

  @JsonIgnore
  default List<String> getFinalizers() {
    return optionalMetadata().map(ObjectMeta::getFinalizers).orElse(Collections.emptyList());
  }

  /**
   * Adds the specified finalizer to this {@code HasMetadata} if it's valid. See {@link #isFinalizerValid(String)}.
   *
   * @param finalizer the identifier of the finalizer to add to this {@code HasMetadata} in
   *        {@code <domain name>/<finalizer name>} format.
   * @return {@code true} if the finalizer was successfully added, {@code false} otherwise (in particular, if the object is
   *         marked for deletion)
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
      ObjectMeta metadata = getMetadata();
      if (metadata == null) {
        metadata = new ObjectMeta();
        setMetadata(metadata);
      }
      return metadata.getFinalizers().add(finalizer);
    } else {
      throw new IllegalArgumentException("Invalid finalizer name: '" + finalizer
          + "'. Must consist of a domain name, a forward slash and the valid kubernetes name.");
    }
  }

  /**
   * Determines whether the specified finalizer is valid according to the
   * <a href=
   * 'https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#finalizers'>finalizer
   * specification</a>.
   *
   * @param finalizer the identifier of the finalizer which validity we want to check
   * @return {@code true} if the identifier is valid, {@code false} otherwise
   */
  static boolean validateFinalizer(String finalizer) {
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
   * @see HasMetadata#validateFinalizer(String)
   *
   * @param finalizer the identifier of the finalizer which validity we want to check
   * @return {@code true} if the identifier is valid, {@code false} otherwise
   */
  default boolean isFinalizerValid(String finalizer) {
    return HasMetadata.validateFinalizer(finalizer);
  }

  /**
   * Removes the specified finalizer if it's held by this {@code HasMetadata}.
   *
   * @param finalizer the identifier of the finalizer we want to remove
   * @return {@code true} if the finalizer was successfully removed, {@code false} otherwise
   */
  default boolean removeFinalizer(String finalizer) {
    final List<String> finalizers = getFinalizers();
    return finalizers.contains(finalizer) && finalizers.remove(finalizer);
  }

  /**
   * Checks whether the provided {@code HasMetadata} is defined as an owner for this {@code HasMetadata}.
   *
   * @param owner the {@code HasMetadata} to check for potential ownership
   * @return {@code true} if the provided {@code HasMetadata} is an owner of this instance
   */
  default boolean hasOwnerReferenceFor(HasMetadata owner) {
    return getOwnerReferenceFor(owner).isPresent();
  }

  /**
   * Checks whether the provided UID identifies an owner for this {@code HasMetadata}.
   *
   * @param ownerUid the UID of a {@code HasMetadata} to check for potential ownership
   * @return {@code true} if the provided {@code HasMetadata} is an owner of this instance
   */
  default boolean hasOwnerReferenceFor(String ownerUid) {
    return getOwnerReferenceFor(ownerUid).isPresent();
  }

  /**
   * Retrieves the {@link OwnerReference} associated with the specified owner if it's part of this {@code HasMetadata}'s owners.
   *
   * @param owner the potential owner of which we want to retrieve the associated {@link OwnerReference}
   * @return an {@link Optional} containing the {@link OwnerReference} associated with the specified owner if it exists or
   *         {@link Optional#empty()} otherwise.
   */
  default Optional<OwnerReference> getOwnerReferenceFor(HasMetadata owner) {
    if (owner == null) {
      return Optional.empty();
    }

    final String ownerUID = owner.optionalMetadata().map(ObjectMeta::getUid).orElse(null);
    return getOwnerReferenceFor(ownerUID);
  }

  /**
   * Retrieves the {@link OwnerReference} associated with the owner identified by the specified UID if it's part of
   * this{@code HasMetadata}'s owners.
   *
   * @param ownerUid the UID of the potential owner of which we want to retrieve the associated {@link
   *        OwnerReference}
   * @return an {@link Optional} containing the {@link OwnerReference} associated with the
   *         owner identified by the specified UID if it exists or {@link Optional#empty()} otherwise.
   */
  default Optional<OwnerReference> getOwnerReferenceFor(String ownerUid) {
    if (ownerUid == null || ownerUid.isEmpty()) {
      return Optional.empty();
    }

    return optionalMetadata()
        .map(m -> Optional.ofNullable(m.getOwnerReferences()).orElse(Collections.emptyList()))
        .orElse(Collections.emptyList())
        .stream()
        .filter(o -> ownerUid.equals(o.getUid()))
        .findFirst();
  }

  /**
   * Adds an {@link OwnerReference} to the specified owner if possible.
   *
   * @param owner the owner to add a reference to
   * @return the newly added {@link OwnerReference}
   */
  default OwnerReference addOwnerReference(HasMetadata owner) {
    if (owner == null) {
      throw new IllegalArgumentException("Cannot add a reference to a null owner to "
          + optionalMetadata().map(m -> "'" + m.getName() + "' ").orElse("unnamed ")
          + getKind());
    }

    final ObjectMeta metadata = owner.getMetadata();
    if (metadata == null) {
      throw new IllegalArgumentException("Cannot add a reference to an owner without metadata to "
          + optionalMetadata().map(m -> "'" + m.getName() + "' ").orElse("unnamed ")
          + getKind());
    }

    final OwnerReference ownerReference = new OwnerReferenceBuilder()
        .withUid(metadata.getUid())
        .withApiVersion(owner.getApiVersion())
        .withName(metadata.getName())
        .withKind(owner.getKind())
        .build();
    return addOwnerReference(sanitizeAndValidate(ownerReference));
  }

  /**
   * Adds the specified, supposed valid (for example because validated by calling {@link #sanitizeAndValidate(OwnerReference)}
   * beforehand), {@link OwnerReference} to this {@code HasMetadata}
   *
   * @param ownerReference the {@link OwnerReference} to add to this {@code HasMetadata}'s owner references
   * @return the newly added {@link OwnerReference}
   */
  default OwnerReference addOwnerReference(OwnerReference ownerReference) {
    if (ownerReference == null) {
      throw new IllegalArgumentException("Cannot add a null reference to "
          + optionalMetadata().map(m -> "'" + m.getName() + "' ").orElse("unnamed ")
          + getKind());
    }

    final Optional<OwnerReference> existing = getOwnerReferenceFor(ownerReference.getUid());
    if (existing.isPresent()) {
      return existing.get();
    }

    ObjectMeta metadata = getMetadata();
    if (metadata == null) {
      metadata = new ObjectMeta();
      setMetadata(metadata);
    }
    List<OwnerReference> ownerReferences = metadata.getOwnerReferences();
    if (ownerReferences == null) {
      ownerReferences = new ArrayList<>();
      metadata.setOwnerReferences(ownerReferences);
    }
    ownerReferences.add(ownerReference);
    return ownerReference;
  }

  /**
   * Sanitizes and validates the specified {@link OwnerReference}, presumably to add it
   *
   * @param ownerReference the {@link OwnerReference} to sanitize and validate
   * @return the sanitized and validated {@link OwnerReference} which should be used instead of the original one
   */
  static OwnerReference sanitizeAndValidate(OwnerReference ownerReference) {
    // validate required fields are present
    final StringBuilder error = new StringBuilder(100);
    error.append("Owner is missing required field(s): ");
    final BiFunction<String, String, Optional<String>> trimmedFieldIfValid = (field, value) -> {
      boolean isError = false;
      if (value == null) {
        isError = true;
      } else {
        value = value.trim();
        if (value.isEmpty()) {
          isError = true;
        }
      }
      if (isError) {
        error.append(field).append(" ");
        return Optional.empty();
      } else {
        return Optional.of(value);
      }
    };
    final Supplier<IllegalArgumentException> exceptionSupplier = () -> new IllegalArgumentException(
        error.toString());

    final Optional<String> uid = trimmedFieldIfValid.apply("uid", ownerReference.getUid());
    final Optional<String> apiVersion = trimmedFieldIfValid.apply("apiVersion",
        ownerReference.getApiVersion());
    final Optional<String> name = trimmedFieldIfValid.apply("name", ownerReference.getName());
    final Optional<String> kind = trimmedFieldIfValid.apply("kind", ownerReference.getKind());

    // check that required values are present
    ownerReference = new OwnerReferenceBuilder(ownerReference)
        .withUid(uid.orElseThrow(exceptionSupplier))
        .withApiVersion(apiVersion.orElseThrow(exceptionSupplier))
        .withName(name.orElseThrow(exceptionSupplier))
        .withKind(kind.orElseThrow(exceptionSupplier))
        .build();
    return ownerReference;
  }

  /**
   * Removes the {@link OwnerReference} identified by the specified UID if it's part of this {@code HasMetadata}'s owner
   * references
   *
   * @param ownerUid the UID of the {@link OwnerReference} to remove
   */
  default void removeOwnerReference(String ownerUid) {
    if (ownerUid != null && !ownerUid.isEmpty()) {
      optionalMetadata()
          .map(m -> Optional.ofNullable(m.getOwnerReferences()).orElse(Collections.emptyList()))
          .orElse(Collections.emptyList())
          .removeIf(o -> ownerUid.equals(o.getUid()));
    }
  }

  /**
   * Removes the {@link OwnerReference} associated with the specified owner if it's part of this {@code
   * HasMetadata}'s owner references
   *
   * @param owner the owner whose reference we want to remove
   */
  default void removeOwnerReference(HasMetadata owner) {
    if (owner != null) {
      removeOwnerReference(owner.getMetadata().getUid());
    }
  }

  default Optional<ObjectMeta> optionalMetadata() {
    return Optional.ofNullable(getMetadata());
  }
}
