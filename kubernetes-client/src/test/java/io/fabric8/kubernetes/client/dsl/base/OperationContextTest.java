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
package io.fabric8.kubernetes.client.dsl.base;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.Config;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class OperationContextTest {
  private OkHttpClient okHttpClient;
  private Config config;

  @BeforeEach
  public void setUp() {
    this.okHttpClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    this.config = Mockito.mock(Config.class, Mockito.RETURNS_DEEP_STUBS);
  }

  @Test
  void testNamespaceIsSetFromOperationContext() {
    // Given
    OperationContext operationContext = new OperationContext();
    when(config.getNamespace()).thenReturn("namespace-from-config");

    // When
    operationContext = operationContext
      .withNamespace("operation-namespace")
      .withConfig(config);

    // Then
    assertNotNull(operationContext);
    assertFalse(operationContext.isNamespaceFromGlobalConfig());
    assertEquals("operation-namespace", operationContext.getNamespace());
  }

  @Test
  void testCompleteOperationContext() {
    // Given
    OperationContext operationContext = new OperationContext();

    // When
    operationContext = operationContext.withNamespace("operation-namespace")
      .withName("operand-name")
      .withConfig(config)
      .withApiGroupName("batch")
      .withApiGroupVersion("v1")
      .withOkhttpClient(okHttpClient)
      .withPlural("jobs")
      .withItem(new JobBuilder().withNewMetadata().withName("testItem").endMetadata().build())
      .withCascading(false)
      .withLabels(Collections.singletonMap("test", "labels"))
      .withLabelsIn(Collections.singletonMap("test", new String[]{"labelsIn1", "labelsIn2"}))
      .withLabelsNot(Collections.singletonMap("test", new String[]{"labelsNot"}))
      .withLabelsNotIn(Collections.singletonMap("test", new String[]{"labelsNotIn"}))
      .withFields(Collections.singletonMap("test", "field"))
      .withFieldsNot(Collections.singletonMap("test", new String[]{"fieldsNot"}))
      .withResourceVersion("234343")
      .withReloadingFromServer(false)
      .withGracePeriodSeconds(0)
      .withPropagationPolicy(DeletionPropagation.BACKGROUND);

    // Then
    assertNotNull(operationContext);
    assertEquals("operation-namespace", operationContext.getNamespace());
    assertEquals("operand-name", operationContext.getName());
    assertEquals("batch", operationContext.getApiGroupName());
    assertEquals("v1", operationContext.getApiGroupVersion());
    assertEquals("jobs", operationContext.getPlural());
    assertNotNull(operationContext.getItem());
    assertTrue(operationContext.getItem() instanceof Job);
    assertFalse(operationContext.getCascading());
    assertEquals("labels", operationContext.getLabels().get("test"));
    assertArrayEquals(new String[]{"labelsIn1", "labelsIn2"}, operationContext.getLabelsIn().get("test"));
    assertArrayEquals(new String[]{"labelsNot"}, operationContext.getLabelsNot().get("test"));
    assertArrayEquals(new String[]{"labelsNotIn"}, operationContext.getLabelsNotIn().get("test"));
    assertEquals("field", operationContext.getFields().get("test"));
    assertArrayEquals(new String[]{ "fieldsNot"}, operationContext.getFieldsNot().get("test"));
    assertEquals("234343", operationContext.getResourceVersion());
    assertFalse(operationContext.isReloadingFromServer());
    assertEquals(0, operationContext.getGracePeriodSeconds());
    assertEquals(DeletionPropagation.BACKGROUND, operationContext.getPropagationPolicy());

    assertEquals("test=labels,test!=labelsNot,test in (labelsIn1,labelsIn2),test notin (labelsNotIn)", operationContext.getLabelQueryParam());
    assertEquals("metadata.name=operand-name,test=field,test!=fieldsNot", operationContext.getFieldQueryParam());

    final String selectorAsString = "foo=bar,!baz";
    operationContext = operationContext.withLabelSelector(selectorAsString);
    assertEquals(selectorAsString, operationContext.getLabelQueryParam());
    assertEquals("metadata.name=operand-name,test=field,test!=fieldsNot", operationContext.getFieldQueryParam());
  }
}
