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
package io.fabric8.kubernetes.client.dsl.internal;

import io.fabric8.kubernetes.client.dsl.internal.OperationSupport.RequestMetadata;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

class OperationSupportTest {
  @Test
  void shouldProperlyExtractMetadataFromURI() {
    RequestMetadata metadata = RequestMetadata.from(
        URI.create("http://localhost:8080/apis/apps/v1/deployments"));
    assertEquals("apps", metadata.group);
    assertEquals("v1", metadata.version);
    assertEquals("deployments", metadata.plural);
    assertNull(metadata.namespace);
    assertNull(metadata.name);
    assertEquals(new RequestMetadata("apps", "v1", "deployments", null, null), metadata);

    metadata = RequestMetadata.from(URI.create("http://localhost:8080/api/v1/pods"));
    assertEquals("", metadata.group);
    assertEquals("v1", metadata.version);
    assertEquals("pods", metadata.plural);
    assertNull(metadata.namespace);
    assertNull(metadata.name);

    metadata = RequestMetadata.from(URI.create("http://localhost:8080/apis/apps/v1/namespaces/foo/deployments"));
    assertEquals("apps", metadata.group);
    assertEquals("v1", metadata.version);
    assertEquals("deployments", metadata.plural);
    assertEquals("foo", metadata.namespace);
    assertNull(metadata.name);

    metadata = RequestMetadata
        .from(URI.create("http://localhost:8080/api/v1/namespaces/kube-system/pods/coredns-78fcd69978-7ls8f"));
    assertEquals("", metadata.group);
    assertEquals("v1", metadata.version);
    assertEquals("pods", metadata.plural);
    assertEquals("kube-system", metadata.namespace);
    assertEquals("coredns-78fcd69978-7ls8f", metadata.name);

    metadata = RequestMetadata
        .from(URI.create("http://localhost:8080/apis/apps/v1/namespaces/foo/deployments/bar-78fcd69978-7ls8f"));
    assertEquals("apps", metadata.group);
    assertEquals("v1", metadata.version);
    assertEquals("deployments", metadata.plural);
    assertEquals("foo", metadata.namespace);
    assertEquals("bar-78fcd69978-7ls8f", metadata.name);
  }

}
