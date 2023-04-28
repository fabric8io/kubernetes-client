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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildSourceBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(BuildConfig.class)
@LoadKubernetesManifests("/buildconfig-it.yml")
class BuildConfigIT {

  OpenShiftClient client;

  @Test
  void load() {
    BuildConfig aBuildConfig = client.buildConfigs()
        .load(getClass().getResourceAsStream("/test-buildconfig.yml")).item();
    assertThat(aBuildConfig).isNotNull();
    assertEquals("ruby-sample-build", aBuildConfig.getMetadata().getName());
  }

  @Test
  void get() {
    assertNotNull(client.buildConfigs().withName("bc-get").get());
  }

  @Test
  void list() {
    BuildConfigList bcList = client.buildConfigs().list();
    assertThat(bcList).isNotNull();
    assertTrue(bcList.getItems().size() >= 1);
  }

  @Test
  void update() {
    BuildConfig buildConfig1 = client.buildConfigs().withName("bc-update").edit(b -> new BuildConfigBuilder(b)
        .editMetadata().withResourceVersion(null).endMetadata()
        .editSpec().withFailedBuildsHistoryLimit(5).endSpec().build());
    assertEquals(5, buildConfig1.getSpec().getFailedBuildsHistoryLimit().intValue());
  }

  @Test
  void delete() {
    client.buildConfigs().withName("bc-delete").waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    boolean bDeleted = client.buildConfigs().withName("bc-delete").delete().size() == 1;
    assertTrue(bDeleted);
  }

  @Test
  void createOrReplace() {
    // Given
    BuildConfig buildConfig = client.buildConfigs().withName("bc-createorreplace").get();

    // When
    buildConfig.getSpec().setSource(new BuildSourceBuilder()
        .withNewGit()
        .withUri("https://github.com/openshift/test2")
        .endGit()
        .build());
    buildConfig = client.buildConfigs().createOrReplace(buildConfig);

    // Then
    assertNotNull(buildConfig);
    assertEquals("bc-createorreplace", buildConfig.getMetadata().getName());
    assertEquals("https://github.com/openshift/test2", buildConfig.getSpec().getSource().getGit().getUri());
  }
}
