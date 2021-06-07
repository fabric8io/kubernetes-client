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

import io.fabric8.kubernetes.api.model.DeleteOptionsBuilder;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.Buffer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RawCustomResourceOperationsImplTest {
  private OkHttpClient mockClient;
  private Config config;
  private CustomResourceDefinitionContext namespacedCustomResourceDefinitionContext;
  private RawCustomResourceOperationsImpl namespacedOperations;
  private RawCustomResourceOperationsImpl clusterOperations;
  private ArgumentCaptor<Request> captor;

  @BeforeEach
  public void setUp() throws IOException {
    mockClient = Mockito.mock(OkHttpClient.class, Mockito.RETURNS_DEEP_STUBS);
    config = new ConfigBuilder().withMasterUrl("https://localhost:8443/").build();
    namespacedCustomResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
      .withGroup("test.fabric8.io")
      .withName("hellos.test.fabric8.io")
      .withPlural("hellos")
      .withScope("Namespaced")
      .withVersion("v1alpha1")
      .build();
    final CustomResourceDefinitionContext clusterCustomResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
      .withGroup("test.fabric8.io")
      .withName("hellos.test.fabric8.io")
      .withPlural("hellos")
      .withScope("Cluster")
      .withVersion("v1alpha1")
      .build();
    namespacedOperations = new RawCustomResourceOperationsImpl(mockClient, config, namespacedCustomResourceDefinitionContext);
    clusterOperations = new RawCustomResourceOperationsImpl(mockClient, config, clusterCustomResourceDefinitionContext);
    captor = ArgumentCaptor.forClass(Request.class);
  }

  @Test
  @DisplayName("load, with valid InputStream, should load a valid Map")
  void loadWithInputStream() throws IOException {
    // When
    final Map<String, Object> result = namespacedOperations.load(RawCustomResourceOperationsImplTest.class
      .getResourceAsStream("/raw-custom-resource-operations/custom-resource.yml"));
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", "custom-resource-example")
      .hasFieldOrPropertyWithValue("spec.field", "value");
  }

  @Test
  @DisplayName("load, with valid object string, should load a valid Map")
  void loadWithObjectString() throws IOException {
    // When
    final Map<String, Object> result = namespacedOperations.load(
      "{\"metadata\":{\"name\":\"custom-resource-example\"}, \"spec\": {\"field\": \"value\"}}"
    );
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.name", "custom-resource-example")
      .hasFieldOrPropertyWithValue("spec.field", "value");
  }

  @Test
  @DisplayName("create, with valid object string, should create")
  void createFromObjectString() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = clusterOperations.create(
      "{\"metadata\":{\"name\":\"custom-resource-example\"}}"
    );
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos", "POST");
  }

  @Test
  @DisplayName("create, with valid Map, should create")
  void createFromMap() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = clusterOperations.create(
      Collections.singletonMap("metadata",
        Collections.singletonMap("name", "custom-resource-example"))
    );
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos", "POST");
  }

  @Test
  @DisplayName("create, with valid InputStream, should create")
  void createFromInputStream() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = clusterOperations.create(RawCustomResourceOperationsImplTest.class
      .getResourceAsStream("/raw-custom-resource-operations/custom-resource.yml"));
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos", "POST");
  }

  @Test
  @DisplayName("create, with namespace and valid InputStream, should create")
  void createWithNamespaceFromInputStream() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = namespacedOperations.create("other-namespace",
      RawCustomResourceOperationsImplTest.class.getResourceAsStream("/raw-custom-resource-operations/custom-resource.yml"));
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/other-namespace/hellos", "POST");
  }

  @Test
  @DisplayName("create, with namespace and valid Map, should create")
  void createWithNamespaceFromMap() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = namespacedOperations.create("other-namespace",
      Collections.singletonMap("metadata",
        Collections.singletonMap("name", "custom-resource-example"))
    );
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/other-namespace/hellos", "POST");
  }

  @Test
  @DisplayName("createOrReplace, with valid object string, should create")
  void createOrReplaceFromString() throws IOException {
    // Given
    String resourceAsString = "{\"metadata\":{\"name\":\"myresource\",\"namespace\":\"myns\",\"resourceVersion\":\"111\"}, \"kind\":\"raw\", \"apiVersion\":\"v1\"}";
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"kind\": \"raw\", \"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = namespacedOperations.inNamespace("myns").createOrReplace(resourceAsString);
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "POST");
  }

  @Test
  @DisplayName("createOrReplace, with valid Map, should create")
  void createOrReplaceFromMap() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CREATED,
        "{\"metadata\": {\"resourceVersion\": \"created\"}}")
    );
    // When
    final Map<String, Object> result = clusterOperations.inNamespace("myns").createOrReplace(
      Collections.singletonMap("metadata",
      Collections.singletonMap("name", "custom-resource-example"))
    );
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "created");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos", "POST");
  }

  @Test
  void testCreateOrReplaceWithConflict() throws IOException {
    // Given
    String resourceAsString = "{\"metadata\":{\"name\":\"myresource\",\"namespace\":\"myns\",\"resourceVersion\":\"111\"}, \"kind\":\"raw\", \"apiVersion\":\"v1\"}";
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_CONFLICT),
      i -> buildResponse(HttpURLConnection.HTTP_OK,
        "{\"kind\": \"raw\", \"metadata\": {\"resourceVersion\": \"replaced\"}}")
    );
    // When
    final Map<String, Object> result = namespacedOperations.inNamespace("myns").createOrReplace(resourceAsString);
    // Then
    assertThat(result)
      .isNotNull()
      .hasFieldOrPropertyWithValue("metadata.resourceVersion", "replaced");
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "POST");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "PUT");
  }

  @Test
  void testDeleteWithNamespaceAndNameForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}");

    // When
    boolean result = namespacedOperations.delete("ns1", "foo");

    // Then
    assertFalse(result);
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/foo", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"hello\", \"namespace\": \"ns1\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}")
    );

    // When
    boolean result = namespacedOperations.delete("ns1");

    // Then
    assertTrue(result); // delete()->deleteList() always returns true
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos", "GET");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/hello", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceAndCascadingForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"hello\", \"namespace\": \"ns1\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}")
    );

    // When
    boolean result = namespacedOperations.delete("ns1", true);

    // Then
    assertTrue(result); // delete()->deleteList() always returns true
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos", "GET");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/hello", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceAndDeleteOptionsForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"hello\", \"namespace\": \"ns1\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}")
    );

    // When
    boolean result = namespacedOperations.delete("ns1", new DeleteOptionsBuilder().withOrphanDependents(true).build());

    // Then
    assertTrue(result); // delete()->deleteList() always returns true
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos", "GET");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/hello", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceNameAndCascading() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{\"kind\":\"Hello\",\"metadata\":{\"name\":\"Failure\"}}");

    // When
    boolean result = namespacedOperations.delete("ns1", "foo", true);

    // Then
    assertTrue(result);
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/foo", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceNameAndCascadingForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}");

    // When
    boolean result = namespacedOperations.delete("ns1", "foo", true);

    // Then
    assertFalse(result);
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/foo", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceNameAndPropagationPolicyForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}");

    // When
    boolean result = namespacedOperations.delete("ns1", "foo", DeletionPropagation.BACKGROUND.toString());

    // Then
    assertFalse(result);
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/foo", "DELETE");
  }

  @Test
  void testDeleteWithNamespaceNameAndDeleteOptionsForNonExistentResource() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_NOT_FOUND, "{\"kind\":\"Status\",\"status\":\"Failure\"}");

    // When
    boolean result = namespacedOperations.delete("ns1", "foo", new DeleteOptionsBuilder().withPropagationPolicy(DeletionPropagation.FOREGROUND.toString()).build());

    // Then
    assertFalse(result);
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/foo", "DELETE");
  }

  @Test
  void testGetUrl() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{}");

    // When
    namespacedOperations.get("myns", "myresource");

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "GET");
  }

  @Test
  void testDeleteUrl() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{\"kind\":\"Status\",\"status\":\"Success\"}");

    // When
    boolean result = namespacedOperations.delete("myns", "myresource");

    // Then
    assertTrue(result);
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "DELETE");
  }

  @Test
  void testGetConfigShouldNotReturnNull() {
    // Given
    Config config = new ConfigBuilder()
      .withRequestTimeout(5)
      .withWebsocketTimeout(10L)
      .withWebsocketPingInterval(10L)
      .withConnectionTimeout(10)
      .withWatchReconnectLimit(1)
      .withWatchReconnectInterval(10)
      .build();
    RawCustomResourceOperationsImpl rawOp = new RawCustomResourceOperationsImpl(mockClient, config, namespacedCustomResourceDefinitionContext);

    // When
    Config configFromRawOp = rawOp.getConfig();

    // Then
    assertThat(configFromRawOp)
      .isNotNull()
      .hasFieldOrPropertyWithValue("requestTimeout", 5)
      .hasFieldOrPropertyWithValue("websocketTimeout", 10L)
      .hasFieldOrPropertyWithValue("websocketPingInterval", 10L)
      .hasFieldOrPropertyWithValue("connectionTimeout", 10)
      .hasFieldOrPropertyWithValue("watchReconnectInterval", 10)
      .hasFieldOrPropertyWithValue("watchReconnectLimit", 1);
  }

  @Test
  void testDryRunDelete() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    namespacedOperations.dryRun().delete("myns", "myresource");

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "DELETE");
    assertEquals("dryRun=All", captor.getValue().url().encodedQuery());
  }

  @Test
  @DisplayName("delete, with valid namespace and name and grace period, should delete")
  void deleteWithGracePeriod() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);
    // When
    namespacedOperations.inNamespace("myns").withName("myresource").withGracePeriod(1337L).delete();
    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "DELETE");
    final Buffer b = new Buffer();
    captor.getValue().body().writeTo(b);
    assertThat(b.readUtf8()).contains("\"gracePeriodSeconds\":1337");
  }

  @Test
  @DisplayName("delete, with valid namespace and name and propagation policy should delete")
  void deleteWithPropagationPolicy() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);
    // When
    namespacedOperations.inNamespace("myns").withName("myresource")
      .withPropagationPolicy(DeletionPropagation.FOREGROUND).delete();
    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "DELETE");
    final Buffer b = new Buffer();
    captor.getValue().body().writeTo(b);
    assertThat(b.readUtf8()).contains("\"propagationPolicy\":\"Foreground\"");
  }

  @Test
  void testDryRunCreate() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    namespacedOperations.dryRun().create("myns", "{\"apiVersion\":\"test.fabric8.io/v1alpha1\"}");

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "POST");
    assertEquals("dryRun=All", captor.getValue().url().encodedQuery());
  }

  @Test
  void testDeleteWithNamespaceAndName() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    namespacedOperations.inNamespace("myns").withName("myresource").delete();

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "DELETE");
  }

  @Test
  void testGet() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{}");

    // When
    namespacedOperations.inNamespace("myns").withName("myresource").get();

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/myresource", "GET");
  }

  @Test
  void testListWithLimitAndContinue() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{\"kind\":\"List\"}");

    // When
    namespacedOperations.inNamespace("myns").list(4, "eyJ2IjoibWV0YS5rOHMuaW8vdj");

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertEquals("limit=4&continue=eyJ2IjoibWV0YS5rOHMuaW8vdj", captor.getValue().url().encodedQuery());
  }

  @Test
  void testListWithListOptions() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{\"kind\":\"List\"}");

    // When
    namespacedOperations.inNamespace("myns").list(new ListOptionsBuilder().withLimit(4L).build());

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertEquals("limit=4", captor.getValue().url().encodedQuery());
  }

  @Test
  void testListWithLabels() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{\"kind\":\"List\"}");

    // When
    namespacedOperations.list("myns", Collections.singletonMap("foo", "bar"));

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertEquals("labelSelector=foo%3Dbar", captor.getValue().url().encodedQuery());
  }

  @Test
  void testDeleteInSpecifiedNamespace() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"one\"}}," +
        "{\"metadata\": {\"name\": \"two\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_OK)
    );

    // When
    namespacedOperations.inNamespace("myns").delete();

    // Then
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertRequestCaptured(1, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/one", "DELETE");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/two", "DELETE");
  }

  @Test
  void testDeleteInAllNamespaces() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"one\", \"namespace\": \"myns\"}}," +
        "{\"metadata\": {\"name\": \"two\", \"namespace\": \"myns\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_OK)
    );

    // When
    namespacedOperations.inAnyNamespace().delete();

    // Then
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/hellos", "GET");
    assertRequestCaptured(1, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/one", "DELETE");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/two", "DELETE");
  }

  @Test
  void testClusterScopedDeletionWithName() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    clusterOperations.withName("myresource").delete();

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos/myresource", "DELETE");
  }

  @Test
  void testClusterScopeDeletionAll() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"one\"}}," +
        "{\"metadata\": {\"name\": \"two\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_OK)
    );

    // When
    clusterOperations.delete();

    // Then
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/hellos", "GET");
    assertRequestCaptured(1, "/apis/test.fabric8.io/v1alpha1/hellos/one", "DELETE");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos/two", "DELETE");
  }

  @Test
  void testDeleteByNamespaceOrNameWithNamespacedScopedCRD() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"one\", \"namespace\": \"myns\"}}," +
        "{\"metadata\": {\"name\": \"two\", \"namespace\": \"myns\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_OK)
    );

    // When
    namespacedOperations.delete("myns");

    // Then
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertRequestCaptured(1, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/one", "DELETE");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/two", "DELETE");
  }

  @Test
  void testDeleteByNamespaceOrNameWithCascadingWithNamespacedScopedCRD() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"one\", \"namespace\": \"myns\"}}," +
        "{\"metadata\": {\"name\": \"two\", \"namespace\": \"myns\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_OK)
    );

    // When
    namespacedOperations.delete("myns", true);

    // Then
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertRequestCaptured(1, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/one", "DELETE");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/two", "DELETE");
  }

  @Test
  void testDeleteByNamespaceOrNameWithDeleteOptionsWithNamespacedScopedCRD() throws IOException {
    // Given
    mockCallWithResponse(
      i -> buildResponse(HttpURLConnection.HTTP_OK, "{" +
        "\"items\": [" +
        "{\"metadata\": {\"name\": \"one\", \"namespace\": \"myns\"}}," +
        "{\"metadata\": {\"name\": \"two\", \"namespace\": \"myns\"}}" +
        "]" +
        "}"),
      i -> buildResponse(HttpURLConnection.HTTP_OK)
    );

    // When
    namespacedOperations.delete("myns", new DeleteOptionsBuilder()
      .withPropagationPolicy(DeletionPropagation.BACKGROUND.toString()).build());

    // Then
    assertRequestCaptured(0, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos", "GET");
    assertRequestCaptured(1, "/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/one", "DELETE");
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/namespaces/myns/hellos/two", "DELETE");
  }

  @Test
  void testDeleteByNamespaceOrNameWithClusterScopedCRD() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    clusterOperations.delete("myresource");

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos/myresource", "DELETE");
  }

  @Test
  void testDeleteByNamespaceOrNameWithCascadingWithClusterScopedCRD() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    clusterOperations.delete("myresource", true);

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos/myresource", "DELETE");
  }

  @Test
  void testDeleteByNamespaceOrNameWithDeleteOptionsWithClusterScopedCRD() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK);

    // When
    clusterOperations.delete("myresource", new DeleteOptionsBuilder()
      .withPropagationPolicy(DeletionPropagation.BACKGROUND.toString()).build());

    // Then
    assertRequestCaptured("/apis/test.fabric8.io/v1alpha1/hellos/myresource", "DELETE");
  }

  @Test
  void testGetConfigmap() throws IOException {
    // Given
    mockCallWithResponse(HttpURLConnection.HTTP_OK, "{\"kind\": \"ConfigMap\"}");
    CustomResourceDefinitionContext configMapContext = new CustomResourceDefinitionContext.Builder()
      .withGroup(null)
      .withVersion("v1")
      .withPlural("configmaps")
      .withScope("Namespaced")
      .withKind("ConfigMap")
      .build();
    RawCustomResourceOperationsImpl rawOp = new RawCustomResourceOperationsImpl(mockClient, config, configMapContext);

    // When
    Map<String, Object> unstructuredConfigMap = rawOp.inNamespace("default").withName("game-config").get();

    // Then
    assertThat(unstructuredConfigMap).isNotNull();
    assertRequestCaptured("/api/v1/namespaces/default/configmaps/game-config", "GET");
  }

  @Test
  void testEditCR() throws IOException {
    // Given
    mockCallWithResponse(i -> buildResponse(HttpURLConnection.HTTP_OK, "{\"kind\": \"Hello\"}"));
    String jsonString = "{ \"metadata\": " + Serialization.jsonMapper().writeValueAsString(new ObjectMetaBuilder().withName("myresource").withNamespace("mynamespace").build()) + "}";

    // When
    Map<String, Object> res = clusterOperations.edit(jsonString);

    // Then
    assertNotNull(res);
  }

  @Test
  @DisplayName("watch, with valid Watcher, should connect and receive event")
  void watch() throws IOException {
    // Given
    final AtomicReference<String> eventReceived = new AtomicReference<>();
    when(mockClient.newBuilder().readTimeout(anyLong(), any()).build().newWebSocket(any(), any())).thenAnswer(i -> {
      final WebSocket webSocket = mock(WebSocket.class);
      ((WebSocketListener)i.getArguments()[1]).onOpen(webSocket, mock(Response.class));
      ((WebSocketListener)i.getArguments()[1])
        .onMessage(webSocket, "{\"type\":\"ADDED\", \"object\":{\"kind\": \"Hello\", \"metadata\": {\"name\": \"test\"}}}");
      return webSocket;
    });
    // When
    final Watch result = clusterOperations.watch(new Watcher<String>() {
      @Override
      public void eventReceived(Action action, String resource) {
        eventReceived.set(resource);
      }

      @Override
      public void onClose(WatcherException cause) {

      }
    });
    // Then
    verify(mockClient.newBuilder().readTimeout(anyLong(), any()).build(), times(1))
      .newWebSocket(captor.capture(), any());
    assertThat(eventReceived).hasValue("{\"kind\":\"Hello\",\"metadata\":{\"name\":\"test\"}}");
    assertThat(result).isNotNull();
    assertThat(captor.getValue().url())
      .hasToString("https://localhost:8443/apis/test.fabric8.io/v1alpha1/hellos?watch=true");
  }

  private void mockCallWithResponse(int code) throws IOException {
    mockCallWithResponse(code, "{\"kind\":\"Status\",\"status\":\"Success\"}");
  }

  private void mockCallWithResponse(int code, String body) throws IOException {
    mockCallWithResponse(i -> buildResponse(code, body));
  }

  @SafeVarargs
  private final void mockCallWithResponse(
    Function<InvocationOnMock, Response> response, Function<InvocationOnMock, Response>... responses)
    throws IOException {
    Call mockCall = mock(Call.class);
    final AtomicInteger invocationCount = new AtomicInteger(-1);
    when(mockCall.execute()).thenAnswer(invocation -> {
      final int current = invocationCount.getAndIncrement();
      if (current == -1 || responses.length == 0){
        return response.apply(invocation);
      } else if (current < responses.length) {
        return responses[current].apply(invocation);
      }
      return responses[responses.length - 1].apply(invocation);
    });
    when(mockClient.newCall(any())).thenReturn(mockCall);
  }

  private Response buildResponse(int code) {
    return buildResponse(code, "{\"kind\":\"Status\",\"status\":\"Success\"}");
  }

  private Response buildResponse(int code, String body) {
    return new Response.Builder()
      .request(new Request.Builder().url("http://mock").build())
      .protocol(Protocol.HTTP_1_1)
      .code(code)
      .body(ResponseBody.create(MediaType.get("application/json"), body))
      .message("mock")
      .build();
  }

  private void assertRequestCaptured(int order, String url, String method) {
    verify(mockClient, atLeastOnce()).newCall(captor.capture());
    assertEquals(url, captor.getAllValues().get(order).url().encodedPath());
    assertEquals(method, captor.getAllValues().get(order).method());
  }

  private void assertRequestCaptured(String url, String method) {
    verify(mockClient, atLeastOnce()).newCall(captor.capture());
    assertEquals(url, captor.getValue().url().encodedPath());
    assertEquals(method, captor.getValue().method());
  }
}
