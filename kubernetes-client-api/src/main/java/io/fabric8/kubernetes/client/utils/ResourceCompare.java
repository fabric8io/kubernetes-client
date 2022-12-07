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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResourceCompare {
  private ResourceCompare() {
  }

  private static TypeReference<HashMap<String, Object>> TYPE_REF = new TypeReference<HashMap<String, Object>>() {
  };

  private static final String METADATA = "metadata";
  private static final String SPEC = "spec";
  private static final String ITEMS = "items";

  /**
   * This method returns true when left Kubernetes resource contains
   * all data that's present in right Kubernetes resource, this method
   * won't consider fields that are missing in right parameters. Values
   * which are present in right would only be compared.
   *
   * @param left kubernetes resource (fetched from cluster)
   * @param right kubernetes resource (provided as input by user)
   * @param <T> type for kubernetes resource
   *
   * @return boolean value whether both resources are actually equal or not
   */
  @Deprecated
  public static <T> boolean equals(T left, T right) {
    ObjectMapper jsonMapper = Serialization.jsonMapper();
    if (left == null && right == null) {
      return true;
    } else if (left == null) {
      return false;
    } else if (right == null) {
      return false;
    }
    Map<String, Object> leftJson = jsonMapper.convertValue(left, TYPE_REF);
    Map<String, Object> rightJson = jsonMapper.convertValue(right, TYPE_REF);

    if (left instanceof KubernetesList) {
      return compareKubernetesList(leftJson, rightJson);
    } else {
      return compareKubernetesResource(leftJson, rightJson);
    }
  }

  @Deprecated
  public static boolean compareKubernetesList(Map<String, Object> leftJson, Map<String, Object> rightJson) {
    List<Map<String, Object>> leftItems = (List<Map<String, Object>>) leftJson.get(ITEMS);
    List<Map<String, Object>> rightItems = (List<Map<String, Object>>) rightJson.get(ITEMS);

    if (leftItems != null && rightItems != null) {
      if (leftItems.size() != rightItems.size()) {
        return false;
      }

      for (int i = 0; i < rightItems.size(); i++) {
        if (!compareKubernetesResource(leftItems.get(i), rightItems.get(i))) {
          return false;
        }
      }
    } else
      return leftItems != null;
    return true;
  }

  @Deprecated
  public static boolean compareKubernetesResource(Map<String, Object> leftJson, Map<String, Object> rightJson) {
    return isEqualMetadata(leftJson, rightJson) &&
        isEqualSpec(leftJson, rightJson);
  }

  private static boolean isEqualMetadata(Map<String, Object> leftMap, Map<String, Object> rightMap) {
    Map<String, Object> leftMetadata = (Map<String, Object>) leftMap.get(METADATA);
    Map<String, Object> rightMetadata = (Map<String, Object>) rightMap.get(METADATA);

    if (leftMetadata == null && rightMetadata == null) {
      return true;
    } else if (leftMetadata != null && rightMetadata == null) {
      return true;
    } else if (leftMetadata == null) {
      return false;
    }

    return isLeftMapSupersetOfRight(leftMetadata, rightMetadata);
  }

  private static boolean isEqualSpec(Map<String, Object> leftMap, Map<String, Object> rightMap) {
    Map<String, Object> leftSpec = (Map<String, Object>) leftMap.get(SPEC);
    Map<String, Object> rightSpec = (Map<String, Object>) rightMap.get(SPEC);

    if (leftSpec == null && rightSpec == null) {
      return true;
    } else if (leftSpec != null && rightSpec == null) {
      return true;
    } else if (leftSpec == null) {
      return false;
    }

    return isLeftMapSupersetOfRight(leftSpec, rightSpec);
  }

  /**
   * Iterates via keys of right map to see if they are present in left map
   *
   * @param leftMap a hashmap of string, object
   * @param rightMap a hashmap of string, object
   * @return boolean value indicating whether left contains all keys and values of right map or not
   */
  private static boolean isLeftMapSupersetOfRight(Map<String, Object> leftMap, Map<String, Object> rightMap) {
    for (Map.Entry<String, Object> entry : rightMap.entrySet()) {
      if (!leftMap.containsKey(entry.getKey())) {
        return false;
      }

      if (!leftMap.get(entry.getKey()).equals(entry.getValue())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Compare the two metadata objects after they have been stripped of api server managed fields, such as uid
   *
   * @return true if the metadata are the same ignoring
   */
  public static boolean metadataChanged(ObjectMeta object1, ObjectMeta object2) {
    return !Objects.equals(withoutRuntimeState(object1), withoutRuntimeState(object2));
  }

  static ObjectMeta withoutRuntimeState(ObjectMeta meta) {
    if (meta == null) {
      return null;
    }
    ObjectMetaBuilder builder = new ObjectMetaBuilder(meta);
    return builder.withCreationTimestamp(null).withDeletionTimestamp(null).withGeneration(null).withResourceVersion(null)
        .withSelfLink(null).withUid(null).build();
  }
}
