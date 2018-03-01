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

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ServiceAccountIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private ServiceAccount serviceAccount1, serviceAccount2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    serviceAccount1 = new ServiceAccountBuilder()
      .withNewMetadata().withName("serviceaccount1").endMetadata()
      .build();
    serviceAccount2 = new ServiceAccountBuilder()
      .withNewMetadata().withName("serviceaccount2").endMetadata()
      .withAutomountServiceAccountToken(false)
      .build();

    client.serviceAccounts().inNamespace(currentNamespace).create(serviceAccount1);
    client.serviceAccounts().inNamespace(currentNamespace).create(serviceAccount2);
  }

  @Test
  public void load() {
    ServiceAccount svcAccount = client.serviceAccounts().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-serviceaccount.yml")).get();
    assertThat(svcAccount).isNotNull();
    assertThat(svcAccount.getMetadata().getUid()).isNotBlank();
  }

  @Test
  public void get() {
    serviceAccount1 = client.serviceAccounts().inNamespace(currentNamespace).withName("serviceaccount1").get();
    assertNotNull(serviceAccount1);
    serviceAccount2 = client.serviceAccounts().inNamespace(currentNamespace).withName("serviceaccount2").get();
    assertNotNull(serviceAccount2);
  }

  @Test
  public void list() {
    ServiceAccountList svcAccountList = client.serviceAccounts().inNamespace(currentNamespace).list();
    assertThat(svcAccountList).isNotNull();
    // Every namespace has a default service account resource.
    assertTrue(svcAccountList.getItems().size() >= 2);
  }

  @Test
  public void update() {
    serviceAccount1 = client.serviceAccounts().inNamespace(currentNamespace).withName("serviceaccount1").edit()
      .addNewSecret().withName("default-token-uudp").endSecret()
      .addNewImagePullSecret().withName("myregistrykey").endImagePullSecret()
      .done();
    assertThat(serviceAccount1).isNotNull();
  }

  @Test
  public void delete() {
    boolean bDeleted = client.serviceAccounts().inNamespace(currentNamespace).withName("serviceaccount1").delete();
    assertTrue(bDeleted);
  }

  @After
  public void cleanup() throws InterruptedException {
    client.serviceAccounts().inNamespace(currentNamespace).delete();
    // Wait for resources to get destroyed
    Thread.sleep(30000);
  }
}
