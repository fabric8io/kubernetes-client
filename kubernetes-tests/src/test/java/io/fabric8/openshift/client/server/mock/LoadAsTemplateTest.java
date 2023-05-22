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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoadAsTemplateTest {

  private OpenShiftClient client;

  @BeforeEach
  public void setUp() {
    client = createOpenShiftClientWithNoServer();
  }

  @AfterEach
  void tearDown() {
    client.close();
    client = null;
  }

  @Test
  void shouldLoadPodAsTemplate() {
    KubernetesList list = client.templates().load(getClass().getResourceAsStream("/test-pod-create-from-load.yml"))
        .processLocally();
    assertNotNull(list);
    assertNotNull(list.getItems());
    assertEquals(1, list.getItems().size());
  }

  @Test
  void shouldProcessLocally() {
    Map<String, String> map = new HashMap<>();
    map.put("USERNAME", "root");
    map.put("REQUIRED", "requiredValue");

    KubernetesList list = client.templates().load(getClass().getResourceAsStream("/template-with-params.yml"))
        .processLocally(map);
    assertListIsProcessed(list);
  }

  @Test
  void shouldProcessLocallyWithParametersInYaml() {
    KubernetesList list = client.templates().load(getClass().getResourceAsStream("/template-with-params.yml"))
        .processLocally(new File(getClass().getResource("/parameters.yml").getFile()));
    assertListIsProcessed(list);
  }

  @Test
  void shouldProcessLocallyDoubleBracedParameters() {
    // Given
    final Map<String, String> localRequiredParameters = new HashMap<>();
    localRequiredParameters.put("USERNAME", "notTheOneInYaml");
    localRequiredParameters.put("REQUIRED", "requiredValue");
    localRequiredParameters.put("REQUIRED_BOOLEAN", "true");
    localRequiredParameters.put("CONTAINER_PORT", "8080");
    // When
    final KubernetesList result = client.templates()
        .load(getClass().getResourceAsStream("/template-with-json-params.yml"))
        .processLocally(localRequiredParameters);
    // Then
    final Container containerToAssert = ((Pod) result.getItems().get(0)).getSpec().getContainers().get(0);
    assertTrue(containerToAssert.getEnv().stream()
        .anyMatch(e -> e.getName().equals("USERNAME") && e.getValue().equals("notTheOneInYaml")));
    assertTrue(containerToAssert.getEnv().stream()
        .anyMatch(e -> e.getName().equals("REQUIRED_BOOLEAN") && e.getValue().equals("true")));
    assertTrue(containerToAssert.getPorts().stream().allMatch(p -> p.getContainerPort() == 8080));
  }

  @Test
  void shouldProcessLocallyWithDoubleBracedParametersAndParametersInYaml() {
    // Given
    final Map<String, String> nonStringParamsToBeAbleToLoad = Collections.singletonMap("CONTAINER_PORT", "8080");
    // When
    final KubernetesList result = client.templates().withParameters(nonStringParamsToBeAbleToLoad)
        .load(getClass().getResourceAsStream("/template-with-json-params.yml"))
        .processLocally(getClass().getResourceAsStream("/parameters.yml"));
    // Then
    assertListIsProcessed(result);
    final Container containerToAssert = ((Pod) result.getItems().get(0)).getSpec().getContainers().get(0);
    assertTrue(containerToAssert.getEnv().stream()
        .anyMatch(e -> e.getName().equals("REQUIRED_BOOLEAN") && e.getValue().equals("false")));
  }

  private static DefaultOpenShiftClient createOpenShiftClientWithNoServer() {
    return new DefaultOpenShiftClient(new OpenShiftConfigBuilder().withDisableApiGroupCheck(true).build());
  }

  //Check that the processed template is as expected
  private void assertListIsProcessed(KubernetesList list) {
    assertNotNull(list);
    assertNotNull(list.getItems());
    assertEquals(1, list.getItems().size());

    final AtomicBoolean userIsRoot = new AtomicBoolean(false);
    final AtomicBoolean passwordIsNotNull = new AtomicBoolean(false);
    final AtomicBoolean requiredIsSet = new AtomicBoolean(false);
    final AtomicBoolean optionalIsEmpty = new AtomicBoolean(false);
    new KubernetesListBuilder(list).accept(new TypedVisitor<EnvVarBuilder>() {

      @Override
      public void visit(EnvVarBuilder element) {
        if (element.getName().equals("USERNAME")) {
          userIsRoot.set(element.getValue().equals("root"));
        } else if (element.getName().equals("PASSWORD")) {
          passwordIsNotNull.set(Utils.isNotNullOrEmpty(element.getValue()));
        } else if (element.getName().equals("REQUIRED")) {
          requiredIsSet.set(Utils.isNotNullOrEmpty(element.getValue()));
        } else if (element.getName().equals("OPTIONAL")) {
          optionalIsEmpty.set(element.getValue().isEmpty());
        }
      }
    }).build();

    assertTrue(userIsRoot.get());
    assertTrue(passwordIsNotNull.get());
    assertTrue(requiredIsSet.get());
    assertTrue(optionalIsEmpty.get());
  }
}
