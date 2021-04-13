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
package io.fabric8.crd.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.fabric8.crd.example.basic.Basic;
import io.fabric8.crd.generator.CRDGenerator.CRDOutput;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionNames;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionSpec;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceValidation;
import io.fabric8.kubernetes.client.utils.Serialization;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import org.junit.jupiter.api.Test;

public class CRDGeneratorTest {

  private final static Class<CustomResourceDefinition> crdClass = CustomResourceDefinition.class;

  @Test
  public void checkCRDGenerator() {
    CRDGenerator generator = new CRDGenerator();
    Class<Basic> customResource = Basic.class;
    TestCRDOutput output = new TestCRDOutput();
    generator.withOutput(output)
      .customResources(CustomResourceInfo.fromClass(customResource))
      .generate();

    CustomResourceDefinition definition = output.definition();
    assertNotNull(definition);
    CustomResourceDefinitionSpec spec = definition.getSpec();
    CustomResourceDefinitionNames names = spec.getNames();

    assertEquals("apiextensions.k8s.io/v1", definition.getApiVersion());
    assertEquals("Basic", names.getKind());
    assertEquals("basics", names.getPlural());
    assertEquals("Namespaced", spec.getScope());
    CustomResourceDefinitionVersion version = spec.getVersions().get(0);
    assertTrue(version.getServed());
    assertTrue(version.getStorage());
    assertNotNull(version.getSubresources());
    CustomResourceValidation schema = version.getSchema();
    assertNotNull(schema);
  }

  private static class TestCRDOutput implements CRDOutput {

    private ByteArrayOutputStream crdStream;
    private String name;

    @Override
    public OutputStream outputFor(String crdName) throws IOException {
      crdStream = new ByteArrayOutputStream();
      name = crdName;
      return crdStream;
    }

    @Override
    public URI crdURI() {
      return URI.create(name);
    }

    @Override
    public void close() throws IOException {
      crdStream.close();
    }

    CustomResourceDefinition definition() {
      return Serialization.unmarshal(new ByteArrayInputStream(crdStream.toByteArray()), crdClass);
    }
  }
}
