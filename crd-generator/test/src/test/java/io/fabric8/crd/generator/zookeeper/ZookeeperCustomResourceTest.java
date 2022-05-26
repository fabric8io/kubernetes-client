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
package io.fabric8.crd.generator.zookeeper;

import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionVersion;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ZookeeperCustomResourceTest {

  @Test
  void testCrd() {
    CustomResourceDefinition d = Serialization.unmarshal(
        getClass().getClassLoader().getResourceAsStream("META-INF/fabric8/zookeepers.io.zookeeper-v1beta1.yml"),
        CustomResourceDefinition.class);
    assertNotNull(d);
    assertEquals("Zookeeper", d.getSpec().getNames().getKind());
    assertEquals("zookeepers", d.getSpec().getNames().getPlural());
    assertEquals("Namespaced", d.getSpec().getScope());

    assertNotNull(d.getSpec().getSubresources());

    assertEquals(".status.size", d.getSpec().getSubresources().getScale().getStatusReplicasPath());
    assertEquals(".spec.size", d.getSpec().getSubresources().getScale().getSpecReplicasPath());
    assertNotNull(d.getSpec().getSubresources().getStatus());

    Optional<CustomResourceDefinitionVersion> v1 = d.getSpec().getVersions().stream().filter(v -> v.getName().equals("v1"))
        .findFirst();
    assertTrue(v1.isPresent());
    v1.ifPresent(v -> {
      //Let's check that version is marked as required
      Object spec = v.getSchema().getOpenAPIV3Schema().getProperties().get("spec");
      assertNotNull(spec);
      JSONSchemaProps props = (JSONSchemaProps) spec;
      List<String> required = props.getRequired();
      assertTrue(required.contains("version"));
    });

    Optional<CustomResourceDefinitionVersion> v1alpha1 = d.getSpec().getVersions().stream()
        .filter(v -> v.getName().equals("v1alpha1")).findFirst();
    assertTrue(v1alpha1.isPresent());
    v1.ifPresent(v -> {
      //Let's check that version is marked as required
      Object spec = v.getSchema().getOpenAPIV3Schema().getProperties().get("spec");
      assertNotNull(spec);
      JSONSchemaProps props = (JSONSchemaProps) spec;
      List<String> required = props.getRequired();
      assertTrue(required.contains("version"));
    });

  }
}
