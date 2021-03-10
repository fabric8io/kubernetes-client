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

import io.fabric8.crd.generator.apt.Scope;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;

public class CustomResourceInfo {
  private static final String CUSTOM_RESOURCE_NAME = CustomResource.class.getCanonicalName();

  private final String group;
  private final String version;
  private final String kind;
  private final String singular;
  private final String plural;
  private final String[] shortNames;
  private final boolean storage;
  private final boolean served;
  private final Scope scope;
  private final Optional<TypeRef> status;
  private final TypeDef definition;
  private final String crClassName;
  private final String specClassName;
  private final String statusClassName;

  public CustomResourceInfo(String group, String version, String kind, String singular,
    String plural, String[] shortNames, boolean storage, boolean served,
    Scope scope, Optional<TypeRef> status, TypeDef definition, String crClassName,
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
    this.status = status;
    this.definition = definition;
    this.crClassName = crClassName;
    this.specClassName = specClassName;
    this.statusClassName = statusClassName;
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

  public Optional<TypeRef> status() {
    return status;
  }

  public String crClassName() {
    return crClassName;
  }

  public String specClassName() {
    return specClassName;
  }

  public String statusClassName() {
    return statusClassName;
  }

  public TypeDef definition() {
    return definition;
  }

  public static CustomResourceInfo fromTypeElement(TypeElement customResource) {
    final DeclaredType superclass = (DeclaredType) customResource.getSuperclass();
    final Name crClassName = customResource.getQualifiedName();
    if (superclass.asElement().toString().equals(CUSTOM_RESOURCE_NAME)) {
      final List<? extends TypeMirror> typeArguments = superclass.getTypeArguments();
      if (typeArguments.size() != 2) {
        System.out.println("Ignoring " + crClassName + " because it isn't parameterized");
        return null;
      }
      final TypeElement spec = ((TypeElement) ((DeclaredType) typeArguments.get(0)).asElement());
      Optional<TypeRef> statusType;
      final TypeElement status = ((TypeElement) ((DeclaredType) typeArguments.get(1)).asElement());
      if (!status.getQualifiedName().contentEquals(Void.class.getCanonicalName())) {
        statusType = Optional.of(ElementTo.TYPEDEF.apply(status).toReference());
      } else {
        statusType = Optional.empty();
      }

      final String group = customResource.getAnnotation(Group.class).value();
      final String version = customResource.getAnnotation(Version.class).value();

      final String kind = Optional.ofNullable(customResource.getAnnotation(Kind.class))
        .map(Kind::value)
        .orElse(customResource.getSimpleName().toString());

      final String singular = Optional.ofNullable(customResource.getAnnotation(Singular.class))
        .map(Singular::value)
        .orElse(kind.toLowerCase(Locale.ROOT));

      final String plural = Optional.ofNullable(customResource.getAnnotation(Plural.class))
        .map(Plural::value)
        .map(s -> s.toLowerCase(Locale.ROOT))
        .orElse(Pluralize.toPlural(singular));

      final String[] shortNames = Optional.ofNullable(customResource.getAnnotation(ShortNames.class))
        .map(ShortNames::value)
        .orElse(new String[]{});

      final boolean storage = customResource.getAnnotation(Version.class).storage();
      final boolean served = customResource.getAnnotation(Version.class).served();

      final Scope scope = customResource.getInterfaces().stream()
        .filter(t -> t.toString().equals(Namespaced.class.getTypeName()))
        .map(t -> Scope.Namespaced).findFirst().orElse(Scope.Cluster);

      final TypeDef definition = ElementTo.TYPEDEF.apply(customResource);

      return new CustomResourceInfo(group, version, kind, singular, plural, shortNames, storage, served, scope, statusType, definition, crClassName.toString(), spec.getQualifiedName().toString(), status.getQualifiedName().toString());
    } else {
      System.out.println(
        "Ignoring " + crClassName + " because it doesn't extend " + CUSTOM_RESOURCE_NAME);
      return null;
    }
  }
}
