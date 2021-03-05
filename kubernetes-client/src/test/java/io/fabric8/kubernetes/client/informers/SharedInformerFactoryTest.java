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
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.concurrent.ExecutorService;

import static io.fabric8.kubernetes.client.informers.SharedInformerFactory.getInformerKey;
import static org.assertj.core.api.Assertions.assertThat;

class SharedInformerFactoryTest {
  private OkHttpClient mockClient;
  private Config config;
  private ExecutorService executorService;
  private static class TestCustomResourceSpec { }
  private static class TestCustomResourceStatus { }

  @Group("io.fabric8")
  @Version("v1")
  private static class TestCustomResource extends CustomResource<TestCustomResourceSpec, TestCustomResourceStatus> { }

  @BeforeEach
  void init() {
    this.mockClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    this.config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    this.executorService = Mockito.mock(ExecutorService.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  void testGetInformerKey() {
    assertThat(getInformerKey(new OperationContext()
      .withApiGroupVersion("v1")
      .withPlural("pods"))).isEqualTo("v1/pods");
    assertThat(getInformerKey(new OperationContext()
      .withApiGroupVersion("v1")
      .withNamespace("ns1")
      .withPlural("pods"))).isEqualTo("v1/pods/ns1");
    assertThat(getInformerKey(new OperationContext()
      .withApiGroupVersion("v1")
      .withApiGroupName("io.fabric8")
      .withPlural("testcustomresources"))).isEqualTo("io.fabric8/v1/testcustomresources");
    assertThat(getInformerKey(new OperationContext()
      .withApiGroupVersion("v1beta1")
      .withApiGroupName("io.fabric8")
      .withPlural("testcustomresources"))).isEqualTo("io.fabric8/v1beta1/testcustomresources");
    assertThat(getInformerKey(new OperationContext()
      .withApiGroupVersion("v1beta1")
      .withApiGroupName("extensions")
      .withPlural("deployments"))).isEqualTo("extensions/v1beta1/deployments");
  }

  @Test
  void testInformersCreatedWithSameNameButDifferentCRDContext() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);

    // When
    sharedInformerFactory.sharedIndexInformerForCustomResource(TestCustomResource.class, new OperationContext()
      .withApiGroupVersion("v1")
      .withPlural("testcustomresources"), 10 * 1000L);
    sharedInformerFactory.sharedIndexInformerForCustomResource(TestCustomResource.class, new OperationContext()
      .withApiGroupVersion("v1beta1")
      .withPlural("testcustomresources"), 10 * 1000L);

    // Then
    assertThat(sharedInformerFactory.getInformers())
      .hasSize(2);
  }

  @Test
  void testGetExistingSharedIndexInformer() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactory(executorService, mockClient, config);

    // When
    sharedInformerFactory.sharedIndexInformerFor(Deployment.class, 10 * 1000L);
    sharedInformerFactory.sharedIndexInformerFor(Pod.class, 10 * 1000L);

    // Then
    assertThat(sharedInformerFactory.getExistingSharedIndexInformer(Deployment.class)).isNotNull();
    assertThat(sharedInformerFactory.getExistingSharedIndexInformer(Pod.class)).isNotNull();
  }

}
