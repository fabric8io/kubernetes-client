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
package io.fabric8.crd.generator.apt.keycloak;

import io.fabric8.crd.generator.apt.AbstractCRDGeneratorCompilerTest;
import io.fabric8.kubernetes.api.model.apiextensions.v1.CustomResourceDefinition;
import io.fabric8.kubernetes.client.utils.Serialization;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class KeycloakRealmCRDTest extends AbstractCRDGeneratorCompilerTest {

  @Override
  protected String[] getJavaSources() {
    return new String[] {
        "KeycloakRealm.java"
    };
  }

  @Override
  protected String[] getExpectedCRDs() {
    return new String[] {
        "keycloakrealms.sample.fabric8.io-v1.yml",
        "keycloakrealms.sample.fabric8.io-v1beta1.yml"
    };
  }

  @Override
  protected void verify(String expectedCRDFile, String generatedCRD) {
    CustomResourceDefinition d = Serialization.unmarshal(generatedCRD, CustomResourceDefinition.class);
    assertNotNull(d); // just make sure it generates
  }
}
