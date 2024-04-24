/*
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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
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
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class KubernetesSerialization {

  private final ObjectMapper mapper;
  private final UnmatchedFieldTypeModule unmatchedFieldTypeModule = new UnmatchedFieldTypeModule();
  private KubernetesDeserializer kubernetesDeserializer;
  private final boolean searchClassloaders;

  /**
   * Creates a new instance with a fresh ObjectMapper
   */
  public KubernetesSerialization() {
    this(new ObjectMapper(), true);
  }

  /**
   * Creates a new instance with the given ObjectMapper, which will be configured for use for
   * kubernetes resource serialization / deserialization.
   *
   * @param searchClassloaders if {@link KubernetesResource} should be automatically discovered via {@link ServiceLoader}
   */
  public KubernetesSerialization(ObjectMapper mapper, boolean searchClassloaders) {
    this.mapper = mapper;
    this.searchClassloaders = searchClassloaders;
    configureMapper(mapper);
  }

  protected void configureMapper(ObjectMapper mapper) {
    mapper.registerModules(new JavaTimeModule(), unmatchedFieldTypeModule);
    mapper.disable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
    // omit null fields, but keep null map values
    mapper.setDefaultPropertyInclusion(JsonInclude.Value.construct(Include.NON_NULL, Include.ALWAYS));
    HandlerInstantiator instanciator = mapper.getDeserializationConfig().getHandlerInstantiator();
    mapper.setConfig(mapper.getDeserializationConfig().with(new HandlerInstantiator() {

      @Override
      public JsonDeserializer<?> deserializerInstance(DeserializationConfig config, Annotated annotated, Class<?> deserClass) {
        if (deserClass == KubernetesDeserializer.class) {
          return getKubernetesDeserializer();
        }
        if (instanciator == null) {
          return null;
        }
        return instanciator.deserializerInstance(config, annotated, deserClass);
      }

      @Override
      public KeyDeserializer keyDeserializerInstance(DeserializationConfig config, Annotated annotated,
          Class<?> keyDeserClass) {
        if (instanciator == null) {
          return null;
        }
        return instanciator.keyDeserializerInstance(config, annotated, keyDeserClass);
      }

      @Override
      public JsonSerializer<?> serializerInstance(SerializationConfig config, Annotated annotated, Class<?> serClass) {
        if (instanciator == null) {
          return null;
        }
        return instanciator.serializerInstance(config, annotated, serClass);
      }

      @Override
      public TypeResolverBuilder<?> typeResolverBuilderInstance(MapperConfig<?> config, Annotated annotated,
          Class<?> builderClass) {
        if (instanciator == null) {
          return null;
        }
        return instanciator.typeResolverBuilderInstance(config, annotated, builderClass);
      }

      @Override
      public TypeIdResolver typeIdResolverInstance(MapperConfig<?> config, Annotated annotated, Class<?> resolverClass) {
        if (instanciator == null) {
          return null;
        }
        return instanciator.typeIdResolverInstance(config, annotated, resolverClass);
      }

    }));
  }

  private synchronized KubernetesDeserializer getKubernetesDeserializer() {
    // created lazily to avoid holding all model classes in memory by default
    if (this.kubernetesDeserializer == null) {
      this.kubernetesDeserializer = new KubernetesDeserializer(searchClassloaders);
    }
    return kubernetesDeserializer;
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
  public <T> String asJson(T object) {
    try {
      return mapper.writeValueAsString(object);
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
  public <T> String asYaml(T object) {
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
    return yaml.dumpToString(mapper.convertValue(object, Object.class));
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
  public <T> T unmarshal(InputStream is) {
    return unmarshal(is, new TypeReference<T>() {
      @Override
      public Type getType() {
        return KubernetesResource.class;
      }
    });
  }

  public <T> T unmarshal(InputStream is, TypeReference<T> type) {
    try (BufferedInputStream bis = new BufferedInputStream(is)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      final T result;
      if (intch != '{' && intch != '[') {
        result = parseYaml(bis, type);
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
  private <T> T parseYaml(BufferedInputStream bis, TypeReference<T> type) {
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
  public <T> T unmarshal(String str) {
    return (T) unmarshal(str, KubernetesResource.class);
  }

  /**
   * Unmarshals a {@link String}
   *
   * @param str The {@link String}.
   * @param type The target type.
   * @param <T> template argument denoting type
   * @return returns de-serialized object
   */
  public <T> T unmarshal(String str, final Class<T> type) {
    try (InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8))) {
      return unmarshal(is, type);
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
  public <T> T unmarshal(InputStream is, final Class<T> type) {
    return unmarshal(is, new TypeReference<T>() {
      @Override
      public Type getType() {
        return type;
      }
    });
  }

  /**
   * Create a copy of the resource via serialization.
   *
   * @return a deep clone of the resource
   * @throws IllegalArgumentException if the cloning cannot be performed
   */
  public <T> T clone(T resource) {
    // if full serialization seems too expensive, there is also
    //return (T) JSON_MAPPER.convertValue(resource, resource.getClass());
    try {
      return (T) mapper.readValue(
          mapper.writeValueAsString(resource), resource.getClass());
    } catch (JsonProcessingException e) {
      throw new IllegalStateException(e);
    }
  }

  public <T> T convertValue(Object value, Class<T> type) {
    return mapper.convertValue(value, type);
  }

  public Type constructParametricType(Class<?> parameterizedClass, Class<?>... parameterClasses) {
    return mapper.getTypeFactory().constructParametricType(parameterizedClass, parameterClasses);
  }

  public Class<? extends KubernetesResource> getRegisteredKubernetesResource(String apiVersion, String kind) {
    return this.getKubernetesDeserializer().getRegisteredKind(apiVersion, kind);
  }

  public UnmatchedFieldTypeModule getUnmatchedFieldTypeModule() {
    return unmatchedFieldTypeModule;
  }

  protected ObjectMapper getMapper() {
    return mapper;
  }

  /**
   * Registers a new resource, which can then be recognized for deserialization
   */
  public void registerKubernetesResource(Class<? extends KubernetesResource> clazz) {
    getKubernetesDeserializer().registerKubernetesResource(clazz);
  }

  /**
   * Registers a new resource, which can then be recognized for deserialization.
   * <p>
   * This is for advanced usage scenarios where you have a class that lacks annotations, or you can have the same class
   * represent multiple versions or groups. However the DSL won't work with those classes - the resource(Class) method and other
   * DSL logic only consults annotations via static HasMetadata methods.
   */
  public void registerKubernetesResource(String apiVersion, String kind, Class<? extends KubernetesResource> clazz) {
    getKubernetesDeserializer().registerCustomKind(apiVersion, kind, clazz);
  }

  public String convertToJson(String input) {
    try {
      mapper.readTree(input);
      return input; // valid json
    } catch (JsonProcessingException e) {
      return asJson(unmarshal(input, JsonNode.class));
    }
  }

}
