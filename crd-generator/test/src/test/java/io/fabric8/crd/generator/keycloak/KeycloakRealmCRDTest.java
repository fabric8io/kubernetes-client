/*
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
package io.fabric8.crd.generator.keycloak;

import io.fabric8.crdv2.generator.CRDGenerator;
import io.fabric8.crdv2.generator.CRDGenerator.AbstractCRDOutput;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.IOHelpers;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeycloakRealmCRDTest {

  @Test
  void testCrd() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    CRDGenerator generator = new CRDGenerator().withOutput(new AbstractCRDOutput() {

      @Override
      protected OutputStream createStreamFor(String crdName) throws IOException {
        return baos;
      }

    });
    generator.customResourceClasses(KeycloakRealm.class);
    generator.generate();
    String result = baos.toString();

    CustomResourceDefinition d1 = Serialization.unmarshal(result,
        CustomResourceDefinition.class);

    CustomResourceDefinition d2 = Serialization.unmarshal(getClass().getClassLoader()
        .getResourceAsStream("META-INF/fabric8/keycloakrealms.sample.fabric8.io-v1.yml"),
        CustomResourceDefinition.class);

    assertEquals(IOHelpers.readFully(getClass().getClassLoader()
        .getResourceAsStream("META-INF/fabric8/keycloakrealms.sample.fabric8.io-v1.yml")), result);

    //assertNotNull(d); // just make sure it generates
  }
}
