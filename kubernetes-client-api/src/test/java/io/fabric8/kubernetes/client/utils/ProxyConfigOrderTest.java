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
import io.fabric8.kubernetes.client.http.HttpClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

class ProxyConfigOrderTest {

  private static final String API_HOST = "api.example";

  @Test
  @DisplayName("environment NO_PROXY cannot disable a higher-priority system HTTP proxy")
  void environmentNoProxyDoesNotDisableSystemHttpProxy() throws Exception {
    assertThat(runChild("system-http")).isEqualTo("HTTP:system-proxy");
  }

  @Test
  @DisplayName("environment NO_PROXY cannot disable a higher-priority system ALL_PROXY")
  void environmentNoProxyDoesNotDisableSystemAllProxy() throws Exception {
    assertThat(runChild("system-all")).isEqualTo("HTTP:system-proxy");
  }

  @Test
  @DisplayName("environment NO_PROXY cannot disable a higher-priority system HTTPS proxy")
  void environmentNoProxyDoesNotDisableSystemHttpsProxy() throws Exception {
    assertThat(runChild("system-https")).isEqualTo("HTTP:system-proxy");
  }

  @Test
  @DisplayName("environment NO_PROXY still applies to an environment HTTP proxy")
  void environmentNoProxyAppliesToEnvironmentHttpProxy() throws Exception {
    assertThat(runChild("environment-http")).isEqualTo("DIRECT:null");
  }

  @Test
  @DisplayName("proxy priority is evaluated for the Kubernetes API protocol only")
  void unrelatedSystemHttpProxyDoesNotOverrideEnvironmentHttpsConfiguration() throws Exception {
    assertThat(runChild("environment-https-with-system-http")).isEqualTo("DIRECT:null");
  }

  @Test
  @DisplayName("system no.proxy still applies to a system HTTP proxy")
  void systemNoProxyAppliesToSystemHttpProxy() throws Exception {
    assertThat(runChild("system-http-and-no-proxy")).isEqualTo("DIRECT:null");
  }

  private static String runChild(String scenario) throws Exception {
    String java = Path.of(System.getProperty("java.home"), "bin", "java").toString();
    ProcessBuilder processBuilder = new ProcessBuilder(
        java,
        "-cp",
        System.getProperty("java.class.path"),
        Child.class.getName(),
        scenario);
    Map<String, String> environment = processBuilder.environment();
    environment.put("HTTP_PROXY", "");
    environment.put("HTTPS_PROXY", "");
    environment.put("ALL_PROXY", "");
    environment.put("NO_PROXY", API_HOST);
    if ("environment-http".equals(scenario)) {
      environment.put("HTTP_PROXY", "http://environment-proxy:8080");
    } else if ("environment-https-with-system-http".equals(scenario)) {
      environment.put("HTTPS_PROXY", "http://environment-proxy:8080");
    }
    processBuilder.redirectErrorStream(true);

    Process process = processBuilder.start();
    String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();

    assertThat(process.waitFor()).as(output).isZero();
    return output;
  }

  public static final class Child {
    private Child() {
    }

    public static void main(String[] args) throws Exception {
      System.setProperty("kubeconfig", "/dev/null");
      boolean useHttps = "system-https".equals(args[0]) || "environment-https-with-system-http".equals(args[0]);
      System.setProperty("kubernetes.master", (useHttps ? "https://" : "http://") + API_HOST);
      if ("system-http".equals(args[0]) || "system-http-and-no-proxy".equals(args[0])) {
        System.setProperty("http.proxy", "http://system-proxy:8080");
      } else if ("system-all".equals(args[0])) {
        System.setProperty("all.proxy", "http://system-proxy:8080");
      } else if ("system-https".equals(args[0])) {
        System.setProperty("https.proxy", "http://system-proxy:8080");
      } else if ("environment-https-with-system-http".equals(args[0])) {
        System.setProperty("http.proxy", "http://unrelated-system-proxy:8080");
      }
      if ("system-http-and-no-proxy".equals(args[0])) {
        System.setProperty("no.proxy", API_HOST);
      }

      Config config = new ConfigBuilder().build();
      AtomicReference<HttpClient.ProxyType> proxyType = new AtomicReference<>();
      AtomicReference<InetSocketAddress> proxyAddress = new AtomicReference<>();
      InvocationHandler handler = (proxy, method, methodArgs) -> {
        if (method.getName().equals("proxyType")) {
          proxyType.set((HttpClient.ProxyType) methodArgs[0]);
        } else if (method.getName().equals("proxyAddress")) {
          proxyAddress.set((InetSocketAddress) methodArgs[0]);
        }
        if (method.getReturnType().isInstance(proxy)) {
          return proxy;
        }
        return null;
      };
      HttpClient.Builder builder = (HttpClient.Builder) Proxy.newProxyInstance(
          HttpClient.Builder.class.getClassLoader(),
          new Class<?>[] { HttpClient.Builder.class },
          handler);

      HttpClientUtils.configureProxy(config, builder);

      String host = proxyAddress.get() == null ? "null" : proxyAddress.get().getHostString();
      System.out.print(proxyType.get() + ":" + host);
    }
  }
}
