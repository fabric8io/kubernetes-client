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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.apps.DaemonSet;
import io.fabric8.kubernetes.api.model.apps.DaemonSetBuilder;
import io.fabric8.kubernetes.api.model.apps.DaemonSetList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(ArquillianConditionalRunner.class)
@Ignore
@RequiresKubernetes
public class DaemonSetIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(DaemonSetIT.class.getResourceAsStream("/daemonset-it.yml"));
  }

  @Test
  public void get() {
    DaemonSet daemonSet = client.apps().daemonSets().inNamespace(session.getNamespace()).withName("daemonset-get").get();
    assertThat(daemonSet).isNotNull();
  }

  @Test
  public void list() {
    DaemonSetList aDaemonSetList = client.apps().daemonSets().inNamespace(session.getNamespace()).list();
    assertNotNull(aDaemonSetList);
    assertTrue(aDaemonSetList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    DaemonSet daemonSet = client.apps().daemonSets().inNamespace(session.getNamespace()).withName("daemonset-update").edit(c -> new DaemonSetBuilder(c)
      .editSpec().editTemplate().editSpec().editContainer(0)
      .withImage("quay.io/fluentd_elasticsearch/fluentd:v3.0.0")
      .endContainer().endSpec().endTemplate().endSpec()
      .build());

    assertNotNull(daemonSet);
    assertEquals("quay.io/fluentd_elasticsearch/fluentd:v3.0.0", daemonSet.getSpec().getTemplate().getSpec().getContainers().get(0).getImage());
  }

  @Test
  public void delete() {
    assertTrue(client.apps().daemonSets().inNamespace(session.getNamespace()).withName("daemonset-delete").delete());
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(DaemonSetIT.class.getResourceAsStream("/daemonset-it.yml"));
  }
}
