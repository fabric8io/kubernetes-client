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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.model.jackson.UnmatchedFieldTypeModule;
import org.snakeyaml.engine.v2.api.Dump;
import org.snakeyaml.engine.v2.api.DumpSettings;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.common.FlowStyle;
import org.snakeyaml.engine.v2.common.ScalarStyle;
import org.snakeyaml.engine.v2.nodes.NodeTuple;
import org.snakeyaml.engine.v2.nodes.ScalarNode;
import org.snakeyaml.engine.v2.nodes.Tag;
import org.snakeyaml.engine.v2.representer.StandardRepresenter;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Serialization {
  private Serialization() {
  }

  public static final UnmatchedFieldTypeModule UNMATCHED_FIELD_TYPE_MODULE = new UnmatchedFieldTypeModule();

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  static {
    JSON_MAPPER.registerModules(new JavaTimeModule(), UNMATCHED_FIELD_TYPE_MODULE);
    JSON_MAPPER.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
  }

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
   */
  public static ObjectMapper jsonMapper() {
    return JSON_MAPPER;
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
    try {
      return JSON_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
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
    DumpSettings settings = DumpSettings.builder()
        .setExplicitStart(true).setDefaultFlowStyle(FlowStyle.BLOCK).build();
    final Dump yaml = new Dump(settings, new StandardRepresenter(settings) {
      private boolean quote = true;

      @Override
      protected NodeTuple representMappingEntry(java.util.Map.Entry<?, ?> entry) {
        Object key = entry.getKey();
        if (key instanceof String) {
          // to match the previous format, don't quote keys
          quote = false;
          String str = (String) key;
          // the abbreviations y/n are not part of the snakeyaml core schema
          if (str.length() == 1) {
            char start = str.charAt(0);
            quote = (start == 'y' || start == 'Y' || start == 'n' || start == 'N');
          }
        }
        org.snakeyaml.engine.v2.nodes.Node nodeKey = representData(key);
        quote = true;
        return new NodeTuple(nodeKey, representData(entry.getValue()));
      }

      @Override
      protected org.snakeyaml.engine.v2.nodes.Node representScalar(Tag tag, String value, ScalarStyle style) {
        if (style == ScalarStyle.PLAIN) {
          style = quote && tag == Tag.STR ? ScalarStyle.DOUBLE_QUOTED : this.defaultScalarStyle;
        }
        return new ScalarNode(tag, value, style);
      }
    });
    return yaml.dumpToString(JSON_MAPPER.convertValue(object, Object.class));
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
   */
  public static <T> T unmarshal(InputStream is) {
    return unmarshal(is, JSON_MAPPER);
  }

  /**
   * Unmarshals a stream optionally performing placeholder substitution to the stream.
   * <p>
   * The type is assumed to be {@link KubernetesResource}
   *
   * @param is The {@link InputStream}.
   * @param parameters A {@link Map} with parameters for placeholder substitution.
   * @param <T> The target type.
   * @return returns returns de-serialized object
   *
   * @deprecated please directly apply {@link Utils#interpolateString(String, Map)} instead of passing parameters here
   */
  @Deprecated
  @SuppressWarnings("unchecked")
  public static <T> T unmarshal(InputStream is, Map<String, String> parameters) {
    return unmarshal(is, JSON_MAPPER, parameters);
  }

  /**
   * Unmarshals a stream.
   * <p>
   * The type is assumed to be {@link KubernetesResource}
   *
   * @param is The {@link InputStream}.
   * @param mapper The {@link ObjectMapper} to use.
   * @param <T> The target type.
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, ObjectMapper mapper) {
    return unmarshal(is, mapper, Collections.emptyMap());
  }

  /**
   * Unmarshals a stream optionally performing placeholder substitution to the stream.
   * <p>
   * The type is assumed to be {@link KubernetesResource}
   *
   * @param is The {@link InputStream}.
   * @param mapper The {@link ObjectMapper} to use.
   * @param parameters A {@link Map} with parameters for placeholder substitution.
   * @param <T> The target type.
   * @return returns de-serialized object
   *
   * @deprecated please directly apply {@link Utils#interpolateString(String, Map)} instead of passing parameters here
   */
  @Deprecated
  public static <T> T unmarshal(InputStream is, ObjectMapper mapper, Map<String, String> parameters) {
    return unmarshal(is, mapper, new TypeReference<T>() {
      @Override
      public Type getType() {
        return KubernetesResource.class;
      }
    }, parameters);
  }

  private static <T> T unmarshal(InputStream is, ObjectMapper mapper, TypeReference<T> type, Map<String, String> parameters) {
    try (InputStream wrapped = parameters != null && !parameters.isEmpty() ? ReplaceValueStream.replaceValues(is, parameters)
        : is;
        BufferedInputStream bis = new BufferedInputStream(wrapped)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      final T result;
      if (intch != '{' && intch != '[') {
        result = parseYaml(bis, mapper, type);
      } else {
        result = mapper.readerFor(type).readValue(bis);
      }
      return result;
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  /**
   * If multiple docs exist, only non-null resources will be kept. Results spanning multiple docs
   * will be returned as a List of KubernetesResource
   */
  private static <T> T parseYaml(BufferedInputStream bis, ObjectMapper mapper, TypeReference<T> type) {
    T result = null;
    List<KubernetesResource> listResult = null;
    final Load yaml = new Load(LoadSettings.builder().build());
    final Iterable<Object> objs = yaml.loadAllFromInputStream(bis);
    for (Object obj : objs) {
      Object value = null;
      if (obj instanceof Map) {
        value = mapper.convertValue(obj, type);
      } else if (obj != null) {
        value = mapper.convertValue(new RawExtension(obj), type);
      }
      if (value != null) {
        if (result == null) {
          result = (T) value;
        } else {
          if (listResult == null) {
            listResult = new ArrayList<>();
            accumulateResult(result, listResult);
          }
          accumulateResult(value, listResult);
        }
      }
    }
    if (listResult != null) {
      return (T) listResult;
    }
    return result;
  }

  private static <T> void accumulateResult(T result, List<KubernetesResource> listResult) {
    if (result instanceof KubernetesResourceList) {
      listResult.addAll(((KubernetesResourceList) result).getItems());
    } else {
      listResult.add((KubernetesResource) result);
    }
  }

  /**
   * Unmarshals a {@link String}
   * <p>
   * The type is assumed to be {@link KubernetesResource}
   *
   * @param str The {@link String}.
   * @param <T> template argument denoting type
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(String str) {
    try (InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8))) {
      return unmarshal(is);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
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
    return unmarshal(str, type, Collections.emptyMap());
  }

  /**
   * Unmarshals a {@link String} optionally performing placeholder substitution to the String.
   *
   * @param str The {@link String}.
   * @param type The target type.
   * @param <T> Template argument denoting type
   * @param parameters A hashmap containing parameters
   *
   * @return returns de-serialized object
   *
   * @deprecated please directly apply {@link Utils#interpolateString(String, Map)} instead of passing parameters here
   */
  @Deprecated
  public static <T> T unmarshal(String str, final Class<T> type, Map<String, String> parameters) {
    try (InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8))) {
      return unmarshal(is, new TypeReference<T>() {
        @Override
        public Type getType() {
          return type;
        }
      }, parameters);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
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
    return unmarshal(is, type, Collections.emptyMap());
  }

  /**
   * Unmarshals an {@link InputStream} optionally performing placeholder substitution to the stream.
   *
   * @param is The {@link InputStream}.
   * @param type The type.
   * @param parameters A {@link Map} with parameters for placeholder substitution.
   * @param <T> Template argument denoting type
   * @return returns de-serialized object
   *
   * @deprecated please directly apply {@link Utils#interpolateString(String, Map)} instead of passing parameters here
   */
  @Deprecated
  public static <T> T unmarshal(InputStream is, final Class<T> type, Map<String, String> parameters) {
    return unmarshal(is, new TypeReference<T>() {
      @Override
      public Type getType() {
        return type;
      }
    }, parameters);
  }

  /**
   * Unmarshals an {@link InputStream}.
   *
   * @param is The {@link InputStream}.
   * @param type The {@link TypeReference}.
   * @param <T> Template argument denoting type
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, TypeReference<T> type) {
    return unmarshal(is, type, Collections.emptyMap());
  }

  /**
   * Unmarshals an {@link InputStream} optionally performing placeholder substitution to the stream.
   *
   * @param is The {@link InputStream}.
   * @param type The {@link TypeReference}.
   * @param parameters A {@link Map} with parameters for placeholder substitution.
   * @param <T> Template argument denoting type
   *
   * @return returns de-serialized object
   *
   * @deprecated please directly apply {@link Utils#interpolateString(String, Map)} instead of passing parameters here
   */
  @Deprecated
  public static <T> T unmarshal(InputStream is, TypeReference<T> type, Map<String, String> parameters) {
    return unmarshal(is, JSON_MAPPER, type, parameters);
  }

  /**
   * Create a copy of the resource via serialization.
   *
   * @return a deep clone of the resource
   * @throws IllegalArgumentException if the cloning cannot be performed
   */
  public static <T> T clone(T resource) {
    // if full serialization seems too expensive, there is also
    //return (T) JSON_MAPPER.convertValue(resource, resource.getClass());
    try {
      return (T) JSON_MAPPER.readValue(
          JSON_MAPPER.writeValueAsString(resource), resource.getClass());
    } catch (JsonProcessingException e) {
      throw new IllegalStateException(e);
    }
  }
}
