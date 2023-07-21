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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.http.TlsVersion;

import java.util.function.Function;

public class KubernetesMockClientKubernetesClientBuilder implements Function<String, KubernetesClientBuilder> {

  @Override
  public KubernetesClientBuilder apply(String url) {
    return new KubernetesClientBuilder().withConfig(initConfig(url));
  }

  protected Config initConfig(String url) {
    return new ConfigBuilder(Config.empty())
        .withMasterUrl(url)
        .withTrustCerts(true)
        .withTlsVersions(TlsVersion.TLS_1_2)
        .withNamespace("test")
        .withHttp2Disable(true)
        .build();
  }
}
