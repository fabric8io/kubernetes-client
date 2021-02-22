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

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapList;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.dsl.EditReplacePatchDeletable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.utils.URLUtils;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.client.dsl.internal.PodOperationContext;
import io.fabric8.kubernetes.client.dsl.internal.core.v1.PodOperationsImpl;
import org.mockito.ArgumentCaptor;

class BaseOperationTest {

  @Test
  void testSimpleFieldQueryParamConcatenation() {
    Map<String, String> fieldsMap = new HashMap<>();
    fieldsMap.put("yesKey1", "yesValue1");
    fieldsMap.put("yesKey2", "yesValue2");

    final PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext());
    operation
      .withFields(fieldsMap)
      .withField("yesKey2", "overrideValue2")
      .withoutField("noKey1", "noValue1")
      .withoutField("noKey2", "noValue2");

    final String fieldQueryParam = operation.getFieldQueryParam();
    // Use contains to not be depending on map key/value pair ordering
    assertThat(fieldQueryParam, containsString("yesKey1=yesValue1"));
    assertThat(fieldQueryParam, containsString("yesKey2=overrideValue2"));
    assertThat(fieldQueryParam, containsString("noKey1!=noValue1"));
    assertThat(fieldQueryParam, containsString("noKey2!=noValue2"));
  }

  @Test
  void testSkippingFieldNotMatchingNullValues() {
    final PodOperationsImpl operation = new PodOperationsImpl(new PodOperationContext());
    operation
      .withField("key1", "value1")
      .withoutField("key2", "value2")
      .withoutField("key2", null)
      .withoutField("key2", "")
      .withoutField("key2", "value3")
      .withoutField("key10", "value11")
      .withoutField("key10", ""); // Once more to make sure no accidental trailing comma is added

    assertThat(operation.getFieldQueryParam(), is(equalTo("key1=value1,key2!=value2,key2!=value3,key10!=value11")));
  }

  @Test
  void testDefaultGracePeriod() {
    final BaseOperation operation = new BaseOperation(new OperationContext());

    assertThat(operation.getGracePeriodSeconds(), is(-1L));
  }

  @Test
  void testChainingGracePeriodAndPropagationPolicy() {
    final BaseOperation operation = new BaseOperation(new OperationContext());
    EditReplacePatchDeletable<?> operationWithPropagationPolicy = operation.withPropagationPolicy(DeletionPropagation.FOREGROUND);
    assertThat(operationWithPropagationPolicy, is(notNullValue()));
    assertNotNull(operationWithPropagationPolicy.withGracePeriod(10));
  }

  @Test
  void testListOptions() throws MalformedURLException {
    // Given
    URL url = new URL("https://172.17.0.2:8443/api/v1/namespaces/default/pods");
    final BaseOperation<Pod, PodList, Resource<Pod>> operation = new BaseOperation<>(new OperationContext());

    // When and Then
    assertEquals(URLUtils.join(url.toString(), "?limit=5"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&fieldSelector=status.phase%3DRunning"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .withFieldSelector("status.phase=Running")
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&resourceVersion=210448&fieldSelector=status.phase%3DRunning"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .withFieldSelector("status.phase=Running")
        .withResourceVersion("210448")
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&resourceVersion=210448&labelSelector=%21node-role.kubernetes.io%2Fmaster"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .withLabelSelector("!node-role.kubernetes.io/master")
        .withResourceVersion("210448")
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&resourceVersion=210448&labelSelector=%21node-role.kubernetes.io%2Fmaster&timeoutSeconds=10"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .withLabelSelector("!node-role.kubernetes.io/master")
        .withResourceVersion("210448")
        .withTimeoutSeconds(10L)
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&resourceVersion=210448&labelSelector=%21node-role.kubernetes.io%2Fmaster&timeoutSeconds=10&allowWatchBookmarks=true"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .withLabelSelector("!node-role.kubernetes.io/master")
        .withResourceVersion("210448")
        .withTimeoutSeconds(10L)
        .withAllowWatchBookmarks(true)
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?limit=5&continue=eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ&resourceVersion=210448&labelSelector=%21node-role.kubernetes.io%2Fmaster&timeoutSeconds=10&allowWatchBookmarks=true&watch=true"),
      operation.fetchListUrl(url, new ListOptionsBuilder()
        .withLimit(5L)
        .withContinue("eyJ2IjoibWV0YS5rOHMuaW8vdjEiLCJydiI6MjE0NDUzLCJzdGFydCI6ImV0Y2QtbWluaWt1YmVcdTAwMDAifQ")
        .withLabelSelector("!node-role.kubernetes.io/master")
        .withResourceVersion("210448")
        .withTimeoutSeconds(10L)
        .withAllowWatchBookmarks(true)
        .withWatch(true)
        .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?resourceVersion=210448"), operation.fetchListUrl(url, new ListOptionsBuilder()
      .withResourceVersion("210448")
      .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?timeoutSeconds=10"), operation.fetchListUrl(url, new ListOptionsBuilder()
      .withTimeoutSeconds(10L)
      .build()).toString());
    assertEquals(URLUtils.join(url.toString(), "?watch=true"), operation.fetchListUrl(url, new ListOptionsBuilder()
      .withWatch(true)
      .build()).toString());
  }

  @Test
  void testGetWriteOperationUrlWithDryRunEnabled() throws MalformedURLException {
    // Given
    BaseOperation baseOp = new BaseOperation(new OperationContext()
      .withConfig(new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").build())
      .withPlural("pods")
      .withDryRun(true));
    baseOp.setType(Pod.class);
    baseOp.setListType(PodList.class);

    // When
    URL result = baseOp.getResourceURLForWriteOperation(new URL("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo"));

    // Then
    assertNotNull(result);
    assertEquals("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo?dryRun=All", result.toString());
  }

  @Test
  void testGetWriteOperationUrlWithDryRunDisabled() throws MalformedURLException {
    // Given
    BaseOperation baseOp = new BaseOperation(new OperationContext()
      .withConfig(new ConfigBuilder().withMasterUrl("https://172.17.0.2:8443").build())
      .withPlural("pods"));
    baseOp.setType(Pod.class);
    baseOp.setListType(PodList.class);

    // When
    URL result = baseOp.getResourceURLForWriteOperation(new URL("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo"));

    // Then
    assertNotNull(result);
    assertEquals("https://172.17.0.2:8443/api/v1/namespaces/ns1/pods/foo", result.toString());
  }
}
