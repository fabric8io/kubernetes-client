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
package io.fabric8.camelk;

import org.junit.jupiter.api.Test;

import io.fabric8.camelk.v1alpha1.Kamelet;
import io.fabric8.camelk.v1alpha1.KameletBuilder;
import io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaPropsBuilder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ModelTest {

  @Test
  void shouldCreateKamelet()  {
    Kamelet kamelet = new KameletBuilder()
      .withNewMetadata()
      .withName("my-kamelet")
      .endMetadata()
      .withNewSpec()
      .withDefinition(new JSONSchemaPropsBuilder()
                      // blah blah
                      .build())
      .endSpec()
      .build();
  }
}

