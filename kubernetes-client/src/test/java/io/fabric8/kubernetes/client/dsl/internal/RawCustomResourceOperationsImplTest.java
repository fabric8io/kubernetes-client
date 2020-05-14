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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RawCustomResourceOperationsImplTest {
  private OkHttpClient mockClient;
  private Config config;
  private CustomResourceDefinitionContext customResourceDefinitionContext;

  @BeforeEach
  public void setUp() {
    this.mockClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    this.config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    this.customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
      .withGroup("test.fabric8.io")
      .withName("hellos.test.fabric8.io")
      .withPlural("hellos")
      .withScope("Namespaced")
      .withVersion("v1alpha1")
      .build();
  }

  @Test
  public void testFetchWatchUrlWithNamespace() throws MalformedURLException {
    // Given
    RawCustomResourceOperationsImpl rawCustomResourceOperations = new RawCustomResourceOperationsImpl(mockClient, config, customResourceDefinitionContext);

    // When
    HttpUrl url = rawCustomResourceOperations.fetchWatchUrl("test", null, null, new ListOptionsBuilder().withWatch(true).build()).build();

    // Then
    assertEquals("https://localhost:8443/apis/test.fabric8.io/v1alpha1/namespaces/test/hellos?watch=true", url.url().toString());
  }

  @Test
  public void testFetchWatchUrlWithNamespaceAndName() throws MalformedURLException {
    // Given
    RawCustomResourceOperationsImpl rawCustomResourceOperations = new RawCustomResourceOperationsImpl(mockClient, config, customResourceDefinitionContext);

    // When
    HttpUrl url = rawCustomResourceOperations.fetchWatchUrl("test", "example-resource", null, new ListOptionsBuilder().withWatch(true).build()).build();

    // Then
    assertEquals("https://localhost:8443/apis/test.fabric8.io/v1alpha1/namespaces/test/hellos?fieldSelector=metadata.name%3Dexample-resource&watch=true", url.url().toString());
  }

  @Test
  public void testFetchWatchUrlWithNamespaceAndNameAndResourceVersion() throws MalformedURLException {
    // Given
    RawCustomResourceOperationsImpl rawCustomResourceOperations = new RawCustomResourceOperationsImpl(mockClient, config, customResourceDefinitionContext);

    // When
    HttpUrl url = rawCustomResourceOperations.fetchWatchUrl("test", "example-resource", null, new ListOptionsBuilder().withResourceVersion("100069").withWatch(true).build()).build();

    // Then
    assertEquals("https://localhost:8443/apis/test.fabric8.io/v1alpha1/namespaces/test/hellos?fieldSelector=metadata.name%3Dexample-resource&resourceVersion=100069&watch=true", url.url().toString());
  }

  @Test
  public void testFetchWatchUrlWithoutAnything() throws MalformedURLException {
    // Given
    RawCustomResourceOperationsImpl rawCustomResourceOperations = new RawCustomResourceOperationsImpl(mockClient, config, customResourceDefinitionContext);

    // When
    HttpUrl url = rawCustomResourceOperations.fetchWatchUrl(null, null, null, new ListOptionsBuilder().withWatch(true).build()).build();

    // Then
    assertEquals("https://localhost:8443/apis/test.fabric8.io/v1alpha1/hellos?watch=true", url.url().toString());
  }

  @Test
  public void testFetchWatchUrlWithLabels() throws MalformedURLException {
    // Given
    RawCustomResourceOperationsImpl rawCustomResourceOperations = new RawCustomResourceOperationsImpl(mockClient, config, customResourceDefinitionContext);

    // When
    Map<String, String> labels = new HashMap<>();
    labels.put("foo", "bar");
    labels.put("foo1", "bar1");

    HttpUrl url = rawCustomResourceOperations.fetchWatchUrl(null, null, labels, new ListOptionsBuilder().withWatch(true).build()).build();

    // Then
    assertEquals("https://localhost:8443/apis/test.fabric8.io/v1alpha1/hellos?labelSelector=" + Utils.toUrlEncoded("foo=bar") + "," + Utils.toUrlEncoded("foo1=bar1") + "&watch=true", url.url().toString());
  }

  @Test
  public void testFetchWatchUrlWithLabelsWithNamespace() throws MalformedURLException {
    // Given
    RawCustomResourceOperationsImpl rawCustomResourceOperations = new RawCustomResourceOperationsImpl(mockClient, config, customResourceDefinitionContext);

    // When
    Map<String, String> labels = new HashMap<>();
    labels.put("foo", "bar");
    labels.put("foo1", "bar1");

    HttpUrl url = rawCustomResourceOperations.fetchWatchUrl("test", null, labels, new ListOptionsBuilder().withWatch(true).build()).build();

    // Then
    assertEquals("https://localhost:8443/apis/test.fabric8.io/v1alpha1/namespaces/test/hellos?labelSelector=" + Utils.toUrlEncoded("foo=bar") + "," + Utils.toUrlEncoded("foo1=bar1") + "&watch=true", url.url().toString());
  }
}
