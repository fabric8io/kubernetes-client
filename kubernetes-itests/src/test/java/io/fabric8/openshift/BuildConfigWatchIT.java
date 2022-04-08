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

import io.fabric8.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.BuildRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getName;
import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getOrCreateAnnotations;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(BuildConfig.class)
class BuildConfigWatchIT {

  static OpenShiftClient client;

  Namespace namespace;

  @BeforeEach
  public void initOcNewApp() {
    client.load(getClass().getResourceAsStream("/ruby-new-app.yml")).inNamespace(namespace.getMetadata().getName()).createOrReplace();
    await().atMost(10, TimeUnit.SECONDS).until(() -> client.imageStreamTags().inNamespace(namespace.getMetadata().getName()).withName("ruby-25-centos7:latest").get() != null);
  }

  @AfterEach
  public void cleanOcNewApp() {
    client.load(getClass().getResourceAsStream("/ruby-new-app.yml")).inNamespace(namespace.getMetadata().getName()).delete();
  }

  @Test
  void instantiateAndWatchBuild() throws InterruptedException {
    // Given
    BuildRequest buildRequest = new BuildRequestBuilder().withNewMetadata().withName("ruby-hello-world").endMetadata().build();
    CountDownLatch buildEventReceivedLatch = new CountDownLatch(1);

    // When
    Build startedBuild = client.buildConfigs().inNamespace(namespace.getMetadata().getName()).withName("ruby-hello-world").instantiate(buildRequest);
    TestBuildWatcher testBuildWatcher = new TestBuildWatcher(buildEventReceivedLatch, getName(startedBuild));
    Watch watcher = client.builds().inNamespace(namespace.getMetadata().getName()).withName(getName(startedBuild)).watch(testBuildWatcher);

    // Then
    assertNotNull(startedBuild);
    assertEquals("ruby-hello-world", getOrCreateAnnotations(startedBuild).get("openshift.io/build-config.name"));
    assertTrue(buildEventReceivedLatch.await(5, TimeUnit.SECONDS));
    watcher.close();
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
