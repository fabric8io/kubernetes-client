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
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class TestDeserialization {

  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    objectMapper = new ObjectMapper(new YAMLFactory()
        .enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
        .disable(YAMLGenerator.Feature.USE_NATIVE_TYPE_ID));
  }

  @Test
  void kustomizeDeserializationTest() throws Exception {
    final Kustomization kustomization = objectMapper.readValue(this.getClass().getResourceAsStream("/kustomization.yaml"),
        Kustomization.class);
    assertEquals(1, kustomization.getReplacements().size());
    assertEquals(1, kustomization.getReplacements().get(0).getTargets().size());
    assertEquals(1, kustomization.getReplacements().get(0).getTargets().get(0).getFieldPaths().size());
    assertEquals("spec.volumes.[name=.*].azureFile.shareName",
        kustomization.getReplacements().get(0).getTargets().get(0).getFieldPaths().get(0));
    assertEquals("chart", kustomization.getHelmCharts().get(0).getName());
    assertInstanceOf(RawExtension.class, kustomization.getHelmCharts().get(0).getValuesInline().get("simple"));
    assertEquals("simple-value",
        ((RawExtension) kustomization.getHelmCharts().get(0).getValuesInline().get("simple")).getValue());
    assertInstanceOf(RawExtension.class, kustomization.getHelmCharts().get(0).getValuesInline().get("complex"));
    assertInstanceOf(Map.class,
        ((RawExtension) kustomization.getHelmCharts().get(0).getValuesInline().get("complex")).getValue());
  }

  @Test
  void deserializeSerialize() throws Exception {
    final String originalWithComments = Helper.loadJson("/kustomization.yaml");
    final String original = "---\n" + originalWithComments.substring(originalWithComments.indexOf("apiVersion")).trim()
        .replace("\r\n", "\n");
    final String processed = objectMapper.writeValueAsString(objectMapper.readValue(original, Kustomization.class)).trim()
        .replace("\r\n", "\n");
    assertEquals(original, processed);
  }
}
