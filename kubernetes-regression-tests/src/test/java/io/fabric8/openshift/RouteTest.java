package io.fabric8.openshift;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.client.DefaultOpenShiftClient;
import io.fabric8.openshift.client.OpenShiftClient;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class RouteTest {
  public static OpenShiftClient client;

  public static String currentNamespace;

  @BeforeClass
  public static void init() {
    client = new DefaultOpenShiftClient();
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
    Route aRoute = client.routes().inNamespace(currentNamespace).load(getClass().getResourceAsStream("/test-route.yml")).get();
    assertThat(aRoute).isNotNull();
    assertEquals("host-route", aRoute.getMetadata().getName());
  }

  @Test
  public void testCrud() {
    Route route1 = new RouteBuilder()
      .withNewMetadata().withName("route1").endMetadata()
      .withNewSpec().withHost("www.example.com").withNewTo().withKind("Service").withName("service-name1").endTo().endSpec()
      .build();
    Route route2 = new RouteBuilder()
      .withNewMetadata().withName("route2").endMetadata()
      .withNewSpec().withNewTo().withKind("Service").withName("service-name2").endTo().endSpec()
      .build();

    client.routes().inNamespace(currentNamespace).create(route1);
    client.routes().inNamespace(currentNamespace).create(route2);

    RouteList aRouteList = client.routes().inNamespace(currentNamespace).list();
    assertThat(aRouteList).isNotNull();
    assertEquals(2, aRouteList.getItems().size());

    route1 = client.routes().inNamespace(currentNamespace).withName("route1").edit()
      .editSpec().withPath("/test").endSpec().done();
    assertThat(route1).isNotNull();
    assertEquals("/test", route1.getSpec().getPath());

    boolean bDeleted = client.routes().inNamespace(currentNamespace).withName("route1").delete();
    assertTrue(bDeleted);
  }
}
