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
package io.fabric8.kubernetes.client.osgi;

import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import io.fabric8.kubernetes.client.NamespacedKubernetesClient;
import io.fabric8.kubernetes.client.NamespacedKubernetesClientAdapter;
import io.fabric8.kubernetes.client.OAuthTokenProvider;
import io.fabric8.kubernetes.client.impl.KubernetesClientImpl;
import io.fabric8.kubernetes.client.impl.ResourceHandler;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.ReferencePolicy;
import org.apache.felix.scr.annotations.ReferencePolicyOption;
import org.apache.felix.scr.annotations.References;
import org.apache.felix.scr.annotations.Service;

import java.util.Map;

import static io.fabric8.kubernetes.client.Config.KUBERNETES_API_VERSION_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_HTTPS_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_HTTP_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_KEYSTORE_FILE_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_MASTER_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_NAMESPACE_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_NO_PROXY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_TRUSTSTORE_FILE_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY;
import static io.fabric8.kubernetes.client.Config.KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY;

@Component(configurationPid = "io.fabric8.kubernetes.client", policy = ConfigurationPolicy.REQUIRE)
@Service({ KubernetesClient.class, NamespacedKubernetesClient.class })
@References({
    @Reference(referenceInterface = ResourceHandler.class, cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, policy = ReferencePolicy.DYNAMIC, bind = "bindResourceHandler", unbind = "unbindResourceHandler"),
    @Reference(referenceInterface = OAuthTokenProvider.class, cardinality = ReferenceCardinality.OPTIONAL_UNARY, policyOption = ReferencePolicyOption.GREEDY, bind = "bindOAuthTokenProvider", unbind = "unbindOAuthTokenProvider")
})
public class ManagedKubernetesClient extends NamespacedKubernetesClientAdapter<KubernetesClientImpl> {

  public ManagedKubernetesClient() {
    super(KubernetesClientImpl.class);
  }

  private OAuthTokenProvider provider;

  @Activate
  public void activate(Map<String, Object> properties) {
    final ConfigBuilder builder = new ConfigBuilder();

    if (properties.containsKey(KUBERNETES_MASTER_SYSTEM_PROPERTY)) {
      builder.withMasterUrl((String) properties.get(KUBERNETES_MASTER_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_API_VERSION_SYSTEM_PROPERTY)) {
      builder.withApiVersion((String) properties.get(KUBERNETES_API_VERSION_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY)) {
      builder.withNamespace((String) properties.get(KUBERNETES_NAMESPACE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY)) {
      builder.withCaCertFile((String) properties.get(KUBERNETES_CA_CERTIFICATE_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY)) {
      builder.withCaCertData((String) properties.get(KUBERNETES_CA_CERTIFICATE_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY)) {
      builder.withClientCertFile((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY)) {
      builder.withClientCertData((String) properties.get(KUBERNETES_CLIENT_CERTIFICATE_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY)) {
      builder.withClientKeyFile((String) properties.get(KUBERNETES_CLIENT_KEY_FILE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY)) {
      builder.withClientKeyData((String) properties.get(KUBERNETES_CLIENT_KEY_DATA_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY)) {
      builder.withClientKeyAlgo((String) properties.get(KUBERNETES_CLIENT_KEY_ALGO_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY)) {
      builder.withClientKeyPassphrase((String) properties.get(KUBERNETES_CLIENT_KEY_PASSPHRASE_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY)) {
      builder.withUsername((String) properties.get(KUBERNETES_AUTH_BASIC_USERNAME_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY)) {
      builder.withPassword((String) properties.get(KUBERNETES_AUTH_BASIC_PASSWORD_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY)) {
      builder.withOauthToken((String) properties.get(KUBERNETES_OAUTH_TOKEN_SYSTEM_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY)) {
      builder.withWatchReconnectInterval(
          Integer.parseInt((String) properties.get(KUBERNETES_WATCH_RECONNECT_INTERVAL_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY)) {
      builder
          .withWatchReconnectLimit(Integer.parseInt((String) properties.get(KUBERNETES_WATCH_RECONNECT_LIMIT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY)) {
      builder.withRequestTimeout(Integer.parseInt((String) properties.get(KUBERNETES_REQUEST_TIMEOUT_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_HTTP_PROXY)) {
      builder.withHttpProxy((String) properties.get(KUBERNETES_HTTP_PROXY));
    }
    if (properties.containsKey(KUBERNETES_HTTPS_PROXY)) {
      builder.withHttpsProxy((String) properties.get(KUBERNETES_HTTPS_PROXY));
    }
    if (properties.containsKey(KUBERNETES_NO_PROXY)) {
      String noProxyProperty = (String) properties.get(KUBERNETES_NO_PROXY);
      builder.withNoProxy(noProxyProperty.split(","));
    }
    if (properties.containsKey(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY)) {
      builder.withWebsocketPingInterval(
          Long.parseLong((String) properties.get(KUBERNETES_WEBSOCKET_PING_INTERVAL_SYSTEM_PROPERTY)));
    }
    if (properties.containsKey(KUBERNETES_TRUSTSTORE_FILE_PROPERTY)) {
      builder.withTrustStoreFile((String) properties.get(KUBERNETES_TRUSTSTORE_FILE_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY)) {
      builder.withTrustStorePassphrase((String) properties.get(KUBERNETES_TRUSTSTORE_PASSPHRASE_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_KEYSTORE_FILE_PROPERTY)) {
      builder.withKeyStoreFile((String) properties.get(KUBERNETES_KEYSTORE_FILE_PROPERTY));
    }
    if (properties.containsKey(KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY)) {
      builder.withKeyStorePassphrase((String) properties.get(KUBERNETES_KEYSTORE_PASSPHRASE_PROPERTY));
    }
    if (provider != null) {
      builder.withOauthTokenProvider(provider);
    }

    this.init(new KubernetesClientBuilder().withConfig(builder.build()).build());
  }

  @Deactivate
  public void deactivate() {
    this.close();
  }

  /**
   * @deprecated ResourceHandlers to not need bound
   */
  @Deprecated
  public void bindResourceHandler(ResourceHandler resourceHandler) {
    // not used
  }

  /**
   * @deprecated ResourceHandlers to not need bound
   */
  @Deprecated
  public void unbindResourceHandler(ResourceHandler resourceHandler) {
    // not used
  }

  public void bindOAuthTokenProvider(OAuthTokenProvider provider) {
    this.provider = provider;
  }

  public void unbindOAuthTokenProvider(OAuthTokenProvider provider) {
    if (this.provider == provider) {
      this.provider = null;
    }
  }

}
