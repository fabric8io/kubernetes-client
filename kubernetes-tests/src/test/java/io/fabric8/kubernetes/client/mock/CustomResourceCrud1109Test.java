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

import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.mock.crd.FooBar;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@EnableKubernetesMockClient(crud = true)
class CustomResourceCrud1109Test {

  KubernetesMockServer server;
  KubernetesClient client;

  private CustomResourceDefinition customResourceDefinition;
  private MixedOperation<FooBar, KubernetesResourceList<FooBar>, Resource<FooBar>> fooBarClient;

  @BeforeEach
  void setUp() {
    customResourceDefinition = client.apiextensions().v1beta1().customResourceDefinitions()
        .create(CustomResourceDefinitionContext.v1beta1CRDFromCustomResourceType(FooBar.class).build());
    fooBarClient = client.resources(FooBar.class);
  }

  @Test
  @DisplayName("Generated customResourceDefinition has dashes in singular and plural but not in kind")
  void testGeneratedCRDHasDashesInNamesButNotInKind() {
    assertThat(customResourceDefinition)
        .hasFieldOrPropertyWithValue("spec.names.kind", "FooBar")
        .hasFieldOrPropertyWithValue("spec.names.singular", "foo-bar")
        .hasFieldOrPropertyWithValue("spec.names.plural", "foo-bars");
  }

  @Test
  @DisplayName("KubernetesCrudDispatcher, HTTP requests are performed to dashed plural (not to lower-cased kind)")
  void testRequestsArePerformedToDashedPath() throws Exception {
    // When
    fooBarClient.inNamespace("my-namespace").list();
    // Then

    assertThat(server.getLastRequest())
        .hasFieldOrPropertyWithValue("path", "/apis/baz.example.com/v1alpha1/namespaces/my-namespace/foo-bars");
  }

  @Test
  @DisplayName("Get single CR resource, with CR created through KubernetesCrudDispatcher, should perform GET to crd list with dashed plural")
  void test1109GetSingleResource() {
    // Given
    final FooBar fb1 = new FooBar();
    fb1.getMetadata().setName("example");
    fooBarClient.inNamespace("default").create(fb1);
    // When
    final FooBar fooBar = fooBarClient.inNamespace("default").withName("example").get();
    // Then
    assertThat(fooBar)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example")
        .hasFieldOrPropertyWithValue("kind", "FooBar")
        .isNotSameAs(fb1);
  }

  @Test
  @DisplayName("Get CR list, with CR created through KubernetesCrudDispatcher, should perform GET to crd list with dashed plural")
  void test1109GetList() {
    // Given
    final FooBar fb1 = new FooBar();
    fb1.getMetadata().setName("example");
    fooBarClient.inNamespace("default").create(fb1);
    // When
    final KubernetesResourceList<FooBar> fooBarList = fooBarClient.inNamespace("default").list();
    // Then
    assertThat(fooBarList)
        .isNotNull()
        .extracting(KubernetesResourceList::getItems)
        .asList()
        .hasSize(1);
  }
}
