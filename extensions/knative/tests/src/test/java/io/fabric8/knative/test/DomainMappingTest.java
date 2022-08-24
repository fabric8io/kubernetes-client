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
package io.fabric8.knative.test;

import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.serving.v1beta1.DomainMapping;
import io.fabric8.knative.serving.v1beta1.DomainMappingBuilder;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class DomainMappingTest {

  KnativeClient client;
  KubernetesMockServer server;

  @Test
  void testCreateOrReplace() {
    // Given
    DomainMapping domainMapping = createNewDomainMapping("helloworld-nodejs-red-blue1");
    server.expect().post().withPath("/apis/serving.knative.dev/v1beta1/namespaces/test/domainmappings")
        .andReturn(HttpURLConnection.HTTP_CONFLICT, domainMapping)
        .once();
    server.expect().get()
        .withPath("/apis/serving.knative.dev/v1beta1/namespaces/test/domainmappings/helloworld-nodejs-red-blue1")
        .andReturn(HttpURLConnection.HTTP_OK, domainMapping)
        .times(2);
    server.expect().put()
        .withPath("/apis/serving.knative.dev/v1beta1/namespaces/test/domainmappings/helloworld-nodejs-red-blue1")
        .andReturn(HttpURLConnection.HTTP_OK, domainMapping)
        .once();

    // When
    domainMapping = client.domainMappings().resource(domainMapping).createOrReplace();

    // Then
    assertNotNull(domainMapping);
  }

  private DomainMapping createNewDomainMapping(String name) {
    return new DomainMappingBuilder()
        .withNewMetadata()
        .withName("helloworld-nodejs-red-blue1")
        .addToAnnotations("foo", "bar")
        .withNamespace("test")
        .endMetadata()
        .withNewSpec()
        .withNewRef()
        .withName("foo-svc")
        .withKind("Service")
        .withApiVersion("serving.knative.dev/v1")
        .endRef()
        .withNewTls()
        .withSecretName("cert-secret")
        .endTls()
        .endSpec()
        .build();
  }
}
