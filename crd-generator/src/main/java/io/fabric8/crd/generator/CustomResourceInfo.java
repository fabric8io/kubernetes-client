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
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.utils.Pluralize;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.functions.ElementTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
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
      final TypeElement status = ((TypeElement) ((DeclaredType) typeArguments.get(1)).asElement());
      Optional<TypeRef> statusType = Optional.empty();
      if (!status.getQualifiedName().contentEquals(Void.class.getCanonicalName())) {
        statusType = Optional.of(ElementTo.TYPEDEF.apply(status).toReference());
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

  private final static String TYPE_NAME = CustomResource.class.getTypeName();
  private final static String VOID_TYPE_NAME = Void.class.getTypeName();


  public static CustomResourceInfo fromClass(Class<? extends CustomResource> customResource) {
    try {
      final CustomResource instance = customResource.getDeclaredConstructor().newInstance();

      final String[] shortNames = Optional.ofNullable(customResource.getAnnotation(ShortNames.class))
        .map(ShortNames::value)
        .orElse(new String[]{});

      final Scope scope = Arrays.stream(customResource.getInterfaces())
        .filter(t -> t.toString().equals(Namespaced.class.getTypeName()))
        .map(t -> Scope.Namespaced).findFirst().orElse(Scope.Cluster);

      final TypeDef definition = ClassTo.TYPEDEF.apply(customResource);
      
      // walk the type hierarchy until we reach CustomResource or a ParameterizedType
      Type genericSuperclass = customResource.getGenericSuperclass();
      String typeName = genericSuperclass.getTypeName();
      while (!TYPE_NAME.equals(typeName) && !(genericSuperclass instanceof ParameterizedType)) {
        genericSuperclass = ((Class) genericSuperclass).getGenericSuperclass();
        typeName = genericSuperclass.getTypeName();
      }

      // this works because CustomResource is an abstract class
      String specClassName = null, statusClassName = null;
      Optional<TypeRef> statusType = Optional.empty();
      if (genericSuperclass instanceof ParameterizedType) {
        final Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (types.length == 2) {
          specClassName = types[0].getTypeName();
          statusClassName = types[1].getTypeName();

          if (!VOID_TYPE_NAME.equals(statusClassName)) {
            // load status class
            final Class<?> statusClass = Thread.currentThread().getContextClassLoader()
              .loadClass(statusClassName);
            statusType = Optional.of(ClassTo.TYPEDEF.apply(statusClass).toReference());
          } 
        }
      }

      return new CustomResourceInfo(instance.getGroup(), instance.getVersion(), instance.getKind(),
        instance.getSingular(), instance.getPlural(), shortNames, instance.isStorage(), instance.isServed(), scope, statusType, definition,
        customResource.getCanonicalName(), specClassName, statusClassName);
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
}
