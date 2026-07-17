package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuth;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuthBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.BasicAuthFluent;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2Builder;
import io.fabric8.openshift.api.model.monitoring.v1.OAuth2Fluent;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorization;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorizationBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeAuthorizationFluent;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfig;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigBuilder;
import io.fabric8.openshift.api.model.monitoring.v1.SafeTLSConfigFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AzureSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.AzureSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authenticationMethod;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private String clientID;
  private SecretKeySelector clientSecret;
  private Boolean enableHTTP2;
  private String environment;
  private Boolean followRedirects;
  private String noProxy;
  private OAuth2Builder oauth2;
  private Integer port;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private String refreshInterval;
  private String resourceGroup;
  private String subscriptionID;
  private String tenantID;
  private SafeTLSConfigBuilder tlsConfig;

  public AzureSDConfigFluent() {
  }
  
  public AzureSDConfigFluent(AzureSDConfig instance) {
    this.copyInstance(instance);
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
  
  public A addToProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null && map != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (map != null) {
      this.proxyConnectHeader.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProxyConnectHeader(String key,List<SecretKeySelector> value) {
    if (this.proxyConnectHeader == null && key != null && value != null) {
      this.proxyConnectHeader = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.proxyConnectHeader.put(key, value);
    }
    return (A) this;
  }
  
  public SafeAuthorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(AzureSDConfig instance) {
    instance = instance != null ? instance : new AzureSDConfig();
    if (instance != null) {
        this.withAuthenticationMethod(instance.getAuthenticationMethod());
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withClientID(instance.getClientID());
        this.withClientSecret(instance.getClientSecret());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withEnvironment(instance.getEnvironment());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withNoProxy(instance.getNoProxy());
        this.withOauth2(instance.getOauth2());
        this.withPort(instance.getPort());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withResourceGroup(instance.getResourceGroup());
        this.withSubscriptionID(instance.getSubscriptionID());
        this.withTenantID(instance.getTenantID());
        this.withTlsConfig(instance.getTlsConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuthorizationNested<A> editAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(null));
  }
  
  public BasicAuthNested<A> editBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(null));
  }
  
  public Oauth2Nested<A> editOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(null));
  }
  
  public AuthorizationNested<A> editOrNewAuthorization() {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new SafeAuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(SafeAuthorization item) {
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(item));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuth() {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(new BasicAuthBuilder().build()));
  }
  
  public BasicAuthNested<A> editOrNewBasicAuthLike(BasicAuth item) {
    return this.withNewBasicAuthLike(Optional.ofNullable(this.buildBasicAuth()).orElse(item));
  }
  
  public Oauth2Nested<A> editOrNewOauth2() {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(new OAuth2Builder().build()));
  }
  
  public Oauth2Nested<A> editOrNewOauth2Like(OAuth2 item) {
    return this.withNewOauth2Like(Optional.ofNullable(this.buildOauth2()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public TlsConfigNested<A> editTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(null));
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
    AzureSDConfigFluent that = (AzureSDConfigFluent) o;
    if (!(Objects.equals(authenticationMethod, that.authenticationMethod))) {
      return false;
    }
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(clientID, that.clientID))) {
      return false;
    }
    if (!(Objects.equals(clientSecret, that.clientSecret))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(environment, that.environment))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(proxyConnectHeader, that.proxyConnectHeader))) {
      return false;
    }
    if (!(Objects.equals(proxyFromEnvironment, that.proxyFromEnvironment))) {
      return false;
    }
    if (!(Objects.equals(proxyUrl, that.proxyUrl))) {
      return false;
    }
    if (!(Objects.equals(refreshInterval, that.refreshInterval))) {
      return false;
    }
    if (!(Objects.equals(resourceGroup, that.resourceGroup))) {
      return false;
    }
    if (!(Objects.equals(subscriptionID, that.subscriptionID))) {
      return false;
    }
    if (!(Objects.equals(tenantID, that.tenantID))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
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
  
  public String getAuthenticationMethod() {
    return this.authenticationMethod;
  }
  
  public String getClientID() {
    return this.clientID;
  }
  
  public SecretKeySelector getClientSecret() {
    return this.clientSecret;
  }
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public String getEnvironment() {
    return this.environment;
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public Map<String,List<SecretKeySelector>> getProxyConnectHeader() {
    return this.proxyConnectHeader;
  }
  
  public Boolean getProxyFromEnvironment() {
    return this.proxyFromEnvironment;
  }
  
  public String getProxyUrl() {
    return this.proxyUrl;
  }
  
  public String getRefreshInterval() {
    return this.refreshInterval;
  }
  
  public String getResourceGroup() {
    return this.resourceGroup;
  }
  
  public String getSubscriptionID() {
    return this.subscriptionID;
  }
  
  public String getTenantID() {
    return this.tenantID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthenticationMethod() {
    return this.authenticationMethod != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasClientID() {
    return this.clientID != null;
  }
  
  public boolean hasClientSecret() {
    return this.clientSecret != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasEnvironment() {
    return this.environment != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasProxyConnectHeader() {
    return this.proxyConnectHeader != null;
  }
  
  public boolean hasProxyFromEnvironment() {
    return this.proxyFromEnvironment != null;
  }
  
  public boolean hasProxyUrl() {
    return this.proxyUrl != null;
  }
  
  public boolean hasRefreshInterval() {
    return this.refreshInterval != null;
  }
  
  public boolean hasResourceGroup() {
    return this.resourceGroup != null;
  }
  
  public boolean hasSubscriptionID() {
    return this.subscriptionID != null;
  }
  
  public boolean hasTenantID() {
    return this.tenantID != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(authenticationMethod, authorization, basicAuth, clientID, clientSecret, enableHTTP2, environment, followRedirects, noProxy, oauth2, port, proxyConnectHeader, proxyFromEnvironment, proxyUrl, refreshInterval, resourceGroup, subscriptionID, tenantID, tlsConfig, additionalProperties);
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
  
  public A removeFromProxyConnectHeader(String key) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (key != null && this.proxyConnectHeader != null) {
      this.proxyConnectHeader.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProxyConnectHeader(Map<String,List<SecretKeySelector>> map) {
    if (this.proxyConnectHeader == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.proxyConnectHeader != null) {
          this.proxyConnectHeader.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authenticationMethod == null)) {
        sb.append("authenticationMethod:");
        sb.append(authenticationMethod);
        sb.append(",");
    }
    if (!(authorization == null)) {
        sb.append("authorization:");
        sb.append(authorization);
        sb.append(",");
    }
    if (!(basicAuth == null)) {
        sb.append("basicAuth:");
        sb.append(basicAuth);
        sb.append(",");
    }
    if (!(clientID == null)) {
        sb.append("clientID:");
        sb.append(clientID);
        sb.append(",");
    }
    if (!(clientSecret == null)) {
        sb.append("clientSecret:");
        sb.append(clientSecret);
        sb.append(",");
    }
    if (!(enableHTTP2 == null)) {
        sb.append("enableHTTP2:");
        sb.append(enableHTTP2);
        sb.append(",");
    }
    if (!(environment == null)) {
        sb.append("environment:");
        sb.append(environment);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(oauth2 == null)) {
        sb.append("oauth2:");
        sb.append(oauth2);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(proxyConnectHeader == null) && !(proxyConnectHeader.isEmpty())) {
        sb.append("proxyConnectHeader:");
        sb.append(proxyConnectHeader);
        sb.append(",");
    }
    if (!(proxyFromEnvironment == null)) {
        sb.append("proxyFromEnvironment:");
        sb.append(proxyFromEnvironment);
        sb.append(",");
    }
    if (!(proxyUrl == null)) {
        sb.append("proxyUrl:");
        sb.append(proxyUrl);
        sb.append(",");
    }
    if (!(refreshInterval == null)) {
        sb.append("refreshInterval:");
        sb.append(refreshInterval);
        sb.append(",");
    }
    if (!(resourceGroup == null)) {
        sb.append("resourceGroup:");
        sb.append(resourceGroup);
        sb.append(",");
    }
    if (!(subscriptionID == null)) {
        sb.append("subscriptionID:");
        sb.append(subscriptionID);
        sb.append(",");
    }
    if (!(tenantID == null)) {
        sb.append("tenantID:");
        sb.append(tenantID);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
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
  
  public A withAuthenticationMethod(String authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
    return (A) this;
  }
  
  public A withAuthorization(SafeAuthorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new SafeAuthorizationBuilder(authorization);
        this._visitables.get("authorization").add(this.authorization);
    } else {
        this.authorization = null;
        this._visitables.get("authorization").remove(this.authorization);
    }
    return (A) this;
  }
  
  public A withBasicAuth(BasicAuth basicAuth) {
    this._visitables.remove("basicAuth");
    if (basicAuth != null) {
        this.basicAuth = new BasicAuthBuilder(basicAuth);
        this._visitables.get("basicAuth").add(this.basicAuth);
    } else {
        this.basicAuth = null;
        this._visitables.get("basicAuth").remove(this.basicAuth);
    }
    return (A) this;
  }
  
  public A withClientID(String clientID) {
    this.clientID = clientID;
    return (A) this;
  }
  
  public A withClientSecret(SecretKeySelector clientSecret) {
    this.clientSecret = clientSecret;
    return (A) this;
  }
  
  public A withEnableHTTP2() {
    return withEnableHTTP2(true);
  }
  
  public A withEnableHTTP2(Boolean enableHTTP2) {
    this.enableHTTP2 = enableHTTP2;
    return (A) this;
  }
  
  public A withEnvironment(String environment) {
    this.environment = environment;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(SafeAuthorization item) {
    return new AuthorizationNested(item);
  }
  
  public BasicAuthNested<A> withNewBasicAuth() {
    return new BasicAuthNested(null);
  }
  
  public BasicAuthNested<A> withNewBasicAuthLike(BasicAuth item) {
    return new BasicAuthNested(item);
  }
  
  public A withNewClientSecret(String key,String name,Boolean optional) {
    return (A) this.withClientSecret(new SecretKeySelector(key, name, optional));
  }
  
  public Oauth2Nested<A> withNewOauth2() {
    return new Oauth2Nested(null);
  }
  
  public Oauth2Nested<A> withNewOauth2Like(OAuth2 item) {
    return new Oauth2Nested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withOauth2(OAuth2 oauth2) {
    this._visitables.remove("oauth2");
    if (oauth2 != null) {
        this.oauth2 = new OAuth2Builder(oauth2);
        this._visitables.get("oauth2").add(this.oauth2);
    } else {
        this.oauth2 = null;
        this._visitables.get("oauth2").remove(this.oauth2);
    }
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public <K,V>A withProxyConnectHeader(Map<String,List<SecretKeySelector>> proxyConnectHeader) {
    if (proxyConnectHeader == null) {
      this.proxyConnectHeader = null;
    } else {
      this.proxyConnectHeader = new LinkedHashMap(proxyConnectHeader);
    }
    return (A) this;
  }
  
  public A withProxyFromEnvironment() {
    return withProxyFromEnvironment(true);
  }
  
  public A withProxyFromEnvironment(Boolean proxyFromEnvironment) {
    this.proxyFromEnvironment = proxyFromEnvironment;
    return (A) this;
  }
  
  public A withProxyUrl(String proxyUrl) {
    this.proxyUrl = proxyUrl;
    return (A) this;
  }
  
  public A withRefreshInterval(String refreshInterval) {
    this.refreshInterval = refreshInterval;
    return (A) this;
  }
  
  public A withResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
    return (A) this;
  }
  
  public A withSubscriptionID(String subscriptionID) {
    this.subscriptionID = subscriptionID;
    return (A) this;
  }
  
  public A withTenantID(String tenantID) {
    this.tenantID = tenantID;
    return (A) this;
  }
  
  public A withTlsConfig(SafeTLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new SafeTLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  public class AuthorizationNested<N> extends SafeAuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    SafeAuthorizationBuilder builder;
  
    AuthorizationNested(SafeAuthorization item) {
      this.builder = new SafeAuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureSDConfigFluent.this.withAuthorization(builder.build());
    }
    
    public N endAuthorization() {
      return and();
    }
    
  }
  public class BasicAuthNested<N> extends BasicAuthFluent<BasicAuthNested<N>> implements Nested<N>{
  
    BasicAuthBuilder builder;
  
    BasicAuthNested(BasicAuth item) {
      this.builder = new BasicAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureSDConfigFluent.this.withBasicAuth(builder.build());
    }
    
    public N endBasicAuth() {
      return and();
    }
    
  }
  public class Oauth2Nested<N> extends OAuth2Fluent<Oauth2Nested<N>> implements Nested<N>{
  
    OAuth2Builder builder;
  
    Oauth2Nested(OAuth2 item) {
      this.builder = new OAuth2Builder(this, item);
    }
  
    public N and() {
      return (N) AzureSDConfigFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) AzureSDConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}