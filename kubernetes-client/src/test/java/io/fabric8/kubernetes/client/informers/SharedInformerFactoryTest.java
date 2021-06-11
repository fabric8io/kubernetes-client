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
package io.fabric8.kubernetes.client.informers;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Version;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SharedInformerFactoryTest {
  public static final long RESYNC_PERIOD = 10 * 1000L;
  private OkHttpClient mockClient;
  private Config config;
  private ExecutorService executorService;
  private static class TestCustomResourceSpec { }
  private static class TestCustomResourceStatus { }

  @Group("io.fabric8")
  @Version("v1")
  private static class TestCustomResource extends CustomResource<TestCustomResourceSpec, TestCustomResourceStatus> { }

  @Group("com.acme")
  @Version("v1")
  @Kind("MyApp")
  public static class MyAppCustomResource extends CustomResource<Void, Void> { }

  @Group("com.acme")
  @Version("v1")
  @Kind("MyApp")
  @Plural("myapps")
  public static class MyAppCustomResourceCopy extends CustomResource<Void, Void> { }

  @Group("networking.istio.io")
  @Version("v1alpha3")
  public static class VirtualService extends CustomResource<Void, Void> { }

  @BeforeEach
  void init() {
    this.mockClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    this.config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    this.executorService = Mockito.mock(ExecutorService.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  void testInformersCreatedWithSameNameButDifferentCRDContext() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);

    // When
    sharedInformerFactory.sharedIndexInformerForCustomResource(TestCustomResource.class, new OperationContext()
      .withApiGroupVersion("v1")
      .withPlural("testcustomresources"), RESYNC_PERIOD);
    sharedInformerFactory.sharedIndexInformerForCustomResource(TestCustomResource.class, new OperationContext()
      .withApiGroupVersion("v1beta1")
      .withPlural("testcustomresources"), RESYNC_PERIOD);

    // Then
    assertThat(sharedInformerFactory.getExistingSharedIndexInformers())
      .hasSize(2);
  }

  @Test
  void testSharedIndexInformerForCustomResourceNoType() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);
    CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
      .withKind("Dummy")
      .withScope("Namespaced")
      .withVersion("v1")
      .withGroup("demos.fabric8.io")
      .withPlural("dummies")
      .build();

    // When
    sharedInformerFactory.inNamespace("ns1").sharedIndexInformerForCustomResource(context, 10 * 1000L);

    // Then
    assertThat(sharedInformerFactory.getInformers())
      .hasSize(1)
      .containsKey("demos.fabric8.io/v1/dummies/ns1");
  }

  @Test
  void testSharedIndexInformerForCustomResourceThrowsIllegalArgumentExceptionOnCoreType() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);
    CustomResourceDefinitionContext context = new CustomResourceDefinitionContext.Builder()
      .withKind("Service")
      .withScope("Namespaced")
      .withVersion("v1")
      .withGroup("")
      .withPlural("services")
      .build();

    // When + Then
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> sharedInformerFactory.sharedIndexInformerForCustomResource(context, 10 * 1000L));
    assertEquals("Using sharedIndexInformerDynamicResource for core type. Please use sharedIndexInformerFor(Class<T>, long) instead.", exception.getMessage());
  }

  @Test
  void testGetExistingSharedIndexInformer() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);

    // When
    sharedInformerFactory.sharedIndexInformerFor(Deployment.class, RESYNC_PERIOD);
    sharedInformerFactory.sharedIndexInformerFor(Pod.class, RESYNC_PERIOD);

    // Then
    assertThat(sharedInformerFactory.getExistingSharedIndexInformer(Deployment.class)).isNotNull();
    assertThat(sharedInformerFactory.getExistingSharedIndexInformer(Pod.class)).isNotNull();
  }

  @Test
  void testGetExistingSharedIndexInformerWithKindDifferentFromClassName() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);

    // When
    SharedIndexInformer<MyAppCustomResource> createdInformer = sharedInformerFactory.sharedIndexInformerFor(MyAppCustomResource.class, RESYNC_PERIOD);
    SharedIndexInformer<MyAppCustomResource> existingInformer = sharedInformerFactory.getExistingSharedIndexInformer(MyAppCustomResource.class);

    // Then
    assertThat(createdInformer).isNotNull();
    assertThat(existingInformer).isNotNull();
    assertThat(createdInformer).isEqualTo(existingInformer);
  }

  @Test
  void testGetExistingSharedIndexInformerWithTwoClassesSimilarNames() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);
    sharedInformerFactory.sharedIndexInformerFor(VirtualService.class, RESYNC_PERIOD);
    sharedInformerFactory.sharedIndexInformerFor(Service.class, RESYNC_PERIOD);

    // When
    SharedIndexInformer<Service> sharedIndexInformerSvc = sharedInformerFactory.getExistingSharedIndexInformer(Service.class);
    SharedIndexInformer<VirtualService> sharedIndexInformerVSvc = sharedInformerFactory.getExistingSharedIndexInformer(VirtualService.class);

    // Then
    assertThat(sharedIndexInformerSvc.getApiTypeClass()).isEqualTo(Service.class);
    assertThat(sharedIndexInformerVSvc.getApiTypeClass()).isEqualTo(VirtualService.class);
  }

  @Test
  void testGetExistingSharedIndexInformersReturnsListOfOperationContextAndSharedIndexInformerEntries() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);
    sharedInformerFactory.sharedIndexInformerFor(MyAppCustomResource.class, RESYNC_PERIOD);
    sharedInformerFactory.sharedIndexInformerFor(Secret.class, RESYNC_PERIOD);
    sharedInformerFactory.sharedIndexInformerFor(MyAppCustomResourceCopy.class, RESYNC_PERIOD);

    // When
    List<Map.Entry<OperationContext, SharedIndexInformer>> existingInformers = sharedInformerFactory.getExistingSharedIndexInformers();

    // Then
    assertThat(existingInformers)
      .isNotNull()
      .hasSize(3);
    assertThat(existingInformers.get(0).getKey().getPlural())
      .isEqualTo("myapps");
    assertThat(existingInformers.get(1).getKey().getPlural())
      .isEqualTo("secrets");
    assertThat(existingInformers.get(2).getKey().getPlural())
      .isEqualTo("myapps");
  }

}
