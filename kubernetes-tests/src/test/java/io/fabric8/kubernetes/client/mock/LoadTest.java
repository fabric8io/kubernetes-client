package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.server.mock.KubernetesServer;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoadTest {

  @Rule
  public KubernetesServer server = new KubernetesServer();

  @Test
  public void testResourceGetFromLoadWhenMultipleDocumentsWithDelimiter() throws Exception {
    // given
    KubernetesClient client = server.getClient();

    // when
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/multiple-document-template.yml")).get();

    // then
    assertNotNull(result);
    assertEquals(6, result.size());
    HasMetadata deploymentResource = result.get(1);
    assertEquals("extensions/v1beta1", deploymentResource.getApiVersion());
    assertEquals("Deployment", deploymentResource.getKind());
    assertEquals("redis-master", deploymentResource.getMetadata().getName());
  }

  @Test
  public void testResourceGetFromLoadWhenSingleDocumentsWithoutDelimiter() throws Exception {
    // given
    KubernetesClient client = server.getClient();

    // when
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/template-with-params.yml")).get();

    // then
    assertNotNull(result);
    assertEquals(1, result.size());
    HasMetadata deploymentResource = result.get(0);
    assertEquals("v1", deploymentResource.getApiVersion());
    assertEquals("Pod", deploymentResource.getKind());
    assertEquals("example-pod", deploymentResource.getMetadata().getName());
  }

  @Test
  public void testResourceGetFromLoadWhenSingleDocumentsWithStartingDelimiter() throws Exception {
    // given
    KubernetesClient client = server.getClient();

    // when
    List<HasMetadata> result = client.load(getClass().getResourceAsStream("/test-template.yml")).get();

    // then
    assertNotNull(result);
    assertEquals(5, result.size());
    HasMetadata deploymentResource = result.get(1);
    assertEquals("v1", deploymentResource.getApiVersion());
    assertEquals("ImageStream", deploymentResource.getKind());
    assertEquals("eap-app", deploymentResource.getMetadata().getName());
  }
}
