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
package io.fabric8.kubernetes.client.internal;

import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.api.model.NamedContextBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("KubeConfigUtils.merge")
class KubeConfigUtilsMergeTest {

  private Config result;

  @Test
  void noContextProvidedLeavesConfigUnchanged() {
    result = Config.empty();
    KubeConfigUtils.merge(result, null,
        parseConfig("/internal/kube-config-utils-merge/config-empty.yaml"));
    assertThat(result)
        .hasFieldOrPropertyWithValue("currentContext", null)
        .hasFieldOrPropertyWithValue("contexts", Collections.emptyList());
  }

  @Test
  void incompleteContextProvidedLeavesConfigUnchanged() {
    result = new ConfigBuilder(Config.empty())
        .addToContexts(new NamedContextBuilder()
            .withName("incomplete-context")
            .build())
        .build();
    KubeConfigUtils.merge(result, "incomplete-context",
        parseConfig("/internal/kube-config-utils-merge/config-1.yaml"),
        parseConfig("/internal/kube-config-utils-merge/config-2.yaml"),
        parseConfig("/internal/kube-config-utils-merge/config-3.yaml"),
        parseConfig("/internal/kube-config-utils-merge/config-4.yaml"));
    assertThat(result)
        .hasFieldOrPropertyWithValue("currentContext", null)
        .extracting("contexts")
        .asInstanceOf(InstanceOfAssertFactories.list(NamedContext.class))
        // Contains the contexts from the config files too
        .filteredOn(ctx -> "incomplete-context".equals(ctx.getName()))
        .singleElement()
        .hasFieldOrPropertyWithValue("name", "incomplete-context")
        .hasFieldOrPropertyWithValue("context", null);
  }

  @Nested
  @DisplayName("When merging multiple Configs with null context, use context from first Config")
  class NullContextArgument {

    @BeforeEach
    void setUp() {
      result = Config.empty();
      KubeConfigUtils.merge(result, null,
          parseConfig("/internal/kube-config-utils-merge/config-1.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-2.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-3.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-4.yaml"));
    }

    @Test
    void contextsContainsAllValidConfigContexts() {
      // Contexts that don't contain a valid nested Context object are ignored
      assertThat(result.getContexts())
          .allMatch(ctx -> ctx.getContext() != null);
    }

    @Test
    void contextsContainInformationFromFile() {
      // Parser adds additional properties to context to be able to retrieve the file where it was loaded from
      assertThat(result.getContexts())
          .allMatch(ctx -> ctx.getAdditionalProperties() != null)
          .allMatch(ctx -> ctx.getAdditionalProperties().get("KUBERNETES_CONFIG_FILE_KEY") != null);
    }

    @Test
    void currentContextLoadedFromFirstConfig() {
      assertThat(result.getCurrentContext())
          .hasFieldOrPropertyWithValue("name", "context-in-all-configs")
          .hasFieldOrPropertyWithValue("context.cluster", "config-1-cluster")
          .hasFieldOrPropertyWithValue("context.namespace", "config-1-namespace")
          .hasFieldOrPropertyWithValue("context.user", "config-1-user");
    }

    @Test
    void clusterInfoFromFirstConfig() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("masterUrl", "https://config-1.example.com/")
          .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy.config-1.example.com");
    }

    @Test
    void userInfoFromFirstConfig() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("username", "config-1-user-username")
          .hasFieldOrPropertyWithValue("password", "config-1-user-pa33word")
          .hasFieldOrPropertyWithValue("autoOAuthToken", "config-1-user-token");
    }
  }

  @Nested
  @DisplayName("When merging multiple Configs with context argument, use context from Config that matches context argument")
  class MatchingContextArgument {

    @BeforeEach
    void setUp() {
      result = Config.empty();
      KubeConfigUtils.merge(result, "context-in-config-3",
          parseConfig("/internal/kube-config-utils-merge/config-1.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-2.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-3.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-4.yaml"));
    }

    @Test
    void currentContextLoadedFromConfig3() {
      assertThat(result.getCurrentContext())
          .hasFieldOrPropertyWithValue("name", "context-in-config-3")
          .hasFieldOrPropertyWithValue("context.cluster", "config-3-special-cluster")
          .hasFieldOrPropertyWithValue("context.user", "config-3-special-user");
    }

    @Test
    void clusterInfoFromConfig3() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("masterUrl", "https://config-3-special-cluster.example.com/")
          .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy.config-3-special-cluster.example.com");
    }

    @Test
    void userInfoFromConfig3() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("username", null)
          .hasFieldOrPropertyWithValue("password", null)
          .hasFieldOrPropertyWithValue("autoOAuthToken", "config-3-special-user-token");
    }
  }

  @Nested
  @DisplayName("When merging multiple Configs with context argument, use context from FIRST Config that matches context argument")
  class MatchingDuplicateContextArgument {

    @BeforeEach
    void setUp() {
      result = Config.empty();
      KubeConfigUtils.merge(result, "duplicate-context",
          parseConfig("/internal/kube-config-utils-merge/config-1.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-2.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-3.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-4.yaml"));
    }

    @Test
    void currentContextLoadedFromFirstMatchingConfig() {
      assertThat(result.getCurrentContext())
          .hasFieldOrPropertyWithValue("name", "duplicate-context")
          .hasFieldOrPropertyWithValue("context.cluster", "duplicate-cluster")
          .hasFieldOrPropertyWithValue("context.user", "duplicate-user");
    }

    @Test
    void clusterInfoFromFirstMatchingConfig() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("masterUrl", "https://duplicate-cluster-in-1.example.com/")
          .hasFieldOrPropertyWithValue("httpsProxy", null);
    }

    @Test
    void userInfoFromFirstMatchingConfig() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("username", null)
          .hasFieldOrPropertyWithValue("password", null)
          .hasFieldOrPropertyWithValue("autoOAuthToken", "duplicate-user-1-token");
    }
  }

  @Nested
  @DisplayName("When merging multiple Configs with context argument, use context from ORIGINAL Config that matches context argument")
  class ContextArgumentInOriginalConfig {

    @BeforeEach
    void setUp() {
      result = new ConfigBuilder()
          .addToContexts(new NamedContextBuilder()
              .withName("context-in-original-config")
              .withNewContext()
              .withCluster("original-cluster")
              .withUser("original-user")
              .endContext()
              .build())
          .withMasterUrl("https://original-cluster.example.com/")
          .withHttpsProxy("socks5://proxy.original-cluster.example.com")
          .withUsername("original-username")
          .withPassword("original-password")
          .build();
      KubeConfigUtils.merge(result, "context-in-original-config",
          parseConfig("/internal/kube-config-utils-merge/config-1.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-2.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-3.yaml"),
          parseConfig("/internal/kube-config-utils-merge/config-4.yaml"));
    }

    @Test
    void currentContextPreservedFromOriginalConfig() {
      assertThat(result.getCurrentContext())
          .hasFieldOrPropertyWithValue("name", "context-in-original-config")
          .hasFieldOrPropertyWithValue("context.cluster", "original-cluster")
          .hasFieldOrPropertyWithValue("context.user", "original-user");
    }

    @Test
    void clusterInfoPreservedFromOriginalConfig() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("masterUrl", "https://original-cluster.example.com/")
          .hasFieldOrPropertyWithValue("httpsProxy", "socks5://proxy.original-cluster.example.com");
    }

    @Test
    void userInfoPreservedFromOriginalConfig() {
      assertThat(result)
          .hasFieldOrPropertyWithValue("username", "original-username")
          .hasFieldOrPropertyWithValue("password", "original-password")
          .hasFieldOrPropertyWithValue("autoOAuthToken", null);
    }
  }

  private static io.fabric8.kubernetes.api.model.Config parseConfig(String path) {
    final var file = new File(Objects.requireNonNull(KubeConfigUtilsMergeTest.class.getResource(path)).getFile());
    return KubeConfigUtils.parseConfig(file);
  }
}
