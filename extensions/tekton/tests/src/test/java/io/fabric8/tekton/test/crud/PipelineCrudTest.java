package io.fabric8.tekton.test.crud;

import io.fabric8.tekton.pipeline.v1alpha1.*;
import io.fabric8.tekton.client.TektonClient;
import io.fabric8.tekton.mock.TektonServer;

import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PipelineCrudTest {
  
  @Rule
  public TektonServer server = new TektonServer(true, true);

  @Test
  public void shouldReturnEmptyList() {
    TektonClient client = server.getTektonClient();
    PipelineList pipelineList = client.pipelines().inNamespace("ns1").list();
    assertNotNull(pipelineList);
    assertTrue(pipelineList.getItems().isEmpty());
  }

  @Test
  public void shouldListAndGetPipeline() {
    TektonClient client = server.getTektonClient();
    Pipeline pipeline2 = new PipelineBuilder().withNewMetadata().withName("pipeline2").endMetadata().build();

    client.pipelines().inNamespace("ns2").create(pipeline2);
    PipelineList pipelineList = client.pipelines().inNamespace("ns2").list();
    assertNotNull(pipelineList);
    assertEquals(1, pipelineList.getItems().size());
    Pipeline pipeline = client.pipelines().inNamespace("ns2").withName("pipeline2").get();
    assertNotNull(pipeline);
    assertEquals("pipeline2", pipeline.getMetadata().getName());
  }

  @Test
  public void shouldDeleteAPipeline() {
    TektonClient client = server.getTektonClient();
    Pipeline pipeline3 = new PipelineBuilder().withNewMetadata().withName("pipeline3").endMetadata().build();

    client.pipelines().inNamespace("ns3").create(pipeline3);
    Boolean deleted = client.pipelines().inNamespace("ns3").withName("pipeline3").delete();
    assertTrue(deleted);
  }
}
