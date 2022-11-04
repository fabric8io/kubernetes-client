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
package io.fabric8.kubernetes;

import io.fabric8.junit.jupiter.api.RequireK8sVersionAtLeast;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.FieldValidateable.Validation;
import io.fabric8.kubernetes.client.dsl.NonDeletingOperation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RequireK8sVersionAtLeast(majorVersion = 1, minorVersion = 25)
class FieldValidationIT {

  KubernetesClient client;

  @Test
  void create() {
    // Given
    ConfigMap configMap = new ConfigMapBuilder()
        .withNewMetadata().withName("invalid").endMetadata().addToData("key", "value").build();
    // add an unknown field
    configMap.setAdditionalProperty("unknown", "field");

    // When
    NonDeletingOperation<ConfigMap> fieldValidation = client.configMaps().resource(configMap)
        .fieldValidation(Validation.STRICT);

    // Then
    assertThrows(KubernetesClientException.class, () -> fieldValidation.create());
  }

}
