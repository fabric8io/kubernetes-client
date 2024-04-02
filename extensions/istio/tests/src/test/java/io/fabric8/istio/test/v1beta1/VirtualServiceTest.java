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

import io.fabric8.istio.api.networking.v1beta1.Destination;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionAbort;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionAbortHttpStatus;
import io.fabric8.istio.api.networking.v1beta1.HTTPMatchRequestBuilder;
import io.fabric8.istio.api.networking.v1beta1.HTTPRewriteBuilder;
import io.fabric8.istio.api.networking.v1beta1.HTTPRoute;
import io.fabric8.istio.api.networking.v1beta1.HTTPRouteBuilder;
import io.fabric8.istio.api.networking.v1beta1.HTTPRouteDestination;
import io.fabric8.istio.api.networking.v1beta1.HTTPRouteDestinationBuilder;
import io.fabric8.istio.api.networking.v1beta1.StringMatch;
import io.fabric8.istio.api.networking.v1beta1.StringMatchBuilder;
import io.fabric8.istio.api.networking.v1beta1.StringMatchPrefix;
import io.fabric8.istio.api.networking.v1beta1.StringMatchRegex;
import io.fabric8.istio.api.networking.v1beta1.VirtualService;
import io.fabric8.istio.api.networking.v1beta1.VirtualServiceBuilder;
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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class VirtualServiceTest {

  IstioClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a Virtual Service")
  void testGet() {
    VirtualService service2 = new VirtualServiceBuilder().withNewMetadata().withName("service2").endMetadata().build();
    client.v1beta1().virtualServices().inNamespace("ns2").create(service2);

    VirtualService service = client.v1beta1().virtualServices().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a Virtual Service")
  void testCreate() throws InterruptedException {
    // Example from: https://istio.io/latest/docs/reference/config/networking/virtual-service/
    VirtualService service = new VirtualServiceBuilder()
        .withNewMetadata()
        .withName("reviews-route")
        .endMetadata()
        .withNewSpec()
        .withHosts("reviews-v2-routes")
        .withHttp(
            new HTTPRouteBuilder().withName("reviews-v2-routes")
                .withMatch(
                    new HTTPMatchRequestBuilder()
                        .withUri(new StringMatchBuilder().withMatchType(new StringMatchPrefix("/wpcatalog")).build()).build(),
                    new HTTPMatchRequestBuilder()
                        .withUri(new StringMatchBuilder().withMatchType(new StringMatchPrefix("/consumercatalog")).build())
                        .build())
                .withRewrite(new HTTPRewriteBuilder().withUri("/newcatalog").build())
                .withRoute(
                    new HTTPRouteDestinationBuilder()
                        .withNewDestination()
                        .withHost("reviews.prod.svc.cluster.local")
                        .withSubset("v2")
                        .endDestination()
                        .build())
                .build())
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns2/virtualservices")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.v1beta1().virtualServices().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"networking.istio.io/v1beta1\","
        + "\"kind\":\"VirtualService\","
        + "\"metadata\":{\"name\":\"reviews-route\"},"
        + "\"spec\":{"
        + "\"hosts\":[\"reviews-v2-routes\"],"
        + "\"http\":[{"
        + "\"match\":["
        + "{\"uri\":{\"prefix\":\"/wpcatalog\"}},"
        + "{\"uri\":{\"prefix\":\"/consumercatalog\"}}],"
        + "\"name\":\"reviews-v2-routes\","
        + "\"rewrite\":{\"uri\":\"/newcatalog\"},"
        + "\"route\":[{\"destination\":{\"host\":\"reviews.prod.svc.cluster.local\",\"subset\":\"v2\"}}]}]}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a Virtual Service")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/virtualservices/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new VirtualServiceBuilder().build())
        .once();
    boolean deleted = client.v1beta1().virtualServices().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/networking.istio.io/v1beta1/namespaces/ns3/virtualservices/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new VirtualServiceBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().virtualServices().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }

  // @formatter:off
  /*
    ---
apiVersion: "networking.istio.io/v1beta1"
kind: "VirtualService"
metadata:
  annotations: {}
  finalizers: []
  labels: {}
  name: "details"
  ownerReferences: []
spec:
  hosts:
  - "details"
  http:
  - route:
    - destination:
        host: "details"
        subset: "v1"
     */
  // @formatter:on
  @Test
  void checkBasicVirtualService() throws Exception {
    final VirtualService virtualService = new VirtualServiceBuilder()
        .withNewMetadata()
        .withName("details")
        .endMetadata()
        .withNewSpec()
        .withHosts("details")
        .addNewHttp()
        .addNewRoute()
        .withNewDestination()
        .withHost("details")
        .withSubset("v1")
        .endDestination()
        .endRoute()
        .endHttp()
        .endSpec()
        .build();

    final String output = Serialization.yamlMapper().writeValueAsString(virtualService);

    final Map<String, Object> reloaded = loadYaml(output);

    assertEquals("VirtualService", reloaded.get("kind"));

    final Map<String, Object> metadata = (Map<String, Object>) reloaded.get("metadata");
    assertNotNull(metadata);
    assertEquals("details", metadata.get("name"));

    final Map<String, Object> spec = (Map<String, Object>) reloaded.get("spec");
    assertNotNull(spec);

    final List<Map> https = (List) spec.get("http");
    assertNotNull(https);

    final Map<String, Map> http = https.get(0);
    assertNotNull(http);

    final List<Map> routes = (List) http.get("route");
    assertNotNull(routes);

    final Map<String, Map> route = routes.get(0);
    assertNotNull(route);

    final Map<String, Object> destination = route.get("destination");
    assertNotNull(destination);

    assertEquals("details", destination.get("host"));
    assertEquals("v1", destination.get("subset"));
  }

  // @formatter:off
  /*
        apiVersion: networking.istio.io/v1beta1
kind: VirtualService
metadata:
  name: reviews-route
spec:
  hosts:
  - reviews.prod.svc.cluster.local
  http:
  - match:
    - uri:
        prefix: "/wpcatalog"
    - uri:
        prefix: "/consumercatalog"
    rewrite:
      uri: "/newcatalog"
    route:
    - destination:
        host: reviews.prod.svc.cluster.local
        subset: v2
  - route:
    - destination:
        host: reviews.prod.svc.cluster.local
        subset: v1
     */
  // @formatter:on
  @Test
  void checkVirtualServiceWithMatch() throws IOException {
    final String reviewsHost = "reviews.prod.svc.cluster.local";
    final VirtualService resource = new VirtualServiceBuilder()
        .withNewMetadata().withName("reviews-route").endMetadata()
        .withNewSpec()
        .addToHosts(reviewsHost)
        .addNewHttp()
        .addNewMatch().withNewUri().withNewStringMatchPrefixType("/wpcatalog").endUri().endMatch()
        .addNewMatch().withNewUri().withNewStringMatchPrefixType("/consumercatalog").endUri().endMatch()
        .withNewRewrite().withUri("/newcatalog").endRewrite()
        .addNewRoute()
        .withNewDestination().withHost(reviewsHost).withSubset("v2").endDestination()
        .endRoute()
        .endHttp()
        .addNewHttp()
        .addNewRoute()
        .withNewDestination().withHost(reviewsHost).withSubset("v1").endDestination()
        .endRoute()
        .endHttp()
        .endSpec()
        .build();

    final String output = Serialization.yamlMapper().writeValueAsString(resource);
    final Map<String, Object> reloaded = loadYaml(output);

    assertEquals("VirtualService", reloaded.get("kind"));

    final Map<String, Object> metadata = (Map<String, Object>) reloaded.get("metadata");
    assertNotNull(metadata);
    assertEquals("reviews-route", metadata.get("name"));

    final Map<String, Object> spec = (Map<String, Object>) reloaded.get("spec");
    assertNotNull(spec);

    assertEquals(reviewsHost, ((List) spec.get("hosts")).get(0).toString());

    final List<Map> https = (List) spec.get("http");
    assertNotNull(https);

    Map<String, Map> http = https.get(0);
    assertNotNull(http);

    final List<Map> matches = (List) http.get("match");
    assertNotNull(matches);
    assertEquals(2, matches.size());
    assertEquals("/wpcatalog", ((Map) matches.get(0).get("uri")).get("prefix"));
    assertEquals("/consumercatalog", ((Map) matches.get(1).get("uri")).get("prefix"));

    assertEquals("/newcatalog", http.get("rewrite").get("uri"));

    Map destination = (Map) ((List<Map>) http.get("route")).get(0).get("destination");
    assertEquals(reviewsHost, destination.get("host"));
    assertEquals("v2", destination.get("subset"));

    http = https.get(1);
    destination = (Map) ((List<Map>) http.get("route")).get(0).get("destination");
    assertEquals(reviewsHost, destination.get("host"));
    assertEquals("v1", destination.get("subset"));
  }

  // @formatter:off
  /*
apiVersion: "networking.istio.io/v1beta1"
kind: "VirtualService"
metadata:
  name: "reviews-route"
spec:
  hosts:
  - "reviews.prod.svc.cluster.local"
  http:
  - route:
    - destination:
        host: "reviews.prod.svc.cluster.local"
        port:
          number: 9090
        subset: "v2"
  - route:
    - destination:
        host: "reviews.prod.svc.cluster.local"
        port:
          number: 9090
        subset: "v1"
    */
  // @formatter:on
  @Test
  void checkVirtualServiceWithPortSelector() throws IOException {
    final String reviewsHost = "reviews.prod.svc.cluster.local";
    final VirtualService resource = new VirtualServiceBuilder()
        .withNewMetadata().withName("reviews-route").endMetadata()
        .withNewSpec()
        .addToHosts(reviewsHost)
        .addNewHttp()
        .addNewRoute()
        .withNewDestination().withHost(reviewsHost).withSubset("v2").withNewPort()
        .withNumber(9090).endPort().endDestination()
        .endRoute()
        .endHttp()
        .addNewHttp()
        .addNewRoute()
        .withNewDestination().withHost(reviewsHost).withSubset("v1").withNewPort()
        .withNumber(9090).endPort().endDestination()
        .endRoute()
        .endHttp()
        .endSpec()
        .build();

    final String output = Serialization.yamlMapper().writeValueAsString(resource);
    final Map<String, Object> reloaded = loadYaml(output);

    assertEquals("VirtualService", reloaded.get("kind"));

    final Map<String, Object> metadata = (Map<String, Object>) reloaded.get("metadata");
    assertNotNull(metadata);
    assertEquals("reviews-route", metadata.get("name"));

    final Map<String, Object> spec = (Map<String, Object>) reloaded.get("spec");
    assertNotNull(spec);

    assertEquals(reviewsHost, ((List) spec.get("hosts")).get(0).toString());

    final List<Map> https = (List) spec.get("http");
    assertNotNull(https);

    Map<String, Map> http = https.get(0);
    assertNotNull(http);

    Map destination = (Map) ((List<Map>) http.get("route")).get(0).get("destination");
    assertEquals(reviewsHost, destination.get("host"));
    assertEquals("v2", destination.get("subset"));

    final Map<String, Integer> portSelector1 = (Map<String, Integer>) (destination.get("port"));
    assertNotNull(portSelector1);
    assertEquals(9090, portSelector1.get("number").intValue());

    http = https.get(1);
    destination = (Map) ((List<Map>) http.get("route")).get(0).get("destination");
    assertEquals(reviewsHost, destination.get("host"));
    assertEquals("v1", destination.get("subset"));

    final Map<String, Integer> portSelector2 = (Map<String, Integer>) (destination.get("port"));
    assertNotNull(portSelector2);
    assertEquals(9090, portSelector2.get("number").intValue());
  }

  @Test
  void loadingFromYAMLShouldWork() throws Exception {
    final InputStream inputStream = VirtualServiceTest.class.getResourceAsStream("/v1beta1/virtual-service.yaml");

    // @formatter:off
        /*
 apiVersion: networking.istio.io/v1beta1
 metadata:
 kind: VirtualService
   name: ratings-route
 spec:
   hosts:
     - ratings.prod.svc.cluster.local
   http:
   - route:
     - destination:
         host: ratings.prod.svc.cluster.local
         subset: v1
     fault:
       abort:
         percent: 10
         httpStatus: 400
         */
    // @formatter:on

    final VirtualService virtualService = Serialization.yamlMapper().readValue(inputStream, VirtualService.class);
    assertEquals("ratings.prod.svc.cluster.local", virtualService.getSpec().getHosts().get(0));
    final List<HTTPRoute> http = virtualService.getSpec().getHttp();
    assertEquals(1, http.size());
    final HTTPRoute route = http.get(0);
    final List<HTTPRouteDestination> destinations = route.getRoute();
    assertEquals(1, destinations.size());
    final Destination destination = destinations.get(0).getDestination();
    assertEquals("ratings.prod.svc.cluster.local", destination.getHost());
    assertEquals("v1", destination.getSubset());
    assertNull(route.getFault().getDelay());
    final HTTPFaultInjectionAbort abort = route.getFault().getAbort();
    assertEquals(10, abort.getPercentage().getValue().intValue());
    assertEquals(400, ((HTTPFaultInjectionAbortHttpStatus) abort.getErrorType()).getHttpStatus().intValue());
  }

  @Test
  void loadingFromYAMLIssue48() throws Exception {
    final InputStream inputStream = VirtualServiceTest.class.getResourceAsStream("/v1beta1/virtual-service-issue48.yaml");
    final VirtualService virtualService = Serialization.yamlMapper().readValue(inputStream, VirtualService.class);

   // @formatter:off
        /*
        ...
        spec:
  hosts:
    - recommendation
  http:
    - match:
        - headers:
            baggage-user-agent:
              regex: .*DarkLaunch.*

              ...
         */
    // @formatter:on

    final Map<String, StringMatch> headers = virtualService.getSpec().getHttp().get(0).getMatch().get(0).getHeaders();
    final StringMatch stringMatch = headers.get("baggage-user-agent");
    assertEquals(StringMatchRegex.class, stringMatch.getMatchType().getClass());
    StringMatchRegex regex = (StringMatchRegex) stringMatch.getMatchType();
    assertEquals(".*DarkLaunch.*", regex.getRegex());
  }

  @Test
  void allowCredentialsShouldWork() throws IOException {
    final InputStream inputStream = VirtualServiceTest.class.getResourceAsStream("/v1beta1/virtual-service-issue119.yaml");
    final VirtualService virtualService = Serialization.yamlMapper().readValue(inputStream, VirtualService.class);

    assertFalse(virtualService.getSpec().getHttp().get(0).getCorsPolicy().getAllowCredentials());
  }

  private Map<String, Object> loadYaml(String output) {
    Load parser = new Load(LoadSettings.builder().build());
    return (Map<String, Object>) parser.loadFromString(output);
  }
}
