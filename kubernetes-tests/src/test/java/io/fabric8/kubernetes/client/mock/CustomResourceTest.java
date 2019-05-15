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

import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomResourceTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  private CustomResourceDefinitionContext customResourceDefinitionContext = new CustomResourceDefinitionContext.Builder()
    .withGroup("test.fabric8.io")
    .withName("hellos.test.fabric8.io")
    .withPlural("hellos")
    .withScope("Namespaced")
    .withVersion("v1alpha1")
    .build();

  @Test
  public void testLoad() throws IOException {
    KubernetesClient client = server.getClient();
    Map<String, Object> customResource = client.customResource(customResourceDefinitionContext).load(getClass().getResourceAsStream("/test-hello-cr.yml"));
    assertNotNull(customResource);
    assertEquals("example-hello", ((Map<String, Object>)customResource.get("metadata")).get("name").toString());
  }

  @Test
  public void testCreate() throws IOException {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";

    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();
    KubernetesClient client = server.getClient();

    Map<String, Object> resource = client.customResource(customResourceDefinitionContext).create("ns1", jsonObject);
    assertEquals("example-hello", ((Map<String, Object>)resource.get("metadata")).get("name").toString());
  }

  @Test
  public void testCreateOrReplace() throws IOException {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";

    server.expect().post().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();
    server.expect().put().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();
    KubernetesClient client = server.getClient();

    Map<String, Object> resource = client.customResource(customResourceDefinitionContext).createOrReplace("ns1", jsonObject);
    assertEquals("example-hello", ((Map<String, Object>)resource.get("metadata")).get("name").toString());

    resource = client.customResource(customResourceDefinitionContext).createOrReplace("ns1", jsonObject);
    assertEquals("example-hello", ((Map<String, Object>)resource.get("metadata")).get("name").toString());
  }

  @Test
  public void testList() {
    String jsonObject = "{\"metadata\":{\"continue\":\"\",\"resourceVersion\":\"539617\",\"selfLink\":\"test.fabric8.io/v1alpha1/namespaces/ns1/hellos/\"},\"apiVersion\":\"test.fabric8.io/v1alpha1\",\"kind\":\"HelloList\",\"items\":[{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3},\"uid\":\"3525437a-6a56-11e9-8787-525400b18c1d\"}]}";

    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();
    KubernetesClient client = server.getClient();

    Map<String, Object> list = client.customResource(customResourceDefinitionContext).list("ns1");
    List<Map<String, Object>> items = (List<Map<String, Object>>)list.get("items");
    assertNotNull(items);
    assertEquals(1, items.size());
  }

  @Test
  public void testListWithLabels() {
    String jsonObject = "{\"metadata\":{\"continue\":\"\",\"resourceVersion\":\"539617\",\"selfLink\":\"test.fabric8.io/v1alpha1/namespaces/ns1/hellos/\"},\"apiVersion\":\"test.fabric8.io/v1alpha1\",\"kind\":\"HelloList\",\"items\":[{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\", \"labels\": {\"scope\":\"test\"}},\"spec\": {\"size\": 3},\"uid\":\"3525437a-6a56-11e9-8787-525400b18c1d\"}]}";

    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos?labelSelector=org%3Dfabric8,scope%3Dtest").andReturn(HttpURLConnection.HTTP_CREATED, jsonObject).once();
    KubernetesClient client = server.getClient();

    Map<String, String> labels = new HashMap<>();
    labels.put("org", "fabric8");
    labels.put("scope", "test");
    Map<String, Object> list = client.customResource(customResourceDefinitionContext).list("ns1", labels);
    List<Map<String, Object>> items = (List<Map<String, Object>>)list.get("items");
    assertNotNull(items);
    assertEquals(1, items.size());
  }

  @Test
  public void testGet() {
    String jsonObject = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 3}}";
    server.expect().get().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObject).once();

    KubernetesClient client = server.getClient();
    Map<String, Object> customResource = client.customResource(customResourceDefinitionContext).get("ns1", "example-hello");
    assertNotNull(customResource);
    assertEquals("example-hello", ((Map<String, Object>)customResource.get("metadata")).get("name").toString());
  }

  @Test
  public void testEdit() throws IOException {
    String jsonObjectNew = "{\"apiVersion\": \"test.fabric8.io/v1alpha1\",\"kind\": \"Hello\"," +
      "\"metadata\": {\"name\": \"example-hello\"},\"spec\": {\"size\": 4}}";
    server.expect().put().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, jsonObjectNew).once();

    KubernetesClient client = server.getClient();
    Map<String, Object> customResource = client.customResource(customResourceDefinitionContext).edit("ns1", "example-hello", jsonObjectNew);
    assertNotNull(customResource);
    assertEquals(4, ((Map<String, Object>)customResource.get("spec")).get("size"));
  }

  @Test
  public void testDelete() {
    server.expect().delete().withPath("/apis/test.fabric8.io/v1alpha1/namespaces/ns1/hellos/example-hello").andReturn(HttpURLConnection.HTTP_OK, "{\"metadata\":{},\"apiVersion\":\"v1\",\"kind\":\"Status\",\"details\":{\"name\":\"prometheus-example-rules\",\"group\":\"monitoring.coreos.com\",\"kind\":\"prometheusrules\",\"uid\":\"b3d085bd-6a5c-11e9-8787-525400b18c1d\"},\"status\":\"Success\"}").once();

    KubernetesClient client = server.getClient();
    Map<String, Object> result = client.customResource(customResourceDefinitionContext).delete("ns1", "example-hello");
    assertEquals("Success", result.get("status"));
  }

  @Test(expected = KubernetesClientException.class)
  public void testDeleteWithNamespaceMismatch() {
    KubernetesClient client = server.getClient();
    client.customResource(customResourceDefinitionContext).delete("ns2", "example-hello");
  }
}
