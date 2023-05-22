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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListMeta;
import io.fabric8.kubernetes.api.model.ObjectMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @deprecated use {@link HasMetadata} methods instead
 */
@Deprecated
public class ReflectUtils {
  private ReflectUtils() {
    throw new IllegalStateException("Utility class");
  }

  public static ObjectMeta objectMetadata(Object obj) throws ReflectiveOperationException {
    if (obj == null) {
      return null;
    }
    if (obj instanceof HasMetadata) {
      return ((HasMetadata) obj).getMetadata();
    }
    try {
      Method mdField = obj.getClass().getMethod("getMetadata");
      return (ObjectMeta) mdField.invoke(obj);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectiveOperationException(e);
    }
  }

  public static String namespace(Object obj) throws ReflectiveOperationException {
    if (obj == null) {
      return "";
    }
    return objectMetadata(obj).getNamespace();
  }

  public static ListMeta listMetadata(Object listObj) throws ReflectiveOperationException {
    if (listObj instanceof KubernetesResourceList) {
      return ((KubernetesResourceList<?>) listObj).getMetadata();
    }
    try {
      Method mdField = listObj.getClass().getMethod("getMetadata");
      return (ListMeta) mdField.invoke(listObj);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectiveOperationException(e);
    }
  }

  public static <ApiType> List<ApiType> getItems(Object listObj) throws ReflectiveOperationException {
    if (listObj instanceof KubernetesResourceList) {
      return ((KubernetesResourceList) listObj).getItems();
    }
    try {
      Method getItemsMethod = listObj.getClass().getMethod("getItems");
      return (List<ApiType>) getItemsMethod.invoke(listObj);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectiveOperationException(e);
    }
  }
}
