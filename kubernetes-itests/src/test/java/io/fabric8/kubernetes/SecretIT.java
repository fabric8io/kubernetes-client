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
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.SecretVolumeSource;
import io.fabric8.kubernetes.api.model.SecretVolumeSourceBuilder;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class SecretIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private String currentNamespace;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(SecretIT.class.getResourceAsStream("/secret-it.yml"));
  }

  @Before
  public void initNamespace() {
    this.currentNamespace = session.getNamespace();
  }

  @Test
  public void load() {
    Secret aSecret = client.secrets().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-secret.yml")).get();
    assertThat(aSecret).isNotNull();
    assertEquals("mysecret", aSecret.getMetadata().getName());
  }

  @Test
  public void get() {
    Secret secret1 = client.secrets().inNamespace(currentNamespace).withName("secret-get").get();
    assertNotNull(secret1);
  }

  @Test
  public void list() {
    SecretList aSecretList = client.secrets().inNamespace(currentNamespace).list();
    assertNotNull(aSecretList);
    assertTrue(aSecretList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<Secret> secretReady = new ReadyEntity<>(Secret.class, client, "secret-update", currentNamespace);
    Secret secret1 = client.secrets().inNamespace(currentNamespace).withName("secret-update").edit(s -> new SecretBuilder(s)
      .editOrNewMetadata().addToLabels("foo", "bar").endMetadata()
      .build());
    await().atMost(30, TimeUnit.SECONDS).until(secretReady);
    assertThat(secret1).isNotNull();
    assertEquals("bar", secret1.getMetadata().getLabels().get("foo"));
  }

  @Test
  public void delete() {
    ReadyEntity<Secret> secretReady = new ReadyEntity<>(Secret.class, client, "secret-delete", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(secretReady);
    assertTrue(client.secrets().inNamespace(currentNamespace).withName("secret-delete").delete());
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
      .withNewMetadata().withName("pod-secret1").endMetadata()
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

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(SecretIT.class.getResourceAsStream("/secret-it.yml"));
  }
}
