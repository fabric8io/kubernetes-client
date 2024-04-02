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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;

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
        + "\"selector\":{\"app\":\"my-gateway-controller\"},"
        + "\"servers\":[{\"hosts\":[\"uk.bookinfo.com\",\"eu.bookinfo.com\"],"
        + "\"port\":{\"name\":\"http\",\"number\":80,\"protocol\":\"HTTP\"},"
        + "\"tls\":{\"httpsRedirect\":true}}]}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a Gateway")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/gateways/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new GatewayBuilder().build())
        .once();
    boolean deleted = client.v1beta1().gateways().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/gateways/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new GatewayBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().gateways().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  void checkBasicGateway() throws Exception {
    final Gateway gateway = new GatewayBuilder()
        .withNewMetadata()
        .withName("httpbin-gateway")
        .endMetadata()
        .withNewSpec()
        .addToSelector("istio", "ingressgateway")
        .addNewServer().withNewPort().withName("http").withProtocol("HTTP").withNumber(80).endPort()
        .withHosts("httpbin.example.com").endServer()
        .addNewServer().withHosts("foobar.com").withNewPort().withName("tls-0").withNumber(443).withProtocol("TLS")
        .withTargetPort(443).endPort()
        .withNewTls().withMode(PASSTHROUGH).withMinProtocolVersion(TLSV1_2).endTls()
        .endServer()
        .endSpec()
        .build();

    final String output = Serialization.yamlMapper().writeValueAsString(gateway);
    final Map<String, Object> reloaded = loadYaml(output);

    assertEquals("Gateway", reloaded.get("kind"));

    final Map metadata = (Map) reloaded.get("metadata");
    assertNotNull(metadata);
    assertEquals("httpbin-gateway", metadata.get("name"));

    final Map<String, Map> spec = (Map<String, Map>) reloaded.get("spec");
    assertNotNull(spec);

    final Map<String, Object> selector = spec.get("selector");
    assertNotNull(selector);
    assertEquals("ingressgateway", selector.get("istio"));

    final List<Map> servers = (List) spec.get("servers");
    assertNotNull(servers);
    assertEquals(2, servers.size());

    Map<String, Map> server = servers.get(0);
    assertNotNull(server);

    Map<String, Object> port = server.get("port");
    assertNotNull(port);
    assertEquals(80, port.get("number"));
    assertEquals("http", port.get("name"));
    assertEquals("HTTP", port.get("protocol"));

    final List<String> hosts = (List<String>) server.get("hosts");
    assertNotNull(hosts);
    assertEquals("httpbin.example.com", hosts.get(0));

    server = servers.get(1);
    assertNotNull(server);
    port = server.get("port");
    assertNotNull(port);
    assertEquals(443, port.get("number"));
    assertEquals("tls-0", port.get("name"));
    assertEquals("TLS", port.get("protocol"));

    final Map<String, String> tls = server.get("tls");
    assertEquals("TLSV1_2", tls.get("minProtocolVersion"));
  }

  private Map<String, Object> loadYaml(String output) {
    Load parser = new Load(LoadSettings.builder().build());
    return (Map<String, Object>) parser.loadFromString(output);
  }
}
