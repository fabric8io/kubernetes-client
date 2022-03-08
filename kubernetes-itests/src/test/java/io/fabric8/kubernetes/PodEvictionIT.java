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
package io.fabric8.kubernetes;

import io.fabric8.commons.AssumingK8sVersionAtLeast;
import io.fabric8.commons.ClusterEntity;
import io.fabric8.kubernetes.api.model.policy.v1.Eviction;
import io.fabric8.kubernetes.api.model.policy.v1.EvictionBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Evictable;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class PodEvictionIT {

  @ArquillianResource
  public KubernetesClient client;

  @ArquillianResource
  public Session session;


  @ClassRule
  public static final AssumingK8sVersionAtLeast assumingK8sVersion = new AssumingK8sVersionAtLeast("1", "22");

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(PodIT.class.getResourceAsStream("/podeviction-it.yml"));
  }

  @Test
  public void evictWithV1PolicyEviction() {
    // Given
    String podName = "podeviction-it-with-v1-policy-eviction";
    Eviction eviction = new EvictionBuilder()
      .withNewMetadata()
      .withNamespace(session.getNamespace())
      .withName(podName)
      .endMetadata()
      .build();

    // When
    boolean evicted = client.pods().inNamespace(session.getNamespace()).withName(podName).evict(eviction);

    // Then
    assertTrue(evicted);
  }

  @Test
  public void evictWithV1PolicyEvictionNonExistentPod() {
    // Given
    String podName = "podit-evict-non-existent-pod";
    Eviction eviction = new EvictionBuilder()
      .withNewMetadata()
      .withNamespace(session.getNamespace())
      .withName(podName)
      .endMetadata()
      .build();
    final Evictable podOps = client.pods().inNamespace(session.getNamespace()).withName(podName);

    // When + Then
    assertThrows(KubernetesClientException.class, () -> podOps.evict(eviction));
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(NetworkPolicyIT.class.getResourceAsStream("/podeviction-it.yml"));
  }
}
