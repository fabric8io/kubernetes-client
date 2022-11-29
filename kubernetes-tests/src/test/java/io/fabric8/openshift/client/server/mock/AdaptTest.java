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

package io.fabric8.openshift.client.server.mock;

import io.fabric8.kubernetes.api.model.APIGroupBuilder;
import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.utils.ResponseProvider;
import io.fabric8.openshift.client.OpenShiftClient;
import okhttp3.Headers;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class AdaptTest {

  KubernetesMockServer server;
  KubernetesClient client;

  @Test
  void testSharedClient() {
    server.expect().withPath("/apis").andReturn(200, new APIGroupListBuilder()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("autoscaling.k8s.io")
        .endGroup()
        .addNewGroup()
        .withApiVersion("v1")
        .withName("security.openshift.io")
        .endGroup()
        .build()).once();

    OpenShiftClient oclient = client.adapt(OpenShiftClient.class);
    assertNotNull(client.getHttpClient());
    assertNotNull(oclient.getHttpClient());
  }

  @Test
  void testCheckIfAvailableAPIGroupsContainOpenShiftOpenShift4() {
    // Given
    String authorizationEndpoint = client.getMasterUrl() + "oauth/authorize";
    server.expect().withPath("/apis").andReturn(HttpURLConnection.HTTP_UNAUTHORIZED, null).once();
    server.expect().get().withPath("/.well-known/oauth-authorization-server")
        .andReturn(HttpURLConnection.HTTP_OK, "{\"authorization_endpoint\":\"" + authorizationEndpoint + "\"}")
        .once();
    server.expect().get().withPath("/oauth/authorize?response_type=token&client_id=openshift-challenging-client")
        .andReply(new ResponseProvider<Object>() {
          @Override
          public Object getBody(RecordedRequest recordedRequest) {
            return null;
          }

          @Override
          public int getStatusCode(RecordedRequest recordedRequest) {
            return HttpURLConnection.HTTP_MOVED_TEMP;
          }

          @Override
          public Headers getHeaders() {
            return new Headers.Builder()
                .add("Location", client.getMasterUrl()
                    + "oauth/token/implicit#access_token=sha256~UkDpAaw0AARKGVvJ0nypSjIDGGLMyxuS9ORWVyMQ2F8&expires_in=86400&scope=user%3Afull&token_type=Bearer")
                .build();
          }

          @Override
          public void setHeaders(Headers headers) {
          }
        }).once();
    server.expect().withPath("/apis").andReturn(HttpURLConnection.HTTP_OK, new APIGroupListBuilder()
        .addToGroups(new APIGroupBuilder().withName("security.internal.openshift.io").build()))
        .once();

    client.getConfiguration().setUsername("foo");
    client.getConfiguration().setPassword("foo-pwd");

    // When
    boolean isOpenShiftAdaptable = client.isAdaptable(OpenShiftClient.class);

    // Then
    assertTrue(isOpenShiftAdaptable);
  }
}
