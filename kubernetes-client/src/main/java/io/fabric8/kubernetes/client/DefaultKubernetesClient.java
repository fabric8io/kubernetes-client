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
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.internal.BaseOperation;
import io.fabric8.kubernetes.client.dsl.internal.EndpointsOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.EventOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesListOperationsImpl;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.dsl.internal.NamespaceOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.NodeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PersistentVolumeClaimOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PersistentVolumeOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.PodOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ResourceQuotaOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.SecretOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.SecurityContextConstraintsOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ServiceAccountOperationsImpl;
import io.fabric8.kubernetes.client.dsl.internal.ServiceOperationsImpl;
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
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.ServiceLoader;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;

public class DefaultKubernetesClient implements KubernetesClient {

  private static final ObjectMapper jsonMapper = new ObjectMapper();
  private static final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
  private static Map<String, ResourceCreator> resourceCreatorMap;
  private AsyncHttpClient httpClient;
  private URL masterUrl;
  private Config configuration;

  public DefaultKubernetesClient() throws KubernetesClientException {
    this(new ConfigBuilder().build());
  }

  public DefaultKubernetesClient(final Config config) throws KubernetesClientException {
    this.configuration = config;
    if (config.getMasterUrl() == null) {
      throw new KubernetesClientException("Unknown Kubernetes master URL - " +
        "please set with the builder, or set with either system property \"" + Config.KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
        " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
    }

    try {
      this.masterUrl = new URL(config.getMasterUrl());
      AsyncHttpClientConfig.Builder clientConfigBuilder = new AsyncHttpClientConfig.Builder();
      clientConfigBuilder.setEnabledProtocols(config.getEnabledProtocols());

      // Follow any redirects
      clientConfigBuilder.setFollowRedirect(true);

      // Should we disable all server certificate checks?
      clientConfigBuilder.setAcceptAnyCertificate(config.isTrustCerts());

      TrustManager[] trustManagers = null;
      if (config.getCaCertFile() != null || config.getCaCertData() != null) {
        KeyStore trustStore = createTrustStore(config.getCaCertData(), config.getCaCertFile());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        trustManagers = tmf.getTrustManagers();
      }

      KeyManager[] keyManagers = null;
      if ((config.getClientCertFile() != null || config.getClientCertData() != null) && (config.getClientKeyFile() != null || config.getClientKeyData() != null)) {
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

      if (config.getUsername() != null && config.getPassword() != null) {
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

      this.httpClient = new AsyncHttpClient(clientConfigBuilder.build());
    } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException | InvalidKeySpecException | IOException | CertificateException e) {
      throw new KubernetesClientException("Could not create HTTP client", e);
    }
  }

  public DefaultKubernetesClient(String masterUrl) throws KubernetesClientException {
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
  public ClientOperation<KubernetesClient, Endpoints, EndpointsList, DoneableEndpoints, ClientResource<Endpoints, DoneableEndpoints>> endpoints() {
    return new EndpointsOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Event, EventList, DoneableEvent, ClientResource<Event, DoneableEvent>> events() {
    return new EventOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, Namespace, NamespaceList, DoneableNamespace, ClientResource<Namespace, DoneableNamespace>> namespaces() {
    return new NamespaceOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, Node, NodeList, DoneableNode, ClientResource<Node, DoneableNode>> nodes() {
    return new NodeOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, PersistentVolume, PersistentVolumeList, DoneablePersistentVolume, ClientResource<PersistentVolume, DoneablePersistentVolume>> persistentVolumes() {
    return new PersistentVolumeOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, PersistentVolumeClaim, PersistentVolumeClaimList, DoneablePersistentVolumeClaim, ClientResource<PersistentVolumeClaim, DoneablePersistentVolumeClaim>> persistentVolumeClaims() {
    return new PersistentVolumeClaimOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Pod, PodList, DoneablePod, ClientLoggableResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ClientRollableScallableResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
    return new ReplicationControllerOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ResourceQuota, ResourceQuotaList, DoneableResourceQuota, ClientResource<ResourceQuota, DoneableResourceQuota>> resourceQuotas() {
    return new ResourceQuotaOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Secret, SecretList, DoneableSecret, ClientResource<Secret, DoneableSecret>> secrets() {
    return new SecretOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, Service, ServiceList, DoneableService, ClientResource<Service, DoneableService>> services() {
    return new ServiceOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ServiceAccount, ServiceAccountList, DoneableServiceAccount, ClientResource<ServiceAccount, DoneableServiceAccount>> serviceAccounts() {
    return new ServiceAccountOperationsImpl(this);
  }

  @Override
  public ClientKubernetesListOperation<KubernetesClient> lists() {
    return new KubernetesListOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<KubernetesClient, SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
    return new SecurityContextConstraintsOperationsImpl(this);
  }

  @Override
  public RootPaths rootPaths() {
    return (RootPaths) new BaseOperation(this, "", null, null, false, null, KubernetesClient.class, RootPaths.class, null, null) {
    }.get();
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
  public Config getConfiguration() {
    return configuration;
  }


  @Override
  public <T extends Extension> T adapt(Class<T> type) {
    for (ExtensionAdapter<T> adapter : ServiceLoader.load(ExtensionAdapter.class)) {
      if (adapter.getExtensionType().isAssignableFrom(type)) {
        return adapter.adapt(this);
      }
    }
    throw new IllegalStateException("Could not find adapter");
  }
}
