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

package io.fabric8.openshift.client.dsl.internal.build;

import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.http.AsyncBody;
import io.fabric8.kubernetes.client.http.TestAsyncBody;
import io.fabric8.kubernetes.client.http.TestHttpResponse;
import io.fabric8.kubernetes.client.http.TestStandardHttpClient;
import io.fabric8.kubernetes.client.http.TestStandardHttpClientFactory;
import io.fabric8.openshift.client.OpenShiftClient;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;

class BuildConfigOperationsTimeoutTest {

  private TestStandardHttpClientFactory factory;
  private OpenShiftClient client;

  @BeforeEach
  void setUp() {
    factory = new TestStandardHttpClientFactory();
    client = new KubernetesClientBuilder().withHttpClientFactory(factory).build().adapt(OpenShiftClient.class);
  }

  @DisplayName("instantiateBinary has no timeout")
  @Test
  void buildConfigHasZeroTimeout() {
    // Given
    factory.getInstance(1)
        .expect("/apis/build.openshift.io/v1/namespaces/.+/buildconfigs/foo/instantiatebinary", (r, c) -> {
          final AsyncBody body = new TestAsyncBody();
          c.consume(
              Collections.singletonList(ByteBuffer.wrap(("{\"metadata\": {},\"items\":[]}").getBytes(StandardCharsets.UTF_8))),
              body);
          return CompletableFuture.completedFuture(new TestHttpResponse<AsyncBody>().withCode(200).withBody(body));
        });
    // When
    client.buildConfigs().inNamespace("default").withName("foo").instantiateBinary()
        .fromInputStream(new ByteArrayInputStream("bar".getBytes(StandardCharsets.UTF_8)));
    // Then
    assertThat(factory.getInstances())
        .element(1)
        .extracting(TestStandardHttpClient::getRecordedConsumeBytesDirects)
        .asList()
        .hasSize(1)
        .singleElement()
        .extracting("request")
        .extracting("timeout")
        .asInstanceOf(InstanceOfAssertFactories.DURATION)
        .hasSeconds(0);
    ;
  }
}
