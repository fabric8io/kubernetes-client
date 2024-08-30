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
import io.fabric8.kubernetes.api.model.AnyType;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;
import io.fabric8.java.generator.testing.KubernetesResourceDiff;
import io.argoproj.v1alpha1.Application;
import io.argoproj.v1alpha1.ApplicationSpec;
import io.argoproj.v1alpha1.applicationspec.Destination;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPreserveUnknownToplevelObjectsFromConfig {

  @Test
  void testDeserialization() {
    // Arrange
    Application sample =
      Serialization.unmarshal(getClass().getResourceAsStream("/sample-addprops.yaml"), Application.class);
    // Assert
    assertEquals(5, sample.getAdditionalProperties().size());
  }

  private Application createSampleApplicationAdditionalFields() throws Exception {
    Application application = new Application();
    ObjectMeta meta = new ObjectMeta();
    meta.setName("testapp-addprops");
    meta.setNamespace("mynamespace");
    application.setMetadata(meta);
    ApplicationSpec spec = new ApplicationSpec();
    application.setSpec(spec);
    spec.setProject("default");
    Destination des = new Destination();
    des.setNamespace("targetnamespace");
    des.setServer("https://kubernetes.default.svc");
    spec.setDestination(des);
    application.setAdditionalProperty("consumerID", new AnyType("{uuid}"));
    application.setAdditionalProperty("url", new AnyType("tcp://admin:public@localhost:1883"));
    application.setAdditionalProperty("qos", new AnyType(1));
    application.setAdditionalProperty("anArray", new AnyType(new int[]{1, 2, 3}));
   
    Map<String, Object> obj = new HashMap();
    obj.put("ONE", 1);
    obj.put("TWO", 2);
    application.setAdditionalProperty("anObject", new AnyType(obj));
    return application;
  }

  @Test
  void testAgainstSampleAdditionalFields() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample-addprops.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Application sample = createSampleApplicationAdditionalFields();
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }
}
