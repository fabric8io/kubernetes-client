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

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Realm;
import com.ning.http.client.filter.FilterContext;
import com.ning.http.client.filter.FilterException;
import com.ning.http.client.filter.RequestFilter;
import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.internal.*;
import io.fabric8.kubernetes.client.internal.Utils;
import io.fabric8.openshift.api.model.*;
import org.jboss.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

import static io.fabric8.kubernetes.client.internal.CertUtils.createKeyStore;
import static io.fabric8.kubernetes.client.internal.CertUtils.createTrustStore;

public class DefaultKubernetesClient implements KubernetesClient, OpenShiftClient {

  private AsyncHttpClient httpClient;
  private URL masterUrl;
  private URL openShiftUrl;

  public DefaultKubernetesClient() throws KubernetesClientException {
    this(new OpenshiftConfigBuilder().build());
  }

  public DefaultKubernetesClient(final Config config) throws KubernetesClientException {
    this(new OpenshiftConfig(config));
  }

  public DefaultKubernetesClient(final OpenshiftConfig config) throws KubernetesClientException {
    if (config.getMasterUrl() == null) {
      throw new KubernetesClientException("Unknown Kubernetes master URL - " +
        "please set with the builder, or set with either system property \"" + Config.KUBERNETES_MASTER_SYSTEM_PROPERTY + "\"" +
        " or environment variable \"" + Utils.convertSystemPropertyNameToEnvVar(Config.KUBERNETES_MASTER_SYSTEM_PROPERTY) + "\"");
    }

    try {
      this.masterUrl = new URL(config.getMasterUrl());
      this.openShiftUrl = new URL(config.getOpenShiftUrl());

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

      this.httpClient = new AsyncHttpClient(clientConfigBuilder.build());
    } catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException | InvalidKeySpecException | IOException | CertificateException e) {
      throw new KubernetesClientException("Could not create HTTP client", e);
    }
  }

  public DefaultKubernetesClient(String masterUrl) throws KubernetesClientException {
   this(new OpenshiftConfigBuilder().withMasterUrl(masterUrl).build());
  }

  @Override
  public void close() {
    httpClient.close();
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
  public ClientOperation<KubernetesClient, Pod, PodList, DoneablePod, ClientResource<Pod, DoneablePod>> pods() {
    return new PodOperationsImpl(this);
  }

  @Override
  public ClientOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController, ReplicationControllerClientResource<ReplicationController, DoneableReplicationController>> replicationControllers() {
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
  public ClientOperation<OpenShiftClient, Template, TemplateList, DoneableTemplate, ProcessableClientResource<Template, DoneableTemplate>> templates() {
    return new TemplateOperationsImpl(this);
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
  public URL getOpenshiftUrl() {
    return openShiftUrl;
  }

  @Override
  public RootPaths rootPaths() {
    return (RootPaths) new BaseOperation(this, "", null, null, KubernetesClient.class, RootPaths.class, null, null) {
    }.get();
  }


  @Override
  public ClientOperation<OpenShiftClient, Build, BuildList, DoneableBuild, ClientResource<Build, DoneableBuild>> builds() {
    return new BuildOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, BuildConfig, BuildConfigList, DoneableBuildConfig, BuildConfigClientResource<BuildConfig, DoneableBuildConfig, Void, Void>> buildConfigs() {
    return new BuildConfigOperationsImpl(this, null, null);
  }

  @Override
  public ClientOperation<OpenShiftClient, DeploymentConfig, DeploymentConfigList, DoneableDeploymentConfig, ClientResource<DeploymentConfig, DoneableDeploymentConfig>> deploymentConfigs() {
    return new DeploymentConfigOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, ImageStream, ImageStreamList, DoneableImageStream, ClientResource<ImageStream, DoneableImageStream>> imageStreams() {
    return new ImageStreamOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthAccessToken, OAuthAccessTokenList, DoneableOAuthAccessToken, ClientResource<OAuthAccessToken, DoneableOAuthAccessToken>> oAuthAccessTokens() {
    return new OAuthAccessTokenOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthAuthorizeToken, OAuthAuthorizeTokenList, DoneableOAuthAuthorizeToken, ClientResource<OAuthAuthorizeToken, DoneableOAuthAuthorizeToken>> oAuthAuthorizeTokens() {
    return new OAuthAuthorizeTokenOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, OAuthClient, OAuthClientList, DoneableOAuthClient, ClientResource<OAuthClient, DoneableOAuthClient>> oAuthClients() {
    return new OAuthClientOperationsImpl(this);
  }

  @Override
  public ClientOperation<OpenShiftClient, Route, RouteList, DoneableRoute, ClientResource<Route, DoneableRoute>> routes() {
    return new RouteOperationsImpl(this);
  }

  @Override
  public ClientNonNamespaceOperation<OpenShiftClient, SecurityContextConstraints, SecurityContextConstraintsList, DoneableSecurityContextConstraints, ClientResource<SecurityContextConstraints, DoneableSecurityContextConstraints>> securityContextConstraints() {
    return new SecurityContextConstraintsOperationsImpl(this);
  }

}
