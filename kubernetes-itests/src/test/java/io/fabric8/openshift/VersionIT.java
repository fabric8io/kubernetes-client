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
package io.fabric8.openshift;

import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.client.VersionInfo;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RequireK8sSupport(Project.class)
class VersionIT {

  OpenShiftClient client;

  @Test
  void getVersionShouldReturnValidVersion() {
    // Given + When
    VersionInfo versionInfo = client.getVersion();

    // Then
    assertThat(versionInfo).isNotNull();
    assertThat(versionInfo.getMajor()).isNotNull();
    assertThat(versionInfo.getMinor()).isNotNull();
    assertThat(versionInfo.getBuildDate()).isNotNull();
  }
}
