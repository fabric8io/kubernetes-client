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

package io.fabric8.openshift.client.impl;

import io.fabric8.openshift.client.OpenShiftConfig;
import io.fabric8.openshift.client.OpenShiftConfigBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OpenShiftExtensionAdapterTest {

  @Test
  void testHasCustomConfig() {
    OpenShiftConfig config = new OpenShiftConfigBuilder()
        .withMasterUrl("http://host1:80")
        .build();

    Assertions.assertFalse(OpenShiftClientImpl.hasCustomOpenShiftUrl(config));

    config = new OpenShiftConfigBuilder()
        .withMasterUrl("http://host1:80")
        .withOpenShiftUrl("http://host2:80/oapi/v1")
        .build();

    Assertions.assertTrue(OpenShiftClientImpl.hasCustomOpenShiftUrl(config));
  }

}
