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
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.model.jackson.UnmatchedFieldTypeModule;

import java.io.InputStream;

public class Serialization {
  private Serialization() {
  }

  /**
   * Create an instance that mimics the old behavior
   * - scans the classpath for KubernetesResources, and provides a static mapper / UnmatchedFieldTypeModule
   *
   * Future versions will further override the KubernetesDeserializer initialization as
   * it will no longer be expected to use Serialization with KubernetesResources.
   */
  private static final KubernetesSerialization kubernetesSerialization = new KubernetesSerialization();

  /**
   * @deprecated use {@link KubernetesSerialization#getUnmatchedFieldTypeModule()} instead
   */
  @Deprecated
  public static final UnmatchedFieldTypeModule UNMATCHED_FIELD_TYPE_MODULE = kubernetesSerialization
      .getUnmatchedFieldTypeModule();

  private static volatile ObjectMapper YAML_MAPPER;

  /**
   * {@link ObjectMapper} singleton instance used internally by the Kubernetes client.
   *
   * <p>
   * The ObjectMapper has an {@link UnmatchedFieldTypeModule} module registered. This module allows the client
   * to work with Resources that contain properties that don't match the target field type. This is especially useful
   * and necessary to work with OpenShift Templates.
   *
   * <p>
   * n.b. the use of this module gives precedence to properties present in the additionalProperties Map present
   * in most KubernetesResource instances. If a property is both defined in the Map and in the original field, the
   * one from the additionalProperties Map will be serialized.
   *
   * @deprecated the static mapper should not be used directly
   */
  @Deprecated
  public static ObjectMapper jsonMapper() {
    return kubernetesSerialization.getMapper();
  }

  /**
   * {@link ObjectMapper} singleton instance used internally by the Kubernetes client.
   *
   * <p>
   * The ObjectMapper has an {@link UnmatchedFieldTypeModule} module registered. This module allows the client
   * to work with Resources that contain properties that don't match the target field type. This is especially useful
   * and necessary to work with OpenShift Templates.
   *
   * <p>
   * n.b. the use of this module gives precedence to properties present in the additionalProperties Map present
   * in most KubernetesResource instances. If a property is both defined in the Map and in the original field, the
   * one from the additionalProperties Map will be serialized.
   *
   * @deprecated use {@link #asYaml(Object)} or one of the unmarshal methods
   */
  @Deprecated
  public static ObjectMapper yamlMapper() {
    if (YAML_MAPPER == null) {
      synchronized (Serialization.class) {
        if (YAML_MAPPER == null) {
          YAML_MAPPER = new ObjectMapper(
              new YAMLFactory().disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID));
          YAML_MAPPER.registerModules(UNMATCHED_FIELD_TYPE_MODULE);
        }
      }
    }
    return YAML_MAPPER;
  }

  /**
   * Allow application to clear out the YAML mapper in order to allow its garbage collection.
   * This is useful because in a lot of cases the YAML mapper is only need at application startup
   * when the client is created, so there is no reason to keep the very heavy (in terms of memory) mapper
   * around indefinitely.
   *
   * @deprecated to be removed in later versions
   */
  @Deprecated
  public static void clearYamlMapper() {
    YAML_MAPPER = null;
  }

  /**
   * Returns a JSON representation of the given object.
   *
   * <p>
   * If the provided object contains a JsonAnyGetter annotated method with a Map that contains an entry that
   * overrides a field of the provided object, the Map entry will take precedence upon serialization. Properties won't
   * be duplicated.
   *
   * @param object the object to serialize.
   * @param <T> the type of the object being serialized.
   * @return a String containing a JSON representation of the provided object.
   */
  public static <T> String asJson(T object) {
    return kubernetesSerialization.asJson(object);
  }

  /**
   * Returns a YAML representation of the given object.
   *
   * <p>
   * If the provided object contains a JsonAnyGetter annotated method with a Map that contains an entry that
   * overrides a field of the provided object, the Map entry will take precedence upon serialization. Properties won't
   * be duplicated.
   *
   * @param object the object to serialize.
   * @param <T> the type of the object being serialized.
   * @return a String containing a JSON representation of the provided object.
   */
  public static <T> String asYaml(T object) {
    return kubernetesSerialization.asYaml(object);
  }

  /**
   * Unmarshals a stream.
   * <p>
   * The type is assumed to be {@link KubernetesResource}
   *
   * @param is The {@link InputStream}.
   * @param <T> The target type.
   *
   * @return returns de-serialized object
   *
   * @deprecated use {@link KubernetesSerialization} instead
   */
  @Deprecated
  public static <T> T unmarshal(InputStream is) {
    return kubernetesSerialization.unmarshal(is);
  }

  /**
   * Unmarshals a {@link String}
   * <p>
   * The type is assumed to be {@link KubernetesResource}
   *
   * @param str The {@link String}.
   * @param <T> template argument denoting type
   * @return returns de-serialized object
   *
   * @deprecated use {@link KubernetesSerialization} instead
   */
  @Deprecated
  public static <T> T unmarshal(String str) {
    return kubernetesSerialization.unmarshal(str);
  }

  /**
   * Unmarshals a {@link String}
   *
   * @param str The {@link String}.
   * @param type The target type.
   * @param <T> template argument denoting type
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(String str, final Class<T> type) {
    return kubernetesSerialization.unmarshal(str, type);
  }

  /**
   * Unmarshals an {@link InputStream}.
   *
   * @param is The {@link InputStream}.
   * @param type The type.
   * @param <T> Template argument denoting type
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, final Class<T> type) {
    return kubernetesSerialization.unmarshal(is, type);
  }

  /**
   * Unmarshals an {@link InputStream}.
   *
   * @param is The {@link InputStream}.
   * @param type The {@link TypeReference}.
   * @param <T> Template argument denoting type
   * @return returns de-serialized object
   *
   * @deprecated use {@link KubernetesSerialization#unmarshal(InputStream, TypeReference)}
   */
  @Deprecated
  public static <T> T unmarshal(InputStream is, TypeReference<T> type) {
    return kubernetesSerialization.unmarshal(is, type);
  }

  /**
   * Create a copy of the resource via serialization.
   *
   * @return a deep clone of the resource
   * @throws IllegalArgumentException if the cloning cannot be performed
   */
  public static <T> T clone(T resource) {
    return kubernetesSerialization.clone(resource);
  }

}
