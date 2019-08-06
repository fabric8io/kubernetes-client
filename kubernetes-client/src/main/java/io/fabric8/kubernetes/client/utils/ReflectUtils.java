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
