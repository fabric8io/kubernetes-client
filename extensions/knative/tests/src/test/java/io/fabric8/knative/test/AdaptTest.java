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
package io.fabric8.knative.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.fabric8.knative.client.KnativeClient;
import io.fabric8.knative.client.serving.v1.ServingV1Client;
import io.fabric8.knative.mock.KnativeMockServer;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

class AdaptTest {

  private KnativeMockServer mock = new KnativeMockServer();

  @BeforeEach
  void setUp() {
    mock.init();
  }

  @AfterEach
  void tearDown() {
    mock.destroy();
  }

  @Test
  void testAdapt() {
    KnativeClient sc = mock.createKnative();
    KubernetesClient kc = new DefaultKubernetesClient(sc.getConfiguration());
    assertNotNull(kc.adapt(KnativeClient.class));
  }

  @Test
  void testAdaptServingV1() {
    KnativeClient sc = mock.createKnative();
    KubernetesClient kc = new DefaultKubernetesClient(sc.getConfiguration());
    assertNotNull(kc.adapt(ServingV1Client.class));
  }
}
