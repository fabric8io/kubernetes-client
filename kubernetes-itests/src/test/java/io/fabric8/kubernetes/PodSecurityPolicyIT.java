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
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@LoadKubernetesManifests("/podsecuritypolicy-it.yml")
@RequireK8sSupport(PodSecurityPolicy.class)
class PodSecurityPolicyIT {

  KubernetesClient client;

  @Test
  void load() {

    PodSecurityPolicy loadedPodSecurityPolicy = client.policy().v1beta1().podSecurityPolicies()
        .load(getClass().getResourceAsStream("/test-podsecuritypolicy.yml")).item();

    assertNotNull(loadedPodSecurityPolicy);
    assertEquals("example", loadedPodSecurityPolicy.getMetadata().getName());
    assertFalse(loadedPodSecurityPolicy.getSpec().getPrivileged());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getSupplementalGroups().getRule());
  }

  @Test
  void get() {
    PodSecurityPolicy getPodSecurityPolicy = client.policy().v1beta1().podSecurityPolicies()
        .withName("psp-get").get();
    assertNotNull(getPodSecurityPolicy);
    assertEquals("psp-get", getPodSecurityPolicy.getMetadata().getName());
  }

  @Test
  void list() {
    PodSecurityPolicyList podSecurityPolicyList = client.policy().v1beta1().podSecurityPolicies()
        .withLabels(Collections.singletonMap("foo", "bar")).list();
    assertNotNull(podSecurityPolicyList);
    assertEquals(1, podSecurityPolicyList.getItems().size());
    assertEquals("psp-list", podSecurityPolicyList.getItems().get(0).getMetadata().getName());
    assertEquals("RunAsAny", podSecurityPolicyList.getItems().get(0).getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny", podSecurityPolicyList.getItems().get(0).getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny", podSecurityPolicyList.getItems().get(0).getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny", podSecurityPolicyList.getItems().get(0).getSpec().getSupplementalGroups().getRule());
  }

  @Test
  void update() {

    PodSecurityPolicy podSecurityPolicy = client.policy().v1beta1().podSecurityPolicies().withName("psp-update")
        .edit(p -> new PodSecurityPolicyBuilder(p)
            .editMetadata().withResourceVersion(null).endMetadata()
            .editSpec().withPrivileged(true).endSpec()
            .build());

    assertNotNull(podSecurityPolicy);
    assertEquals("psp-update", podSecurityPolicy.getMetadata().getName());
    assertTrue(podSecurityPolicy.getSpec().getPrivileged());
    assertEquals("RunAsAny", podSecurityPolicy.getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny", podSecurityPolicy.getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny", podSecurityPolicy.getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny", podSecurityPolicy.getSpec().getSupplementalGroups().getRule());
  }

  @Test
  void delete() {
    boolean deleted = client.policy().v1beta1().podSecurityPolicies().withName("psp-delete").delete().size() == 1;
    assertTrue(deleted);

    client.policy().v1beta1().podSecurityPolicies().withName("psp-delete")
        .waitUntilCondition(psp -> psp == null || psp.getMetadata().getDeletionTimestamp() != null, 30, TimeUnit.SECONDS);
  }

}
