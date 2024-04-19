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
package io.fabric8.istio.api.extensons.v1alpha1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.istio.api.extensions.v1alpha1.WasmPlugin;
import io.fabric8.istio.api.extensions.v1alpha1.WasmPluginBuilder;
import io.fabric8.istio.api.networking.v1alpha1.PluginPhase;
import io.fabric8.kubernetes.api.model.Namespaced;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WasmPluginTest {
  private final ObjectMapper mapper = new ObjectMapper();

  @Test
  void hasExpectedApiVersion() {
    assertThat(new WasmPlugin().getApiVersion()).isEqualTo("extensions.istio.io/v1alpha1");
  }

  @Test
  void hasExpectedPlural() {
    assertThat(new WasmPlugin().getPlural()).isEqualTo("wasmplugins");
  }

  @Test
  void hasExpectedKind() {
    assertThat(new WasmPlugin().getKind()).isEqualTo("WasmPlugin");
  }

  @Test
  void isNamespaceScoped() {
    assertThat(WasmPlugin.class.getInterfaces()).contains(Namespaced.class);
  }

  @Test
  void deserializationAndSerializationShouldWorkAsExpected() throws JsonProcessingException {
    // Given
    String originalJson = new Scanner(getClass().getResourceAsStream("/wasmplugin-v1alpha1.json"))
        .useDelimiter("\\A")
        .next();

    // When
    final WasmPlugin wasmPlugin = mapper.readValue(originalJson, WasmPlugin.class);
    final String serializedJson = mapper.writeValueAsString(wasmPlugin);

    // Then
    assertThat(serializedJson).isNotNull();
    assertThat(wasmPlugin)
        .hasFieldOrPropertyWithValue("metadata.name", "openid-connect")
        .hasFieldOrPropertyWithValue("spec.selector.matchLabels", Collections.singletonMap("istio", "ingressgateway"))
        .hasFieldOrPropertyWithValue("spec.phase", PluginPhase.AUTHN)
        .hasFieldOrPropertyWithValue("spec.url", "file:///opt/filters/openid.wasm")
        .hasFieldOrPropertyWithValue("spec.sha256", "1ef0c9a92b0420cf25f7fe5d481b231464bc88f486ca3b9c83ed5cc21df6210")
        .hasFieldOrPropertyWithValue("spec.pluginConfig.openid_server", "authn")
        .hasFieldOrPropertyWithValue("spec.pluginConfig.openid_realm", "ingress");
  }

  @Test
  void builderShouldCreateObjects() {
    // Given
    WasmPluginBuilder proxyConfigBuilder = new WasmPluginBuilder()
        .withNewMetadata()
        .withName("openid-connect")
        .endMetadata()
        .withNewSpec()
        .withNewSelector()
        .addToMatchLabels(Collections.singletonMap("istio", "ingressgateway"))
        .endV1beta1Selector()
        .withUrl("file:///opt/filters/openid.wasm")
        .withSha256("1ef0c9a92b0420cf25f7fe5d481b231464bc88f486ca3b9c83ed5cc21df6210")
        .addToPluginConfig("openid_server", "authn")
        .addToPluginConfig("openid_realm", "ingress")
        .withPhase(PluginPhase.AUTHN)
        .endSpec();
    // When
    WasmPlugin wasmPlugin = proxyConfigBuilder.build();

    // Then
    assertThat(wasmPlugin)
        .hasFieldOrPropertyWithValue("metadata.name", "openid-connect")
        .hasFieldOrPropertyWithValue("spec.selector.matchLabels", Collections.singletonMap("istio", "ingressgateway"))
        .hasFieldOrPropertyWithValue("spec.phase", PluginPhase.AUTHN)
        .hasFieldOrPropertyWithValue("spec.url", "file:///opt/filters/openid.wasm")
        .hasFieldOrPropertyWithValue("spec.sha256", "1ef0c9a92b0420cf25f7fe5d481b231464bc88f486ca3b9c83ed5cc21df6210")
        .hasFieldOrPropertyWithValue("spec.pluginConfig.openid_server", "authn")
        .hasFieldOrPropertyWithValue("spec.pluginConfig.openid_realm", "ingress");
  }
}
