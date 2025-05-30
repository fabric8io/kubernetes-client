/*
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
package io.fabric8.openshift.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Helper;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.zjsonpatch.JsonDiff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class DeploymentConfigRollbackTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void deploymentConfigRollbackTest() throws Exception {
    // Given
    final String originalJson = Helper.loadJson("/valid-deploymentConfigRollback.json");
    final DeploymentConfigRollback deploymentConfigRollback = mapper.readValue(originalJson,
        DeploymentConfigRollback.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson),
        mapper.readTree(mapper.writeValueAsString(deploymentConfigRollback)));
    // Then
    assertThat(diff).isEmpty();
  }

  @Test
  void deploymentConfigRollbackBuilderTest() throws Exception {
    //given
    final DeploymentConfigRollback expected = mapper.readValue(
        Helper.loadJson("/valid-deploymentConfigRollback.json"),
        DeploymentConfigRollback.class);

    //when
    DeploymentConfigRollback actual = new DeploymentConfigRollbackBuilder()
        .withName("app-to-rollback")
        .withNewSpec()
        .withFrom(
            new ObjectReferenceBuilder()
                .withApiVersion("version-1")
                .withFieldPath("fieldPath")
                .withKind("ObjectReference")
                .withName("ObjectReferenceName")
                .withNamespace("ObjectReferenceNamespace")
                .withResourceVersion("version 1")
                .withUid("1234")
                .build())
        .withIncludeReplicationMeta(Boolean.FALSE)
        .withIncludeStrategy(Boolean.FALSE)
        .withIncludeTemplate(Boolean.FALSE)
        .withIncludeTriggers(Boolean.FALSE)
        .withRevision(1L)
        .endSpec()
        .withUpdatedAnnotations(
            Collections.singletonMap("APPLICATION_VERSION", "2.7.18"))
        .withAdditionalProperties(
            Collections.singletonMap("additionalProperty", "additionalValue"))
        .build();

    //then
    Assertions.assertEquals(expected, actual);
  }
}
