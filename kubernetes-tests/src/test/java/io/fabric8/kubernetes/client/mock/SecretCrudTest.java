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

import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
public class SecretCrudTest {

  KubernetesClient client;

  @Test
  public void testCrud() {

    Secret secret1 = new SecretBuilder()
        .withNewMetadata().withName("secret1").addToLabels("foo", "bar").endMetadata()
        .addToData("username", "guccifer")
        .addToData("password", "shadowgovernment")
        .addToData("secret1", "SECRET1")
        .build();

    Secret secret2 = new SecretBuilder()
        .withNewMetadata().withName("secret2").addToLabels("foo", "bar").endMetadata()
        .addToData("one", "1")
        .build();

    client.secrets().inNamespace("ns1").create(secret1);
    client.secrets().inNamespace("ns2").create(secret2);

    SecretList aSecretList = client.secrets().list();
    assertNotNull(aSecretList);
    assertEquals(0, aSecretList.getItems().size());

    aSecretList = client.secrets().inAnyNamespace().list();
    assertNotNull(aSecretList);
    assertEquals(2, aSecretList.getItems().size());

    aSecretList = client.secrets().inNamespace("ns1").list();
    assertNotNull(aSecretList);
    assertEquals(1, aSecretList.getItems().size());

    aSecretList = client.secrets().inAnyNamespace().withLabels(Collections.singletonMap("foo", "bar")).list();
    assertNotNull(aSecretList);
    assertEquals(2, aSecretList.getItems().size());

    boolean bDeleted = client.secrets().inNamespace("ns1").withName("secret1").delete().size() == 1;
    aSecretList = client.secrets().inNamespace("ns1").list();
    assertTrue(bDeleted);
    assertNotNull(aSecretList);
    assertEquals(0, aSecretList.getItems().size());

    secret2 = client.secrets().inNamespace("ns2").withName("secret2")
        .edit(s -> new SecretBuilder(s).removeFromData("one").build());
    assertNotNull(secret2);
    assertTrue(secret2.getData().isEmpty());
  }

  @Test
  void testSecretWithNoMetadataCreateFails() {
    // Given
    Secret invalidSecret = new SecretBuilder()
        .addToData("key.json", "{\"foo\":\"bar\"}")
        .build();

    // When + Then
    NonNamespaceOperation<Secret, SecretList, Resource<Secret>> secretOp = client.secrets().inNamespace("foo");
    KubernetesClientException kubernetesClientException = assertThrows(KubernetesClientException.class,
        () -> secretOp.create(invalidSecret));
    assertEquals(422, kubernetesClientException.getCode());
    assertEquals("Secret is invalid", kubernetesClientException.getStatus().getMessage());
    assertEquals(1, kubernetesClientException.getStatus().getDetails().getCauses().size());
    assertEquals("ValueRequired", kubernetesClientException.getStatus().getDetails().getCauses().get(0).getReason());
    assertEquals("Required value: metadata is required",
        kubernetesClientException.getStatus().getDetails().getCauses().get(0).getMessage());
  }
}
