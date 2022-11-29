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
package io.fabric8.openclustermanagement.api.model.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.Application;
import io.fabric8.openclustermanagement.api.model.app.k8s.v1beta1.ApplicationBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-application.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final Application application = mapper.readValue(originalJson, Application.class);
    final String serializedJson = mapper.writeValueAsString(application);
    final Application applicationFromSerializedJson = mapper.readValue(serializedJson, Application.class);

    // Then
    assertNotNull(application);
    assertNotNull(serializedJson);
    assertNotNull(applicationFromSerializedJson);
    assertEquals(application.getMetadata().getName(), applicationFromSerializedJson.getMetadata().getName());
    assertEquals(1, application.getSpec().getComponentKinds().size());
    assertEquals("Subscription", application.getSpec().getComponentKinds().get(0).getKind());
    assertEquals("apps.open-cluster-management.io", application.getSpec().getComponentKinds().get(0).getGroup());
    assertEquals(1, application.getSpec().getSelector().getMatchLabels().size());
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    ApplicationBuilder applicationBuilder = new ApplicationBuilder()
        .withNewMetadata()
        .addToLabels("app", "nginx-app-details")
        .withName("nginx-app-3")
        .endMetadata()
        .withNewSpec()
        .addNewComponentKind("apps.open-cluster-management.io", "Subscription")
        .withNewSelector()
        .addToMatchLabels("app", "nginx-app-details")
        .endSelector()
        .endSpec();

    // When
    Application application = applicationBuilder.build();

    // Then
    assertNotNull(application);
    assertEquals("nginx-app-3", application.getMetadata().getName());
    assertEquals(1, application.getMetadata().getLabels().size());
    assertEquals(1, application.getSpec().getComponentKinds().size());
    assertEquals("apps.open-cluster-management.io", application.getSpec().getComponentKinds().get(0).getGroup());
    assertEquals("Subscription", application.getSpec().getComponentKinds().get(0).getKind());
    assertEquals(1, application.getSpec().getSelector().getMatchLabels().size());
    assertEquals(Collections.singletonMap("app", "nginx-app-details"), application.getSpec().getSelector().getMatchLabels());
  }

}
