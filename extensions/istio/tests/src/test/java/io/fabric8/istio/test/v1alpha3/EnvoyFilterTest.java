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
package io.fabric8.istio.test.v1alpha3;

import io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatch;
import io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectPatch;
import io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterPatchContext;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilter;
import io.fabric8.kubernetes.api.model.runtime.RawExtension;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="claprun@redhat.com">Christophe Laprun</a>
 */
class EnvoyFilterTest {

  @Test
  void loadingFromYAMLIssue99ShouldWork() {
    final InputStream inputStream = EnvoyFilterTest.class.getResourceAsStream("/v1alpha3/envoy-filter-issue99.yaml");
    final EnvoyFilter filter = Serialization.unmarshal(inputStream, EnvoyFilter.class);

    final EnvoyFilterEnvoyConfigObjectPatch configObjectPatch = filter.getSpec().getConfigPatches().get(0);
    final EnvoyFilterEnvoyConfigObjectMatch match = configObjectPatch.getMatch();
    assertEquals(EnvoyFilterPatchContext.SIDECAR_OUTBOUND, match.getContext());

    /*
     * value:
     * name: istio.stats
     * typed_config:
     * '@type': type.googleapis.com/udpa.type.v1.TypedStruct
     * type_url: type.googleapis.com/envoy.extensions.filters.http.wasm.v3.Wasm
     * value:
     * config:
     * configuration: |
     * {
     * "debug": "false",
     * "stat_prefix": "istio"
     * }
     * root_id: stats_outbound
     * vm_config:
     * code:
     * local:
     * inline_string: envoy.wasm.stats
     * runtime: envoy.wasm.runtime.null
     * vm_id: stats_outbound
     */
    assertThat(configObjectPatch.getPatch().getValue())
        .asInstanceOf(InstanceOfAssertFactories.type(RawExtension.class))
        .extracting(RawExtension::getValue)
        .asInstanceOf(InstanceOfAssertFactories.map(String.class, Object.class))
        .contains(
            entry("name", "istio.stats"))
        .extracting("typed_config")
        .asInstanceOf(InstanceOfAssertFactories.map(String.class, Object.class))
        .contains(
            entry("@type", "type.googleapis.com/udpa.type.v1.TypedStruct"),
            entry("type_url", "type.googleapis.com/envoy.extensions.filters.http.wasm.v3.Wasm"))
        .extracting("value.config")
        .asInstanceOf(InstanceOfAssertFactories.map(String.class, String.class))
        .contains(
            entry("configuration", "{\n" +
                "  \"debug\": \"false\",\n" +
                "  \"stat_prefix\": \"istio\"\n" +
                "}\n"),
            entry("root_id", "stats_outbound"));
  }
}
