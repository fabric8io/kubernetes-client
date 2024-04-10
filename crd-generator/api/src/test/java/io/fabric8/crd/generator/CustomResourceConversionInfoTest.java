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
package io.fabric8.crd.generator;

import io.fabric8.crd.generator.annotation.NoneConversion;
import io.fabric8.crd.generator.annotation.WebhookConversion;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomResourceConversionInfoTest {

  @NoneConversion
  private static class ValidNoneConversionExample {
  }

  @WebhookConversion(versions = { "v1" }, url = "https://example.com")
  private static class ValidWebhookConversionUrlExample {
  }

  @WebhookConversion(versions = { "v1", "v1" }, url = "https://example.com")
  private static class WebhookConversionUrlExampleDuplicateVersions {
  }

  @WebhookConversion(versions = { "v1" }, url = "http://example.com")
  private static class WebhookConversionUrlExampleInvalidUrlSchema {
  }

  @WebhookConversion(versions = { "v1" }, url = "https://example.com?myparam=3")
  private static class WebhookConversionUrlExampleUrlHasParameter {
  }

  @WebhookConversion(versions = { "v1" }, url = "https://example.com/test#myfragment")
  private static class WebhookConversionUrlExampleUrlHasFragment {
  }

  @WebhookConversion(versions = { "v1" }, url = "example.com")
  private static class WebhookConversionExampleUrlMalformed {
  }

  @WebhookConversion(versions = { "v1" })
  private static class WebhookConversionExampleNoUrlOrService {
  }

  @WebhookConversion(versions = { "v1" }, serviceName = "my-service", serviceNamespace = "my-ns", servicePort = 99999999)
  private static class WebhookConversionExampleServicePortInvalid {
  }

  @WebhookConversion(versions = { "v1" }, serviceName = "my-service")
  private static class WebhookConversionExampleServiceNamespaceMissing {
  }

  @WebhookConversion(versions = { "v1" }, url = "https://example.com", serviceName = "my-service")
  private static class WebhookConversionExampleUrlAndServiceNameMissing {
  }

  @Test
  void givenNull_whenFrom_thenNull() {
    Optional<CustomResourceConversionInfo> info = CustomResourceConversionInfo
        .from(null, null);
    assertFalse(info.isPresent());
  }

  @Test
  void givenNoneConversionValid_whenFrom_thenSucceed() {
    Optional<CustomResourceConversionInfo> infoOptional = CustomResourceConversionInfo
        .from(ValidNoneConversionExample.class.getAnnotation(NoneConversion.class), null);

    assertTrue(infoOptional.isPresent());
    CustomResourceConversionInfo info = infoOptional.get();

    assertEquals(CustomResourceConversionInfo.Strategy.None, info.getStrategy());
    assertNull(info.getConversionReviewVersions());
    assertNull(info.getUrl());
    assertNull(info.getServiceName());
    assertNull(info.getServiceNamespace());
    assertNull(info.getServicePath());
    assertNull(info.getServicePort());

    assertNotNull(info.toString());
  }

  @Test
  void givenWebhookConversionValid_whenFrom_thenSucceed() {
    Optional<CustomResourceConversionInfo> infoOptional = CustomResourceConversionInfo
        .from(null, ValidWebhookConversionUrlExample.class.getAnnotation(WebhookConversion.class));

    assertTrue(infoOptional.isPresent());
    CustomResourceConversionInfo info = infoOptional.get();

    assertEquals(CustomResourceConversionInfo.Strategy.Webhook, info.getStrategy());
    assertNotNull(info.getConversionReviewVersions());
    assertEquals(1, info.getConversionReviewVersions().length);
    assertEquals("v1", info.getConversionReviewVersions()[0]);
    assertEquals("https://example.com", info.getUrl());
    assertNull(info.getServiceName());
    assertNull(info.getServiceNamespace());
    assertNull(info.getServicePath());
    assertNull(info.getServicePort());

    assertNotNull(info.toString());
  }

  @Test
  void givenWebhookConversionDuplicateVersions_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionUrlExampleDuplicateVersions.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals("ConversionReviewVersions values must be distinct: [v1, v1]", exception.getMessage());
  }

  @Test
  void givenWebhookConversionInvalidUrlSchema_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionUrlExampleInvalidUrlSchema.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: URL schema of http://example.com is invalid. Only https:// is allowed.",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionWithUrlHasParameter_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionUrlExampleUrlHasParameter.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: URL https://example.com?myparam=3 contains query parameters which are not allowed.",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionWithUrlHasFragment_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionUrlExampleUrlHasFragment.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CustomResourceConversionInfo
        .from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: URL https://example.com/test#myfragment contains fragment(s) which is not allowed.",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionWithMalformedUrl_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionExampleUrlMalformed.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: Malformed URL: no protocol: example.com",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionNoUrlOrService_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionExampleNoUrlOrService.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: Exactly one of URL or serviceNamespace/serviceName must be specified. serviceNamespace: null, serviceName: null, servicePath: null, servicePort: null, URL: null",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionInvalidServicePort_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionExampleServicePortInvalid.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: Service port must be a valid port number (1-65535, inclusive). ServicePort: 99999999",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionServiceNameMissing_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionExampleServiceNamespaceMissing.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: Exactly one of URL or serviceNamespace/serviceName must be specified. serviceNamespace: null, serviceName: my-service, servicePath: null, servicePort: null, URL: null",
        exception.getMessage());
  }

  @Test
  void givenWebhookConversionUrlAndServiceName_whenFrom_thenFail() {
    WebhookConversion annotation = WebhookConversionExampleUrlAndServiceNameMissing.class
        .getAnnotation(WebhookConversion.class);
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
        () -> CustomResourceConversionInfo.from(null, annotation));

    assertEquals(
        "Invalid WebhookConversion configuration: Exactly one of URL or serviceNamespace/serviceName must be specified. serviceNamespace: null, serviceName: my-service, servicePath: null, servicePort: null, URL: https://example.com",
        exception.getMessage());
  }

}
