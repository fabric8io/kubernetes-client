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
import io.fabric8.openshift.api.model.ImageImportSpecBuilder;
import io.fabric8.openshift.api.model.ImageStreamImport;
import io.fabric8.openshift.api.model.ImageStreamImportBuilder;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class ImageStreamImportTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void imageStreamImportTest() throws Exception {
    // given
    final String originalJson = Helper.loadJson("/valid-imagestreamimport.json");

    // when
    final ImageStreamImport imageStreamImport = mapper.readValue(originalJson, ImageStreamImport.class);
    final String serializedJson = mapper.writeValueAsString(imageStreamImport);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);
  }

  @Test
  public void imageStreamImportBuilderTest() throws Exception {

    // given
    final String originalJson = Helper.loadJson("/valid-imagestreamimport.json");

    // when
    ImageStreamImport imageStreamImport = new ImageStreamImportBuilder()
        .withNewMetadata()
        .withName("test-isi")
        .withNamespace("myproject")
        .withLabels(Collections.singletonMap("key", "value"))
        .endMetadata()
        .withNewSpec()
        .addToImages(0, new ImageImportSpecBuilder()
            .withNewFrom()
            .withKind("DockerImage")
            .withName("dockerImageName")
            .endFrom()
            .withNewTo()
            .withName("default")
            .endTo()
            .withIncludeManifest(true)
            .withNewReferencePolicy()
            .withType("Source")
            .endReferencePolicy()
            .withNewImportPolicy()
            .withInsecure(true)
            .withScheduled(true)
            .endImportPolicy()
            .build())
        .withImport(true)
        .withNewRepository()
        .withNewFrom()
        .withKind("DockerImage")
        .withName("docker.io/openshift/jenkins-slave-maven-centos7:latest")
        .endFrom()
        .withIncludeManifest(true)
        .withNewReferencePolicy()
        .withType("Source")
        .endReferencePolicy()
        .withNewImportPolicy()
        .withInsecure(true)
        .withScheduled(true)
        .endImportPolicy()
        .endRepository()
        .endSpec()
        .build();

    final String serializedJson = mapper.writeValueAsString(imageStreamImport);

    // then
    assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
        .isEqualTo(originalJson);

  }
}
