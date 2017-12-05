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
package io.fabric8.kubernetes.client.internal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.client.internal.serializationmixins.ObjectMetaMixIn;
import io.fabric8.kubernetes.client.internal.serializationmixins.ReplicationControllerMixIn;
import io.fabric8.kubernetes.client.utils.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerializationUtils {

  private static final String DOCUMENT_DELIMITER = "---";

  private static ObjectMapper mapper;

  private static ObjectMapper statelessMapper;

  public static ObjectMapper getStatelessMapper() {
    if (statelessMapper == null) {
      statelessMapper = new ObjectMapper(new YAMLFactory());
      statelessMapper.addMixInAnnotations(ObjectMeta.class, ObjectMetaMixIn.class);
      statelessMapper.addMixInAnnotations(ReplicationController.class, ReplicationControllerMixIn.class);
    }
    return statelessMapper;
  }

  public static ObjectMapper getMapper() {
    if (mapper == null) {
      mapper = new ObjectMapper(new YAMLFactory());
    }
    return mapper;
  }

  public static String dumpAsYaml(HasMetadata obj) throws JsonProcessingException {
    return getMapper().writeValueAsString(obj);
  }

  public static String dumpWithoutRuntimeStateAsYaml(HasMetadata obj) throws JsonProcessingException {
    return getStatelessMapper().writeValueAsString(obj);
  }

  public static Object unmarshal(InputStream inputStream, Map<String, String> parameters) {
    String specFile = readSpecFileFromInputStream(inputStream);
    if (containsMultipleDocuments(specFile)) {
      return getKubernetesResourceList(parameters, specFile);
    }
    return Serialization.unmarshal(new ByteArrayInputStream(specFile.getBytes()), parameters);
  }

  private static List<KubernetesResource> getKubernetesResourceList(Map<String, String> parameters, String specFile) {
    List<KubernetesResource> documentList = new ArrayList<>();
    String[] documents = specFile.split(DOCUMENT_DELIMITER);
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
    Pattern p = Pattern.compile(DOCUMENT_DELIMITER);
    Matcher m = p.matcher(specFile);
    int count = 0;
    while (m.find()) {
      count++;
    }
    if (count == 1) {
      String[] documents = specFile.split(DOCUMENT_DELIMITER);
      return validate(documents[0]);
    }
    return count > 1;
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
