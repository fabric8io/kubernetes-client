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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.junit.Assert;
import org.junit.Test;

public class OpenShiftExtensionAdapterTest {

  @Test
  public void testHasCustomConfig() {
    OpenShiftConfig config = new OpenShiftConfigBuilder()
      .withMasterUrl("http://host1:80")
      .build();

    Assert.assertFalse(OpenShiftExtensionAdapter.hasCustomOpenShiftUrl(config));

    config = new OpenShiftConfigBuilder()
      .withMasterUrl("http://host1:80")
      .withOpenShiftUrl("http://host2:80/oapi/v1")
      .build();

    Assert.assertTrue(OpenShiftExtensionAdapter.hasCustomOpenShiftUrl(config));
  }

}
