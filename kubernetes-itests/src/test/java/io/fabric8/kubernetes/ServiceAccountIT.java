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
import io.fabric8.commons.ReadyEntity;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ServiceAccountIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(ServiceAccountIT.class.getResourceAsStream("/serviceaccount-it.yml"));
  }

  @Test
  public void load() {
    ServiceAccount svcAccount = client.serviceAccounts().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-serviceaccount.yml")).get();
    assertThat(svcAccount).isNotNull();
    assertThat(svcAccount.getMetadata().getName()).isNotNull();
  }

  @Test
  public void get() {
    ServiceAccount serviceAccount1 = client.serviceAccounts().inNamespace(session.getNamespace()).withName("sa-get").get();
    assertNotNull(serviceAccount1);
  }

  @Test
  public void list() {
    ServiceAccountList svcAccountList = client.serviceAccounts().inNamespace(session.getNamespace()).list();
    assertThat(svcAccountList).isNotNull();
    // Every namespace has a default service account resource.
    assertTrue(svcAccountList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<ServiceAccount> serviceAccountReady = new ReadyEntity<>(ServiceAccount.class, client, "sa-update", session.getNamespace());
    ServiceAccount serviceAccount1 = client.serviceAccounts().inNamespace(session.getNamespace()).withName("sa-update").edit(s -> new ServiceAccountBuilder(s)
      .addNewSecret().withName("default-token-uudp").endSecret()
      .addNewImagePullSecret().withName("myregistrykey").endImagePullSecret()
      .build());
    await().atMost(30, TimeUnit.SECONDS).until(serviceAccountReady);
    assertThat(serviceAccount1).isNotNull();
  }

  @Test
  public void delete() {
    ReadyEntity<ServiceAccount> serviceAccountReady = new ReadyEntity<>(ServiceAccount.class, client, "sa-delete", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(serviceAccountReady);
    boolean bDeleted = client.serviceAccounts().inNamespace(session.getNamespace()).withName("sa-delete").delete();
    assertTrue(bDeleted);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(ServiceAccountIT.class.getResourceAsStream("/serviceaccount-it.yml"));
  }
}
