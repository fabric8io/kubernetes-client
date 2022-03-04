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
package io.fabric8.istio.test.v1beta1;

import io.fabric8.istio.api.networking.v1beta1.Gateway;
import io.fabric8.istio.api.networking.v1beta1.GatewayBuilder;
import io.fabric8.istio.api.networking.v1beta1.PortBuilder;
import io.fabric8.istio.api.networking.v1beta1.ServerBuilder;
import io.fabric8.istio.api.networking.v1beta1.ServerTLSSettingsBuilder;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.fabric8.istio.api.networking.v1beta1.ServerTLSSettingsTLSProtocol.TLSV1_2;
import static io.fabric8.istio.api.networking.v1beta1.ServerTLSSettingsTLSmode.PASSTHROUGH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class GatewayTest {

  IstioClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a Gateway")
  void testGet() {
    Gateway service2 = new GatewayBuilder().withNewMetadata().withName("service2").endMetadata().build();
    server.expect().get().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/gateways/service2")
      .andReturn(HttpURLConnection.HTTP_OK, service2)
      .once();

    Gateway service = client.v1beta1().gateways().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a Gateway")
  void testCreate() throws InterruptedException {
    // Example from: https://istio.io/latest/docs/reference/config/networking/virtual-service/
    Gateway service = new GatewayBuilder()
      .withNewMetadata()
      .withName("my-gateway")
      .endMetadata()
      .withNewSpec()
      .withSelector(Collections.singletonMap("app", "my-gateway-controller"))
      .withServers(new ServerBuilder()
        .withPort(new PortBuilder().withNumber(80).withProtocol("HTTP").withName("http").build())
        .withHosts("uk.bookinfo.com", "eu.bookinfo.com")
        .withTls(new ServerTLSSettingsBuilder().withHttpsRedirect(true).build())
        .build())
      .endSpec()
      .build();

    server.expect().post().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/gateways")
      .andReturn(HttpURLConnection.HTTP_OK, service)
      .once();
    service = client.v1beta1().gateways().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"networking.istio.io/v1beta1\","
        + "\"kind\":\"Gateway\","
        + "\"metadata\":{\"name\":\"my-gateway\"},"
        + "\"spec\":{"
        +   "\"selector\":{\"app\":\"my-gateway-controller\"},"
        +   "\"servers\":[{\"hosts\":[\"uk.bookinfo.com\",\"eu.bookinfo.com\"],"
        +   "\"port\":{\"name\":\"http\",\"number\":80,\"protocol\":\"HTTP\"},"
        +   "\"tls\":{\"httpsRedirect\":true}}]}}",
      recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a Gateway")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/gateways/service3")
      .andReturn(HttpURLConnection.HTTP_OK, new GatewayBuilder().build())
      .once();
    Boolean deleted = client.v1beta1().gateways().inNamespace("ns3").withName("service3").delete();
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}", recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/gateways/service3")
      .andReturn(HttpURLConnection.HTTP_OK, new GatewayBuilder().build())
      .once();
    Boolean deleted = client.v1beta1().gateways().inNamespace("ns3").withName("service3")
      .withPropagationPolicy(DeletionPropagation.ORPHAN).delete();
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
      recordedRequest.getBody().readUtf8());
  }

  @Test
  public void checkBasicGateway() throws Exception {
    final Gateway gateway = new GatewayBuilder()
      .withNewMetadata()
      .withName("httpbin-gateway")
      .endMetadata()
      .withNewSpec()
      .addToSelector("istio", "ingressgateway")
      .addNewServer().withNewPort().withName("http").withProtocol("HTTP").withNumber(80).endPort()
      .withHosts("httpbin.example.com").endServer()
      .addNewServer().withHosts("foobar.com").withNewPort("tls-0", 443, "TLS", 443)
      .withNewTls().withMode(PASSTHROUGH).withMinProtocolVersion(TLSV1_2).endTls()
      .endServer()
      .endSpec()
      .build();

    final String output = Serialization.yamlMapper().writeValueAsString(gateway);
    Yaml parser = new Yaml();
    final Map<String, Object> reloaded = parser.loadAs(output, Map.class);

    Assert.assertEquals("Gateway", reloaded.get("kind"));

    final Map metadata = (Map) reloaded.get("metadata");
    Assert.assertNotNull(metadata);
    Assert.assertEquals("httpbin-gateway", metadata.get("name"));

    final Map<String, Map> spec = (Map<String, Map>) reloaded.get("spec");
    Assert.assertNotNull(spec);

    final Map<String, Object> selector = spec.get("selector");
    Assert.assertNotNull(selector);
    Assert.assertEquals("ingressgateway", selector.get("istio"));

    final List<Map> servers = (List) spec.get("servers");
    Assert.assertNotNull(servers);
    Assert.assertEquals(2, servers.size());

    Map<String, Map> server = servers.get(0);
    Assert.assertNotNull(server);

    Map<String, Object> port = server.get("port");
    Assert.assertNotNull(port);
    Assert.assertEquals(80, port.get("number"));
    Assert.assertEquals("http", port.get("name"));
    Assert.assertEquals("HTTP", port.get("protocol"));

    final List<String> hosts = (List<String>) server.get("hosts");
    Assert.assertNotNull(hosts);
    Assert.assertEquals("httpbin.example.com", hosts.get(0));

    server = servers.get(1);
    Assert.assertNotNull(server);
    port = server.get("port");
    Assert.assertNotNull(port);
    Assert.assertEquals(443, port.get("number"));
    Assert.assertEquals("tls-0", port.get("name"));
    Assert.assertEquals("TLS", port.get("protocol"));

    final Map<String, String> tls = server.get("tls");
    Assert.assertEquals("TLSV1_2", tls.get("minProtocolVersion"));
  }
}
