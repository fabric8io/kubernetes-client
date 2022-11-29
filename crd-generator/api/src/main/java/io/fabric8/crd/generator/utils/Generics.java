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
package io.fabric8.crd.generator.utils;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Generics utilities borrowed from sundrio's TypedVisitor class.
 */
public class Generics {

  /**
   * Get the underlying class for a type, or null if the type is a variable type.
   *
   * @param type the type
   * @return the underlying class
   */
  private Generics() {
    throw new IllegalStateException("Utility class");
  }

  public static Class<?> getClass(Type type) {
    if (type instanceof Class) {
      return (Class) type;
    } else if (type instanceof ParameterizedType) {
      return getClass(((ParameterizedType) type).getRawType());
    } else if (type instanceof GenericArrayType) {
      Type componentType = ((GenericArrayType) type).getGenericComponentType();
      Class<?> componentClass = getClass(componentType);
      if (componentClass != null) {
        return Array.newInstance(componentClass, 0).getClass();
      } else {
        return null;
      }
    } else {
      return null;
    }
  }

  /**
   * Get the actual type arguments a child class has used to extend a generic base class.
   *
   * @param baseClass the base class
   * @param childClass the child class
   * @param <T> the type of the base class
   * @return a list of the raw classes for the actual type arguments
   */
  public static <T> List<Class> getTypeArguments(Class<T> baseClass,
      Class<? extends T> childClass) {
    Map<Type, Type> resolvedTypes = new LinkedHashMap<>();
    Type type = childClass;
    // start walking up the inheritance hierarchy until we hit baseClass
    while (true) {
      final Class<?> clazz = getClass(type);
      if (clazz == null || clazz.equals(baseClass))
        break;
      if (type instanceof Class) {
        // there is no useful information for us in raw types, so just keep going.
        type = ((Class) type).getGenericSuperclass();
      } else {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Class<?> rawType = (Class) parameterizedType.getRawType();

        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable<?>[] typeParameters = rawType.getTypeParameters();
        for (int i = 0; i < actualTypeArguments.length; i++) {
          resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);
        }

        if (!rawType.equals(baseClass)) {
          type = rawType.getGenericSuperclass();
        }
      }
    }

    // finally, for each actual type argument provided to baseClass, determine (if possible)
    // the raw class for that type argument.
    Type[] actualTypeArguments;
    if (type instanceof Class) {
      actualTypeArguments = ((Class) type).getTypeParameters();
    } else {
      actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
    }
    List<Class> typeArgumentsAsClasses = new ArrayList<>();
    // resolve types by chasing down type variables.
    for (Type baseType : actualTypeArguments) {
      while (resolvedTypes.containsKey(baseType)) {
        baseType = resolvedTypes.get(baseType);
      }
      typeArgumentsAsClasses.add(getClass(baseType));
    }
    return typeArgumentsAsClasses;
  }
}
