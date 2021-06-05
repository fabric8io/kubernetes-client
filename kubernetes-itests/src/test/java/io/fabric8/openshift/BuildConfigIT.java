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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildSourceBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class BuildConfigIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(BuildConfigIT.class.getResourceAsStream("/buildconfig-it.yml"));
  }

  @Test
  public void load() {
    BuildConfig aBuildConfig = client.buildConfigs().inNamespace(session.getNamespace())
      .load(getClass().getResourceAsStream("/test-buildconfig.yml")).get();
    assertThat(aBuildConfig).isNotNull();
    assertEquals("ruby-sample-build", aBuildConfig.getMetadata().getName());
  }

  @Test
  public void get() {
    assertNotNull(client.buildConfigs().inNamespace(session.getNamespace()).withName("bc-get").get());
  }

  @Test
  public void list() {
    BuildConfigList bcList = client.buildConfigs().inNamespace(session.getNamespace()).list();
    assertThat(bcList).isNotNull();
    assertTrue(bcList.getItems().size() >= 1);
  }

  @Test
  public void update() {
    ReadyEntity<BuildConfig> buildConfigReady = new ReadyEntity<>(BuildConfig.class, client, "bc-update", session.getNamespace());
    BuildConfig buildConfig1 = client.buildConfigs().inNamespace(session.getNamespace()).withName("bc-update").edit(b -> new BuildConfigBuilder(b)
                                     .editSpec().withFailedBuildsHistoryLimit(5).endSpec().build());
    await().atMost(30, TimeUnit.SECONDS).until(buildConfigReady);
    assertEquals(5, buildConfig1.getSpec().getFailedBuildsHistoryLimit().intValue());
  }

  @Test
  public void delete() {
    ReadyEntity<BuildConfig> buildConfigReady = new ReadyEntity<>(BuildConfig.class, client, "bc-delete", session.getNamespace());
    await().atMost(30, TimeUnit.SECONDS).until(buildConfigReady);
    boolean bDeleted = client.buildConfigs().inNamespace(session.getNamespace()).withName("bc-delete").delete();
    assertTrue(bDeleted);
  }

  @Test
  public void createOrReplace() {
    // Given
    BuildConfig buildConfig = client.buildConfigs().inNamespace(session.getNamespace()).withName("bc-createorreplace").get();

    // When
    buildConfig.getSpec().setSource(new BuildSourceBuilder()
      .withNewGit()
      .withUri("https://github.com/openshift/test2")
      .endGit()
      .build());
    buildConfig = client.buildConfigs().inNamespace(session.getNamespace()).createOrReplace(buildConfig);

    // Then
    assertNotNull(buildConfig);
    assertEquals("bc-createorreplace", buildConfig.getMetadata().getName());
    assertEquals("https://github.com/openshift/test2", buildConfig.getSpec().getSource().getGit().getUri());
  }
}
