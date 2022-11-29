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
import io.fabric8.openshift.api.model.*;
import io.fabric8.openshift.api.model.ImageBuilder;
import io.fabric8.openshift.api.model.ImageLayerBuilder;
import io.fabric8.openshift.api.model.ImageLookupPolicyBuilder;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.api.model.TagReferenceBuilder;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImageStreamTagTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void imageStreamTagTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-ist.json");

    // when
    final ImageStreamTag ist = mapper.readValue(originalJson, ImageStreamTag.class);
    final String serializedJson = mapper.writeValueAsString(ist);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  public void imageStreamTagBuilderTest() {

    ImageStreamTag ist = new ImageStreamTagBuilder()
        .withNewMetadata()
        .withName("bar1:1.0.12")
        .withNamespace("myproject")
        .withCreationTimestamp("2018-04-12T09:22:41Z")
        .withResourceVersion("1523")
        .withSelfLink("/oapi/v1/namespaces/myproject/imagestreamtags/bar1%3A1.0.12")
        .endMetadata()
        .withLookupPolicy(new ImageLookupPolicyBuilder()
            .withLocal(false)
            .build())
        .withGeneration(2L)
        .withImage(new ImageBuilder()
            .addToDockerImageLayers(0, new ImageLayerBuilder()
                .withMediaType("application/vnd.docker.image.rootfs.diff.tar.gzip")
                .withName("sha256:8111c19639475fb11ffa928f9e5e2dc05cbbe143363889355d2fee66a9f5664c")
                .withSize(1160L)
                .build())
            .withDockerImageReference(
                "docker.io/openshift/jenkins-slave-maven-centos7@sha256:df7bb31ff8f3ae0918b2e8b5c29b3deed04c547142abbc49ad133e9451ebb660")
            .withDockerImageMetadataVersion("1.0")
            .withNewMetadata()
            .withName("sha256:df7bb31ff8f3ae0918b2e8b5c29b3deed04c547142abbc49ad133e9451ebb660")
            .withCreationTimestamp("2018-04-12T09:22:41Z")
            .endMetadata()
            .build())
        .withTag(new TagReferenceBuilder()
            .withName("1.0.12")
            .withFrom(new io.fabric8.kubernetes.api.model.ObjectReferenceBuilder()
                .withKind("DockerImage")
                .withName("docker.io/openshift/jenkins-slave-maven-centos7:latest")
                .build())
            .withGeneration(2L)
            .addToAnnotations("role", "jenkins-slave")
            .addToAnnotations("slave-label", "jenkins-slave")
            .withReferencePolicy(new io.fabric8.openshift.api.model.TagReferencePolicyBuilder()
                .withType("Source")
                .build())
            .build())
        .build();

    assertNotNull(ist);
    assertEquals("bar1:1.0.12", ist.getMetadata().getName());
    assertEquals("myproject", ist.getMetadata().getNamespace());
    assertEquals("1523", ist.getMetadata().getResourceVersion());
    assertEquals("2018-04-12T09:22:41Z", ist.getMetadata().getCreationTimestamp());
    assertEquals("/oapi/v1/namespaces/myproject/imagestreamtags/bar1%3A1.0.12", ist.getMetadata()
        .getSelfLink());
    assertFalse(ist.getLookupPolicy().getLocal());
    assertEquals(2L, ist.getGeneration().intValue());
    assertEquals(1, ist.getImage().getDockerImageLayers().size());
    assertEquals("application/vnd.docker.image.rootfs.diff.tar.gzip", ist.getImage()
        .getDockerImageLayers().get(0).getMediaType());
    assertEquals("sha256:8111c19639475fb11ffa928f9e5e2dc05cbbe143363889355d2fee66a9f5664c",
        ist.getImage().getDockerImageLayers().get(0).getName());
    assertEquals(1160L, ist.getImage().getDockerImageLayers().get(0).getSize().intValue());
    assertEquals(
        "docker.io/openshift/jenkins-slave-maven-centos7@sha256:df7bb31ff8f3ae0918b2e8b5c29b3deed04c547142abbc49ad133e9451ebb660",
        ist.getImage().getDockerImageReference());
    assertEquals("1.0", ist.getImage().getDockerImageMetadataVersion());
    assertEquals("sha256:df7bb31ff8f3ae0918b2e8b5c29b3deed04c547142abbc49ad133e9451ebb660",
        ist.getImage().getMetadata().getName());
    assertEquals("2018-04-12T09:22:41Z", ist.getImage().getMetadata().getCreationTimestamp());
    assertEquals("1.0.12", ist.getTag().getName());
    assertEquals("DockerImage", ist.getTag().getFrom().getKind());
    assertEquals("docker.io/openshift/jenkins-slave-maven-centos7:latest", ist.getTag().getFrom().getName());
    assertEquals(2L, ist.getTag().getGeneration().intValue());
    assertEquals("jenkins-slave", ist.getTag().getAnnotations().get("role"));
    assertEquals("jenkins-slave", ist.getTag().getAnnotations().get("slave-label"));
    assertEquals("Source", ist.getTag().getReferencePolicy().getType());

  }

}
