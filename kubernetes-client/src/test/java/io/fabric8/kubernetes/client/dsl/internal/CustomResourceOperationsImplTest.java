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

import java.io.IOException;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MappingJsonFactory;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CustomResourceOperationsImplTest {

  public static class MyCustomResource extends CustomResource {
  }

  public static class MyCustomResourceList extends CustomResourceList<MyCustomResource> {
  }

  private final CustomResourceDefinition crd = new CustomResourceDefinitionBuilder()
    .withNewMetadata()
      .withName("custom.name")
    .endMetadata()
    .withNewSpec()
      .withGroup("custom.group")
      .withVersion("v1alpha1")
      .withNewNames()
        .withKind("MyCustomResource")
        .withListKind("MyCustomResourceList")
        .withPlural("mycustomresources")
        .withSingular("mycustomresource")
      .endNames()
    .endSpec()
  .build();

  private final CustomResourceOperationContext context = new CustomResourceOperationContext()
    .withCrd(crd)
    .withType(MyCustomResource.class)
    .withListType(MyCustomResourceList.class);

  @Test
  public void shouldRegisterWithKubernetesDeserializer() throws IOException {
    // CustomResourceOperationsImpl constructor invokes KubernetesDeserializer::registerCustomKind
    new CustomResourceOperationsImpl<>(context);

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
