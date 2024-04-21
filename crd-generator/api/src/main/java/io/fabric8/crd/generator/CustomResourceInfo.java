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
package io.fabric8.crd.generator;

import io.fabric8.crd.generator.utils.Types;
import io.fabric8.crd.generator.utils.Types.SpecAndStatus;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class CustomResourceInfo {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomResourceInfo.class);
  private final String group;
  private final String version;
  private final String kind;
  private final String singular;
  private final String plural;
  private final String[] shortNames;
  private final boolean storage;
  private final boolean served;
  private final boolean deprecated;
  private final String deprecationWarning;
  private final Scope scope;
  private final Class<?> definition;
  private final String crClassName;
  private final String specClassName;
  private final String statusClassName;
  private final String id;
  private final int hash;

  private final String[] annotations;
  private final String[] labels;

  public CustomResourceInfo(String group, String version, String kind, String singular,
      String plural, String[] shortNames, boolean storage, boolean served, boolean deprecated, String deprecationWarning,
      Scope scope, Class<?> definition, String crClassName,
      String specClassName, String statusClassName, String[] annotations, String[] labels) {
    this.group = group;
    this.version = version;
    this.kind = kind;
    this.singular = singular;
    this.plural = plural;
    this.shortNames = shortNames;
    this.storage = storage;
    this.served = served;
    this.deprecated = deprecated;
    this.deprecationWarning = deprecationWarning;
    this.scope = scope;
    this.definition = definition;
    this.crClassName = crClassName;
    this.specClassName = specClassName;
    this.statusClassName = statusClassName;
    this.id = crdName() + "/" + version;
    this.hash = id.hashCode();
    this.annotations = annotations;
    this.labels = labels;
  }

  public boolean storage() {
    return storage;
  }

  public boolean served() {
    return served;
  }

  public boolean deprecated() {
    return deprecated;
  }

  public String deprecationWarning() {
    return deprecationWarning;
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
    return Optional.ofNullable(specClassName);
  }

  public Optional<String> statusClassName() {
    return Optional.ofNullable(statusClassName);
  }

  public Class<?> definition() {
    return definition;
  }

  public String[] annotations() {
    return annotations;
  }

  public String[] labels() {
    return labels;
  }

  public static CustomResourceInfo fromClass(Class<? extends HasMetadata> customResource) {
    try {
      final HasMetadata instance = customResource.getDeclaredConstructor().newInstance();

      final String[] shortNames = CustomResource.getShortNames(customResource);

      final Scope scope = Utils.isResourceNamespaced(customResource) ? Scope.NAMESPACED : Scope.CLUSTER;

      SpecAndStatus specAndStatus = Types.resolveSpecAndStatusTypes(customResource);
      if (specAndStatus.isUnreliable()) {
        LOGGER.warn(
            "Cannot reliably determine status types for {} because it isn't parameterized with only spec and status types. Status replicas detection will be deactivated.",
            customResource.getCanonicalName());
      }

      ResourceDefinitionContext rdc = ResourceDefinitionContext.fromResourceType(customResource);
      String singular = HasMetadata.getSingular(customResource);
      boolean deprecated = CustomResource.getDeprecated(customResource);
      String deprecationWarning = CustomResource.getDeprecationWarning(customResource);
      boolean storage = CustomResource.getStorage(customResource);
      boolean served = CustomResource.getServed(customResource);

      // instance level methods - TODO: deprecate?
      if (instance instanceof CustomResource) {
        CustomResource<?, ?> cr = (CustomResource)instance;
        singular = cr.getSingular();
        deprecated = cr.isDeprecated();
        deprecationWarning = cr.getDeprecationWarning();
        storage = cr.isStorage();
        served = cr.isServed();
      }

      return new CustomResourceInfo(rdc.getGroup(), rdc.getVersion(), rdc.getKind(),
          singular, rdc.getPlural(), shortNames, storage, served,
          deprecated, deprecationWarning,
          scope, customResource,
          customResource.getCanonicalName(), specAndStatus.getSpecClassName(),
          specAndStatus.getStatusClassName(), toStringArray(instance.getMetadata().getAnnotations()),
          toStringArray(instance.getMetadata().getLabels()));
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public static String[] toStringArray(Map<String, String> map) {
    String[] res = new String[map.size()];
    Set<Map.Entry<String, String>> entrySet = map.entrySet();
    int i = 0;
    for (Map.Entry<String, String> e : entrySet) {
      res[i] = e.getKey() + "=" + e.getValue();
      i++;
    }
    return res;
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
