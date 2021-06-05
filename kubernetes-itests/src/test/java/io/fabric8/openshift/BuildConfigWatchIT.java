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

import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.BuildRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.openshift.impl.requirement.RequiresOpenshift;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getName;
import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getOrCreateAnnotations;
import static junit.framework.TestCase.assertNotNull;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresOpenshift
public class BuildConfigWatchIT {
  @ArquillianResource
  OpenShiftClient client;

  @ArquillianResource
  Session session;

  @Before
  public void initOcNewApp() {
    client.load(getClass().getResourceAsStream("/ruby-new-app.yml")).inNamespace(session.getNamespace()).createOrReplace();
    await().atMost(10, TimeUnit.SECONDS).until(() -> client.imageStreamTags().inNamespace(session.getNamespace()).withName("ruby-25-centos7:latest").get() != null);
  }

  @Test
  public void instantiateAndWatchBuild() throws InterruptedException {
    // Given
    BuildRequest buildRequest = new BuildRequestBuilder().withNewMetadata().withName("ruby-hello-world").endMetadata().build();
    CountDownLatch buildEventReceivedLatch = new CountDownLatch(1);

    // When
    Build startedBuild = client.buildConfigs().inNamespace(session.getNamespace()).withName("ruby-hello-world").instantiate(buildRequest);
    TestBuildWatcher testBuildWatcher = new TestBuildWatcher(buildEventReceivedLatch, getName(startedBuild));
    Watch watcher = client.builds().inNamespace(session.getNamespace()).withName(getName(startedBuild)).watch(testBuildWatcher);

    // Then
    assertNotNull(startedBuild);
    assertEquals("ruby-hello-world", getOrCreateAnnotations(startedBuild).get("openshift.io/build-config.name"));
    assertTrue(buildEventReceivedLatch.await(5, TimeUnit.SECONDS));
    watcher.close();
  }

  @After
  public void cleanOcNewApp() {
    client.load(getClass().getResourceAsStream("/ruby-new-app.yml")).inNamespace(session.getNamespace()).delete();
  }

  private static class TestBuildWatcher implements Watcher<Build> {
    private final String resourceName;
    private final CountDownLatch eventRecievedForResourceLatch;

    private TestBuildWatcher(CountDownLatch countDownLatch, String resourceName) {
      this.resourceName = resourceName;
      this.eventRecievedForResourceLatch = countDownLatch;
    }

    @Override
    public void eventReceived(Action action, Build resource) {
      if (getName(resource).equals(resourceName)) {
        eventRecievedForResourceLatch.countDown();
      }
    }

    @Override
    public void onClose(WatcherException cause) { }
  }
}
