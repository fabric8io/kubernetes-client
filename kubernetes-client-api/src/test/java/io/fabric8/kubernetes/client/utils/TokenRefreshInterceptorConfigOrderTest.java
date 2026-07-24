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
package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RestoreSystemProperties;
import io.fabric8.kubernetes.client.http.HttpRequest;
import io.fabric8.kubernetes.client.http.StandardHttpRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Regression for config source order: higher-priority auth must not lose to lower-priority
 * credentials retained from kubeconfig. See https://github.com/fabric8io/kubernetes-client/issues/7960
 */
@RestoreSystemProperties({
    "kubeconfig",
    "kubernetes.auth.token",
    "kubernetes.auth.basic.username",
    "kubernetes.auth.basic.password"
})
class TokenRefreshInterceptorConfigOrderTest {

  @TempDir
  private Path temporaryFolder;

  @Test
  void systemPropertyTokenOverridesKubeconfigBasicAuth() throws Exception {
    Path kubeconfig = temporaryFolder.resolve("lower-basic.yaml");
    Files.writeString(kubeconfig, String.join("\n",
        "apiVersion: v1",
        "kind: Config",
        "clusters:",
        "- name: c",
        "  cluster:",
        "    server: https://api.example",
        "contexts:",
        "- name: ctx",
        "  context:",
        "    cluster: c",
        "    user: lower",
        "current-context: ctx",
        "users:",
        "- name: lower",
        "  user:",
        "    username: lower-user",
        "    password: lower-pass",
        ""),
        StandardCharsets.UTF_8);
    System.setProperty("kubeconfig", kubeconfig.toString());
    System.setProperty("kubernetes.auth.token", "HIGHER_TOKEN");

    Config config = new ConfigBuilder().build();
    HttpRequest.Builder request = new StandardHttpRequest.Builder()
        .uri("https://api.example");
    new TokenRefreshInterceptor(config, null, Instant.now()).before(request, request.build(), null);

    assertThat(config.getAutoOAuthToken()).isEqualTo("HIGHER_TOKEN");
    assertThat(config.getUsername()).isNull();
    assertThat(config.getPassword()).isNull();
    assertThat(request.build().header("Authorization"))
        .isEqualTo("Bearer HIGHER_TOKEN");
  }

  @Test
  void systemPropertyBasicAuthOverridesKubeconfigToken() throws Exception {
    Path kubeconfig = temporaryFolder.resolve("lower-token.yaml");
    Files.writeString(kubeconfig, String.join("\n",
        "apiVersion: v1",
        "kind: Config",
        "clusters:",
        "- name: c",
        "  cluster:",
        "    server: https://api.example",
        "contexts:",
        "- name: ctx",
        "  context:",
        "    cluster: c",
        "    user: lower",
        "current-context: ctx",
        "users:",
        "- name: lower",
        "  user:",
        "    token: LOWER_TOKEN",
        ""),
        StandardCharsets.UTF_8);
    System.setProperty("kubeconfig", kubeconfig.toString());
    System.setProperty("kubernetes.auth.basic.username", "sys-user");
    System.setProperty("kubernetes.auth.basic.password", "sys-pass");

    Config config = new ConfigBuilder().build();
    HttpRequest.Builder request = new StandardHttpRequest.Builder()
        .uri("https://api.example");
    new TokenRefreshInterceptor(config, null, Instant.now()).before(request, request.build(), null);

    assertThat(config.getAutoOAuthToken()).isNull();
    assertThat(config.getUsername()).isEqualTo("sys-user");
    assertThat(config.getPassword()).isEqualTo("sys-pass");
    assertThat(request.build().header("Authorization"))
        .isEqualTo(HttpClientUtils.basicCredentials("sys-user", "sys-pass"));
  }
}
