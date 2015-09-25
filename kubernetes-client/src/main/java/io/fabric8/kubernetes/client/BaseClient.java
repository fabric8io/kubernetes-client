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

package io.fabric8.kubernetes.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.Realm;
import com.ning.http.client.filter.FilterContext;
import com.ning.http.client.filter.FilterException;
import com.ning.http.client.filter.RequestFilter;
import com.ning.http.client.providers.netty.NettyAsyncHttpProviderConfig;
import io.fabric8.kubernetes.api.model.RootPaths;
import io.fabric8.kubernetes.client.dsl.internal.BaseOperation;
import io.fabric8.kubernetes.client.internal.Utils;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;
import static io.fabric8.kubernetes.client.internal.Utils.isNotNullOrEmpty;


public class BaseClient implements Client {

  private static final ObjectMapper jsonMapper = new ObjectMapper();
  private static final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

  private AsyncHttpClient httpClient;
  private URL masterUrl;
  private String apiVersion;
  private String namespace;
  private Config configuration;

  public BaseClient() throws KubernetesClientException {
    this(new ConfigBuilder().build());
  }

  public BaseClient(final Config config) throws KubernetesClientException {
    this(createHttpClient(config), config);
  }

  public BaseClient(final AsyncHttpClient httpClient, Config config) throws KubernetesClientException {
    try {
      this.httpClient = httpClient;
      this.namespace = config.getNamespace();
      this.configuration = config;
      this.apiVersion = config.getApiVersion();
      if (config.getMasterUrl() == null) {
        throw new KubernetesClientException("Unknown Kubernetes master URL - " +
          "please set with the builder, or set with either system property \"" + Config.KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
          " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
      }
      this.masterUrl = new URL(config.getMasterUrl());

    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }


  static AsyncHttpClient createHttpClient(final Config config) {
    try {
      AsyncHttpClientConfig.Builder clientConfigBuilder = new AsyncHttpClientConfig.Builder();
      clientConfigBuilder.setEnabledProtocols(config.getEnabledProtocols());

      // Follow any redirects
      clientConfigBuilder.setFollowRedirect(true);

      // Should we disable all server certificate checks?
      clientConfigBuilder.setAcceptAnyCertificate(config.isTrustCerts());

      TrustManager[] trustManagers = null;
      if (isNotNullOrEmpty(config.getCaCertFile())|| isNotNullOrEmpty(config.getCaCertData())) {
        KeyStore trustStore = createTrustStore(config.getCaCertData(), config.getCaCertFile());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        trustManagers = tmf.getTrustManagers();
      }

      KeyManager[] keyManagers = null;
      if ((isNotNullOrEmpty(config.getClientCertFile()) || isNotNullOrEmpty(config.getClientCertData())) && (isNotNullOrEmpty(config.getClientKeyFile()) || isNotNullOrEmpty(config.getClientKeyData()))) {
        KeyStore keyStore = createKeyStore(config.getClientCertData(), config.getClientCertFile(), config.getClientKeyData(), config.getClientKeyFile(), config.getClientKeyAlgo(), config.getClientKeyPassphrase().toCharArray());
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, config.getClientKeyPassphrase().toCharArray());
        keyManagers = kmf.getKeyManagers();
      }

      if (keyManagers != null || trustManagers != null) {
        if (trustManagers == null && config.isTrustCerts()) {
          trustManagers = InsecureTrustManagerFactory.INSTANCE.getTrustManagers();
          clientConfigBuilder.setHostnameVerifier(null);
        }
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(keyManagers, trustManagers, new SecureRandom());
        clientConfigBuilder.setSSLContext(sslContext);
      }

      if (isNotNullOrEmpty(config.getUsername()) && isNotNullOrEmpty(config.getPassword())) {
        Realm realm = new Realm.RealmBuilder()
          .setPrincipal(config.getUsername())
          .setPassword(config.getPassword())
          .setUsePreemptiveAuth(true)
          .setScheme(Realm.AuthScheme.BASIC)
          .build();
        clientConfigBuilder.setRealm(realm);
      } else if (config.getOauthToken() != null) {
        clientConfigBuilder.addRequestFilter(new RequestFilter() {
          @Override
          public <T> FilterContext<T> filter(FilterContext<T> ctx) throws FilterException {
            ctx.getRequest().getHeaders().add("Authorization", "Bearer " + config.getOauthToken());
            return ctx;
          }
        });
      }

      if (config.getRequestTimeout() > 0) {
        clientConfigBuilder.setRequestTimeout(config.getRequestTimeout());
      }

      if (config.getProxy() != null) {
        try {
          URL u = new URL(config.getProxy());
          clientConfigBuilder.setProxyServer(new ProxyServer(ProxyServer.Protocol.valueOf(u.getProtocol()), u.getHost(), u.getPort()));
        } catch (MalformedURLException e) {
          throw new KubernetesClientException("Invalid proxy server configuration", e);
        }
      }

      NettyAsyncHttpProviderConfig nettyConfig = new NettyAsyncHttpProviderConfig();
      nettyConfig.setWebSocketMaxFrameSize(65536);
      clientConfigBuilder.setAsyncHttpClientProviderConfig(nettyConfig);

      return new AsyncHttpClient(clientConfigBuilder.build());
    } catch (Exception e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  public BaseClient(String masterUrl) throws KubernetesClientException {
    this(new ConfigBuilder().withMasterUrl(masterUrl).build());
  }

  @Override
  public void close() {
    httpClient.close();
  }

  @Override
  public <T> T unmarshal(InputStream is, Class<T> type) throws KubernetesClientException {
    try (BufferedInputStream bis = new BufferedInputStream(is)) {
      bis.mark(-1);
      int intch;
      do {
        intch = bis.read();
      } while (intch > -1 && Character.isWhitespace(intch));
      bis.reset();

      ObjectMapper mapper = jsonMapper;
      if (intch != '{') {
        mapper = yamlMapper;
      }
      return mapper.readerFor(type).readValue(bis);
    } catch (IOException e) {
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public AsyncHttpClient getHttpClient() {
    return httpClient;
  }

  @Override
  public URL getMasterUrl() {
    return masterUrl;
  }

  @Override
  public String getApiVersion() {
    return apiVersion;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }


  @Override
  public Config getConfiguration() {
    return configuration;
  }

  @Override
  public <C extends Client> C adapt(Class<C> type) {
    ExtensionAdapter<C> adapter = Adapters.get(type);
    if (adapter != null) {
      return adapter.adapt(this);
    }
    throw new IllegalStateException("Could not find adapter");
  }


  @Override
  public RootPaths rootPaths() {
        return new BaseOperation(this, "", null, null, false, null, RootPaths.class, null, null) {}.getRootPaths();
  }

}
