package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.AuthProviderConfig;
import io.fabric8.kubernetes.api.model.NamedContext;
import io.fabric8.kubernetes.client.http.TlsVersion;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SundrioConfigFluent<A extends io.fabric8.kubernetes.client.SundrioConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties = new LinkedHashMap<String,Object>();
  private String apiVersion;
  private AuthProviderConfig authProvider;
  private Boolean autoConfigure;
  private String autoOAuthToken;
  private String caCertData;
  private String caCertFile;
  private String clientCertData;
  private String clientCertFile;
  private String clientKeyAlgo;
  private String clientKeyData;
  private String clientKeyFile;
  private String clientKeyPassphrase;
  private Integer connectionTimeout;
  private List<NamedContext> contexts = new ArrayList<NamedContext>();
  private NamedContext currentContext;
  private Map<String,String> customHeaders = new LinkedHashMap<String,String>();
  private Boolean defaultNamespace;
  private Boolean disableHostnameVerification;
  private Boolean http2Disable;
  private String httpProxy;
  private String httpsProxy;
  private Map<String,List<String>> impersonateExtras = new LinkedHashMap<String,List<String>>();
  private List<String> impersonateGroups = new ArrayList<String>();
  private String impersonateUsername;
  private String keyStoreFile;
  private String keyStorePassphrase;
  private Integer loggingInterval;
  private String masterUrl;
  private Integer maxConcurrentRequests;
  private Integer maxConcurrentRequestsPerHost;
  private String namespace;
  private List<String> noProxy = new ArrayList<String>();
  private String oauthToken;
  private OAuthTokenProvider oauthTokenProvider;
  private Boolean onlyHttpWatches;
  private String password;
  private String proxyPassword;
  private String proxyUsername;
  private Integer requestRetryBackoffInterval;
  private Integer requestRetryBackoffLimit;
  private Integer requestTimeout;
  private Long scaleTimeout;
  private String tlsServerName;
  private List<TlsVersion> tlsVersions = new ArrayList<TlsVersion>();
  private Boolean trustCerts;
  private String trustStoreFile;
  private String trustStorePassphrase;
  private Integer uploadRequestTimeout;
  private String userAgent;
  private String username;
  private Boolean watchList;
  private Integer watchReconnectInterval;
  private Integer watchReconnectLimit;
  private Long websocketPingInterval;

  public SundrioConfigFluent() {
  }
  
  public SundrioConfigFluent(SundrioConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToContexts(Collection<NamedContext> items) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    for (NamedContext item : items) {
      this.contexts.add(item);
    }
    return (A) this;
  }
  
  public A addAllToImpersonateGroups(Collection<String> items) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    for (String item : items) {
      this.impersonateGroups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNoProxy(Collection<String> items) {
    if (this.noProxy == null) {
      this.noProxy = new ArrayList();
    }
    for (String item : items) {
      this.noProxy.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTlsVersions(Collection<TlsVersion> items) {
    if (this.tlsVersions == null) {
      this.tlsVersions = new ArrayList();
    }
    for (TlsVersion item : items) {
      this.tlsVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToContexts(NamedContext... items) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    for (NamedContext item : items) {
      this.contexts.add(item);
    }
    return (A) this;
  }
  
  public A addToContexts(int index,NamedContext item) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    this.contexts.add(index, item);
    return (A) this;
  }
  
  public A addToCustomHeaders(Map<String,String> map) {
    if (this.customHeaders == null && map != null) {
      this.customHeaders = new LinkedHashMap();
    }
    if (map != null) {
      this.customHeaders.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCustomHeaders(String key,String value) {
    if (this.customHeaders == null && key != null && value != null) {
      this.customHeaders = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.customHeaders.put(key, value);
    }
    return (A) this;
  }
  
  public A addToImpersonateExtras(Map<String,List<String>> map) {
    if (this.impersonateExtras == null && map != null) {
      this.impersonateExtras = new LinkedHashMap();
    }
    if (map != null) {
      this.impersonateExtras.putAll(map);
    }
    return (A) this;
  }
  
  public A addToImpersonateExtras(String key,List<String> value) {
    if (this.impersonateExtras == null && key != null && value != null) {
      this.impersonateExtras = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.impersonateExtras.put(key, value);
    }
    return (A) this;
  }
  
  public A addToImpersonateGroups(String... items) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    for (String item : items) {
      this.impersonateGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToImpersonateGroups(int index,String item) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    this.impersonateGroups.add(index, item);
    return (A) this;
  }
  
  public A addToNoProxy(String... items) {
    if (this.noProxy == null) {
      this.noProxy = new ArrayList();
    }
    for (String item : items) {
      this.noProxy.add(item);
    }
    return (A) this;
  }
  
  public A addToNoProxy(int index,String item) {
    if (this.noProxy == null) {
      this.noProxy = new ArrayList();
    }
    this.noProxy.add(index, item);
    return (A) this;
  }
  
  public A addToTlsVersions(TlsVersion... items) {
    if (this.tlsVersions == null) {
      this.tlsVersions = new ArrayList();
    }
    for (TlsVersion item : items) {
      this.tlsVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToTlsVersions(int index,TlsVersion item) {
    if (this.tlsVersions == null) {
      this.tlsVersions = new ArrayList();
    }
    this.tlsVersions.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(SundrioConfig instance) {
    instance = instance != null ? instance : new SundrioConfig();
    if (instance != null) {
        this.withTrustCerts(instance.getTrustCerts());
        this.withDisableHostnameVerification(instance.getDisableHostnameVerification());
        this.withMasterUrl(instance.getMasterUrl());
        this.withApiVersion(instance.getApiVersion());
        this.withNamespace(instance.getNamespace());
        this.withDefaultNamespace(instance.getDefaultNamespace());
        this.withCaCertFile(instance.getCaCertFile());
        this.withCaCertData(instance.getCaCertData());
        this.withClientCertFile(instance.getClientCertFile());
        this.withClientCertData(instance.getClientCertData());
        this.withClientKeyFile(instance.getClientKeyFile());
        this.withClientKeyData(instance.getClientKeyData());
        this.withClientKeyAlgo(instance.getClientKeyAlgo());
        this.withClientKeyPassphrase(instance.getClientKeyPassphrase());
        this.withTrustStoreFile(instance.getTrustStoreFile());
        this.withTrustStorePassphrase(instance.getTrustStorePassphrase());
        this.withKeyStoreFile(instance.getKeyStoreFile());
        this.withKeyStorePassphrase(instance.getKeyStorePassphrase());
        this.withAuthProvider(instance.getAuthProvider());
        this.withUsername(instance.getUsername());
        this.withPassword(instance.getPassword());
        this.withOauthToken(instance.getOauthToken());
        this.withAutoOAuthToken(instance.getAutoOAuthToken());
        this.withOauthTokenProvider(instance.getOauthTokenProvider());
        this.withWebsocketPingInterval(instance.getWebsocketPingInterval());
        this.withConnectionTimeout(instance.getConnectionTimeout());
        this.withMaxConcurrentRequests(instance.getMaxConcurrentRequests());
        this.withMaxConcurrentRequestsPerHost(instance.getMaxConcurrentRequestsPerHost());
        this.withContexts(instance.getContexts());
        this.withCurrentContext(instance.getCurrentContext());
        this.withWatchReconnectInterval(instance.getWatchReconnectInterval());
        this.withWatchReconnectLimit(instance.getWatchReconnectLimit());
        this.withUploadRequestTimeout(instance.getUploadRequestTimeout());
        this.withRequestRetryBackoffLimit(instance.getRequestRetryBackoffLimit());
        this.withRequestRetryBackoffInterval(instance.getRequestRetryBackoffInterval());
        this.withRequestTimeout(instance.getRequestTimeout());
        this.withScaleTimeout(instance.getScaleTimeout());
        this.withLoggingInterval(instance.getLoggingInterval());
        this.withImpersonateUsername(instance.getImpersonateUsername());
        this.withImpersonateGroups(instance.getImpersonateGroups());
        this.withImpersonateExtras(instance.getImpersonateExtras());
        this.withHttp2Disable(instance.getHttp2Disable());
        this.withHttpProxy(instance.getHttpProxy());
        this.withHttpsProxy(instance.getHttpsProxy());
        this.withProxyUsername(instance.getProxyUsername());
        this.withProxyPassword(instance.getProxyPassword());
        this.withNoProxy(instance.getNoProxy());
        this.withUserAgent(instance.getUserAgent());
        this.withTlsVersions(instance.getTlsVersions());
        this.withTlsServerName(instance.getTlsServerName());
        this.withOnlyHttpWatches(instance.getOnlyHttpWatches());
        this.withWatchList(instance.getWatchList());
        this.withCustomHeaders(instance.getCustomHeaders());
        this.withAutoConfigure(instance.getAutoConfigure());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    SundrioConfigFluent that = (SundrioConfigFluent) o;
    if (!(Objects.equals(trustCerts, that.trustCerts))) {
      return false;
    }
    if (!(Objects.equals(disableHostnameVerification, that.disableHostnameVerification))) {
      return false;
    }
    if (!(Objects.equals(masterUrl, that.masterUrl))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(defaultNamespace, that.defaultNamespace))) {
      return false;
    }
    if (!(Objects.equals(caCertFile, that.caCertFile))) {
      return false;
    }
    if (!(Objects.equals(caCertData, that.caCertData))) {
      return false;
    }
    if (!(Objects.equals(clientCertFile, that.clientCertFile))) {
      return false;
    }
    if (!(Objects.equals(clientCertData, that.clientCertData))) {
      return false;
    }
    if (!(Objects.equals(clientKeyFile, that.clientKeyFile))) {
      return false;
    }
    if (!(Objects.equals(clientKeyData, that.clientKeyData))) {
      return false;
    }
    if (!(Objects.equals(clientKeyAlgo, that.clientKeyAlgo))) {
      return false;
    }
    if (!(Objects.equals(clientKeyPassphrase, that.clientKeyPassphrase))) {
      return false;
    }
    if (!(Objects.equals(trustStoreFile, that.trustStoreFile))) {
      return false;
    }
    if (!(Objects.equals(trustStorePassphrase, that.trustStorePassphrase))) {
      return false;
    }
    if (!(Objects.equals(keyStoreFile, that.keyStoreFile))) {
      return false;
    }
    if (!(Objects.equals(keyStorePassphrase, that.keyStorePassphrase))) {
      return false;
    }
    if (!(Objects.equals(authProvider, that.authProvider))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(oauthToken, that.oauthToken))) {
      return false;
    }
    if (!(Objects.equals(autoOAuthToken, that.autoOAuthToken))) {
      return false;
    }
    if (!(Objects.equals(oauthTokenProvider, that.oauthTokenProvider))) {
      return false;
    }
    if (!(Objects.equals(websocketPingInterval, that.websocketPingInterval))) {
      return false;
    }
    if (!(Objects.equals(connectionTimeout, that.connectionTimeout))) {
      return false;
    }
    if (!(Objects.equals(maxConcurrentRequests, that.maxConcurrentRequests))) {
      return false;
    }
    if (!(Objects.equals(maxConcurrentRequestsPerHost, that.maxConcurrentRequestsPerHost))) {
      return false;
    }
    if (!(Objects.equals(contexts, that.contexts))) {
      return false;
    }
    if (!(Objects.equals(currentContext, that.currentContext))) {
      return false;
    }
    if (!(Objects.equals(watchReconnectInterval, that.watchReconnectInterval))) {
      return false;
    }
    if (!(Objects.equals(watchReconnectLimit, that.watchReconnectLimit))) {
      return false;
    }
    if (!(Objects.equals(uploadRequestTimeout, that.uploadRequestTimeout))) {
      return false;
    }
    if (!(Objects.equals(requestRetryBackoffLimit, that.requestRetryBackoffLimit))) {
      return false;
    }
    if (!(Objects.equals(requestRetryBackoffInterval, that.requestRetryBackoffInterval))) {
      return false;
    }
    if (!(Objects.equals(requestTimeout, that.requestTimeout))) {
      return false;
    }
    if (!(Objects.equals(scaleTimeout, that.scaleTimeout))) {
      return false;
    }
    if (!(Objects.equals(loggingInterval, that.loggingInterval))) {
      return false;
    }
    if (!(Objects.equals(impersonateUsername, that.impersonateUsername))) {
      return false;
    }
    if (!(Objects.equals(impersonateGroups, that.impersonateGroups))) {
      return false;
    }
    if (!(Objects.equals(impersonateExtras, that.impersonateExtras))) {
      return false;
    }
    if (!(Objects.equals(http2Disable, that.http2Disable))) {
      return false;
    }
    if (!(Objects.equals(httpProxy, that.httpProxy))) {
      return false;
    }
    if (!(Objects.equals(httpsProxy, that.httpsProxy))) {
      return false;
    }
    if (!(Objects.equals(proxyUsername, that.proxyUsername))) {
      return false;
    }
    if (!(Objects.equals(proxyPassword, that.proxyPassword))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(userAgent, that.userAgent))) {
      return false;
    }
    if (!(Objects.equals(tlsVersions, that.tlsVersions))) {
      return false;
    }
    if (!(Objects.equals(tlsServerName, that.tlsServerName))) {
      return false;
    }
    if (!(Objects.equals(onlyHttpWatches, that.onlyHttpWatches))) {
      return false;
    }
    if (!(Objects.equals(watchList, that.watchList))) {
      return false;
    }
    if (!(Objects.equals(customHeaders, that.customHeaders))) {
      return false;
    }
    if (!(Objects.equals(autoConfigure, that.autoConfigure))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public AuthProviderConfig getAuthProvider() {
    return this.authProvider;
  }
  
  public Boolean getAutoConfigure() {
    return this.autoConfigure;
  }
  
  public String getAutoOAuthToken() {
    return this.autoOAuthToken;
  }
  
  public String getCaCertData() {
    return this.caCertData;
  }
  
  public String getCaCertFile() {
    return this.caCertFile;
  }
  
  public String getClientCertData() {
    return this.clientCertData;
  }
  
  public String getClientCertFile() {
    return this.clientCertFile;
  }
  
  public String getClientKeyAlgo() {
    return this.clientKeyAlgo;
  }
  
  public String getClientKeyData() {
    return this.clientKeyData;
  }
  
  public String getClientKeyFile() {
    return this.clientKeyFile;
  }
  
  public String getClientKeyPassphrase() {
    return this.clientKeyPassphrase;
  }
  
  public Integer getConnectionTimeout() {
    return this.connectionTimeout;
  }
  
  public NamedContext getContext(int index) {
    return this.contexts.get(index);
  }
  
  public List<NamedContext> getContexts() {
    return this.contexts;
  }
  
  public NamedContext getCurrentContext() {
    return this.currentContext;
  }
  
  public Map<String,String> getCustomHeaders() {
    return this.customHeaders;
  }
  
  public Boolean getDefaultNamespace() {
    return this.defaultNamespace;
  }
  
  public Boolean getDisableHostnameVerification() {
    return this.disableHostnameVerification;
  }
  
  public NamedContext getFirstContext() {
    return this.contexts.get(0);
  }
  
  public Boolean getHttp2Disable() {
    return this.http2Disable;
  }
  
  public String getHttpProxy() {
    return this.httpProxy;
  }
  
  public String getHttpsProxy() {
    return this.httpsProxy;
  }
  
  public Map<String,List<String>> getImpersonateExtras() {
    return this.impersonateExtras;
  }
  
  public String[] getImpersonateGroups() {
    int size = impersonateGroups != null ? impersonateGroups.size() : 0;
    String[] result = new String[size];
    if (size == 0) {
      return result;
    }
    int index = 0;
    for (String item : impersonateGroups) {
      result[index++] = item;
    }
    return result;
  }
  
  public String getImpersonateUsername() {
    return this.impersonateUsername;
  }
  
  public String getKeyStoreFile() {
    return this.keyStoreFile;
  }
  
  public String getKeyStorePassphrase() {
    return this.keyStorePassphrase;
  }
  
  public NamedContext getLastContext() {
    return this.contexts.get(contexts.size() - 1);
  }
  
  public Integer getLoggingInterval() {
    return this.loggingInterval;
  }
  
  public String getMasterUrl() {
    return this.masterUrl;
  }
  
  public NamedContext getMatchingContext(Predicate<NamedContext> predicate) {
      for (NamedContext item : contexts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMaxConcurrentRequests() {
    return this.maxConcurrentRequests;
  }
  
  public Integer getMaxConcurrentRequestsPerHost() {
    return this.maxConcurrentRequestsPerHost;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public String[] getNoProxy() {
    int size = noProxy != null ? noProxy.size() : 0;
    String[] result = new String[size];
    if (size == 0) {
      return result;
    }
    int index = 0;
    for (String item : noProxy) {
      result[index++] = item;
    }
    return result;
  }
  
  public String getOauthToken() {
    return this.oauthToken;
  }
  
  public OAuthTokenProvider getOauthTokenProvider() {
    return this.oauthTokenProvider;
  }
  
  public Boolean getOnlyHttpWatches() {
    return this.onlyHttpWatches;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public String getProxyPassword() {
    return this.proxyPassword;
  }
  
  public String getProxyUsername() {
    return this.proxyUsername;
  }
  
  public Integer getRequestRetryBackoffInterval() {
    return this.requestRetryBackoffInterval;
  }
  
  public Integer getRequestRetryBackoffLimit() {
    return this.requestRetryBackoffLimit;
  }
  
  public Integer getRequestTimeout() {
    return this.requestTimeout;
  }
  
  public Long getScaleTimeout() {
    return this.scaleTimeout;
  }
  
  public String getTlsServerName() {
    return this.tlsServerName;
  }
  
  public TlsVersion[] getTlsVersions() {
    int size = tlsVersions != null ? tlsVersions.size() : 0;
    TlsVersion[] result = new TlsVersion[size];
    if (size == 0) {
      return result;
    }
    int index = 0;
    for (TlsVersion item : tlsVersions) {
      result[index++] = item;
    }
    return result;
  }
  
  public Boolean getTrustCerts() {
    return this.trustCerts;
  }
  
  public String getTrustStoreFile() {
    return this.trustStoreFile;
  }
  
  public String getTrustStorePassphrase() {
    return this.trustStorePassphrase;
  }
  
  public Integer getUploadRequestTimeout() {
    return this.uploadRequestTimeout;
  }
  
  public String getUserAgent() {
    return this.userAgent;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public Boolean getWatchList() {
    return this.watchList;
  }
  
  public Integer getWatchReconnectInterval() {
    return this.watchReconnectInterval;
  }
  
  public Integer getWatchReconnectLimit() {
    return this.watchReconnectLimit;
  }
  
  public Long getWebsocketPingInterval() {
    return this.websocketPingInterval;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasAuthProvider() {
    return this.authProvider != null;
  }
  
  public boolean hasAutoConfigure() {
    return this.autoConfigure != null;
  }
  
  public boolean hasAutoOAuthToken() {
    return this.autoOAuthToken != null;
  }
  
  public boolean hasCaCertData() {
    return this.caCertData != null;
  }
  
  public boolean hasCaCertFile() {
    return this.caCertFile != null;
  }
  
  public boolean hasClientCertData() {
    return this.clientCertData != null;
  }
  
  public boolean hasClientCertFile() {
    return this.clientCertFile != null;
  }
  
  public boolean hasClientKeyAlgo() {
    return this.clientKeyAlgo != null;
  }
  
  public boolean hasClientKeyData() {
    return this.clientKeyData != null;
  }
  
  public boolean hasClientKeyFile() {
    return this.clientKeyFile != null;
  }
  
  public boolean hasClientKeyPassphrase() {
    return this.clientKeyPassphrase != null;
  }
  
  public boolean hasConnectionTimeout() {
    return this.connectionTimeout != null;
  }
  
  public boolean hasContexts() {
    return this.contexts != null && !(this.contexts.isEmpty());
  }
  
  public boolean hasCurrentContext() {
    return this.currentContext != null;
  }
  
  public boolean hasCustomHeaders() {
    return this.customHeaders != null;
  }
  
  public boolean hasDefaultNamespace() {
    return this.defaultNamespace != null;
  }
  
  public boolean hasDisableHostnameVerification() {
    return this.disableHostnameVerification != null;
  }
  
  public boolean hasHttp2Disable() {
    return this.http2Disable != null;
  }
  
  public boolean hasHttpProxy() {
    return this.httpProxy != null;
  }
  
  public boolean hasHttpsProxy() {
    return this.httpsProxy != null;
  }
  
  public boolean hasImpersonateExtras() {
    return this.impersonateExtras != null;
  }
  
  public boolean hasImpersonateGroups() {
    return this.impersonateGroups != null && !(this.impersonateGroups.isEmpty());
  }
  
  public boolean hasImpersonateUsername() {
    return this.impersonateUsername != null;
  }
  
  public boolean hasKeyStoreFile() {
    return this.keyStoreFile != null;
  }
  
  public boolean hasKeyStorePassphrase() {
    return this.keyStorePassphrase != null;
  }
  
  public boolean hasLoggingInterval() {
    return this.loggingInterval != null;
  }
  
  public boolean hasMasterUrl() {
    return this.masterUrl != null;
  }
  
  public boolean hasMatchingContext(Predicate<NamedContext> predicate) {
      for (NamedContext item : contexts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxConcurrentRequests() {
    return this.maxConcurrentRequests != null;
  }
  
  public boolean hasMaxConcurrentRequestsPerHost() {
    return this.maxConcurrentRequestsPerHost != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null && !(this.noProxy.isEmpty());
  }
  
  public boolean hasOauthToken() {
    return this.oauthToken != null;
  }
  
  public boolean hasOauthTokenProvider() {
    return this.oauthTokenProvider != null;
  }
  
  public boolean hasOnlyHttpWatches() {
    return this.onlyHttpWatches != null;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasProxyPassword() {
    return this.proxyPassword != null;
  }
  
  public boolean hasProxyUsername() {
    return this.proxyUsername != null;
  }
  
  public boolean hasRequestRetryBackoffInterval() {
    return this.requestRetryBackoffInterval != null;
  }
  
  public boolean hasRequestRetryBackoffLimit() {
    return this.requestRetryBackoffLimit != null;
  }
  
  public boolean hasRequestTimeout() {
    return this.requestTimeout != null;
  }
  
  public boolean hasScaleTimeout() {
    return this.scaleTimeout != null;
  }
  
  public boolean hasTlsServerName() {
    return this.tlsServerName != null;
  }
  
  public boolean hasTlsVersions() {
    return this.tlsVersions != null && !(this.tlsVersions.isEmpty());
  }
  
  public boolean hasTrustCerts() {
    return this.trustCerts != null;
  }
  
  public boolean hasTrustStoreFile() {
    return this.trustStoreFile != null;
  }
  
  public boolean hasTrustStorePassphrase() {
    return this.trustStorePassphrase != null;
  }
  
  public boolean hasUploadRequestTimeout() {
    return this.uploadRequestTimeout != null;
  }
  
  public boolean hasUserAgent() {
    return this.userAgent != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public boolean hasWatchList() {
    return this.watchList != null;
  }
  
  public boolean hasWatchReconnectInterval() {
    return this.watchReconnectInterval != null;
  }
  
  public boolean hasWatchReconnectLimit() {
    return this.watchReconnectLimit != null;
  }
  
  public boolean hasWebsocketPingInterval() {
    return this.websocketPingInterval != null;
  }
  
  public int hashCode() {
    return Objects.hash(trustCerts, disableHostnameVerification, masterUrl, apiVersion, namespace, defaultNamespace, caCertFile, caCertData, clientCertFile, clientCertData, clientKeyFile, clientKeyData, clientKeyAlgo, clientKeyPassphrase, trustStoreFile, trustStorePassphrase, keyStoreFile, keyStorePassphrase, authProvider, username, password, oauthToken, autoOAuthToken, oauthTokenProvider, websocketPingInterval, connectionTimeout, maxConcurrentRequests, maxConcurrentRequestsPerHost, contexts, currentContext, watchReconnectInterval, watchReconnectLimit, uploadRequestTimeout, requestRetryBackoffLimit, requestRetryBackoffInterval, requestTimeout, scaleTimeout, loggingInterval, impersonateUsername, impersonateGroups, impersonateExtras, http2Disable, httpProxy, httpsProxy, proxyUsername, proxyPassword, noProxy, userAgent, tlsVersions, tlsServerName, onlyHttpWatches, watchList, customHeaders, autoConfigure, additionalProperties);
  }
  
  public A removeAllFromContexts(Collection<NamedContext> items) {
    if (this.contexts == null) {
      return (A) this;
    }
    for (NamedContext item : items) {
      this.contexts.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromImpersonateGroups(Collection<String> items) {
    if (this.impersonateGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.impersonateGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNoProxy(Collection<String> items) {
    if (this.noProxy == null) {
      return (A) this;
    }
    for (String item : items) {
      this.noProxy.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTlsVersions(Collection<TlsVersion> items) {
    if (this.tlsVersions == null) {
      return (A) this;
    }
    for (TlsVersion item : items) {
      this.tlsVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromContexts(NamedContext... items) {
    if (this.contexts == null) {
      return (A) this;
    }
    for (NamedContext item : items) {
      this.contexts.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCustomHeaders(String key) {
    if (this.customHeaders == null) {
      return (A) this;
    }
    if (key != null && this.customHeaders != null) {
      this.customHeaders.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCustomHeaders(Map<String,String> map) {
    if (this.customHeaders == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.customHeaders != null) {
          this.customHeaders.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromImpersonateExtras(String key) {
    if (this.impersonateExtras == null) {
      return (A) this;
    }
    if (key != null && this.impersonateExtras != null) {
      this.impersonateExtras.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromImpersonateExtras(Map<String,List<String>> map) {
    if (this.impersonateExtras == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.impersonateExtras != null) {
          this.impersonateExtras.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromImpersonateGroups(String... items) {
    if (this.impersonateGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.impersonateGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNoProxy(String... items) {
    if (this.noProxy == null) {
      return (A) this;
    }
    for (String item : items) {
      this.noProxy.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTlsVersions(TlsVersion... items) {
    if (this.tlsVersions == null) {
      return (A) this;
    }
    for (TlsVersion item : items) {
      this.tlsVersions.remove(item);
    }
    return (A) this;
  }
  
  public A setToContexts(int index,NamedContext item) {
    if (this.contexts == null) {
      this.contexts = new ArrayList();
    }
    this.contexts.set(index, item);
    return (A) this;
  }
  
  public A setToImpersonateGroups(int index,String item) {
    if (this.impersonateGroups == null) {
      this.impersonateGroups = new ArrayList();
    }
    this.impersonateGroups.set(index, item);
    return (A) this;
  }
  
  public A setToNoProxy(int index,String item) {
    if (this.noProxy == null) {
      this.noProxy = new ArrayList();
    }
    this.noProxy.set(index, item);
    return (A) this;
  }
  
  public A setToTlsVersions(int index,TlsVersion item) {
    if (this.tlsVersions == null) {
      this.tlsVersions = new ArrayList();
    }
    this.tlsVersions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(trustCerts == null)) {
        sb.append("trustCerts:");
        sb.append(trustCerts);
        sb.append(",");
    }
    if (!(disableHostnameVerification == null)) {
        sb.append("disableHostnameVerification:");
        sb.append(disableHostnameVerification);
        sb.append(",");
    }
    if (!(masterUrl == null)) {
        sb.append("masterUrl:");
        sb.append(masterUrl);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(defaultNamespace == null)) {
        sb.append("defaultNamespace:");
        sb.append(defaultNamespace);
        sb.append(",");
    }
    if (!(caCertFile == null)) {
        sb.append("caCertFile:");
        sb.append(caCertFile);
        sb.append(",");
    }
    if (!(caCertData == null)) {
        sb.append("caCertData:");
        sb.append(caCertData);
        sb.append(",");
    }
    if (!(clientCertFile == null)) {
        sb.append("clientCertFile:");
        sb.append(clientCertFile);
        sb.append(",");
    }
    if (!(clientCertData == null)) {
        sb.append("clientCertData:");
        sb.append(clientCertData);
        sb.append(",");
    }
    if (!(clientKeyFile == null)) {
        sb.append("clientKeyFile:");
        sb.append(clientKeyFile);
        sb.append(",");
    }
    if (!(clientKeyData == null)) {
        sb.append("clientKeyData:");
        sb.append(clientKeyData);
        sb.append(",");
    }
    if (!(clientKeyAlgo == null)) {
        sb.append("clientKeyAlgo:");
        sb.append(clientKeyAlgo);
        sb.append(",");
    }
    if (!(clientKeyPassphrase == null)) {
        sb.append("clientKeyPassphrase:");
        sb.append(clientKeyPassphrase);
        sb.append(",");
    }
    if (!(trustStoreFile == null)) {
        sb.append("trustStoreFile:");
        sb.append(trustStoreFile);
        sb.append(",");
    }
    if (!(trustStorePassphrase == null)) {
        sb.append("trustStorePassphrase:");
        sb.append(trustStorePassphrase);
        sb.append(",");
    }
    if (!(keyStoreFile == null)) {
        sb.append("keyStoreFile:");
        sb.append(keyStoreFile);
        sb.append(",");
    }
    if (!(keyStorePassphrase == null)) {
        sb.append("keyStorePassphrase:");
        sb.append(keyStorePassphrase);
        sb.append(",");
    }
    if (!(authProvider == null)) {
        sb.append("authProvider:");
        sb.append(authProvider);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(oauthToken == null)) {
        sb.append("oauthToken:");
        sb.append(oauthToken);
        sb.append(",");
    }
    if (!(autoOAuthToken == null)) {
        sb.append("autoOAuthToken:");
        sb.append(autoOAuthToken);
        sb.append(",");
    }
    if (!(oauthTokenProvider == null)) {
        sb.append("oauthTokenProvider:");
        sb.append(oauthTokenProvider);
        sb.append(",");
    }
    if (!(websocketPingInterval == null)) {
        sb.append("websocketPingInterval:");
        sb.append(websocketPingInterval);
        sb.append(",");
    }
    if (!(connectionTimeout == null)) {
        sb.append("connectionTimeout:");
        sb.append(connectionTimeout);
        sb.append(",");
    }
    if (!(maxConcurrentRequests == null)) {
        sb.append("maxConcurrentRequests:");
        sb.append(maxConcurrentRequests);
        sb.append(",");
    }
    if (!(maxConcurrentRequestsPerHost == null)) {
        sb.append("maxConcurrentRequestsPerHost:");
        sb.append(maxConcurrentRequestsPerHost);
        sb.append(",");
    }
    if (!(contexts == null) && !(contexts.isEmpty())) {
        sb.append("contexts:");
        sb.append(contexts);
        sb.append(",");
    }
    if (!(currentContext == null)) {
        sb.append("currentContext:");
        sb.append(currentContext);
        sb.append(",");
    }
    if (!(watchReconnectInterval == null)) {
        sb.append("watchReconnectInterval:");
        sb.append(watchReconnectInterval);
        sb.append(",");
    }
    if (!(watchReconnectLimit == null)) {
        sb.append("watchReconnectLimit:");
        sb.append(watchReconnectLimit);
        sb.append(",");
    }
    if (!(uploadRequestTimeout == null)) {
        sb.append("uploadRequestTimeout:");
        sb.append(uploadRequestTimeout);
        sb.append(",");
    }
    if (!(requestRetryBackoffLimit == null)) {
        sb.append("requestRetryBackoffLimit:");
        sb.append(requestRetryBackoffLimit);
        sb.append(",");
    }
    if (!(requestRetryBackoffInterval == null)) {
        sb.append("requestRetryBackoffInterval:");
        sb.append(requestRetryBackoffInterval);
        sb.append(",");
    }
    if (!(requestTimeout == null)) {
        sb.append("requestTimeout:");
        sb.append(requestTimeout);
        sb.append(",");
    }
    if (!(scaleTimeout == null)) {
        sb.append("scaleTimeout:");
        sb.append(scaleTimeout);
        sb.append(",");
    }
    if (!(loggingInterval == null)) {
        sb.append("loggingInterval:");
        sb.append(loggingInterval);
        sb.append(",");
    }
    if (!(impersonateUsername == null)) {
        sb.append("impersonateUsername:");
        sb.append(impersonateUsername);
        sb.append(",");
    }
    if (!(impersonateGroups == null) && !(impersonateGroups.isEmpty())) {
        sb.append("impersonateGroups:");
        sb.append(impersonateGroups);
        sb.append(",");
    }
    if (!(impersonateExtras == null) && !(impersonateExtras.isEmpty())) {
        sb.append("impersonateExtras:");
        sb.append(impersonateExtras);
        sb.append(",");
    }
    if (!(http2Disable == null)) {
        sb.append("http2Disable:");
        sb.append(http2Disable);
        sb.append(",");
    }
    if (!(httpProxy == null)) {
        sb.append("httpProxy:");
        sb.append(httpProxy);
        sb.append(",");
    }
    if (!(httpsProxy == null)) {
        sb.append("httpsProxy:");
        sb.append(httpsProxy);
        sb.append(",");
    }
    if (!(proxyUsername == null)) {
        sb.append("proxyUsername:");
        sb.append(proxyUsername);
        sb.append(",");
    }
    if (!(proxyPassword == null)) {
        sb.append("proxyPassword:");
        sb.append(proxyPassword);
        sb.append(",");
    }
    if (!(noProxy == null) && !(noProxy.isEmpty())) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(userAgent == null)) {
        sb.append("userAgent:");
        sb.append(userAgent);
        sb.append(",");
    }
    if (!(tlsVersions == null) && !(tlsVersions.isEmpty())) {
        sb.append("tlsVersions:");
        sb.append(tlsVersions);
        sb.append(",");
    }
    if (!(tlsServerName == null)) {
        sb.append("tlsServerName:");
        sb.append(tlsServerName);
        sb.append(",");
    }
    if (!(onlyHttpWatches == null)) {
        sb.append("onlyHttpWatches:");
        sb.append(onlyHttpWatches);
        sb.append(",");
    }
    if (!(watchList == null)) {
        sb.append("watchList:");
        sb.append(watchList);
        sb.append(",");
    }
    if (!(customHeaders == null) && !(customHeaders.isEmpty())) {
        sb.append("customHeaders:");
        sb.append(customHeaders);
        sb.append(",");
    }
    if (!(autoConfigure == null)) {
        sb.append("autoConfigure:");
        sb.append(autoConfigure);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withAuthProvider(AuthProviderConfig authProvider) {
    this.authProvider = authProvider;
    return (A) this;
  }
  
  public A withAutoConfigure() {
    return withAutoConfigure(true);
  }
  
  public A withAutoConfigure(Boolean autoConfigure) {
    this.autoConfigure = autoConfigure;
    return (A) this;
  }
  
  public A withAutoOAuthToken(String autoOAuthToken) {
    this.autoOAuthToken = autoOAuthToken;
    return (A) this;
  }
  
  public A withCaCertData(String caCertData) {
    this.caCertData = caCertData;
    return (A) this;
  }
  
  public A withCaCertFile(String caCertFile) {
    this.caCertFile = caCertFile;
    return (A) this;
  }
  
  public A withClientCertData(String clientCertData) {
    this.clientCertData = clientCertData;
    return (A) this;
  }
  
  public A withClientCertFile(String clientCertFile) {
    this.clientCertFile = clientCertFile;
    return (A) this;
  }
  
  public A withClientKeyAlgo(String clientKeyAlgo) {
    this.clientKeyAlgo = clientKeyAlgo;
    return (A) this;
  }
  
  public A withClientKeyData(String clientKeyData) {
    this.clientKeyData = clientKeyData;
    return (A) this;
  }
  
  public A withClientKeyFile(String clientKeyFile) {
    this.clientKeyFile = clientKeyFile;
    return (A) this;
  }
  
  public A withClientKeyPassphrase(String clientKeyPassphrase) {
    this.clientKeyPassphrase = clientKeyPassphrase;
    return (A) this;
  }
  
  public A withConnectionTimeout(Integer connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
    return (A) this;
  }
  
  public A withContexts(List<NamedContext> contexts) {
    if (contexts != null) {
        this.contexts = new ArrayList();
        for (NamedContext item : contexts) {
          this.addToContexts(item);
        }
    } else {
      this.contexts = null;
    }
    return (A) this;
  }
  
  public A withContexts(NamedContext... contexts) {
    if (this.contexts != null) {
        this.contexts.clear();
        _visitables.remove("contexts");
    }
    if (contexts != null) {
      for (NamedContext item : contexts) {
        this.addToContexts(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentContext(NamedContext currentContext) {
    this.currentContext = currentContext;
    return (A) this;
  }
  
  public <K,V>A withCustomHeaders(Map<String,String> customHeaders) {
    if (customHeaders == null) {
      this.customHeaders = null;
    } else {
      this.customHeaders = new LinkedHashMap(customHeaders);
    }
    return (A) this;
  }
  
  public A withDefaultNamespace() {
    return withDefaultNamespace(true);
  }
  
  public A withDefaultNamespace(Boolean defaultNamespace) {
    this.defaultNamespace = defaultNamespace;
    return (A) this;
  }
  
  public A withDisableHostnameVerification() {
    return withDisableHostnameVerification(true);
  }
  
  public A withDisableHostnameVerification(Boolean disableHostnameVerification) {
    this.disableHostnameVerification = disableHostnameVerification;
    return (A) this;
  }
  
  public A withHttp2Disable() {
    return withHttp2Disable(true);
  }
  
  public A withHttp2Disable(Boolean http2Disable) {
    this.http2Disable = http2Disable;
    return (A) this;
  }
  
  public A withHttpProxy(String httpProxy) {
    this.httpProxy = httpProxy;
    return (A) this;
  }
  
  public A withHttpsProxy(String httpsProxy) {
    this.httpsProxy = httpsProxy;
    return (A) this;
  }
  
  public <K,V>A withImpersonateExtras(Map<String,List<String>> impersonateExtras) {
    if (impersonateExtras == null) {
      this.impersonateExtras = null;
    } else {
      this.impersonateExtras = new LinkedHashMap(impersonateExtras);
    }
    return (A) this;
  }
  
  public A withImpersonateGroups(String... impersonateGroups) {
    if (this.impersonateGroups != null) {
        this.impersonateGroups.clear();
        _visitables.remove("impersonateGroups");
    }
    if (impersonateGroups != null) {
      for (String item : impersonateGroups) {
        this.addToImpersonateGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withImpersonateUsername(String impersonateUsername) {
    this.impersonateUsername = impersonateUsername;
    return (A) this;
  }
  
  public A withKeyStoreFile(String keyStoreFile) {
    this.keyStoreFile = keyStoreFile;
    return (A) this;
  }
  
  public A withKeyStorePassphrase(String keyStorePassphrase) {
    this.keyStorePassphrase = keyStorePassphrase;
    return (A) this;
  }
  
  public A withLoggingInterval(Integer loggingInterval) {
    this.loggingInterval = loggingInterval;
    return (A) this;
  }
  
  public A withMasterUrl(String masterUrl) {
    this.masterUrl = masterUrl;
    return (A) this;
  }
  
  public A withMaxConcurrentRequests(Integer maxConcurrentRequests) {
    this.maxConcurrentRequests = maxConcurrentRequests;
    return (A) this;
  }
  
  public A withMaxConcurrentRequestsPerHost(Integer maxConcurrentRequestsPerHost) {
    this.maxConcurrentRequestsPerHost = maxConcurrentRequestsPerHost;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withNoProxy(String... noProxy) {
    if (this.noProxy != null) {
        this.noProxy.clear();
        _visitables.remove("noProxy");
    }
    if (noProxy != null) {
      for (String item : noProxy) {
        this.addToNoProxy(item);
      }
    }
    return (A) this;
  }
  
  public A withOauthToken(String oauthToken) {
    this.oauthToken = oauthToken;
    return (A) this;
  }
  
  public A withOauthTokenProvider(OAuthTokenProvider oauthTokenProvider) {
    this.oauthTokenProvider = oauthTokenProvider;
    return (A) this;
  }
  
  public A withOnlyHttpWatches() {
    return withOnlyHttpWatches(true);
  }
  
  public A withOnlyHttpWatches(Boolean onlyHttpWatches) {
    this.onlyHttpWatches = onlyHttpWatches;
    return (A) this;
  }
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withProxyPassword(String proxyPassword) {
    this.proxyPassword = proxyPassword;
    return (A) this;
  }
  
  public A withProxyUsername(String proxyUsername) {
    this.proxyUsername = proxyUsername;
    return (A) this;
  }
  
  public A withRequestRetryBackoffInterval(Integer requestRetryBackoffInterval) {
    this.requestRetryBackoffInterval = requestRetryBackoffInterval;
    return (A) this;
  }
  
  public A withRequestRetryBackoffLimit(Integer requestRetryBackoffLimit) {
    this.requestRetryBackoffLimit = requestRetryBackoffLimit;
    return (A) this;
  }
  
  public A withRequestTimeout(Integer requestTimeout) {
    this.requestTimeout = requestTimeout;
    return (A) this;
  }
  
  public A withScaleTimeout(Long scaleTimeout) {
    this.scaleTimeout = scaleTimeout;
    return (A) this;
  }
  
  public A withTlsServerName(String tlsServerName) {
    this.tlsServerName = tlsServerName;
    return (A) this;
  }
  
  public A withTlsVersions(TlsVersion... tlsVersions) {
    if (this.tlsVersions != null) {
        this.tlsVersions.clear();
        _visitables.remove("tlsVersions");
    }
    if (tlsVersions != null) {
      for (TlsVersion item : tlsVersions) {
        this.addToTlsVersions(item);
      }
    }
    return (A) this;
  }
  
  public A withTrustCerts() {
    return withTrustCerts(true);
  }
  
  public A withTrustCerts(Boolean trustCerts) {
    this.trustCerts = trustCerts;
    return (A) this;
  }
  
  public A withTrustStoreFile(String trustStoreFile) {
    this.trustStoreFile = trustStoreFile;
    return (A) this;
  }
  
  public A withTrustStorePassphrase(String trustStorePassphrase) {
    this.trustStorePassphrase = trustStorePassphrase;
    return (A) this;
  }
  
  public A withUploadRequestTimeout(Integer uploadRequestTimeout) {
    this.uploadRequestTimeout = uploadRequestTimeout;
    return (A) this;
  }
  
  public A withUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  
  public A withWatchList() {
    return withWatchList(true);
  }
  
  public A withWatchList(Boolean watchList) {
    this.watchList = watchList;
    return (A) this;
  }
  
  public A withWatchReconnectInterval(Integer watchReconnectInterval) {
    this.watchReconnectInterval = watchReconnectInterval;
    return (A) this;
  }
  
  public A withWatchReconnectLimit(Integer watchReconnectLimit) {
    this.watchReconnectLimit = watchReconnectLimit;
    return (A) this;
  }
  
  public A withWebsocketPingInterval(Long websocketPingInterval) {
    this.websocketPingInterval = websocketPingInterval;
    return (A) this;
  }
  
}