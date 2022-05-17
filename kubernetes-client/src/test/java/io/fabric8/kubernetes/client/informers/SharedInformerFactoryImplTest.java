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
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.informers.impl.SharedInformerFactoryImpl;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SharedInformerFactoryImplTest {
  public static final long RESYNC_PERIOD = 10 * 1000L;
  private DefaultKubernetesClient mockBaseClient;

  private static class TestCustomResourceSpec {
  }

  private static class TestCustomResourceStatus {
  }

  @Group("io.fabric8")
  @Version("v1")
  private static class TestCustomResource extends CustomResource<TestCustomResourceSpec, TestCustomResourceStatus> {
  }

  @Group("com.acme")
  @Version("v1")
  @Kind("MyApp")
  public static class MyAppCustomResource extends CustomResource<Void, Void> {
  }

  @Group("com.acme")
  @Version("v1")
  @Kind("MyApp")
  @Plural("myapps")
  public static class MyAppCustomResourceCopy extends CustomResource<Void, Void> {
  }

  @Group("networking.istio.io")
  @Version("v1alpha3")
  public static class VirtualService extends CustomResource<Void, Void> {
  }

  @Group("com.acme")
  @Version("v1")
  @Kind("FlinkJob")
  @Plural("flinkjobs")
  @ShortNames("fj")
  private static class FlinkJobCustomResource extends CustomResource<FlinkJobSpec, Void> {
    @Override
    protected FlinkJobSpec initSpec() {
      return new FlinkJobSpec();
    }
  }

  private static class FlinkJobSpec {
    private String flinkJobSpec;

    public String getFlinkJobSpec() {
      return flinkJobSpec;
    }

    public void setFlinkJobSpec(String flinkJobSpec) {
      this.flinkJobSpec = flinkJobSpec;
    }

    @Override
    public String toString() {
      return "FlinkJobSpec{flinkJobSpec='" + flinkJobSpec + "'}";
    }
  }

  @BeforeEach
  void init() {
    this.mockBaseClient = new DefaultKubernetesClient();
  }

  @Test
  void testGetExistingSharedIndexInformer() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactoryImpl(mockBaseClient);

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
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactoryImpl(mockBaseClient);

    // When
    SharedIndexInformer<MyAppCustomResource> createdInformer = sharedInformerFactory
        .sharedIndexInformerFor(MyAppCustomResource.class, RESYNC_PERIOD);
    SharedIndexInformer<MyAppCustomResource> existingInformer = sharedInformerFactory
        .getExistingSharedIndexInformer(MyAppCustomResource.class);

    // Then
    assertThat(createdInformer).isNotNull();
    assertThat(existingInformer).isNotNull();
    assertThat(createdInformer).isEqualTo(existingInformer);
  }

  @Test
  void testGetExistingSharedIndexInformerWithTwoClassesSimilarNames() {
    // Given
    SharedInformerFactory sharedInformerFactory = new SharedInformerFactoryImpl(mockBaseClient);
    sharedInformerFactory.sharedIndexInformerFor(VirtualService.class, RESYNC_PERIOD);
    sharedInformerFactory.sharedIndexInformerFor(Service.class, RESYNC_PERIOD);

    // When
    SharedIndexInformer<Service> sharedIndexInformerSvc = sharedInformerFactory.getExistingSharedIndexInformer(Service.class);
    SharedIndexInformer<VirtualService> sharedIndexInformerVSvc = sharedInformerFactory
        .getExistingSharedIndexInformer(VirtualService.class);

    // Then
    assertThat(sharedIndexInformerSvc.getApiTypeClass()).isEqualTo(Service.class);
    assertThat(sharedIndexInformerVSvc.getApiTypeClass()).isEqualTo(VirtualService.class);
  }

}
