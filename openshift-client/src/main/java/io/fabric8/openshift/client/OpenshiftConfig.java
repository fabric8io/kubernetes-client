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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.internal.Utils;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenshiftConfig extends Config {

  public static final String KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY = "kubernetes.oapi.version";

  private String oapiVersion = "v1";
  private String openShiftUrl;
  private Config kubernetesConfig;

  public OpenshiftConfig() {
    this(new ConfigBuilder().build());
  }

  public OpenshiftConfig(Config kubernetesConfig) {
    this(kubernetesConfig, "v1", null);
  }

  @Buildable(builderPackage = "io.fabric8.kubernetes.api.builder",
  refs = {@BuildableReference(Config.class)}
  )
  public OpenshiftConfig(Config kubernetesConfig, String oapiVersion, String openShiftUrl) {
    super(kubernetesConfig.isTrustCerts(),
      kubernetesConfig.getMasterUrl(), kubernetesConfig.getApiVersion(), kubernetesConfig.getEnabledProtocols(),
      kubernetesConfig.getCaCertFile(), kubernetesConfig.getCaCertData(),
      kubernetesConfig.getClientCertFile(), kubernetesConfig.getClientCertData(),
      kubernetesConfig.getClientKeyFile(), kubernetesConfig.getClientKeyData(),
      kubernetesConfig.getClientKeyAlgo(), kubernetesConfig.getClientKeyPassphrase(),
      kubernetesConfig.getUsername(), kubernetesConfig.getPassword(), kubernetesConfig.getOauthToken());
    this.kubernetesConfig=kubernetesConfig;
    this.oapiVersion = Utils.getSystemPropertyOrEnvVar(KUBERNETES_OAPI_VERSION_SYSTEM_PROPERTY, oapiVersion);
    this.openShiftUrl = openShiftUrl;

    if (this.openShiftUrl == null) {
      try {
        this.openShiftUrl = new URL(new URL(getMasterUrl()), "/oapi/" + this.oapiVersion + "/").toString();
      } catch (MalformedURLException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
  }

  public Config getKubernetesConfig() {
    return this.kubernetesConfig;
  }

  public String getOapiVersion() {
    return oapiVersion;
  }

  public String getOpenShiftUrl() {
    return openShiftUrl;
  }
}
