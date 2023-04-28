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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.SecretVolumeSource;
import io.fabric8.kubernetes.api.model.SecretVolumeSourceBuilder;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/secret-it.yml")
class SecretIT {

  KubernetesClient client;

  @Test
  void load() {
    Secret aSecret = client.secrets().load(getClass().getResourceAsStream("/test-secret.yml")).item();
    assertThat(aSecret).isNotNull();
    assertEquals("my-secret", aSecret.getMetadata().getName());
  }

  @Test
  void get() {
    Secret secret1 = client.secrets().withName("secret-get").get();
    assertNotNull(secret1);
  }

  @Test
  void list() {
    SecretList aSecretList = client.secrets().list();
    assertNotNull(aSecretList);
    assertTrue(aSecretList.getItems().size() >= 1);
  }

  @Test
  void update() {
    Secret secret1 = client.secrets().withName("secret-update").edit(s -> new SecretBuilder(s)
        .editMetadata().withResourceVersion(null).addToLabels("foo", "bar").endMetadata()
        .build());
    client.secrets().withName("secret-update").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    assertThat(secret1).isNotNull();
    assertEquals("bar", secret1.getMetadata().getLabels().get("foo"));
  }

  @Test
  void delete() {
    client.secrets().withName("secret-delete").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    assertTrue(client.secrets().withName("secret-delete").delete().size() == 1);
  }

  @Test
  void testLoadInPod() {
    Secret aSecret = client.secrets().create(new SecretBuilder()
        .withNewMetadata().withName("secret2").endMetadata()
        .addToData("username", "guccifer")
        .addToData("password", "shadowgovernment")
        .build());
    SecretVolumeSource secretVolumeSource = new SecretVolumeSourceBuilder()
        .withSecretName("secret2")
        .build();

    Pod pod1 = client.pods().create(new PodBuilder()
        .withNewMetadata().withName("pod-secret1").endMetadata()
        .withNewSpec()
        .addNewContainer().withName("mysql").withImage("openshift/mysql-55-centos7").endContainer()
        .addNewVolume().withName("foo").withSecret(secretVolumeSource).endVolume()
        .endSpec()
        .build());
    assertThat(pod1).isNotNull();
    assertTrue(pod1.getSpec().getVolumes().size() > 0);

    Volume aVolume = pod1.getSpec().getVolumes().get(0);
    Secret fetchedSecret = client.secrets()
        .withName(aVolume.getSecret().getSecretName()).get();
    assertThat(fetchedSecret).isNotNull();
  }

}
