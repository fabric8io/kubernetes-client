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

import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSource;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceBuilder;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceListBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableOpenShiftMockClient
class CatalogSourceTest {

  OpenShiftMockServer server;
  OpenShiftClient client;

  @Test
  void create() {
    // Given
    CatalogSource catalogSource = getCatalogSource();
    server.expect().post()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/catalogsources")
        .andReturn(HttpURLConnection.HTTP_OK, catalogSource)
        .once();

    // When
    catalogSource = client.operatorHub().catalogSources().inNamespace("ns1").create(catalogSource);

    // Then
    assertNotNull(catalogSource);
    assertEquals("foo", catalogSource.getMetadata().getName());
  }

  @Test
  void get() {
    // Given
    server.expect().get()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/catalogsources/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getCatalogSource())
        .once();

    // When
    CatalogSource f = client.operatorHub().catalogSources().inNamespace("ns1").withName("foo").get();

    // Then
    assertNotNull(f);
    assertEquals("foo", f.getMetadata().getName());
  }

  @Test
  void list() {
    // Given
    server.expect().get()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/catalogsources")
        .andReturn(HttpURLConnection.HTTP_OK, new CatalogSourceListBuilder().withItems(getCatalogSource()).build())
        .once();

    // When
    CatalogSourceList csList = client.operatorHub().catalogSources().inNamespace("ns1").list();

    // Then
    assertNotNull(csList);
    assertNotNull(csList.getItems());
    assertEquals(1, csList.getItems().size());
  }

  @Test
  void delete() {
    // Given
    server.expect().delete()
        .withPath("/apis/operators.coreos.com/v1alpha1/namespaces/ns1/catalogsources/foo")
        .andReturn(HttpURLConnection.HTTP_OK, getCatalogSource())
        .once();

    // When
    boolean deleted = client.operatorHub().catalogSources().inNamespace("ns1").withName("foo").delete().size() == 1;

    // Then
    assertTrue(deleted);
  }

  private CatalogSource getCatalogSource() {
    return new CatalogSourceBuilder()
        .withNewMetadata().withName("foo").endMetadata()
        .withNewSpec()
        .withSourceType("Foo")
        .withImage("nginx:latest")
        .withDisplayName("Foo Bar")
        .withPublisher("Fabric8")
        .endSpec()
        .build();
  }
}
