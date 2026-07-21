package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
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
public class ReadinessProbeFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.ReadinessProbeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer failureThreshold;
  private VisitableBuilder<? extends IsReadinessProbeHealthCheckMethod,?> healthCheckMethod;
  private Integer initialDelaySeconds;
  private Integer periodSeconds;
  private Integer successThreshold;
  private Integer timeoutSeconds;

  public ReadinessProbeFluent() {
  }
  
  public ReadinessProbeFluent(ReadinessProbe instance) {
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
  
  public IsReadinessProbeHealthCheckMethod buildHealthCheckMethod() {
    return this.healthCheckMethod != null ? this.healthCheckMethod.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "ReadinessProbeExec":
    
          return (VisitableBuilder<T,?>) new ReadinessProbeExecBuilder((ReadinessProbeExec) item);
    
      case "ReadinessProbeGrpc":
    
          return (VisitableBuilder<T,?>) new ReadinessProbeGrpcBuilder((ReadinessProbeGrpc) item);
    
      case "ReadinessProbeHttpGet":
    
          return (VisitableBuilder<T,?>) new ReadinessProbeHttpGetBuilder((ReadinessProbeHttpGet) item);
    
      case "ReadinessProbeTcpSocket":
    
          return (VisitableBuilder<T,?>) new ReadinessProbeTcpSocketBuilder((ReadinessProbeTcpSocket) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(ReadinessProbe instance) {
    instance = instance != null ? instance : new ReadinessProbe();
    if (instance != null) {
        this.withHealthCheckMethod(instance.getHealthCheckMethod());
        this.withFailureThreshold(instance.getFailureThreshold());
        this.withInitialDelaySeconds(instance.getInitialDelaySeconds());
        this.withPeriodSeconds(instance.getPeriodSeconds());
        this.withSuccessThreshold(instance.getSuccessThreshold());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
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
    ReadinessProbeFluent that = (ReadinessProbeFluent) o;
    if (!(Objects.equals(healthCheckMethod, that.healthCheckMethod))) {
      return false;
    }
    if (!(Objects.equals(failureThreshold, that.failureThreshold))) {
      return false;
    }
    if (!(Objects.equals(initialDelaySeconds, that.initialDelaySeconds))) {
      return false;
    }
    if (!(Objects.equals(periodSeconds, that.periodSeconds))) {
      return false;
    }
    if (!(Objects.equals(successThreshold, that.successThreshold))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
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
  
  public Integer getFailureThreshold() {
    return this.failureThreshold;
  }
  
  public Integer getInitialDelaySeconds() {
    return this.initialDelaySeconds;
  }
  
  public Integer getPeriodSeconds() {
    return this.periodSeconds;
  }
  
  public Integer getSuccessThreshold() {
    return this.successThreshold;
  }
  
  public Integer getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailureThreshold() {
    return this.failureThreshold != null;
  }
  
  public boolean hasHealthCheckMethod() {
    return this.healthCheckMethod != null;
  }
  
  public boolean hasInitialDelaySeconds() {
    return this.initialDelaySeconds != null;
  }
  
  public boolean hasPeriodSeconds() {
    return this.periodSeconds != null;
  }
  
  public boolean hasSuccessThreshold() {
    return this.successThreshold != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(healthCheckMethod, failureThreshold, initialDelaySeconds, periodSeconds, successThreshold, timeoutSeconds, additionalProperties);
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
    if (!(healthCheckMethod == null)) {
        sb.append("healthCheckMethod:");
        sb.append(healthCheckMethod);
        sb.append(",");
    }
    if (!(failureThreshold == null)) {
        sb.append("failureThreshold:");
        sb.append(failureThreshold);
        sb.append(",");
    }
    if (!(initialDelaySeconds == null)) {
        sb.append("initialDelaySeconds:");
        sb.append(initialDelaySeconds);
        sb.append(",");
    }
    if (!(periodSeconds == null)) {
        sb.append("periodSeconds:");
        sb.append(periodSeconds);
        sb.append(",");
    }
    if (!(successThreshold == null)) {
        sb.append("successThreshold:");
        sb.append(successThreshold);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
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
  
  public A withFailureThreshold(Integer failureThreshold) {
    this.failureThreshold = failureThreshold;
    return (A) this;
  }
  
  public A withHealthCheckMethod(IsReadinessProbeHealthCheckMethod healthCheckMethod) {
    if (healthCheckMethod == null) {
        this.healthCheckMethod = null;
        this._visitables.remove("healthCheckMethod");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsReadinessProbeHealthCheckMethod,?> builder = builder(healthCheckMethod);
        this._visitables.get("healthCheckMethod").clear();
        this._visitables.get("healthCheckMethod").add(builder);
        this.healthCheckMethod = builder;
        return (A) this;
    }
  }
  
  public A withInitialDelaySeconds(Integer initialDelaySeconds) {
    this.initialDelaySeconds = initialDelaySeconds;
    return (A) this;
  }
  
  public ReadinessProbeExecHealthCheckMethodNested<A> withNewReadinessProbeExecHealthCheckMethod() {
    return new ReadinessProbeExecHealthCheckMethodNested(null);
  }
  
  public ReadinessProbeExecHealthCheckMethodNested<A> withNewReadinessProbeExecHealthCheckMethodLike(ReadinessProbeExec item) {
    return new ReadinessProbeExecHealthCheckMethodNested(item);
  }
  
  public ReadinessProbeGrpcHealthCheckMethodNested<A> withNewReadinessProbeGrpcHealthCheckMethod() {
    return new ReadinessProbeGrpcHealthCheckMethodNested(null);
  }
  
  public ReadinessProbeGrpcHealthCheckMethodNested<A> withNewReadinessProbeGrpcHealthCheckMethodLike(ReadinessProbeGrpc item) {
    return new ReadinessProbeGrpcHealthCheckMethodNested(item);
  }
  
  public ReadinessProbeHttpGetHealthCheckMethodNested<A> withNewReadinessProbeHttpGetHealthCheckMethod() {
    return new ReadinessProbeHttpGetHealthCheckMethodNested(null);
  }
  
  public ReadinessProbeHttpGetHealthCheckMethodNested<A> withNewReadinessProbeHttpGetHealthCheckMethodLike(ReadinessProbeHttpGet item) {
    return new ReadinessProbeHttpGetHealthCheckMethodNested(item);
  }
  
  public ReadinessProbeTcpSocketHealthCheckMethodNested<A> withNewReadinessProbeTcpSocketHealthCheckMethod() {
    return new ReadinessProbeTcpSocketHealthCheckMethodNested(null);
  }
  
  public ReadinessProbeTcpSocketHealthCheckMethodNested<A> withNewReadinessProbeTcpSocketHealthCheckMethodLike(ReadinessProbeTcpSocket item) {
    return new ReadinessProbeTcpSocketHealthCheckMethodNested(item);
  }
  
  public A withPeriodSeconds(Integer periodSeconds) {
    this.periodSeconds = periodSeconds;
    return (A) this;
  }
  
  public A withSuccessThreshold(Integer successThreshold) {
    this.successThreshold = successThreshold;
    return (A) this;
  }
  
  public A withTimeoutSeconds(Integer timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  public class ReadinessProbeExecHealthCheckMethodNested<N> extends ReadinessProbeExecFluent<ReadinessProbeExecHealthCheckMethodNested<N>> implements Nested<N>{
  
    ReadinessProbeExecBuilder builder;
  
    ReadinessProbeExecHealthCheckMethodNested(ReadinessProbeExec item) {
      this.builder = new ReadinessProbeExecBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeFluent.this.withHealthCheckMethod(builder.build());
    }
    
    public N endReadinessProbeExecHealthCheckMethod() {
      return and();
    }
    
  }
  public class ReadinessProbeGrpcHealthCheckMethodNested<N> extends ReadinessProbeGrpcFluent<ReadinessProbeGrpcHealthCheckMethodNested<N>> implements Nested<N>{
  
    ReadinessProbeGrpcBuilder builder;
  
    ReadinessProbeGrpcHealthCheckMethodNested(ReadinessProbeGrpc item) {
      this.builder = new ReadinessProbeGrpcBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeFluent.this.withHealthCheckMethod(builder.build());
    }
    
    public N endReadinessProbeGrpcHealthCheckMethod() {
      return and();
    }
    
  }
  public class ReadinessProbeHttpGetHealthCheckMethodNested<N> extends ReadinessProbeHttpGetFluent<ReadinessProbeHttpGetHealthCheckMethodNested<N>> implements Nested<N>{
  
    ReadinessProbeHttpGetBuilder builder;
  
    ReadinessProbeHttpGetHealthCheckMethodNested(ReadinessProbeHttpGet item) {
      this.builder = new ReadinessProbeHttpGetBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeFluent.this.withHealthCheckMethod(builder.build());
    }
    
    public N endReadinessProbeHttpGetHealthCheckMethod() {
      return and();
    }
    
  }
  public class ReadinessProbeTcpSocketHealthCheckMethodNested<N> extends ReadinessProbeTcpSocketFluent<ReadinessProbeTcpSocketHealthCheckMethodNested<N>> implements Nested<N>{
  
    ReadinessProbeTcpSocketBuilder builder;
  
    ReadinessProbeTcpSocketHealthCheckMethodNested(ReadinessProbeTcpSocket item) {
      this.builder = new ReadinessProbeTcpSocketBuilder(this, item);
    }
  
    public N and() {
      return (N) ReadinessProbeFluent.this.withHealthCheckMethod(builder.build());
    }
    
    public N endReadinessProbeTcpSocketHealthCheckMethod() {
      return and();
    }
    
  }
}