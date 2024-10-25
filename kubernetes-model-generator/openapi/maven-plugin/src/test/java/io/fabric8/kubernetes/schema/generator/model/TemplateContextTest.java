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
package io.fabric8.kubernetes.schema.generator.model;

import io.fabric8.kubernetes.schema.generator.GeneratorSettings;
import io.swagger.v3.oas.models.media.Schema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemplateContextTest {

  private GeneratorSettings settings;
  private TemplateContext templateContext;

  @BeforeEach
  void setUp(@TempDir File tempDir) {
    settings = GeneratorSettings.builder()
        .outputDirectory(tempDir)
        .schema(new File("../schemas/kubernetes-1.30.0.json"))
        .packageName("io.fabric8.kubernetes.api.model")
        .packageMapping(
            "io.k8s.api.core.v1", "io.fabric8.kubernetes.api.model")
        .packageMapping("io.k8s.apimachinery.pkg.apis.meta.v1", "io.fabric8.kubernetes.api.model")
        .build();

    final Schema<?> schema = (Schema<?>) settings.getOpenAPI().getComponents().getSchemas().get("io.k8s.api.core.v1.Pod");
    templateContext = new TemplateContext(settings, new AbstractMap.SimpleEntry<>("io.k8s.api.core.v1.Pod", schema));
  }

  @Test
  void classKey() {
    assertEquals("io.k8s.api.core.v1.Pod", templateContext.getClassKey());
  }

  @Test
  void classSchema() {
    assertEquals(settings.getOpenAPI().getComponents().getSchemas().get("io.k8s.api.core.v1.Pod"),
        templateContext.getClassSchema());
  }

  @Test
  void apiVersion() {
    assertEquals("", templateContext.getApiVersion().getGroup());
    assertEquals("v1", templateContext.getApiVersion().getVersion());
    assertTrue(templateContext.getApiVersion().isNamespaced());
  }

  @Test
  void packageName() {
    assertEquals("io.fabric8.kubernetes.api.model", templateContext.getPackageName());
  }

  @Test
  void inRootPackage() {
    assertTrue(templateContext.isInRootPackage());
  }

  @Test
  void classSimpleName() {
    assertEquals("Pod", templateContext.getClassSimpleName());
  }

  @Test
  void className() {
    assertEquals("io.fabric8.kubernetes.api.model.Pod", templateContext.getClassName());
  }

  @Test
  void hasMetadata() {
    assertTrue(templateContext.isHasMetadata());
  }

  @Test
  void hasMetadata_podSpec() {
    final Schema<?> schema = (Schema<?>) settings.getOpenAPI().getComponents().getSchemas().get("io.k8s.api.core.v1.PodSpec");
    templateContext = new TemplateContext(settings, new AbstractMap.SimpleEntry<>("io.k8s.api.core.v1.PodSpec", schema));
    assertFalse(templateContext.isHasMetadata());
  }

  @Test
  void kubernetesListType() {
    assertNull(templateContext.getKubernetesListType());
  }

  @Test
  void kubernetesListType_podList() {
    final Schema<?> schema = (Schema<?>) settings.getOpenAPI().getComponents().getSchemas().get("io.k8s.api.core.v1.PodList");
    templateContext = new TemplateContext(settings, new AbstractMap.SimpleEntry<>("io.k8s.api.core.v1.PodList", schema));
    assertEquals("Pod", templateContext.getKubernetesListType());
  }

  @Test
  void context() {
    assertEquals(2, templateContext.getContext().size());
    assertEquals(new HashSet<>(List.of("imports", "classInformation")), templateContext.getContext().keySet());
  }

  @Test
  void put() {
    templateContext.put("key", "value-in-context");
    assertEquals("value-in-context", templateContext.getContext().get("key"));
  }

  @Test
  void addImport() {
    templateContext.addImport("java.util.List");
    assertEquals(new HashSet<>(Collections.singletonList("java.util.List")), templateContext.getContext().get("imports"));
  }

  @Test
  void addAllImports() {
    templateContext.addAllImports(Arrays.asList("java.util.List", "java.util.Map"));
    assertEquals(new HashSet<>(Arrays.asList("java.util.List", "java.util.Map")), templateContext.getContext().get("imports"));
  }

  @Test
  void isNamespaced() {
    assertTrue(templateContext.isNamespaced());
  }

  @Test
  void isNamespaced_node() {
    final Schema<?> schema = (Schema<?>) settings.getOpenAPI().getComponents().getSchemas().get("io.k8s.api.core.v1.Node");
    templateContext = new TemplateContext(settings, new AbstractMap.SimpleEntry<>("io.k8s.api.core.v1.Node", schema));
    assertFalse(templateContext.isNamespaced());
  }

  @Test
  void isNamespaced_podSpec() {
    final Schema<?> schema = (Schema<?>) settings.getOpenAPI().getComponents().getSchemas().get("io.k8s.api.core.v1.PodSpec");
    templateContext = new TemplateContext(settings, new AbstractMap.SimpleEntry<>("io.k8s.api.core.v1.PodSpec", schema));
    assertFalse(templateContext.isNamespaced());
  }
}
