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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.client.KubernetesClientException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.yaml.snakeyaml.Yaml;

public class Serialization {
  private Serialization() { }

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  static {
    JSON_MAPPER.registerModule(new JavaTimeModule());
  }

  private static final ObjectMapper YAML_MAPPER = new ObjectMapper(
    new YAMLFactory().disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID)
  );

  private static final String DOCUMENT_DELIMITER = "---";

  public static ObjectMapper jsonMapper() {
    return JSON_MAPPER;
  }

  public static ObjectMapper yamlMapper() {
    return YAML_MAPPER;
  }

  public static <T> String asJson(T object) {
    try {
      return JSON_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public static <T> String asYaml(T object) {
    try {
      return YAML_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  /**
   * Unmarshals a stream.
   *
   * @param is    The {@link InputStream}.
   * @param <T>   The target type.
   *
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is) {
    return unmarshal(is, JSON_MAPPER);
  }

  /**
   * Unmarshals a stream optionally performing placeholder substitution to the stream.
   * @param is    The {@link InputStream}.
   * @param parameters  A {@link Map} with parameters for placeholder substitution.
   * @param <T>   The target type.
   * @return returns returns de-serialized object
   */
  @SuppressWarnings("unchecked")
  public static <T> T unmarshal(InputStream is, Map<String, String> parameters) {
    String specFile = readSpecFileFromInputStream(is);
    if (containsMultipleDocuments(specFile)) {
      return (T) getKubernetesResourceList(parameters, specFile);
    }
    return unmarshal(new ByteArrayInputStream(specFile.getBytes()), JSON_MAPPER, parameters);
  }

  /**
   * Unmarshals a stream.
   * @param is      The {@link InputStream}.
   * @param mapper  The {@link ObjectMapper} to use.
   * @param <T>     The target type.
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, ObjectMapper mapper) {
   return unmarshal(is, mapper, Collections.emptyMap());
  }

  /**
   * Unmarshals a stream optionally performing placeholder substitution to the stream.
   * @param is          The {@link InputStream}.
   * @param mapper      The {@link ObjectMapper} to use.
   * @param parameters  A {@link Map} with parameters for placeholder substitution.
   * @param <T>         The target type.
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, ObjectMapper mapper, Map<String, String> parameters) {
    try (
      InputStream wrapped = parameters != null && !parameters.isEmpty() ? ReplaceValueStream.replaceValues(is, parameters) : is;
      BufferedInputStream bis = new BufferedInputStream(wrapped)
    ) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      if (intch != '{') {
        return unmarshalYaml(bis, null);
      }
      return mapper.readerFor(KubernetesResource.class).readValue(bis);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }
  
  /**
   * Unmarshals a {@link String}
   * @param str   The {@link String}.
   * @param <T>   template argument denoting type
   * @return returns de-serialized object
   */
  public static<T> T unmarshal(String str) {
    try (InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8))) {
      return unmarshal(is);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  /**
   * Unmarshals a {@link String}
   * @param str   The {@link String}.
   * @param type  The target type.
   * @param <T>   template argument denoting type
   * @return returns de-serialized object
   */
  public static<T> T unmarshal(String str, final Class<T> type) {
    return unmarshal(str, type, Collections.emptyMap());
  }

  /**
   * Unmarshals a {@link String} optionally performing placeholder substitution to the String.
   * @param str         The {@link String}.
   * @param type        The target type.
   * @param <T>         Template argument denoting type
   * @param parameters  A hashmap containing parameters
   *
   * @return returns de-serialized object
   */
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
   * @param is              The {@link InputStream}.
   * @param type            The type.
   * @param <T>           Template argument denoting type
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, final Class<T> type) {
    return unmarshal(is, type, Collections.emptyMap());
  }

  /**
   * Unmarshals an {@link InputStream} optionally performing placeholder substitution to the stream.
   * @param is              The {@link InputStream}.
   * @param type            The type.
   * @param parameters      A {@link Map} with parameters for placeholder substitution.
   * @param <T>             Template argument denoting type
   * @return returns de-serialized object
   */
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
   * @param is            The {@link InputStream}.
   * @param type          The {@link TypeReference}.
   * @param <T>           Template argument denoting type
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, TypeReference<T> type) {
   return unmarshal(is, type, Collections.emptyMap());
  }

  /**
   * Unmarshals an {@link InputStream} optionally performing placeholder substitution to the stream.
   *
   * @param is            The {@link InputStream}.
   * @param type          The {@link TypeReference}.
   * @param parameters    A {@link Map} with parameters for placeholder substitution.
   * @param <T>           Template argument denoting type
   *
   * @return returns de-serialized object
   */
  public static <T> T unmarshal(InputStream is, TypeReference<T> type, Map<String, String> parameters) {
    try (
      InputStream wrapped = parameters != null && !parameters.isEmpty() ? ReplaceValueStream.replaceValues(is, parameters) : is;
      BufferedInputStream bis = new BufferedInputStream(wrapped)
    ) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      ObjectMapper mapper = JSON_MAPPER;
      if (intch != '{') {
        return unmarshalYaml(bis, type);
      }
      return mapper.readValue(bis, type);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  private static List<KubernetesResource> getKubernetesResourceList(Map<String, String> parameters, String specFile) {
    return splitSpecFile(specFile).stream().filter(Serialization::validate)
      .map(document ->
        (KubernetesResource)Serialization.unmarshal(new ByteArrayInputStream(document.getBytes()), parameters))
      .collect(Collectors.toList());
  }

  static boolean containsMultipleDocuments(String specFile) {
    final long validDocumentCount = splitSpecFile(specFile).stream().filter(Serialization::validate)
      .count();
    return validDocumentCount > 1;
  }

  private static List<String> splitSpecFile(String aSpecFile) {
    final List<String> documents = new ArrayList<>();
    final StringBuilder documentBuilder = new StringBuilder();
    for (String line : aSpecFile.split("\r?\n")) {
      if (line.startsWith(DOCUMENT_DELIMITER)) {
        documents.add(documentBuilder.toString());
        documentBuilder.setLength(0);
      } else {
        documentBuilder.append(line).append(System.lineSeparator());
      }
    }
    if (documentBuilder.length() > 0) {
      documents.add(documentBuilder.toString());
    }
    return documents;
  }

  private static boolean validate(String document) {
    Matcher keyValueMatcher = Pattern.compile("(\\S+):\\s(\\S*)(?:\\b(?!:)|$)").matcher(document);
    return !document.isEmpty() && keyValueMatcher.find();
  }

  private static String readSpecFileFromInputStream(InputStream inputStream) {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length;
    try {
      while ((length = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, length);
      }
      return outputStream.toString();
    } catch (IOException e) {
      throw new RuntimeException("Unable to read InputStream." + e);
    }
  }

  private static <T> T unmarshalYaml(InputStream is, TypeReference<T> type) throws JsonProcessingException {
    final Yaml yaml = new Yaml();
    Map<String, Object> obj = yaml.load(is);
    String objAsJsonStr = JSON_MAPPER.writeValueAsString(obj);
    return unmarshalJsonStr(objAsJsonStr, type);
  }

  private static <T> T unmarshalJsonStr(String jsonString, TypeReference<T> type) throws JsonProcessingException {
    if (type != null) {
      return JSON_MAPPER.readValue(jsonString, type);
    }
    return JSON_MAPPER.readerFor(KubernetesResource.class).readValue(jsonString);
  }
  
  /**
   * Create a copy of the resource via serialization.
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
