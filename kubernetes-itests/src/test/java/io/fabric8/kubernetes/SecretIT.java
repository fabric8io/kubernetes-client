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

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
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

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class SecretIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private Secret secret1;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    secret1 = new SecretBuilder()
      .withNewMetadata().withName("secret1").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .build();

    client.secrets().inNamespace(currentNamespace).createOrReplace(secret1);
  }

  @Test
  public void load() {
    Secret aSecret = client.secrets().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-secret.yml")).get();
    assertThat(aSecret).isNotNull();
    assertEquals("mysecret", aSecret.getMetadata().getName());
  }

  @Test
  public void get() {
    secret1 = client.secrets().inNamespace(currentNamespace).withName("secret1").get();
    assertNotNull(secret1);
  }

  @Test
  public void list() {
    SecretList aSecretList = client.secrets().inNamespace(currentNamespace).list();
    assertNotNull(aSecretList);
    assertTrue(aSecretList.getItems().size() > 1);
  }

  @Test
  public void update() {
    ReadyEntity<Secret> secretReady = new ReadyEntity<>(Secret.class, client, "secret1", currentNamespace);
    secret1 = client.secrets().inNamespace(currentNamespace).withName("secret1").edit()
      .withType("Opaque")
      .done();
    await().atMost(30, TimeUnit.SECONDS).until(secretReady);
    assertThat(secret1).isNotNull();
    assertEquals("Opaque", secret1.getType());
  }

  @Test
  public void delete()
  {
    ReadyEntity<Secret> secretReady = new ReadyEntity<>(Secret.class, client, "secret1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(secretReady);
    assertTrue(client.secrets().inNamespace(currentNamespace).withName("secret1").delete());
  }

  @After
  public void cleanup() throws InterruptedException {
    if (client.secrets().inNamespace(currentNamespace).list().getItems().size()!= 0) {
      client.secrets().inNamespace(currentNamespace).withName("secret1").delete();
    }
    // Wait for resources to get destroyed
    DeleteEntity<Secret> secretDelete = new DeleteEntity<>(Secret.class, client, "secret1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(secretDelete);
  }

  @Test
  public void testLoadInPod() {
    String currentNamespace = session.getNamespace();
    Secret aSecret = new SecretBuilder()
      .withNewMetadata().withName("secret2").endMetadata()
      .addToData("username", "guccifer")
      .addToData("password", "shadowgovernment")
      .build();

    client.secrets().inNamespace(currentNamespace).create(aSecret);
    SecretVolumeSource secretVolumeSource = new SecretVolumeSourceBuilder()
      .withSecretName("secret2")
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
