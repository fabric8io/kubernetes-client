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

import io.fabric8.junit.jupiter.api.LoadKubernetesManifests;
import io.fabric8.junit.jupiter.api.RequireK8sSupport;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudget;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodDisruptionBudgetSpecBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.readiness.Readiness;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/pod-evict-it.yml")
@RequireK8sSupport(PodDisruptionBudget.class)
class PodEvictIT {
  private static final int POD_READY_WAIT_IN_SECONDS = 60;

  KubernetesClient client;

  @Test
  void evict() {
    Pod pod1 = client.pods().withName("pod-standard").get();
    String pdbScope = pod1.getMetadata().getLabels().get("pdb-scope");
    assertNotNull("pdb-scope label is null. is pod1 misconfigured?", pdbScope);

    PodDisruptionBudget pdb = new PodDisruptionBudgetBuilder()
        .withNewMetadata()
        .withName("test-pdb")
        .endMetadata()
        .withSpec(
            new PodDisruptionBudgetSpecBuilder()
                .withMinAvailable(new IntOrString(1))
                .withNewSelector()
                .addToMatchLabels("pdb-scope", pdbScope)
                .endSelector()
                .build())
        .build();

    Pod pod2 = new PodBuilder()
        .withNewMetadata()
        .withName("pod2")
        .addToLabels("pdb-scope", pdbScope)
        .endMetadata()
        .withSpec(pod1.getSpec())
        .build();

    Pod pod3 = new PodBuilder()
        .withNewMetadata()
        .withName("pod3")
        .addToLabels("pdb-scope", pdbScope)
        .endMetadata()
        .withSpec(pod1.getSpec())
        .build();

    client.pods().resource(pod1).waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    client.pods().resource(pod2).createOrReplace();
    client.pods().resource(pod2).waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    client.resource(pdb).createOrReplace();

    // the server needs to process the pdb before the eviction can proceed, so we'll need to wait here
    await().atMost(5, TimeUnit.MINUTES)
        .until(() -> client.pods().withName(pod2.getMetadata().getName()).evict());

    // cant evict because only one left
    assertFalse(client.pods().resource(pod1).evict());
    // ensure it really is still up
    assertTrue(Readiness.getInstance().isReady(client.pods().resource(pod1).get()));

    // create another pod to satisfy PDB
    client.pods().resource(pod3).createOrReplace();
    client.pods().resource(pod3).waitUntilReady(POD_READY_WAIT_IN_SECONDS, TimeUnit.SECONDS);

    // can now evict
    await().atMost(1, TimeUnit.MINUTES).until(() -> client.pods().resource(pod3).evict());
  }
}
