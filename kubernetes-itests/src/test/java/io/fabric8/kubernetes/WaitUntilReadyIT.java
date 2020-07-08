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

import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodBuilder;
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.SecretBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.arquillian.cube.kubernetes.api.Session;
import org.arquillian.cube.kubernetes.impl.requirement.RequiresKubernetes;
import org.arquillian.cube.requirement.ArquillianConditionalRunner;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@RunWith(ArquillianConditionalRunner.class)
@RequiresKubernetes
public class WaitUntilReadyIT {
  @ArquillianResource
  KubernetesClient client;

  @ArquillianResource
  Session session;

  Pod pod = new PodBuilder()
    .withNewMetadata().withName("p2").withLabels(Collections.singletonMap("app", "p2")).endMetadata()
    .withNewSpec()
    .addNewContainer()
    .withName("myapp-container")
    .withImage("busybox:1.28")
    .withCommand("sh", "-c", "echo The app is running!; sleep 10")
    .endContainer()
    .addNewInitContainer()
    .withName("init-myservice")
    .withImage("busybox:1.28")
    .withCommand("sh", "-c", "echo inititalizing...; sleep 5")
    .endInitContainer()
    .endSpec()
    .build();

  Pod secondPod = new PodBuilder()
    .withNewMetadata().withName("p1").endMetadata()
    .withNewSpec()
    .addNewContainer()
    .withName("myapp2-container")
    .withImage("busybox:1.28")
    .withCommand("sh", "-c", "echo The app is running!; sleep 10")
    .endContainer()
    .addNewInitContainer()
    .withName("init2-mypod")
    .withImage("busybox:1.28")
    .withCommand("sh", "-c", "echo initializing...; sleep 5")
    .endInitContainer()
    .endSpec()
    .build();

  Secret mySecret = new SecretBuilder()
    .withNewMetadata().withName("mysecret").endMetadata()
    .withType("Opaque")
    .addToData("username", "YWRtaW4=")
    .addToData("password", "MWYyZDFlMmU2N2Rm")
    .build();

  @Test
  public void testBatchWaitUntilReady() throws InterruptedException {

    String namespace = session.getNamespace();
    pod = client.pods().inNamespace(namespace).create(pod);
    secondPod = client.pods().inNamespace(namespace).create(secondPod);
    mySecret = client.secrets().inNamespace(namespace).create(mySecret);

    // For waiting for single resource use this.
    client.resourceList(new KubernetesListBuilder().withItems(pod, secondPod, mySecret).build()).inNamespace(namespace).waitUntilReady(60, TimeUnit.SECONDS);

    // Cleanup
    client.pods().inNamespace(namespace).withName("p2").delete();
    client.pods().inNamespace(namespace).withName("p1").delete();
    client.secrets().inNamespace(namespace).withName("mysecret").delete();
  }
}
