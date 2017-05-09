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

package io.fabric8.openshift.client.server.mock;

import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.openshift.client.OpenShiftClient;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class AdaptTest {

  private OpenShiftMockServer mock = new OpenShiftMockServer();

  @Before
  public void setUp() {
    mock.init();
  }

  @After
  public void tearDown() throws IOException {
    mock.destroy();
  }


  @Test
  public void testSharedClient() {
    KubernetesClient client = mock.createClient();
    OpenShiftClient oclient = client.adapt(OpenShiftClient.class);
    Assert.assertNotNull(client.adapt(OkHttpClient.class));
    Assert.assertNotNull(oclient.adapt(OkHttpClient.class));
  }
}
