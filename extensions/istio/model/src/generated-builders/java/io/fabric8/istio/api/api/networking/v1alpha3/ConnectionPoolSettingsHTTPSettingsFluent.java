package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConnectionPoolSettingsHTTPSettingsFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ConnectionPoolSettingsHTTPSettingsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy;
  private Integer http1MaxPendingRequests;
  private Integer http2MaxRequests;
  private String idleTimeout;
  private Integer maxConcurrentStreams;
  private Integer maxRequestsPerConnection;
  private Integer maxRetries;
  private Boolean useClientProtocol;

  public ConnectionPoolSettingsHTTPSettingsFluent() {
  }
  
  public ConnectionPoolSettingsHTTPSettingsFluent(ConnectionPoolSettingsHTTPSettings instance) {
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
  
  protected void copyInstance(ConnectionPoolSettingsHTTPSettings instance) {
    instance = instance != null ? instance : new ConnectionPoolSettingsHTTPSettings();
    if (instance != null) {
        this.withH2UpgradePolicy(instance.getH2UpgradePolicy());
        this.withHttp1MaxPendingRequests(instance.getHttp1MaxPendingRequests());
        this.withHttp2MaxRequests(instance.getHttp2MaxRequests());
        this.withIdleTimeout(instance.getIdleTimeout());
        this.withMaxConcurrentStreams(instance.getMaxConcurrentStreams());
        this.withMaxRequestsPerConnection(instance.getMaxRequestsPerConnection());
        this.withMaxRetries(instance.getMaxRetries());
        this.withUseClientProtocol(instance.getUseClientProtocol());
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
    ConnectionPoolSettingsHTTPSettingsFluent that = (ConnectionPoolSettingsHTTPSettingsFluent) o;
    if (!(Objects.equals(h2UpgradePolicy, that.h2UpgradePolicy))) {
      return false;
    }
    if (!(Objects.equals(http1MaxPendingRequests, that.http1MaxPendingRequests))) {
      return false;
    }
    if (!(Objects.equals(http2MaxRequests, that.http2MaxRequests))) {
      return false;
    }
    if (!(Objects.equals(idleTimeout, that.idleTimeout))) {
      return false;
    }
    if (!(Objects.equals(maxConcurrentStreams, that.maxConcurrentStreams))) {
      return false;
    }
    if (!(Objects.equals(maxRequestsPerConnection, that.maxRequestsPerConnection))) {
      return false;
    }
    if (!(Objects.equals(maxRetries, that.maxRetries))) {
      return false;
    }
    if (!(Objects.equals(useClientProtocol, that.useClientProtocol))) {
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
  
  public ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy getH2UpgradePolicy() {
    return this.h2UpgradePolicy;
  }
  
  public Integer getHttp1MaxPendingRequests() {
    return this.http1MaxPendingRequests;
  }
  
  public Integer getHttp2MaxRequests() {
    return this.http2MaxRequests;
  }
  
  public String getIdleTimeout() {
    return this.idleTimeout;
  }
  
  public Integer getMaxConcurrentStreams() {
    return this.maxConcurrentStreams;
  }
  
  public Integer getMaxRequestsPerConnection() {
    return this.maxRequestsPerConnection;
  }
  
  public Integer getMaxRetries() {
    return this.maxRetries;
  }
  
  public Boolean getUseClientProtocol() {
    return this.useClientProtocol;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasH2UpgradePolicy() {
    return this.h2UpgradePolicy != null;
  }
  
  public boolean hasHttp1MaxPendingRequests() {
    return this.http1MaxPendingRequests != null;
  }
  
  public boolean hasHttp2MaxRequests() {
    return this.http2MaxRequests != null;
  }
  
  public boolean hasIdleTimeout() {
    return this.idleTimeout != null;
  }
  
  public boolean hasMaxConcurrentStreams() {
    return this.maxConcurrentStreams != null;
  }
  
  public boolean hasMaxRequestsPerConnection() {
    return this.maxRequestsPerConnection != null;
  }
  
  public boolean hasMaxRetries() {
    return this.maxRetries != null;
  }
  
  public boolean hasUseClientProtocol() {
    return this.useClientProtocol != null;
  }
  
  public int hashCode() {
    return Objects.hash(h2UpgradePolicy, http1MaxPendingRequests, http2MaxRequests, idleTimeout, maxConcurrentStreams, maxRequestsPerConnection, maxRetries, useClientProtocol, additionalProperties);
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
    if (!(h2UpgradePolicy == null)) {
        sb.append("h2UpgradePolicy:");
        sb.append(h2UpgradePolicy);
        sb.append(",");
    }
    if (!(http1MaxPendingRequests == null)) {
        sb.append("http1MaxPendingRequests:");
        sb.append(http1MaxPendingRequests);
        sb.append(",");
    }
    if (!(http2MaxRequests == null)) {
        sb.append("http2MaxRequests:");
        sb.append(http2MaxRequests);
        sb.append(",");
    }
    if (!(idleTimeout == null)) {
        sb.append("idleTimeout:");
        sb.append(idleTimeout);
        sb.append(",");
    }
    if (!(maxConcurrentStreams == null)) {
        sb.append("maxConcurrentStreams:");
        sb.append(maxConcurrentStreams);
        sb.append(",");
    }
    if (!(maxRequestsPerConnection == null)) {
        sb.append("maxRequestsPerConnection:");
        sb.append(maxRequestsPerConnection);
        sb.append(",");
    }
    if (!(maxRetries == null)) {
        sb.append("maxRetries:");
        sb.append(maxRetries);
        sb.append(",");
    }
    if (!(useClientProtocol == null)) {
        sb.append("useClientProtocol:");
        sb.append(useClientProtocol);
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
  
  public A withH2UpgradePolicy(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy) {
    this.h2UpgradePolicy = h2UpgradePolicy;
    return (A) this;
  }
  
  public A withHttp1MaxPendingRequests(Integer http1MaxPendingRequests) {
    this.http1MaxPendingRequests = http1MaxPendingRequests;
    return (A) this;
  }
  
  public A withHttp2MaxRequests(Integer http2MaxRequests) {
    this.http2MaxRequests = http2MaxRequests;
    return (A) this;
  }
  
  public A withIdleTimeout(String idleTimeout) {
    this.idleTimeout = idleTimeout;
    return (A) this;
  }
  
  public A withMaxConcurrentStreams(Integer maxConcurrentStreams) {
    this.maxConcurrentStreams = maxConcurrentStreams;
    return (A) this;
  }
  
  public A withMaxRequestsPerConnection(Integer maxRequestsPerConnection) {
    this.maxRequestsPerConnection = maxRequestsPerConnection;
    return (A) this;
  }
  
  public A withMaxRetries(Integer maxRetries) {
    this.maxRetries = maxRetries;
    return (A) this;
  }
  
  public A withUseClientProtocol() {
    return withUseClientProtocol(true);
  }
  
  public A withUseClientProtocol(Boolean useClientProtocol) {
    this.useClientProtocol = useClientProtocol;
    return (A) this;
  }
  
}