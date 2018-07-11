package io.fabric8.kubernetes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class ListLoadTest {

  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
  }

  @Test
  public void test() {
    client.load(getClass().getResourceAsStream("/test-list.json")).createOrReplace();

    DeploymentList aDeploymentList = client.apps().deployments().inNamespace(currentNamespace).list();
    assertThat(aDeploymentList).isNotNull();
    assertEquals(1, aDeploymentList.getItems().size());
  }

}
