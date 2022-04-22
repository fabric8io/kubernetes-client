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
package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.openshift.api.model.TemplateInstance;
import io.fabric8.openshift.api.model.TemplateInstanceBuilder;
import io.fabric8.openshift.api.model.TemplateInstanceList;
import io.fabric8.openshift.api.model.TemplateInstanceListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThat;

@EnableOpenShiftMockClient
class TemplateInstanceTest {
  private OpenShiftClient client;
  private OpenShiftMockServer server;

  @Test
  void get() {
    // Given
    server.expect().get().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templateinstances/test-get")
        .andReturn(HttpURLConnection.HTTP_OK, createNewTemplateInstance("test-get"))
        .once();

    // When
    TemplateInstance templateInstance = client.templateInstances().inNamespace("ns1").withName("test-get").get();

    // Then
    assertThat(templateInstance)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-get");
  }

  @Test
  void list() {
    // Given
    server.expect().get().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templateinstances")
        .andReturn(HttpURLConnection.HTTP_OK, new TemplateInstanceListBuilder()
            .addToItems(createNewTemplateInstance("test-list"))
            .build())
        .once();

    // When
    TemplateInstanceList templateInstanceList = client.templateInstances().inNamespace("ns1").list();

    // Then
    assertThat(templateInstanceList).isNotNull();
    assertThat(templateInstanceList.getItems()).hasSize(1);
    assertThat(templateInstanceList.getItems().get(0))
        .hasFieldOrPropertyWithValue("metadata.name", "test-list");
  }

  @Test
  void delete() {
    // Given
    server.expect().delete().withPath("/apis/template.openshift.io/v1/namespaces/ns1/templateinstances/test-delete")
        .andReturn(HttpURLConnection.HTTP_OK, createNewTemplateInstance("test-delete"))
        .once();

    // When
    boolean isDeleted = client.templateInstances().inNamespace("ns1").withName("test-delete").delete().size() == 1;

    // Then
    assertThat(isDeleted).isTrue();
  }

  private TemplateInstance createNewTemplateInstance(String name) {
    return new TemplateInstanceBuilder()
        .withNewMetadata().withName(name).endMetadata()
        .withNewSpec()
        .withNewSecret().withName("secret").endSecret()
        .withNewTemplate()
        .withNewMetadata()
        .withName("redis-template")
        .addToAnnotations("description", "Description")
        .endMetadata()
        .addToObjects(new ConfigMapBuilder()
            .withNewMetadata().withNamespace(name).endMetadata()
            .addToData("foo", "bar")
            .build())
        .addNewParameter()
        .withDescription("Password used for Redis authentication")
        .withFrom("[A-Z0-9]{8}")
        .withGenerate("expression")
        .withName("REDIS_PASSWORD")
        .endParameter()
        .addToLabels("redis", "master")
        .endTemplate()
        .endSpec()
        .build();
  }
}
