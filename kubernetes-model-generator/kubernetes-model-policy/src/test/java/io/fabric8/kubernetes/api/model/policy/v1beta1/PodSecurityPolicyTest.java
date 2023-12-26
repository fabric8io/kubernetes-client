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
package io.fabric8.kubernetes.api.model.policy.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PodSecurityPolicyTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void isClusterScoped() {
    assertThat(PodSecurityPolicy.class).isNotInstanceOf(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws IOException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/valid-v1beta1-podsecuritypolicy.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final PodSecurityPolicy podSecurityPolicy = mapper.readValue(originalJson, PodSecurityPolicy.class);
    final String serializedJson = mapper.writeValueAsString(podSecurityPolicy);

    // Then
    assertThat(serializedJson).isNotNull();
    AssertionsForClassTypes.assertThat(podSecurityPolicy)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-podsecuritypolicy")
        .hasFieldOrPropertyWithValue("spec.privileged", false)
        .hasFieldOrPropertyWithValue("spec.hostNetwork", false)
        .hasFieldOrPropertyWithValue("spec.allowPrivilegeEscalation", false)
        .hasFieldOrPropertyWithValue("spec.defaultAllowPrivilegeEscalation", false)
        .hasFieldOrPropertyWithValue("spec.hostPID", false)
        .hasFieldOrPropertyWithValue("spec.hostIPC", false)
        .hasFieldOrPropertyWithValue("spec.runAsUser.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.fsGroup.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.seLinux.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.supplementalGroups.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.volumes",
            Arrays.asList("configMap", "downwardAPI", "emptyDir", "persistentVolumeClaim", "secret", "projected"))
        .hasFieldOrPropertyWithValue("spec.allowedCapabilities", Collections.singletonList("*"));
  }

  @Test
  void builderShouldCreateObject() {
    // Given
    PodSecurityPolicyBuilder podSecurityPolicyBuilder = new PodSecurityPolicyBuilder()
        .withNewMetadata()
        .withName("test-podsecuritypolicy")
        .endMetadata()
        .withNewSpec()
        .withPrivileged(false)
        .withHostNetwork(false)
        .withAllowPrivilegeEscalation(false)
        .withDefaultAllowPrivilegeEscalation(false)
        .withHostPID(false)
        .withHostIPC(false)
        .withNewRunAsUser().withRule("RunAsAny").endRunAsUser()
        .withNewFsGroup().withRule("RunAsAny").endFsGroup()
        .withNewSeLinux().withRule("RunAsAny").endSeLinux()
        .withNewSupplementalGroups().withRule("RunAsAny").endSupplementalGroups()
        .addToVolumes("configMap", "downwardAPI", "emptyDir", "persistentVolumeClaim", "secret", "projected")
        .addAllToAllowedCapabilities(Collections.singletonList("*"))
        .endSpec();
    // When
    PodSecurityPolicy serviceCIDR = podSecurityPolicyBuilder.build();

    // Then
    assertThat(serviceCIDR)
        .isNotNull()
        .hasFieldOrPropertyWithValue("metadata.name", "test-podsecuritypolicy")
        .hasFieldOrPropertyWithValue("spec.privileged", false)
        .hasFieldOrPropertyWithValue("spec.hostNetwork", false)
        .hasFieldOrPropertyWithValue("spec.allowPrivilegeEscalation", false)
        .hasFieldOrPropertyWithValue("spec.defaultAllowPrivilegeEscalation", false)
        .hasFieldOrPropertyWithValue("spec.hostPID", false)
        .hasFieldOrPropertyWithValue("spec.hostIPC", false)
        .hasFieldOrPropertyWithValue("spec.runAsUser.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.fsGroup.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.seLinux.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.supplementalGroups.rule", "RunAsAny")
        .hasFieldOrPropertyWithValue("spec.volumes",
            Arrays.asList("configMap", "downwardAPI", "emptyDir", "persistentVolumeClaim", "secret", "projected"))
        .hasFieldOrPropertyWithValue("spec.allowedCapabilities", Collections.singletonList("*"));
  }

}
