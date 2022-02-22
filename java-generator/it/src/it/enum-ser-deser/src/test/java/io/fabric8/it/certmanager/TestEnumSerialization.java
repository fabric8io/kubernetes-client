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
package io.fabric8.it.certmanager;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import io.cert_manager.v1.CertificateRequest;
import io.cert_manager.v1.CertificateRequestSpec;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.zjsonpatch.JsonDiff;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEnumSerialization {

  ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));

  @Test
  void testDeserialization() {
    // Arrange
    CertificateRequest sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample1.yaml"), CertificateRequest.class);

    // Act
    List<CertificateRequestSpec.Usages> usagesList = sample.getSpec().getUsages();

    // Assert
    assertEquals(4, usagesList.size());
    assertEquals(CertificateRequestSpec.Usages.SIGNING, usagesList.get(0));
    assertEquals(CertificateRequestSpec.Usages.DIGITAL_SIGNATURE, usagesList.get(1));
    assertEquals(CertificateRequestSpec.Usages.SERVER_AUTH, usagesList.get(2));
    assertEquals(CertificateRequestSpec.Usages.S_MIME, usagesList.get(3));
  }

  @Test
  void testSerialization() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample1.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    JsonNode originalCRJson = yamlMapper.readTree(yamlContent);
    CertificateRequest sample = Serialization.unmarshal(yamlContent, CertificateRequest.class);

    // Act
    JsonNode resultCRJson = yamlMapper.readTree(Serialization.asYaml(sample));
    JsonNode diff = JsonDiff.asJson(originalCRJson, resultCRJson);
    List<JsonNode> aggregatedDiffs = StreamSupport.stream(diff.spliterator(), false).collect(Collectors.toList());

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }
}
