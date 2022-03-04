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
package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.tekton.client.TektonClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableKubernetesMockClient
class TriggerTemplateTest {

  TektonClient client;
  KubernetesMockServer server;

  @Test
  @DisplayName("Should get a triggertemplate")
  void testGet() {
    server.expect().get().withPath("/apis/triggers.tekton.dev/v1alpha1/namespaces/ns1/triggertemplates/tt")
        .andReturn(HttpURLConnection.HTTP_OK, new io.fabric8.tekton.triggers.v1alpha1.TriggerTemplateBuilder()
            .withNewMetadata()
            .withName("tt")
            .endMetadata()
            .build())
        .once();

    TriggerTemplate tt = client.v1alpha1().triggerTemplates().inNamespace("ns1").withName("tt").get();
    assertNotNull(tt);
  }

}
