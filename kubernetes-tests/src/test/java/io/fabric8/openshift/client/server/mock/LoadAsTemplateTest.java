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

import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoadAsTemplateTest {

  @Test
  public void shouldLoadPodAsTemplate() throws Exception {
    OpenShiftClient client = createOpenShiftClientWithNoServer();
    KubernetesList list = client.templates().load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).processLocally();
    assertNotNull(list);
    assertNotNull(list.getItems());
    assertEquals(1, list.getItems().size());
  }

  @Test
  public void shouldProcessLocally() throws Exception {
    OpenShiftClient client = createOpenShiftClientWithNoServer();
    Map<String, String> map = new HashMap<>();
    map.put("USERNAME", "root");
    map.put("REQUIRED", "requiredValue");

    KubernetesList list = client.templates().load(getClass().getResourceAsStream("/template-with-params.yml")).processLocally(map);
    assertListIsProcessed(list);
  }

  @Test
  public void shouldProcessLocallyWithParametersInYaml() throws Exception {
    OpenShiftClient client = createOpenShiftClientWithNoServer();

    KubernetesList list = client.templates().load(getClass().getResourceAsStream("/template-with-params.yml")).processLocally(getClass().getResourceAsStream("/parameters.yml"));
    assertListIsProcessed(list);
  }

  protected DefaultOpenShiftClient createOpenShiftClientWithNoServer() {
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
