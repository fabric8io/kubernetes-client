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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KubernetesClientExceptionTest {

  @DisplayName("Exception from HttpRequest contains resource metadata")
  @ParameterizedTest(name = "{index} ''{0}'': group: ''{1}'', version: ''{2}'', plural: ''{3}'', namespace: ''{4}'', name: ''{5}''")
  @MethodSource("exceptionFromHttpRequestContainsExpectedMetadataInput")
  void exceptionFromHttpRequestContainsExpectedMetadata(String url, String expectedGroup, String expectedVersion,
      String expectedPlural, String expectedNamespace, String expectedName) {
    final KubernetesClientException result = new KubernetesClientException(
        null, null, -1, null, new StandardHttpRequest.Builder().uri(url).build());
    assertThat(result)
        .hasFieldOrPropertyWithValue("group", expectedGroup)
        .hasFieldOrPropertyWithValue("version", expectedVersion)
        .hasFieldOrPropertyWithValue("resourcePlural", expectedPlural)
        .hasFieldOrPropertyWithValue("namespace", expectedNamespace)
        .hasFieldOrPropertyWithValue("name", expectedName);
  }

  static Stream<Arguments> exceptionFromHttpRequestContainsExpectedMetadataInput() {
    return Stream.of(
        arguments("https://localhost:8080/apis/apps/v1/deployments", "apps", "v1", "deployments", null, null),
        arguments("https://localhost:8080/api/v1/pods", "", "v1", "pods", null, null),
        arguments("https://localhost:8080/apis/apps/v1/namespaces/foo/deployments",
            "apps", "v1", "deployments", "foo", null),
        arguments("https://localhost:8080/api/v1/namespaces/kube-system/pods/coredns-78fcd69978-7ls8f",
            "", "v1", "pods", "kube-system", "coredns-78fcd69978-7ls8f"),
        arguments("https://localhost:8080/apis/apps/v1/namespaces/foo/deployments/bar-78fcd69978-7ls8f",
            "apps", "v1", "deployments", "foo", "bar-78fcd69978-7ls8f"));
  }
}
