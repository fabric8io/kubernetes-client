package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class IngressControllerTuningOptionsFluent<A extends io.fabric8.openshift.api.model.operator.v1.IngressControllerTuningOptionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String clientFinTimeout;
  private String clientTimeout;
  private String connectTimeout;
  private Integer headerBufferBytes;
  private Integer headerBufferMaxRewriteBytes;
  private String healthCheckInterval;
  private String httpKeepAliveTimeout;
  private Integer maxConnections;
  private String reloadInterval;
  private String serverFinTimeout;
  private String serverTimeout;
  private Integer threadCount;
  private String tlsInspectDelay;
  private String tunnelTimeout;

  public IngressControllerTuningOptionsFluent() {
  }
  
  public IngressControllerTuningOptionsFluent(IngressControllerTuningOptions instance) {
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
  
  protected void copyInstance(IngressControllerTuningOptions instance) {
    instance = instance != null ? instance : new IngressControllerTuningOptions();
    if (instance != null) {
        this.withClientFinTimeout(instance.getClientFinTimeout());
        this.withClientTimeout(instance.getClientTimeout());
        this.withConnectTimeout(instance.getConnectTimeout());
        this.withHeaderBufferBytes(instance.getHeaderBufferBytes());
        this.withHeaderBufferMaxRewriteBytes(instance.getHeaderBufferMaxRewriteBytes());
        this.withHealthCheckInterval(instance.getHealthCheckInterval());
        this.withHttpKeepAliveTimeout(instance.getHttpKeepAliveTimeout());
        this.withMaxConnections(instance.getMaxConnections());
        this.withReloadInterval(instance.getReloadInterval());
        this.withServerFinTimeout(instance.getServerFinTimeout());
        this.withServerTimeout(instance.getServerTimeout());
        this.withThreadCount(instance.getThreadCount());
        this.withTlsInspectDelay(instance.getTlsInspectDelay());
        this.withTunnelTimeout(instance.getTunnelTimeout());
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
    IngressControllerTuningOptionsFluent that = (IngressControllerTuningOptionsFluent) o;
    if (!(Objects.equals(clientFinTimeout, that.clientFinTimeout))) {
      return false;
    }
    if (!(Objects.equals(clientTimeout, that.clientTimeout))) {
      return false;
    }
    if (!(Objects.equals(connectTimeout, that.connectTimeout))) {
      return false;
    }
    if (!(Objects.equals(headerBufferBytes, that.headerBufferBytes))) {
      return false;
    }
    if (!(Objects.equals(headerBufferMaxRewriteBytes, that.headerBufferMaxRewriteBytes))) {
      return false;
    }
    if (!(Objects.equals(healthCheckInterval, that.healthCheckInterval))) {
      return false;
    }
    if (!(Objects.equals(httpKeepAliveTimeout, that.httpKeepAliveTimeout))) {
      return false;
    }
    if (!(Objects.equals(maxConnections, that.maxConnections))) {
      return false;
    }
    if (!(Objects.equals(reloadInterval, that.reloadInterval))) {
      return false;
    }
    if (!(Objects.equals(serverFinTimeout, that.serverFinTimeout))) {
      return false;
    }
    if (!(Objects.equals(serverTimeout, that.serverTimeout))) {
      return false;
    }
    if (!(Objects.equals(threadCount, that.threadCount))) {
      return false;
    }
    if (!(Objects.equals(tlsInspectDelay, that.tlsInspectDelay))) {
      return false;
    }
    if (!(Objects.equals(tunnelTimeout, that.tunnelTimeout))) {
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
  
  public String getClientFinTimeout() {
    return this.clientFinTimeout;
  }
  
  public String getClientTimeout() {
    return this.clientTimeout;
  }
  
  public String getConnectTimeout() {
    return this.connectTimeout;
  }
  
  public Integer getHeaderBufferBytes() {
    return this.headerBufferBytes;
  }
  
  public Integer getHeaderBufferMaxRewriteBytes() {
    return this.headerBufferMaxRewriteBytes;
  }
  
  public String getHealthCheckInterval() {
    return this.healthCheckInterval;
  }
  
  public String getHttpKeepAliveTimeout() {
    return this.httpKeepAliveTimeout;
  }
  
  public Integer getMaxConnections() {
    return this.maxConnections;
  }
  
  public String getReloadInterval() {
    return this.reloadInterval;
  }
  
  public String getServerFinTimeout() {
    return this.serverFinTimeout;
  }
  
  public String getServerTimeout() {
    return this.serverTimeout;
  }
  
  public Integer getThreadCount() {
    return this.threadCount;
  }
  
  public String getTlsInspectDelay() {
    return this.tlsInspectDelay;
  }
  
  public String getTunnelTimeout() {
    return this.tunnelTimeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClientFinTimeout() {
    return this.clientFinTimeout != null;
  }
  
  public boolean hasClientTimeout() {
    return this.clientTimeout != null;
  }
  
  public boolean hasConnectTimeout() {
    return this.connectTimeout != null;
  }
  
  public boolean hasHeaderBufferBytes() {
    return this.headerBufferBytes != null;
  }
  
  public boolean hasHeaderBufferMaxRewriteBytes() {
    return this.headerBufferMaxRewriteBytes != null;
  }
  
  public boolean hasHealthCheckInterval() {
    return this.healthCheckInterval != null;
  }
  
  public boolean hasHttpKeepAliveTimeout() {
    return this.httpKeepAliveTimeout != null;
  }
  
  public boolean hasMaxConnections() {
    return this.maxConnections != null;
  }
  
  public boolean hasReloadInterval() {
    return this.reloadInterval != null;
  }
  
  public boolean hasServerFinTimeout() {
    return this.serverFinTimeout != null;
  }
  
  public boolean hasServerTimeout() {
    return this.serverTimeout != null;
  }
  
  public boolean hasThreadCount() {
    return this.threadCount != null;
  }
  
  public boolean hasTlsInspectDelay() {
    return this.tlsInspectDelay != null;
  }
  
  public boolean hasTunnelTimeout() {
    return this.tunnelTimeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(clientFinTimeout, clientTimeout, connectTimeout, headerBufferBytes, headerBufferMaxRewriteBytes, healthCheckInterval, httpKeepAliveTimeout, maxConnections, reloadInterval, serverFinTimeout, serverTimeout, threadCount, tlsInspectDelay, tunnelTimeout, additionalProperties);
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
    if (!(clientFinTimeout == null)) {
        sb.append("clientFinTimeout:");
        sb.append(clientFinTimeout);
        sb.append(",");
    }
    if (!(clientTimeout == null)) {
        sb.append("clientTimeout:");
        sb.append(clientTimeout);
        sb.append(",");
    }
    if (!(connectTimeout == null)) {
        sb.append("connectTimeout:");
        sb.append(connectTimeout);
        sb.append(",");
    }
    if (!(headerBufferBytes == null)) {
        sb.append("headerBufferBytes:");
        sb.append(headerBufferBytes);
        sb.append(",");
    }
    if (!(headerBufferMaxRewriteBytes == null)) {
        sb.append("headerBufferMaxRewriteBytes:");
        sb.append(headerBufferMaxRewriteBytes);
        sb.append(",");
    }
    if (!(healthCheckInterval == null)) {
        sb.append("healthCheckInterval:");
        sb.append(healthCheckInterval);
        sb.append(",");
    }
    if (!(httpKeepAliveTimeout == null)) {
        sb.append("httpKeepAliveTimeout:");
        sb.append(httpKeepAliveTimeout);
        sb.append(",");
    }
    if (!(maxConnections == null)) {
        sb.append("maxConnections:");
        sb.append(maxConnections);
        sb.append(",");
    }
    if (!(reloadInterval == null)) {
        sb.append("reloadInterval:");
        sb.append(reloadInterval);
        sb.append(",");
    }
    if (!(serverFinTimeout == null)) {
        sb.append("serverFinTimeout:");
        sb.append(serverFinTimeout);
        sb.append(",");
    }
    if (!(serverTimeout == null)) {
        sb.append("serverTimeout:");
        sb.append(serverTimeout);
        sb.append(",");
    }
    if (!(threadCount == null)) {
        sb.append("threadCount:");
        sb.append(threadCount);
        sb.append(",");
    }
    if (!(tlsInspectDelay == null)) {
        sb.append("tlsInspectDelay:");
        sb.append(tlsInspectDelay);
        sb.append(",");
    }
    if (!(tunnelTimeout == null)) {
        sb.append("tunnelTimeout:");
        sb.append(tunnelTimeout);
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
  
  public A withClientFinTimeout(String clientFinTimeout) {
    this.clientFinTimeout = clientFinTimeout;
    return (A) this;
  }
  
  public A withClientTimeout(String clientTimeout) {
    this.clientTimeout = clientTimeout;
    return (A) this;
  }
  
  public A withConnectTimeout(String connectTimeout) {
    this.connectTimeout = connectTimeout;
    return (A) this;
  }
  
  public A withHeaderBufferBytes(Integer headerBufferBytes) {
    this.headerBufferBytes = headerBufferBytes;
    return (A) this;
  }
  
  public A withHeaderBufferMaxRewriteBytes(Integer headerBufferMaxRewriteBytes) {
    this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
    return (A) this;
  }
  
  public A withHealthCheckInterval(String healthCheckInterval) {
    this.healthCheckInterval = healthCheckInterval;
    return (A) this;
  }
  
  public A withHttpKeepAliveTimeout(String httpKeepAliveTimeout) {
    this.httpKeepAliveTimeout = httpKeepAliveTimeout;
    return (A) this;
  }
  
  public A withMaxConnections(Integer maxConnections) {
    this.maxConnections = maxConnections;
    return (A) this;
  }
  
  public A withReloadInterval(String reloadInterval) {
    this.reloadInterval = reloadInterval;
    return (A) this;
  }
  
  public A withServerFinTimeout(String serverFinTimeout) {
    this.serverFinTimeout = serverFinTimeout;
    return (A) this;
  }
  
  public A withServerTimeout(String serverTimeout) {
    this.serverTimeout = serverTimeout;
    return (A) this;
  }
  
  public A withThreadCount(Integer threadCount) {
    this.threadCount = threadCount;
    return (A) this;
  }
  
  public A withTlsInspectDelay(String tlsInspectDelay) {
    this.tlsInspectDelay = tlsInspectDelay;
    return (A) this;
  }
  
  public A withTunnelTimeout(String tunnelTimeout) {
    this.tunnelTimeout = tunnelTimeout;
    return (A) this;
  }
  
}