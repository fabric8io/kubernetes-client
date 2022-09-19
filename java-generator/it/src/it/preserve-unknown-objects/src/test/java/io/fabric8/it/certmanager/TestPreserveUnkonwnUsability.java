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
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import io.dapr.v1alpha1.Component;
import io.dapr.v1alpha1.ComponentSpec;
import io.dapr.v1alpha1.componentspec.Metadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPreserveUnknownUsability {

  @Test
  void testDeserialization() {
    // Arrange
    Component sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample.yaml"), Component.class);

    // Act
    List<Metadata> metadataList = sample.getSpec().getMetadata();

    // Assert
    assertEquals(5, metadataList.size());
  }

  private Component createSampleComponent() throws Exception {
    Component component = new Component();
    ComponentSpec spec = new ComponentSpec();
    spec.setType("pubsub.mqtt");
    spec.setVersion("v1");

    Metadata meta1 = new Metadata();
    meta1.setName("consumerID");
    meta1.setValue(new TextNode("{uuid}"));

    Metadata meta2 = new Metadata();
    meta2.setName("url");
    meta2.setValue(new TextNode("tcp://admin:public@localhost:1883"));

    Metadata meta3 = new Metadata();
    meta3.setName("qos");
    meta3.setValue(new IntNode(1));

    Metadata meta4 = new Metadata();
    meta4.setName("anArray");
    meta4.setValue(Serialization.jsonMapper().readTree("[1,2,3]"));

    Metadata meta5 = new Metadata();
    meta5.setName("anObject");
    meta5.setValue(Serialization.jsonMapper().readTree("{ \"ONE\": 1, \"TWO\": 2 }"));

    List<Metadata> lst = new ArrayList();
    lst.add(meta1);
    lst.add(meta2);
    lst.add(meta3);
    lst.add(meta4);
    lst.add(meta5);
    spec.setMetadata(lst);

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
