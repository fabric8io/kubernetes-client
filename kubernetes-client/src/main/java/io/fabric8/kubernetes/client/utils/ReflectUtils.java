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

import io.fabric8.kubernetes.api.model.ObjectMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectUtils {

  public static ObjectMeta objectMetadata(Object obj) throws ReflectiveOperationException {
    try {
      Method mdField = obj.getClass().getDeclaredMethod("getMetadata");
      return (ObjectMeta) mdField.invoke(obj);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectiveOperationException(e);
    }
  }

  public static String namespace(Object obj) throws ReflectiveOperationException {
    return objectMetadata(obj).getNamespace();
  }

  public static ObjectMeta listMetadata(Object listObj) throws ReflectiveOperationException {
    try {
      Method mdField = listObj.getClass().getDeclaredMethod("getMetadata");
      return (ObjectMeta) mdField.invoke(listObj);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectiveOperationException(e);
    }
  }

  public static <ApiType> List<ApiType> getItems(Object listObj) throws ReflectiveOperationException {
    try {
      Method getItemsMethod = listObj.getClass().getMethod("getItems");
      return (List<ApiType>) getItemsMethod.invoke(listObj);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new ReflectiveOperationException(e);
    }
  }
}
