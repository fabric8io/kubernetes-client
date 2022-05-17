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

import com.fasterxml.jackson.core.JsonProcessingException;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.model.DefaultKubernetesResourceList;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.OwnerReference;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.readiness.Readiness;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class KubernetesResourceUtil {
  private KubernetesResourceUtil() {
  }

  public static final Pattern KUBERNETES_DNS1123_LABEL_REGEX = Pattern.compile("[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?");
  private static final Pattern INVALID_LABEL_CHARS_PATTERN = Pattern.compile("[^-A-Za-z0-9]+");

  /**
   * Returns the resource version for the entity or null if it does not have one
   *
   * @param entity entity provided
   * @return returns resource version of provided entity
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
   * Set resource version of a kubernetes resource
   *
   * @param entity entity provided
   * @param resourceVersion updated resource version
   */
  public static void setResourceVersion(HasMetadata entity, String resourceVersion) {
    if (entity != null) {
      ObjectMeta metadata = entity.getMetadata();
      if (metadata != null) {
        metadata.setResourceVersion(resourceVersion);
      }
    }
  }

  /**
   * Set namespace of a kubernetes resource if possible
   *
   * @param entity entity provided
   * @param namespace the new namesapce
   */
  public static void setNamespace(HasMetadata entity, String namespace) {
    if (entity != null) {
      ObjectMeta metadata = entity.getMetadata();
      if (metadata != null) {
        metadata.setNamespace(namespace);
      }
    }
  }

  /**
   * Returns the kind of the entity
   *
   * @param entity provided entity
   * @return returns kind of entity provided
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
   * @return returns qualified name
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
   * @return returns name of resource
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
   *
   * @param entity entity provided
   * @return returns a boolean value indicating whether it has a valid non blank resourceVersion
   */
  public static boolean hasResourceVersion(HasMetadata entity) {
    return getResourceVersion(entity) != null;
  }

  /**
   * Returns name of the resource from it's Metadata
   *
   * @param entity MetaData of kubernetes resource
   * @return returns name of resource
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
   * @param additionalProperties additional properties
   * @param name name of resource
   * @return returns additional property text
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
   * @return returns namespace as plain string
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
   * @return returns namespace as plain string
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
   * @return returns a hashmap containing annotations
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
    if (name != null) {
      name = INVALID_LABEL_CHARS_PATTERN.matcher(name).replaceAll("-");
      if (!Character.isLetterOrDigit(name.charAt(0))) {
        name = "a" + name;
      }
      if (name.length() > 63) {
        name = name.substring(0, 63);
      }
      name = name.toLowerCase();
      final int lastChar = name.length() - 1;
      if (!Character.isLetterOrDigit(name.charAt(lastChar))) {
        name = name.substring(0, lastChar - 1) + "a";
      }
      return name;
    }
    return null;
  }

  /**
   * Null safe get method for getting Labels of a Kubernetes Resource
   *
   * @param entity Kubernetes Resource
   * @return returns a hashmap containing labels
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
   *
   * @param metadata ObjectMeta for resource's metadata
   * @return returns labels as a hashmap
   */

  @SuppressWarnings("unchecked")
  public static Map<String, String> getLabels(ObjectMeta metadata) {
    if (metadata != null) {
      Map<String, String> labels = metadata.getLabels();
      if (labels != null) {
        return labels;
      }
    }
    return Collections.emptyMap();
  }

  /**
   * Null safe operation for getting Metadata of a Kubernetes resource
   *
   * @param entity Kubernetes Resource
   * @return returns ObjectMeta as metadata
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
   * @return returns a boolean value indicating whether it's valid or not
   */
  public static boolean isValidName(String name) {
    return Utils.isNotNullOrEmpty(name) && KUBERNETES_DNS1123_LABEL_REGEX.matcher(name).matches();
  }

  /**
   * Validates labels/annotations of Kubernetes resources
   *
   * @param map Label/Annotation of resource
   * @return returns a boolean value indicating whether it's valid or not
   */
  public static boolean isValidLabelOrAnnotation(Map<String, String> map) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      if (!(isValidName(entry.getKey()) && isValidName(entry.getValue()))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks whether the resource has some controller(parent) or not.
   *
   * @param resource resource
   * @return boolean value indicating whether it's a child or not.
   */
  public static boolean hasController(HasMetadata resource) {
    return getControllerUid(resource) != null;
  }

  public static OwnerReference getControllerUid(HasMetadata resource) {
    if (resource.getMetadata() != null) {
      List<OwnerReference> ownerReferenceList = resource.getMetadata().getOwnerReferences();
      for (OwnerReference ownerReference : ownerReferenceList) {
        if (Boolean.TRUE.equals(ownerReference.getController())) {
          return ownerReference;
        }
      }
    }
    return null;
  }

  public static void sortEventListBasedOnTimestamp(List<Event> eventList) {
    if (eventList != null) {
      // Sort to get latest events in beginning, putting events without lastTimestamp first
      eventList.sort(Comparator.comparing(Event::getLastTimestamp,
          Comparator.nullsFirst(Comparator.comparing(Instant::parse).reversed())));
    }
  }

  public static List<EnvVar> convertMapToEnvVarList(Map<String, String> envVarMap) {
    List<EnvVar> envVars = new ArrayList<>();
    for (Map.Entry<String, String> entry : envVarMap.entrySet()) {
      if (entry.getKey() != null && entry.getValue() != null) {
        envVars.add(new EnvVarBuilder()
            .withName(entry.getKey())
            .withValue(entry.getValue())
            .build());
      }
    }
    return envVars;
  }

  /**
   * Check whether a Kubernetes resource is Ready or not. Applicable only to
   * Deployment, ReplicaSet, Pod, ReplicationController, Endpoints, Node and
   * StatefulSet
   * 
   * @param item item which needs to be checked
   * @return boolean value indicating it's status
   */
  public static boolean isResourceReady(HasMetadata item) {
    return Readiness.getInstance().isReady(item);
  }

  /**
   * Calculates age of a kubernetes resource
   * 
   * @param kubernetesResource
   * @return a positive duration indicating age of the kubernetes resource
   */
  public static Duration getAge(HasMetadata kubernetesResource) {
    Instant instant = Instant.parse(kubernetesResource.getMetadata().getCreationTimestamp());
    return Duration.between(instant, Instant.now()).abs();
  }

  public static <T extends HasMetadata> Class<? extends KubernetesResourceList> inferListType(Class<T> type) {
    return (Class<? extends KubernetesResourceList>) loadRelated(type, "List", DefaultKubernetesResourceList.class);
  }

  public static <T extends HasMetadata, V extends VisitableBuilder<T, V>> Class<V> inferBuilderType(Class<T> type) {
    return (Class<V>) loadRelated(type, "Builder", null);
  }

  private static Class<?> loadRelated(Class<?> type, String suffix, Class<?> defaultClass) {
    try {
      return Thread.currentThread().getContextClassLoader().loadClass(type.getName() + suffix);
    } catch (ClassNotFoundException | ClassCastException e) {
      try {
        return type.getClassLoader().loadClass(type.getName() + suffix);
      } catch (ClassNotFoundException | ClassCastException ex) {
        return defaultClass;
      }
    }
  }

  /**
   * Create Secret by using username and password.
   * 
   * @param dockerServer User to store key value pair for auths map
   * @param username username that needs to be used during secret creation
   * @param password password that needs to be used during secret creation
   * @return an object of Secret
   */
  public static Secret createDockerRegistrySecret(String dockerServer, String username, String password)
      throws JsonProcessingException {
    Map<String, Object> dockerConfigMap = new HashMap<>();
    Map<String, Object> auths = new HashMap<>();
    Map<String, Object> credentials = new HashMap<>();
    credentials.put("username", username);
    credentials.put("password", password);
    String usernameAndPasswordAuth = username + ":" + password;
    credentials.put("auth", Base64.getEncoder().encodeToString(usernameAndPasswordAuth.getBytes(StandardCharsets.UTF_8)));
    auths.put(dockerServer, credentials);
    dockerConfigMap.put("auths", auths);

    String dockerConfigAsStr = Serialization.jsonMapper().writeValueAsString(dockerConfigMap);

    return new SecretBuilder()
        .withNewMetadata().withName("harbor-secret").endMetadata()
        .withType("kubernetes.io/dockerconfigjson")
        .addToData(".dockerconfigjson", Base64.getEncoder().encodeToString(dockerConfigAsStr.getBytes(StandardCharsets.UTF_8)))
        .build();
  }
}
