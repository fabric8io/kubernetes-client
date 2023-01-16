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
import io.cert_manager.v1.CertificateRequest;
import io.cert_manager.v1.CertificateRequestSpec;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEnumSerialization {

  @Test
  void testDeserialization() {
    // Arrange
    CertificateRequest sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample1.yaml"), CertificateRequest.class);

    // Act
    List<CertificateRequestSpec.Usages> usagesList = sample.getSpec().getUsages();

    // Assert
    assertEquals(5, usagesList.size());
    assertEquals(CertificateRequestSpec.Usages._EMPTY, usagesList.get(0));
    assertEquals(CertificateRequestSpec.Usages.SIGNING, usagesList.get(1));
    assertEquals(CertificateRequestSpec.Usages.DIGITAL_SIGNATURE, usagesList.get(2));
    assertEquals(CertificateRequestSpec.Usages.SERVER_AUTH, usagesList.get(3));
    assertEquals(CertificateRequestSpec.Usages.S_MIME, usagesList.get(4));
  }

  @Test
  void testSerialization() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample1.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    CertificateRequest sample = Serialization.unmarshal(yamlContent, CertificateRequest.class);
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }
}
