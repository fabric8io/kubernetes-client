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
package io.fabric8.crd.generator;

import io.fabric8.crd.generator.utils.Types;
import io.fabric8.crd.generator.utils.Types.SpecAndStatus;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.model.Scope;
import io.sundr.model.TypeDef;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomResourceInfo {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomResourceInfo.class);
  public static final boolean DESCRIBE_TYPE_DEFS = false;
  private final String group;
  private final String version;
  private final String kind;
  private final String singular;
  private final String plural;
  private final String[] shortNames;
  private final boolean storage;
  private final boolean served;
  private final Scope scope;
  private final TypeDef definition;
  private final String crClassName;
  private final Optional<String> specClassName;
  private final Optional<String> statusClassName;
  private final String id;
  private final int hash;

  public CustomResourceInfo(String group, String version, String kind, String singular,
    String plural, String[] shortNames, boolean storage, boolean served,
    Scope scope, TypeDef definition, String crClassName,
    String specClassName, String statusClassName) {
    this.group = group;
    this.version = version;
    this.kind = kind;
    this.singular = singular;
    this.plural = plural;
    this.shortNames = shortNames;
    this.storage = storage;
    this.served = served;
    this.scope = scope;
    this.definition = definition;
    this.crClassName = crClassName;
    this.specClassName = Optional.ofNullable(specClassName);
    this.statusClassName = Optional.ofNullable(statusClassName);
    this.id = crdName() + "/" + version;
    this.hash = id.hashCode();
  }

  public boolean storage() {
    return storage;
  }

  public boolean served() {
    return served;
  }

  public String key() {
    return crdName();
  }

  public Scope scope() {
    return scope;
  }

  public String crdName() {
    return plural() + "." + group;
  }

  public String[] shortNames() {
    return shortNames;
  }

  public String singular() {
    return singular;
  }

  public String plural() {
    return plural;
  }

  public String kind() {
    return kind;
  }

  public String version() {
    return version;
  }

  public String group() {
    return group;
  }

  public String crClassName() {
    return crClassName;
  }

  public Optional<String> specClassName() {
    return specClassName;
  }

  public Optional<String> statusClassName() {
    return statusClassName;
  }

  public TypeDef definition() {
    return definition;
  }

  public static CustomResourceInfo fromClass(Class<? extends CustomResource> customResource) {
    try {
      final CustomResource instance = customResource.getDeclaredConstructor().newInstance();

      final String[] shortNames = CustomResource.getShortNames(customResource);

      final TypeDef definition = Types.typeDefFrom(customResource);
      if (DESCRIBE_TYPE_DEFS) {
        Types.output(definition);
      }

      final Scope scope = Types.isNamespaced(definition) ? Scope.NAMESPACED : Scope.CLUSTER;

      SpecAndStatus specAndStatus = Types.resolveSpecAndStatusTypes(definition);
      if (specAndStatus.isUnreliable()) {
        LOGGER.warn("Cannot reliably determine status types for {} because it isn't parameterized with only spec and status types. Status replicas detection will be deactivated.",
          customResource.getCanonicalName());
      }

      return new CustomResourceInfo(instance.getGroup(), instance.getVersion(), instance.getKind(),
        instance.getSingular(), instance.getPlural(), shortNames, instance.isStorage(), instance.isServed(), scope, definition,
        customResource.getCanonicalName(), specAndStatus.getSpecClassName(),
        specAndStatus.getStatusClassName());
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomResourceInfo that = (CustomResourceInfo) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return hash;
  }
}
