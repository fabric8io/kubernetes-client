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
package io.fabric8.kubernetes.client.mock;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.server.mock.KubernetesServer;
import io.fabric8.openshift.client.dsl.TemplateResource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LoadAsTemplateTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void shouldLoadPodAsTemplate() throws Exception {
    KubernetesClient client = server.getClient();
    KubernetesList list = client.load(getClass().getResourceAsStream("/test-pod-create-from-load.yml")).as(TemplateResource.class).processLocally();
    assertNotNull(list);
    assertNotNull(list.getItems());
    assertEquals(1, list.getItems().size());
  }

  @Test
  public void shouldProcessLocally() throws Exception {
    KubernetesClient client = server.getClient();
    Map<String, String> map = new HashMap<>();
    map.put("USERNAME", "root");

    KubernetesList list = client.load(getClass().getResourceAsStream("/template-with-params.yml")).as(TemplateResource.class).processLocally(map);
    assertNotNull(list);
    assertNotNull(list.getItems());
    assertEquals(1, list.getItems().size());

    final AtomicBoolean userIsRoot = new AtomicBoolean(false);
    final AtomicBoolean passwordIsNotNull = new AtomicBoolean(false);
    new KubernetesListBuilder(list).accept(new TypedVisitor<EnvVarBuilder>() {

      @Override
      public void visit(EnvVarBuilder element) {
        if (element.getName().equals("USERNAME")) {
          userIsRoot.set(element.getValue().equals("root"));
        } else if (element.getName().equals("PASSWORD")) {
          passwordIsNotNull.set(element.getValue() != null);
        }
      }
    }).build();

    assertTrue(userIsRoot.get());
    assertTrue(passwordIsNotNull.get());
  }
}
