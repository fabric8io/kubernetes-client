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

import io.fabric8.kubernetes.api.model.APIGroupListBuilder;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableRuleMigrationSupport
class AdaptTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();

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

    KubernetesClient client = server.getClient();
    OpenShiftClient oclient = client.adapt(OpenShiftClient.class);
    assertNotNull(client.adapt(OkHttpClient.class));
    assertNotNull(oclient.adapt(OkHttpClient.class));
  }
}
