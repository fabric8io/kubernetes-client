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

import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.StatusBuilder;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionList;
import io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    GenericKubernetesResource customResource = client.genericKubernetesResources(customResourceDefinitionContext)
        .load(getClass().getResourceAsStream("/test-hello-cr.yml")).item();
    assertThat(customResource)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-hello");
  }

  @Test
  void testCreate() throws IOException {
    final String createResponse = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
        "\"metadata\": {\"name\": \"example-hello\", \"resourceVersion\": \"1\"},\"spec\": {\"size\": 3, \"creationTimestamp\": \"19851026T090000Z\"}}";
    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos")
        .andReturn(HttpURLConnection.HTTP_CREATED, createResponse).once();

    final String newCrdObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
        "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";
    GenericKubernetesResource resource = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .create(Serialization.unmarshal(newCrdObject, GenericKubernetesResource.class));

    assertThat(resource)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "example-hello")
        .hasFieldOrPropertyWithValue("metadata.resourceVersion", "1")
        .hasFieldOrPropertyWithValue("additionalProperties.spec.creationTimestamp", "19851026T090000Z");
  }

  @Test
  void testCreateOrReplace() throws IOException {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
        "\"metadata\": {\"resourceVersion\":\"1\", \"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";

    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos")
        .andReturn(HttpURLConnection.HTTP_INTERNAL_ERROR, new StatusBuilder().build()).once();
    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos")
        .andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();
    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, jsonObject).once();
    server.expect().put().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();

    GenericKubernetesResource resource = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .createOrReplace(Serialization.unmarshal(jsonObject, GenericKubernetesResource.class));
    assertEquals("example-hello", resource.getMetadata().getName());

    resource = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .createOrReplace(Serialization.unmarshal(jsonObject, GenericKubernetesResource.class));
    assertEquals("example-hello", resource.getMetadata().getName());
  }

  @Test
  void testList() {
    String jsonObject = "{\"metadata\":{\"continue\":\"\",\"resourceVersion\":\"539617\",\"selfLink\":\"test.fabric8.io/v1alpha1/namespaces/ns1/hellos/\"},\"apiVersion\":\"test.fabric8.io/v1alpha1\",\"kind\":\"HelloList\",\"items\":[{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\","
        +
        "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3},\"uid\":\"3525437a-6a56-11e9-8787-525400b18c1d\"}]}";

    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos")
        .andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();

    GenericKubernetesResourceList list = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .list();
    List<GenericKubernetesResource> items = list.getItems();
    assertNotNull(items);
    assertEquals(1, items.size());
  }

  @Test
  void testListWithLabels() {
    String jsonObject = "{\"metadata\":{\"continue\":\"\",\"resourceVersion\":\"539617\",\"selfLink\":\"test.fabric8.io/v1alpha1/namespaces/ns1/hellos/\"},\"apiVersion\":\"test.fabric8.io/v1alpha1\",\"kind\":\"HelloList\",\"items\":[{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\","
        +
        "\"metadata\": {\"name\": \"example-hello\", \"labels\": {\"scope\":\"test\"}},\"spec\": {\"size\": 3},\"uid\":\"3525437a-6a56-11e9-8787-525400b18c1d\"}]}";

    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?labelSelector=org%3Dfabric8"
        + Utils.toUrlEncoded(",") + "scope%3Dtest").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();

    Map<String, String> labels = new HashMap<>();
    labels.put("org", "fabric8");
    labels.put("scope", "test");
    GenericKubernetesResourceList list = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .withLabels(labels).list();
    List<GenericKubernetesResource> items = list.getItems();
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
        .toUrlEncoded("key1=value1,key2=value2,key3!=value3,key3!=value4"))
        .andReturn(HttpURLConnection.HTTP_CREATED, customResourceDefinitionList).once();

    CustomResourceDefinitionList list = client.apiextensions().v1beta1().customResourceDefinitions()
        .withField("key1", "value1")
        .withField("key2", "value2")
        .withoutField("key3", "value3")
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
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();

    GenericKubernetesResource customResource = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1").withName("example-hello").get();
    assertNotNull(customResource);
    assertEquals("example-hello", customResource.getMetadata().getName());
  }

  @Test
  void testEdit() throws IOException {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
        "\"metadata\": {\"resourceVersion\": \"1\", \"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";
    String jsonObjectNew = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
        "\"metadata\": {\"resourceVersion\": \"1\", \"name\": \"example-hello\"},\"spec\": {\"size\": 4}}";
    server.expect().patch().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, jsonObjectNew).once();
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, jsonObjectNew).once();

    GenericKubernetesResource customResource = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1").withName("example-hello")
        .edit(g -> Serialization.unmarshal(jsonObjectNew, GenericKubernetesResource.class));
    assertNotNull(customResource);
    assertEquals(4, ((Map<String, Object>) customResource.get("spec")).get("size"));
  }

  @Test
  void testDelete() throws IOException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(
        HttpURLConnection.HTTP_OK,
        "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}")
        .once();

    // When
    boolean result = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .withName("example-hello").delete().size() == 1;

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
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/idontexist")
        .andReturn(HttpURLConnection.HTTP_NOT_FOUND, Serialization.jsonMapper().writeValueAsString(notFoundStatus)).once();

    // When
    List<StatusDetails> deleted = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .withName("idontexist").delete();

    // Then
    assertTrue(deleted.isEmpty());
  }

  @Test
  void testCascadingDeletion() throws IOException, InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(
        HttpURLConnection.HTTP_OK,
        "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}")
        .once();

    // When
    boolean result = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1").withName("example-hello").cascading(false).delete().size() == 1;

    // Then
    assertTrue(result);

    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        request.getBody().readUtf8());
  }

  @Test
  void testPropagationPolicy() throws IOException, InterruptedException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(
        HttpURLConnection.HTTP_OK,
        "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}")
        .once();

    // When
    boolean result = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1").withName("example-hello").withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;

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
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(
        HttpURLConnection.HTTP_OK,
        "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}")
        .once();

    DeleteOptions deleteOptions = new DeleteOptions();
    deleteOptions.setGracePeriodSeconds(0L);
    deleteOptions.setPropagationPolicy("Orphan");

    // When
    boolean result = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1")
        .withName("example-hello")
        .withPropagationPolicy(DeletionPropagation.ORPHAN)
        .withGracePeriod(0L)
        .delete().size() == 1;

    // Then
    assertTrue(result);
    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"gracePeriodSeconds\":0,\"propagationPolicy\":\"Orphan\"}",
        request.getBody().readUtf8());
  }

  @Test
  void testDeleteWithEmptyResponse() throws InterruptedException, IOException {
    // Given
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello")
        .andReturn(HttpURLConnection.HTTP_OK, "").once();

    // When
    boolean result = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1").withName("example-hello").withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;

    // Then
    assertFalse(result);
    RecordedRequest request = server.getLastRequest();
    assertEquals("DELETE", request.getMethod());
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        request.getBody().readUtf8());
  }

  @Test
  void testDeleteWithNonExistentResource() throws IOException {
    assertThat(client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns2").withName("example-hello")
        .delete().size() == 1)
        .isFalse();
  }

  @Test
  void testStatusUpdate() throws IOException {
    String objectAsJsonString = "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}";
    server.expect().put().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello/status")
        .andReturn(HttpURLConnection.HTTP_OK, objectAsJsonString).once();

    Resource<GenericKubernetesResource> withName = client.genericKubernetesResources(customResourceDefinitionContext)
        .inNamespace("ns1").withName("example-hello");
    GenericKubernetesResource obj = Serialization.unmarshal(objectAsJsonString, GenericKubernetesResource.class);
    assertThrows(KubernetesClientException.class, () -> withName.updateStatus(obj));

    obj.getMetadata().setResourceVersion("1");
    GenericKubernetesResource result = withName.updateStatus(obj);
    assertEquals("Success", result.get("status"));
  }

  @Test
  @DisplayName("Should be able to watch some resource in a namespace with null name, labelSelector and ListOptions")
  void testWatchAllResource() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1003}}}")
        .done().always();

    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .watch(new Watcher<GenericKubernetesResource>() {
          @Override
          public void eventReceived(Action action, GenericKubernetesResource resource) {
            anyEventReceived.countDown();
          }

          @Override
          public void onClose(WatcherException cause) {
          }
        });

    // Then
    assertTrue(anyEventReceived.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to watch some resource in a namespace")
  void testWatchAllResourceInNamespace() throws IOException, InterruptedException {
    // Given
    server.expect().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1}}}")
        .done().always();

    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .watch(new Watcher<GenericKubernetesResource>() {
          @Override
          public void eventReceived(Action action, GenericKubernetesResource resource) {
            anyEventReceived.countDown();
          }

          @Override
          public void onClose(WatcherException cause) {
          }
        });

    // Then
    assertTrue(anyEventReceived.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to watch a single resource with some name")
  void testWatchSingleResource() throws IOException, InterruptedException {
    // Given
    server.expect()
        .withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos" + "?fieldSelector="
            + Utils.toUrlEncoded("metadata.name=example-hello") + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1}}}")
        .done().always();

    CountDownLatch anyEventReceieved = new CountDownLatch(1);
    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .withName("example-hello")
        .watch(new Watcher<GenericKubernetesResource>() {
          @Override
          public void eventReceived(Action action, GenericKubernetesResource resource) {
            anyEventReceieved.countDown();
          }

          @Override
          public void onClose(WatcherException cause) {
          }
        });

    // Then
    assertTrue(anyEventReceieved.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to watch with labelSelectors")
  void testWatchWithLabels() throws IOException, InterruptedException {
    // Given
    server.expect()
        .withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?labelSelector=" + Utils.toUrlEncoded("foo=bar")
            + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1}}}")
        .done().always();

    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .withLabel("foo", "bar").watch(new Watcher<GenericKubernetesResource>() {
          @Override
          public void eventReceived(Action action, GenericKubernetesResource resource) {
            anyEventReceived.countDown();
          }

          @Override
          public void onClose(WatcherException cause) {
          }
        });

    // Then
    assertTrue(anyEventReceived.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with some specific resourceVersion")
  void testWatchSomeResourceVersion() throws IOException, InterruptedException {
    // Given
    String watchResourceVersion = "1001";
    server.expect()
        .withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?resourceVersion=" + watchResourceVersion
            + "&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1001}}}")
        .done().always();

    CountDownLatch anyEventReceived = new CountDownLatch(1);

    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .withResourceVersion(watchResourceVersion)
        .watch(new Watcher<GenericKubernetesResource>() {
          @Override
          public void eventReceived(Action action, GenericKubernetesResource resource) {
            anyEventReceived.countDown();
          }

          @Override
          public void onClose(WatcherException cause) {
          }
        });

    // Then
    assertTrue(anyEventReceived.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with ListOptions provided")
  void testWatchWithListOptions() throws IOException, InterruptedException {
    // Given
    server.expect().withPath(
        "/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?resourceVersion=1003&timeoutSeconds=30&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1003}}}")
        .done().always();

    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .watch(new ListOptionsBuilder()
            .withTimeoutSeconds(30L)
            .withResourceVersion("1003")
            .withAllowWatchBookmarks(true)
            .build(),
            new Watcher<GenericKubernetesResource>() {
              @Override
              public void eventReceived(Action action, GenericKubernetesResource resource) {
                anyEventReceived.countDown();
              }

              @Override
              public void onClose(WatcherException cause) {
              }
            });

    // Then
    assertTrue(anyEventReceived.await(10, TimeUnit.SECONDS));
    watch.close();
  }

  @Test
  @DisplayName("Should be able to test watch with Namespace and ListOptions provided")
  void testWatchWithNamespaceAndListOptions() throws IOException, InterruptedException {
    // Given
    server.expect().withPath(
        "/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?resourceVersion=1003&timeoutSeconds=30&allowWatchBookmarks=true&watch=true")
        .andUpgradeToWebSocket()
        .open()
        .waitFor(WATCH_EVENT_PERIOD)
        .andEmit(
            "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"apiVersion\": \"v1\", \"metadata\": {\"resourceVersion\": 1003}}}")
        .done().always();

    CountDownLatch anyEventReceived = new CountDownLatch(1);
    // When
    Watch watch = client.genericKubernetesResources(customResourceDefinitionContext).inNamespace("ns1")
        .watch(new ListOptionsBuilder()
            .withTimeoutSeconds(30L)
            .withResourceVersion("1003")
            .withAllowWatchBookmarks(true)
            .build(),
            new Watcher<GenericKubernetesResource>() {
              @Override
              public void eventReceived(Action action, GenericKubernetesResource resource) {
                anyEventReceived.countDown();
              }

              @Override
              public void onClose(WatcherException cause) {
              }
            });

    // Then
    assertTrue(anyEventReceived.await(10, TimeUnit.SECONDS));
    watch.close();
  }
}
