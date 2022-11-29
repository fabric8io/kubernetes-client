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
import io.fabric8.kubernetes.model.util.Helper;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ServiceTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void serviceTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-service.json");

    // when
    final Service service = mapper.readValue(originalJson, Service.class);
    final String serializedJson = mapper.writeValueAsString(service);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  public void serviceBuilderTest() {

    Service service = new io.fabric8.kubernetes.api.model.ServiceBuilder()
        .withNewMetadata()
        .withName("fabric8-maven-sample-zero-config")
        .addToLabels("expose", "true")
        .addToLabels("app", "fabric8-maven-sample-zero-config")
        .addToLabels("provider", "fabric8")
        .addToLabels("version", "3.5-SNAPSHOT")
        .addToLabels("group", "io.fabric8")
        .addToAnnotations("prometheus.io/port", "9779")
        .addToAnnotations("fabric8.io/scm-url",
            "https://github.com/spring-projects/spring-boot/spring-boot-starter-parent/fabric8-maven-sample-zero-config")
        .addToAnnotations("fabric8.io/iconUrl", "img/icons/spring-boot.svg")
        .addToAnnotations("prometheus.io/scrape", "true")
        .addToAnnotations("fabric8.io/scm-tag", "HEAD")
        .endMetadata()
        .withNewSpec()
        .addToPorts(0, new io.fabric8.kubernetes.api.model.ServicePortBuilder()
            .withName("http")
            .withPort(8080)
            .withProtocol("TCP")
            .withNodePort(30080)
            .withNewTargetPort(8080)
            .build())
        .addToPorts(1, new io.fabric8.kubernetes.api.model.ServicePortBuilder()
            .withName("https")
            .withPort(443)
            .withProtocol("TCP")
            .withNodePort(30043)
            .withNewTargetPort(9000)
            .build())
        .addToSelector("app", "fabric8-maven-sample-zero-config")
        .addToSelector("provider", "fabric8")
        .addToSelector("group", "io.fabric8")
        .withClusterIP("10.0.171.239")
        .withLoadBalancerIP("78.11.24.19")
        .withHealthCheckNodePort(50000)
        .withType("LoadBalancer")
        .addToExternalIPs(0, "80.11.12.10")
        .addToExternalIPs(1, "80.12.13.11")
        .withExternalName("my.database.example.com")
        .withExternalTrafficPolicy("Local")
        .addToLoadBalancerSourceRanges(0, "130.211.204.1/32")
        .addToLoadBalancerSourceRanges(1, "130.211.204.2/32")
        .withSessionAffinity("ClientIP")
        .endSpec()
        .build();

    assertNotNull(service);
    assertEquals("fabric8-maven-sample-zero-config", service.getMetadata().getName());
    assertEquals("true", service.getMetadata().getLabels().get("expose"));

    assertEquals("fabric8-maven-sample-zero-config", service.getMetadata().getLabels().get("app"));
    assertEquals("fabric8", service.getMetadata().getLabels().get("provider"));
    assertEquals("3.5-SNAPSHOT", service.getMetadata().getLabels().get("version"));
    assertEquals("io.fabric8", service.getMetadata().getLabels().get("group"));
    assertEquals("9779", service.getMetadata().getAnnotations().get("prometheus.io/port"));
    assertEquals("https://github.com/spring-projects/spring-boot/spring-boot-starter-parent/" +
        "fabric8-maven-sample-zero-config", service.getMetadata().getAnnotations().get("fabric8.io/scm-url"));
    assertEquals("img/icons/spring-boot.svg", service.getMetadata().getAnnotations().get("fabric8.io/iconUrl"));
    assertEquals("true", service.getMetadata().getAnnotations().get("prometheus.io/scrape"));
    assertEquals("HEAD", service.getMetadata().getAnnotations().get("fabric8.io/scm-tag"));
    assertNotNull(service.getSpec().getPorts());
    assertEquals(2, service.getSpec().getPorts().size());
    assertEquals("http", service.getSpec().getPorts().get(0).getName());
    assertEquals("TCP", service.getSpec().getPorts().get(0).getProtocol());
    assertEquals(8080, service.getSpec().getPorts().get(0).getPort().intValue());
    assertEquals(30080, service.getSpec().getPorts().get(0).getNodePort().intValue());
    assertEquals(8080, service.getSpec().getPorts().get(0).getTargetPort().getIntVal().intValue());
    assertEquals("https", service.getSpec().getPorts().get(1).getName());
    assertEquals("TCP", service.getSpec().getPorts().get(1).getProtocol());
    assertEquals(443, service.getSpec().getPorts().get(1).getPort().intValue());
    assertEquals(30043, service.getSpec().getPorts().get(1).getNodePort().intValue());
    assertEquals(9000, service.getSpec().getPorts().get(1).getTargetPort().getIntVal().intValue());
    assertEquals(3, service.getSpec().getSelector().size());
    assertEquals("fabric8-maven-sample-zero-config", service.getSpec().getSelector().get("app"));
    assertEquals("fabric8", service.getSpec().getSelector().get("provider"));
    assertEquals("io.fabric8", service.getSpec().getSelector().get("group"));
    assertEquals("10.0.171.239", service.getSpec().getClusterIP());
    assertEquals("78.11.24.19", service.getSpec().getLoadBalancerIP());
    assertEquals(50000, service.getSpec().getHealthCheckNodePort().intValue());
    assertEquals("LoadBalancer", service.getSpec().getType());
    assertEquals(2, service.getSpec().getExternalIPs().size());
    assertEquals("80.11.12.10", service.getSpec().getExternalIPs().get(0));
    assertEquals("80.12.13.11", service.getSpec().getExternalIPs().get(1));
    assertEquals("my.database.example.com", service.getSpec().getExternalName());
    assertEquals("Local", service.getSpec().getExternalTrafficPolicy());
    assertEquals(2, service.getSpec().getLoadBalancerSourceRanges().size());
    assertEquals("130.211.204.1/32", service.getSpec().getLoadBalancerSourceRanges().get(0));
    assertEquals("130.211.204.2/32", service.getSpec().getLoadBalancerSourceRanges().get(1));
    assertEquals("ClientIP", service.getSpec().getSessionAffinity());
  }
}
