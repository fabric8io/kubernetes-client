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

package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReplicaSetTest {
  public static KubernetesClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultKubernetesClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    Namespace aNamespace = new NamespaceBuilder().withNewMetadata().withName(currentNamespace).and().build();
    client.namespaces().create(aNamespace);
  }

  @AfterClass
  public static void cleanup() {
    client.namespaces().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testLoad() {
    ReplicaSet replicaSet = client.extensions().replicaSets().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-replicaset.yml")).get();
    assertThat(replicaSet).isNotNull();
    assertEquals("frontend", replicaSet.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    Map<String, Quantity> requests = new HashMap<>();
    requests.put("cpu", new Quantity("100m"));
    requests.put("memory", new Quantity("100Mi"));

    List<EnvVar> envVarList = new ArrayList<>();
    envVarList.add(new EnvVar("name", "GET_HOSTS_FROM", null));
    envVarList.add(new EnvVar("value", "dns", null));

    ReplicaSet replicaset1 = new ReplicaSetBuilder()
      .withNewMetadata()
      .withName("replicaset1")
      .addToLabels("app", "guestbook")
      .addToLabels("tier", "frontend")
      .endMetadata()
      .withNewSpec()
      .withReplicas(3)
      .withNewSelector()
      .withMatchLabels(Collections.singletonMap("tier", "frontend"))
      .endSelector()
      .withNewTemplate()
      .withNewMetadata()
      .addToLabels("app", "guestbook")
      .addToLabels("tier", "frontend")
      .endMetadata()
      .withNewSpec()
      .addNewContainer()
      .withName("php-redis")
      .withImage("kubernetes/example-guestbook-php-redis")
      .withNewResources()
      .withRequests(requests)
      .endResources()
      .withEnv(envVarList)
      .addNewPort()
      .withContainerPort(80)
      .endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    client.extensions().replicaSets().inNamespace(currentNamespace).create(replicaset1);

    ReplicaSetList replicaSetList = client.extensions().replicaSets().inNamespace(currentNamespace).list();
    assertThat(replicaSetList).isNotNull();
    assertEquals(1, replicaSetList.getItems().size());

    replicaset1 = client.extensions().replicaSets().inNamespace(currentNamespace).withName("replicaset1").edit()
      .editSpec().withReplicas(5).endSpec().done();
    assertThat(replicaset1).isNotNull();
    assertEquals(5, replicaset1.getSpec().getReplicas().intValue());

    boolean bDeleted = client.extensions().replicaSets().inNamespace(currentNamespace).withName("replicaset1").delete();
    assertTrue(bDeleted);
  }
}
