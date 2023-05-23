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
package io.fabric8.it.dummy;

import com.fasterxml.jackson.databind.JsonNode;
import com.example.v1.Dummy;
import com.example.v1.DummySpec;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEscapeCharacters {

  @Test
  void testDeserialization() {
    // Arrange
    Dummy sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample.yaml"), Dummy.class);

    // Act
    DummySpec spec = sample.getSpec();

    // Assert
    assertEquals("0", spec.getZero());
    assertEquals("1", spec.getOne_dot());
    assertEquals("2", spec.getTwo_space());
    assertEquals("3", spec.getThree_quote());
    assertEquals("4", spec.getFour_doublequote());
    assertEquals("5", spec.getFive_slash());
  }

  @Test
  void testAgainstSample() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Dummy sample = new Dummy();
    DummySpec spec = new DummySpec();
    spec.setZero("0");
    spec.setOne_dot("1");
    spec.setTwo_space("2");
    spec.setThree_quote("3");
    spec.setFour_doublequote("4");
    spec.setFive_slash("5");
    sample.setSpec(spec);
    ObjectMeta om = new ObjectMeta();
    om.setName("sample");
    sample.setMetadata(om);
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }
}
