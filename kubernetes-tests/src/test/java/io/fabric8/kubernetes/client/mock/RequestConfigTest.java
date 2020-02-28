/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import io.fabric8.kubernetes.client.OAuthTokenProvider;
import io.fabric8.kubernetes.client.RequestConfig;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.RequestConfigBuilder;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@EnableRuleMigrationSupport
public class RequestConfigTest {
  @Rule
  public KubernetesServer server = new KubernetesServer();

  TestableOAuthTokenProvider tokenProvider = new TestableOAuthTokenProvider();

  @Test
  public void testList() throws InterruptedException {
   server.expect().withPath("/api/v1/namespaces/test/pods/pod1").andReturn(200, new PodBuilder()
     .withNewMetadata()
     .withName("testPod")
     .endMetadata()
     .build()).always();

    server.expect().withPath("/api/v1/namespaces/test/pods/pod2").andReturn(200, new PodBuilder()
      .withNewMetadata()
      .withName("testPod")
      .endMetadata()
      .build()).always();

    NamespacedKubernetesClient client = server.getClient();

    Pod pod1 = client.withRequestConfig(new RequestConfigBuilder().withOauthToken("TOKEN").build()).call(c -> c.pods().inNamespace("test").withName("pod1").get());

    //Let's check that request config actually works
    RecordedRequest request1 = server.getMockServer().takeRequest();
    String authHeader1 = request1.getHeader("Authorization");
    assertEquals("Bearer TOKEN", authHeader1);

    //Let's also check that we didn't pollute client config.
    Pod pod2 = client.pods().inNamespace("test").withName("pod2").get();
    RecordedRequest request2 = server.getMockServer().takeRequest();
    String authHeader2 = request2.getHeader("Authorization");
    assertNotEquals("Bearer TOKEN", authHeader2);
  }

  @Test
  public void testOauthTokenSuppliedByProvider() throws InterruptedException {
    server.expect().withPath("/api/v1/namespaces/test/pods/podName").andReturn(200, new PodBuilder()
                   .withNewMetadata()
                   .withName("testPodX")
                   .endMetadata()
                   .build()).always();

    RequestConfig requestConfig = new RequestConfigBuilder().withOauthTokenProvider(tokenProvider)
                                                            .build();

    tokenProvider.updateToken("token1");
    sendRequest(requestConfig);
    assertAuthorizationHeader("Bearer token1");

    tokenProvider.updateToken("token2");
    sendRequest(requestConfig);
    assertAuthorizationHeader("Bearer token2");
  }

  private void sendRequest(RequestConfig requestConfig) {
    NamespacedKubernetesClient client = server.getClient();
    client.withRequestConfig(requestConfig)
          .call(c -> c.pods().inNamespace("test").withName("podName").get());
  }

  private void assertAuthorizationHeader(String expectedValue) throws InterruptedException {
    RecordedRequest request = server.getMockServer().takeRequest();
    String acutalValue = request.getHeader("Authorization");
    assertEquals(expectedValue, acutalValue);
  }

  private static class TestableOAuthTokenProvider implements OAuthTokenProvider {

    private final AtomicReference<String> token = new AtomicReference<>();

    @Override
    public String getToken() {
        return token.get();
    }

    public void updateToken(String newToken) {
      this.token.set(newToken);
    }
  };

}
