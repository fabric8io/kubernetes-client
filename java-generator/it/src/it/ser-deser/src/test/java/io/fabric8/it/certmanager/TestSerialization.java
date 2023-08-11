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
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestSerialization {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
  ZonedDateTime datetimeValue = ZonedDateTime.parse("2017-07-21T17:32:28Z", formatter);

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

    assertEquals(datetimeValue, sample.getSpec().getDatetime());
  }

  @Test
  void testAlternativeDateDeserialization() {
    // Arrange
    CertificateRequest sample2 =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample2.yaml"), CertificateRequest.class);
    CertificateRequest sample3 =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample3.yaml"), CertificateRequest.class);
    CertificateRequest sample4 =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample4.yaml"), CertificateRequest.class);

    // Act
    ZonedDateTime datetime2 = sample2.getSpec().getDatetime();
    ZonedDateTime datetime3 = sample3.getSpec().getDatetime();
    ZonedDateTime datetime4 = sample4.getSpec().getDatetime();

    // Assert
    assertEquals(datetimeValue, datetime2);
    assertEquals(datetimeValue, datetime3);
    assertEquals(datetimeValue, datetime4);
  }

  @Test
  void testInvalidAlternativeDateDeserialization() {
    assertThrows(IllegalArgumentException.class, () -> Serialization.unmarshal(getClass().getResourceAsStream("/sample5.yaml"), CertificateRequest.class));
    assertThrows(IllegalArgumentException.class, () -> Serialization.unmarshal(getClass().getResourceAsStream("/sample6.yaml"), CertificateRequest.class));
  }

  @Test
  void testEmptyDateDeserialization() {
    // Arrange
    CertificateRequest sample7 =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample7.yaml"), CertificateRequest.class);

    // Act
    ZonedDateTime datetime = sample7.getSpec().getDatetime();

    // Assert
    assertNull(datetime);
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
