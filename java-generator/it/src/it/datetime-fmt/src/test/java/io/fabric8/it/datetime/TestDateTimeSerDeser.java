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
package io.fabric8.it.datetime;

import com.fasterxml.jackson.databind.JsonNode;
import com.example.v1.Dummy;
import com.example.v1.DummySpec;
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

class TestSerialization {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX");
  ZonedDateTime datetimeValue = ZonedDateTime.parse("2017-07-21T17:32:28Z", formatter);

  @Test
  void testDeserialization() {
    // Arrange
    Dummy sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample.yaml"), Dummy.class);

    // Act
    ZonedDateTime datetime = sample.getSpec().getMydatetime();

    // Assert
    assertEquals(datetimeValue, datetime);
  }

  @Test
  void testSerialization() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Dummy sample = Serialization.unmarshal(yamlContent, Dummy.class);
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }
}
