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

public class ApiVersionUtil {

  private ApiVersionUtil() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Extracts apiGroupName from apiGroupVersion when in resource for apiGroupName/apiGroupVersion combination
   * 
   * @param <T> Template argument provided
   * @param item resource which is being used
   * @param apiGroup apiGroupName present if any
   * @return Just the apiGroupName part without apiGroupVersion
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
   * 
   * @param <T> type of parameter
   * @param item item to be processed
   * @param apiVersion apiVersion string
   * @return returns api version
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
   * 
   * @param apiVersion The apiGroupVersion or apiGroupName/apiGroupVersion combo.
   * @return Just the apiGroupVersion part without the apiGroupName.
   */
  public static String trimVersion(String apiVersion) {
    if (apiVersion != null) {
      final int slash = apiVersion.indexOf('/');
      if (slash > 0) {
        return apiVersion.substring(slash + 1);
      }
    }
    return apiVersion;
  }

  /**
   * Separates apiGroupName for apiGroupName/apiGroupVersion combination.
   * 
   * @param apiVersion The apiGroupVersion or apiGroupName/apiGroupVersion combo.
   * @return Just the apiGroupName part without the apiGroupName, or apiVersion if no separator is found.
   */
  public static String trimGroup(String apiVersion) {
    if (apiVersion != null) {
      final int slash = apiVersion.indexOf('/');
      if (slash > 0) {
        return apiVersion.substring(0, slash);
      }
    }
    return apiVersion;
  }

  /**
   * Separates apiGroupName for apiGroupName/apiGroupVersion combination.
   * 
   * @param apiVersion The apiGroupVersion or apiGroupName/apiGroupVersion combo.
   * @return Just the apiGroupName part without the apiGroupName, or null if no separator is found.
   */
  public static String trimGroupOrNull(String apiVersion) {
    if (apiVersion != null && apiVersion.contains("/")) {
      return trimGroup(apiVersion);
    }
    return null;
  }

  /**
   * Join group and version strings to form apiVersion key in Kubernetes objects
   *
   * @param group ApiGroup for resource
   * @param version ApiVersion for resource
   * @return version if group is null or empty, joined string otherwise.
   */
  public static String joinApiGroupAndVersion(String group, String version) {
    if (Utils.isNullOrEmpty(group)) {
      return version;
    }
    return group + "/" + version;
  }
}
