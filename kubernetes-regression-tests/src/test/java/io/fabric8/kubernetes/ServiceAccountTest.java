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
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ServiceAccountTest {
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
    ServiceAccount svcAccount = client.serviceAccounts().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-serviceaccount.yml")).get();
    assertThat(svcAccount).isNotNull();
    assertThat(svcAccount.getMetadata().getUid()).isNotBlank();
  }

  @Test
  public void testCrud() {
    ServiceAccount serviceAccount1 = new ServiceAccountBuilder()
      .withNewMetadata().withName("serviceaccount1").endMetadata()
      .build();
    ServiceAccount serviceAccount2 = new ServiceAccountBuilder()
      .withNewMetadata().withName("serviceaccount2").endMetadata()
      .withAutomountServiceAccountToken(false)
      .build();

    client.serviceAccounts().inNamespace(currentNamespace).create(serviceAccount1);
    client.serviceAccounts().inNamespace(currentNamespace).create(serviceAccount2);

    ServiceAccountList svcAccountList = client.serviceAccounts().inNamespace(currentNamespace).list();
    assertThat(svcAccountList).isNotNull();
    // Every namespace has a default service account resource.
    assertEquals(3, svcAccountList.getItems().size());

    serviceAccount1 = client.serviceAccounts().inNamespace(currentNamespace).withName("serviceaccount1").edit()
      .addNewSecret().withName("default-token-uudp").endSecret()
      .addNewImagePullSecret().withName("myregistrykey").endImagePullSecret()
      .done();
    assertThat(serviceAccount1).isNotNull();

    boolean bDeleted = client.serviceAccounts().inNamespace(currentNamespace).withName("serviceaccount1").delete();
    assertTrue(bDeleted);
  }
}
