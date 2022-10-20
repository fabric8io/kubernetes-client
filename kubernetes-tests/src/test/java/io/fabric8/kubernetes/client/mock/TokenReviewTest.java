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

import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.authentication.TokenReviewBuilder;
import io.fabric8.kubernetes.api.model.authentication.TokenReviewStatusBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class TokenReviewTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  @DisplayName("Should create TokenReview")
  void testCreate() {
    // Given
    TokenReview tokenReview = new TokenReviewBuilder()
        .withNewSpec()
        .withToken("eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJhdWQiOlsidmF1bHQiXSwiZXhwIjoxNTUyNjc1")
        .endSpec()
        .build();
    server.expect().post().withPath("/apis/authentication.k8s.io/v1/tokenreviews")
        .andReply(HttpURLConnection.HTTP_OK, recordedRequest -> {
          TokenReview tokenReviewReq = Serialization.unmarshal(recordedRequest.getBody().readString(Charset.defaultCharset()),
              TokenReview.class);
          tokenReviewReq.setStatus(new TokenReviewStatusBuilder()
              .withAuthenticated(true)
              .withNewUser()
              .withUsername("system:serviceaccount:dev:http-svc-test")
              .withUid("4afdf4d0-46d2-11e9-8716-005056bf4b40")
              .withGroups("system:serviceaccounts", "system:serviceaccounts:dev", "system:authenticated")
              .endUser()
              .addToAudiences("factors")
              .build());

          return tokenReviewReq;
        }).once();

    // When
    tokenReview = client.tokenReviews().create(tokenReview);

    // Then
    assertNotNull(tokenReview);
    assertNotNull(tokenReview.getStatus());
    assertTrue(tokenReview.getStatus().getAuthenticated());
    assertEquals("system:serviceaccount:dev:http-svc-test", tokenReview.getStatus().getUser().getUsername());
    assertEquals("4afdf4d0-46d2-11e9-8716-005056bf4b40", tokenReview.getStatus().getUser().getUid());
    assertEquals(3, tokenReview.getStatus().getUser().getGroups().size());
  }
}
