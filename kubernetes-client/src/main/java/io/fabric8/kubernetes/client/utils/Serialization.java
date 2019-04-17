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

public class Serialization {

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());
  private static final String DOCUMENT_DELIMITER = "---";

  public static ObjectMapper jsonMapper() {
    return JSON_MAPPER;
  }

  public static ObjectMapper yamlMapper() {
    return YAML_MAPPER;
  }

  public static <T> String asJson(T object) throws KubernetesClientException {
    try {
      return JSON_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public static <T> String asYaml(T object) throws KubernetesClientException {
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
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is) throws KubernetesClientException {
    return unmarshal(is, JSON_MAPPER);
  }

  /**
   * Unmarshals a stream optionally performing placeholder substitution to the stream.
   * @param is    The {@link InputStream}.
   * @param parameters  A {@link Map} with parameters for placeholder substitution.
   * @param <T>   The target type.
   * @return returns returns de-serialized object
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, Map<String, String> parameters) throws KubernetesClientException {
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
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, ObjectMapper mapper) {
   return unmarshal(is, mapper, Collections.<String, String>emptyMap());
  }

  /**
   * Unmarshals a stream optionally performing placeholder substitution to the stream.
   * @param is          The {@link InputStream}.
   * @param mapper      The {@link ObjectMapper} to use.
   * @param parameters  A {@link Map} with parameters for placeholder substitution.
   * @param <T>         The target type.
   * @return returns de-serialized object
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, ObjectMapper mapper, Map<String, String> parameters) {
    InputStream wrapped = parameters != null && !parameters.isEmpty() ? new ReplaceValueStream(parameters).createInputStream(is) : is;
    try (BufferedInputStream bis = new BufferedInputStream(wrapped)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      if (intch != '{') {
        mapper = YAML_MAPPER;
      }
      return mapper.readerFor(KubernetesResource.class).readValue(bis);
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
   * @throws KubernetesClientException KubernetesClientException
   */
  public static<T> T unmarshal(String str, final Class<T> type) throws KubernetesClientException {
    return unmarshal(str, type, Collections.<String, String>emptyMap());
  }

  /**
   * Unmarshals a {@link String} optionally performing placeholder substitution to the String.
   * @param str         The {@link String}.
   * @param type        The target type.
   * @param <T>         Template argument denoting type
   * @param parameters  A hashmap containing parameters
   *
   * @return returns de-serialized object
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(String str, final Class<T> type, Map<String, String> parameters) throws KubernetesClientException {
    try (InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));) {
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
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, final Class<T> type) throws KubernetesClientException {
    return unmarshal(is, type, Collections.<String, String>emptyMap());
  }

  /**
   * Unmarshals an {@link InputStream} optionally performing placeholder substitution to the stream.
   * @param is              The {@link InputStream}.
   * @param type            The type.
   * @param parameters      A {@link Map} with parameters for placeholder substitution.
   * @param <T>             Template argument denoting type
   * @return returns de-serialized object
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, final Class<T> type, Map<String, String> parameters) throws KubernetesClientException {
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
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, TypeReference<T> type) throws KubernetesClientException {
   return unmarshal(is, type, Collections.<String, String>emptyMap());
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
   * @throws KubernetesClientException KubernetesClientException
   */
  public static <T> T unmarshal(InputStream is, TypeReference<T> type, Map<String, String> parameters) throws KubernetesClientException {
    InputStream wrapped = parameters != null && !parameters.isEmpty() ? new ReplaceValueStream(parameters).createInputStream(is) : is;
    try (BufferedInputStream bis = new BufferedInputStream(wrapped)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      ObjectMapper mapper = JSON_MAPPER;
      if (intch != '{') {
        mapper = YAML_MAPPER;
      }
      return mapper.readValue(bis, type);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }


  private static List<KubernetesResource> getKubernetesResourceList(Map<String, String> parameters, String specFile) {
    List<KubernetesResource> documentList = new ArrayList<>();
    String[] documents = splitSpecFile(specFile);
    for (String document : documents) {
      if (validate(document)) {
        ByteArrayInputStream documentInputStream = new ByteArrayInputStream(document.getBytes());
        Object resource = Serialization.unmarshal(documentInputStream, parameters);
        documentList.add((KubernetesResource) resource);
      }
    }
    return documentList;
  }

  private static boolean containsMultipleDocuments(String specFile) {
    String[] documents = splitSpecFile(specFile);
    int nValidDocuments = 0;
    for(String document : documents) {
      if(validate(document))
        nValidDocuments++;
    }

    return nValidDocuments > 1;
  }

  private static String[] splitSpecFile(String aSpecFile) {
    List<String> documents = new ArrayList<>();
    String[] lines = aSpecFile.split(System.lineSeparator());
    int nLine = 0;
    StringBuilder builder = new StringBuilder();

    while(nLine < lines.length) {
      if((lines[nLine].length() >= DOCUMENT_DELIMITER.length()
          && !lines[nLine].substring(0, DOCUMENT_DELIMITER.length()).equals(DOCUMENT_DELIMITER)) || (lines[nLine].length() < DOCUMENT_DELIMITER.length())) {
        builder.append(lines[nLine] + System.lineSeparator());
      } else {
        documents.add(builder.toString());
        builder.setLength(0);
      }

      nLine++;
    }

    if(!builder.toString().isEmpty())
      documents.add(builder.toString());
    return documents.toArray(new String[documents.size()]);
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
}
