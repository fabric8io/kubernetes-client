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
package io.fabric8.it.top;

import com.fasterxml.jackson.databind.JsonNode;
import io.argoproj.v1alpha1.Application;
import io.argoproj.v1alpha1.ApplicationSpec;
import io.argoproj.v1alpha1.applicationspec.Destination;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestIgnoreUnknownTopleveObjsFromConfig {

  @Test
  void testDeserialization() {
    try {
      Application.class.getMethod("getAdditionalProperties");
      fail("No getAdditionalProperties method expected");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }

  private Application createSampleApplicationNoAdditionalFields(String name) throws Exception {
    Application application = new Application();
    ObjectMeta meta = new ObjectMeta();
    meta.setName(name);
    meta.setNamespace("mynamespace");
    application.setMetadata(meta);
    ApplicationSpec spec = new ApplicationSpec();
    application.setSpec(spec);
    spec.setProject("default");
    Destination des = new Destination();
    des.setNamespace("targetnamespace");
    des.setServer("https://kubernetes.default.svc");
    spec.setDestination(des);
    return application;
  }

  @Test
  void testAgainstSampleNoAdditionalFields() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample-no-addprops.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Application sample = createSampleApplicationNoAdditionalFields("testapp-no-addprops");
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }

  @Test
  void testAgainstSampleWithAdditionalFields() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample-addprops.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Application sample = createSampleApplicationNoAdditionalFields(" testapp-addprops");
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    // We expect 6 additional fields that are not available in the sample object
    assertEquals(6, aggregatedDiffs.size());
  }
}
