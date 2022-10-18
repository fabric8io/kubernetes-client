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
package io.fabric8.istio.test.v1alpha3;

import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilter;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectPatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterPatchContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author <a href="claprun@redhat.com">Christophe Laprun</a>
 */
class EnvoyFilterTest {

  @Test
  void loadingFromYAMLIssue99ShouldWork() throws Exception {
    final InputStream inputStream = EnvoyFilterTest.class.getResourceAsStream("/v1alpha3/envoy-filter-issue99.yaml");
    final EnvoyFilter filter = Serialization.yamlMapper().readValue(inputStream, EnvoyFilter.class);

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
    final Map<String, Object> value = configObjectPatch.getPatch().getValue();
    Map<String, Object> typedConfigStruct = (Map<String, Object>) value.get("typed_config");
    Map<String, Object> valueStruct = (Map<String, Object>) typedConfigStruct.get("value");
    Map<String, Object> configStruct = (Map<String, Object>) valueStruct.get("config");
    final String actual = (String) configStruct.get("root_id");
    assertEquals("stats_outbound", actual);
  }
}
