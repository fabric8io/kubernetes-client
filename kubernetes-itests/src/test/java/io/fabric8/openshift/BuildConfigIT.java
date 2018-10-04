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

import io.fabric8.commons.DeleteEntity;
import io.fabric8.commons.ReadyEntity;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class BuildConfigIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  private BuildConfig buildConfig1, buildConfig2;

  private String currentNamespace;

  @Before
  public void init() {
    currentNamespace = session.getNamespace();
    buildConfig1 = new BuildConfigBuilder()
      .withNewMetadata().withName("bc1").endMetadata()
      .withNewSpec()
      .addNewTrigger()
      .withType("GitHub")
      .withNewGithub()
      .withSecret("secret101")
      .endGithub()
      .endTrigger()
      .addNewTrigger()
      .withType("Generic")
      .withNewGeneric()
      .withSecret("secret101")
      .endGeneric()
      .endTrigger()
      .addNewTrigger()
      .withType("ImageChange")
      .endTrigger()
      .withNewSource()
      .withType("Git")
      .withNewGit()
      .withUri("https://github.com/openshift/ruby-hello-world")
      .endGit()
      .withDockerfile("FROM openshift/ruby-22-centos7\\nUSER example")
      .endSource()
      .withNewStrategy()
      .withType("Source")
      .withNewSourceStrategy()
      .withNewFrom()
      .withKind("ImageStreamTag")
      .withName("origin-ruby-sample:latest")
      .endFrom()
      .endSourceStrategy()
      .endStrategy()
      .withNewOutput()
      .withNewTo()
      .withKind("ImageStreamTag")
      .withName("origin-ruby-sample:latest")
      .endTo()
      .endOutput()
      .withNewPostCommit()
      .withScript("bundle exec rake test")
      .endPostCommit()
      .endSpec()
      .build();

    client.buildConfigs().inNamespace(currentNamespace).createOrReplace(buildConfig1);
  }

  @Test
  public void load() {
    BuildConfig aBuildConfig = client.buildConfigs().inNamespace(currentNamespace)
      .load(getClass().getResourceAsStream("/test-buildconfig.yml")).get();
    assertThat(aBuildConfig).isNotNull();
    assertEquals("ruby-sample-build", aBuildConfig.getMetadata().getName());
  }

  @Test
  public void get() {
    assertNotNull(client.buildConfigs().inNamespace(currentNamespace).withName("bc1").get());
  }

  @Test
  public void list() {
    BuildConfigList bcList = client.buildConfigs().inNamespace(currentNamespace).list();
    assertThat(bcList).isNotNull();
    assertEquals(1, bcList.getItems().size());
  }

  @Test
  public void update() {
    ReadyEntity<BuildConfig> buildConfigReady = new ReadyEntity<>(BuildConfig.class, client, "bc1", currentNamespace);
    buildConfig1 = client.buildConfigs().inNamespace(currentNamespace).withName("bc1").edit()
      .editSpec().withFailedBuildsHistoryLimit(5).endSpec().done();
    await().atMost(30, TimeUnit.SECONDS).until(buildConfigReady);
    assertEquals(5, buildConfig1.getSpec().getFailedBuildsHistoryLimit().intValue());
  }

  @Test
  public void delete() {
    ReadyEntity<BuildConfig> buildConfigReady = new ReadyEntity<>(BuildConfig.class, client, "bc1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(buildConfigReady);
    boolean bDeleted = client.buildConfigs().inNamespace(currentNamespace).withName("bc1").delete();
    assertTrue(bDeleted);
  }

  @After
  public void cleanup() throws InterruptedException {
    if (client.buildConfigs().list().getItems().size() != 0) {
      client.buildConfigs().inNamespace(currentNamespace).delete();
    }

    DeleteEntity<BuildConfig> buildConfigDelete = new DeleteEntity<>(BuildConfig.class, client, "bc1", currentNamespace);
    await().atMost(30, TimeUnit.SECONDS).until(buildConfigDelete);
  }
}
