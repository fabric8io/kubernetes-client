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
package io.fabric8.tekton.test.crud;

import io.fabric8.kubernetes.client.server.mock.EnableKubernetesMockClient;
import io.fabric8.tekton.client.TektonClient;
import io.fabric8.tekton.pipeline.v1alpha1.Pipeline;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineBuilder;
import io.fabric8.tekton.pipeline.v1alpha1.PipelineList;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.Param;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableKubernetesMockClient(crud = true)
class V1alpha1PipelineCrudTest {

  TektonClient client;

  @Test
  void shouldReturnEmptyList() {

    PipelineList pipelineList = client.v1alpha1().pipelines().inNamespace("ns1").list();
    assertNotNull(pipelineList);
    assertTrue(pipelineList.getItems().isEmpty());
  }

  @Test
  void shouldListAndGetPipeline() {

    Pipeline pipeline2 = new PipelineBuilder().withNewMetadata().withName("pipeline2").endMetadata().build();

    client.v1alpha1().pipelines().inNamespace("ns2").create(pipeline2);
    PipelineList pipelineList = client.v1alpha1().pipelines().inNamespace("ns2").list();
    assertNotNull(pipelineList);
    assertEquals(1, pipelineList.getItems().size());
    Pipeline pipeline = client.v1alpha1().pipelines().inNamespace("ns2").withName("pipeline2").get();
    assertNotNull(pipeline);
    assertEquals("pipeline2", pipeline.getMetadata().getName());
  }

  @Test
  void shouldDeleteAPipeline() {

    Pipeline pipeline3 = new PipelineBuilder().withNewMetadata().withName("pipeline3").endMetadata().build();

    client.v1alpha1().pipelines().inNamespace("ns3").create(pipeline3);
    Boolean deleted = client.v1alpha1().pipelines().inNamespace("ns3").withName("pipeline3").delete();
    assertTrue(deleted);
  }

  @Test
  void shouldLoadAPipelineWithParams() {

    String pipelineDefinition = String.join("\n", Arrays.asList(
        "apiVersion: tekton.dev/v1alpha1",
        "kind: Pipeline",
        "metadata:",
        "  name: pipeline4",
        "spec:",
        "  tasks:",
        "    - name: task-with-params",
        "      params:",
        "        - name: name",
        "          value: param-value"));

    Pipeline p = client.v1alpha1().pipelines().inNamespace("ns4").load(new ByteArrayInputStream(pipelineDefinition.getBytes()))
        .createOrReplace();

    final List<Param> taskParams = p.getSpec().getTasks().get(0).getParams();
    assertEquals(1, taskParams.size());
    assertEquals("name", taskParams.get(0).getName());
    assertEquals("param-value", taskParams.get(0).getValue().getStringVal());
  }

}
