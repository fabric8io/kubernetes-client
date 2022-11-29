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

import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.function.Predicate;

public class Metadata {
  private Metadata() {
    throw new IllegalStateException("Utility class");
  }

  public static Optional<String> getKind(Builder builder) {
    try {
      Method method = builder.getClass().getMethod("getKind");
      Object o = method.invoke(builder);
      if (o instanceof String) {
        return Optional.of((String) o);
      }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      //ignore
    }
    return Optional.empty();
  }

  public static Optional<ObjectMeta> getMetadata(Builder builder) {
    try {
      Method method = builder.getClass().getMethod("buildMetadata");
      Object o = method.invoke(builder);
      if (o instanceof ObjectMeta) {
        return Optional.of((ObjectMeta) o);
      }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      //ignore
    }
    return Optional.empty();
  }

  public static boolean addToLabels(Builder builder, String key, String value) {
    try {
      Method editMethod = builder.getClass().getMethod("editOrNewMetadata");
      Object o = editMethod.invoke(builder);
      if (o instanceof ObjectMetaFluent) {
        ObjectMetaFluent fluent = (ObjectMetaFluent) o;
        fluent.addToLabels(key, value);
        Method endMethod = fluent.getClass().getMethod("endMetadata");
        endMethod.invoke(fluent);
        return true;
      }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      //ignore
    }
    return false;
  }

  public static boolean removeFromLabels(Builder builder, String key) {
    try {
      Method editMethod = builder.getClass().getMethod("editOrNewMetadata");
      Object o = editMethod.invoke(builder);
      if (o instanceof ObjectMetaFluent) {
        ObjectMetaFluent fluent = (ObjectMetaFluent) o;
        fluent.removeFromLabels(key);
        Method endMethod = fluent.getClass().getMethod("endMetadata");
        endMethod.invoke(fluent);
        return true;
      }
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      //ignore
    }
    return false;
  }

  /**
   * Create a {@link Predicate} that checks that a resource builder doesn't match the name and kind.
   *
   * @param candidate The specified resource.
   * @return The predicate.
   */
  public static Predicate<VisitableBuilder<? extends HasMetadata, ?>> matching(
      HasMetadata candidate) {
    return matching(candidate.getApiVersion(), candidate.getKind(),
        candidate.getMetadata().getName());
  }

  /**
   * Create a {@link Predicate} that checks that a resource builder doesn't match the name and kind.
   *
   * @param apiVersion the API version the resources must match
   * @param kind The specified kind.
   * @param name The specified name.
   * @return The predicate.
   */
  public static Predicate<VisitableBuilder<? extends HasMetadata, ?>> matching(String apiVersion,
      String kind, String name) {
    return builder -> {
      HasMetadata item = builder.build();
      ObjectMeta metadata = item.getMetadata();
      return apiVersion.equals(item.getApiVersion()) &&
          kind != null && kind.equals(item.getKind()) &&
          name != null && name.equals(metadata.getName());
    };
  }
}
