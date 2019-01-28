package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.HasMetadata;

public class ApiVersionUtil {

    /**
   * Extracts apiGroupName from apiGroupVersion when in resource for apiGroupName/apiGroupVersion combination
   * @param item      resource which is being used
   * @param apiGroup  apiGroupName present if any
   * @return          Just the apiGroupName part without apiGroupVersion
   */
  public static <T> String apiGroup(T item, String apiGroup) {
        if (item instanceof HasMetadata && Utils.isNotNullOrEmpty(((HasMetadata) item).getApiVersion())) {
      return trimGroupOrNull(((HasMetadata) item).getApiVersion());
    } else if (apiGroup != null && !apiGroup.isEmpty()) {
      return trimGroup(apiGroup);
    }
    return null;
  }

  /**
   * Returns the api version falling back to the items apiGroupVersion if not null.
   * @param <T>
   * @param item
   * @param apiVersion
   * @return
   */
  public static <T> String apiVersion(T item, String apiVersion) {
    if (item instanceof HasMetadata && Utils.isNotNullOrEmpty(((HasMetadata) item).getApiVersion())) {
      return trimVersion(((HasMetadata) item).getApiVersion());
    } else if (apiVersion != null && !apiVersion.isEmpty()) {
      return trimVersion(apiVersion);
    }
    return null;
  }

  /**
   * Separates apiGroupVersion for apiGroupName/apiGroupVersion combination.
   * @param apiVersion  The apiGroupVersion or apiGroupName/apiGroupVersion combo.
   * @return            Just the apiGroupVersion part without the apiGroupName.
   */
  private static String trimVersion(String apiVersion) {
    if (apiVersion != null && apiVersion.contains("/")) {
      String[] versionParts = apiVersion.split("/");
      return versionParts[versionParts.length - 1];
    }
    return apiVersion;
  }

   /**
   * Separates apiGroupName for apiGroupName/apiGroupVersion combination.
   * @param apiVersion  The apiGroupVersion or apiGroupName/apiGroupVersion combo.
   * @return            Just the apiGroupName part without the apiGroupName, or apiVersion if no separator is found.
   */
  private static String trimGroup(String apiVersion) {
    if (apiVersion != null && apiVersion.contains("/")) {
      String[] versionParts = apiVersion.split("/");
      return versionParts[0];
    }
    return apiVersion;
  }



   /**
   * Separates apiGroupName for apiGroupName/apiGroupVersion combination.
   * @param apiVersion  The apiGroupVersion or apiGroupName/apiGroupVersion combo.
   * @return            Just the apiGroupName part without the apiGroupName, or null if no separator is found.
   */
  private static String trimGroupOrNull(String apiVersion) {
    if (apiVersion != null && apiVersion.contains("/")) {
      String[] versionParts = apiVersion.split("/");
      return versionParts[0];
    }
    return null;
  }
}
