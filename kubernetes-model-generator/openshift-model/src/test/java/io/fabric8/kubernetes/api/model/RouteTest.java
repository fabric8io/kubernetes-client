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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteTargetReferenceBuilder;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void routeTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-route.json");

    // when
    final Route route = mapper.readValue(originalJson, Route.class);
    final String serializedJson = mapper.writeValueAsString(route);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  public void routeBuilderTest() {

    Route route = new RouteBuilder()
        .withNewMetadata()
        .withName("fabric8-maven-sample-zero-config")
        .addToLabels("expose", "true")
        .addToLabels("app", "fabric8-maven-sample-zero-config")
        .addToLabels("provider", "fabric8")
        .addToLabels("version", "3.5-SNAPSHOT")
        .addToLabels("group", "io.fabric8")
        .endMetadata()
        .withNewSpec()
        .withHost("www.example.com")
        .withPath("/test")
        .withNewPort().withNewTargetPort().withValue(8080).endTargetPort().endPort()
        .withNewTo().withKind("Service")
        .withName("fabric8-maven-sample-zero-config")
        .withWeight(5)
        .endTo()
        .addToAlternateBackends(
            new RouteTargetReferenceBuilder().withName("test1").withKind("Service").withWeight(0).build())
        .addToAlternateBackends(
            new RouteTargetReferenceBuilder().withName("test2").withKind("Service").withWeight(0).build())
        .addToAlternateBackends(
            new RouteTargetReferenceBuilder().withName("test3").withKind("Service").withWeight(0).build())
        .withNewTls()
        .withTermination("edge")
        .withKey("$(perl -pe 's/\n/\\n/' example-test.key)")
        .withCertificate("$(perl -pe 's/\n/\\n/' example-test.cert)")
        .withCaCertificate("$(perl -pe 's/\n/\\n/' example-test.cert)")
        .withDestinationCACertificate("$(perl -pe 's/\n/\\n/' example-test.cert)")
        .withInsecureEdgeTerminationPolicy("Allow")
        .endTls()
        .withWildcardPolicy("Subdomain")
        .endSpec()
        .build();

    assertNotNull(route);
    assertEquals("fabric8-maven-sample-zero-config", route.getMetadata().getName());
    assertTrue(route.getMetadata().getLabels().get("expose").equals("true"));
    assertTrue(route.getMetadata().getLabels().get("app").equals("fabric8-maven-sample-zero-config"));
    assertTrue(route.getMetadata().getLabels().get("provider").equals("fabric8"));
    assertTrue(route.getMetadata().getLabels().get("version").equals("3.5-SNAPSHOT"));
    assertTrue(route.getMetadata().getLabels().get("group").equals("io.fabric8"));
    assertEquals("www.example.com", route.getSpec().getHost());
    assertEquals("/test", route.getSpec().getPath());
    assertNotNull(route.getSpec().getPort());
    assertEquals(8080, route.getSpec().getPort().getTargetPort().getIntVal().intValue());
    assertNotNull(route.getSpec().getTo());
    assertEquals("Service", route.getSpec().getTo().getKind());
    assertEquals("fabric8-maven-sample-zero-config", route.getSpec().getTo().getName());
    assertEquals("5", route.getSpec().getTo().getWeight().toString());
    assertNotNull(route.getSpec().getAlternateBackends());
    assertEquals(3, route.getSpec().getAlternateBackends().size());
    assertEquals(0, route.getSpec().getAlternateBackends().get(0).getWeight().intValue());
    assertEquals("Service", route.getSpec().getAlternateBackends().get(0).getKind());
    assertEquals(0, route.getSpec().getAlternateBackends().get(1).getWeight().intValue());
    assertEquals("Service", route.getSpec().getAlternateBackends().get(1).getKind());
    assertEquals(0, route.getSpec().getAlternateBackends().get(2).getWeight().intValue());
    assertEquals("Service", route.getSpec().getAlternateBackends().get(2).getKind());
    assertTrue(route.getSpec().getAlternateBackends().get(0).getName().startsWith("test"));
    assertTrue(route.getSpec().getAlternateBackends().get(1).getName().startsWith("test"));
    assertTrue(route.getSpec().getAlternateBackends().get(2).getName().startsWith("test"));
    assertNotNull(route.getSpec().getTls());
    assertEquals("edge", route.getSpec().getTls().getTermination());
    assertEquals("$(perl -pe 's/\n/\\n/' example-test.key)", route.getSpec().getTls().getKey());
    assertEquals("$(perl -pe 's/\n/\\n/' example-test.cert)", route.getSpec().getTls().getCertificate());
    assertEquals("$(perl -pe 's/\n/\\n/' example-test.cert)", route.getSpec().getTls().getCaCertificate());
    assertEquals("$(perl -pe 's/\n/\\n/' example-test.cert)", route.getSpec().getTls().getDestinationCACertificate());
    assertEquals("Allow", route.getSpec().getTls().getInsecureEdgeTerminationPolicy());
    assertEquals("Subdomain", route.getSpec().getWildcardPolicy());
  }
}
