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
public class HetznerSDConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.HetznerSDConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private SafeAuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private Boolean enableHTTP2;
  private Boolean followRedirects;
  private String labelSelector;
  private String noProxy;
  private OAuth2Builder oauth2;
  private Integer port;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private String refreshInterval;
  private String role;
  private SafeTLSConfigBuilder tlsConfig;

  public HetznerSDConfigFluent() {
  }
  
  public HetznerSDConfigFluent(HetznerSDConfig instance) {
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
  
  protected void copyInstance(HetznerSDConfig instance) {
    instance = instance != null ? instance : new HetznerSDConfig();
    if (instance != null) {
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withEnableHTTP2(instance.getEnableHTTP2());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withLabelSelector(instance.getLabelSelector());
        this.withNoProxy(instance.getNoProxy());
        this.withOauth2(instance.getOauth2());
        this.withPort(instance.getPort());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withRefreshInterval(instance.getRefreshInterval());
        this.withRole(instance.getRole());
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
    HetznerSDConfigFluent that = (HetznerSDConfigFluent) o;
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(enableHTTP2, that.enableHTTP2))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(labelSelector, that.labelSelector))) {
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
    if (!(Objects.equals(role, that.role))) {
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
  
  public Boolean getEnableHTTP2() {
    return this.enableHTTP2;
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public String getLabelSelector() {
    return this.labelSelector;
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
  
  public String getRole() {
    return this.role;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthorization() {
    return this.authorization != null;
  }
  
  public boolean hasBasicAuth() {
    return this.basicAuth != null;
  }
  
  public boolean hasEnableHTTP2() {
    return this.enableHTTP2 != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasLabelSelector() {
    return this.labelSelector != null;
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
  
  public boolean hasRole() {
    return this.role != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorization, basicAuth, enableHTTP2, followRedirects, labelSelector, noProxy, oauth2, port, proxyConnectHeader, proxyFromEnvironment, proxyUrl, refreshInterval, role, tlsConfig, additionalProperties);
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
    if (!(enableHTTP2 == null)) {
        sb.append("enableHTTP2:");
        sb.append(enableHTTP2);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(labelSelector == null)) {
        sb.append("labelSelector:");
        sb.append(labelSelector);
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
    if (!(role == null)) {
        sb.append("role:");
        sb.append(role);
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
  
  public A withEnableHTTP2() {
    return withEnableHTTP2(true);
  }
  
  public A withEnableHTTP2(Boolean enableHTTP2) {
    this.enableHTTP2 = enableHTTP2;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public A withLabelSelector(String labelSelector) {
    this.labelSelector = labelSelector;
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
  
  public A withRole(String role) {
    this.role = role;
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
      return (N) HetznerSDConfigFluent.this.withAuthorization(builder.build());
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
      return (N) HetznerSDConfigFluent.this.withBasicAuth(builder.build());
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
      return (N) HetznerSDConfigFluent.this.withOauth2(builder.build());
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
      return (N) HetznerSDConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}