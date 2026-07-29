package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SundrioConfigBuilder extends SundrioConfigFluent<SundrioConfigBuilder> implements VisitableBuilder<SundrioConfig,SundrioConfigBuilder>{

  SundrioConfigFluent<?> fluent;

  public SundrioConfigBuilder() {
    this(new SundrioConfig());
  }
  
  public SundrioConfigBuilder(SundrioConfigFluent<?> fluent) {
    this(fluent, new SundrioConfig());
  }
  
  public SundrioConfigBuilder(SundrioConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SundrioConfigBuilder(SundrioConfigFluent<?> fluent,SundrioConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SundrioConfig build() {
    SundrioConfig buildable = new SundrioConfig();
    buildable.setTrustCerts(fluent.getTrustCerts());
    buildable.setDisableHostnameVerification(fluent.getDisableHostnameVerification());
    buildable.setMasterUrl(fluent.getMasterUrl());
    buildable.setApiVersion(fluent.getApiVersion());
    buildable.setNamespace(fluent.getNamespace());
    buildable.setDefaultNamespace(fluent.getDefaultNamespace());
    buildable.setCaCertFile(fluent.getCaCertFile());
    buildable.setCaCertData(fluent.getCaCertData());
    buildable.setClientCertFile(fluent.getClientCertFile());
    buildable.setClientCertData(fluent.getClientCertData());
    buildable.setClientKeyFile(fluent.getClientKeyFile());
    buildable.setClientKeyData(fluent.getClientKeyData());
    buildable.setClientKeyAlgo(fluent.getClientKeyAlgo());
    buildable.setClientKeyPassphrase(fluent.getClientKeyPassphrase());
    buildable.setTrustStoreFile(fluent.getTrustStoreFile());
    buildable.setTrustStorePassphrase(fluent.getTrustStorePassphrase());
    buildable.setKeyStoreFile(fluent.getKeyStoreFile());
    buildable.setKeyStorePassphrase(fluent.getKeyStorePassphrase());
    buildable.setAuthProvider(fluent.getAuthProvider());
    buildable.setUsername(fluent.getUsername());
    buildable.setPassword(fluent.getPassword());
    buildable.setOauthToken(fluent.getOauthToken());
    buildable.setAutoOAuthToken(fluent.getAutoOAuthToken());
    buildable.setOauthTokenProvider(fluent.getOauthTokenProvider());
    buildable.setWebsocketPingInterval(fluent.getWebsocketPingInterval());
    buildable.setConnectionTimeout(fluent.getConnectionTimeout());
    buildable.setMaxConcurrentRequests(fluent.getMaxConcurrentRequests());
    buildable.setMaxConcurrentRequestsPerHost(fluent.getMaxConcurrentRequestsPerHost());
    buildable.setContexts(fluent.getContexts());
    buildable.setCurrentContext(fluent.getCurrentContext());
    buildable.setWatchReconnectInterval(fluent.getWatchReconnectInterval());
    buildable.setWatchReconnectLimit(fluent.getWatchReconnectLimit());
    buildable.setUploadRequestTimeout(fluent.getUploadRequestTimeout());
    buildable.setRequestRetryBackoffLimit(fluent.getRequestRetryBackoffLimit());
    buildable.setRequestRetryBackoffInterval(fluent.getRequestRetryBackoffInterval());
    buildable.setRequestTimeout(fluent.getRequestTimeout());
    buildable.setScaleTimeout(fluent.getScaleTimeout());
    buildable.setLoggingInterval(fluent.getLoggingInterval());
    buildable.setImpersonateUsername(fluent.getImpersonateUsername());
    buildable.setImpersonateGroups(fluent.getImpersonateGroups());
    buildable.setImpersonateExtras(fluent.getImpersonateExtras());
    buildable.setHttp2Disable(fluent.getHttp2Disable());
    buildable.setHttpProxy(fluent.getHttpProxy());
    buildable.setHttpsProxy(fluent.getHttpsProxy());
    buildable.setProxyUsername(fluent.getProxyUsername());
    buildable.setProxyPassword(fluent.getProxyPassword());
    buildable.setNoProxy(fluent.getNoProxy());
    buildable.setUserAgent(fluent.getUserAgent());
    buildable.setTlsVersions(fluent.getTlsVersions());
    buildable.setTlsServerName(fluent.getTlsServerName());
    buildable.setOnlyHttpWatches(fluent.getOnlyHttpWatches());
    buildable.setWatchList(fluent.getWatchList());
    buildable.setCustomHeaders(fluent.getCustomHeaders());
    buildable.setAutoConfigure(fluent.getAutoConfigure());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}