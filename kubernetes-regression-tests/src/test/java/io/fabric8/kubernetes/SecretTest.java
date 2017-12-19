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

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SecretTest {
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
    Secret aSecret = client.secrets().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-secret.yml")).get();
    assertThat(aSecret).isNotNull();
    assertEquals("mysecret", aSecret.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    Secret secret1 = new SecretBuilder()
      .withNewMetadata().withName("secret1").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .build();

    client.secrets().inNamespace(currentNamespace).create(secret1);

    /*
     * Skipping listing tests here because Kubernetes/OpenShift create
     * some secrets just after creating namespace the API. So here we
     * won't be able to assert counts properly.
     */
    secret1 = client.secrets().inNamespace(currentNamespace).withName("secret1").edit()
      .withType("Opaque")
      .done();
    assertThat(secret1).isNotNull();
    assertEquals("Opaque", secret1.getType());

    boolean bDeleted = client.secrets().inNamespace(currentNamespace).withName("secret1").delete();
    assertTrue(bDeleted);
  }

  @Test
  public void testLoadInPod() {
    Secret aSecret = new SecretBuilder()
      .withNewMetadata().withName("secret1").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .build();

    client.secrets().inNamespace(currentNamespace).create(aSecret);
    SecretVolumeSource secretVolumeSource = new SecretVolumeSourceBuilder()
      .withSecretName("secret1")
      .build();

    Pod pod1 = client.pods().inNamespace(currentNamespace).create(new PodBuilder()
      .withNewMetadata().withName("pod1").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("mysql").withImage("openshift/mysql-55-centos7").endContainer()
      .addNewVolume().withName("foo").withSecret(secretVolumeSource).endVolume()
      .endSpec()
      .build());
    assertThat(pod1).isNotNull();
    assertTrue(pod1.getSpec().getVolumes().size() > 0);

    Volume aVolume = pod1.getSpec().getVolumes().get(0);
    Secret fetchedSecret = client.secrets().inNamespace(currentNamespace)
      .withName(aVolume.getSecret().getSecretName()).get();
    assertThat(fetchedSecret).isNotNull();
  }
}
