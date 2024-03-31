/*
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
package io.fabric8.kubernetes.log4j.lookup.it;

import io.fabric8.kubernetes.log4j.lookup.KubernetesLookup;
import org.apache.logging.log4j.core.config.plugins.util.PluginManager;
import org.apache.logging.log4j.core.config.plugins.util.PluginType;
import org.apache.logging.log4j.core.lookup.StrLookup;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KubernetesLookupIT {

  @Test
  void should_find_lookup() {
    PluginManager manager = new PluginManager(StrLookup.CATEGORY);
    manager.collectPlugins();
    PluginType<?> pluginType = manager.getPluginType("k8s");
    assertThat(pluginType)
        .as("check 'k8s' lookup")
        .isNotNull()
        .extracting(PluginType::getPluginClass)
        .isEqualTo(KubernetesLookup.class);
  }
}
