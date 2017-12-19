package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collections;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReplicationControllerTest {
  public static KubernetesClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultKubernetesClient();
    currentNamespace = "rt-" + RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    Namespace aNamespace = new NamespaceBuilder().withNewMetadata().withName(currentNamespace).and().build();
    client.namespaces().create(aNamespace);
  }

  @AfterClass
  public static void cleanup() {
    client.namespaces().withName(currentNamespace).delete();
    client.close();
  }

  @Test
  public void testLoad() {
    ReplicationController aReplicationController = client.replicationControllers().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-replicationcontroller.yml")).get();

    assertThat(aReplicationController).isNotNull();
    assertEquals("nginx", aReplicationController.getMetadata().getName());
    assertEquals(3, aReplicationController.getSpec().getReplicas().intValue());
  }

  @Test
  public void testCrud() {
    ReplicationController rc1 = new ReplicationControllerBuilder()
      .withNewMetadata().withName("nginx-controller").addToLabels("server", "nginx").endMetadata()
      .withNewSpec().withReplicas(3)
      .withNewTemplate()
      .withNewMetadata().addToLabels("server", "nginx").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("nginx").withImage("nginx")
      .addNewPort().withContainerPort(80).endPort()
      .endContainer()
      .endSpec()
      .endTemplate()
      .endSpec().build();
    ReplicationController rc2 = new ReplicationControllerBuilder()
      .withNewMetadata().withName("frontend").endMetadata()
      .withNewSpec()
      .withReplicas(1)
      .withSelector(Collections.singletonMap("name", "frontend"))
      .withNewTemplate()
      .withNewMetadata().addToLabels("name", "frontend").endMetadata()
      .withNewSpec()
      .addNewContainer().withName("helloworld").withImage("openshift/hello-openshift")
      .addNewPort().withContainerPort(8080).withProtocol("TCP").endPort()
      .endContainer()
      .withRestartPolicy("Always")
      .endSpec()
      .endTemplate()
      .endSpec()
      .build();

    client.replicationControllers().inNamespace(currentNamespace).create(rc1);
    client.replicationControllers().inNamespace(currentNamespace).create(rc2);

    ReplicationControllerList aRcList = client.replicationControllers().inNamespace(currentNamespace).list();
    assertThat(aRcList).isNotNull();
    assertEquals(2, aRcList.getItems().size());

    rc1 = client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").scale(5);
    assertEquals(5, rc1.getSpec().getReplicas().intValue());

    boolean bDeleted = client.replicationControllers().inNamespace(currentNamespace).withName("nginx-controller").delete();
    assertTrue(bDeleted);
  }
}
