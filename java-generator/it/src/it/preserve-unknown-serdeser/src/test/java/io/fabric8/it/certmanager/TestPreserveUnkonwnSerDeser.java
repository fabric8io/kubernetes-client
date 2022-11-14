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
import io.dapr.v1alpha1.Component;
import io.dapr.v1alpha1.ComponentSpec;
import io.fabric8.kubernetes.api.model.AnyType;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPreserveUnknownSerDeser {

  @Test
  void testDeserialization() {
    // Arrange
    Component sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample.yaml"), Component.class);

    // Act
    Map<String, Object> testObj = sample.getSpec().getTest().getAdditionalProperties();

    // Assert
    assertEquals(2, testObj.size());
    // TODO check content
  }

  private Component createSampleComponent() throws Exception {
    Component component = new Component();
    ComponentSpec spec = new ComponentSpec();

    io.dapr.v1alpha1.componentspec.Test t = new io.dapr.v1alpha1.componentspec.Test();

    t.setAdditionalProperty("one", "ONE");

    HashMap<String, Object> twoContent = new HashMap();
    twoContent.put("more", 1);
    twoContent.put("complex", true);
    t.setAdditionalProperty("two", twoContent);
    
    spec.setTest(t);

    component.setSpec(spec);
    ObjectMeta om = new ObjectMeta();
    om.setName("messagebus");
    component.setMetadata(om);

    return component;
  }

  @Test
  void testAgainstSample() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Component sample = createSampleComponent();
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }
}
