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
import io.argoproj.v1alpha1.application.Operation;
import io.argoproj.v1alpha1.application.operation.InitiatedBy;
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

class TestToplevelFields {

  private Application createSampleApplication() throws Exception {
    Application application = new Application();
    ObjectMeta meta = new ObjectMeta();
    meta.setName("testapp-tl-operation");
    meta.setNamespace("mynamespace");
    application.setMetadata(meta);
    ApplicationSpec spec = new ApplicationSpec();
    application.setSpec(spec);
    spec.setProject("default");
    Destination des = new Destination();
    des.setNamespace("targetnamespace");
    des.setServer("https://kubernetes.default.svc");
    spec.setDestination(des);
    Operation op = new Operation();
    InitiatedBy initiatedBy = new InitiatedBy();
    initiatedBy.setUsername("me");
    op.setInitiatedBy(initiatedBy);
    application.setOperation(op);
    return application;
  }

  @Test
  void testAgainstSample() throws Exception {
    // Arrange
    Path resPath = Paths.get(getClass().getResource("/sample-tl-operation.yaml").toURI());
    String yamlContent = new String(Files.readAllBytes(resPath), "UTF8");
    Application sample = createSampleApplication();
    KubernetesResourceDiff diff = new KubernetesResourceDiff(yamlContent, Serialization.asYaml(sample));

    // Act
    List<JsonNode> aggregatedDiffs = diff.getListOfDiffs();

    // Assert
    assertEquals(0, aggregatedDiffs.size());
  }

}
