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
package io.fabric8.openshift.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.internal.OperationContext;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OpenShiftOperationTest {
  @Test
  void testWrapWithOpenShiftAPIGroupNameAndApiGroupEnabled() {
    // Given
    OperationContext context = new OperationContext()
      .withConfig(new OpenShiftConfigBuilder()
        .build())
      .withApiGroupName("apps.openshift.io")
      .withApiGroupVersion("v1");

    // When
    OperationContext result = OpenShiftOperation.wrap(context);

    // Then
    assertEquals("apps.openshift.io", result.getApiGroupName());
    assertEquals("v1", result.getApiGroupVersion());
  }

  @Test
  void testWrapWithOpenShiftAPIGroupNameAndApiGroupDisabled() {
    // Given
    OperationContext context = new OperationContext()
      .withConfig(new OpenShiftConfigBuilder()
        .build())
      .withApiGroupName("")
      .withApiGroupVersion("v1");

    // When
    OperationContext result = OpenShiftOperation.wrap(context);

    // Then
    assertNull(result.getApiGroupName());
    assertEquals("v1", result.getApiGroupVersion());
  }

  @Test
  void testWrapWithCoreosAPIGroupNameAndApiGroupDisabled() {
    // Given
    OperationContext context = new OperationContext()
      .withConfig(new OpenShiftConfigBuilder()
        .build())
      .withApiGroupName("operators.coreos.com")
      .withApiGroupVersion("v1alpha1");

    // When
    OperationContext result = OpenShiftOperation.wrap(context);

    // Then
    assertEquals("operators.coreos.com", result.getApiGroupName());
    assertEquals("v1alpha1", result.getApiGroupVersion());
  }

  @Test
  void testWrapWithOpenShiftAPIGroupNameWithAlphaVersion() {
    // Given
    OperationContext context = new OperationContext()
      .withConfig(new OpenShiftConfigBuilder()
        .build())
      .withApiGroupName("operator.openshift.io")
      .withApiGroupVersion("v1alpha1");

    // When
    OperationContext result = OpenShiftOperation.wrap(context);

    // Then
    assertEquals("operator.openshift.io", result.getApiGroupName());
    assertEquals("v1alpha1", result.getApiGroupVersion());
  }
}
