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
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.openshift.api.model.Build;
import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.BuildRequestBuilder;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getName;
import static io.fabric8.kubernetes.client.utils.KubernetesResourceUtil.getOrCreateAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequireK8sSupport(BuildConfig.class)
@LoadKubernetesManifests("/build-config-watch.yml")
class BuildConfigWatchIT {

  OpenShiftClient client;

  @Test
  void instantiateAndWatchBuild() throws Exception {
    // Given
    client.imageStreams().withName("fabric8-build-config-watch")
        .waitUntilCondition(is -> is != null && is.getStatus() != null &&
            is.getStatus().getTags().stream().anyMatch(nt -> nt.getTag().equals("1.33.7")),
            30, TimeUnit.SECONDS);
    client.buildConfigs().withName("fabric8-build-config-watch")
        .waitUntilCondition(Objects::nonNull, 30, TimeUnit.SECONDS);
    BuildRequest buildRequest = new BuildRequestBuilder().withNewMetadata()
        .withName("fabric8-build-config-watch").endMetadata().build();
    CountDownLatch buildEventReceivedLatch = new CountDownLatch(1);

    // When
    Build startedBuild = client.buildConfigs().withName("fabric8-build-config-watch").instantiate(buildRequest);
    TestBuildWatcher testBuildWatcher = new TestBuildWatcher(buildEventReceivedLatch, getName(startedBuild));
    Watch watcher = client.builds().withName(getName(startedBuild)).watch(testBuildWatcher);

    // Then
    assertNotNull(startedBuild);
    assertEquals("fabric8-build-config-watch", getOrCreateAnnotations(startedBuild).get("openshift.io/build-config.name"));
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
    public void onClose(WatcherException cause) {
    }
  }
}
