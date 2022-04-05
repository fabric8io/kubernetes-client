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
package io.fabric8.tekton.pipeline.v1beta1;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.tekton.client.TektonClient;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient
class PipelineTest {

  KubernetesMockServer server;
  TektonClient client;

  @Test
  @DisplayName("Should get a pipeline")
  void testGet() {
    server.expect().get().withPath("/apis/tekton.dev/v1beta1/namespaces/ns1/pipelines/pipeline")
        .andReturn(HttpURLConnection.HTTP_OK, new io.fabric8.tekton.pipeline.v1beta1.PipelineBuilder()
            .withNewMetadata()
            .withName("pipeline")
            .endMetadata()
            .build())
        .once();

    Pipeline pipeline = client.v1beta1().pipelines().inNamespace("ns1").withName("pipeline").get();
    assertNotNull(pipeline);
  }

  @Test
  @DisplayName("Should create a pipeline")
  void testCreate() {
    Pipeline pipeline = new io.fabric8.tekton.pipeline.v1beta1.PipelineBuilder().withNewMetadata().withName("pipeline")
        .endMetadata().build();
    server.expect().post().withPath("/apis/tekton.dev/v1beta1/namespaces/ns1/pipelines")
        .andReturn(HttpURLConnection.HTTP_OK, pipeline).once();

    pipeline = client.v1beta1().pipelines().inNamespace("ns1").create(pipeline);
    assertNotNull(pipeline);
  }

  @Test
  @DisplayName("Should delete a pipeline")
  void testDelete() throws InterruptedException {
    server.expect().delete().withPath("/apis/tekton.dev/v1beta1/namespaces/ns1/pipelines/pipeline")
        .andReturn(HttpURLConnection.HTTP_OK, new io.fabric8.tekton.pipeline.v1beta1.PipelineBuilder().build())
        .once();

    boolean isDeleted = client.v1beta1().pipelines().inNamespace("ns1").withName("pipeline").delete().size() == 1;
    assertTrue(isDeleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Background\"}",
        recordedRequest.getBody().readUtf8());
  }

  @Test
  @DisplayName("Should delete pipeline with some explicit propagationpolicy")
  void testDeleteOrphan() throws InterruptedException {
    server.expect().delete().withPath("/apis/tekton.dev/v1beta1/namespaces/ns1/pipelines/pipeline")
        .andReturn(HttpURLConnection.HTTP_OK, new io.fabric8.tekton.pipeline.v1beta1.PipelineBuilder().build())
        .once();

    Boolean isDeleted = client.v1beta1().pipelines().inNamespace("ns1").withName("pipeline")
        .withPropagationPolicy(DeletionPropagation.ORPHAN).delete().size() == 1;
    assertTrue(isDeleted);

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("{\"apiVersion\":\"v1\",\"kind\":\"DeleteOptions\",\"propagationPolicy\":\"Orphan\"}",
        recordedRequest.getBody().readUtf8());
  }
}
