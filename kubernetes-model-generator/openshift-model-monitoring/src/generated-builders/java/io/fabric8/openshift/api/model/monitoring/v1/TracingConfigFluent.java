package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class TracingConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.TracingConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientType;
  private String compression;
  private String endpoint;
  private Map<String,String> headers;
  private Boolean insecure;
  private Quantity samplingFraction;
  private String timeout;
  private TLSConfigBuilder tlsConfig;

  public TracingConfigFluent() {
  }
  
  public TracingConfigFluent(TracingConfig instance) {
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
  
  public TLSConfig buildTlsConfig() {
    return this.tlsConfig != null ? this.tlsConfig.build() : null;
  }
  
  protected void copyInstance(TracingConfig instance) {
    instance = instance != null ? instance : new TracingConfig();
    if (instance != null) {
        this.withClientType(instance.getClientType());
        this.withCompression(instance.getCompression());
        this.withEndpoint(instance.getEndpoint());
        this.withHeaders(instance.getHeaders());
        this.withInsecure(instance.getInsecure());
        this.withSamplingFraction(instance.getSamplingFraction());
        this.withTimeout(instance.getTimeout());
        this.withTlsConfig(instance.getTlsConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    TracingConfigFluent that = (TracingConfigFluent) o;
    if (!(Objects.equals(clientType, that.clientType))) {
      return false;
    }
    if (!(Objects.equals(compression, that.compression))) {
      return false;
    }
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(insecure, that.insecure))) {
      return false;
    }
    if (!(Objects.equals(samplingFraction, that.samplingFraction))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
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
  
  public String getClientType() {
    return this.clientType;
  }
  
  public String getCompression() {
    return this.compression;
  }
  
  public String getEndpoint() {
    return this.endpoint;
  }
  
  public Map<String,String> getHeaders() {
    return this.headers;
  }
  
  public Boolean getInsecure() {
    return this.insecure;
  }
  
  public Quantity getSamplingFraction() {
    return this.samplingFraction;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientType() {
    return this.clientType != null;
  }
  
  public boolean hasCompression() {
    return this.compression != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasInsecure() {
    return this.insecure != null;
  }
  
  public boolean hasSamplingFraction() {
    return this.samplingFraction != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasTlsConfig() {
    return this.tlsConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientType, compression, endpoint, headers, insecure, samplingFraction, timeout, tlsConfig, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clientType == null)) {
        sb.append("clientType:");
        sb.append(clientType);
        sb.append(",");
    }
    if (!(compression == null)) {
        sb.append("compression:");
        sb.append(compression);
        sb.append(",");
    }
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(headers == null) && !(headers.isEmpty())) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(insecure == null)) {
        sb.append("insecure:");
        sb.append(insecure);
        sb.append(",");
    }
    if (!(samplingFraction == null)) {
        sb.append("samplingFraction:");
        sb.append(samplingFraction);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
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
  
  public A withClientType(String clientType) {
    this.clientType = clientType;
    return (A) this;
  }
  
  public A withCompression(String compression) {
    this.compression = compression;
    return (A) this;
  }
  
  public A withEndpoint(String endpoint) {
    this.endpoint = endpoint;
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
  
  public A withInsecure() {
    return withInsecure(true);
  }
  
  public A withInsecure(Boolean insecure) {
    this.insecure = insecure;
    return (A) this;
  }
  
  public A withNewSamplingFraction(String amount) {
    return (A) this.withSamplingFraction(new Quantity(amount));
  }
  
  public A withNewSamplingFraction(String amount,String format) {
    return (A) this.withSamplingFraction(new Quantity(amount, format));
  }
  
  public TlsConfigNested<A> withNewTlsConfig() {
    return new TlsConfigNested(null);
  }
  
  public TlsConfigNested<A> withNewTlsConfigLike(TLSConfig item) {
    return new TlsConfigNested(item);
  }
  
  public A withSamplingFraction(Quantity samplingFraction) {
    this.samplingFraction = samplingFraction;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
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
  public class TlsConfigNested<N> extends TLSConfigFluent<TlsConfigNested<N>> implements Nested<N>{
  
    TLSConfigBuilder builder;
  
    TlsConfigNested(TLSConfig item) {
      this.builder = new TLSConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) TracingConfigFluent.this.withTlsConfig(builder.build());
    }
    
    public N endTlsConfig() {
      return and();
    }
    
  }
}