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
package io.fabric8.openshift.client.internal;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.dsl.internal.OpenShiftOperation;

import java.util.List;

/**
 * Helper methods for dealing with different API Group based API versions
 */
public class ApiVersionHelpers {

  /**
   * Updates the list items if they have missing or default apiVersion values and the resource is currently
   * using API Groups with custom version strings
   */
  public static void updateApiVersion(OpenShiftOperation operation, OpenShiftConfig openShiftConfig, KubernetesResourceList list) {
    String version = operation.getApiGroupVersion();
    if (list != null && version != null && version.length() > 0) {
      List items = list.getItems();
      if (items != null) {
        for (Object item : items) {
          if (item instanceof HasMetadata) {
            HasMetadata hasMetadata = (HasMetadata) item;
            ObjectMeta metadata = hasMetadata.getMetadata();
            if (metadata != null) {
              hasMetadata.setApiVersion(version);
            }
          }
        }
      }
    }
  }

  /**
   * Updates the resource if it has missing or default apiVersion values and the resource is currently
   * using API Groups with custom version strings
   */
  public static void updateApiVersion(OpenShiftOperation operation, OpenShiftConfig openShiftConfig, HasMetadata hasMetadata) {
    String version = operation.getApiGroupVersion();
    if (hasMetadata != null && version != null && version.length() > 0) {
      ObjectMeta metadata = hasMetadata.getMetadata();
      if (metadata != null) {
        hasMetadata.setApiVersion(version);
      }
    }
  }
}
