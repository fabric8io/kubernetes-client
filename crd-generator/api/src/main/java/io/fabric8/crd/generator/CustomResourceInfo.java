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

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.model.Scope;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.sundr.codegen.functions.ClassTo;
import io.sundr.codegen.model.TypeDef;
import io.sundr.codegen.model.TypeRef;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Optional;

public class CustomResourceInfo {
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
  private final Optional<String> specClassName;
  private final Optional<String> statusClassName;

  public CustomResourceInfo(String group, String version, String kind, String singular,
    String plural, String[] shortNames, boolean storage, boolean served,
    Scope scope, TypeRef status, TypeDef definition, String crClassName,
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
    this.status = Optional.ofNullable(status);
    this.definition = definition;
    this.crClassName = crClassName;
    this.specClassName = Optional.ofNullable(specClassName);
    this.statusClassName = Optional.ofNullable(statusClassName);
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

  public Optional<String> specClassName() {
    return specClassName;
  }

  public Optional<String> statusClassName() {
    return statusClassName;
  }

  public TypeDef definition() {
    return definition;
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
        .filter(t -> t.getTypeName().equals(Namespaced.class.getTypeName()))
        .findFirst().map(t -> Scope.NAMESPACED).orElse(Scope.CLUSTER);

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
      TypeRef statusType = null;
      if (genericSuperclass instanceof ParameterizedType) {
        final Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (types.length == 2) {
          specClassName = types[0].getTypeName();
          statusClassName = types[1].getTypeName();

          if (!VOID_TYPE_NAME.equals(statusClassName)) {
            // load status class
            final Class<?> statusClass = Thread.currentThread().getContextClassLoader()
              .loadClass(statusClassName);
            statusType = ClassTo.TYPEDEF.apply(statusClass).toReference();
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
