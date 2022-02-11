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
package io.fabric8.kubernetes.client.dsl.internal;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.Assert.assertThat;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ResourceOperationsImplTest {

  @Group(MyCustomResource.GROUP)
  @Version(MyCustomResource.VERSION)
  public static class MyCustomResource extends CustomResource {
    public static final String GROUP = "custom.group";
    public static final String VERSION = "v1alpha1";
  }

  public static class MyCustomResourceList extends CustomResourceList<MyCustomResource> {
  }
  
  @Group("sample.fabric8.io")
  @Version("v1")
  public static class Bar extends CustomResource {}

  private final CustomResourceDefinition crd = CustomResourceDefinitionContext.v1beta1CRDFromCustomResourceType(MyCustomResource.class).build();

  @Test
  void shouldBeAbleToReturnOperationsWithoutSpecificList() {
    final MixedOperation<Bar, CustomResourceList, Resource<Bar>> operation = new DefaultKubernetesClient().customResources(Bar.class, CustomResourceList.class);
    assertNotNull(operation);
  }
  
  @Test
  void shouldRegisterWithKubernetesDeserializer() throws IOException {
    assertForContext(new OperationContext(), CustomResourceDefinitionContext.fromCrd(crd), MyCustomResource.class, MyCustomResourceList.class);
  }
  
  @Test
  void shouldWorkWithPlainCustomResourceList() throws IOException {
    assertForContext(new OperationContext(), CustomResourceDefinitionContext.fromCrd(crd), MyCustomResource.class, CustomResourceList.class);
  }

  @Test
  void itFallsBackOnTypeKindIfNoKindSpecifiedInContext() throws IOException {
    ResourceDefinitionContext rdc = new ResourceDefinitionContext.Builder()
        .withGroup(crd.getSpec().getGroup())
        .withVersion(crd.getSpec().getVersion())
        .withPlural(crd.getSpec().getNames().getPlural())
        .build();

    assertForContext(new OperationContext(), rdc, MyCustomResource.class, MyCustomResourceList.class);
  }
  
  private <T extends HasMetadata, L extends KubernetesResourceList<T>> void assertForContext(OperationContext context, ResourceDefinitionContext rdc, Class<T> type, Class<L> listType) throws IOException {
    // ResourceOperationsImpl constructor invokes KubernetesDeserializer::registerCustomKind
    new HasMetadataOperationsImpl<>(context, rdc, type, listType);

    JsonFactory factory = new MappingJsonFactory();
    JsonParser parser = factory.createParser("{\n" +
      "    \"apiVersion\": \"custom.group/v1alpha1\",\n" +
      "    \"kind\": \"MyCustomResource\"\n" +
      "}");

    KubernetesDeserializer deserializer = new KubernetesDeserializer();
    KubernetesResource resource = deserializer.deserialize(parser, null);

    assertThat(resource, instanceOf(MyCustomResource.class));
    assertEquals("custom.group/v1alpha1", ((MyCustomResource) resource).getApiVersion());
  }
}
