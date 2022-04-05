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

import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicy;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyAction;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyBuilder;
import io.fabric8.istio.api.security.v1beta1.ConditionBuilder;
import io.fabric8.istio.api.security.v1beta1.OperationBuilder;
import io.fabric8.istio.api.security.v1beta1.RuleBuilder;
import io.fabric8.istio.api.security.v1beta1.RuleFromBuilder;
import io.fabric8.istio.api.security.v1beta1.RuleToBuilder;
import io.fabric8.istio.api.security.v1beta1.SourceBuilder;
import io.fabric8.istio.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.client.IstioClient;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class AuthorizationPolicyTest {

  IstioClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a AuthorizationPolicy Entry")
  void testGet() {
    AuthorizationPolicy service2 = new AuthorizationPolicyBuilder().withNewMetadata().withName("service2").endMetadata()
        .build();
    server.expect().get().withPath("/apis/security.istio.io/v1beta1/namespaces/ns2/authorizationpolicies/service2")
        .andReturn(HttpURLConnection.HTTP_OK, service2)
        .once();

    AuthorizationPolicy service = client.v1beta1().authorizationPolicies().inNamespace("ns2").withName("service2").get();
    assertNotNull(service);
    assertEquals("service2", service.getMetadata().getName());
  }

  @Test
  @DisplayName("Should Create a AuthorizationPolicy Entry")
  void testCreate() throws InterruptedException {
    AuthorizationPolicy service = new AuthorizationPolicyBuilder()
        .withNewMetadata()
        .withName("httpbin")
        .endMetadata()
        .withNewSpec()
        .withSelector(new WorkloadSelectorBuilder().withMatchLabels(Collections.singletonMap("app", "httpbin")).build())
        .withAction(AuthorizationPolicyAction.DENY)
        .withRules(new RuleBuilder()
            .withFrom(
                new RuleFromBuilder()
                    .withSource(new SourceBuilder().withPrincipals("cluster.local/ns/default/sa/sleep").build())
                    .build(),
                new RuleFromBuilder().withSource(new SourceBuilder().withNamespaces("dev").build()).build())
            .withTo(new RuleToBuilder().withOperation(new OperationBuilder().withMethods("GET").build()).build())
            .withWhen(
                new ConditionBuilder().withKey("request.auth.claims[iss]").withValues("https://accounts.google.com").build())
            .build())
        .endSpec()
        .build();

    server.expect().post().withPath("/apis/security.istio.io/v1beta1/namespaces/ns2/authorizationpolicies")
        .andReturn(HttpURLConnection.HTTP_OK, service)
        .once();
    service = client.v1beta1().authorizationPolicies().inNamespace("ns2").create(service);
    assertNotNull(service);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"security.istio.io/v1beta1\","
        + "\"kind\":\"AuthorizationPolicy\","
        + "\"metadata\":{\"name\":\"httpbin\"},"
        + "\"spec\":{"
        + "\"action\":\"DENY\","
        + "\"rules\":["
        + "{\"from\":[{\"source\":{\"principals\":[\"cluster.local/ns/default/sa/sleep\"]}},"
        + "{\"source\":{\"namespaces\":[\"dev\"]}}],"
        + "\"to\":[{\"operation\":{\"methods\":[\"GET\"]}}],"
        + "\"when\":[{\"key\":\"request.auth.claims[iss]\",\"values\":[\"https://accounts.google.com\"]}]}],"
        + "\"selector\":{\"matchLabels\":{\"app\":\"httpbin\"}}}}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should Delete a AuthorizationPolicy Entry")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/security.istio.io/v1beta1/namespaces/ns3/authorizationpolicies/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new AuthorizationPolicyBuilder().build())
        .once();
    boolean deleted = client.v1beta1().authorizationPolicies().inNamespace("ns3").withName("service3").delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete with PropagationPolicy=Orphan")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/security.istio.io/v1beta1/namespaces/ns3/authorizationpolicies/service3")
        .andReturn(HttpURLConnection.HTTP_OK, new AuthorizationPolicyBuilder().build())
        .once();
    Boolean deleted = client.v1beta1().authorizationPolicies().inNamespace("ns3").withName("service3")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(deleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }
}
