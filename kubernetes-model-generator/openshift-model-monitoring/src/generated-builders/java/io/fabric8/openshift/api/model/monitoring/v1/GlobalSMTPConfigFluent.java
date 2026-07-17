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
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GlobalSMTPConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.GlobalSMTPConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String authIdentity;
  private SecretKeySelector authPassword;
  private SecretKeySelector authSecret;
  private String authUsername;
  private Boolean forceImplicitTLS;
  private String from;
  private String hello;
  private Boolean requireTLS;
  private HostPortBuilder smartHost;
  private SafeTLSConfigBuilder tlsConfig;

  public GlobalSMTPConfigFluent() {
  }
  
  public GlobalSMTPConfigFluent(GlobalSMTPConfig instance) {
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
  
  public HostPort buildSmartHost() {
    return this.smartHost != null ? this.smartHost.build() : null;
  }
  
  public SafeTLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(GlobalSMTPConfig instance) {
    instance = instance != null ? instance : new GlobalSMTPConfig();
    if (instance != null) {
        this.withAuthIdentity(instance.getAuthIdentity());
        this.withAuthPassword(instance.getAuthPassword());
        this.withAuthSecret(instance.getAuthSecret());
        this.withAuthUsername(instance.getAuthUsername());
        this.withForceImplicitTLS(instance.getForceImplicitTLS());
        this.withFrom(instance.getFrom());
        this.withHello(instance.getHello());
        this.withRequireTLS(instance.getRequireTLS());
        this.withSmartHost(instance.getSmartHost());
        this.withTlsConfig(instance.getTlsConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SmartHostNested<A> editOrNewSmartHost() {
    return this.withNewSmartHostLike(Optional.ofNullable(this.buildSmartHost()).orElse(new HostPortBuilder().build()));
  }
  
  public SmartHostNested<A> editOrNewSmartHostLike(HostPort item) {
    return this.withNewSmartHostLike(Optional.ofNullable(this.buildSmartHost()).orElse(item));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfig() {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(new SafeTLSConfigBuilder().build()));
  }
  
  public TlsConfigNested<A> editOrNewTlsConfigLike(SafeTLSConfig item) {
    return this.withNewTlsConfigLike(Optional.ofNullable(this.buildTlsConfig()).orElse(item));
  }
  
  public SmartHostNested<A> editSmartHost() {
    return this.withNewSmartHostLike(Optional.ofNullable(this.buildSmartHost()).orElse(null));
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
    GlobalSMTPConfigFluent that = (GlobalSMTPConfigFluent) o;
    if (!(Objects.equals(authIdentity, that.authIdentity))) {
      return false;
    }
    if (!(Objects.equals(authPassword, that.authPassword))) {
      return false;
    }
    if (!(Objects.equals(authSecret, that.authSecret))) {
      return false;
    }
    if (!(Objects.equals(authUsername, that.authUsername))) {
      return false;
    }
    if (!(Objects.equals(forceImplicitTLS, that.forceImplicitTLS))) {
      return false;
    }
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(hello, that.hello))) {
      return false;
    }
    if (!(Objects.equals(requireTLS, that.requireTLS))) {
      return false;
    }
    if (!(Objects.equals(smartHost, that.smartHost))) {
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
  
  public String getAuthIdentity() {
    return this.authIdentity;
  }
  
  public SecretKeySelector getAuthPassword() {
    return this.authPassword;
  }
  
  public SecretKeySelector getAuthSecret() {
    return this.authSecret;
  }
  
  public String getAuthUsername() {
    return this.authUsername;
  }
  
  public Boolean getForceImplicitTLS() {
    return this.forceImplicitTLS;
  }
  
  public String getFrom() {
    return this.from;
  }
  
  public String getHello() {
    return this.hello;
  }
  
  public Boolean getRequireTLS() {
    return this.requireTLS;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuthIdentity() {
    return this.authIdentity != null;
  }
  
  public boolean hasAuthPassword() {
    return this.authPassword != null;
  }
  
  public boolean hasAuthSecret() {
    return this.authSecret != null;
  }
  
  public boolean hasAuthUsername() {
    return this.authUsername != null;
  }
  
  public boolean hasForceImplicitTLS() {
    return this.forceImplicitTLS != null;
  }
  
  public boolean hasFrom() {
    return this.from != null;
  }
  
  public boolean hasHello() {
    return this.hello != null;
  }
  
  public boolean hasRequireTLS() {
    return this.requireTLS != null;
  }
  
  public boolean hasSmartHost() {
    return this.smartHost != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(authIdentity, authPassword, authSecret, authUsername, forceImplicitTLS, from, hello, requireTLS, smartHost, tlsConfig, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(authIdentity == null)) {
        sb.append("authIdentity:");
        sb.append(authIdentity);
        sb.append(",");
    }
    if (!(authPassword == null)) {
        sb.append("authPassword:");
        sb.append(authPassword);
        sb.append(",");
    }
    if (!(authSecret == null)) {
        sb.append("authSecret:");
        sb.append(authSecret);
        sb.append(",");
    }
    if (!(authUsername == null)) {
        sb.append("authUsername:");
        sb.append(authUsername);
        sb.append(",");
    }
    if (!(forceImplicitTLS == null)) {
        sb.append("forceImplicitTLS:");
        sb.append(forceImplicitTLS);
        sb.append(",");
    }
    if (!(from == null)) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(hello == null)) {
        sb.append("hello:");
        sb.append(hello);
        sb.append(",");
    }
    if (!(requireTLS == null)) {
        sb.append("requireTLS:");
        sb.append(requireTLS);
        sb.append(",");
    }
    if (!(smartHost == null)) {
        sb.append("smartHost:");
        sb.append(smartHost);
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
  
  public A withAuthIdentity(String authIdentity) {
    this.authIdentity = authIdentity;
    return (A) this;
  }
  
  public A withAuthPassword(SecretKeySelector authPassword) {
    this.authPassword = authPassword;
    return (A) this;
  }
  
  public A withAuthSecret(SecretKeySelector authSecret) {
    this.authSecret = authSecret;
    return (A) this;
  }
  
  public A withAuthUsername(String authUsername) {
    this.authUsername = authUsername;
    return (A) this;
  }
  
  public A withForceImplicitTLS() {
    return withForceImplicitTLS(true);
  }
  
  public A withForceImplicitTLS(Boolean forceImplicitTLS) {
    this.forceImplicitTLS = forceImplicitTLS;
    return (A) this;
  }
  
  public A withFrom(String from) {
    this.from = from;
    return (A) this;
  }
  
  public A withHello(String hello) {
    this.hello = hello;
    return (A) this;
  }
  
  public A withNewAuthPassword(String key,String name,Boolean optional) {
    return (A) this.withAuthPassword(new SecretKeySelector(key, name, optional));
  }
  
  public A withNewAuthSecret(String key,String name,Boolean optional) {
    return (A) this.withAuthSecret(new SecretKeySelector(key, name, optional));
  }
  
  public SmartHostNested<A> withNewSmartHost() {
    return new SmartHostNested(null);
  }
  
  public A withNewSmartHost(String host,String port) {
    return (A) this.withSmartHost(new HostPort(host, port));
  }
  
  public SmartHostNested<A> withNewSmartHostLike(HostPort item) {
    return new SmartHostNested(item);
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(SafeTLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withRequireTLS() {
    return withRequireTLS(true);
  }
  
  public A withRequireTLS(Boolean requireTLS) {
    this.requireTLS = requireTLS;
    return (A) this;
  }
  
  public A withSmartHost(HostPort smartHost) {
    this._visitables.remove("smartHost");
    if (smartHost != null) {
        this.smartHost = new HostPortBuilder(smartHost);
        this._visitables.get("smartHost").add(this.smartHost);
    } else {
        this.smartHost = null;
        this._visitables.get("smartHost").remove(this.smartHost);
    }
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
  public class SmartHostNested<N> extends HostPortFluent<SmartHostNested<N>> implements Nested<N>{
  
    HostPortBuilder builder;
  
    SmartHostNested(HostPort item) {
      this.builder = new HostPortBuilder(this, item);
    }
  
    public N and() {
      return (N) GlobalSMTPConfigFluent.this.withSmartHost(builder.build());
    }
    
    public N endSmartHost() {
      return and();
    }
    
  }
  public class TlsConfigNested<N> extends SafeTLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    SafeTLSConfigBuilder builder;
  
    TlsConfigNested(SafeTLSConfig item) {
      this.builder = new SafeTLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) GlobalSMTPConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}