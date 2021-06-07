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

package io.fabric8.kubernetes.client.mock;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@EnableKubernetesMockClient
class CustomResourceTest {
  private static final Long WATCH_EVENT_PERIOD = 5L;

  KubernetesMockServer server;
  KubernetesClient client;

  private final CustomResourceDefinitionContext customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
    .withGroup("test.fabric8.io")
    .withName("hellos.test.fabric8.io")
    .withPlural("hellos")
    .withScope("Namespaced")
    .withVersion("v1alpha1")
    .build();

  @Test
  void testLoad() throws IOException {
    Map<String, Object> customResource = client.customResource(customResourceDefinitionContext).load(getClass().getResourceAsStream("/test-hello-cr.yml"));
    assertNotNull(customResource);
    assertEquals("example-hello", ((Map<String, Object>)customResource.get("metadata")).get("name").toString());
  }

  @SuppressWarnings("unchecked")
  @Test
  void testCreate() throws IOException {
    final String createResponse = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\", \"resourceVersion\": \"1\"},\"spec\": {\"size\": 3, \"creationTimestamp\": \"19851026T090000Z\"}}";
    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos")
      .andReturn(HttpURLConnection.HTTP_CREATED, createResponse).once();

    final String newCrdObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";
    Map<String, Object> resource = client.customResource(customResourceDefinitionContext).create("ns1", newCrdObject);

    final Map<String, String> metadata = (Map<String, String>)resource.get("metadata");
    assertEquals("example-hello", metadata.get("name"));
    assertEquals("1", metadata.get("resourceVersion"));
    assertEquals("19851026T090000Z", ((Map<String, String>)resource.get("spec")).get("creationTimestamp"));
  }

  @Test
  void testCreateOrReplace() throws IOException {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"resourceVersion\":\"1\", \"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";

    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos").andReturn(HttpURLConnection.HTTP_INTERNAL_ERROR, new StatusBuilder().build()).once();
    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();
    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos").andReturn(HttpURLConnection.HTTP_CONFLICT, jsonObject).once();
    server.expect().put().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();

    KubernetesClientException exception = Assertions.assertThrows(KubernetesClientException.class,
      () -> client.customResource(customResourceDefinitionContext).createOrReplace("ns1", jsonObject));
    assertEquals(HttpURLConnection.HTTP_INTERNAL_ERROR, exception.getCode());

    Map<String, Object> resource = client.customResource(customResourceDefinitionContext).createOrReplace("ns1", jsonObject);
    assertEquals("example-hello", ((Map<String, Object>)resource.get("metadata")).get("name").toString());

    resource = client.customResource(customResourceDefinitionContext).createOrReplace("ns1", jsonObject);
    assertEquals("example-hello", ((Map<String, Object>)resource.get("metadata")).get("name").toString());
  }

  @Test
  void testList() {
    String jsonObject = "{\"metadata\":{\"continue\":\"\",\"resourceVersion\":\"539617\",\"selfLink\":\"test.fabric8.io/v1alpha1/namespaces/ns1/hellos/\"},\"apiVersion\":\"test.fabric8.io/v1alpha1\",\"kind\":\"HelloList\",\"items\":[{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3},\"uid\":\"3525437a-6a56-11e9-8787-525400b18c1d\"}]}";

    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();

    Map<String, Object> list = client.customResource(customResourceDefinitionContext).list("ns1");
    List<Map<String, Object>> items = (List<Map<String, Object>>)list.get("items");
    assertNotNull(items);
    assertEquals(1, items.size());
  }

  @Test
  void testListWithLabels() {
    String jsonObject = "{\"metadata\":{\"continue\":\"\",\"resourceVersion\":\"539617\",\"selfLink\":\"test.fabric8.io/v1alpha1/namespaces/ns1/hellos/\"},\"apiVersion\":\"test.fabric8.io/v1alpha1\",\"kind\":\"HelloList\",\"items\":[{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\", \"labels\": {\"scope\":\"test\"}},\"spec\": {\"size\": 3},\"uid\":\"3525437a-6a56-11e9-8787-525400b18c1d\"}]}";

    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?labelSelector=org%3Dfabric8" + Utils.toUrlEncoded(",") + "scope%3Dtest").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();


    Map<String, String> labels = new HashMap<>();
    labels.put("org", "fabric8");
    labels.put("scope", "test");
    Map<String, Object> list = client.customResource(customResourceDefinitionContext).list("ns1", labels);
    List<Map<String, Object>> items = (List<Map<String, Object>>)list.get("items");
    assertNotNull(items);
    assertEquals(1, items.size());
  }

  @Test
  void testListWithFields() {
    final CustomResourceDefinitionList customResourceDefinitionList = new CustomResourceDefinitionListBuilder()
      .addNewItem().and()
      .addNewItem().and()
      .build();

    server.expect().get().withPath("/apis/apiextensions.k8s.io/v1beta1/customresourcedefinitions?fieldSelector=" + Utils
        .toUrlEncoded("key1=value1,key2=value2,key3!=value3,key3!=value4")).andReturn(HttpURLConnection.HTTP_CREATED, customResourceDefinitionList).once();

    CustomResourceDefinitionList list = client.apiextensions().v1beta1().customResourceDefinitions()
      .withField("key1", "value1")
      .withField("key2","value2")
      .withoutField("key3","value3")
      .withoutField("key3", "value4")
      .list();

    List<CustomResourceDefinition> items = list.getItems();
    assertNotNull(items);
    assertEquals(2, items.size());
  }

  @Test
  void testGet() {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();

    Map<String, Object> customResource = client.customResource(customResourceDefinitionContext).get("ns1", "example-hello");
    assertNotNull(customResource);
    assertEquals("example-hello", ((Map<String, Object>)customResource.get("metadata")).get("name").toString());
  }

  @Test
  void testEdit() throws IOException {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"resourceVersion\": \"1\", \"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";
    String jsonObjectNew = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"resourceVersion\": \"1\", \"name\": \"example-hello\"},\"spec\": {\"size\": 4}}";
    server.expect().patch().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObjectNew).once();
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObjectNew).once();

    Map<String, Object> customResource = client.customResource(customResourceDefinitionContext).edit("ns1", "example-hello", jsonObjectNew);
    assertNotNull(customResource);
    assertEquals(4, ((Map<String, Object>)customResource.get("spec")).get("size"));
  }

  @Test
  void testDelete() throws IOException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}").once();

    // When
    boolean result = client.customResource(customResourceDefinitionContext).delete("ns1", "example-hello");

    // Then
    assertTrue(result);
  }

  @Test
  void testDeleteNonExistentItem() throws IOException {
    // Given
    Status notFoundStatus = new StatusBuilder()
      .withStatus("Failure")
      .withMessage("\"idontexist\" not found")
      .withReason("NotFound")
      .withNewDetails().withKind("pods").withName("idontexist").endDetails()
      .withCode(HttpURLConnection.HTTP_NOT_FOUND)
      .build();
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/idontexist").andReturn(HttpURLConnection.HTTP_NOT_FOUND, Serialization.jsonMapper().writeValueAsString(notFoundStatus)).once();

    // When
    boolean isDeleted = client.customResource(customResourceDefinitionContext).delete("ns1", "idontexist");

    // Then
    assertFalse(isDeleted);
  }

  @Test
  void testCascadingDeletion() throws IOException, InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}").once();

    // When
    boolean result = client.customResource(customResourceDefinitionContext)
      .delete("ns1", "example-hello", true);

    // Then
    assertTrue(result);

    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"orphanDependents\":false}",
      request.getBody().readUtf8());
  }

  @Test
  void testPropagationPolicy() throws IOException, InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}").once();

    // When
    boolean result = client.customResource(customResourceDefinitionContext)
      .delete("ns1", "example-hello", "Orphan");

    // Then
    assertTrue(result);
    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
      request.getBody().readUtf8());
  }

  @Test
  void testDeleteOptions() throws InterruptedException, IOException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}").once();

    DeleteOptions deleteOptions = new DeleteOptions();
    deleteOptions.setGracePeriodSeconds(0L);
    deleteOptions.setPropagationPolicy("Orphan");

    // When
    boolean result = client.customResource(customResourceDefinitionContext)
      .delete("ns1", "example-hello", deleteOptions);

    // Then
    assertTrue(result);
    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"gracePeriodSeconds\":0,\"propagationPolicy\":\"Orphan\"}",
      request.getBody().readUtf8());;
  }

  @Test
  void testDeleteWithEmptyResponse() throws InterruptedException, IOException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, "").once();

    // When
    boolean result = client.customResource(customResourceDefinitionContext)
      .delete("ns1", "example-hello", "Orphan");

    // Then
    assertTrue(result);
    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
      request.getBody().readUtf8());;
  }

  @Test
  void testDeleteWithNamespaceMismatch() {
    Assertions.assertThrows(KubernetesClientException.class, () -> {
      client.customResource(customResourceDefinitionContext).delete("ns2", "example-hello");
    });
  }

  @Test
  void testStatusUpdate() throws IOException {
    String objectAsJsonString = "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}";
    server.expect().put().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello/status").andReturn(HttpURLConnection.HTTP_OK, objectAsJsonString).once();

    Map<String, Object> result = client.customResource(customResourceDefinitionContext).updateStatus("ns1", "example-hello", objectAsJsonString);
    assertEquals("Success", result.get("status"));
  }

  @Test
  @DisplayName("Should be able to watch some resource in a namespace with null name, labelSelector and ListOptions")
  void testWatchAllResource() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_PERIOD)
      .andEmit(new WatchEvent(null, "ADDED"))
      .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
      .watch("ns1", null, null, (ListOptions)null,
        new Watcher<String>() {
          @Override
          public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
          @Override
          public void onClose(WatcherException cause) { }
        });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to watch some resource in a namespace")
  void testWatchAllResourceInNamespace() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(new WatchEvent(null, "ADDED"))
        .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
        .watch(
            "ns1",
            new Watcher<String>() {
              @Override
              public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
              @Override
              public void onClose(WatcherException cause) { }
            });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to watch a single resource with some name")
  void testWatchSingleResource() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos"+ "?fieldSelector=" + Utils.toUrlEncoded("metadata.name=example-hello")+"&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_PERIOD)
      .andEmit( new WatchEvent(null, "ADDED"))
      .done().always();


    CountDownLatch anyEventReceieved = new CountDownLatch(1);
    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
      .watch("ns1", "example-hello", null, (ListOptions)null,
        new Watcher<String>() {
          @Override
          public void eventReceived(Action action, String resource) { anyEventReceieved.countDown(); }
          @Override
          public void onClose(WatcherException cause) { }
        });

    // Then
    assertTrue(anyEventReceieved.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to watch with labelSelectors")
  void testWatchWithLabels() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?labelSelector="+ Utils.toUrlEncoded("foo=bar")+ "&watch=true")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_PERIOD)
      .andEmit(new WatchEvent(null, "ADDED"))
      .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
      .watch("ns1", null, Collections.singletonMap("foo", "bar"), (ListOptions)null,
        new Watcher<String>() {
          @Override
          public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
          @Override
          public void onClose(WatcherException cause) { }
        });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with some specific resourceVersion")
  void testWatchSomeResourceVersion() throws IOException, InterruptedException {
    // Given
    String watchResourceVersion = "1001";
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?watch=true&resourceVersion=" + watchResourceVersion)
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_PERIOD)
      .andEmit(new WatchEvent(null, "ADDED"))
      .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);

    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
      .watch("ns1", null, null, watchResourceVersion,
        new Watcher<String>() {
          @Override
          public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
          @Override
          public void onClose(WatcherException cause) { }
        });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with namespace and some specific resourceVersion")
  void testWatchNamespaceAndSomeResourceVersion() throws IOException, InterruptedException {
    // Given
    String watchResourceVersion = "1001";
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?watch=true&resourceVersion=" + watchResourceVersion)
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(new WatchEvent(null, "ADDED"))
        .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);

    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
        .watch(
            "ns1",
            watchResourceVersion,
            new Watcher<String>() {
              @Override
              public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
              @Override
              public void onClose(WatcherException cause) { }
            });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with ListOptions provided")
  void testWatchWithListOptions() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?timeoutSeconds=30&allowWatchBookmarks=true&watch=true&resourceVersion=1003")
      .andUpgradeToWebSocket()
      .open()
      .waitFor(WATCH_EVENT_PERIOD)
      .andEmit(new WatchEvent(null, "ADDED"))
      .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
      .watch("ns1", null, null, new ListOptionsBuilder()
          .withTimeoutSeconds(30L)
          .withResourceVersion("1003")
          .withAllowWatchBookmarks(true)
          .build(),
        new Watcher<String>() {
          @Override
          public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
          @Override
          public void onClose(WatcherException cause) { }
        });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with Namespace and ListOptions provided")
  void testWatchWithNamespaceAndListOptions() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?timeoutSeconds=30&allowWatchBookmarks=true&watch=true&resourceVersion=1003")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(new WatchEvent(null, "ADDED"))
        .done().always();


    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.customResource(customResourceDefinitionContext)
        .watch(
            "ns1",
            new ListOptionsBuilder()
                .withTimeoutSeconds(30L)
                .withResourceVersion("1003")
                .withAllowWatchBookmarks(true)
                .build(),
            new Watcher<String>() {
              @Override
              public void eventReceived(Action action, String resource) { anyEventReceived.countDown(); }
              @Override
              public void onClose(WatcherException cause) { }
            });

    // Then
    assertTrue(anyEventReceived.await(1, TimeUnit.SECONDS));
    watch.close();
  }
}
