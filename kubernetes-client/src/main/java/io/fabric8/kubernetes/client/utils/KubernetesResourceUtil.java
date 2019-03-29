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
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.ObjectMeta;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class KubernetesResourceUtil {

  public static final Pattern KUBERNETES_DNS1123_LABEL_REGEX = Pattern.compile("[a-z0-9]([-a-z0-9]*[a-z0-9])?");

  public static final int KUBERNETES_DNS1123_LABEL_MAX_LENGTH = 63;

  /**
   * Returns the resource version for the entity or null if it does not have one
   */
  public static String getResourceVersion(HasMetadata entity) {
    if (entity != null) {
      ObjectMeta metadata = entity.getMetadata();
      if (metadata != null) {
        String resourceVersion = metadata.getResourceVersion();
        if (!Utils.isNullOrEmpty(resourceVersion)) {
          return resourceVersion;
        }
      }
    }
    return null;
  }

  /**
   * Returns the kind of the entity
   */
  public static String getKind(HasMetadata entity) {
    if (entity != null) {
      // TODO use reflection to find the kind?
      if (entity instanceof KubernetesList) {
        return "List";
      } else {
        return entity.getClass().getSimpleName();
      }
    } else {
      return null;
    }
  }

  /**
   * Returns Qualified name for the specified Kubernetes Resource
   *
   * @param entity Kubernetes resource
   * @return
   */
  public static String getQualifiedName(HasMetadata entity) {
    if (entity != null) {
      return "" + getNamespace(entity) + "/" + getName(entity);
    } else {
      return null;
    }
  }

  /**
   * Returns name of the resource from it's Metadata
   *
   * @param entity Kubernetes resource
   * @return
   */
  public static String getName(HasMetadata entity) {
    if (entity != null) {
      return getName(entity.getMetadata());
    } else {
      return null;
    }
  }

  /**
   * Returns true if this entity has a valid non blank resourceVersion in its metadata
   */
  public static boolean hasResourceVersion(HasMetadata entity) {
    return getResourceVersion(entity) != null;
  }

  /**
   * Returns name of the resource from it's Metadata
   *
   * @param entity MetaData of kubernetes resource
   * @return
   */
  public static String getName(ObjectMeta entity) {
    if (entity != null) {
      return Utils.coalesce(entity.getName(),
        getAdditionalPropertyText(entity.getAdditionalProperties(), "id"),
        entity.getUid());
    } else {
      return null;
    }
  }

  /**
   * Used to get additional properties from Object's metadata
   *
   * @param additionalProperties
   * @param name
   * @return
   */
  protected static String getAdditionalPropertyText(Map<String, Object> additionalProperties, String name) {
    if (additionalProperties != null) {
      Object value = additionalProperties.get(name);
      if (value != null) {
        return value.toString();
      }
    }
    return null;
  }

  /**
   * Null safe get operation for getting namespace from Kubernetes Resource's MetaData
   *
   * @param entity Kubernetes Resource
   * @return
   */
  public static String getNamespace(ObjectMeta entity) {
    if (entity != null) {
      return entity.getNamespace();
    } else {
      return null;
    }
  }

  /**
   * Getting namespace from Kubernetes Resource
   *
   * @param entity Kubernetes Resource
   * @return
   */
  public static String getNamespace(HasMetadata entity) {
    if (entity != null) {
      return getNamespace(entity.getMetadata());
    } else {
      return null;
    }
  }

  /**
   * Null safe get for fetching annotations from MetaData of Kubernetes Resource
   *
   * @param entity Kubernetes resource
   * @return
   */
  public static Map<String, String> getOrCreateAnnotations(HasMetadata entity) {
    ObjectMeta metadata = getOrCreateMetadata(entity);
    Map<String, String> answer = metadata.getAnnotations();
    if (answer == null) {
      // use linked so the annotations can be in the FIFO order
      answer = new LinkedHashMap<>();
      metadata.setAnnotations(answer);
    }
    return answer;
  }

  /**
   * Returns an identifier from the given string that can be used as resource name.
   *
   * @param name which needs to be sanitized
   * @return sanitized name
   */
  public static String sanitizeName(String name) {
    if(name != null) {
      return name.replaceAll("[^A-Za-z0-9]+", "-");
    }
    return null;
  }

  /**
   * Null safe get method for getting Labels of a Kubernetes Resource
   *
   * @param entity Kubernetes Resource
   * @return
   */
  public static Map<String, String> getOrCreateLabels(HasMetadata entity) {
    ObjectMeta metadata = getOrCreateMetadata(entity);
    Map<String, String> answer = metadata.getLabels();
    if (answer == null) {
      // use linked so the annotations can be in the FIFO order
      answer = new LinkedHashMap<>();
      metadata.setLabels(answer);
    }
    return answer;
  }

  /**
   * Returns the labels of the given metadata object or an empty map if the metadata or labels are null
   */
  @SuppressWarnings("unchecked")
  public static Map<String, String> getLabels(ObjectMeta metadata) {
    if (metadata != null) {
      Map<String, String> labels = metadata.getLabels();
      if (labels != null) {
        return labels;
      }
    }
    return Collections.EMPTY_MAP;
  }

  /**
   * Null safe operation for getting Metadata of a Kubernetes resource
   *
   * @param entity Kubernetes Resource
   * @return
   */
  public static ObjectMeta getOrCreateMetadata(HasMetadata entity) {
    ObjectMeta metadata = entity.getMetadata();
    if (metadata == null) {
      metadata = new ObjectMeta();
      entity.setMetadata(metadata);
    }
    return metadata;
  }

  /**
   * Validates name of Kubernetes Resource name, label or annotation based on Kubernetes regex
   *
   * @param name Name of resource/label/annotation
   * @return
   */
  public static boolean isValidName(String name) {
    return Utils.isNotNullOrEmpty(name) &&
      name.length() < KUBERNETES_DNS1123_LABEL_MAX_LENGTH &&
      KUBERNETES_DNS1123_LABEL_REGEX.matcher(name).matches();
  }


  /**
   * Validates labels/annotations of Kubernetes resources
   *
   * @param map Label/Annotation of resource
   * @return
   */
  public static boolean isValidLabelOrAnnotation(Map<String, String> map) {
    for(Map.Entry<String, String> entry : map.entrySet()) {
      if(!(isValidName(entry.getKey()) && isValidName(entry.getValue()))) {
        return false;
      }
    }
    return true;
  }
}
