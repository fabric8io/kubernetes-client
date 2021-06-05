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

import io.fabric8.commons.ClusterEntity;
import io.fabric8.commons.DeleteEntity;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicy;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyBuilder;
import io.fabric8.kubernetes.api.model.policy.v1beta1.PodSecurityPolicyList;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class PodSecurityPolicyIT {

  @ArquillianResource
  KubernetesClient client;

  @BeforeClass
  public static void init() {
    ClusterEntity.apply(PodSecurityPolicyIT.class.getResourceAsStream("/podsecuritypolicy-it.yml"));
  }

  @Test
  public void load() {

    PodSecurityPolicy loadedPodSecurityPolicy = client.policy().podSecurityPolicies()
      .load(getClass().getResourceAsStream("/test-podsecuritypolicy.yml")).get();

    assertNotNull(loadedPodSecurityPolicy);
    assertEquals("example", loadedPodSecurityPolicy.getMetadata().getName());
    assertFalse(loadedPodSecurityPolicy.getSpec().getPrivileged());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny", loadedPodSecurityPolicy.getSpec().getSupplementalGroups().getRule());
  }

  @Test
  public void get() {
    PodSecurityPolicy getPodSecurityPolicy = client.policy().podSecurityPolicies()
      .withName("psp-get").get();
    assertNotNull(getPodSecurityPolicy);
    assertEquals("psp-get", getPodSecurityPolicy.getMetadata().getName());
  }

  @Test
  public void list() {

    PodSecurityPolicyList podSecurityPolicyList = client.policy().podSecurityPolicies()
      .withLabels(Collections.singletonMap("foo","bar")).list();
    assertNotNull(podSecurityPolicyList);
    assertEquals(1,podSecurityPolicyList.getItems().size());
    assertEquals("psp-list",podSecurityPolicyList.getItems().get(0).getMetadata().getName());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getRunAsUser().getRule());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getFsGroup().getRule());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getSeLinux().getRule());
    assertEquals("RunAsAny",podSecurityPolicyList.getItems().get(0).getSpec().getSupplementalGroups().getRule());
  }

  @Test
  public void update(){

    PodSecurityPolicy podSecurityPolicy = client.policy().podSecurityPolicies().withName("psp-update").edit(p -> new PodSecurityPolicyBuilder(p)
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
  public void delete(){
    boolean deleted = client.policy().podSecurityPolicies().withName("psp-delete").delete();
    assertTrue(deleted);

    DeleteEntity<PodSecurityPolicy> deleteEntity = new DeleteEntity<>(PodSecurityPolicy.class, client, "psp-delete", null);
    await().atMost(30, TimeUnit.SECONDS).until(deleteEntity);
  }

  @AfterClass
  public static void cleanup() {
    ClusterEntity.remove(PodSecurityPolicyIT.class.getResourceAsStream("/podsecuritypolicy-it.yml"));
  }

}
