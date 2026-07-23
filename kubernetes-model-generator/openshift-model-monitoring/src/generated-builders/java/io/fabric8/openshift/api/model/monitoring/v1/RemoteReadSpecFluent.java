package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import java.lang.Boolean;
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
public class RemoteReadSpecFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.RemoteReadSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AuthorizationBuilder authorization;
  private BasicAuthBuilder basicAuth;
  private String bearerToken;
  private String bearerTokenFile;
  private Boolean filterExternalLabels;
  private Boolean followRedirects;
  private Map<String,String> headers;
  private String name;
  private String noProxy;
  private OAuth2Builder oauth2;
  private Map<String,List<SecretKeySelector>> proxyConnectHeader;
  private Boolean proxyFromEnvironment;
  private String proxyUrl;
  private Boolean readRecent;
  private String remoteTimeout;
  private Map<String,String> requiredMatchers;
  private TLSConfigBuilder tlsConfig;
  private String url;

  public RemoteReadSpecFluent() {
  }
  
  public RemoteReadSpecFluent(RemoteReadSpec instance) {
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
  
  public A addToHeaders(Map<String,String> map) {
    if (this.headers == null && map != null) {
      this.headers = new LinkedHashMap();
    }
    if (map != null) {
      this.headers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToHeaders(String key,String value) {
    if (this.headers == null && key != null && value != null) {
      this.headers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.headers.put(key, value);
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
  
  public A addToRequiredMatchers(Map<String,String> map) {
    if (this.requiredMatchers == null && map != null) {
      this.requiredMatchers = new LinkedHashMap();
    }
    if (map != null) {
      this.requiredMatchers.putAll(map);
    }
    return (A) this;
  }
  
  public A addToRequiredMatchers(String key,String value) {
    if (this.requiredMatchers == null && key != null && value != null) {
      this.requiredMatchers = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.requiredMatchers.put(key, value);
    }
    return (A) this;
  }
  
  public Authorization buildAuthorization() {
    return this.authorization != null ? this.authorization.build() : null;
  }
  
  public BasicAuth buildBasicAuth() {
    return this.basicAuth != null ? this.basicAuth.build() : null;
  }
  
  public OAuth2 buildOauth2() {
    return this.oauth2 != null ? this.oauth2.build() : null;
  }
  
  public TLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(RemoteReadSpec instance) {
    instance = instance != null ? instance : new RemoteReadSpec();
    if (instance != null) {
        this.withAuthorization(instance.getAuthorization());
        this.withBasicAuth(instance.getBasicAuth());
        this.withBearerToken(instance.getBearerToken());
        this.withBearerTokenFile(instance.getBearerTokenFile());
        this.withFilterExternalLabels(instance.getFilterExternalLabels());
        this.withFollowRedirects(instance.getFollowRedirects());
        this.withHeaders(instance.getHeaders());
        this.withName(instance.getName());
        this.withNoProxy(instance.getNoProxy());
        this.withOauth2(instance.getOauth2());
        this.withProxyConnectHeader(instance.getProxyConnectHeader());
        this.withProxyFromEnvironment(instance.getProxyFromEnvironment());
        this.withProxyUrl(instance.getProxyUrl());
        this.withReadRecent(instance.getReadRecent());
        this.withRemoteTimeout(instance.getRemoteTimeout());
        this.withRequiredMatchers(instance.getRequiredMatchers());
        this.withTlsConfig(instance.getTlsConfig());
        this.withUrl(instance.getUrl());
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
    return this.withNewAuthorizationLike(Optional.ofNullable(this.buildAuthorization()).orElse(new AuthorizationBuilder().build()));
  }
  
  public AuthorizationNested<A> editOrNewAuthorizationLike(Authorization item) {
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
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new TLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(TLSConfig item) {
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
    RemoteReadSpecFluent that = (RemoteReadSpecFluent) o;
    if (!(Objects.equals(authorization, that.authorization))) {
      return false;
    }
    if (!(Objects.equals(basicAuth, that.basicAuth))) {
      return false;
    }
    if (!(Objects.equals(bearerToken, that.bearerToken))) {
      return false;
    }
    if (!(Objects.equals(bearerTokenFile, that.bearerTokenFile))) {
      return false;
    }
    if (!(Objects.equals(filterExternalLabels, that.filterExternalLabels))) {
      return false;
    }
    if (!(Objects.equals(followRedirects, that.followRedirects))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(oauth2, that.oauth2))) {
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
    if (!(Objects.equals(readRecent, that.readRecent))) {
      return false;
    }
    if (!(Objects.equals(remoteTimeout, that.remoteTimeout))) {
      return false;
    }
    if (!(Objects.equals(requiredMatchers, that.requiredMatchers))) {
      return false;
    }
    if (!(Objects.equals(tlsConfig, that.tlsConfig))) {
      return false;
    }
    if (!(Objects.equals(url, that.url))) {
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
  
  public String getBearerToken() {
    return this.bearerToken;
  }
  
  public String getBearerTokenFile() {
    return this.bearerTokenFile;
  }
  
  public Boolean getFilterExternalLabels() {
    return this.filterExternalLabels;
  }
  
  public Boolean getFollowRedirects() {
    return this.followRedirects;
  }
  
  public Map<String,String> getHeaders() {
    return this.headers;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNoProxy() {
    return this.noProxy;
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
  
  public Boolean getReadRecent() {
    return this.readRecent;
  }
  
  public String getRemoteTimeout() {
    return this.remoteTimeout;
  }
  
  public Map<String,String> getRequiredMatchers() {
    return this.requiredMatchers;
  }
  
  public String getUrl() {
    return this.url;
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
  
  public boolean hasBearerToken() {
    return this.bearerToken != null;
  }
  
  public boolean hasBearerTokenFile() {
    return this.bearerTokenFile != null;
  }
  
  public boolean hasFilterExternalLabels() {
    return this.filterExternalLabels != null;
  }
  
  public boolean hasFollowRedirects() {
    return this.followRedirects != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasOauth2() {
    return this.oauth2 != null;
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
  
  public boolean hasReadRecent() {
    return this.readRecent != null;
  }
  
  public boolean hasRemoteTimeout() {
    return this.remoteTimeout != null;
  }
  
  public boolean hasRequiredMatchers() {
    return this.requiredMatchers != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public boolean hasUrl() {
    return this.url != null;
  }
  
  public int hashCode() {
    return Objects.hash(authorization, basicAuth, bearerToken, bearerTokenFile, filterExternalLabels, followRedirects, headers, name, noProxy, oauth2, proxyConnectHeader, proxyFromEnvironment, proxyUrl, readRecent, remoteTimeout, requiredMatchers, tlsConfig, url, additionalProperties);
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
  
  public A removeFromHeaders(String key) {
    if (this.headers == null) {
      return (A) this;
    }
    if (key != null && this.headers != null) {
      this.headers.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromHeaders(Map<String,String> map) {
    if (this.headers == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.headers != null) {
          this.headers.remove(key);
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
  
  public A removeFromRequiredMatchers(String key) {
    if (this.requiredMatchers == null) {
      return (A) this;
    }
    if (key != null && this.requiredMatchers != null) {
      this.requiredMatchers.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromRequiredMatchers(Map<String,String> map) {
    if (this.requiredMatchers == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.requiredMatchers != null) {
          this.requiredMatchers.remove(key);
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
    if (!(bearerToken == null)) {
        sb.append("bearerToken:");
        sb.append(bearerToken);
        sb.append(",");
    }
    if (!(bearerTokenFile == null)) {
        sb.append("bearerTokenFile:");
        sb.append(bearerTokenFile);
        sb.append(",");
    }
    if (!(filterExternalLabels == null)) {
        sb.append("filterExternalLabels:");
        sb.append(filterExternalLabels);
        sb.append(",");
    }
    if (!(followRedirects == null)) {
        sb.append("followRedirects:");
        sb.append(followRedirects);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
    if (!(readRecent == null)) {
        sb.append("readRecent:");
        sb.append(readRecent);
        sb.append(",");
    }
    if (!(remoteTimeout == null)) {
        sb.append("remoteTimeout:");
        sb.append(remoteTimeout);
        sb.append(",");
    }
    if (!(requiredMatchers == null) && !(requiredMatchers.isEmpty())) {
        sb.append("requiredMatchers:");
        sb.append(requiredMatchers);
        sb.append(",");
    }
    if (!(tlsConfig == null)) {
        sb.append("tlsConfig:");
        sb.append(tlsConfig);
        sb.append(",");
    }
    if (!(url == null)) {
        sb.append("url:");
        sb.append(url);
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
  
  public A withAuthorization(Authorization authorization) {
    this._visitables.remove("authorization");
    if (authorization != null) {
        this.authorization = new AuthorizationBuilder(authorization);
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
  
  public A withBearerToken(String bearerToken) {
    this.bearerToken = bearerToken;
    return (A) this;
  }
  
  public A withBearerTokenFile(String bearerTokenFile) {
    this.bearerTokenFile = bearerTokenFile;
    return (A) this;
  }
  
  public A withFilterExternalLabels() {
    return withFilterExternalLabels(true);
  }
  
  public A withFilterExternalLabels(Boolean filterExternalLabels) {
    this.filterExternalLabels = filterExternalLabels;
    return (A) this;
  }
  
  public A withFollowRedirects() {
    return withFollowRedirects(true);
  }
  
  public A withFollowRedirects(Boolean followRedirects) {
    this.followRedirects = followRedirects;
    return (A) this;
  }
  
  public <K,V>A withHeaders(Map<String,String> headers) {
    if (headers == null) {
      this.headers = null;
    } else {
      this.headers = new LinkedHashMap(headers);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public AuthorizationNested<A> withNewAuthorization() {
    return new AuthorizationNested(null);
  }
  
  public AuthorizationNested<A> withNewAuthorizationLike(Authorization item) {
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
  
  public TlsConfigNested<A> withNewTlsConfigLike(TLSConfig item) {
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
  
  public A withReadRecent() {
    return withReadRecent(true);
  }
  
  public A withReadRecent(Boolean readRecent) {
    this.readRecent = readRecent;
    return (A) this;
  }
  
  public A withRemoteTimeout(String remoteTimeout) {
    this.remoteTimeout = remoteTimeout;
    return (A) this;
  }
  
  public <K,V>A withRequiredMatchers(Map<String,String> requiredMatchers) {
    if (requiredMatchers == null) {
      this.requiredMatchers = null;
    } else {
      this.requiredMatchers = new LinkedHashMap(requiredMatchers);
    }
    return (A) this;
  }
  
  public A withTlsConfig(TLSConfig tlsConfig) {
    this._visitables.remove("tlsConfig");
    if (tlsConfig != null) {
        this.tlsConfig = new TLSConfigBuilder(tlsConfig);
        this._visitables.get("tlsConfig").add(this.tlsConfig);
    } else {
        this.tlsConfig = null;
        this._visitables.get("tlsConfig").remove(this.tlsConfig);
    }
    return (A) this;
  }
  
  public A withUrl(String url) {
    this.url = url;
    return (A) this;
  }
  public class AuthorizationNested<N> extends AuthorizationFluent<AuthorizationNested<N>> implements Nested<N>{
  
    AuthorizationBuilder builder;
  
    AuthorizationNested(Authorization item) {
      this.builder = new AuthorizationBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteReadSpecFluent.this.withAuthorization(builder.build());
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
      return (N) RemoteReadSpecFluent.this.withBasicAuth(builder.build());
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
      return (N) RemoteReadSpecFluent.this.withOauth2(builder.build());
    }
    
    public N endOauth2() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends TLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsConfigNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) RemoteReadSpecFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}