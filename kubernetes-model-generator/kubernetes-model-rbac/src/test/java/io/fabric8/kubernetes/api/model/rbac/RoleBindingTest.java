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
package io.fabric8.kubernetes.api.model.rbac;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.model.util.Helper;
import io.fabric8.zjsonpatch.JsonDiff;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleBindingTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void kubernetesRoleBindingTest() throws Exception {
    // Given
    final String originalJson = Helper.loadJson("/valid-roleBinding.json");
    final RoleBinding kubernetesRoleBinding = mapper.readValue(originalJson, RoleBinding.class);
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson),
        mapper.readTree(mapper.writeValueAsString(kubernetesRoleBinding)));
    // Then
    assertThat(diff).isEmpty();
  }

  @Test
  public void kubernetesRoleBuilderTest() throws Exception {
    // Given
    final String originalJson = Helper.loadJson("/valid-roleBinding.json");
    final RoleBinding kubernetesRoleBinding = new RoleBindingBuilder()
        .withNewMetadata()
        .withName("read-jobs")
        .withNamespace("default")
        .endMetadata()
        .addToSubjects(0, new SubjectBuilder()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("User")
            .withName("jane")
            .withNamespace("default")
            .build())
        .withRoleRef(new RoleRefBuilder()
            .withApiGroup("rbac.authorization.k8s.io")
            .withKind("Role")
            .withName("job-reader")
            .build())
        .build();
    // When
    final var diff = JsonDiff.asJson(mapper.readTree(originalJson),
        mapper.readTree(mapper.writeValueAsString(kubernetesRoleBinding)));
    // Then
    assertThat(diff).isEmpty();

  }
}
