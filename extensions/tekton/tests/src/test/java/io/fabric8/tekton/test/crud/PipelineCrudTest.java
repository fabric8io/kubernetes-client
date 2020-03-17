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

import io.fabric8.tekton.client.TektonClient;
import io.fabric8.tekton.mock.TektonServer;
import io.fabric8.tekton.pipeline.v1beta1.Pipeline;
import io.fabric8.tekton.pipeline.v1beta1.PipelineBuilder;
import io.fabric8.tekton.pipeline.v1beta1.PipelineList;
import io.fabric8.tekton.pipeline.v1beta1.ParamSpec;
import io.fabric8.tekton.pipeline.v1beta1.PipelineListBuilder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
public class PipelineCrudTest {

  @Rule
  public TektonServer server = new TektonServer();

  @Test
  public void shouldReturnEmptyList() {
    server.expect().withPath("/apis/tekton.dev/v1beta1/namespaces/ns1/pipelines")
      .andReturn(200, new PipelineListBuilder().build()).once();

    TektonClient client = server.getTektonClient();
    PipelineList pipelineList = client.pipelines().inNamespace("ns1").list();
    assertNotNull(pipelineList);
    assertTrue(pipelineList.getItems().isEmpty());
  }

  @Test
  public void shouldListAndGetPipeline() {
    Pipeline pipeline2 = new PipelineBuilder().withNewMetadata().withName("pipeline2").endMetadata().build();
    server.expect().post().withPath("/apis/tekton.dev/v1beta1/namespaces/ns2/pipelines")
      .andReturn(202, pipeline2).once();
    server.expect().get().withPath("/apis/tekton.dev/v1beta1/namespaces/ns2/pipelines")
      .andReturn(200, new PipelineListBuilder().withItems(pipeline2).build()).once();

    TektonClient client = server.getTektonClient();
    client.pipelines().inNamespace("ns2").create(pipeline2);
    PipelineList pipelineList = client.pipelines().inNamespace("ns2").list();
    assertNotNull(pipelineList);
    assertEquals(1, pipelineList.getItems().size());
    Pipeline pipeline = pipelineList.getItems().get(0);
    assertNotNull(pipeline);
    assertEquals("pipeline2", pipeline.getMetadata().getName());
  }

  @Test
  public void shouldDeleteAPipeline() {
    Pipeline pipeline3 = new PipelineBuilder().withApiVersion("v1beta1").withNewMetadata().withName("pipeline3").endMetadata().build();
    server.expect().post().withPath("/apis/tekton.dev/v1beta1/namespaces/ns3/pipelines")
      .andReturn(200, pipeline3).once();
    server.expect().delete().withPath("/apis/tekton.dev/v1beta1/namespaces/ns3/pipelines/pipeline3")
      .andReturn(200, pipeline3).once();
    TektonClient client = server.getTektonClient();

    client.pipelines().inNamespace("ns3").create(pipeline3);
    Boolean deleted = client.pipelines().inNamespace("ns3").withName("pipeline3").delete();
    assertTrue(deleted);
  }

  @Test
  public void shouldLoadAPipelineWithParams() {
    server.expect().post().withPath("/apis/tekton.dev/v1beta1/namespaces/ns4/pipelines")
      .andReturn(200, new PipelineBuilder().withNewMetadata().withName("skaffold-git-output-pipelinerun").endMetadata()
      .withNewSpec()
        .addNewParam().withName("revision").endParam()
        .addNewParam().withName("url").endParam()
      .endSpec()
      .build()).once();
    TektonClient client = server.getTektonClient();

    Pipeline p = client.pipelines().inNamespace("ns4").load(getClass().getResourceAsStream("/pipeline.yml")).createOrReplace();

    final List<ParamSpec> taskParams = p.getSpec().getParams();
    assertEquals(2, taskParams.size());
    assertEquals("revision", taskParams.get(0).getName());
    assertEquals("url", taskParams.get(1).getName());
  }

}
