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

import io.fabric8.openshift.api.model.BuildConfig;
import io.fabric8.openshift.api.model.BuildConfigBuilder;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.client.OpenShiftClient;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableOpenShiftMockClient(crud = true)
class BuildConfigCrudTest {
  OpenShiftClient client;

  @Test
  void testCrud() {
    BuildConfig buildConfig = new BuildConfigBuilder()
        .withNewMetadata()
        .withName("bc2")
        .withLabels(Collections.singletonMap("key", "value"))
        .endMetadata()
        .build();

    client.buildConfigs().create(buildConfig);

    BuildConfig buildConfig1 = client.buildConfigs().withName("bc2").get();
    assertEquals("value", buildConfig1.getMetadata().getLabels().get("key"));

    BuildConfigList buildConfigList = client.buildConfigs().list();
    assertEquals(1, buildConfigList.getItems().size());
  }
}
