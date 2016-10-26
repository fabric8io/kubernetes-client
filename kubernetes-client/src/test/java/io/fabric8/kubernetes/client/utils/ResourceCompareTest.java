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
package io.fabric8.kubernetes.client.utils;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import org.junit.Before;
import org.junit.Test;

public class ResourceCompareTest {

  private Pod pod;
  private Service service;
  private KubernetesList kubeList;

  @Before
  public void setup() {
    pod = new PodBuilder().withNewMetadata().withName("pod1").withNamespace("test").and().build();
    service = new ServiceBuilder()
        .withNewMetadata().withName("service1").withNamespace("test").and()
        .build();
    final ReplicationController rc = new ReplicationControllerBuilder()
        .withNewMetadata().withName("repl1").withNamespace("test").endMetadata()
        .withNewSpec().withReplicas(1).endSpec()
        .build();

    kubeList = new KubernetesListBuilder().withItems(pod, service, rc).build();
  }

  @Test
  public void testResourceCompareEqualsTrue() throws Exception {
    assertThat(ResourceCompare.equals(kubeList, kubeList), is(true));
  }

  @Test
  public void testResourceCompareEqualsFalse() throws Exception {
    final ReplicationController rc = new ReplicationControllerBuilder()
        .withNewMetadata().withName("repl1").withNamespace("test").endMetadata()
        .withNewSpec().withReplicas(2).endSpec()
        .build();
    final KubernetesList kubeList2 =
        new KubernetesListBuilder(kubeList).withItems(pod, service, rc).build();
    assertThat(ResourceCompare.equals(kubeList, kubeList2), is(false));
  }
}
